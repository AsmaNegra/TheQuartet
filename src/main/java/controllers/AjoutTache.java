package controllers;

import entities.Tache;
import entities.Utilisateur;
import entities.Fournisseur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    //MENU ATTRIBUTS//
    @FXML
    public Button btnLogout;
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

    @FXML
    private Label labelUser;
    /////////////////
    @FXML
    private TextField budgetField;

    @FXML
    private Slider budgetSlider;

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
        // Liaison du slider et du champ texte
        budgetSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            budgetField.setText(String.format("%.0f", newVal.doubleValue()));
        });

        budgetField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                double value = Double.parseDouble(newVal);
                if (value >= budgetSlider.getMin() && value <= budgetSlider.getMax()) {
                    budgetSlider.setValue(value);
                }
            } catch (NumberFormatException ignored) {
            }
        });

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
            // Validation des champs
            if (nomField.getText().isEmpty()) {
                showAlert("Erreur de validation", "Le nom de la tâche est obligatoire.");
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
            if (budgetField.getText().isEmpty() || !budgetField.getText().matches("\\d+")) {
                showAlert("Erreur de validation", "Veuillez entrer un budget valide.");
                return;
            }

            // Vérification de l'unicité de la tâche
            ServiceTache st = new ServiceTache();
            Tache existingTask = st.chercherTacheParNom(nomField.getText());
            if (existingTask != null) {
                showAlert("Erreur de validation", "Une tâche avec ce nom existe déjà.");
                return;
            }

            // Création de la tâche
            Tache t = new Tache();
            Evenement ev = new Evenement();
            ev.setEvenement_id(currentEventId);
            Fournisseur f = new Fournisseur();
            f.setNom(fournisseurComboBox.getValue());
            ServiceFournisseur service = new ServiceFournisseur();
            f.setFournisseurId(service.rechercherIdParNom(fournisseurComboBox.getValue()));

            // Affectation des valeurs
            t.setNom(nomField.getText());
            t.setDescription(descriptionField.getText().isEmpty() ? null : descriptionField.getText());
            t.setPriorite(prioriteComboBox.getValue());
            t.setStatut(statutComboBox.getValue());
            t.setEvenement(ev);
            t.setFournisseur(f);
            t.setUserAssocie(userAssocieComboBox.getValue());
            t.setDateLimite(Date.valueOf(dateLimitePicker.getValue()));
            t.setBudget(Float.parseFloat(budgetField.getText()));

            // Ajout de la tâche
            st.ajouter(t);

            // Redirection après ajout
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


    //////////////////////MENU/////////////////////////////////
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
        btnLogout.setText("Logout");
        labelUser.setVisible(true);
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
        btnLogout.setText("");
        labelUser.setVisible(false);
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

            // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ref.fxml"));

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

    public void handleLogoutClick(ActionEvent event) {

    }
    //////////////////////////////////////////////////////////
}
