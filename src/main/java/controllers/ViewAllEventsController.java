package controllers;

import entities.Evenement;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceEvenement;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import netscape.javascript.JSObject;
import services.GeocodingService;

public class ViewAllEventsController implements Initializable {
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
    private TilePane eventsContainer;
    private Ref ref;
    @FXML
    private HBox categoriesContainer;
    @FXML
    private TextField searchField;
    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private Button selectedCategoryButton = null;
    @FXML
    private VBox mapContainer;

    private WebView webView;
    private WebEngine webEngine;


    // Ajoutez cette déclaration FXML
    @FXML
    private VBox calendarContainer;

    // Ajoutez une variable membre
    private CalendarComponent calendar;

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        loadCategories();
//        System.out.println("hello");
//        loadEvents();
//        initializeMap();
//        // Configuration du TilePane
//        eventsContainer.setPrefColumns(2); // 2 colonnes
//        eventsContainer.setHgap(20); // Espacement horizontal
//        eventsContainer.setVgap(20); // Espacement vertical
//
//        //écouteur sur le champ de recherche
//        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
//            filterEventsByName(newValue); // Filtrer les événements en temps réel
//        });
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Début initialisation...");

        // Charger les catégories d'abord (cela n'interagit pas avec la carte)
        loadCategories();

        // Configurer le TilePane
        eventsContainer.setPrefColumns(2);
        eventsContainer.setHgap(20);
        eventsContainer.setVgap(20);

        initializeCalendar();

        // Initialiser la carte simple en dernier
        initializeMap();

        // Écouteur sur le champ de recherche
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterEventsByName(newValue);
        });

        // Charger les événements
        loadEvents();

        System.out.println("Fin initialisation.");
    }

    private void loadEvents() {
        String searchText = searchField.getText(); // Récupérer le texte de recherche
        filterEventsByName(searchText); // Filtrer les événements
        try {
            eventsContainer.getChildren().clear();
            List<Evenement> evenements = serviceEvenement.afficher();
            for (Evenement event : evenements) {
                createEventCard(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showEventDetails(Evenement event) {
        try {
            // Charger la nouvelle interface FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetailsEvent&Transaction.fxml"));
            Parent root = loader.load();

            // Récupérer le contrôleur associé
            DetailsEvenementController2 detailsController = loader.getController();

            // Passer l'événement au contrôleur
            detailsController.setCurrentEvenement(event);

            // Mettre à jour l'interface utilisateur avec les détails de l'événement
            detailsController.updateUI();

            // Récupérer la scène actuelle et la fenêtre (stage)
            Scene scene = eventsContainer.getScene();
            Stage stage = (Stage) scene.getWindow();

            // Changer la scène pour afficher la nouvelle interface
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCategories() {
        try {
            // Bouton "Tous"
            Button allButton = new Button("Tous");
            allButton.getStyleClass().add("category-button");
            allButton.setMinWidth(Button.USE_PREF_SIZE);
            allButton.setPrefWidth(Button.USE_COMPUTED_SIZE);
            allButton.setMaxWidth(Button.USE_PREF_SIZE);
            allButton.setOnAction(e -> {
                updateSelectedButton(allButton);
                loadEvents();
            });
            categoriesContainer.getChildren().add(allButton);
            selectedCategoryButton = allButton;

            List<String> categories = serviceEvenement.getCategories();
            HBox buttonsContainer = new HBox(10); // Espacement de 10 entre les boutons
            buttonsContainer.setAlignment(Pos.CENTER_LEFT);

            for (String categorie : categories) {
                Button categoryButton = new Button(categorie);
                // Configuration du bouton
                categoryButton.getStyleClass().add("category-button");
                categoryButton.setMinWidth(Button.USE_PREF_SIZE);
                categoryButton.setPrefWidth(Button.USE_COMPUTED_SIZE);
                categoryButton.setMaxWidth(Button.USE_PREF_SIZE);
                categoryButton.setTextAlignment(TextAlignment.CENTER);
                categoryButton.setWrapText(false);  // Empêcher le texte de se wrapper

                categoryButton.setOnAction(e -> {
                    updateSelectedButton(categoryButton);
                    filterEventsByCategory(categorie);
                });

                buttonsContainer.getChildren().add(categoryButton);
            }

            categoriesContainer.getChildren().add(buttonsContainer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateSelectedButton(Button newSelection) {
        // Réinitialiser le style du bouton précédemment sélectionné
        if (selectedCategoryButton != null) {
            selectedCategoryButton.getStyleClass().remove("category-button-selected");
        }
        // Appliquer le style au nouveau bouton sélectionné
        newSelection.getStyleClass().add("category-button-selected");
        selectedCategoryButton = newSelection;
    }

    private void filterEventsByCategory(String category) {
        try {
            eventsContainer.getChildren().clear();

//            if (webEngine != null) {
//                webEngine.executeScript("clearMarkers()");
//            }

            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                if (event.getCategorie().equals(category) || category.equals("Tous")) {
                    // Ajouter la carte d'événement
                    createEventCard(event);

//                    // Ajouter le marqueur sur la carte
//                    double[] coordinates = GeocodingService.geocodeAddressWithCache(event.getLieu());
//                    if (coordinates != null) {
//                        String script = String.format(
//                            "addMarker(%f, %f, '%s', '%s', '%s')",
//                            coordinates[0], coordinates[1],
//                            escapeJavaScript(event.getNom()),
//                            escapeJavaScript(event.getLieu()),
//                            escapeJavaScript(event.getCategorie())
//                        );
//                        webEngine.executeScript(script);
//                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        refreshCalendar();
    }

    private void createEventCard(Evenement event) {
        // Créer deux cartes séparées au lieu d'essayer de les flip
        VBox frontCard = new VBox(10);
        frontCard.getStyleClass().add("event-card");
        frontCard.setPrefWidth(330);
        frontCard.setPrefHeight(380);
        frontCard.setPadding(new Insets(20));
        frontCard.setStyle("-fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgb(17,18,60), 10, 0, 0, 2);");

        VBox backCard = new VBox(10);
        backCard.getStyleClass().add("event-card");
        backCard.setPrefWidth(330);
        backCard.setPrefHeight(380);
        backCard.setPadding(new Insets(20));
        backCard.setAlignment(Pos.CENTER);
        backCard.setStyle("-fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgb(17,18,60), 10, 0, 0, 2);");
        backCard.setVisible(false); // Commencer avec le dos invisible

        // Container pour les deux cartes
        StackPane cardContainer = new StackPane();
        cardContainer.getChildren().addAll(frontCard, backCard);
        cardContainer.setPrefWidth(330);
        cardContainer.setPrefHeight(380);

        // * Face avant *
        // Image
        try {
            if (event.getImage_event() != null && !event.getImage_event().isEmpty()) {
                String projectPath = System.getProperty("user.dir");
                String fullPath = projectPath + "/src/main/resources/" + event.getImage_event();
                File file = new File(fullPath);
                if (file.exists()) {
                    ImageView imageView = new ImageView(new Image(file.toURI().toString()));
                    imageView.setFitWidth(300);
                    imageView.setFitHeight(200);
                    imageView.setPreserveRatio(true);
                    frontCard.getChildren().add(imageView);
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur de chargement d'image: " + e.getMessage());
        }

        // Informations de l'événement (face avant)
        Label titleLabel = new Label(event.getNom());
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
// Ajouter wrapping pour le titre
        titleLabel.setWrapText(true);
        titleLabel.setMaxWidth(250); // Ajustez cette valeur selon la largeur de votre carte

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

// Date de début
        Label dateDebutLabel = new Label("Du: " + dateFormat.format(event.getDate_debut()) + " à " + timeFormat.format(event.getDate_debut()));
        dateDebutLabel.getStyleClass().add("event-details");
        dateDebutLabel.setWrapText(true);
        dateDebutLabel.setMaxWidth(250);

// Date de fin
        Label dateFinLabel = new Label("Au: " + dateFormat.format(event.getDate_fin()) + " à " + timeFormat.format(event.getDate_fin()));
        dateFinLabel.getStyleClass().add("event-details");
        dateFinLabel.setWrapText(true);
        dateFinLabel.setMaxWidth(250);

// Lieu
        Label lieuLabel = new Label("Lieu: " + event.getLieu());
        lieuLabel.setWrapText(true);
        lieuLabel.setMaxWidth(250);

// Catégorie
        Label categorieLabel = new Label("Catégorie: " + event.getCategorie());
        categorieLabel.setStyle("-fx-text-fill: #d87769;");
        categorieLabel.setWrapText(true);
        categorieLabel.setMaxWidth(250);

        // Ajouter tous les éléments à la face avant
        frontCard.getChildren().addAll(
            titleLabel,
            dateDebutLabel,
            dateFinLabel,
            lieuLabel,
            categorieLabel
        );

        // * Face arrière *
        // Titre sur la face arrière
        Label backTitle = new Label(event.getNom());
        backTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #d87769;");
        backTitle.setWrapText(true);
        backTitle.setAlignment(Pos.CENTER);

        // Description sur la face arrière
        ScrollPane scrollDescription = new ScrollPane();
        scrollDescription.setFitToWidth(true);
        scrollDescription.setPrefHeight(200);
        scrollDescription.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        Label descriptionLabel = new Label(event.getDescription());
        descriptionLabel.setStyle("-fx-text-fill: #11123c;");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPadding(new Insets(5));

        scrollDescription.setContent(descriptionLabel);

        // Calcul du nombre de jours de l'événement
        long diffInMillies = event.getDate_fin().getTime() - event.getDate_debut().getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        String dureeTexte;

        if (diffInDays == 0) {
            // Si c'est le même jour
            dureeTexte = "Événement se déroulant sur une journée";
        } else if (diffInDays == 1) {
            dureeTexte = "Événement se déroulant sur 2 jours";
        } else {
            dureeTexte = "Événement se déroulant sur " + (diffInDays + 1) + " jours";
        }

        Label dureeLabel = new Label(dureeTexte);
        dureeLabel.getStyleClass().add("event-duration");
        dureeLabel.setStyle("-fx-font-style: italic; -fx-text-fill: #d87769;");
        dureeLabel.setWrapText(true);
        dureeLabel.setAlignment(Pos.CENTER);
        dureeLabel.setMaxWidth(260);

        // Button Détails
        Button detailsButton = new Button("Voir plus de détails");
        detailsButton.getStyleClass().add("category-button");
        detailsButton.setStyle("-fx-background-color: #d87769; -fx-text-fill: white;");
        detailsButton.setOnAction(e -> showEventDetails(event));

        // Ajouter tous les éléments à la face arrière
        backCard.getChildren().addAll(
            backTitle,
            new Separator(),
            scrollDescription,
            dureeLabel,
            new Separator(),
            detailsButton
        );

        // Gestionnaires d'événements pour le survol
        cardContainer.setOnMouseEntered(e -> {
            frontCard.setVisible(false);
            backCard.setVisible(true);
        });

        cardContainer.setOnMouseExited(e -> {
            frontCard.setVisible(true);
            backCard.setVisible(false);
        });

        // Ajouter au conteneur principal
        eventsContainer.getChildren().add(cardContainer);


    }

    private void filterEventsByName(String searchText) {
        try {
            // Effacer les cartes d'événements actuelles
            eventsContainer.getChildren().clear();

            // NE PAS effacer les marqueurs pour l'instant
            // if (webEngine != null) {
            //     webEngine.executeScript("clearMarkers()");
            // }

            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                if (event.getNom().toLowerCase().contains(searchText.toLowerCase())) {
                    // Ajouter la carte d'événement
                    createEventCard(event);

                    // NE PAS ajouter de marqueurs pour l'instant
                    // if (webEngine != null) {
                    //     double[] coordinates = GeocodingService.geocodeAddressWithCache(event.getLieu());
                    //     if (coordinates != null) {
                    //         String script = String.format(
                    //             "addMarker(%f, %f, '%s', '%s', '%s')",
                    //             coordinates[0], coordinates[1],
                    //             escapeJavaScript(event.getNom()),
                    //             escapeJavaScript(event.getLieu()),
                    //             escapeJavaScript(event.getCategorie())
                    //         );
                    //         webEngine.executeScript(script);
                    //     }
                    // }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        refreshCalendar();
    }


    public void redirectToOrganisateurPage(MouseEvent mouseEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventOrganisation.fxml"));
            Parent root = loader.load();
            Scene scene = ((Node) mouseEvent.getSource()).getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



//    private void initializeMap() {
//        // Configurer le conteneur de carte
//        mapContainer.setMinHeight(300);  // Hauteur adaptée à votre sidebar
//        mapContainer.setPrefHeight(300);
//
//        // Créer WebView
//        webView = new WebView();
//        webEngine = webView.getEngine();
//
//        // Configurer WebView
//        webView.setPrefHeight(300);
//        webView.setPrefWidth(Double.MAX_VALUE);  // Utiliser toute la largeur disponible
//
//        // Ajouter WebView au container
//        mapContainer.getChildren().add(webView);
//
//        // Configurer l'écouteur d'état
//        webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
//            System.out.println("État du chargement de la carte: " + newState);
//
//            if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
//                System.out.println("Carte chargée avec succès");
//
//                try {
//                    // Créer un pont Java-JavaScript
//                    JSObject window = (JSObject) webEngine.executeScript("window");
//                    window.setMember("javaConnector", new MapJavaConnector());
//
//                    webEngine.executeScript(
//                        "window.showEventOnMap = function(lat, lng, name, location) {" +
//                            "    if (typeof map !== 'undefined' && map !== null) {" +
//                            "        L.marker([lat, lng]).addTo(map)" +
//                            "          .bindPopup('<b>' + name + '</b><br>' + location + '<br>" +
//                            "                     <button onclick=\"javaConnector.showEventDetails(\\'' + name + '\\')\">Voir détails</button>');" +
//                            "        return true;" +
//                            "    }" +
//                            "    return false;" +
//                            "};"
//                    );
//
//                    // Charger les événements sur la carte
//                    loadEventsOnMap();
//                } catch (Exception e) {
//                    System.err.println("Erreur lors de l'initialisation de la carte:");
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        // Charger une carte Leaflet avec la variable map exposée globalement
//        String leafletHtml =
//            "<html>" +
//                "<head>" +
//                "    <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.9.4/dist/leaflet.css\" />" +
//                "    <script src=\"https://unpkg.com/leaflet@1.9.4/dist/leaflet.js\"></script>" +
//                "    <style>" +
//                "        html, body { height: 100%; margin: 0; padding: 0; }" +
//                "        #map { width: 100%; height: 100%; position: absolute; top: 0; left: 0; }" +
//                "    </style>" +
//                "</head>" +
//                "<body>" +
//                "    <div id=\"map\"></div>" +
//                "    <script>" +
//                "        // Variable globale pour la carte" +
//                "        var map;" +
//                "        window.onload = function() {" +
//                "            console.log('Initialisation de la carte...');" +
//                "            map = L.map('map').setView([46.227638, 2.213749], 5);" +
//                "            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {" +
//                "                attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'" +
//                "            }).addTo(map);" +
//                "            console.log('Carte initialisée et disponible globalement');" +
//                "            // Informer Java que la carte est prête" +
//                "            if (window.javaConnector) {" +
//                "                javaConnector.logMessage('Carte prête');" +
//                "            }" +
//                "        };" +
//                "    </script>" +
//                "</body>" +
//                "</html>";
//
//        // Configurer l'écouteur d'état
//        webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
//            System.out.println("État du chargement de la carte: " + newState);
//
//            if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
//                System.out.println("Page HTML chargée avec succès");
//
//                try {
//                    // Créer un pont Java-JavaScript
//                    JSObject window = (JSObject) webEngine.executeScript("window");
//                    window.setMember("javaConnector", new MapJavaConnector());
//
//                    // Attendre un moment pour s'assurer que la carte est initialisée
//                    Platform.runLater(() -> {
//                        try {
//                            Thread.sleep(1000);  // Attendre 1 seconde
//                            loadEventsOnMap();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    });
//                } catch (Exception e) {
//                    System.err.println("Erreur lors de l'initialisation de la carte:");
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        webEngine.loadContent(leafletHtml);
//    }

    private void initializeMap() {
        // Configuration du conteneur
        mapContainer.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1px;");
        mapContainer.setMinHeight(180);
        mapContainer.setPrefHeight(180);
        mapContainer.setMaxHeight(180);
        mapContainer.setMaxWidth(180);
        mapContainer.setPrefWidth(180);

        // Créer WebView
        webView = new WebView();
        webEngine = webView.getEngine();

        // Configurer WebView
        webView.setPrefHeight(180);
        webView.setPrefWidth(180);

        // Ajouter WebView au container
        mapContainer.getChildren().add(webView);

        // HTML avec marqueurs en forme de cercles colorés
        String mapHtml =
            "<html>" +
                "<head>" +
                "    <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.9.4/dist/leaflet.css\" />" +
                "    <script src=\"https://unpkg.com/leaflet@1.9.4/dist/leaflet.js\"></script>" +
                "    <style>" +
                "        body, html, #map { width: 100%; height: 100%; margin: 0; padding: 0; }" +
                "        .circle-marker { border-radius: 50%; width: 15px; height: 15px; }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div id=\"map\"></div>" +
                "    <script>" +
                "        var mymap = L.map('map').setView([36.8, 10.18], 9);" +
                "        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {" +
                "            attribution: '&copy; OpenStreetMap'" +
                "        }).addTo(mymap);" +
                "        " +
                "        // Fonction pour créer un marqueur circulaire coloré" +
                "        function createCircleMarker(lat, lng, color, title) {" +
                "            var circleIcon = L.divIcon({" +
                "                html: '<div style=\"background-color:' + color + '; width:15px; height:15px; border-radius:50%; border:2px solid white;\"></div>'," +
                "                className: ''," +
                "                iconSize: [19, 19]" +
                "            });" +
                "            return L.marker([lat, lng], {icon: circleIcon}).addTo(mymap).bindPopup(title);" +
                "        }" +
                "        " +
                "        // Marqueurs colorés" +
                "        createCircleMarker(36.8, 10.18, '#FF0000', '<b>Tunis</b>');" +
                "        createCircleMarker(36.4, 10.62, '#00FF00', '<b>Hammamet</b>');" +
                "        createCircleMarker(37.27, 9.87, '#0000FF', '<b>Bizerte</b>');" +
                "    </script>" +
                "</body>" +
                "</html>";

        webEngine.loadContent(mapHtml);
    }

    // Méthode de géocodage simplifiée pour les lieux tunisiens
    private double[] geocodeSimple(String lieu) {
        if (lieu == null || lieu.trim().isEmpty()) {
            return null;
        }

        String normalizedLieu = lieu.trim().toLowerCase();
        System.out.println("Géocodage de: " + normalizedLieu);

        // Table de correspondance pour les lieux courants
        HashMap<String, double[]> locations = new HashMap<>();
        locations.put("tunis", new double[]{36.8, 10.18});
        locations.put("hammamet", new double[]{36.4, 10.62});
        locations.put("bizerte", new double[]{37.27, 9.87});
        locations.put("tabarka", new double[]{36.95, 8.76});
        locations.put("marsa", new double[]{36.88, 10.32});

        // Vérifier si le lieu contient l'un des mots clés
        for (String key : locations.keySet()) {
            if (normalizedLieu.contains(key)) {
                System.out.println("Lieu reconnu: " + key + " pour " + normalizedLieu);
                return locations.get(key);
            }
        }

        // Pour les lieux non reconnus, générer des coordonnées légèrement décalées de Tunis
        // (pour les visualiser quand même sur la carte)
        double randomLat = 36.8 + (Math.random() * 0.1 - 0.05);
        double randomLng = 10.18 + (Math.random() * 0.1 - 0.05);
        System.out.println("Lieu non reconnu: " + normalizedLieu + " - coordonnées aléatoires générées");
        return new double[]{randomLat, randomLng};
    }

    private void loadEventsOnMap() {
        try {
            // Vérifier d'abord si la carte est disponible
            Boolean mapExists = (Boolean) webEngine.executeScript(
                "typeof map !== 'undefined' && map !== null"
            );

            if (!mapExists) {
                System.out.println("La carte n'est pas encore initialisée, réessai ultérieur...");
                // Réessayer après un court délai
                Platform.runLater(() -> {
                    try {
                        Thread.sleep(500);
                        loadEventsOnMap();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                return;
            }

            List<Evenement> evenements = serviceEvenement.afficher();
            System.out.println("Chargement de " + evenements.size() + " événements sur la carte");

            for (Evenement event : evenements) {
                double[] coordinates = GeocodingService.geocodeAddressWithCache(event.getLieu());
                if (coordinates != null) {
                    Boolean success = (Boolean) webEngine.executeScript(
                        "window.showEventOnMap(" +
                            coordinates[0] + ", " +
                            coordinates[1] + ", '" +
                            escapeJavaScript(event.getNom()) + "', '" +
                            escapeJavaScript(event.getLieu()) + "')"
                    );
                    if (success) {
                        System.out.println("Marqueur ajouté pour: " + event.getNom());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des événements sur la carte");
            e.printStackTrace();
        }
    }
    // Échapper les caractères spéciaux pour JavaScript
    private String escapeJavaScript(String str) {
        if (str == null) return "";
        return str.replace("\\", "\\\\")
            .replace("'", "\\'")
            .replace("\"", "\\\"")
            .replace("\n", "\\n")
            .replace("\r", "\\r");
    }

    public class MapJavaConnector {
        public void logMessage(String message) {
            System.out.println("Message reçu de JavaScript: " + message);

            // Si on reçoit le message que la carte est prête, charger les événements
            if (message.equals("Carte prête")) {
                Platform.runLater(() -> loadEventsOnMap());
            }
        }

        // Méthode appelée depuis JavaScript quand on clique sur un marqueur
        public void showEventDetails(String eventName) {
            System.out.println("Demande d'affichage des détails pour: " + eventName);
            Platform.runLater(() -> showEventDetailsFromMap(eventName));
        }
    }

    private void showEventDetailsFromMap(String eventName) {
        try {
            List<Evenement> evenements = serviceEvenement.afficher();
            for (Evenement event : evenements) {
                if (event.getNom().equals(eventName)) {
                    showEventDetails(event);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour centrer la carte sur un lieu spécifique
    public void centerMapOnLocation(String location) {
        double[] coordinates = GeocodingService.geocodeAddressWithCache(location);
        if (coordinates != null) {
            webEngine.executeScript(String.format(
                "centerMap(%f, %f, 13)",
                coordinates[0], coordinates[1]
            ));
        }
    }

    private void initializeCalendar() {
        if (calendarContainer != null) {
            calendar = new CalendarComponent(calendarContainer, serviceEvenement);
        }
    }

    // Ajoutez cette méthode pour rafraîchir le calendrier lorsque vous filtrez ou ajoutez des événements
    private void refreshCalendar() {
        if (calendar != null) {
            calendar.refreshCalendar();
        }
    }

    //////////////////////MENU//////////////////////////
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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ref.fxml"));

            //FXMLLoader loader = new FXMLLoader(getClass().getResource("/EvenementAll.fxml"));

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
/////////////////////////////////////
    /////////////////////////////////////////////////////////
}


