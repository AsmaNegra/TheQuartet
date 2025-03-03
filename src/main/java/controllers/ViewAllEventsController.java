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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import netscape.javascript.JSObject;
import services.GeocodingService;

public class ViewAllEventsController implements Initializable, CalendarComponent.DateClickHandler {
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
    @FXML
    private Label activeFilterLabel;
    @FXML
    private Button clearFilterButton;
    @FXML
    private HBox pastEventsContainer;
    @FXML
    private HBox filterContainer;

    private WebView webView;
    private WebEngine webEngine;
    private SidebarMapController sidebarMapController;
    @FXML
    private VBox calendarContainer;
    @FXML
    private HBox DateFilterLabel;

    // Ajoutez une variable membre
    private CalendarComponent calendar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCategories();
        if (filterContainer != null) {
            filterContainer.setVisible(false);
        }
        // Configurer le TilePane
        eventsContainer.setPrefColumns(2);
        eventsContainer.setHgap(15);
        eventsContainer.setVgap(15);

        initializeCalendar();

        initializeMap();


        // Écouteur sur le champ de recherche
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterEventsByName(newValue);
        });

        // Charger les événements
        loadEvents();
        Platform.runLater(() -> {
            try {
                loadPastEvents();
            } catch (Exception e) {
                System.out.println("Error loading past events: " + e.getMessage());
                e.printStackTrace();
            }
        });

    }

    // Méthode pour initialiser la carte
    private void initializeMap() {
        if (mapContainer != null) {
            sidebarMapController = new SidebarMapController(mapContainer, serviceEvenement);
        }
    }

    private void loadEvents() {
        String searchText = searchField.getText(); // Récupérer le texte de recherche
        filterEventsByName(searchText); // Filtrer les événements

        Date now = new Date();
        try {
            eventsContainer.getChildren().clear();

            // Si un texte de recherche est spécifié, utilisez la méthode de filtrage existante
            if (searchText != null && !searchText.isEmpty()) {
                filterEventsByName(searchText);
                return;
            }

            // Sinon, chargez les événements triés par nombre de vues
            List<Evenement> evenements = serviceEvenement.afficherParVues();
            for (Evenement event : evenements) {
                if(event.getDate_fin().after(now)) {
                    createEventCard(event);
                }
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

    // Dans ViewAllEventsController.java
// Modifiez la méthode updateSelectedButton ou l'événement onClick du bouton "Tous"

    private void updateSelectedButton(Button newSelection) {
        // Réinitialiser le style du bouton précédemment sélectionné
        if (selectedCategoryButton != null) {
            selectedCategoryButton.getStyleClass().remove("category-button-selected");
        }

        // Appliquer le style au nouveau bouton sélectionné
        newSelection.getStyleClass().add("category-button-selected");
        selectedCategoryButton = newSelection;

        // Vérifier si c'est le bouton "Tous" et ajuster l'alignement en conséquence
        if (newSelection.getText().equals("Tous")) {
            // Centrer les cartes d'événements
            eventsContainer.setAlignment(Pos.CENTER);
            eventsContainer.setTileAlignment(Pos.CENTER); // Si TilePane a cette méthode
        } else {
            // Restaurer l'alignement par défaut pour les autres catégories
            eventsContainer.setAlignment(Pos.TOP_LEFT);
            eventsContainer.setTileAlignment(Pos.TOP_LEFT); // Si TilePane a cette méthode
        }
    }

    private void filterEventsByCategory(String category) {
        try {
            eventsContainer.getChildren().clear();

            List<Evenement> evenements = serviceEvenement.afficher();
            Date now = new Date();

            for (Evenement event : evenements) {
                if (event.getCategorie().equals(category) || category.equals("Tous") && event.getDate_fin().after(now)) {
                    // Ajouter la carte d'événement
                    createEventCard(event);
                }
            }

            if(sidebarMapController != null) {
                sidebarMapController.filterEventsByCategory(category);
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
        frontCard.setPrefWidth(300);
        frontCard.setPrefHeight(380);
        frontCard.setPadding(new Insets(20));
        frontCard.setStyle("-fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgb(17,18,60), 10, 0, 0, 2);");

        VBox backCard = new VBox(10);
        backCard.getStyleClass().add("event-card");
        backCard.setPrefWidth(300);
        backCard.setPrefHeight(380);
        backCard.setPadding(new Insets(20));
        backCard.setAlignment(Pos.CENTER);
        backCard.setStyle("-fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgb(17,18,60), 10, 0, 0, 2);");
        backCard.setVisible(false); // Commencer avec le dos invisible

        // Container pour les deux cartes
        StackPane cardContainer = new StackPane();
        cardContainer.getChildren().addAll(frontCard, backCard);
        cardContainer.setPrefWidth(300);
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
                    imageView.setFitWidth(280);
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
            List<Evenement> evenements = serviceEvenement.afficher();
            Date now = new Date();


            for (Evenement event : evenements) {
                if (event.getNom().toLowerCase().contains(searchText.toLowerCase()) && event.getDate_fin().after(now)) {
                    // Ajouter la carte d'événement
                    createEventCard(event);
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
            calendar.setDateClickHandler(this);
        }
    }

    // Ajoutez cette méthode pour rafraîchir le calendrier lorsque vous filtrez ou ajoutez des événements
    private void refreshCalendar() {
        if (calendar != null) {
            calendar.refreshCalendar();
        }
    }

    @FXML
    private void clearFilter() {
        resetDateFilter();
        clearFilterButton.setVisible(false);

        if(calendar != null){
            calendar.clearSelection();
        }

        // Si un bouton de catégorie est sélectionné, le désélectionner
        if (selectedCategoryButton != null && !selectedCategoryButton.getText().equals("Tous")) {
            // Trouver et sélectionner le bouton "Tous"
            for (Node node : categoriesContainer.getChildren()) {
                if (node instanceof Button && ((Button) node).getText().equals("Tous")) {
                    updateSelectedButton((Button) node);
                    break;
                }
            }
        }
    }

    @Override
    public void filterEventsByDate(LocalDate date, List<Evenement> events) {
        // Filtre les événements par date
        eventsContainer.getChildren().clear();

        if (events.isEmpty()) {
            // Afficher un message quand il n'y a pas d'événements pour cette date
            Label noEventsLabel = new Label("Aucun événement pour le " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            noEventsLabel.setStyle("-fx-font-style: italic; -fx-text-fill: #645F71; -fx-font-size: 16px;");
            noEventsLabel.setAlignment(Pos.CENTER);
            noEventsLabel.setMaxWidth(Double.MAX_VALUE);
            noEventsLabel.setPadding(new Insets(50, 0, 0, 0));
            eventsContainer.getChildren().add(noEventsLabel);
        } else {
            // Afficher les événements pour cette date
            for (Evenement event : events) {
                createEventCard(event);
            }
        }

        // Mettre à jour l'indication de filtre
        if (activeFilterLabel != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            activeFilterLabel.setText("Événements du " + date.format(formatter));
            activeFilterLabel.setVisible(true);
        }

        // Rendre le conteneur et le bouton visibles
        if (filterContainer != null) {
            filterContainer.setVisible(true);
        }

        if (clearFilterButton != null) {
            clearFilterButton.setVisible(true);
        }
    }
    @Override
    public void resetDateFilter() {
        // Réinitialiser le filtre et afficher tous les événements
        loadEvents();

        // Masquer l'indication de filtre et le conteneur
        if (activeFilterLabel != null) {
            activeFilterLabel.setVisible(false);
        }

        if (filterContainer != null) {
            filterContainer.setVisible(false);
        }

        if (clearFilterButton != null) {
            clearFilterButton.setVisible(false);
        }
    }


    private void loadPastEvents() {
        try {
            // Utilisez le HBox pastEventsContainer
            if (pastEventsContainer == null) return;

            pastEventsContainer.getChildren().clear();

            // Date actuelle
            Timestamp now = new Timestamp(System.currentTimeMillis());

            // Date une semaine dans le passé
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(now.getTime());
            cal.add(Calendar.DAY_OF_YEAR, -7);
            Timestamp oneWeekAgo = new Timestamp(cal.getTimeInMillis());

            List<Evenement> allEvents = serviceEvenement.afficher();
            int eventsAdded = 0;

            for (Evenement event : allEvents) {
                // Vérifier si l'événement est terminé mais pas plus vieux qu'une semaine
                if (event.getDate_fin().before(now) && event.getDate_fin().after(oneWeekAgo)) {
                    // Créer une carte pour cet événement passé - maintenant elle sera affichée horizontalement
                    VBox pastEventCard = createPastEventCard(event);
                    pastEventsContainer.getChildren().add(pastEventCard);
                    eventsAdded++;
                }
            }

            System.out.println("Added " + eventsAdded + " past events to the container");
        } catch (Exception e) {
            System.out.println("Error in loadPastEvents: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Méthode pour créer une carte d'événement passé
    private VBox createPastEventCard(Evenement event) {
        // Créer deux cartes séparées au lieu d'essayer de les flip
        VBox frontCard = new VBox(10);
        frontCard.getStyleClass().add("event-card");
        frontCard.setPrefWidth(200);  // Taille réduite pour past events
        frontCard.setPrefHeight(220); // Taille réduite pour past events
        frontCard.setPadding(new Insets(10));
        frontCard.setStyle("-fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgb(17,18,60), 10, 0, 0, 2);");

        VBox backCard = new VBox(10);
        backCard.getStyleClass().add("event-card");
        backCard.setPrefWidth(200);  // Même taille que frontCard
        backCard.setPrefHeight(220); // Même taille que frontCard
        backCard.setPadding(new Insets(10));
        backCard.setAlignment(Pos.CENTER);
        backCard.setStyle("-fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgb(17,18,60), 10, 0, 0, 2);");
        backCard.setVisible(false); // Commencer avec le dos invisible

        // Container pour les deux cartes
        StackPane cardContainer = new StackPane();
        cardContainer.getChildren().addAll(frontCard, backCard);
        cardContainer.setPrefWidth(200);
        cardContainer.setPrefHeight(220);

        // * Face avant *
        // Image
        try {
            if (event.getImage_event() != null && !event.getImage_event().isEmpty()) {
                String projectPath = System.getProperty("user.dir");
                String fullPath = projectPath + "/src/main/resources/" + event.getImage_event();
                File file = new File(fullPath);
                if (file.exists()) {
                    ImageView imageView = new ImageView(new Image(file.toURI().toString()));
                    imageView.setFitWidth(180);
                    imageView.setFitHeight(100);
                    imageView.setPreserveRatio(true);
                    frontCard.getChildren().add(imageView);
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur de chargement d'image: " + e.getMessage());
        }

        // Informations de l'événement (face avant)
        Label titleLabel = new Label(event.getNom());
        titleLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        titleLabel.setWrapText(true);
        titleLabel.setMaxWidth(180);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Date de fin
        Label dateFinLabel = new Label("Terminé le: " + dateFormat.format(event.getDate_fin()));
        dateFinLabel.getStyleClass().add("past-event-date");
        dateFinLabel.setWrapText(true);
        dateFinLabel.setMaxWidth(180);

        // Lieu
        Label lieuLabel = new Label("Lieu: " + event.getLieu());
        lieuLabel.setWrapText(true);
        lieuLabel.setMaxWidth(180);

        // Catégorie
        Label categorieLabel = new Label("Catégorie: " + event.getCategorie());
        categorieLabel.setStyle("-fx-text-fill: #d87769;");
        categorieLabel.setWrapText(true);
        categorieLabel.setMaxWidth(180);

        // Ajouter tous les éléments à la face avant
        frontCard.getChildren().addAll(
            titleLabel,
            dateFinLabel,
            lieuLabel,
            categorieLabel
        );

        // * Face arrière *
        // Titre sur la face arrière
        Label backTitle = new Label(event.getNom());
        backTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #d87769;");
        backTitle.setWrapText(true);
        backTitle.setAlignment(Pos.CENTER);
        backTitle.setMaxWidth(180);

        // Description abrégée sur la face arrière
        ScrollPane scrollDescription = new ScrollPane();
        scrollDescription.setFitToWidth(true);
        scrollDescription.setPrefHeight(100); // Plus petite que les événements actifs
        scrollDescription.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        // On limite la description à un nombre raisonnable de caractères
        String descText = event.getDescription();
        if (descText != null && descText.length() > 150) {
            descText = descText.substring(0, 147) + "...";
        }

        Label descriptionLabel = new Label(descText);
        descriptionLabel.setStyle("-fx-text-fill: #11123c;");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPadding(new Insets(5));

        scrollDescription.setContent(descriptionLabel);

        // Boutons
        Button detailsButton = new Button("Voir détails");
        detailsButton.getStyleClass().add("category-button");
        detailsButton.setStyle("-fx-background-color: #d87769; -fx-text-fill: white;");
        detailsButton.setOnAction(e -> showEventDetails(event));

        Button archiveButton = new Button("Voir les avis");
        archiveButton.getStyleClass().add("avis-button");
        archiveButton.setStyle("-fx-background-color: #11123c; -fx-text-fill: white;");
        archiveButton.setOnAction(e -> {
            try {
                // Load the feedback page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventFeedback.fxml"));
                Parent root = loader.load();

                // Get the controller and set the current event
                EventFeedbackController feedbackController = loader.getController();
                feedbackController.setCurrentEvent(event);

                // Navigate to the feedback page
                Scene scene = ((Node) e.getSource()).getScene();
                Stage stage = (Stage) scene.getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                System.err.println("Error loading feedback page: " + ex.getMessage());
                ex.printStackTrace();

                // Show error alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Impossible d'ouvrir la page des avis");
                alert.setContentText("Une erreur s'est produite lors du chargement de la page des avis: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        // Ajouter tous les éléments à la face arrière
        backCard.getChildren().addAll(
            backTitle,
            new Separator(),
            scrollDescription,
            new Separator(),
            detailsButton,
            archiveButton
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

        // Retourner le StackPane directement
        return new VBox(cardContainer);
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


