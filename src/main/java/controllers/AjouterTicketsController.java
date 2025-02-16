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

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class AjouterTicketsController {

    @FXML
    private ComboBox<Evenement> evenementComboBox;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField prixTextField;

    @FXML
    private DatePicker dateValiditePicker;

    @FXML
    private TextField nbTicketsTextField;

    @FXML
    private Button ajouterButton;

    @FXML
    private Label messageLabel;
    @FXML
    private Label nomEvenementLabel;
    @FXML
    private Label lieuEvenementLabel;
    @FXML
    private Label dateDebutEvenementLabel;
    @FXML
    private Label dateFinEvenementLabel;

    @FXML
    public void initialize() {
        chargerEvenements();
        evenementComboBox.setOnAction(event -> afficherDetailsEvenement());
    }

    private ServiceTicket serviceTicket;
    private ServiceEvenement serviceEvenement;

    public AjouterTicketsController() {
        serviceTicket = new ServiceTicket();
        serviceEvenement = new ServiceEvenement();
    }
    private void afficherDetailsEvenement() {
        Evenement evenement = evenementComboBox.getValue();
        if (evenement != null) {
            nomEvenementLabel.setText(evenement.getNom());
            lieuEvenementLabel.setText(evenement.getLieu());
            dateDebutEvenementLabel.setText(evenement.getDate_debut().toString());
            dateFinEvenementLabel.setText(evenement.getDate_fin().toString());
        }
    }

    private void chargerEvenements() {
        List<Evenement> evenements = serviceEvenement.getAllEvenements();
        ObservableList<Evenement> evenementList = FXCollections.observableArrayList(evenements);
        evenementComboBox.setItems(evenementList);
    }

    @FXML
    private void ajouterTicket(ActionEvent event) {
        Evenement evenement = evenementComboBox.getValue();
        String typeText = typeTextField.getText();
        String prixText = prixTextField.getText();
        String nbTicketsText = nbTicketsTextField.getText();

        if (evenement == null || typeText.isEmpty() || prixText.isEmpty() || nbTicketsText.isEmpty() || dateValiditePicker.getValue() == null) {
            messageLabel.setText("Veuillez remplir tous les champs.");
            return;
        }

        try {
            String type = typeText;
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
