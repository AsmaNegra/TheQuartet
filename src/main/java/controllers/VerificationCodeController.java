package controllers;

import entities.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceUtilisateur;

import java.io.IOException;

public class VerificationCodeController {

    @FXML
    private TextField codeField;

    @FXML
    private Label errorLabel;

    @FXML
    private Label attemptsLabel;

    @FXML
    private Button verifyButton;

    @FXML
    private Button cancelButton;

    private Utilisateur utilisateur;
    private String verificationCode;
    private int attemptsLeft = 3;
    private ServiceUtilisateur serviceUtilisateur;

    public void initData(Utilisateur utilisateur, String verificationCode) {
        this.utilisateur = utilisateur;
        this.verificationCode = verificationCode;
        this.serviceUtilisateur = new ServiceUtilisateur();
        attemptsLabel.setText("Tentatives restantes: " + attemptsLeft);
    }

    @FXML
    void verifyCode(ActionEvent event) {
        String enteredCode = codeField.getText().trim();

        if (enteredCode.isEmpty()) {
            errorLabel.setText("Veuillez entrer le code de vérification.");
            return;
        }

        if (enteredCode.equals(verificationCode)) {
            // Code correct, procéder à l'inscription
            try {
                serviceUtilisateur.ajouter(utilisateur);
                showAlert(event, "Inscription réussie !", "Votre compte a été créé avec succès.");
                navigateToAuthentication(event);
            } catch (Exception e) {
                errorLabel.setText("Erreur lors de l'inscription: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Code incorrect
            attemptsLeft--;
            attemptsLabel.setText("Tentatives restantes: " + attemptsLeft);

            if (attemptsLeft <= 0) {
                errorLabel.setText("Nombre maximum de tentatives atteint. Inscription impossible.");
                // Désactiver le bouton de vérification
                verifyButton.setDisable(true);

                // Attendre 2 secondes puis rediriger vers la page d'authentification
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        javafx.application.Platform.runLater(() -> {
                            try {
                                navigateToAuthentication(event);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                errorLabel.setText("Code incorrect. " + attemptsLeft + " tentative(s) restante(s).");
            }
        }
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        navigateToAuthentication(event);
    }

    private void navigateToAuthentication(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Authentification.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(ActionEvent event, String title, String content) throws IOException {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}