package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Evenement;

import java.sql.Timestamp;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
import services.ServiceCategorie;
import services.ServiceEvenement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javafx.fxml.FXML;
import services.ServiceUtilisateurEvenement;
import utils.AiUtility;

public class AjouterEvenementController {

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
    private TextField evenementNomField;

    @FXML
    private TextArea evenementDescriptionArea;

    @FXML
    private DatePicker evenementDateDebutPicker;

    @FXML
    private Spinner<String> evenementHeureDebutField;

    @FXML
    private DatePicker evenementDateFinPicker;

    @FXML
    private Spinner<String> evenementHeureFinField;

    @FXML
    private TextField evenementLieuField;

    @FXML
    private ComboBox<String> evenementCategorieComboBox;

    @FXML
    private TextField evenementBudgetField;

    @FXML
    private TextField evenementImageField;

    @FXML
    private TextField evenementNbPlacesField;

    @FXML
    private Button evenementAjouterButton;

    @FXML
    private Button evenementFermerButton;

    @FXML
    private Button choisirImageButton;

    @FXML
    private ImageView imagePreview;

    private File selectedImageFile;

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

    private void afficherAlerte(String titre, String header, String contenu) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setHeaderText(header);
        alert.setContentText(contenu);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {

        // Configuration pour le champ budget
        evenementBudgetField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            }
            return null;
        }));

        // Configuration pour le champ nombre de places
        evenementNbPlacesField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            }
            return null;
        }));

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // Configuration du Spinner pour l'heure de début
        SpinnerValueFactory<String> heureDebutFactory = new SpinnerValueFactory<String>() {
            {
                setValue("12:00");
            }

            @Override
            public void decrement(int steps) {
                try {
                    LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                    setValue(time.minusMinutes(1).format(timeFormatter));
                } catch (Exception e) {
                    setValue("12:00");
                }
            }

            @Override
            public void increment(int steps) {
                try {
                    LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                    setValue(time.plusMinutes(1).format(timeFormatter));
                } catch (Exception e) {
                    setValue("12:00");
                }
            }
        };

        // Configuration du Spinner pour l'heure de fin
        SpinnerValueFactory<String> heureFinFactory = new SpinnerValueFactory<String>() {
            {
                setValue("00:00");
            }

            @Override
            public void decrement(int steps) {
                try {
                    LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                    setValue(time.minusMinutes(1).format(timeFormatter));
                } catch (Exception e) {
                    setValue("00:00");
                }
            }

            @Override
            public void increment(int steps) {
                try {
                    LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                    setValue(time.plusMinutes(1).format(timeFormatter));
                } catch (Exception e) {
                    setValue("00:00");
                }
            }
        };

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

        LocalDate aujourdhui = LocalDate.now();

        evenementDateDebutPicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(aujourdhui));
            }
        });

        evenementDateFinPicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate dateDebut = evenementDateDebutPicker.getValue();
                setDisable(empty || date.isBefore(aujourdhui) ||
                    (dateDebut != null && date.isBefore(dateDebut)));
            }
        });

        evenementDateDebutPicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                LocalDate dateFin = evenementDateFinPicker.getValue();
                if (dateFin != null && dateFin.isBefore(newVal)) {
                    evenementDateFinPicker.setValue(newVal);
                }
            }
        });

        // Chargement des catégories dans le ComboBox
        try {
            ServiceCategorie serviceCategorie = new ServiceCategorie();
            List<String> categories = serviceCategorie.getAllCategories();
            evenementCategorieComboBox.getItems().clear();
            evenementCategorieComboBox.getItems().addAll(categories);

            // Optionnel : sélectionner la première catégorie par défaut
            if (!categories.isEmpty()) {
                evenementCategorieComboBox.setValue(categories.get(0));
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors du chargement des catégories : " + e.getMessage());
            alert.showAndWait();
        }
    }


    @FXML
    void ajouterEvenement(ActionEvent event) {
        if (!validerDates()) {
            return;
        }
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

            // Récupération des valeurs
            LocalDate dateDebut = evenementDateDebutPicker.getValue();
            LocalDate dateFin = evenementDateFinPicker.getValue();

            // Parsing des heures et minutes
            LocalTime heureDebut = LocalTime.parse(evenementHeureDebutField.getValue());
            LocalTime heureFin = LocalTime.parse(evenementHeureFinField.getValue());

            // Création des LocalDateTime
            LocalDateTime dateTimeDebut = dateDebut.atTime(heureDebut);
            LocalDateTime dateTimeFin = dateFin.atTime(heureFin);

            // Conversion en Timestamp
            Timestamp timestampDebut = Timestamp.valueOf(dateTimeDebut);
            Timestamp timestampFin = Timestamp.valueOf(dateTimeFin);

            String imagePath = evenementImageField.getText();

            // Création de l'événement avec Timestamp
            Evenement evenement = new Evenement(
                evenementNomField.getText(),
                evenementDescriptionArea.getText(),
                timestampDebut,
                timestampFin,
                evenementLieuField.getText(),
                evenementCategorieComboBox.getValue(),
                Float.parseFloat(evenementBudgetField.getText()),
                imagePath,
                Integer.parseInt(evenementNbPlacesField.getText())
            );

            // Sauvegarde dans la base de données
            ServiceEvenement serviceEvenement = new ServiceEvenement();
            try {
                serviceEvenement.ajouter(evenement);

                // Ajout dans la table d'association avec l'utilisateur connecté
                // Pour cet exemple, j'utilise l'ID 1 comme utilisateur connecté
                ServiceUtilisateurEvenement serviceUtilisateurEvenement = new ServiceUtilisateurEvenement();
                serviceUtilisateurEvenement.inscrireUtilisateurAEvenement(1, evenement.getEvenement_id());

                // Afficher un message de succès
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Succès");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Événement ajouté avec succès !");
                successAlert.showAndWait();

                Stage stage = (Stage) evenementAjouterButton.getScene().getWindow();
                stage.close();

                // Charger l'interface DetailsEvenement.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetailsEvenement.fxml"));
                Parent root = loader.load(); // Crée une nouvelle instance de Parent
                DetailsEvenement dec = loader.getController();

                // Passer les données de l'événement à l'interface DetailsEvenement
                dec.setResNom(evenement.getNom());
                dec.setResDescription(evenement.getDescription());
                dec.setResDateDebut(evenement.getDate_debut().toString());
                dec.setResDateFin(evenement.getDate_fin().toString());
                dec.setResLieu(evenement.getLieu());
                dec.setResCategorie(evenement.getCategorie());
                dec.setResBudget(String.valueOf(evenement.getBudget()));
                dec.setResImageEvent(evenement.getImage_event());
                dec.setResNbPlaces(String.valueOf(evenement.getNb_places()));
                dec.setEvenementId(evenement.getEvenement_id());

                // Remplacer la scène actuelle par DetailsEvenement
                Stage detailStage = new Stage();
                detailStage.setTitle("Details de l'evenement");
                detailStage.setScene(new Scene(root));
                detailStage.show();
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

    private boolean validerDates() {
        LocalDate aujourdhui = LocalDate.now();
        LocalDate dateDebut = evenementDateDebutPicker.getValue();
        LocalDate dateFin = evenementDateFinPicker.getValue();

        if (dateDebut == null || dateFin == null) {
            afficherAlerte("Erreur", "Dates manquantes",
                "Veuillez sélectionner les dates de début et de fin.");
            return false;
        }

        if (dateDebut.isBefore(aujourdhui)) {
            afficherAlerte("Erreur", "Date invalide",
                "La date de début doit être à partir d'aujourd'hui.");
            return false;
        }

        if (dateFin.isBefore(dateDebut)) {
            afficherAlerte("Erreur", "Date invalide",
                "La date de fin doit être après la date de début.");
            return false;
        }

        if (dateDebut.equals(dateFin)) {
            LocalTime heureDebut = LocalTime.parse(evenementHeureDebutField.getValue());
            LocalTime heureFin = LocalTime.parse(evenementHeureFinField.getValue());

            if (heureFin.isBefore(heureDebut) || heureFin.equals(heureDebut)) {
                afficherAlerte("Erreur", "Heure invalide",
                    "Pour une même date, l'heure de fin doit être après l'heure de début.");
                return false;
            }
        }

        return true;
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
