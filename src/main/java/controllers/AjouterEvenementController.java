package controllers;

import entities.Evenement;
import java.sql.Timestamp;

import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

public class AjouterEvenementController {
    @FXML
    private TextField evenementNomField;

    @FXML
    private TextArea evenementDescriptionArea;

    @FXML
    private DatePicker evenementDateDebutPicker;

    @FXML
    private Spinner<Integer> evenementHeureDebutField;

    @FXML
    private DatePicker evenementDateFinPicker;

    @FXML
    private Spinner<Integer> evenementHeureFinField;

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

    @FXML
    public void initialize() {
        // Configuration existante des Spinners
        evenementHeureDebutField.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 12)
        );
        evenementHeureFinField.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 18)
        );

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


    // Dans AjouterEvenementController.java
    @FXML
    void ajouterEvenement(ActionEvent event) {
        try {
            // Récupération des valeurs
            LocalDate dateDebut = evenementDateDebutPicker.getValue();
            int heureDebut = evenementHeureDebutField.getValue();
            LocalDate dateFin = evenementDateFinPicker.getValue();
            int heureFin = evenementHeureFinField.getValue();

            // Création des LocalDateTime
            LocalDateTime dateTimeDebut = dateDebut.atTime(heureDebut, 0);
            LocalDateTime dateTimeFin = dateFin.atTime(heureFin, 0);

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
            serviceEvenement.ajouter(evenement);

            // Affichage dans DetailsEvenement
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetailsEvenement.fxml"));
            Parent root = loader.load();
            DetailsEvenement dec = loader.getController();

            // Format d'affichage des timestamps
            dec.setResNom(evenement.getNom());
            dec.setResDescription(evenement.getDescription());
            dec.setResDateDebut(evenement.getDate_debut().toString());
            dec.setResDateFin(evenement.getDate_fin().toString());
            dec.setResLieu(evenement.getLieu());
            dec.setResCategorie(evenement.getCategorie());
            dec.setResBudget(String.valueOf(evenement.getBudget()));
            dec.setResImageEvent(evenement.getImage_event());
            dec.setResNbPlaces(String.valueOf(evenement.getNb_places()));


            evenementAjouterButton.getScene().setRoot(root);



        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite : " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }


}
