package controllers;

import entities.Evenement;
import entities.Fournisseur;
import entities.Tache;
import entities.Utilisateur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceEvenement;
import services.ServiceFournisseur;
import services.ServiceTache;
import services.ServiceUtilisateurEvenement;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ModifierTache {

    @FXML
    private TextField budgetField;

    @FXML
    private Slider budgetSlider;

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


    @FXML
    private DatePicker dateLimitePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private ComboBox<String> fournisseurComboBox;

    @FXML
    private TextField nomField;

    @FXML
    private ComboBox<String> prioriteComboBox;

    @FXML
    private ComboBox<String> statutComboBox;

    @FXML
    private ComboBox<String> userAssocieComboBox;

    @FXML
    private Label eventDescriptionLabel;

    @FXML
    private Label eventNameLabel;

    @FXML
    private Pane pane_event;

    @FXML
    private Button submitButton;

    private final ServiceTache serviceTache = new ServiceTache();
    private final ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
    private final ServiceEvenement serviceEvenement = new ServiceEvenement();

    private Tache selectedTask;
    private int currentEventId;

    /**
     * ✅ Initialize Event Data
     */
    public void initEventData(int eventId) {
        this.currentEventId = eventId;
        try {
            Evenement event = serviceEvenement.getEvenementById(eventId);
            if (event != null) {
                eventNameLabel.setText(event.getNom());
                eventDescriptionLabel.setText(event.getDescription());

                String imagePath = event.getImage_event();
                if (imagePath != null && !imagePath.isEmpty()) {
                    String encodedPath = imagePath.replace(" ", "%20");
                    pane_event.setStyle("-fx-background-image: url('" + encodedPath + "');"
                            + " -fx-background-size: cover;"
                            + " -fx-background-position: center center;");
                }
                populateUserAssocieComboBox();
                populateFournisseurComboBox();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void populateFournisseurComboBox() throws SQLException {
        ServiceFournisseur service = new ServiceFournisseur();
        List<Fournisseur> fournisseurs = service.afficherFournisseursParEventId(currentEventId);
        fournisseurComboBox.getItems().clear();
        for (Fournisseur fournisseur : fournisseurs) {
            fournisseurComboBox.getItems().add(fournisseur.getNom());
        }
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
    /**
     * ✅ Set Task Data in Form Fields
     */
    public void setTaskData(Tache task) {
        this.selectedTask = task;
        if (task == null) return;

        nomField.setText(task.getNom());
        descriptionField.setText(task.getDescription());
        budgetField.setText(String.valueOf(task.getBudget()));
        budgetSlider.setValue(task.getBudget());

        // Conversion de la date
        LocalDate localDate = dateLimitePicker.getValue();
        if (localDate != null) {
            task.setDateLimite(Date.valueOf(localDate));
        }
        prioriteComboBox.getItems().setAll("Basse", "Moyenne", "Haute");
        prioriteComboBox.setValue(task.getPriorite());

        statutComboBox.getItems().setAll("À faire", "En cours", "Terminée");
        statutComboBox.setValue(task.getStatut());

        userAssocieComboBox.getItems().setAll(task.getUserAssocie());
        userAssocieComboBox.setValue(task.getUserAssocie());

        try {
            List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
            for (Fournisseur f : fournisseurs) {
                fournisseurComboBox.getItems().add(f.getNom());
            }
            if (task.getFournisseur() != null) {
                fournisseurComboBox.setValue(task.getFournisseur().getNom());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ✅ Update Task and Save Changes
     */
    @FXML
    public void updateTask(ActionEvent event) {
        if (selectedTask == null) return;

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
            if (budgetField.getText().isEmpty() || !budgetField.getText().matches("\\d+(\\.\\d{1,2})?")) {
                showAlert("Erreur de validation", "Veuillez entrer un budget valide.");
                return;
            }

            // Mise à jour des valeurs de la tâche
            selectedTask.setNom(nomField.getText());
            selectedTask.setDescription(descriptionField.getText());
            selectedTask.setDateLimite(Date.valueOf(dateLimitePicker.getValue()));
            selectedTask.setPriorite(prioriteComboBox.getValue());
            selectedTask.setStatut(statutComboBox.getValue());
            selectedTask.setUserAssocie(userAssocieComboBox.getValue());
            selectedTask.setBudget(Float.parseFloat(budgetField.getText()));

            // Mise à jour du fournisseur
            int idF = serviceFournisseur.rechercherIdParNom(fournisseurComboBox.getValue());
            Fournisseur fournisseur = serviceFournisseur.rechercherParId(idF);
            selectedTask.setFournisseur(fournisseur);

            // Modifier la tâche
            serviceTache.modifier(selectedTask);
            System.out.println("✅ Tâche mise à jour avec succès !");

            // Redirection après modification
            goToEventTache(event);

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Erreur", "Une erreur est survenue lors de la mise à jour.");
        }
    }

    /**
     * ✅ Redirect to EventTache.fxml
     */
    @FXML
    private void goToEventTache(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
            EventTache controller = loader.getController();
            controller.initEventData(currentEventId);

            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ✅ Back Button to Previous Page
     */
    @FXML
    void RedirectBack(ActionEvent event) {
        goToEventTache(event);
    }

    /**
     * ✅ Show Alert Messages
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
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

    @FXML
    public void initialize() {
        // Synchronisation du Slider et du champ Budget
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
    }

}
