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
import javafx.stage.Stage;
import services.ServiceFournisseur;
import services.ServiceTache;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

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
    private Button submitButton;

    private Tache selectedTask;
    private final ServiceTache serviceTache = new ServiceTache();

    /** ✅ Method to Set Task Data */
    public void setTaskData(Tache task) {
        this.selectedTask = task;
        nomField.setText(task.getNom());
        descriptionField.setText(task.getDescription());
        // Conversion de la date
        LocalDate localDate = dateLimitePicker.getValue();
        if (localDate != null) {
            task.setDateLimite(Date.valueOf(localDate));
        }

        // Populate ComboBoxes (Ensure proper values are set)
        prioriteComboBox.getItems().addAll("Basse", "Moyenne", "Haute");
        prioriteComboBox.setValue(task.getPriorite());

        statutComboBox.getItems().addAll("À faire", "En cours", "Terminée");
        statutComboBox.setValue(task.getStatut());

        userAssocieComboBox.getItems().add(task.getUserAssocie()); // You might need to load actual user names
        userAssocieComboBox.setValue(task.getUserAssocie());
            fournisseurComboBox.getItems().add(task.getFournisseur().getNom());
            fournisseurComboBox.setValue(task.getFournisseur().getNom());
        System.out.println(task.getFournisseur().getNom());
    }

    @FXML
    public void updateTask(ActionEvent event) {
        try {
            ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
            Evenement e = new Evenement();
            e.setEvenement_id(3);
            Fournisseur f = new Fournisseur();
            f.setFournisseurId(7);
           int idF = serviceFournisseur.rechercherIdParNom(fournisseurComboBox.getValue());

            LocalDate localDate = dateLimitePicker.getValue();
            selectedTask.setNom(nomField.getText());
            selectedTask.setDescription(descriptionField.getText());
            selectedTask.setDateLimite(Date.valueOf(localDate));
            selectedTask.setPriorite(prioriteComboBox.getValue());
            selectedTask.setStatut(statutComboBox.getValue());
            selectedTask.setUserAssocie(userAssocieComboBox.getValue());
            selectedTask.setEvenement(e);
            selectedTask.setFournisseur(serviceFournisseur.rechercherParId(idF));
            // Call service to update the task
            serviceTache.modifier(selectedTask);
            System.out.println("✅ Tâche mise à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void RedirectBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
