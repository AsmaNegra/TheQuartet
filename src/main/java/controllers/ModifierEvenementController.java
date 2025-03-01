package controllers;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Evenement;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javafx.stage.Stage;
import javafx.util.Duration;
import netscape.javascript.JSObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import services.ServiceCategorie;
import services.ServiceEvenement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import utils.AiUtility;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

public class ModifierEvenementController {

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
        private Label AjouterEvent;

        @FXML
        private Label budgetEvent;

        @FXML
        private Label categorieEvent;

        @FXML
        private Button choisirImageButton;

        @FXML
        private Label date_debutEvent;

        @FXML
        private Label date_finEvent;

        @FXML
        private Label descriptionEvent;

        @FXML
        private TextField evenementBudgetField;

        @FXML
        private ComboBox<String> evenementCategorieComboBox;

        @FXML
        private DatePicker evenementDateDebutPicker;

        @FXML
        private DatePicker evenementDateFinPicker;

        @FXML
        private TextArea evenementDescriptionArea;

        @FXML
        private Button evenementFermerButton;

        @FXML
        private Spinner<String> evenementHeureDebutField;

        @FXML
        private Spinner<String> evenementHeureFinField;

        @FXML
        private TextField evenementImageField;

        @FXML
        private TextField evenementLieuField;

        @FXML
        private Button evenementModifierButton;

        @FXML
        private TextField evenementNbPlacesField;

        @FXML
        private TextField evenementNomField;

        @FXML
        private ImageView imagePreview;

        @FXML
        private Label image_event;

        @FXML
        private Label lieuEvent;

        @FXML
        private Label nb_placesEvent;

        @FXML
        private Label nomEvent;

        private File selectedImageFile;

    @FXML
    private AnchorPane lieuContainer;

    @FXML
    private WebView mapWebView;
    private WebEngine webEngine;

    private OkHttpClient client = new OkHttpClient();
    private ListView<String> placeSuggestions;
    private String googleApiKey = "AIzaSyDVp922yWQ9Dt6P3QzYFaB0VCRzNIfpPA8";
    private PauseTransition pause = new PauseTransition(Duration.millis(300));




    private Evenement evenementToModify; // Pour stocker l'événement à modifier

    public void setEvenement(Evenement evenement) {
        this.evenementToModify = evenement;
        populateFields();
    }

    private void populateFields() {
        if (evenementToModify != null) {
            evenementNomField.setText(evenementToModify.getNom());
            evenementDescriptionArea.setText(evenementToModify.getDescription());

            // Conversion et affichage des dates
            Timestamp timestampDebut = (Timestamp) evenementToModify.getDate_debut();
            Timestamp timestampFin = (Timestamp) evenementToModify.getDate_fin();

            LocalDateTime dateTimeDebut = timestampDebut.toLocalDateTime();
            LocalDateTime dateTimeFin = timestampFin.toLocalDateTime();

            evenementDateDebutPicker.setValue(dateTimeDebut.toLocalDate());
            evenementDateFinPicker.setValue(dateTimeFin.toLocalDate());

            evenementHeureDebutField.getValueFactory().setValue(dateTimeDebut.format(DateTimeFormatter.ofPattern("HH:mm")));
            evenementHeureFinField.getValueFactory().setValue(dateTimeFin.format(DateTimeFormatter.ofPattern("HH:mm")));

            evenementLieuField.setText(evenementToModify.getLieu());
            evenementCategorieComboBox.setValue(evenementToModify.getCategorie());
            evenementBudgetField.setText(String.valueOf(evenementToModify.getBudget()));

            evenementImageField.setText(evenementToModify.getImage_event());

            // Ajoutez le chargement de l'image existante
            if (evenementToModify.getImage_event() != null) {
                String imagePath = "src/main/resources/" + evenementToModify.getImage_event();
                Image image = new Image(new File(imagePath).toURI().toString());
                imagePreview.setImage(image);
            }

            evenementNbPlacesField.setText(String.valueOf(evenementToModify.getNb_places()));

        }
    }

    private SpinnerValueFactory<String> createTimeSpinnerValueFactory() {
        return new SpinnerValueFactory<String>() {
            private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            {
                setValue("12:00");
            }

            @Override
            public void decrement(int steps) {
                try {
                    LocalTime time = LocalTime.parse(getValue(), formatter);
                    setValue(time.minusMinutes(15).format(formatter));
                } catch (Exception e) {
                    setValue("12:00");
                }
            }

            @Override
            public void increment(int steps) {
                try {
                    LocalTime time = LocalTime.parse(getValue(), formatter);
                    setValue(time.plusMinutes(15).format(formatter));
                } catch (Exception e) {
                    setValue("12:00");
                }
            }
        };
    }

    @FXML
    public void initialize() {
        // Configuration des formatters pour n'accepter que des chiffres
        evenementBudgetField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            }
            return null;
        }));

        evenementNbPlacesField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            }
            return null;
        }));

        // Configuration des spinners d'heure
        SpinnerValueFactory<String> heureDebutFactory = createTimeSpinnerValueFactory();
        SpinnerValueFactory<String> heureFinFactory = createTimeSpinnerValueFactory();

        evenementHeureDebutField.setValueFactory(heureDebutFactory);
        evenementHeureFinField.setValueFactory(heureFinFactory);

        // Ajout des TextFormatters pour valider la saisie manuelle
        evenementHeureDebutField.getEditor().setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
                return change;
            }
            return null;
        }));

        evenementHeureFinField.getEditor().setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
                return change;
            }
            return null;
        }));

        // Chargement des catégories
        try {
            ServiceCategorie serviceCategorie = new ServiceCategorie();
            List<String> categories = serviceCategorie.getAllCategories();
            evenementCategorieComboBox.getItems().clear();
            evenementCategorieComboBox.getItems().addAll(categories);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors du chargement des catégories : " + e.getMessage());
            alert.showAndWait();
        }

        // Configuration du WebView et du moteur JavaScript pour Google Maps
        if (mapWebView != null) {
            webEngine = mapWebView.getEngine();
            webEngine.setJavaScriptEnabled(true);

            // Charger la page HTML pour Google Maps
            String htmlPath = getClass().getResource("/maps_autocomplete.html").toExternalForm();
            webEngine.load(htmlPath);

            // Initialiser le pont Java-JavaScript
            webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == Worker.State.SUCCEEDED) {
                    try {
                        JSObject window = (JSObject) webEngine.executeScript("window");
                        window.setMember("javaConnector", new JavaConnector());
                    } catch (Exception e) {
                        System.err.println("Erreur lors de l'initialisation: " + e.getMessage());
                    }
                }
            });

            // Cacher la carte initialement
            mapWebView.setVisible(false);
            mapWebView.setPrefHeight(0);

            // Créer une liste pour les suggestions
            placeSuggestions = new ListView<>();
            placeSuggestions.setPrefHeight(0);
            placeSuggestions.setVisible(false);
            placeSuggestions.getStyleClass().add("place-suggestions");

            // Ajouter la liste au conteneur si lieuContainer est présent
            if (lieuContainer != null) {
                // Configurer le conteneur
                lieuContainer.setMinHeight(40);

                // Ajouter la liste au conteneur
                AnchorPane.setLeftAnchor(placeSuggestions, 0.0);
                AnchorPane.setRightAnchor(placeSuggestions, 0.0);
                AnchorPane.setTopAnchor(placeSuggestions, evenementLieuField.getPrefHeight());
                lieuContainer.getChildren().add(placeSuggestions);

                // Positionner le champ de texte
                AnchorPane.setTopAnchor(evenementLieuField, 0.0);
                AnchorPane.setLeftAnchor(evenementLieuField, 0.0);
                AnchorPane.setRightAnchor(evenementLieuField, 0.0);
            }

            // Délai pour la recherche
            pause = new PauseTransition(Duration.millis(300));
            pause.setOnFinished(e -> {
                String searchText = evenementLieuField.getText();
                if (searchText.length() > 2) {
                    // Rechercher des suggestions
                    fetchPlaceSuggestions(searchText);

                    // Cacher la carte pendant la recherche
                    mapWebView.setVisible(false);
                    mapWebView.setPrefHeight(0);
                } else {
                    placeSuggestions.setVisible(false);
                    placeSuggestions.setPrefHeight(0);
                }
            });

            // Écouter les changements dans le champ de lieu
            evenementLieuField.textProperty().addListener((observable, oldValue, newValue) -> {
                pause.playFromStart();
            });

            // Action lorsqu'un lieu est sélectionné dans la liste
            placeSuggestions.setOnMouseClicked(event -> {
                String selectedPlace = placeSuggestions.getSelectionModel().getSelectedItem();
                if (selectedPlace != null) {
                    // Mettre à jour le champ
                    evenementLieuField.setText(selectedPlace);

                    // Masquer les suggestions
                    placeSuggestions.setVisible(false);
                    placeSuggestions.setPrefHeight(0);

                    // Afficher la carte avec le lieu sélectionné
                    showMap(selectedPlace);
                }
            });
        }
    }

    // Méthode pour obtenir des suggestions de lieux
    private void fetchPlaceSuggestions(String input) {
        try {
            String encodedInput = URLEncoder.encode(input, StandardCharsets.UTF_8.toString());
            String url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + encodedInput +
                "&key=" + googleApiKey + "&types=establishment&language=fr";

            Request request = new Request.Builder()
                .url(url)
                .build();

            // Exécuter la requête dans un thread séparé
            new Thread(() -> {
                try (Response response = client.newCall(request).execute()) {
                    if (response.isSuccessful()) {
                        String jsonData = response.body().string();
                        JSONObject jsonObject = new JSONObject(jsonData);
                        JSONArray predictions = jsonObject.getJSONArray("predictions");

                        ObservableList<String> suggestions = FXCollections.observableArrayList();
                        for (int i = 0; i < predictions.length(); i++) {
                            JSONObject prediction = predictions.getJSONObject(i);
                            suggestions.add(prediction.getString("description"));
                        }

                        // Mettre à jour l'UI dans le thread JavaFX
                        Platform.runLater(() -> {
                            placeSuggestions.setItems(suggestions);
                            if (!suggestions.isEmpty()) {
                                placeSuggestions.setPrefHeight(Math.min(suggestions.size() * 24, 150));
                                placeSuggestions.setVisible(true);
                            } else {
                                placeSuggestions.setVisible(false);
                                placeSuggestions.setPrefHeight(0);
                            }
                        });
                    }
                } catch (Exception e) {
                    System.err.println("Exception: " + e.getMessage());
                }
            }).start();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    // Méthode pour afficher la carte APRÈS la sélection d'un lieu
    private void showMap(String place) {
        // Afficher la carte
        mapWebView.setVisible(true);
        mapWebView.setPrefHeight(400);

        // Force le rendu
        mapWebView.requestLayout();

        // Rechercher le lieu sur la carte
        try {
            String escapedPlace = place.replace("'", "\\'");
            webEngine.executeScript("searchPlace('" + escapedPlace + "');");
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche sur la carte: " + e.getMessage());
        }
    }

    // Classe JavaConnector pour la communication avec JavaScript
    public class JavaConnector {
        public void onPlaceSelected(String name, String address, double lat, double lng) {
            // Ne rien faire ici, puisque nous avons déjà le lieu dans le champ
            System.out.println("Lieu confirmé sur la carte: " + name);
        }
    }
    @FXML
    void choisirImage(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choisir une image");

            // Configurer les filtres pour n'accepter que les images
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );

            // Ouvrir le sélecteur de fichier
            File file = fileChooser.showOpenDialog(choisirImageButton.getScene().getWindow());

            if (file != null) {
                try {
                    // Créer le dossier d'images s'il n'existe pas
                    String uploadDir = "src/main/resources/images/events";
                    Path uploadPath = Paths.get(uploadDir);
                    if (!Files.exists(uploadPath)) {
                        Files.createDirectories(uploadPath);
                    }

                    // Générer un nom unique pour l'image
                    String uniqueFileName = System.currentTimeMillis() + "_" + file.getName();
                    Path destinationPath = uploadPath.resolve(uniqueFileName);

                    // Copier l'image dans le dossier du projet
                    Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

                    // Mettre à jour le champ de texte avec le chemin relatif
                    evenementImageField.setText("images/events/" + uniqueFileName);

                    // Afficher l'aperçu de l'image
                    Image image = new Image(file.toURI().toString());
                    imagePreview.setImage(image);

                    selectedImageFile = file;

                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Erreur lors de la copie de l'image : " + e.getMessage());
                    alert.showAndWait();
                }
            }
        }

    @FXML
    void modifierEvenement(ActionEvent event) {
        try {
            // Vérification que tous les champs sont remplis
            if (evenementNomField.getText().isEmpty() ||
                evenementDescriptionArea.getText().isEmpty() ||
                evenementDateDebutPicker.getValue() == null ||
                evenementDateFinPicker.getValue() == null ||
                evenementLieuField.getText().isEmpty() ||
                evenementCategorieComboBox.getValue() == null ||
                evenementBudgetField.getText().isEmpty() ||
                evenementImageField.getText().isEmpty() ||
                evenementNbPlacesField.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs et sélectionner une image.");
                alert.showAndWait();
                return;
            }

            // Récupération des valeurs et création des timestamps comme dans AjouterEvenement
            LocalDate dateDebut = evenementDateDebutPicker.getValue();
            LocalDate dateFin = evenementDateFinPicker.getValue();
            LocalTime heureDebut = LocalTime.parse(evenementHeureDebutField.getValue());
            LocalTime heureFin = LocalTime.parse(evenementHeureFinField.getValue());

            LocalDateTime dateTimeDebut = dateDebut.atTime(heureDebut);
            LocalDateTime dateTimeFin = dateFin.atTime(heureFin);

            Timestamp timestampDebut = Timestamp.valueOf(dateTimeDebut);
            Timestamp timestampFin = Timestamp.valueOf(dateTimeFin);

            // Mise à jour de l'événement
            evenementToModify.setNom(evenementNomField.getText());
            evenementToModify.setDescription(evenementDescriptionArea.getText());
            evenementToModify.setDate_debut(timestampDebut);
            evenementToModify.setDate_fin(timestampFin);
            evenementToModify.setLieu(evenementLieuField.getText());
            evenementToModify.setCategorie(evenementCategorieComboBox.getValue());
            evenementToModify.setBudget(Float.parseFloat(evenementBudgetField.getText()));
            evenementToModify.setImage_event(evenementImageField.getText());
            evenementToModify.setNb_places(Integer.parseInt(evenementNbPlacesField.getText()));

            // Sauvegarde des modifications
            ServiceEvenement serviceEvenement = new ServiceEvenement();
            try {
                serviceEvenement.modifier(evenementToModify);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Événement modifié avec succès !");
                successAlert.showAndWait();

                Stage stage = (Stage) evenementModifierButton.getScene().getWindow();
                stage.close();

                // Affichage des détails mis à jour
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetailsEvenement.fxml"));
                Parent root = loader.load();
                DetailsEvenement dec = loader.getController();

                dec.setResNom(evenementToModify.getNom());
                dec.setResDescription(evenementToModify.getDescription());
                dec.setResDateDebut(evenementToModify.getDate_debut().toString());
                dec.setResDateFin(evenementToModify.getDate_fin().toString());
                dec.setResLieu(evenementToModify.getLieu());
                dec.setResCategorie(evenementToModify.getCategorie());
                dec.setResBudget(String.valueOf(evenementToModify.getBudget()));
                dec.setResImageEvent(evenementToModify.getImage_event());
                dec.setResNbPlaces(String.valueOf(evenementToModify.getNb_places()));

                evenementModifierButton.getScene().setRoot(root);
            } catch (SQLException e) {
                if (e.getMessage().contains("existe déjà")) {
                    // Si l'erreur est liée à un événement qui existe déjà
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                } else {
                    // Pour les autres erreurs SQL
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Une erreur s'est produite : " + e.getMessage());
                    alert.showAndWait();
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite : " + e.getMessage());
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

    @FXML
    void genererDescription(ActionEvent event) {
        // Vérifier que les champs nécessaires sont remplis
        if (evenementNomField.getText().isEmpty() ||
            evenementCategorieComboBox.getValue() == null ||
            evenementLieuField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informations manquantes");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez d'abord remplir le nom, la catégorie et le lieu de l'événement pour générer une description.");
            alert.showAndWait();
            return;
        }

        // Montrer un indicateur de chargement
        Button sourceButton = (Button) event.getSource();
        String originalText = sourceButton.getText();
        FontAwesomeIconView originalIcon = (FontAwesomeIconView) sourceButton.getGraphic();

        sourceButton.setText("...");
        FontAwesomeIconView spinnerIcon = new FontAwesomeIconView(FontAwesomeIcon.SPINNER);
        spinnerIcon.setFill(Color.WHITE);
        spinnerIcon.setSize("1.2em");
        sourceButton.setGraphic(spinnerIcon);
        sourceButton.setDisable(true);

        // Appel à l'API dans un thread séparé pour ne pas bloquer l'interface
        Task<String> task = new Task<String>() {
            @Override
            protected String call() throws Exception {
                return AiUtility.generateEventDescription(
                    evenementNomField.getText(),
                    evenementCategorieComboBox.getValue(),
                    evenementLieuField.getText()
                );
            }
        };

        task.setOnSucceeded(e -> {
            evenementDescriptionArea.setText(task.getValue());
            sourceButton.setText(originalText);
            sourceButton.setGraphic(originalIcon);
            sourceButton.setDisable(false);
        });

        task.setOnFailed(e -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de la génération de la description: " + task.getException().getMessage());
            alert.showAndWait();

            sourceButton.setText(originalText);
            sourceButton.setGraphic(originalIcon);
            sourceButton.setDisable(false);
        });

        new Thread(task).start();
    }

}


