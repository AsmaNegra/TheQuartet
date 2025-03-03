package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entities.Utilisateur;
import services.ServiceUtilisateur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class UserProfileController {
    @FXML
    private TextField nomField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField entrepriseField;

    private Utilisateur currentUser;
    private ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();

    public void initData(Utilisateur user) {
        this.currentUser = user;
        nomField.setText(user.getNom());
        emailField.setText(user.getEmail());
        passwordField.setText(user.getMotDePasse());
        entrepriseField.setText(user.getEntreprise());
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        currentUser.setNom(nomField.getText());
        currentUser.setEmail(emailField.getText());
        currentUser.setMotDePasse(passwordField.getText());
        currentUser.setEntreprise(entrepriseField.getText());

        try {
            serviceUtilisateur.modifier(currentUser);
            showAlert(AlertType.INFORMATION, "Succès", "Vos informations ont été mises à jour");
            // Rediriger vers la page d'authentification
            redirectToAuthentication(event);
        } catch (SQLException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        try {
            redirectToAuthentication(event);
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors de la redirection : " + e.getMessage());
        }
    }

    private void redirectToAuthentication(ActionEvent event) {
        try {
            // Essayer différentes approches pour charger le fichier FXML
            URL fxmlUrl = getClass().getResource("Authentification.fxml");

            if (fxmlUrl == null) {
                // Si le premier chemin ne fonctionne pas, essayons d'autres variantes
                fxmlUrl = getClass().getResource("Authentification.fxml");
            }

            if (fxmlUrl == null) {
                // Essayons sans le '/' initial
                fxmlUrl = getClass().getResource("Authentification.fxml");
            }

            if (fxmlUrl == null) {
                // Essayons avec un chemin absolu en fonction de la structure de votre projet
                fxmlUrl = getClass().getClassLoader().getResource("Authentification.fxml");
            }

            if (fxmlUrl == null) {
                // Dernier essai, en considérant que le chemin pourrait être avec ou sans majuscule
                fxmlUrl = getClass().getResource(",Authentification.fxml");
            }

            if (fxmlUrl == null) {
                throw new IOException("Impossible de trouver le fichier FXML d'authentification");
            }

            // Chargement du fichier FXML
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            // Configuration de la scène
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors de la redirection : " + e.getMessage());
            e.printStackTrace(); // Afficher la trace complète pour le débogage
        }
    }

    private void showAlert(AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
