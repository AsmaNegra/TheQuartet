package controllers;

import entities.Ticket;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.ServiceTicket;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        typeField.setText(ticket.getType());
        statutComboBox.getItems().addAll("Disponible", "Épuisé");
        statutComboBox.setValue(ticket.getStatut());
        prixField.setText(String.valueOf(ticket.getPrix()));
        dateValiditePicker.setValue(ticket.getDate_validite().toLocalDateTime().toLocalDate());
        nbTicketsField.setText(String.valueOf(ticket.getNb_tickets()));
    }

    @FXML
    private void enregistrerModifications() {
        try {
            // Vérifier les valeurs saisies
            if (typeField.getText().isEmpty() || prixField.getText().isEmpty() ||
                    nbTicketsField.getText().isEmpty() || dateValiditePicker.getValue() == null ||
                    statutComboBox.getValue() == null) {
                messageLabel.setText("❌ Tous les champs doivent être remplis.");
                return;
            }

            // Mise à jour des informations du ticket
            ticket.setType(typeField.getText());
            ticket.setStatut(statutComboBox.getValue());
            ticket.setPrix(Double.parseDouble(prixField.getText()));
            ticket.setNb_tickets(Integer.parseInt(nbTicketsField.getText()));

            // Conversion de la date en Timestamp
            LocalDate localDate = dateValiditePicker.getValue();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            ticket.setDate_validite(new java.sql.Timestamp(date.getTime()));

            // Mise à jour en base de données
            serviceTicket.modifier(ticket);

            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("✅ Modifications enregistrées avec succès.");

            // Fermer la fenêtre après enregistrement
            Stage stage = (Stage) messageLabel.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            messageLabel.setText("❌ Prix et Nombre de tickets doivent être des nombres valides.");
        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors de la mise à jour du ticket.");
            e.printStackTrace();
        }
    }
}
