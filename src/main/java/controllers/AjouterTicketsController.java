package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import services.ServiceEvenement;
import services.ServiceTicket;
import entities.Ticket;
import entities.Evenement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.function.UnaryOperator;

public class AjouterTicketsController {

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
    private TextField typeTextField;

    @FXML
    private TextField prixTextField;

    @FXML
    private DatePicker dateValiditePicker;

    @FXML
    private TextField nbTicketsTextField;

    @FXML
    private Label messageLabel;

    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceTicket serviceTicket = new ServiceTicket();

    @FXML
    public void initialize() {
        // Charger les événements dans la ComboBox
        try {
            evenementComboBox.getItems().addAll(serviceEvenement.afficher());
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors du chargement des événements.");
            e.printStackTrace();
        }

        // Ajouter un écouteur pour mettre à jour les détails de l'événement sélectionné
        evenementComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                nomEvenementLabel.setText(newVal.getNom());
                lieuEvenementLabel.setText(newVal.getLieu());
                dateDebutEvenementLabel.setText(newVal.getDate_debut().toString());
                dateFinEvenementLabel.setText(newVal.getDate_fin().toString());
            }
        });

        // Contrôle de saisie pour le prix (Double)
        TextFormatter<Double> prixFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, createDoubleFilter());
        prixTextField.setTextFormatter(prixFormatter);

        // Contrôle de saisie pour le nombre de tickets (int)
        TextFormatter<Integer> nbTicketsFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, createIntegerFilter());
        nbTicketsTextField.setTextFormatter(nbTicketsFormatter);
    }

    @FXML
    private void ajouterTicket() {
        // Récupérer les valeurs des champs
        Evenement evenement = evenementComboBox.getSelectionModel().getSelectedItem();
        String type = typeTextField.getText();
        double prix = Double.parseDouble(prixTextField.getText());
        LocalDate dateValidite = dateValiditePicker.getValue();
        int nbTickets = Integer.parseInt(nbTicketsTextField.getText());

        // Validation des champs
        if (evenement == null || type.isEmpty() || prix <= 0 || dateValidite == null || nbTickets <= 0) {
            messageLabel.setText("Veuillez remplir tous les champs correctement.");
            return;
        }

        // Créer un nouveau ticket
        Ticket ticket = new Ticket();
        ticket.setEvenement(evenement);
        ticket.setType(type);
        ticket.setPrix(prix);
        ticket.setDate_validite(java.sql.Timestamp.valueOf(dateValidite.atStartOfDay()));
        ticket.setNb_tickets(nbTickets);

        // Ajouter le ticket à la base de données
        try {
            serviceTicket.ajouter(ticket);
            messageLabel.setText("Ticket ajouté avec succès.");
            clearFields();
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors de l'ajout du ticket.");
            e.printStackTrace();
        }
    }

    private void clearFields() {
        typeTextField.clear();
        prixTextField.clear();
        dateValiditePicker.setValue(null);
        nbTicketsTextField.clear();
    }

    // Créer un filtre pour les entrées de type double
    private UnaryOperator<TextFormatter.Change> createDoubleFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        };
    }

    // Créer un filtre pour les entrées de type int
    private UnaryOperator<TextFormatter.Change> createIntegerFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };
    }
}