package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Evenement;
import entities.Ticket;
import entities.Transaction;
import entities.Utilisateur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    // Menu
    @FXML private Button btnSitemap, btnGift, btnHome, btnHome1,btnRetour;
    @FXML private AnchorPane sidebar;
    // Détails de l'événement
    @FXML private Label eventNameLabel, eventLocationLabel, eventDateDebLabel, eventDateFinLabel;
    // Table des tickets disponibles
    @FXML private TableView<Ticket> ticketsTable;
    @FXML private TableColumn<Ticket, String> typeColumn, statutColumn;
    @FXML private TableColumn<Ticket, Double> prixColumn;
    @FXML private TableColumn<Ticket, String> dateValiditeColumn;
    @FXML private TableColumn<Ticket, Integer> quantiteColumn;
    @FXML private TableColumn<Ticket, Void> panierColumn;
    // Table du panier
    @FXML private TableView<Ticket> panierTable;
    @FXML private TableColumn<Ticket, String> panierTypeColumn;
    @FXML private TableColumn<Ticket, Double> panierPrixColumn;
    @FXML private TableColumn<Ticket, Integer> panierQuantiteColumn;
    @FXML private TableColumn<Ticket, Double> panierTotalColumn;
    @FXML private TableColumn<Ticket, Void> supprimerColumn;
    @FXML private Button passerCaisseButton;
    @FXML private Label montantTotalLabel, messageLabel;

    private Utilisateur utilisateurConnecte;
    private Evenement currentEvenement;
    private final ServiceTicket serviceTicket = new ServiceTicket();
    private final ServiceTransaction serviceTransaction = new ServiceTransaction();
    public void setUtilisateurConnecte(Utilisateur utilisateur) {
        this.utilisateurConnecte = utilisateur;
    }
    private final ObservableList<Ticket> panier = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        // Initialisation des colonnes
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        dateValiditeColumn.setCellValueFactory(new PropertyValueFactory<>("date_validite"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("nb_tickets"));

        setupPanierColumn();
        setupSupprimerColumn();

        panierTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        panierPrixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        panierQuantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantiteAcheter"));
        panierTotalColumn.setCellValueFactory(cellData -> {
            Ticket ticket = cellData.getValue();
            return new javafx.beans.property.SimpleDoubleProperty(ticket.getPrix() * ticket.getQuantiteAcheter()).asObject();
        });
    }
    @FXML
    private void retournerEnArriere() {
        try {
            // Charger le fichier FXML de l'interface précédente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle et remplacer son contenu
            Stage stage = (Stage) btnRetour.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ ERREUR : Impossible de charger ViewAllEvents.fxml !");
        }
    }


    public void setCurrentEvenement(Evenement event) {
        this.currentEvenement = event;
        updateUI();
    }
    public void updateUI() {
        if (currentEvenement != null) {
            eventNameLabel.setText(currentEvenement.getNom());
            eventLocationLabel.setText("Lieu: " + currentEvenement.getLieu());
            eventDateDebLabel.setText("Date Début: " + currentEvenement.getDate_debut().toString());
            eventDateFinLabel.setText("Date Fin: " + currentEvenement.getDate_fin().toString());
            loadTickets();
        }
    }
    private void loadTickets() {
        try {
            List<Ticket> tickets = serviceTicket.getTicketsByEvenementId(currentEvenement.getEvenement_id());
            ticketsTable.setItems(FXCollections.observableArrayList(tickets));
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des tickets.");
            e.printStackTrace();
        }
    }
    private void ajouterAuPanier(Ticket ticket) {
        if ("épuisé".equalsIgnoreCase(ticket.getStatut())) {
            messageLabel.setText("❌ Ce ticket est épuisé et ne peut pas être ajouté.");
            return;
        }

        // Vérifier si un ticket est déjà dans le panier
        if (!panier.isEmpty()) {
            messageLabel.setText("❌ Vous ne pouvez ajouter qu'un seul ticket à la fois.");
            return;
        }

        if (ticket.getNb_tickets() > 0) {
            Ticket nouveauTicket = new Ticket(ticket);
            nouveauTicket.setQuantiteAcheter(1);
            panier.add(nouveauTicket);
        } else {
            messageLabel.setText("❌ Aucun ticket disponible.");
            return;
        }

        panierTable.setItems(panier);
        panierTable.refresh();
        calculerMontantTotal();
    }
    private void setupPanierColumn() {
        panierColumn.setCellFactory(param -> new TableCell<Ticket, Void>() {
            private final FontAwesomeIconView addIcon = new FontAwesomeIconView(FontAwesomeIcon.PLUS_CIRCLE);
            {
                addIcon.setStyle("-fx-fill: green; -fx-cursor: hand; -fx-font-size: 20px;");
                addIcon.setOnMouseClicked(event -> ajouterAuPanier(getTableView().getItems().get(getIndex())));
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : addIcon);
            }
        });
    }

    private void setupSupprimerColumn() {
        supprimerColumn.setCellFactory(param -> new TableCell<Ticket, Void>() {
            private final FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
            {
                deleteIcon.setStyle("-fx-fill: red; -fx-cursor: hand; -fx-font-size: 20px;");
                deleteIcon.setOnMouseClicked(event -> supprimerTicketDuPanier(getTableView().getItems().get(getIndex())));
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : deleteIcon);
            }
        });
    }
    private void supprimerTicketDuPanier(Ticket ticket) {
        panier.remove(ticket);
        panierTable.refresh();
        calculerMontantTotal();
    }
    private double calculerMontantTotal() {
        double total = panier.stream().mapToDouble(t -> t.getPrix() * t.getQuantiteAcheter()).sum();
        montantTotalLabel.setText(String.format("%.2f TND", total));
        return total;
    }

    @FXML
    private void passerALaCaisse() {
        if (panier.isEmpty()) {
            messageLabel.setText("❌ Votre panier est vide.");
            return;
        }
        if (panier.size() > 1) {
            messageLabel.setText("❌ Vous ne pouvez acheter qu'un seul ticket par transaction.");
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation de paiement");
        confirmationAlert.setHeaderText("Êtes-vous sûr de vouloir finaliser votre transaction ?");
        confirmationAlert.setContentText("Cette action est irréversible.");
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                Transaction transaction = new Transaction();
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setUtilisateurId(5);
                transaction.setUtilisateur_id(utilisateur);

                // Ajouter uniquement un ticket
                transaction.setTicket(panier.get(0));
                transaction.setMontant_total(calculerMontantTotal());
                transaction.setMode_paiement("Carte Bancaire");
                transaction.setDate_paiement(new Timestamp(System.currentTimeMillis()));

                serviceTransaction.ajouter(transaction);
                panier.clear();
                panierTable.refresh();
                messageLabel.setText("✅ Transaction enregistrée avec succès !");
                ouvrirFenetrePaiement(transaction);

            } catch (SQLException e) {
                messageLabel.setText("❌ Erreur lors de la transaction.");
                e.printStackTrace();
            }
        }
    }
    private void ouvrirFenetrePaiement(Transaction transaction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/paiement.fxml"));
            Parent root = loader.load();
            PaiementController paiementController = loader.getController();
            paiementController.setTransactionDetails(transaction);
            Stage stage = new Stage();
            stage.setTitle("Paiement - Stripe");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ ERREUR : Le fichier paiement.fxml est introuvable !");
        }
    }

    ////////////////////////////MENU///////////////////////////////////////////////////////////////////////
    @FXML
    void expandSidebar(MouseEvent event) {
        Timeline expandTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        expandTimeline.getKeyFrames().add(keyFrame);
        expandTimeline.play();
        btnSitemap.setText("Mes evenements");
        btnGift.setText("Admin");
        btnHome.setText("Tous les evenements");
        btnHome1.setText("My Account");
    }
    public void handleLogoutClick(ActionEvent event) {
        System.out.println("Déconnexion...");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void collapseSidebar(MouseEvent event) {
        Timeline collapseTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 70);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        collapseTimeline.getKeyFrames().add(keyFrame);
        collapseTimeline.play();
        btnSitemap.setText("");
        btnGift.setText("");
        btnHome.setText("");
        btnHome1.setText("");
    }
    @FXML
    void handleGiftClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminFournisseur.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleHomeClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleSitemapClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventOrganisation.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////////////////////
}
