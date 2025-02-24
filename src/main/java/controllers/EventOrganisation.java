package controllers;

import entities.Evenement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceEvenement;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EventOrganisation {

    @FXML
    private AnchorPane eventContainer;
    @FXML
    private ImageView eventImage;
    @FXML
    private Label eventName;
    @FXML
    private Label eventDate;
    @FXML
    private Label eventLocation;
    @FXML
    private Label eventCategory;
    @FXML
    private HBox listEvents;
    private Timeline refreshTimeline;

    private ServiceEvenement serviceEvenement = new ServiceEvenement();

    @FXML
    public void initialize() {
        loadEvents();

        refreshTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event-> loadEvents()));
        refreshTimeline.setCycleCount(Timeline.INDEFINITE);
        refreshTimeline.play();
    }

    public void stopRefresh() {
        if(refreshTimeline != null) {
            refreshTimeline.stop();
        }
    }

//    @FXML
//    void redirectEvent(MouseEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
//            Parent root = loader.load();
//
//            Scene scene = ((Node) event.getSource()).getScene();
//            scene.setRoot(root);
//
//        } catch (IOException e) {
//            e.printStackTrace(); // Meilleur pour le débogage
//        }
//    }

    @FXML
    void redirectEvent(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Integer eventId = (Integer) source.getUserData();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();

            // Récupérer le contrôleur et initialiser les données
            EventTache eventTacheController = loader.getController();
            eventTacheController.initEventData(eventId);  // Nouvelle méthode à créer

            Scene scene = source.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadEvents() {
        try {
            List<Evenement> evenements = serviceEvenement.afficher();

            // On garde le bouton + qui est le premier élément
            Node addButton = listEvents.getChildren().get(0);
            listEvents.getChildren().clear();
            listEvents.getChildren().add(addButton);

            // Définir la hauteur minimale du HBox
            listEvents.setMinHeight(300);

            for (Evenement event : evenements) {
                try {
                    // Créer le container principal
                    AnchorPane newContainer = new AnchorPane();
                    newContainer.setPrefWidth(200);
                    newContainer.setPrefHeight(250);
                    newContainer.setMinWidth(200);
                    newContainer.setMaxWidth(200);
                    newContainer.getStyleClass().addAll("event-container", "pane", "background_color");

                    // Créer le VBox interne
                    VBox vbox = new VBox();
                    vbox.setSpacing(8);
                    vbox.setAlignment(Pos.CENTER);
                    vbox.getStyleClass().add("colored_card");
                    vbox.setPadding(new Insets(10));

                    // Créer l'ImageView
                    ImageView imageView = new ImageView();
                    imageView.setFitHeight(120.0);
                    imageView.setFitWidth(180.0);
                    imageView.setPreserveRatio(true);

                    StackPane imageContainer = new StackPane(imageView);
                    imageContainer.setStyle("-fx-border-color: #ddc8b0; -fx-border-radius: 8px; -fx-border-width: 1px");
                    imageContainer.setPadding(new Insets(2));


                    // Charger l'image
                    loadEventImage(imageView, event.getImage_event());

                    // Créer les labels
                    Label nameLabel = new Label(event.getNom());
                    nameLabel.getStyleClass().add("event-title");
                    nameLabel.setWrapText(true);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Label dateLabel = new Label(dateFormat.format(event.getDate_debut()));
                    dateLabel.getStyleClass().add("event-details");

                    Label locationLabel = new Label(event.getLieu());
                    locationLabel.getStyleClass().add("event-details");

                    Label categoryLabel = new Label(event.getCategorie());
                    categoryLabel.getStyleClass().add("event-category");

                    // Ajouter tous les éléments au VBox
                    vbox.getChildren().addAll(
                        imageContainer,
                        nameLabel,
                        dateLabel,
                        locationLabel,
                        categoryLabel
                    );

                    // Ajouter le VBox au container
                    newContainer.getChildren().add(vbox);

                    // Configurer les contraintes d'ancrage
                    AnchorPane.setTopAnchor(vbox, 0.0);
                    AnchorPane.setBottomAnchor(vbox, 0.0);
                    AnchorPane.setLeftAnchor(vbox, 0.0);
                    AnchorPane.setRightAnchor(vbox, 0.0);

                    // Stocker l'ID de l'événement
                    newContainer.setUserData(event.getEvenement_id());

                    // Ajouter le gestionnaire de clic
                    newContainer.setOnMouseClicked(e -> redirectEvent(e));

                    // Configurer les marges
                    HBox.setMargin(newContainer, new Insets(15));

                    // Ajouter le container à la liste
                    listEvents.getChildren().add(newContainer);

                } catch (Exception e) {
                    System.err.println("Erreur lors de la création du container pour l'événement: " + event.getNom());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des événements");
            e.printStackTrace();
        }
    }

    private void loadEventImage(ImageView imageView, String imagePath) {
        try {
            if (imagePath == null || imagePath.isEmpty()) {
                System.out.println("Image path is null or empty");
                return;
            }

            Image image;
            if (imagePath.startsWith("http://") || imagePath.startsWith("https://")) {
                // URL directe
                image = new Image(imagePath, 270, 180, true, true);
            } else {
                // Chemin local
                String cleanPath = imagePath.replace("images/events/", ""); // Nettoyage du chemin
                String resourcePath = "/images/events/" + cleanPath;

                InputStream imageStream = getClass().getResourceAsStream(resourcePath);
                if (imageStream == null) {
                    File file = new File("src/main/resources/images/events/" + cleanPath);
                    if (file.exists()) {
                        image = new Image(file.toURI().toString(), 270, 180, true, true);
                    } else {
                        //System.out.println("image not found");
                        return;
                    }
                } else {
                    image = new Image(imageStream, 270, 180, true, true);
                }
            }

            imageView.setImage(image);

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image: " + imagePath + "\n" + e.getMessage());
        }
    }



    public void ajouterEvenement(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterEvenement.fxml"));
            Parent root = loader.load();

            Stage newStage = new Stage();
            newStage.setTitle("Ajouter un evenement");
            newStage.setScene(new Scene(root));

            newStage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            newStage.initModality(Modality.WINDOW_MODAL);

            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

