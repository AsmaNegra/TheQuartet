package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import entities.Role;
import entities.Utilisateur;
import services.EmailService;
import services.ServiceUtilisateur;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;

public class InscriptionController implements Initializable {

    @FXML
    private TextField nom_field;

    @FXML
    private TextField email_field;

    @FXML
    private PasswordField mdp_field;

    @FXML
    private TextField mdp_field_visible;

    @FXML
    private FontAwesomeIconView eye_icon;

    @FXML
    private Button btn_inscrire;

    @FXML
    private ToggleGroup rolegrp;

    @FXML
    private ProgressBar passwordStrengthBar;

    @FXML
    private Label passwordStrengthLabel;

    @FXML
    private Button btn_choisir_image;

    @FXML
    private Label image_path_label;

    @FXML
    private ImageView image_preview;

    private File selectedImageFile;
    private String photoUrl;
    private boolean passwordVisible = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Ajouter un écouteur pour le champ de mot de passe
        mdp_field.textProperty().addListener((observable, oldValue, newValue) -> {
            updatePasswordStrength(newValue);
            mdp_field_visible.setText(newValue);
        });

        // Ajouter un écouteur pour le champ de mot de passe visible
        mdp_field_visible.textProperty().addListener((observable, oldValue, newValue) -> {
            updatePasswordStrength(newValue);
            mdp_field.setText(newValue);
        });
    }

    @FXML
    void togglePasswordVisibility(MouseEvent event) {
        passwordVisible = !passwordVisible;

        if (passwordVisible) {
            // Afficher le mot de passe
            mdp_field_visible.setText(mdp_field.getText());
            mdp_field_visible.setVisible(true);
            mdp_field.setVisible(false);
            eye_icon.setGlyphName("EYE_SLASH");
        } else {
            // Masquer le mot de passe
            mdp_field.setText(mdp_field_visible.getText());
            mdp_field.setVisible(true);
            mdp_field_visible.setVisible(false);
            eye_icon.setGlyphName("EYE");
        }
    }

    @FXML
    void choisirImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner une image de profil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        selectedImageFile = fileChooser.showOpenDialog(stage);

        if (selectedImageFile != null) {
            // Afficher le chemin du fichier sélectionné
            image_path_label.setText(selectedImageFile.getName());

            // Prévisualiser l'image
            try {
                Image image = new Image(selectedImageFile.toURI().toString());
                image_preview.setImage(image);
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible de charger l'image: " + e.getMessage());
            }
        }
    }

    private String saveImageToDirectory(File imageFile) throws IOException {
        // Créer un dossier pour stocker les images s'il n'existe pas
        String directoryPath = "src/main/resources/images/profiles";
        Path directory = Paths.get(directoryPath);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        // Générer un nom de fichier unique pour éviter les collisions
        String extension = imageFile.getName().substring(imageFile.getName().lastIndexOf('.'));
        String uniqueFileName = UUID.randomUUID().toString() + extension;

        // Chemin destination
        Path destinationPath = directory.resolve(uniqueFileName);

        // Copier le fichier
        Files.copy(imageFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        // Retourner le chemin relatif pour stockage en BDD
        return "images/profiles/" + uniqueFileName;
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

    private String hashPassword(String plainPassword) {
        // Générer un sel avec un coût de calcul de 12 (recommandé)
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    @FXML
    void saveutili(ActionEvent event) {
        if (!validateFields()) {
            return;
        }

        try {
            // Vérifier si l'email existe déjà
            ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();
            if (serviceUtilisateur.emailExists(email_field.getText().trim())) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Cette adresse email est déjà utilisée.");
                return;
            }

            String nom = nom_field.getText().trim();
            String email = email_field.getText().trim();
            String motDePasse = passwordVisible ? mdp_field_visible.getText().trim() : mdp_field.getText().trim();

            // Hacher le mot de passe avant de le stocker
            String motDePasseHashe = hashPassword(motDePasse);

            // Gérer l'image si elle a été sélectionnée
            if (selectedImageFile != null) {
                photoUrl = saveImageToDirectory(selectedImageFile);
            } else {
                // Chemin vers une image par défaut si aucune image n'est sélectionnée
                photoUrl = "images/profiles/default.jpg";
            }

            // Vérifier si un rôle est sélectionné
            RadioButton selectedRadioButton = (RadioButton) rolegrp.getSelectedToggle();
            if (selectedRadioButton == null) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez sélectionner un rôle");
                return;
            }

            Role role = Role.valueOf(selectedRadioButton.getText().toUpperCase());

            // Créer l'utilisateur avec le mot de passe haché et le chemin de l'image
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(nom);
            utilisateur.setEmail(email);
            utilisateur.setMotDePasse(motDePasseHashe);
            utilisateur.setRole(role);
            utilisateur.setEtat("");
            //utilisateur.setNote_organisateur(0);
            utilisateur.setEntreprise("");
            utilisateur.setPhotoUrl(photoUrl);

            // Générer et envoyer un code de vérification
            String verificationCode = EmailService.generateVerificationCode();
            boolean emailSent = EmailService.sendVerificationEmail(email, verificationCode);

            if (emailSent) {
                // Ouvrir la fenêtre de vérification du code
                openVerificationWindow(utilisateur, verificationCode, event);
            } else {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Échec de l'envoi de l'email de vérification. Veuillez réessayer.");
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors de l'inscription : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void openVerificationWindow(Utilisateur utilisateur, String verificationCode, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/VerificationCode.fxml"));
        Parent root = loader.load();

        // Récupérer le contrôleur et initialiser les données
        VerificationCodeController controller = loader.getController();
        controller.initData(utilisateur, verificationCode);

        // Créer une nouvelle scène
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.setTitle("Vérification du code");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
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
        String motDePasse = passwordVisible ? mdp_field_visible.getText().trim() : mdp_field.getText().trim();
        if (motDePasse.isEmpty()) {
            errors.append("- Le mot de passe est requis\n");
            if (passwordVisible) {
                mdp_field_visible.setStyle("-fx-border-color: red");
            } else {
                mdp_field.setStyle("-fx-border-color: red");
            }
            isValid = false;
        } else if (!validatePassword(motDePasse)) {
            errors.append("- Le mot de passe doit contenir au moins 8 caractères, incluant une majuscule, une minuscule et un chiffre\n");
            if (passwordVisible) {
                mdp_field_visible.setStyle("-fx-border-color: red");
            } else {
                mdp_field.setStyle("-fx-border-color: red");
            }
            isValid = false;
        } else {
            mdp_field.setStyle("");
            mdp_field_visible.setStyle("");
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
        mdp_field_visible.clear();

        if (rolegrp.getSelectedToggle() != null) {
            rolegrp.getSelectedToggle().setSelected(false);
        }

        // Réinitialiser les styles
        nom_field.setStyle("");
        email_field.setStyle("");
        mdp_field.setStyle("");
        mdp_field_visible.setStyle("");

        // Réinitialiser la barre de progression
        passwordStrengthBar.setProgress(0.0);
        passwordStrengthLabel.setText("Faible");
        passwordStrengthBar.setStyle("-fx-accent: red;");

        // Réinitialiser l'affichage du mot de passe
        mdp_field.setVisible(true);
        mdp_field_visible.setVisible(false);
        eye_icon.setGlyphName("EYE");
        passwordVisible = false;

        // Réinitialiser l'image
        image_preview.setImage(null);
        image_path_label.setText("Aucun fichier sélectionné");
        selectedImageFile = null;
        photoUrl = null;
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