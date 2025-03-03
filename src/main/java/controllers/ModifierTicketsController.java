package controllers;

import entities.Evenement;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import services.ServiceTicket;
import entities.Ticket;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.UnaryOperator;

public class ModifierTicketsController {

    //BOUTTON MENU//
    @FXML private Button btnSitemap;
    @FXML private Button btnGift;
    @FXML private Button btnHome;
    @FXML private Button btnHome1;
    @FXML private AnchorPane sidebar;
    ////////////////
    @FXML private TextField typeTextField;
    @FXML private Button confirmerButton;
    @FXML private ComboBox<String> statutComboBox;
    @FXML private TextField prixTextField;
    @FXML private DatePicker dateValiditePicker;
    @FXML private TextField nbTicketsTextField;
    @FXML private Label messageLabel;
    @FXML private Label nomEvenementLabel;
    @FXML private Label lieuEvenementLabel;
    @FXML private Label dateDebutEvenementLabel;
    @FXML private Label dateFinEvenementLabel;

    private Ticket ticket;
    private EventTache eventTacheController;
    private Evenement currentEvent;

    private final ServiceTicket serviceTicket = new ServiceTicket();
    private void updateEventDetails() {
        nomEvenementLabel.setText(currentEvent.getNom());
        lieuEvenementLabel.setText(currentEvent.getLieu());
        dateDebutEvenementLabel.setText(currentEvent.getDate_debut().toString());
        dateFinEvenementLabel.setText(currentEvent.getDate_fin().toString());
    }
    @FXML
    public void initialize() {
        if (currentEvent != null) {
            updateEventDetails();
        }

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
        if (confirmerButton == null) {
            System.out.println("❌ ERREUR: ajouterButton est null ! Vérifiez le fichier FXML.");
        } else {
            System.out.println("✅ ajouterButton est bien reconnu.");
        }
    }
    public void setTicket(Ticket ticket, EventTache eventTacheController) {
        this.ticket = ticket;
        this.eventTacheController = eventTacheController;

        if (statutComboBox != null) {
            statutComboBox.setItems(FXCollections.observableArrayList("Disponible", "Épuisé"));
            statutComboBox.setValue(ticket.getStatut());
        } else {
            System.out.println("⚠ statutComboBox est NULL !");
        }

        typeTextField.setText(ticket.getType());
        prixTextField.setText(String.valueOf(ticket.getPrix()));
        nbTicketsTextField.setText(String.valueOf(ticket.getNb_tickets()));

        if (ticket.getDate_validite() != null) {
            dateValiditePicker.setValue(ticket.getDate_validite().toLocalDateTime().toLocalDate());
        }

        // Vérifie aussi que l'événement n'est pas null avant d'y accéder


        applyInputValidation();
    }
    @FXML
    private void modifierTicket() {
        if (ticket == null) {
            messageLabel.setText("Erreur : Aucun ticket sélectionné.");
            messageLabel.setVisible(true);
            return;
        }
        String type = typeTextField.getText().trim();
        String statut = statutComboBox.getValue();
        String prixText = prixTextField.getText().trim();
        String nbTicketsText = nbTicketsTextField.getText().trim();
        LocalDate dateValidite = dateValiditePicker.getValue();
        if (type.isEmpty() || statut == null || prixText.isEmpty() || nbTicketsText.isEmpty() || dateValidite == null) {
            messageLabel.setText("Veuillez remplir tous les champs.");
            messageLabel.setVisible(true);
            return;
        }
        double prix;
        int nbTickets;
        try {
            prix = Double.parseDouble(prixText);
            nbTickets = Integer.parseInt(nbTicketsText);
        } catch (NumberFormatException e) {
            messageLabel.setText("Prix et nombre de tickets doivent être des valeurs numériques.");
            messageLabel.setVisible(true);
            return;
        }
        if (prix <= 0 || nbTickets <= 0) {
            messageLabel.setText("Le prix et le nombre de tickets doivent être supérieurs à 0.");
            messageLabel.setVisible(true);
            return;
        }
        if (dateValidite.isBefore(LocalDate.now())) {
            messageLabel.setText("La date de validité ne peut pas être dans le passé.");
            messageLabel.setVisible(true);
            return;
        }
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Modification du ticket");
        confirmationAlert.setContentText("Êtes-vous sûr de vouloir modifier ce ticket ?");

        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                appliquerModification(prix, nbTickets, type, statut, dateValidite);
            }
        });
    }
    private void appliquerModification(double prix, int nbTickets, String type, String statut, LocalDate dateValidite) {
        try {
            // Mise à jour du ticket
            ticket.setType(type);
            ticket.setStatut(statut);
            ticket.setPrix(prix);
            ticket.setDate_validite(java.sql.Timestamp.valueOf(dateValidite.atStartOfDay()));
            ticket.setNb_tickets(nbTickets);
            serviceTicket.modifier(ticket);
            if (eventTacheController != null) {
                eventTacheController.loadTickets();
            }
            Stage stage = (Stage) typeTextField.getScene().getWindow();
            stage.close();

        } catch (SQLException e) {
            messageLabel.setText("Erreur lors de la modification du ticket.");
            messageLabel.setVisible(true);
            e.printStackTrace();
        }
    }
    private void applyInputValidation() {
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
                    setStyle("-fx-background-color: #ffcccc;");
                }
            }
        });
    }

    private UnaryOperator<TextFormatter.Change> createDoubleFilter() {
        return change -> change.getControlNewText().matches("\\d*(\\.\\d*)?") ? change : null;
    }

    private UnaryOperator<TextFormatter.Change> createIntegerFilter() {
        return change -> change.getControlNewText().matches("\\d*") ? change : null;
    }
    ////////////////////////////MENU///////////////////////////////////////////////////////////////////////
    @FXML
    void expandSidebar(MouseEvent event) {
        // Animate sidebar expansion (e.g., from 70 to 200 pixels)
        Timeline expandTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        expandTimeline.getKeyFrames().add(keyFrame);
        expandTimeline.play();

        // Set the text for each button
        btnSitemap.setText("Mes evenements");
        btnGift.setText("Admin");
        btnHome.setText("Tous les evenements");
        btnHome1.setText("My Account");
    }
    @FXML
    void collapseSidebar(MouseEvent event) {
        // Animate sidebar collapse (e.g., back to 70 pixels)
        Timeline collapseTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 70);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        collapseTimeline.getKeyFrames().add(keyFrame);
        collapseTimeline.play();

        // Clear the text for each button
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
    @FXML
    private void handleLogoutClick(ActionEvent event) {
        System.out.println("Déconnexion...");
        // Fermer la fenêtre actuelle
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    //////////////////////////////////////////////////////////////////////////

}
