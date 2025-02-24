package controllers;

import entities.Evenement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class DetailsEvenementController2 {

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

    // Méthode initialize() pour configurer les écouteurs de propriétés
    @FXML
    public void initialize() {
        // Ajouter des écouteurs pour ajuster la taille de l'image lorsque le Pane est redimensionné
        pane_event.widthProperty().addListener((obs, oldVal, newVal) -> {
            eventImageView.setFitWidth(newVal.doubleValue());
        });

        pane_event.heightProperty().addListener((obs, oldVal, newVal) -> {
            eventImageView.setFitHeight(newVal.doubleValue());
        });
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

                        // Ajuster l'image à la taille du Pane
                        eventImageView.setFitWidth(pane_event.getWidth()); // Largeur du Pane
                        eventImageView.setFitHeight(pane_event.getHeight()); // Hauteur du Pane
                        eventImageView.setPreserveRatio(true); // Conserver les proportions
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

}
