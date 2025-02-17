package controllers;

import entities.Tache;
import entities.Utilisateur;
import entities.Fournisseur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceTache;
import services.ServiceUtilisateurEvenement;
import services.ServiceFournisseur;
import entities.Evenement;

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

    @FXML
    private ComboBox<String> fournisseurComboBox;

    private int evenementId = 3; // Default event ID for testing

    @FXML
    public void initialize() throws SQLException {
        populateUserAssocieComboBox();
        populateFournisseurComboBox();
    }

    private void populateUserAssocieComboBox() {
        ServiceUtilisateurEvenement service = new ServiceUtilisateurEvenement();
        List<Utilisateur> utilisateurs = service.getUtilisateursByEvenementId(3);

        userAssocieComboBox.getItems().clear();
        for (Utilisateur user : utilisateurs) {
            userAssocieComboBox.getItems().add(user.getNom());
        }
    }

    private void populateFournisseurComboBox() throws SQLException {
        ServiceFournisseur service = new ServiceFournisseur();
        List<Fournisseur> fournisseurs = service.afficher();

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
            if (fournisseurComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner un fournisseur.");
                return;
            }

            // Création d'un nouvel objet Tache
            Tache t = new Tache();
            Evenement e = new Evenement();
            e.setEvenement_id(evenementId);
            Fournisseur f = new Fournisseur();
            f.setNom(fournisseurComboBox.getValue());
            ServiceFournisseur service = new ServiceFournisseur();
            f.setFournisseurId(service.rechercherIdParNom(fournisseurComboBox.getValue()));

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
