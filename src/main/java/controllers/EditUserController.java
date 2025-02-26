package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entities.Role;
import entities.Utilisateur;
import services.ServiceUtilisateur;

import java.sql.SQLException;

public class EditUserController {
    @FXML
    private TextField nomField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox<Role> roleComboBox;
    @FXML
    private TextField etatField;
    @FXML
    private TextField entrepriseField;

    private Utilisateur user;
    private ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();
    private Runnable onSaveCallback;

    public void initData(Utilisateur user, Runnable onSaveCallback) {
        this.user = user;
        this.onSaveCallback = onSaveCallback;

        nomField.setText(user.getNom());
        emailField.setText(user.getEmail());
        passwordField.setText(user.getMotDePasse());
        roleComboBox.getItems().setAll(Role.values());
        roleComboBox.setValue(user.getRole());
        etatField.setText(user.getEtat());
        entrepriseField.setText(user.getEntreprise());
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        user.setNom(nomField.getText());
        user.setEmail(emailField.getText());
        user.setMotDePasse(passwordField.getText());
        user.setRole(roleComboBox.getValue());
        user.setEtat(etatField.getText());
        user.setEntreprise(entrepriseField.getText());

        try {
            serviceUtilisateur.modifier(user);
            if (onSaveCallback != null) {
                onSaveCallback.run();
            }
            closeWindow();
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
