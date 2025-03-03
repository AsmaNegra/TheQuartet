package controllers;

import entities.Transaction;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import services.ServiceEvenement;
import services.ServiceTicket;
import entities.Ticket;
import entities.Evenement;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.time.LocalDate;
import java.util.function.UnaryOperator;

public class AjouterTicketsController {
    //BOUTTON MENU//

    @FXML
    private Button btnSitemap;
    @FXML
    private Button btnGift;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnHome1;

    @FXML
    private AnchorPane sidebar;
    ////////////////
    @FXML private Button ajouterButton;
    @FXML private Label nomEvenementLabel;
    @FXML private Label lieuEvenementLabel;
    @FXML private Label dateDebutEvenementLabel;
    @FXML private Label dateFinEvenementLabel;
    @FXML private TextField typeTextField;
    @FXML private TextField prixTextField;
    @FXML private DatePicker dateValiditePicker;
    @FXML private TextField nbTicketsTextField;
    @FXML private Label messageLabel;
    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceTicket serviceTicket = new ServiceTicket();
    private Ticket ticket =new Ticket();
    private EventTache eventTacheController;
    private int currentEventId;
    private Evenement currentEvent;
    @FXML
    public void initialize() {
        if (currentEvent != null) {
            updateEventDetails();
        }
        TextFormatter<Double> prixFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, createDoubleFilter());
        prixTextField.setTextFormatter(prixFormatter);
        TextFormatter<Integer> nbTicketsFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, createIntegerFilter());
        nbTicketsTextField.setTextFormatter(nbTicketsFormatter);
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
        dateValiditePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null && newDate.isBefore(LocalDate.now())) {
                messageLabel.setText("La date de validité ne peut pas être dans le passé.");
            } else {
                messageLabel.setText("");
            }
        });
        if (ajouterButton == null) {
            System.out.println("❌ ERREUR: ajouterButton est null ! Vérifiez le fichier FXML.");
        } else {
            System.out.println("✅ ajouterButton est bien reconnu.");
        }
    }
    public void setEventTacheController(EventTache eventTacheController) {
        this.eventTacheController = eventTacheController;
    }
    @FXML
    public void initEventData(int eventId) {
        this.currentEventId = eventId;

        try {
            ServiceEvenement serviceEvenement = new ServiceEvenement();
            currentEvent = serviceEvenement.getEvenementById(eventId);

            if (currentEvent == null) {
                System.err.println("⚠ Erreur : Aucun événement trouvé avec l'ID " + eventId);
                return;
            }
            if (nomEvenementLabel != null) {
                updateEventDetails();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void ajouterTicket() {
        if (currentEvent == null) {
            messageLabel.setText("Erreur : Aucun événement sélectionné.");
            return;
        }
        System.out.println("Événement sélectionné : " + currentEvent); // Debugging
        String type = typeTextField.getText().trim();
        String statut = "Disponible";
        double prix;
        int nbTickets;
        LocalDate dateValidite = dateValiditePicker.getValue();
        try {
            prix = Double.parseDouble(prixTextField.getText().trim());
            nbTickets = Integer.parseInt(nbTicketsTextField.getText().trim());
        } catch (NumberFormatException e) {
            messageLabel.setText("Veuillez entrer un prix et un nombre de tickets valides.");
            return;
        }
        if (type.isEmpty() || prix <= 0 || dateValidite == null || nbTickets <= 0) {
            messageLabel.setText("Veuillez remplir tous les champs correctement.");
            return;
        }
        if (dateValidite.isBefore(LocalDate.now())) {
            messageLabel.setText("La date de validité doit être après la date actuelle.");
            return;
        }
        if (currentEvent.getDate_fin() != null && dateValidite.isBefore(LocalDate.now())) {
            messageLabel.setText("La date de validité doit être après la fin de l'événement.");
            return;
        }
        try {
            if (serviceTicket.ticketExiste(currentEvent.getEvenement_id(), type)) {
                messageLabel.setText("Un ticket de ce type existe déjà pour cet événement.");
                return;
            }
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors de la vérification du ticket.");
            e.printStackTrace();
            return;
        }
        Ticket ticket = new Ticket();
        ticket.setEvenement(currentEvent);
        System.out.println("Ticket lié à l'événement : " + ticket.getEvenement());
        ticket.setType(type);
        ticket.setPrix(prix);
        ticket.setDate_validite(java.sql.Timestamp.valueOf(dateValidite.atStartOfDay()));
        ticket.setNb_tickets(nbTickets);
        ticket.setStatut(statut);
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Ajout du ticket");
        confirmationAlert.setContentText("Êtes-vous sûr de vouloir ajouter ce ticket ?");

        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                ajouterTicketBD(ticket);
            }
        });
    }
    private void ajouterTicketBD(Ticket ticket) {
        try {
            serviceTicket.ajouter(ticket);
            if (eventTacheController != null) {
                eventTacheController.loadTickets();
            }
            Stage stage = (Stage) typeTextField.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            messageLabel.setText("Erreur lors de l'ajout du ticket.");
            messageLabel.setVisible(true);
            e.printStackTrace();
        }
    }
    private UnaryOperator<TextFormatter.Change> createDoubleFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        };
    }
    private UnaryOperator<TextFormatter.Change> createIntegerFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        };
    }
    private void updateEventDetails() {
        nomEvenementLabel.setText(currentEvent.getNom());
        lieuEvenementLabel.setText(currentEvent.getLieu());
        dateDebutEvenementLabel.setText(currentEvent.getDate_debut().toString());
        dateFinEvenementLabel.setText(currentEvent.getDate_fin().toString());
    }


    ////////////////////////////MENU///////////////////////////////////////////////////////////////////////
    @FXML
    void expandSidebar(MouseEvent event) {
        Timeline expandTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        expandTimeline.getKeyFrames().add(keyFrame);
        expandTimeline.play();
        btnSitemap.setText("Mes evenements");
        btnGift.setText("Admin");
        btnHome.setText("Tous les evenements");
        btnHome1.setText("My Account");
    }
    public void handleLogoutClick(ActionEvent event) {
        System.out.println("Déconnexion...");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    void collapseSidebar(MouseEvent event) {
        Timeline collapseTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 70);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        collapseTimeline.getKeyFrames().add(keyFrame);
        collapseTimeline.play();
        btnSitemap.setText("");
        btnGift.setText("");
        btnHome.setText("");
        btnHome1.setText("");
    }
    @FXML
    void handleGiftClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminFournisseur.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleHomeClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleSitemapClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventOrganisation.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////////////////////
}