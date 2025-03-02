package controllers;

import entities.Evenement;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Worker;
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
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javafx.scene.layout.AnchorPane;
import netscape.javascript.JSObject;

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
    @FXML
    private WebView locationMapView;

    @FXML
    private AnchorPane mapContainer;

    private WebEngine webEngine;

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

        // Initialiser le WebView pour la carte
        if (locationMapView != null) {
            webEngine = locationMapView.getEngine();
            webEngine.setJavaScriptEnabled(true);

            // Masquer initialement la carte
            mapContainer.setVisible(false);
            mapContainer.setManaged(false);

            // Charger le fichier HTML de la carte
            String mapHtmlPath = getClass().getResource("/location_map.html").toExternalForm();
            System.out.println("Chargement de la carte depuis: " + mapHtmlPath);
            webEngine.load(mapHtmlPath);

            // Configurer un listener pour le chargement de la page
            webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == Worker.State.SUCCEEDED) {
                    System.out.println("La page HTML de la carte a été chargée avec succès");
                    // Créer un pont Java-JavaScript
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    window.setMember("javaConnector", new JavaConnector());

                    // Si nous avons déjà un événement à afficher, mettre à jour la carte
                    if (currentEvenement != null) {
                        loadMapForEvent();
                    }
                } else if (newState == Worker.State.FAILED) {
                    System.err.println("Échec de chargement de la carte");
                }
            });
        }
    }

    // Ajoutez une classe interne pour la communication avec JavaScript
    public class JavaConnector {
        public void onLocationFound(boolean success, String name, String address) {
            if (success) {
                System.out.println("Localisation trouvée: " + name + " à " + address);
            } else {
                System.err.println("Impossible de trouver la localisation sur la carte");
            }
        }
    }

    // Méthode pour charger la carte pour l'événement courant
    private void loadMapForEvent() {
        if (currentEvenement != null && locationMapView != null) {
            String location = currentEvenement.getLieu();
            if (location != null && !location.isEmpty()) {
                // Rendre la carte visible
                mapContainer.setVisible(true);
                mapContainer.setManaged(true);

                try {
                    // Échapper les caractères spéciaux dans le nom et l'adresse
                    String escapedLocation = location.replace("'", "\\'");
                    String escapedName = currentEvenement.getNom().replace("'", "\\'");

                    // Préparer un message de statut si nécessaire (optionnel)
                    String status = ""; // Exemple: "Boutique fermée actuellement, réouverture dimanche à 10:00"
                    String escapedStatus = status.replace("'", "\\'");

                    // Exécuter la recherche via JavaScript
                    String script = "searchLocation('" + escapedLocation + "', '" + escapedName + "', '" + escapedStatus + "')";
                    webEngine.executeScript(script);
                } catch (Exception e) {
                    System.err.println("Erreur lors de l'exécution du script de carte: " + e.getMessage());
                }
            } else {
                // Masquer la carte si pas de lieu
                mapContainer.setVisible(false);
                mapContainer.setManaged(false);
            }
        }
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

            // Afficher le lieu
            String location = currentEvenement.getLieu();
            eventLocationLabel.setText("Location: " + currentEvenement.getLieu());

            // Charger la carte avec l'adresse du lieu
            if (webEngine != null && webEngine.getLoadWorker().getState() == Worker.State.SUCCEEDED) {
                loadMapForEvent();
            }

            // Charger la carte avec l'adresse du lieu
            if (location != null && !location.isEmpty()) {
                loadGoogleMap(location);
            } else {
                // Masquer la carte si pas de lieu spécifié
                mapContainer.setVisible(false);
                mapContainer.setManaged(false);
            }

        } else {
            System.err.println("Aucun événement n'est défini pour afficher les détails.");
        }
    }

    private void loadGoogleMap(String location) {
        try {
            // Afficher le conteneur de carte
            mapContainer.setVisible(true);
            mapContainer.setManaged(true);

            // Charger le fichier HTML
            String mapHtmlPath = getClass().getResource("/location_map.html").toExternalForm();
            webEngine.load(mapHtmlPath);

            // Configurer un écouteur pour exécuter le script après le chargement de la page
            webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == Worker.State.SUCCEEDED) {
                    // Créer un pont Java-JavaScript
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    window.setMember("javaConnector", new JavaConnector());

                    // Rechercher l'adresse
                    webEngine.executeScript("searchLocation('" + location.replace("'", "\\'") + "')");
                }
            });
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de la carte: " + e.getMessage());
            e.printStackTrace();
            mapContainer.setVisible(false);
            mapContainer.setManaged(false);
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
