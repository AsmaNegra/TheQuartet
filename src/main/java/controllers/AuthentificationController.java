package controllers;

import com.google.api.services.oauth2.model.Userinfo;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import entities.Role;
import entities.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;
import services.GoogleAuthService;
import services.ServiceUtilisateur;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

public class AuthentificationController {

    @FXML
    private TextField mail_field;

    @FXML
    private TextField mdp_field;

    @FXML
    private TextField champs_mdp_visible;

    @FXML
    private FontAwesomeIconView eye_icon;

    @FXML
    private Button btn_cnx;

    @FXML
    private Button btn_annule;

    private ServiceUtilisateur serviceUtilisateur;
    private boolean passwordVisible = false;

    @FXML
    private Button btn_google;

    private GoogleAuthService googleAuthService;

    @FXML
    public void initialize() {
        serviceUtilisateur = new ServiceUtilisateur();

        try {
            googleAuthService = new GoogleAuthService();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            // Log le message d'erreur spécifique
            System.err.println("Erreur d'initialisation du service Google: " + e.getMessage());
            showAlert(AlertType.ERROR, "Erreur d'initialisation",
                    "Impossible d'initialiser le service Google: " + e.getMessage());
        }
    }

    @FXML
    void connectWithGoogle(ActionEvent event) {
        try {
            // Créer une nouvelle instance de GoogleAuthService à chaque connexion
            googleAuthService = new GoogleAuthService();

            // Obtenir les informations utilisateur de Google
            Userinfo userInfo = googleAuthService.getUserInfo();

            // Récupérer les informations nécessaires
            String email = userInfo.getEmail();
            String nom = userInfo.getName();
            String photoUrl = userInfo.getPicture();

            // Vérifier si l'utilisateur existe déjà
            boolean userExists = serviceUtilisateur.emailExists(email);
            Utilisateur utilisateur;

            if (userExists) {
                // Si l'utilisateur existe, le récupérer
                utilisateur = serviceUtilisateur.recupererUtilisateurParEmail(email);

                // Définir l'utilisateur dans la session
                UserSession.getInstance().setUtilisateur(utilisateur);

                // Naviguer vers la page appropriée selon le rôle
                navigateBasedOnRole(utilisateur, event);
            } else {
                // Créer un nouveau compte
                String tempPassword = generateRandomPassword(8);

                utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setEmail(email);
                utilisateur.setMotDePasse(BCrypt.hashpw(tempPassword, BCrypt.gensalt()));
                utilisateur.setRole(Role.PARTICIPANT);
                utilisateur.setEtat("actif");
                utilisateur.setNote_organisateur(0);
                utilisateur.setEntreprise("");
                utilisateur.setPhotoUrl(photoUrl != null ? photoUrl : "default_profile.png");

                // Ajouter l'utilisateur
                serviceUtilisateur.ajouter(utilisateur);

                // Définir l'utilisateur dans la session
                UserSession.getInstance().setUtilisateur(utilisateur);

                // Afficher le mot de passe temporaire
                showAlert(AlertType.INFORMATION, "Compte créé",
                        "Votre compte a été créé avec succès.\n" +
                                "Votre mot de passe temporaire est: " + tempPassword + "\n" +
                                "Veuillez changer votre mot de passe après la connexion.");

                // Naviguer vers la page appropriée
                navigateBasedOnRole(utilisateur, event);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Erreur de connexion",
                    "Erreur lors de la connexion Google: " + e.getMessage());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Erreur de sécurité",
                    "Problème avec les certificats ou les accès Google: " + e.getMessage());
        }
    }

    // Méthode utilitaire pour naviguer en fonction du rôle de l'utilisateur
    private void navigateBasedOnRole(Utilisateur utilisateur, ActionEvent event) {
        try {
            FXMLLoader loader;
            Parent root;
            String roleMsg = "";

            if (utilisateur.getRole() == Role.ADMIN) {
                loader = new FXMLLoader(getClass().getResource("/AdminFournisseur.fxml"));
                roleMsg = "administrateur";
            } else if (utilisateur.getRole() == Role.PARTICIPANT) {
                loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
                roleMsg = "participant";
            } else if (utilisateur.getRole() == Role.ORGANISATEUR) {
                loader = new FXMLLoader(getClass().getResource("/EventOrganisation.fxml"));
                roleMsg = "organisateur";
            } else {
                showAlert(AlertType.ERROR, "Erreur", "Rôle inconnu");
                return;
            }

            root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Afficher un message de bienvenue
            showAlert(AlertType.INFORMATION, "Connexion réussie",
                    "Bienvenue " + utilisateur.getNom() + " en tant que " + roleMsg);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Erreur de navigation",
                    "Impossible de charger la page: " + e.getMessage());
        }
    }

    // Méthode utilitaire pour générer un mot de passe aléatoire
    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder sb = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }


    @FXML
    void togglePasswordVisibility(MouseEvent event) {
        passwordVisible = !passwordVisible;

        if (passwordVisible) {
            // Afficher le mot de passe
            champs_mdp_visible.setText(mdp_field.getText());
            champs_mdp_visible.setVisible(true);
            mdp_field.setVisible(false);
            eye_icon.setGlyphName("EYE_SLASH");
        } else {
            // Masquer le mot de passe
            mdp_field.setText(champs_mdp_visible.getText());
            mdp_field.setVisible(true);
            champs_mdp_visible.setVisible(false);
            eye_icon.setGlyphName("EYE");
        }
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
                // Sauvegarder l'utilisateur dans la session
                UserSession.getInstance().setUtilisateur(utilisateur);

                // Rediriger en fonction du rôle de l'utilisateur
                FXMLLoader loader;
                Parent root;
                String roleMsg = "";

                if (utilisateur.getRole() == Role.ADMIN) {
                    // Rediriger vers la vue pour l'admin
                    loader = new FXMLLoader(getClass().getResource("/AdminFournisseur.fxml"));
                    roleMsg = "administrateur";
                } else if (utilisateur.getRole() == Role.PARTICIPANT) {
                    // Rediriger vers la vue pour le participant
                    loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
                    roleMsg = "participant";
                } else if (utilisateur.getRole() == Role.ORGANISATEUR) {
                    // Rediriger vers la vue pour l'organisateur
                    loader = new FXMLLoader(getClass().getResource("/EventOrganisation.fxml"));
                    roleMsg = "organisateur";
                } else {
                    // Cas non prévu
                    showAlert(AlertType.ERROR, "Erreur", "Rôle inconnu");
                    return;
                }

                root = loader.load();

                // Vous pouvez initialiser des données dans le contrôleur de la vue si nécessaire
                // Par exemple : ViewAllEventsController controller = loader.getController();
                // controller.initData(utilisateur);

                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();

                // Afficher un message de bienvenue personnalisé basé sur le rôle
                showAlert(AlertType.INFORMATION, "Connexion réussie",
                        "Bienvenue " + utilisateur.getNom() + " en tant que " + roleMsg);
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
