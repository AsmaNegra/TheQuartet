package controllers;

import entities.Ticket;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceTicket;
import java.sql.SQLException;
import java.util.List;

public class AfficherTousTicketsController {

    @FXML private TableView<Ticket> ticketsTable;
    @FXML private TableColumn<Ticket, String> typeColumn;
    @FXML private TableColumn<Ticket, Double> prixColumn;
    @FXML private TableColumn<Ticket, String> statutColumn;
    @FXML private TableColumn<Ticket, String> dateValiditeColumn;
    @FXML private TableColumn<Ticket, Integer> quantiteColumn;
    @FXML private TableColumn<Ticket, Void> actionsColumn;

    private final ServiceTicket serviceTicket = new ServiceTicket();

    @FXML
    public void initialize() {
        // Associer les colonnes aux attributs de l'entité Ticket
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        dateValiditeColumn.setCellValueFactory(new PropertyValueFactory<>("date_validite"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("nb_tickets"));
        chargerTickets();
    }

    private void chargerTickets() {
        try {
            List<Ticket> tickets = serviceTicket.afficher();
            ticketsTable.getItems().setAll(tickets);
        } catch (SQLException e) {
            afficherErreur("Erreur lors du chargement des tickets", e.getMessage());
        }
    }

    private void afficherErreur(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
