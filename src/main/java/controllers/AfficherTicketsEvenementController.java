package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
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
    private Label messageLabel;
    @FXML
    private TableColumn<Ticket, Void> actionsColumn;


    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceTicket serviceTicket = new ServiceTicket();


    @FXML
    public void initialize() {
        // Configurer les colonnes de la TableView
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        dateValiditeColumn.setCellValueFactory(new PropertyValueFactory<>("date_validite"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("nb_tickets"));
        setupActionsColumn();

        // Charger les événements dans la ComboBox
        try {
            List<Evenement> evenements = serviceEvenement.afficher();
            evenementComboBox.getItems().addAll(evenements);
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors du chargement des événements.");
            e.printStackTrace();
        }

        // Ajouter un écouteur pour mettre à jour les détails de l'événement sélectionné
        evenementComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // Afficher les détails de l'événement
                nomEvenementLabel.setText(newVal.getNom());
                lieuEvenementLabel.setText(newVal.getLieu());
                dateDebutEvenementLabel.setText(newVal.getDate_debut().toString());
                dateFinEvenementLabel.setText(newVal.getDate_fin().toString());

                // Charger les tickets associés à l'événement
                try {
                    List<Ticket> tickets = serviceTicket.getTicketsByEvenementId(newVal.getEvenement_id());
                    ticketsTable.getItems().clear();
                    ticketsTable.getItems().addAll(tickets);
                } catch (SQLException e) {
                    messageLabel.setText("Erreur lors du chargement des tickets.");
                    e.printStackTrace();
                }
            }
        });
    }
    @FXML
    private void ajouterTicket() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterTicketsEvenement.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajouter  Ticket");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("❌ Erreur lors de l'ouverture de l'interface d'ajout.");
        }
    }
    private void setupActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<Ticket, Void>() {
            private final Button modifyButton = new Button("Modifier");
            private final Button deleteButton = new Button("Supprimer");
            private final HBox actionButtons = new HBox(10, modifyButton, deleteButton);

            {
                modifyButton.setStyle("-fx-background-color: #FFC107; -fx-text-fill: black;");
                deleteButton.setStyle("-fx-background-color: #D32F2F; -fx-text-fill: white;");

                modifyButton.setOnAction(event -> {
                    Ticket ticket = getTableView().getItems().get(getIndex());
                    modifierTicket(ticket);
                });

                deleteButton.setOnAction(event -> {
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

    private void modifierTicket(Ticket ticket) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierTicket.fxml"));
            Parent root = loader.load();

            ModifierTicketsController controller = loader.getController();
            controller.setTicket(ticket);
            Stage stage = new Stage();
            stage.setTitle("Modifier un Ticket");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("❌ Erreur lors de l'ouverture de la modification.");
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