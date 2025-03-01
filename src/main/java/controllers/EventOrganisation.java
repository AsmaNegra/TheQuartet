package controllers;

import entities.Evenement;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceEvenement;
import services.ServiceTache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventOrganisation {
    @FXML
    private Text nbrEvents;

    @FXML
    private Text nbrTaches;

    @FXML
    private Text nbrTachesRetard;

    @FXML
    private Text nbrTickets;

    //BOUTTON MENU//

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
    ////////////////
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
///////CHARTS NOUR////
    @FXML
    private BarChart<String, Number> taskChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private final ServiceTache serviceTache = new ServiceTache();
    ////////////
    /////DISCOVER////
    @FXML
    private Label lblPersonnalite;

    @FXML
    private Circle circlePersonnalite;

    @FXML
    private StackPane circleContainer;
    ////////
    @FXML
    public void initialize() {
        loadEvents();
loadChartData();
//        refreshTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event-> loadEvents()));
//        refreshTimeline.setCycleCount(Timeline.INDEFINITE);
//        refreshTimeline.play();
        try {
            // nbrEvents.setText(String.valueOf(serviceEvenement.getTotalEvenementsUtilisateur(utilisateurId)));
            nbrTaches.setText(String.valueOf(serviceTache.getTotalTachesUtilisateur(5)));
            nbrTachesRetard.setText(String.valueOf(serviceTache.getTachesEnRetardUtilisateur(5)));

            // 🔹 Simulation pour le nombre de tickets (remplace avec une vraie fonction)
         //   nbrTickets.setText(String.valueOf(getNombreTickets(utilisateurId)));

        } catch (SQLException e) {
            e.printStackTrace();
           // nbrEvents.setText("Erreur");
            nbrTaches.setText("Erreur");
            nbrTachesRetard.setText("Erreur");
          //  nbrTickets.setText("Erreur");
        }


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
            ServiceEvenement serviceEvenement = new ServiceEvenement();
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

    public void redirectToHomePage(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
            Parent root = loader.load();
            Scene scene = ((Node) mouseEvent.getSource()).getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////MENU///////////////////////////////////////////////////////////////////////
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
    //////////////////////////////////////////////////////////////////////////
/////////////////////////API CHARTS NOUR//////////////////////////////////////////
    private void loadChartData() {
        try {
            // Retrieve KPI data from ServiceTache
            Map<String, Map<String, Object>> kpiData = serviceTache.getKpiFournisseurs();

            // Convert to List and sort by total tasks (Descending)
            List<Map.Entry<String, Map<String, Object>>> sortedList = new ArrayList<>(kpiData.entrySet());
            sortedList.sort((a, b) -> Integer.compare((int) b.getValue().get("total_taches"), (int) a.getValue().get("total_taches")));

            // Keep only the top 5 suppliers
            sortedList = sortedList.subList(0, Math.min(sortedList.size(), 5));

            XYChart.Series<String, Number> seriesTasks = new XYChart.Series<>();
            seriesTasks.setName("Total Tâches");

            XYChart.Series<String, Number> seriesCompleted = new XYChart.Series<>();
            seriesCompleted.setName("Tâches Terminées");

            for (Map.Entry<String, Map<String, Object>> entry : sortedList) {
                String fournisseur = entry.getKey();
                int totalTasks = (int) entry.getValue().get("total_taches");
                int completedTasks = (int) entry.getValue().get("taches_terminees");

                XYChart.Data<String, Number> totalData = new XYChart.Data<>(fournisseur, totalTasks);
                XYChart.Data<String, Number> completedData = new XYChart.Data<>(fournisseur, completedTasks);

                seriesTasks.getData().add(totalData);
                seriesCompleted.getData().add(completedData);
            }

            taskChart.getData().addAll(seriesTasks, seriesCompleted);

            // Animate bars from bottom to top
            animateBars();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** 📌 Animation to make bars grow from bottom to top */
    private void animateBars() {
        for (XYChart.Series<String, Number> series : taskChart.getData()) {
            for (XYChart.Data<String, Number> data : series.getData()) {
                data.getNode().setScaleY(0);
                data.getNode().setTranslateY(0);

                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), data.getNode());
                scaleTransition.setFromY(0);
                scaleTransition.setToY(1);
                scaleTransition.play();
            }
        }
    }
    //////////////////////////////////////////////////////
    /////////////DISCOVER YOUR PERSONALITY/////////////////
    @FXML
    private void decouvrirPersonnalite() {
        lblPersonnalite.setText("⏳ Calcul en cours...");
        lblPersonnalite.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-alignment: center;");

        // Lancer l'animation de pulsation (effet big & small)
        animateLoading();

        // Ajoute un délai de 2 secondes pour afficher la personnalité
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> afficherPersonnalite());
        pause.play();
    }

    /** 📌 Animation de pulsation du cercle */
    private void animateLoading() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), circleContainer);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setCycleCount(6);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    /** 📌 Fonction pour afficher la personnalité avec une couleur dynamique */
    private void afficherPersonnalite() {
        try {
            int TacheId = 5; // Remplace avec l'ID de l'Tache actuel
            String personnalite = serviceTache.analyserPersonnaliteUtilisateur(TacheId);

            lblPersonnalite.setText(personnalite);
            lblPersonnalite.setStyle("-fx-font-size: 18px; -fx-text-fill: #1b1b1b; -fx-font-weight: bold; -fx-text-alignment: center;");

            // 🎨 Appliquer une couleur en fonction de la personnalité
            if (personnalite.contains("🏆")) {
                circlePersonnalite.setStyle("-fx-fill: rgba(46, 204, 113, 0.7);"); // Vert
            } else if (personnalite.contains("🔥")) {
                circlePersonnalite.setStyle("-fx-fill: rgba(243, 156, 18, 0.7);"); // Orange
            } else if (personnalite.contains("⚖")) {
                circlePersonnalite.setStyle("-fx-fill: rgba(52, 152, 219, 0.7);"); // Bleu
            } else if (personnalite.contains("⏳")) {
                circlePersonnalite.setStyle("-fx-fill: rgba(231, 76, 60, 0.7);"); // Rouge
            } else if (personnalite.contains("🐢")) {
                circlePersonnalite.setStyle("-fx-fill: rgba(142, 68, 173, 0.7);"); // Violet
            } else {
                circlePersonnalite.setStyle("-fx-fill: rgba(90, 95, 125, 0.7);"); // Gris
            }

        } catch (SQLException e) {
            lblPersonnalite.setText("❌ Erreur !");
            lblPersonnalite.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////
}

