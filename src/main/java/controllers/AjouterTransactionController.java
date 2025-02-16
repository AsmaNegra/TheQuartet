package controllers;

import entities.Evenement;
import entities.Ticket;
import entities.Transaction;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceEvenement;
import services.ServiceTicket;

import java.sql.SQLException;
import java.util.List;

public class AjouterTransactionController {

    @FXML
    private Label nomEvenementLabel;

    @FXML
    private Label lieuEvenementLabel;

    @FXML
    private Label dateDebutLabel;

    @FXML
    private Label dateFinLabel;

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
    private TableColumn<Ticket, Integer> quantiteAcheterColumn;

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
    private Label montantTotalLabel;

    @FXML
    private Label messageLabel;

    private Evenement evenement;
    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceTicket serviceTicket = new ServiceTicket();

    private ObservableList<Ticket> ticketsDisponibles = FXCollections.observableArrayList();
    private ObservableList<Ticket> panier = FXCollections.observableArrayList();
    public void initialize() {
        // Configurer les colonnes de la table des tickets disponibles
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        dateValiditeColumn.setCellValueFactory(new PropertyValueFactory<>("date_validite"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("nb_tickets"));

        // Configurer les colonnes de la table du panier
        panierTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        panierPrixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        panierQuantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantiteAcheter"));


        // Charger les détails de l'événement et les tickets disponibles
        try {
            evenement = serviceEvenement.getEvenementById(3); // Remplacez par l'ID de l'événement
            nomEvenementLabel.setText(evenement.getNom());
            lieuEvenementLabel.setText(evenement.getLieu());
            dateDebutLabel.setText(evenement.getDate_debut().toString());
            dateFinLabel.setText(evenement.getDate_fin().toString());

            // Récupérer les tickets associés à l'événement
            List<Ticket> tickets = serviceTicket.getTicketsByEvenementId(evenement.getEvenement_id());
            ticketsDisponibles.addAll(tickets);
            ticketsTable.setItems(ticketsDisponibles);
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors du chargement des données.");
            e.printStackTrace();
        }
    }
    public void ajouterAuPanier(Ticket ticket) {
        panier.add(ticket);
        panierTable.setItems(panier);
        calculerMontantTotal();
    }
    private void calculerMontantTotal() {
        //double total = panier.stream().mapToDouble(t -> t.getPrix() * t.getQuantiteAcheter()).sum();
        //montantTotalLabel.setText(String.format("%.2f TND", total));
    }
    @FXML
    private void passerALaCaisse() {
        // Logique pour ajouter la transaction
    }
}