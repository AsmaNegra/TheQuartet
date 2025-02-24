package controllers;

import entities.Tache;
import entities.Utilisateur;
import entities.Fournisseur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceEvenement;
import services.ServiceTache;
import services.ServiceUtilisateurEvenement;
import services.ServiceFournisseur;
import entities.Evenement;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AjoutTache implements Initializable {

    @FXML
    private DatePicker dateLimitePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField nomField;

    @FXML
    private Button submitButton;

    @FXML
    private ComboBox<String> prioriteComboBox;

    @FXML
    private ComboBox<String> statutComboBox;

    @FXML
    private ComboBox<String> userAssocieComboBox;

    @FXML
    private ComboBox<String> fournisseurComboBox;

    @FXML
    private Label eventNameLabel;
    @FXML
    private Label eventDescriptionLabel;

    @FXML
    private Pane pane_event;

    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private final ServiceTache serviceTache = new ServiceTache();
    private int currentEventId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configuration du DatePicker
        dateLimitePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #EEEEEE;");
                }
            }
        });


    }

    private void populateUserAssocieComboBox() {
        ServiceUtilisateurEvenement service = new ServiceUtilisateurEvenement();
        List<Utilisateur> utilisateurs = service.getUtilisateursByEvenementIdNour(currentEventId);
        userAssocieComboBox.getItems().clear();
        for (Utilisateur user : utilisateurs) {
            userAssocieComboBox.getItems().add(user.getNom());
        }
        System.out.println("Nombre d'utilisateurs : " + utilisateurs.size());
    }

    private void populateFournisseurComboBox() throws SQLException {
        ServiceFournisseur service = new ServiceFournisseur();
        List<Fournisseur> fournisseurs = service.afficherFournisseursParEventId(currentEventId);
        fournisseurComboBox.getItems().clear();
        for (Fournisseur fournisseur : fournisseurs) {
            fournisseurComboBox.getItems().add(fournisseur.getNom());
        }
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        try {
            // Validation des champs obligatoires
            if (nomField.getText().isEmpty()) {
                showAlert("Erreur de validation", "Le nom de la tâche est obligatoire.");
                return;
            }
            if (nomField.getText().length() < 4) {
                showAlert("Erreur de validation", "Le nom de la tâche doit contenir au moins 4 caractères.");
                return;
            }
            if (dateLimitePicker.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner une date limite.");
                return;
            }
            if (prioriteComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner une priorité.");
                return;
            }
            if (statutComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner un statut.");
                return;
            }
            if (userAssocieComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner un utilisateur associé.");
                return;
            }

            // Vérification que la date limite n'est pas antérieure à aujourd'hui
            LocalDate selectedDate = dateLimitePicker.getValue();
            if (selectedDate.isBefore(LocalDate.now())) {
                showAlert("Erreur de validation", "La date limite ne peut pas être antérieure à aujourd'hui.");
                return;
            }

            // Vérification de l'unicité de la tâche par nom
            ServiceTache st = new ServiceTache();
            Tache existingTask = st.chercherTacheParNom(nomField.getText());
            if (existingTask != null) {
                showAlert("Erreur de validation", "Une tâche avec ce nom existe déjà.");
                return;
            }

            // Création d'un nouvel objet Tache
            Tache t = new Tache();
            Evenement ev = new Evenement();
            ev.setEvenement_id(currentEventId);
            Fournisseur f = new Fournisseur();
            f.setNom(fournisseurComboBox.getValue());
            ServiceFournisseur service = new ServiceFournisseur();
            f.setFournisseurId(service.rechercherIdParNom(fournisseurComboBox.getValue()));

            // Attribution des valeurs des champs
            t.setNom(nomField.getText());
            t.setDescription(descriptionField.getText().isEmpty() ? null : descriptionField.getText());
            t.setPriorite(prioriteComboBox.getValue());
            t.setStatut(statutComboBox.getValue());
            t.setEvenement(ev);
            t.setFournisseur(f);
            t.setUserAssocie(userAssocieComboBox.getValue());

            // Conversion de la date
            t.setDateLimite(Date.valueOf(selectedDate));

            // Sauvegarde de la tâche
            st.ajouter(t);

            try {
                Node source = (Node) event.getSource();
                Integer eventId = this.currentEventId;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
                Parent root = loader.load();
                EventTache ajoutTacheController = loader.getController();
                ajoutTacheController.initEventData(eventId);
                Scene scene = source.getScene();
                scene.setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAlert(String title, String message) {
        Dialog<ButtonType> errorDialog = new Dialog<>();
        errorDialog.setTitle(title);
        errorDialog.setHeaderText(null); // Remove default header for a clean look
        errorDialog.getDialogPane().getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        errorDialog.getDialogPane().getStyleClass().add("modern-error-dialog");

        Label messageLabel = new Label(message);
        messageLabel.getStyleClass().add("dialog-text");

        VBox content = new VBox(10);
        content.setAlignment(Pos.CENTER);
        content.getChildren().add(messageLabel);
        errorDialog.getDialogPane().setContent(content);

        ButtonType okButton = new ButtonType("✔ OK", ButtonBar.ButtonData.OK_DONE);
        errorDialog.getDialogPane().getButtonTypes().setAll(okButton);

        // Apply error-button style
        errorDialog.getDialogPane().lookupButton(okButton).getStyleClass().add("error-button");

        errorDialog.showAndWait();
    }


    @FXML
    void RedirectBack(ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Integer eventId = this.currentEventId;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
          EventTache ajoutTacheController = loader.getController();
            ajoutTacheController.initEventData(eventId);
            Scene scene = source.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cette méthode est appelée depuis l'autre écran pour initialiser les données de l'événement
    public void initEventData(int eventId) {
        this.currentEventId = eventId;
        try {
            // Charger les détails de l'événement
            Evenement event = serviceEvenement.getEvenementById(eventId);
            if (event != null) {
                eventNameLabel.setText(event.getNom());
                eventDescriptionLabel.setText(event.getDescription());
                String imagePath = event.getImage_event();
                if (imagePath != null && !imagePath.isEmpty()) {
                    // Encoder les espaces dans le chemin
                    String encodedPath = imagePath.replace(" ", "%20");
                    pane_event.setStyle("-fx-background-image: url('" + encodedPath + "');"
                            + " -fx-background-size: cover;"
                            + " -fx-background-position: center center;");
                }
            }
            // Appel de la méthode de peuplement une fois que currentEventId est défini
            populateUserAssocieComboBox();
            populateFournisseurComboBox();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
