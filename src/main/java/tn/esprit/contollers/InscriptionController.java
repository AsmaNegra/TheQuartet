package tn.esprit.contollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tn.esprit.entities.Role;
import tn.esprit.entities.Utilisateur;
import tn.esprit.services.ServiceUtilisateur;

import java.io.IOException;

public class InscriptionController {

    @FXML
    private TextField nom_field;

    @FXML
    private TextField email_field;

    @FXML
    private TextField mdp_field;

    @FXML
    private Button btn_inscrire;

    @FXML
    private ToggleGroup rolegrp;

    @FXML
    void saveutili(ActionEvent event) {
        if (!validateFields()) {
            return;
        }

        try {
            String nom = nom_field.getText().trim();
            String email = email_field.getText().trim();
            String motDePasse = mdp_field.getText().trim();

            // Vérifier si un rôle est sélectionné
            RadioButton selectedRadioButton = (RadioButton) rolegrp.getSelectedToggle();
            if (selectedRadioButton == null) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez sélectionner un rôle");
                return;
            }

            Role role = Role.valueOf(selectedRadioButton.getText().toUpperCase());

            // Créer l'utilisateur
            Utilisateur utilisateur = new Utilisateur(
                    0,
                    nom,
                    email,
                    motDePasse,
                    role
            );

            ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();
            serviceUtilisateur.ajouter_Utili(utilisateur);

            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Succès", "Inscription réussie !");

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors de l'inscription : " + e.getMessage());
        }
    }

    private boolean validateFields() {
        StringBuilder errors = new StringBuilder();
        boolean isValid = true;

        // Validation du nom
        if (nom_field.getText().trim().isEmpty()) {
            errors.append("- Le nom est requis\n");
            nom_field.setStyle("-fx-border-color: red");
            isValid = false;
        } else if (!nom_field.getText().trim().matches("[a-zA-Z\\s]{3,30}")) {
            errors.append("- Le nom doit contenir entre 3 et 30 caractères alphabétiques\n");
            nom_field.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            nom_field.setStyle("");
        }

        // Validation de l'email
        if (email_field.getText().trim().isEmpty()) {
            errors.append("- L'email est requis\n");
            email_field.setStyle("-fx-border-color: red");
            isValid = false;
        } else if (!validateEmail(email_field.getText().trim())) {
            errors.append("- Format d'email invalide\n");
            email_field.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            email_field.setStyle("");
        }

        // Validation du mot de passe
        if (mdp_field.getText().trim().isEmpty()) {
            errors.append("- Le mot de passe est requis\n");
            mdp_field.setStyle("-fx-border-color: red");
            isValid = false;
        } else if (!validatePassword(mdp_field.getText().trim())) {
            errors.append("- Le mot de passe doit contenir au moins 8 caractères, incluant une majuscule, une minuscule et un chiffre\n");
            mdp_field.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            mdp_field.setStyle("");
        }

        // Validation du rôle
        if (rolegrp.getSelectedToggle() == null) {
            errors.append("- La sélection d'un rôle est requise\n");
            isValid = false;
        }

        if (!isValid) {
            showAlert(Alert.AlertType.ERROR, "Erreur de validation", errors.toString());
        }

        return isValid;
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    private boolean validatePassword(String password) {
        // Au moins 8 caractères, une majuscule, une minuscule et un chiffre
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        return password.matches(passwordRegex);
    }

    private void clearFields() {
        nom_field.clear();
        email_field.clear();
        mdp_field.clear();
        if (rolegrp.getSelectedToggle() != null) {
            rolegrp.getSelectedToggle().setSelected(false);
        }

        // Réinitialiser les styles
        nom_field.setStyle("");
        email_field.setStyle("");
        mdp_field.setStyle("");
    }

    @FXML
    void annuler(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Authentification.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erreur lors du chargement de la page inscription: " + ex.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}