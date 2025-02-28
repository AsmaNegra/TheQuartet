package controllers;

import entities.Evenement;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DetailsEvenement {

    @FXML
    public Button btnLogout;
    @FXML
    private Button btnSitemap;
    @FXML
    private Button btnGift;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnHome1;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private Label labelUser;

    @FXML
    private TextField resNom;

    @FXML
    private TextArea resDescription;

    @FXML
    private Label resDateDebut;

    @FXML
    private Label resDateFin;

    @FXML
    private TextField resLieu;

    @FXML
    private TextField resCategorie;

    @FXML
    private TextField resBudget;

    @FXML
    private ImageView resImageEvent;

    @FXML
    private TextField resNbPlaces;

    @FXML
    private Button evenementFermerButton;

    @FXML
    private ImageView detailImageView;

    @FXML
    private ImageView imageViewEvent;

    private int evenementId;

    private String imagePathStored;

    @FXML
    private Button evenementModifierButton;

    private static Evenement currentEvenement;

    public static void setCurrentEvenement(Evenement evenement) {
        currentEvenement = evenement;
    }

    @FXML
    public void initialize() {
        if (currentEvenement != null) {
            // Afficher les données de currentEvenement dans les champs de l'interface
            setResNom(currentEvenement.getNom());
            setResDescription(currentEvenement.getDescription());
            setResDateDebut(currentEvenement.getDate_debut().toString());
            setResDateFin(currentEvenement.getDate_fin().toString());
            setResLieu(currentEvenement.getLieu());
            setResCategorie(currentEvenement.getCategorie());
            setResBudget(String.valueOf(currentEvenement.getBudget()));
            setResImageEvent(currentEvenement.getImage_event());
            setResNbPlaces(String.valueOf(currentEvenement.getNb_places()));
        }
    }

    public void setEvenementId(int id) {
        this.evenementId = id;
    }


    // Méthodes pour définir les valeurs des champs
    public void setResNom(String resNom) {
        this.resNom.setText(resNom);
    }

    public void setResDescription(String resDescription) {
        this.resDescription.setText(resDescription);
    }

    public void setResDateDebut(String resDateDebut) {
        this.resDateDebut.setText(resDateDebut);
    }

    public void setResDateFin(String resDateFin) {
        this.resDateFin.setText(resDateFin);
    }

    public void setResLieu(String resLieu) {
        this.resLieu.setText(resLieu);
    }

    public void setResCategorie(String resCategorie) {
        this.resCategorie.setText(resCategorie);
    }

    public void setResBudget(String resBudget) {
        this.resBudget.setText(resBudget);
    }

    public void setResImageEvent(String imagePath) {
        this.imagePathStored = imagePath; // Stocker le chemin
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                // Construire le chemin absolu vers l'image
                String projectPath = System.getProperty("user.dir");
                String fullPath = projectPath + "/src/main/resources/" + imagePath;
                File file = new File(fullPath);

                if (file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    resImageEvent.setImage(image);

                    // Ajuster l'image dans son conteneur
                    resImageEvent.setFitWidth(200);
                    resImageEvent.setFitHeight(150);
                    resImageEvent.setPreserveRatio(true);
                } else {
                    System.err.println("Le fichier d'image n'existe pas: " + fullPath);
                    chargerImageParDefaut();
                }
            } else {
                chargerImageParDefaut();
            }
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
            chargerImageParDefaut();
        }
    }

    private void chargerImageParDefaut() {
        try {
            // Construire le chemin vers l'image par défaut
            String projectPath = System.getProperty("user.dir");
            String defaultImagePath = projectPath + "/src/main/resources/images/default-event.png";
            File defaultFile = new File(defaultImagePath);

            if (defaultFile.exists()) {
                Image defaultImage = new Image(defaultFile.toURI().toString());
                resImageEvent.setImage(defaultImage);
            } else {
                System.err.println("Image par défaut introuvable: " + defaultImagePath);
            }
        } catch (Exception ex) {
            System.err.println("Impossible de charger l'image par défaut: " + ex.getMessage());
        }
    }


    public void setResNbPlaces(String resNbPlaces) {
        this.resNbPlaces.setText(resNbPlaces);
    }

    @FXML
    private void modifierEvenement(ActionEvent event) {
        try {
            // Récupérer les données de l'événement actuel
            Evenement evenementActuel = new Evenement();
            evenementActuel.setEvenement_id(this.evenementId);
            evenementActuel.setNom(resNom.getText());
            evenementActuel.setDescription(resDescription.getText());

            // Convertir les strings de date en Timestamp
            String dateDebutText = resDateDebut.getText().replace(".0", "");
            String dateFinText = resDateFin.getText().replace(".0", "");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateDebut = LocalDateTime.parse(dateDebutText, formatter);
            LocalDateTime dateFin = LocalDateTime.parse(dateFinText, formatter);

            evenementActuel.setDate_debut(Timestamp.valueOf(dateDebut));
            evenementActuel.setDate_fin(Timestamp.valueOf(dateFin));
            evenementActuel.setLieu(resLieu.getText());
            evenementActuel.setCategorie(resCategorie.getText());

            evenementActuel.setBudget(Float.parseFloat(resBudget.getText()));

            // Correction pour l'image
            // Utiliser directement le chemin relatif stocké
            evenementActuel.setImage_event(imagePathStored); // Vous devez ajouter cette variable de classe

            evenementActuel.setNb_places(Integer.parseInt(resNbPlaces.getText()));

            // Charger la vue de modification
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierEvenement.fxml"));
            Parent root = loader.load();

            // Récupérer le contrôleur et initialiser les champs
            ModifierEvenementController modifierController = loader.getController();
            modifierController.setEvenement(evenementActuel);

            // Afficher la vue de modification
            Scene scene = evenementModifierButton.getScene();
            scene.setRoot(root);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de l'ouverture de la vue de modification : " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }



    @FXML
    private void handleFermerButton(ActionEvent event) {
        // Get the stage
        Stage stage = (Stage) evenementFermerButton.getScene().getWindow();
        // Close the stage
        stage.close();
    }

    @FXML
    void expandSidebar(MouseEvent event) {
        // Animate sidebar expansion (e.g., from 70 to 200 pixels)
        Timeline expandTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        expandTimeline.getKeyFrames().add(keyFrame);
        expandTimeline.play();

        // Set the text for each button
        btnSitemap.setText("Mes evenements");
        btnGift.setText("Admin");
        btnHome.setText("Tous les evenements");
        btnHome1.setText("My Account");
        btnLogout.setText("Logout");
        labelUser.setVisible(true);
    }

    @FXML
    void collapseSidebar(MouseEvent event) {
        // Animate sidebar collapse (e.g., back to 70 pixels)
        Timeline collapseTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 70);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        collapseTimeline.getKeyFrames().add(keyFrame);
        collapseTimeline.play();

        // Clear the text for each button
        btnSitemap.setText("");
        btnGift.setText("");
        btnHome.setText("");
        btnHome1.setText("");
        btnLogout.setText("");
        labelUser.setVisible(false);
    }



    @FXML
    void handleGiftClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminFournisseur.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleHomeClick(ActionEvent event) {
        try {

            // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ref.fxml"));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleSitemapClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventOrganisation.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLogoutClick(ActionEvent event) {

    }


}
