package controllers;

import entities.Evenement;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class DetailsEvenementController2 {

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
    private Label eventNameLabel;

    @FXML
    private Label eventDateLabel;

    @FXML
    private Label eventLocationLabel;

    @FXML
    private Label eventCategoryLabel;

    @FXML
    private Label eventDescriptionLabel;

    @FXML
    private ImageView eventImageView;

    @FXML
    private Pane pane_event;

    @FXML
    private Button retourButton;


    private Evenement currentEvenement;


    @FXML
    public void initialize() {
        // Adapter le pane_event pour qu'il ait un fond arrondi
        pane_event.setStyle("-fx-background-radius: 10px; -fx-background-color: #F5F5F5;");

        // Configurer l'imageView une seule fois
        eventImageView.setPreserveRatio(true);

        // Centrer l'imageView dans le pane
        eventImageView.setLayoutX(0);
        eventImageView.setLayoutY(0);

        // Mettre à jour les dimensions quand le pane change de taille
        pane_event.widthProperty().addListener((obs, oldVal, newVal) -> {
            double width = newVal.doubleValue();
            eventImageView.setFitWidth(width);
            centerImage();
        });

        pane_event.heightProperty().addListener((obs, oldVal, newVal) -> {
            double height = newVal.doubleValue();
            eventImageView.setFitHeight(height);
            centerImage();
        });
    }

    // Méthode pour centrer l'image manuellement
    private void centerImage() {
        if (eventImageView.getImage() != null) {
            double x = (pane_event.getWidth() - eventImageView.getBoundsInLocal().getWidth()) / 2;
            double y = (pane_event.getHeight() - eventImageView.getBoundsInLocal().getHeight()) / 2;

            eventImageView.setLayoutX(Math.max(0, x));
            eventImageView.setLayoutY(Math.max(0, y));
        }
    }

    public void setCurrentEvenement(Evenement evenement) {
        this.currentEvenement = evenement;
        updateUI();
    }

    public void updateUI() {
        if (currentEvenement != null) {
            // Afficher le nom de l'événement
            eventNameLabel.setText(currentEvenement.getNom());
            // Afficher les dates
            eventDateLabel.setText("Date: " + currentEvenement.getDate_debut().toString() + " - " + currentEvenement.getDate_fin().toString());
            // Afficher le lieu et la catégorie
            eventLocationLabel.setText("Location: " + currentEvenement.getLieu());
            eventCategoryLabel.setText("Category: " + currentEvenement.getCategorie());
            // Afficher la description
            eventDescriptionLabel.setText("Description: " + currentEvenement.getDescription());
            // Charger l'image
            String imagePath = currentEvenement.getImage_event();
            if (imagePath != null && !imagePath.isEmpty()) {
                try {
                    // Construire le chemin absolu vers l'image
                    String projectPath = System.getProperty("user.dir");
                    String fullPath = projectPath + "/src/main/resources/" + imagePath;
                    File file = new File(fullPath);
                    if (file.exists()) {
                        Image image = new Image(file.toURI().toString());
                        eventImageView.setImage(image);

                        // Configurer les dimensions
                        eventImageView.setFitWidth(pane_event.getWidth());
                        eventImageView.setFitHeight(pane_event.getHeight());

                        // Centrer l'image une fois qu'elle est chargée
                        centerImage();

                        // Appliquer un style de bordure
                        eventImageView.setStyle("-fx-border-color: #ddc8b0; -fx-border-radius: 15px; -fx-border-width: 2px; -fx-padding: 5px;");
                    } else {
                        System.err.println("Le fichier d'image n'existe pas: " + fullPath);
                    }
                } catch (Exception e) {
                    System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
                }
            }
        } else {
            System.err.println("Aucun événement n'est défini pour afficher les détails.");
        }
    }



    public void retourPage(javafx.event.ActionEvent actionEvent) {
        try {
            // Load the FXML file for the previous page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void handleGiftClick(javafx.event.ActionEvent event) {
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
    void handleHomeClick(javafx.event.ActionEvent event) {
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
    void handleSitemapClick(javafx.event.ActionEvent event) {
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
