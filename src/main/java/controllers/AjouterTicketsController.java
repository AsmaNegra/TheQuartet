package controllers;

import entities.Evenement;
import entities.Ticket;
import services.ServiceEvenement;
import services.ServiceTicket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class AjouterTicketsController {

    @FXML
    private ComboBox<Evenement> evenementComboBox;

    @FXML
    private TextField typeField;

    @FXML
    private TextField prixField;

    @FXML
    private DatePicker dateValiditePicker;

    @FXML
    private TextField nbTicketsField;

    @FXML
    private Button ajouterButton;

    @FXML
    private Label messageLabel;

    private ServiceTicket serviceTicket;
    private ServiceEvenement serviceEvenement;

    public AjouterTicketsController() {
        serviceTicket = new ServiceTicket();
        serviceEvenement = new ServiceEvenement();
    }

    @FXML
    public void initialize() {
        chargerEvenements();
    }

    private void chargerEvenements() {
        List<Evenement> evenements = serviceEvenement.getAllEvenements();
        ObservableList<Evenement> evenementList = FXCollections.observableArrayList(evenements);
        evenementComboBox.setItems(evenementList);
    }

    @FXML
    private void ajouterTicket(ActionEvent event) {
        Evenement evenement = evenementComboBox.getValue();
        String type = typeField.getText();
        String prixText = prixField.getText();
        String nbTicketsText = nbTicketsField.getText();

        if (evenement == null || type.isEmpty() || prixText.isEmpty() || nbTicketsText.isEmpty() || dateValiditePicker.getValue() == null) {
            messageLabel.setText("Veuillez remplir tous les champs.");
            return;
        }

        try {
            double prix = Double.parseDouble(prixText);
            int nbTickets = Integer.parseInt(nbTicketsText);
            Timestamp dateValidite = Timestamp.valueOf(dateValiditePicker.getValue().atStartOfDay());

            Ticket ticket = new Ticket(evenement, type, "En attente", prix, dateValidite, nbTickets);
            serviceTicket.ajouter(ticket);
            messageLabel.setText("Ticket ajouté avec succès !");
        } catch (NumberFormatException e) {
            messageLabel.setText("Prix et nombre de tickets doivent être des valeurs numériques.");
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Erreur lors de l'ajout du ticket.");
        }
    }
}
