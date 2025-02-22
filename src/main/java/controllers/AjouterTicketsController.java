package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import services.ServiceEvenement;
import services.ServiceTicket;
import entities.Ticket;
import entities.Evenement;
import javafx.scene.control.Alert.AlertType;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
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
        try {
            // Charger les événements
            List<Evenement> evenements = serviceEvenement.afficher();
            evenementComboBox.setItems(FXCollections.observableArrayList(evenements));

            // Configurer l'affichage du ComboBox
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

        } catch (SQLException e) {
            messageLabel.setText("Erreur lors du chargement des événements.");
            e.printStackTrace();
        }

        // Mise à jour des détails après sélection
        evenementComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                nomEvenementLabel.setText(newVal.getNom());
                lieuEvenementLabel.setText(newVal.getLieu());
                dateDebutEvenementLabel.setText(newVal.getDate_debut().toString());
                dateFinEvenementLabel.setText(newVal.getDate_fin().toString());
            }
        });

        // Contrôle de saisie pour le prix
        TextFormatter<Double> prixFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, createDoubleFilter());
        prixTextField.setTextFormatter(prixFormatter);

        // Contrôle de saisie pour le nombre de tickets
        TextFormatter<Integer> nbTicketsFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, createIntegerFilter());
        nbTicketsTextField.setTextFormatter(nbTicketsFormatter);

        // Désactiver les dates antérieures à aujourd'hui dans le DatePicker
        dateValiditePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffcccc;"); // Met en rouge les dates invalides
                }
            }
        });

        // Convertisseur de date
        dateValiditePicker.setConverter(new StringConverter<LocalDate>() {
            private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                return (date != null) ? date.format(formatter) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                try {
                    return LocalDate.parse(string, formatter);
                } catch (DateTimeParseException e) {
                    return null;
                }
            }
        });

        // Vérification de la date lors de la sélection
        dateValiditePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null && newDate.isBefore(LocalDate.now())) {
                messageLabel.setText("La date de validité ne peut pas être dans le passé.");
            } else {
                messageLabel.setText(""); // Efface le message d'erreur si la date est valide
            }
        });
    }



    @FXML
    private void ajouterTicket() {
        Evenement evenement = evenementComboBox.getSelectionModel().getSelectedItem();
        String type = typeTextField.getText();
        double prix;
        int nbTickets;
        LocalDate dateValidite = dateValiditePicker.getValue();

        // Vérification des valeurs numériques
        try {
            prix = Double.parseDouble(prixTextField.getText());
            nbTickets = Integer.parseInt(nbTicketsTextField.getText());
        } catch (NumberFormatException e) {
            messageLabel.setText("Veuillez entrer un prix et un nombre valides.");
            return;
        }

        // Vérification des champs
        if (evenement == null || type.isEmpty() || prix <= 0 || dateValidite == null || nbTickets <= 0) {
            messageLabel.setText("Veuillez remplir tous les champs correctement.");
            return;
        }

        // ✅ Vérification de `date_validite` (doit être après `date_fin`)
        if (dateValidite.isBefore(LocalDate.now())) {
            messageLabel.setText("La date de validité doit être après la date actuelle");
            return;
        }

        // ✅ Vérification d'un ticket identique existant
        try {
            if (serviceTicket.ticketExiste(evenement.getEvenement_id(), type)) {
                messageLabel.setText("Un ticket de ce type existe déjà pour cet événement.");
                return;
            }
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors de la vérification du ticket.");
            e.printStackTrace();
            return;
        }

        // Création du ticket
        Ticket ticket = new Ticket();
        ticket.setEvenement(evenement);
        ticket.setType(type);
        ticket.setPrix(prix);
        ticket.setDate_validite(java.sql.Timestamp.valueOf(dateValidite.atStartOfDay()));
        ticket.setNb_tickets(nbTickets);

        // Ajout en base de données
        try {

            serviceTicket.ajouter(ticket);
            messageLabel.setText("Ticket ajouté avec succès.");
            clearFields();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Le ticket a été ajouté avec succès !");
            alert.showAndWait();
            redirectToAfficherTickets();
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors de l'ajout du ticket.");
            e.printStackTrace();
        }
    }
    private void clearFields() {
        evenementComboBox.getSelectionModel().clearSelection(); // Réinitialiser la sélection de l'événement
        nomEvenementLabel.setText("");
        lieuEvenementLabel.setText("");
        dateDebutEvenementLabel.setText("");
        dateFinEvenementLabel.setText("");

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
    private void redirectToAfficherTickets() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AfficherTicketsEvenement.fxml"));
            Parent root = loader.load();

            // Récupérer la scène actuelle à partir d'un des nœuds de la fenêtre
            Stage stage = (Stage) messageLabel.getScene().getWindow(); // Remplace messageLabel par un autre composant si nécessaire
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}