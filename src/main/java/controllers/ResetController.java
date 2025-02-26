package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceUtilisateur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class ResetController {

    @FXML
    private TextField chmps_mail;

    @FXML
    private TextField champs_mdp;

    @FXML
    private Button btn_annuler;

    @FXML
    private Button btn_enregistrer;

    private ServiceUtilisateur serviceUtilisateur;

    @FXML
    public void initialize() {
        serviceUtilisateur = new ServiceUtilisateur();

        // Ajouter des listeners pour la validation en temps réel
        chmps_mail.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail(newValue);
        });

        champs_mdp.textProperty().addListener((observable, oldValue, newValue) -> {
            validatePassword(newValue);
        });
    }

    @FXML
    void retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Authentification.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors du retour : " + e.getMessage());
        }
    }

    @FXML
    void enregistrer(ActionEvent event) {
        String email = chmps_mail.getText().trim();
        String newPassword = champs_mdp.getText().trim();

        // Validation des champs
        if (!validateFields(email, newPassword)) {
            return;
        }

        try {
            // Vérifier si l'email existe dans la base
            if (!serviceUtilisateur.emailExists(email)) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Cette adresse email n'existe pas dans notre système.");
                return;
            }

            // Mettre à jour le mot de passe
            if (serviceUtilisateur.updatePassword(email, newPassword)) {
                showAlert(Alert.AlertType.INFORMATION, "Succès", "Votre mot de passe a été mis à jour avec succès.");
                retour(event); // Retourner à la page d'authentification
            } else {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible de mettre à jour le mot de passe.");
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur de base de données : " + e.getMessage());
        }
    }

    private boolean validateFields(String email, String password) {
        // Vérification des champs vides
        if (email.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Tous les champs sont obligatoires.");
            return false;
        }

        // Validation de l'email
        if (!validateEmail(email)) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Format d'email invalide.");
            return false;
        }

        // Validation du mot de passe
        if (!validatePassword(password)) {
            showAlert(Alert.AlertType.ERROR, "Erreur",
                    "Le mot de passe doit contenir au moins 8 caractères, " +
                            "incluant une majuscule, une minuscule, un chiffre et un caractère spécial.");
            return false;
        }

        return true;
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    private boolean validatePassword(String password) {
        // Au moins 8 caractères, une majuscule et une minuscule
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        return Pattern.compile(passwordRegex).matcher(password).matches();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
