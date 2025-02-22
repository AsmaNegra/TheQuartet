package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import services.ServiceTicket;
import entities.Ticket;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.UnaryOperator;

public class ModifierTicketsController {

    @FXML
    private TextField typeField;

    @FXML
    private ComboBox<String> statutComboBox;

    @FXML
    private TextField prixField;

    @FXML
    private DatePicker dateValiditePicker;

    @FXML
    private TextField nbTicketsField;

    @FXML
    private Label messageLabel;

    private Ticket ticket;
    private final ServiceTicket serviceTicket = new ServiceTicket();
    private TableView<Ticket> tableViewTickets; // For live updates

    public void setTicket(Ticket ticket, TableView<Ticket> tableViewTickets) {
        this.ticket = ticket;
        this.tableViewTickets = tableViewTickets;

        // ✅ Ensure fields are correctly pre-filled with old values
        typeField.setText(ticket.getType() != null ? ticket.getType() : "");
        statutComboBox.setItems(FXCollections.observableArrayList("Disponible", "Épuisé"));
        statutComboBox.setValue(ticket.getStatut() != null ? ticket.getStatut() : "Disponible");
        prixField.setText(String.valueOf(ticket.getPrix()));
        nbTicketsField.setText(String.valueOf(ticket.getNb_tickets()));

        if (ticket.getDate_validite() != null) {
            dateValiditePicker.setValue(ticket.getDate_validite().toLocalDateTime().toLocalDate());
        } else {
            dateValiditePicker.setValue(LocalDate.now());
        }

        applyInputValidation();
    }

    private void applyInputValidation() {
        // Validate Price Input
        TextFormatter<Double> prixFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, createDoubleFilter());
        prixField.setTextFormatter(prixFormatter);

        // Validate Ticket Count
        TextFormatter<Integer> nbTicketsFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, createIntegerFilter());
        nbTicketsField.setTextFormatter(nbTicketsFormatter);

        // Disable Past Dates
        dateValiditePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffcccc;");
                }
            }
        });

        // Convert Date Format
        dateValiditePicker.setConverter(new StringConverter<>() {
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

        // Validate Date Selection
        dateValiditePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null && newDate.isBefore(LocalDate.now())) {
                messageLabel.setText("❌ La date de validité ne peut pas être dans le passé.");
            } else {
                messageLabel.setText("");
            }
        });
    }

    @FXML
    private void enregistrerModifications() {
        try {
            // Validate Empty Fields
            if (typeField.getText().isEmpty() || prixField.getText().isEmpty() ||
                    nbTicketsField.getText().isEmpty() || dateValiditePicker.getValue() == null ||
                    statutComboBox.getValue() == null) {
                messageLabel.setText("❌ Tous les champs doivent être remplis.");
                return;
            }

            // Validate Numeric Inputs
            double prix;
            int nbTickets;
            try {
                prix = Double.parseDouble(prixField.getText());
                nbTickets = Integer.parseInt(nbTicketsField.getText());
            } catch (NumberFormatException e) {
                messageLabel.setText("❌ Prix et Nombre de tickets doivent être des nombres valides.");
                return;
            }

            // Validate Date
            LocalDate dateValidite = dateValiditePicker.getValue();
            if (dateValidite.isBefore(LocalDate.now())) {
                messageLabel.setText("❌ La date de validité doit être après aujourd'hui.");
                return;
            }

            // Update Ticket Object
            ticket.setType(typeField.getText());
            ticket.setStatut(statutComboBox.getValue());
            ticket.setPrix(prix);
            ticket.setNb_tickets(nbTickets);
            ticket.setDate_validite(java.sql.Timestamp.valueOf(dateValidite.atStartOfDay()));

            // Update Database
            serviceTicket.modifier(ticket);

            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("✅ Modifications enregistrées avec succès.");

            // Refresh TableView
            tableViewTickets.refresh();

            // Close Window
            Stage stage = (Stage) messageLabel.getScene().getWindow();
            stage.close();

        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors de la mise à jour du ticket.");
            e.printStackTrace();
        }
    }

    // Create Numeric Filters
    private UnaryOperator<TextFormatter.Change> createDoubleFilter() {
        return change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*(\\.\\d*)?") ? change : null;
        };
    }

    private UnaryOperator<TextFormatter.Change> createIntegerFilter() {
        return change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null;
        };
    }
}
