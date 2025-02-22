package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Evenement;
import entities.Ticket;
import entities.Transaction;
import entities.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import services.ServiceEvenement;
import services.ServiceTicket;
import services.ServiceTransaction;
import services.ServiceTransactionTicket;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AjouterTransactionController {

    @FXML
    private ComboBox<Evenement> evenementComboBox;

    @FXML
    private Label nomEvenementLabel;

    @FXML
    private Label lieuEvenementLabel;

    @FXML
    private Label dateDebutEvenementLabel;

    @FXML
    private Label dateFinEvenementLabel;

    @FXML
    private TableView<Ticket> ticketsTable;

    @FXML
    private TableColumn<Ticket, String> typeColumn;

    @FXML
    private TableColumn<Ticket, Double> prixColumn;

    @FXML
    private TableColumn<Ticket, String> statutColumn;

    @FXML
    private TableColumn<Ticket, String> dateValiditeColumn;

    @FXML
    private TableColumn<Ticket, Integer> quantiteColumn;

    @FXML
    private TableColumn<Ticket, Void> panierColumn;

    @FXML
    private TableView<Ticket> panierTable;

    @FXML
    private TableColumn<Ticket, String> panierTypeColumn;

    @FXML
    private TableColumn<Ticket, Double> panierPrixColumn;

    @FXML
    private TableColumn<Ticket, Integer> panierQuantiteColumn;

    @FXML
    private TableColumn<Ticket, Double> panierTotalColumn;
    @FXML
    private TableColumn<Ticket, Void> supprimerColumn;

    @FXML
    private Label montantTotalLabel;

    @FXML
    private Label messageLabel;

    private void setupSupprimerColumn() {
        supprimerColumn.setCellFactory(param -> new TableCell<Ticket, Void>() {
            private final FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);

            {
                deleteIcon.setStyle("-fx-fill: red; -fx-cursor: hand;");
                deleteIcon.setOnMouseClicked(event -> {
                    Ticket ticket = getTableView().getItems().get(getIndex());
                    supprimerTicketAvecConfirmation(ticket);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : new HBox(deleteIcon));
            }
        });
    }
    private void supprimerTicketAvecConfirmation(Ticket ticket) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation de suppression");
        confirmationAlert.setHeaderText("Voulez-vous vraiment supprimer ce ticket du panier ?");
        confirmationAlert.setContentText("Cette action mettra à jour votre transaction.");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            supprimerTicketDuPanier(ticket);
        }
    }
    private void supprimerTicketDuPanier(Ticket ticket) {
        try {
            Transaction transaction =new Transaction();
            if (transaction != null && transaction.getId_transaction() != 0) {
                // Supprimer uniquement si la transaction est confirmée dans la BD
                serviceTransactionTicket.supprimerTicketDeTransaction(transaction, ticket);
            } else {
                // Cas où le ticket est juste dans le panier et pas encore en BD
                panier.remove(ticket);
                panierTable.refresh();
                calculerMontantTotal();
                messageLabel.setText("✅ Ticket supprimé du panier.");
                return;
            }

            // Mise à jour du panier après suppression
            panier.remove(ticket);
            panierTable.refresh();
            calculerMontantTotal();
            messageLabel.setText("✅ Ticket supprimé avec succès.");
        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors de la suppression du ticket.");
            e.printStackTrace();
        }
    }

    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceTicket serviceTicket = new ServiceTicket();
    private ServiceTransaction serviceTransaction = new ServiceTransaction();
    private ServiceTransactionTicket serviceTransactionTicket = new ServiceTransactionTicket();


    private ObservableList<Ticket> ticketsDisponibles = FXCollections.observableArrayList();
    private ObservableList<Ticket> panier = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialisation des colonnes de la table des tickets
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        dateValiditeColumn.setCellValueFactory(new PropertyValueFactory<>("date_validite"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("nb_tickets"));

        setupPanierColumn();
        setupSupprimerColumn();

        // Initialisation des colonnes de la table du panier
        panierTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        panierPrixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        panierQuantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantiteAcheter"));
        panierTotalColumn.setCellValueFactory(cellData -> {
            Ticket ticket = cellData.getValue();
            return new javafx.beans.property.SimpleDoubleProperty(ticket.getPrix() * ticket.getQuantiteAcheter()).asObject();
        });

        // Charger la liste des événements dans le ComboBox
        loadEvenements();

        // Ajouter un listener pour mettre à jour les détails lorsqu'un événement est sélectionné
        evenementComboBox.setOnAction(event -> afficherDetailsEvenement());
    }

    private void loadEvenements() {
        List<Evenement> evenements = serviceEvenement.getAllEvenements();
        evenementComboBox.setItems(FXCollections.observableArrayList(evenements));
        evenementComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Evenement evenement) {
                return evenement == null ? "" : "id : " + evenement.getEvenement_id() + " - nom : " + evenement.getNom();
            }

            @Override
            public Evenement fromString(String string) {
                return null;
            }
        });

    }
    private void ajouterAuPanier(Ticket ticket) {
        // Vérifier si le ticket est "épuisé"
        if ("épuisé".equalsIgnoreCase(ticket.getStatut())) {
            messageLabel.setText("Ce ticket est épuisé et ne peut pas être ajouté au panier.");
            return;
        }

        Optional<Ticket> existingTicket = panier.stream()
                .filter(t -> t.getType().equals(ticket.getType()))
                .findFirst();

        if (existingTicket.isPresent()) {
            int nouvelleQuantite = existingTicket.get().getQuantiteAcheter() + 1;
            if (nouvelleQuantite > ticket.getNb_tickets()) {
                messageLabel.setText("❌ Quantité maximale atteinte pour ce type de ticket.");
                return;
            }
            existingTicket.get().setQuantiteAcheter(nouvelleQuantite);
        } else {
            if (ticket.getNb_tickets() > 0) {
                Ticket nouveauTicket = new Ticket(ticket);
                nouveauTicket.setQuantiteAcheter(1);
                panier.add(nouveauTicket);
            } else {
                messageLabel.setText("❌ Aucun ticket disponible pour ce type.");
                return;
            }
        }

        panierTable.setItems(panier);
        panierTable.refresh();
        calculerMontantTotal();
    }


    private void afficherDetailsEvenement() {
        Evenement evenement = evenementComboBox.getSelectionModel().getSelectedItem();
        if (evenement != null) {
            nomEvenementLabel.setText(evenement.getNom());
            lieuEvenementLabel.setText(evenement.getLieu());
            dateDebutEvenementLabel.setText(evenement.getDate_debut().toString());
            dateFinEvenementLabel.setText(evenement.getDate_fin().toString());

            // Charger les tickets associés à l'événement sélectionné
            loadTickets(evenement.getEvenement_id());
        }
    }

    private void loadTickets(int evenementId) {
        try {
            ticketsDisponibles.clear();
            List<Ticket> tickets = serviceTicket.getTicketsByEvenementId(evenementId);
            ticketsDisponibles.addAll(tickets);
            ticketsTable.setItems(ticketsDisponibles);
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors du chargement des tickets.");
            e.printStackTrace();
        }
    }

    private double calculerMontantTotal() {
        double total = panier.stream()
                .mapToDouble(t -> t.getPrix() * t.getQuantiteAcheter())
                .sum();
        montantTotalLabel.setText(String.format("%.2f TND", total));
        return total;
    }

    @FXML
    private void passerALaCaisse() {
        if (panier.isEmpty()) {
            messageLabel.setText("Votre panier est vide.");
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation de paiement");
        confirmationAlert.setHeaderText("Êtes-vous sûr de vouloir finaliser votre transaction ?");
        confirmationAlert.setContentText("Cette action est irréversible.");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setUtilisateurId(1);

                Transaction transaction = new Transaction();
                transaction.setUtilisateur_id(utilisateur);
                transaction.setTickets_associes(new ArrayList<>(panier));
                transaction.setMontant_total(calculerMontantTotal());
                transaction.setMode_paiement("Carte Bancaire");
                transaction.setDate_paiement(new Timestamp(System.currentTimeMillis()));

                serviceTransaction.ajouter(transaction);

                // Vider le panier après l'achat
                panier.clear();
                panierTable.refresh();
                messageLabel.setText("✅ Transaction réussie !");
                redirectToAfficherTransactions();
            } catch (SQLException e) {
                messageLabel.setText("❌ Erreur lors de la transaction.");
                e.printStackTrace();
            }
        }
    }

    private void setupPanierColumn() {
        panierColumn.setCellFactory(param -> new TableCell<Ticket, Void>() {
            private final Button addButton = new Button("Ajouter");

            {
                addButton.setOnAction(event -> {
                    Ticket ticket = getTableView().getItems().get(getIndex());
                    ajouterAuPanier(ticket);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : addButton);
            }
        });
    }
    private void redirectToAfficherTransactions() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AfficherTransactionUtilisateur.fxml"));            Parent root = loader.load();

            // Récupérer la scène actuelle à partir d'un des nœuds de la fenêtre
            Stage stage = (Stage) messageLabel.getScene().getWindow(); // Remplace messageLabel par un autre composant si nécessaire
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
