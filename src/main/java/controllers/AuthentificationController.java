package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entities.Role;
import entities.Utilisateur;
import services.ServiceUtilisateur;

import java.io.IOException;
import java.sql.SQLException;

public class AuthentificationController {

    @FXML
    private TextField mail_field;

    @FXML
    private TextField mdp_field;

    @FXML
    private Button btn_cnx;

    @FXML
    private Button btn_annule;

    private ServiceUtilisateur serviceUtilisateur;

    @FXML
    public void initialize() {
        serviceUtilisateur = new ServiceUtilisateur();
    }
    @FXML
    private void reset(ActionEvent event) throws IOException {
        Parent resetPage = FXMLLoader.load(getClass().getResource("/Reset.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(resetPage));
        stage.show();
    }

    @FXML
    void connect(ActionEvent event) {
        String email = mail_field.getText().trim();
        String motDePasse = mdp_field.getText().trim();

        if (email.isEmpty() || motDePasse.isEmpty()) {
            showAlert(AlertType.ERROR, "Erreur", "Veuillez remplir tous les champs");
            return;
        }

        try {
            Utilisateur utilisateur = serviceUtilisateur.verifierIdentifiants(email, motDePasse);

            if (utilisateur != null) {
                FXMLLoader loader;
                if (utilisateur.getRole() == Role.ADMIN) {
                    loader = new FXMLLoader(getClass().getResource("/AdminDashboard.fxml"));
                    Parent root = loader.load();
                    AdminDashboardController controller = loader.getController();
                    controller.initData(utilisateur);
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } else {
                    loader = new FXMLLoader(getClass().getResource("/UserProfile.fxml"));
                    Parent root = loader.load();
                    UserProfileController controller = loader.getController();
                    controller.initData(utilisateur);
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            } else {
                showAlert(AlertType.ERROR, "Erreur", "Email ou mot de passe incorrect");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Erreur", "Erreur : " + e.getMessage());
        }
    }

//    @FXML
//    void connect(ActionEvent event) {
//        String email = mail_field.getText().trim();
//        String motDePasse = mdp_field.getText().trim();
//
//        // Vérification des champs vides
//        if (email.isEmpty() || motDePasse.isEmpty()) {
//            showAlert(AlertType.ERROR, "Erreur", "Veuillez remplir tous les champs");
//            return;
//        }
//
//        try {
//            Utilisateur utilisateur = serviceUtilisateur.verifierIdentifiants(email, motDePasse);
//
//            if (utilisateur != null) {
//                // Connexion réussie
//                showAlert(AlertType.INFORMATION, "Succès", "Vous êtes connecté !");
//
//                // Ici vous pouvez ajouter la navigation vers la page suivante
//                // Par exemple :
//                /*
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/gui/Dashboard.fxml"));
//                Parent root = loader.load();
//                Scene scene = new Scene(root);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//                */
//            } else {
//                // Échec de la connexion
//                showAlert(AlertType.ERROR, "Erreur", "Email ou mot de passe incorrect");
//            }
//        } catch (SQLException e) {
//            showAlert(AlertType.ERROR, "Erreur", "Erreur de connexion à la base de données : " + e.getMessage());
//        }
//    }

//    @FXML
//    void revenir(ActionEvent event) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/Accueil.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du retour à l'accueil : " + e.getMessage());
//        }
//    }
    @FXML
    void inscri(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/InscriptionU.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erreur lors du chargement de la page inscription: " + ex.getMessage());
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
