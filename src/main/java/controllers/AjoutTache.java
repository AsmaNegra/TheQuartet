package controllers;

import entities.Tache;
import entities.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ServiceTache;
import services.ServiceUtilisateurEvenement;
import entities.Evenement;
import entities.Fournisseur;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

public class AjoutTache {

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

    private int evenementId = -1; // Default value to ensure it's properly set

    @FXML
    public void initialize() {
        // Populate ComboBox when the UI loads (if evenementId is valid)
        if (evenementId > 0) {
            populateUserAssocieComboBox();
        }
    }

    public void setEvenementId(int evenementId) {
        this.evenementId = evenementId;
        System.out.println("Evenement ID set to: " + evenementId); // Debugging statement
        populateUserAssocieComboBox();
    }

    private void populateUserAssocieComboBox() {
        if (evenementId <= 0) {
            System.out.println("Evenement ID is not valid, skipping user retrieval."); // Debugging statement
            return;
        }

        ServiceUtilisateurEvenement service = new ServiceUtilisateurEvenement();
        List<Utilisateur> utilisateurs = service.getUtilisateursByEvenementId(evenementId);

        System.out.println("Users retrieved: " + utilisateurs.size()); // Debugging statement

        userAssocieComboBox.getItems().clear();
        for (Utilisateur user : utilisateurs) {
            System.out.println("Adding user: " + user.getNom()); // Debugging statement
            userAssocieComboBox.getItems().add(user.getNom());
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

            // Création d'un nouvel objet Tache
            Tache t = new Tache();
            Evenement e = new Evenement();
            e.setEvenement_id(evenementId);
            Fournisseur f = new Fournisseur();
            f.setFournisseurId(1);

            // Attribution des valeurs des champs
            t.setNom(nomField.getText());
            t.setDescription(descriptionField.getText().isEmpty() ? null : descriptionField.getText());
            t.setPriorite(prioriteComboBox.getValue());
            t.setStatut(statutComboBox.getValue());
            t.setEvenement(e);
            t.setFournisseur(f);
            t.setUserAssocie(userAssocieComboBox.getValue());

            // Conversion de la date
            LocalDate localDate = dateLimitePicker.getValue();
            if (localDate != null) {
                t.setDateLimite(Date.valueOf(localDate));
            }

            // Sauvegarde de la tâche
            ServiceTache st = new ServiceTache();
            st.ajouter(t);

            // Chargement de la vue des détails
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();

            // Changement de scène
            nomField.getScene().setRoot(root);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
