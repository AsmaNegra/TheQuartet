package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.ServiceUtilisateur;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class ResetController {

    @FXML
    private TextField chmps_mail;

    @FXML
    private PasswordField champs_mdp;

    @FXML
    private TextField champs_mdp_visible;

    @FXML
    private FontAwesomeIconView eye_icon;

    @FXML
    private Button btn_annuler;

    @FXML
    private Button btn_enregistrer;

    @FXML
    private ProgressBar passwordStrengthBar;

    @FXML
    private Label passwordStrengthLabel;

    private ServiceUtilisateur serviceUtilisateur;

    private boolean passwordVisible = false;

    @FXML
    public void initialize() {
        serviceUtilisateur = new ServiceUtilisateur();

        // Ajouter des listeners pour la validation en temps réel
        chmps_mail.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail(newValue);
        });

        // Synchroniser les deux champs de mot de passe
        champs_mdp.textProperty().addListener((observable, oldValue, newValue) -> {
            champs_mdp_visible.setText(newValue);
            validatePassword(newValue);
            updatePasswordStrength(newValue);
        });

        champs_mdp_visible.textProperty().addListener((observable, oldValue, newValue) -> {
            champs_mdp.setText(newValue);
            validatePassword(newValue);
            updatePasswordStrength(newValue);
        });

        // Initialiser la barre de progression
        passwordStrengthBar.setProgress(0.0);
        passwordStrengthBar.setStyle("-fx-accent: red;");
        passwordStrengthLabel.setText("Faible");
        passwordStrengthLabel.setTextFill(Color.RED);
    }

    @FXML
    void togglePasswordVisibility(MouseEvent event) {
        passwordVisible = !passwordVisible;

        if (passwordVisible) {
            // Afficher le mot de passe
            champs_mdp_visible.setText(champs_mdp.getText());
            champs_mdp_visible.setVisible(true);
            champs_mdp.setVisible(false);
            eye_icon.setGlyphName("EYE_SLASH");
        } else {
            // Masquer le mot de passe
            champs_mdp.setText(champs_mdp_visible.getText());
            champs_mdp.setVisible(true);
            champs_mdp_visible.setVisible(false);
            eye_icon.setGlyphName("EYE");
        }
    }

    private void updatePasswordStrength(String password) {
        // Calculer la force du mot de passe
        double strength = calculatePasswordStrength(password);

        // Mettre à jour la barre de progression
        passwordStrengthBar.setProgress(strength);

        // Définir la couleur de la barre en fonction de la force
        if (strength < 0.3) {
            passwordStrengthBar.setStyle("-fx-accent: red;");
            passwordStrengthLabel.setText("Faible");
            passwordStrengthLabel.setTextFill(Color.RED);
        } else if (strength < 0.6) {
            passwordStrengthBar.setStyle("-fx-accent: orange;");
            passwordStrengthLabel.setText("Moyen");
            passwordStrengthLabel.setTextFill(Color.ORANGE);
        } else if (strength < 0.8) {
            passwordStrengthBar.setStyle("-fx-accent: yellow;");
            passwordStrengthLabel.setText("Bon");
            passwordStrengthLabel.setTextFill(Color.YELLOWGREEN);
        } else {
            passwordStrengthBar.setStyle("-fx-accent: green;");
            passwordStrengthLabel.setText("Fort");
            passwordStrengthLabel.setTextFill(Color.GREEN);
        }
    }

    private double calculatePasswordStrength(String password) {
        if (password.isEmpty()) {
            return 0.0;
        }

        int length = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;

        // Vérifier les caractères spéciaux
        String specialChars = "!@#$%^&*()_-+=<>?/[]{}|";

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.contains(String.valueOf(c))) hasSpecial = true;
        }

        // Calculer le score
        double score = 0.0;

        // Longueur (40% du score total)
        double lengthScore = Math.min(1.0, length / 12.0) * 0.4;

        // Complexité (60% du score total)
        int complexityCount = (hasLower ? 1 : 0) + (hasUpper ? 1 : 0) + (hasDigit ? 1 : 0) + (hasSpecial ? 1 : 0);
        double complexityScore = (complexityCount / 4.0) * 0.6;

        score = lengthScore + complexityScore;

        // Vérifier si le mot de passe répond aux exigences minimales
        if (length < 8 || !hasLower || !hasUpper || !hasDigit) {
            score = Math.min(score, 0.6); // Limiter le score si les exigences minimales ne sont pas satisfaites
        }

        return score;
    }

    /**
     * Méthode pour hacher un mot de passe avec BCrypt
     * @param plainPassword Le mot de passe en clair
     * @return Le mot de passe haché
     */
    private String hashPassword(String plainPassword) {
        // Générer un sel avec un coût de calcul de 12 (recommandé)
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
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
        String newPassword = passwordVisible ? champs_mdp_visible.getText().trim() : champs_mdp.getText().trim();

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

            // Hacher le mot de passe avant de le mettre à jour
            String hashedPassword = hashPassword(newPassword);

            // Mettre à jour le mot de passe (utilisez le mot de passe haché)
            if (serviceUtilisateur.updatePassword(email, hashedPassword)) {
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
                            "incluant une majuscule, une minuscule et un chiffre.");
            return false;
        }

        return true;
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    private boolean validatePassword(String password) {
        // Au moins 8 caractères, une majuscule, une minuscule et un chiffre
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
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