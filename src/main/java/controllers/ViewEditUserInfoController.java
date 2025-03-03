package controllers;

import entities.UserSession;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import entities.Role;
import entities.Utilisateur;
import javafx.util.Duration;
import services.ServiceUtilisateur;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

public class ViewEditUserInfoController {
    @FXML
    private TextField nomField;
    @FXML
    private TextField emailField;
    @FXML
    private ComboBox<Role> roleComboBox;
    @FXML
    private TextField etatField;
    @FXML
    private TextField entrepriseField;
    @FXML
    private TextField photoPathField;
    @FXML
    private ImageView photoPreview;
    @FXML
    private Button browsePhotoButton;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    // Nouveaux éléments pour la sidebar
    @FXML
    private AnchorPane sidebar;
    @FXML
    private Label labelUser;
    @FXML
    private Label profileLabel;
    @FXML
    private Circle profileCircle;

    private final int EXPANDED_WIDTH = 200;
    private final int COLLAPSED_WIDTH = 70;
    private boolean isSidebarExpanded = false;

    private Utilisateur currentUser;
    private ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();

    private File selectedPhotoFile;
    private String originalPhotoPath;

    @FXML
    public void initialize() {
        // Get the current user from the session
        currentUser = UserSession.getInstance().getUtilisateur();

        // Initialiser la ComboBox des rôles
        roleComboBox.getItems().addAll(Role.PARTICIPANT, Role.ORGANISATEUR);

        if (currentUser != null) {
            // Fill in fields with current user data
            nomField.setText(currentUser.getNom());
            emailField.setText(currentUser.getEmail());

            // Sélectionner le rôle actuel dans la ComboBox
            roleComboBox.setValue(currentUser.getRole());

            etatField.setText(currentUser.getEtat());
            entrepriseField.setText(currentUser.getEntreprise());
            labelUser.setText(currentUser.getNom());

            // Charger la photo de profil si elle existe
            if (currentUser.getPhotoUrl() != null && !currentUser.getPhotoUrl().isEmpty()) {
                originalPhotoPath = currentUser.getPhotoUrl();
                photoPathField.setText(originalPhotoPath);

                try {
                    File photoFile = new File(originalPhotoPath);
                    if (photoFile.exists()) {
                        Image profileImage = new Image(photoFile.toURI().toString());
                        photoPreview.setImage(profileImage);

                        // Afficher l'image dans le cercle de profil
                        profileCircle.setFill(new ImagePattern(profileImage));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        sidebar.setPrefWidth(COLLAPSED_WIDTH);
    }

    @FXML
    private void handleBrowsePhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner une photo de profil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        selectedPhotoFile = fileChooser.showOpenDialog(photoPathField.getScene().getWindow());

        if (selectedPhotoFile != null) {
            photoPathField.setText(selectedPhotoFile.getAbsolutePath());

            // Afficher l'aperçu de l'image
            Image image = new Image(selectedPhotoFile.toURI().toString());
            photoPreview.setImage(image);

            // Mettre à jour le cercle de profil
            profileCircle.setFill(new ImagePattern(image));
        }
    }

    @FXML
    private void handleSave(ActionEvent event) {
        if (validateForm()) {
            // Update the user object with the form values
            currentUser.setNom(nomField.getText());
            currentUser.setEmail(emailField.getText());
            currentUser.setRole(roleComboBox.getValue());  // Get role from ComboBox
            currentUser.setEtat(etatField.getText());
            currentUser.setEntreprise(entrepriseField.getText());

            // Gérer la mise à jour de la photo
            if (selectedPhotoFile != null) {
                try {
                    // Créer un dossier pour les photos de profil s'il n'existe pas
                    String profileDir = "profiles";
                    Path profilePath = Paths.get(profileDir);
                    if (!Files.exists(profilePath)) {
                        Files.createDirectories(profilePath);
                    }

                    // Copier le fichier dans le dossier des profils
                    String fileName = System.currentTimeMillis() + "_" + selectedPhotoFile.getName();
                    Path destination = profilePath.resolve(fileName);
                    Files.copy(selectedPhotoFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

                    // Mettre à jour le chemin de la photo dans l'objet utilisateur
                    currentUser.setPhotoUrl(destination.toString());

                } catch (IOException e) {
                    showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la sauvegarde de la photo : " + e.getMessage());
                    return;
                }
            }

            try {
                // Save the changes to the database
                serviceUtilisateur.modifier(currentUser);

                // Update the user in the session
                UserSession.getInstance().setUtilisateur(currentUser);

                showAlert(Alert.AlertType.INFORMATION, "Succès", "Profil mis à jour avec succès!");
            } catch (SQLException e) {
                showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors de la mise à jour : " + e.getMessage());
            }
        }
    }

//    @FXML
//    private void handleCancel(ActionEvent event) {
//        closeWindow();
//    }

    private boolean validateForm() {
        StringBuilder errors = new StringBuilder();

        if (nomField.getText().trim().isEmpty()) {
            errors.append("- Le nom ne peut pas être vide\n");
        }

        if (emailField.getText().trim().isEmpty()) {
            errors.append("- L'email ne peut pas être vide\n");
        } else if (!emailField.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.append("- Format d'email invalide\n");
        }

        if (roleComboBox.getValue() == null) {
            errors.append("- Veuillez sélectionner un rôle\n");
        }

        if (errors.length() > 0) {
            showAlert(Alert.AlertType.ERROR, "Erreur de validation", errors.toString());
            return false;
        }

        return true;
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

    @FXML
    public void expandSidebar() {
        if (!isSidebarExpanded) {
            TranslateTransition slideOut = new TranslateTransition(Duration.seconds(0.3), sidebar);
            sidebar.setPrefWidth(EXPANDED_WIDTH);
            labelUser.setVisible(true);
            profileLabel.setVisible(true);
            isSidebarExpanded = true;
        }
    }

    @FXML
    public void collapseSidebar() {
        if (isSidebarExpanded) {
            TranslateTransition slideIn = new TranslateTransition(Duration.seconds(0.3), sidebar);
            sidebar.setPrefWidth(COLLAPSED_WIDTH);
            labelUser.setVisible(false);
            profileLabel.setVisible(false);
            isSidebarExpanded = false;
        }
    }

    @FXML
    public void handleSitemapClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Sitemap.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Sitemap : " + e.getMessage());
        }
    }

    @FXML
    public void handleGiftClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gift.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Gift : " + e.getMessage());
        }
    }

    @FXML
    public void handleHomeClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Home : " + e.getMessage());
        }
    }

    @FXML
    public void handleUserClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewUserInfo.fxml"));
            Parent root = loader.load();
            UserProfileController controller = loader.getController();
            if (currentUser != null) {
                controller.initData(currentUser);
            }
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Profil : " + e.getMessage());
        }
    }

    @FXML
    public void handleLogout() {
        try {
            Parent authentificationPage = FXMLLoader.load(getClass().getResource("/Authentification.fxml"));
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(authentificationPage));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors du retour à la page d'authentification : " + e.getMessage());
        }
    }

    @FXML
    private void handleUserInfoClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewUserInfo.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}