package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import services.ServiceEvenement;
import services.ServiceTicket;
import entities.Evenement;
import entities.Ticket;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class AfficherTicketsEvenementController {

    @FXML
    private ComboBox<Evenement> evenementComboBox;

    @FXML
    private Label nomEvenementLabel, lieuEvenementLabel, dateDebutEvenementLabel, dateFinEvenementLabel, messageLabel;

    @FXML
    private TableView<Ticket> ticketsTable;

    @FXML
    private TableColumn<Ticket, String> typeColumn, statutColumn, dateValiditeColumn;

    @FXML
    private TableColumn<Ticket, Double> prixColumn;

    @FXML
    private TableColumn<Ticket, Integer> quantiteColumn;

    @FXML
    private TableColumn<Ticket, Void> actionsColumn;

    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceTicket serviceTicket = new ServiceTicket();

    @FXML
    public void initialize() {
        // Configuration des colonnes de la TableView
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        dateValiditeColumn.setCellValueFactory(new PropertyValueFactory<>("date_validite"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("nb_tickets"));
        setupActionsColumn();


        // Charger les événements dans le ComboBox
        chargerEvenements();

        // Ajouter un écouteur pour mettre à jour les détails de l'événement sélectionné
        evenementComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                afficherDetailsEvenement(newVal);
                chargerTicketsEvenement(newVal.getEvenement_id());
            }
        });
    }

    /**
     * Charge les événements et configure l'affichage dans le ComboBox.
     */
    private void chargerEvenements() {
        try {
            List<Evenement> evenements = serviceEvenement.afficher();
            evenementComboBox.setItems(FXCollections.observableArrayList(evenements));

            evenementComboBox.setConverter(new StringConverter<>() {
                @Override
                public String toString(Evenement evenement) {
                    return (evenement == null) ? "" : "id : " + evenement.getEvenement_id() + " - nom : " + evenement.getNom();
                }

                @Override
                public Evenement fromString(String string) {
                    return null;
                }
            });

        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors du chargement des événements.");
            e.printStackTrace();
        }
    }

    /**
     * Met à jour l'affichage des détails de l'événement sélectionné.
     */
    private void afficherDetailsEvenement(Evenement evenement) {
        nomEvenementLabel.setText(evenement.getNom());
        lieuEvenementLabel.setText(evenement.getLieu());
        dateDebutEvenementLabel.setText(evenement.getDate_debut().toString());
        dateFinEvenementLabel.setText(evenement.getDate_fin().toString());
    }

    /**
     * Charge et affiche les tickets liés à un événement donné.
     */
    private void chargerTicketsEvenement(int evenementId) {
        try {
            List<Ticket> tickets = serviceTicket.getTicketsByEvenementId(evenementId);
            ticketsTable.getItems().setAll(tickets);
        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors du chargement des tickets.");
            e.printStackTrace();
        }
    }

    @FXML
    private void ajouterTicket() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterTickets.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajouter Ticket");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("❌ Erreur lors de l'ouverture de l'interface d'ajout.");
        }
    }

    private void setupActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<Ticket, Void>() {
            private final FontAwesomeIconView modifyIcon = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
            private final FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
            private final HBox actionButtons = new HBox(20, modifyIcon, deleteIcon);

            {
                modifyIcon.setStyle("-fx-cursor: hand; -fx-fill: #FFC107; -fx-font-size: 16px;");
                deleteIcon.setStyle("-fx-cursor: hand; -fx-fill: #D32F2F; -fx-font-size: 16px;");

                modifyIcon.setOnMouseClicked(event -> {
                    Ticket ticket = getTableView().getItems().get(getIndex());
                    modifierTicket(ticket);
                });

                deleteIcon.setOnMouseClicked(event -> {
                    Ticket ticket = getTableView().getItems().get(getIndex());
                    supprimerTicket(ticket);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(actionButtons);
                }
            }
        });
    }



    private void afficherMessageErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void modifierTicket(Ticket ticket) {
        Ticket selectedTicket = ticketsTable.getSelectionModel().getSelectedItem();

        if (selectedTicket == null) {
            afficherMessageErreur("Veuillez sélectionner un ticket à modifier.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierTicket.fxml"));
            Parent root = loader.load();

            // Get the controller
            ModifierTicketsController controller = loader.getController();

            // Pass selected ticket + tableView reference to update it later
            //   controller.setTicket(selectedTicket, ticketsTable);

            // Open modification window
            Stage stage = new Stage();
            stage.setTitle("Modifier Ticket");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            afficherMessageErreur("Erreur lors de l'ouverture de la fenêtre de modification.");
            e.printStackTrace();
        }
    }


    private void supprimerTicket(Ticket ticket) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Voulez-vous vraiment supprimer ce ticket ?");
        alert.setContentText("Cette action est irréversible.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                serviceTicket.supprimer(ticket.getId_ticket());
                ticketsTable.getItems().remove(ticket);
                messageLabel.setText("✅ Ticket supprimé avec succès.");
            } catch (SQLException e) {
                messageLabel.setText("❌ Erreur lors de la suppression du ticket.");
                e.printStackTrace();
            }
        }
    }
}