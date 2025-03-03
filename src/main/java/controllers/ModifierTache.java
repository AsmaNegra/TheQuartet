package controllers;

import entities.Evenement;
import entities.Fournisseur;
import entities.Tache;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.ServiceEvenement;
import services.ServiceFournisseur;
import services.ServiceTache;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ModifierTache {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ✅ Set Task Data in Form Fields
     */
    public void setTaskData(Tache task) {
        this.selectedTask = task;
        if (task == null) return;

        nomField.setText(task.getNom());
        descriptionField.setText(task.getDescription());

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
            int idF = serviceFournisseur.rechercherIdParNom(fournisseurComboBox.getValue());
            Fournisseur fournisseur = serviceFournisseur.rechercherParId(idF);

            LocalDate localDate = dateLimitePicker.getValue();
            if (localDate == null) {
                showAlert("Erreur", "Veuillez sélectionner une date limite valide.");
                return;
            }

            selectedTask.setNom(nomField.getText());
            selectedTask.setDescription(descriptionField.getText());
            selectedTask.setDateLimite(Date.valueOf(localDate));
            selectedTask.setPriorite(prioriteComboBox.getValue());
            selectedTask.setStatut(statutComboBox.getValue());
            selectedTask.setUserAssocie(userAssocieComboBox.getValue());
            selectedTask.setFournisseur(fournisseur);

            serviceTache.modifier(selectedTask);
            System.out.println("✅ Tâche mise à jour avec succès !");

            // Redirect to EventTache screen
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
}
