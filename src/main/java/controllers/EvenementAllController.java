package controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Comparator;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import java.io.File;

import entities.Evenement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import services.ServiceEvenement;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EvenementAllController {

    @FXML
    private TableView<Evenement> evenementTable;

    @FXML
    private TableColumn<Evenement, String> nomColumn;

    @FXML
    private TableColumn<Evenement, String> descriptionColumn;

    @FXML
    private TableColumn<Evenement, String> dateDebutColumn;

    @FXML
    private TableColumn<Evenement, String> dateFinColumn;

    @FXML
    private TableColumn<Evenement, String> lieuColumn;

    @FXML
    private TableColumn<Evenement, String> categorieColumn;

    @FXML
    private TableColumn<Evenement, Float> budgetColumn;

    @FXML
    private TableColumn<Evenement, Integer> nbPlacesColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private Button ajouterButton;

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
    private TextField evenementNbPlacesField;

    @FXML
    private TextField evenementImageField;

    @FXML
    private ImageView imagePreview;

    @FXML
    private Button choisirImageButton;

    @FXML
    private Button evenementFermerButton;

    @FXML
    private Button evenementModifierButton;

    @FXML
    private Button evenementSupprimerButton;

    @FXML
    private Button effacerRechercheButton;

    @FXML
    private TableColumn<Evenement, Void> actionsColumn;

    @FXML
    private ComboBox<String> colonneTriComboBox;

    @FXML
    private CheckBox triDescendantCheckBox;

    @FXML
    private TextField rechercheField;
    private ObservableList<Evenement> evenementListComplete = FXCollections.observableArrayList();

    private ObservableList<Evenement> evenementList = FXCollections.observableArrayList();

    private Evenement evenementSelectionne; // Pour stocker l'événement à modifier
    private ServiceEvenement serviceEvenement = new ServiceEvenement();

    @FXML
    public void verifierNomEvenement(ActionEvent event) {
        String nom = evenementNomField.getText().trim();
        if (nom.isEmpty()) {
            afficherAlerte("Erreur", "Champ vide", "Veuillez saisir un nom d'événement.");
            return;
        }

        try {
            Optional<Evenement> evenementOpt = serviceEvenement.getEvenementParNom(nom);
            if (evenementOpt.isPresent()) {
                evenementSelectionne = evenementOpt.get();
                remplirChampsFormulaire(evenementSelectionne);
            } else {
                afficherAlerte("Erreur", "Événement introuvable", "Aucun événement avec ce nom n'existe.");
            }
        } catch (SQLException e) {
            afficherAlerte("Erreur", "Problème de base de données", e.getMessage());
        }
    }

    private void remplirChampsFormulaire(Evenement evenement) {
        if (evenement == null) {
            return;
        }

        try {
            // Basic fields
            evenementNomField.setText(evenement.getNom());
            evenementDescriptionArea.setText(evenement.getDescription());
            evenementLieuField.setText(evenement.getLieu());
            evenementCategorieComboBox.setValue(evenement.getCategorie());
            evenementBudgetField.setText(String.valueOf(evenement.getBudget()));
            evenementNbPlacesField.setText(String.valueOf(evenement.getNb_places()));
            evenementImageField.setText(evenement.getImage_event());

            // Handle dates and times
            if (evenement.getDate_debut() != null) {
                LocalDateTime dateTimeDebut = evenement.getDate_debut().toLocalDateTime();
                evenementDateDebutPicker.setValue(dateTimeDebut.toLocalDate());

                // Ensure ValueFactory is set before setting value
                if (evenementHeureDebutField.getValueFactory() != null) {
                    evenementHeureDebutField.getValueFactory().setValue(
                        dateTimeDebut.format(DateTimeFormatter.ofPattern("HH:mm"))
                    );
                }
            }

            if (evenement.getDate_fin() != null) {
                LocalDateTime dateTimeFin = evenement.getDate_fin().toLocalDateTime();
                evenementDateFinPicker.setValue(dateTimeFin.toLocalDate());

                // Ensure ValueFactory is set before setting value
                if (evenementHeureFinField.getValueFactory() != null) {
                    evenementHeureFinField.getValueFactory().setValue(
                        dateTimeFin.format(DateTimeFormatter.ofPattern("HH:mm"))
                    );
                }
            }

            // Load image if exists
            if (evenement.getImage_event() != null && !evenement.getImage_event().isEmpty()) {
                String imagePath = "src/main/resources/" + evenement.getImage_event();
                File file = new File(imagePath);
                if (file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    imagePreview.setImage(image);
                }
            }

        } catch (Exception e) {
            afficherAlerte("Erreur", "Erreur lors du remplissage des champs",
                "Une erreur s'est produite : " + e.getMessage());
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize() {
        // Initialize existing columns
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateDebutColumn.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        dateFinColumn.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        lieuColumn.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        categorieColumn.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
        nbPlacesColumn.setCellValueFactory(new PropertyValueFactory<>("nb_places"));

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

        // Initialize time spinners
        initializeTimeSpinners();

        // Add table selection listener
        evenementTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                evenementSelectionne = newSelection;
                remplirChampsFormulaire(newSelection);
            }
        });

        // Load initial data
        loadEvenements();

        // Initialize categories
        try {
            List<String> categories = serviceEvenement.getCategories();
            evenementCategorieComboBox.getItems().addAll(categories);
        } catch (SQLException e) {
            afficherAlerte("Erreur", "Chargement des catégories", e.getMessage());
        }

        // Configurer la recherche dynamique
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrerEvenements(newValue);
        });

        initializeActionsColumn();

        // Configurer le bouton d'effacement
        effacerRechercheButton.setVisible(false);
        effacerRechercheButton.setStyle(
            "-fx-background-radius: 15;" +
                "-fx-min-width: 30;" +
                "-fx-min-height: 30;" +
                "-fx-font-size: 14;"
        );

        // Ajouter le listener pour la visibilité du bouton
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            effacerRechercheButton.setVisible(!newValue.isEmpty());
        });

        colonneTriComboBox.getItems().addAll(
            "Aucun tri",
            "Nom",
            "Description",
            "Date de début",
            "Date de fin",
            "Lieu",
            "Catégorie",
            "Budget",
            "Nombre de places"
        );
        colonneTriComboBox.setValue("Aucun tri");

        // Ajouter les listeners pour le tri
        colonneTriComboBox.valueProperty().addListener((obs, oldVal, newVal) -> appliquerTri());
        triDescendantCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> appliquerTri());

        // Listener pour la recherche
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrerEvenements(newValue);
        });

        // Listeners pour le tri
        colonneTriComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            appliquerTri();
            // Réappliquer le filtre de recherche après le tri
            filtrerEvenements(rechercheField.getText());
        });

        triDescendantCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            appliquerTri();
            // Réappliquer le filtre de recherche après le tri
            filtrerEvenements(rechercheField.getText());
        });
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
    private void loadEvenements() {
        try {
            evenementListComplete.clear();
            evenementListComplete.addAll(serviceEvenement.afficher());

            // D'abord appliquer le tri si nécessaire
            String triActuel = colonneTriComboBox.getValue();
            if (triActuel != null && !triActuel.equals("Aucun tri")) {
                appliquerTri();
            }

            // Ensuite appliquer le filtre de recherche si nécessaire
            if (rechercheField.getText() != null && !rechercheField.getText().isEmpty()) {
                filtrerEvenements(rechercheField.getText());
            } else {
                evenementTable.setItems(evenementListComplete);
            }
        } catch (SQLException e) {
            afficherAlerte("Erreur", "Chargement des données", e.getMessage());
        }
    }

    private void afficherAlerte(String titre, String entete, String contenu) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(entete);
        alert.setContentText(contenu);
        alert.showAndWait();
    }

    @FXML
    private void handleAjouterButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterEvenement.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Ajouter un événement");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            afficherAlerte("Erreur", "Impossible d'ouvrir l'interface", e.getMessage());
        }
    }

    @FXML
    private void modifierEvenement(ActionEvent event) {
        if (evenementSelectionne == null) {
            afficherAlerte("Erreur", "Aucun événement sélectionné",
                "Veuillez sélectionner un événement dans le tableau.");
            return;
        }

        if (!validerDates()) {
            return;
        }

        try {
            // Update the selected event with form values
            evenementSelectionne.setNom(evenementNomField.getText());
            evenementSelectionne.setDescription(evenementDescriptionArea.getText());
            evenementSelectionne.setLieu(evenementLieuField.getText());
            evenementSelectionne.setCategorie(evenementCategorieComboBox.getValue());
            evenementSelectionne.setBudget(Float.parseFloat(evenementBudgetField.getText()));
            evenementSelectionne.setNb_places(Integer.parseInt(evenementNbPlacesField.getText()));
            evenementSelectionne.setImage_event(evenementImageField.getText());

            // Handle dates
            LocalDate dateDebut = evenementDateDebutPicker.getValue();
            LocalTime heureDebut = LocalTime.parse(evenementHeureDebutField.getValue());
            evenementSelectionne.setDate_debut(
                Timestamp.valueOf(LocalDateTime.of(dateDebut, heureDebut))
            );

            LocalDate dateFin = evenementDateFinPicker.getValue();
            LocalTime heureFin = LocalTime.parse(evenementHeureFinField.getValue());
            evenementSelectionne.setDate_fin(
                Timestamp.valueOf(LocalDateTime.of(dateFin, heureFin))
            );

            // Save changes to database
            serviceEvenement.modifier(evenementSelectionne);

            // Refresh table
            loadEvenements();

            // Show success message
            afficherAlerte("Succès", "Modification réussie",
                "L'événement a été modifié avec succès.");

        } catch (Exception e) {
            afficherAlerte("Erreur", "Erreur lors de la modification",
                "Une erreur s'est produite : " + e.getMessage());
            e.printStackTrace();
        }
    }


    @FXML
    public void choisirImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        File file = fileChooser.showOpenDialog(choisirImageButton.getScene().getWindow());
        if (file != null) {
            try {
                String uploadDir = "src/main/resources/images/events";
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                String uniqueFileName = System.currentTimeMillis() + "_" + file.getName();
                Path destinationPath = uploadPath.resolve(uniqueFileName);
                Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

                evenementImageField.setText("images/events/" + uniqueFileName);

                Image image = new Image(file.toURI().toString());
                imagePreview.setImage(image);
            } catch (IOException e) {
                afficherAlerte("Erreur", "Erreur d'image", "Impossible de copier l'image.");
            }
        }
    }

        private void initializeTimeSpinners() {
            // Configuration du format de l'heure
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            // Création des SpinnerValueFactory pour les heures
            SpinnerValueFactory<String> heureDebutFactory = new SpinnerValueFactory<String>() {
                {
                    setValue("00:00");
                }

                @Override
                public void decrement(int steps) {
                    try {
                        LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                        setValue(time.minusMinutes(steps).format(timeFormatter));
                    } catch (Exception e) {
                        setValue("00:00");
                    }
                }

                @Override
                public void increment(int steps) {
                    try {
                        LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                        setValue(time.plusMinutes(steps).format(timeFormatter));
                    } catch (Exception e) {
                        setValue("00:00");
                    }
                }
            };

            SpinnerValueFactory<String> heureFinFactory = new SpinnerValueFactory<String>() {
                {
                    setValue("00:00");
                }

                @Override
                public void decrement(int steps) {
                    try {
                        LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                        setValue(time.minusMinutes(steps).format(timeFormatter));
                    } catch (Exception e) {
                        setValue("00:00");
                    }
                }

                @Override
                public void increment(int steps) {
                    try {
                        LocalTime time = LocalTime.parse(getValue(), timeFormatter);
                        setValue(time.plusMinutes(steps).format(timeFormatter));
                    } catch (Exception e) {
                        setValue("00:00");
                    }
                }
            };

            // Appliquer les factories aux spinners
            evenementHeureDebutField.setValueFactory(heureDebutFactory);
            evenementHeureFinField.setValueFactory(heureFinFactory);

            // Ajouter des validateurs pour la saisie manuelle
            evenementHeureDebutField.getEditor().setTextFormatter(new TextFormatter<>(change -> {
                String newText = change.getControlNewText();
                if (newText.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") || newText.isEmpty()) {
                    return change;
                }
                return null;
            }));

            evenementHeureFinField.getEditor().setTextFormatter(new TextFormatter<>(change -> {
                String newText = change.getControlNewText();
                if (newText.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") || newText.isEmpty()) {
                    return change;
                }
                return null;
            }));
        }


    @FXML
    private void handleFermerButton(ActionEvent event) {
        // Get the stage
        Stage stage = (Stage) evenementFermerButton.getScene().getWindow();
        // Close the stage
        stage.close();
    }

    @FXML
    private void supprimerEvenement(ActionEvent event) {
        if (evenementSelectionne == null) {
            afficherAlerte("Erreur", "Aucun événement sélectionné",
                "Veuillez sélectionner un événement dans le tableau.");
            return;
        }

        // Demander confirmation avant la suppression
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation de suppression");
        confirmation.setHeaderText("Supprimer l'événement");
        confirmation.setContentText("Êtes-vous sûr de vouloir supprimer l'événement \"" +
            evenementSelectionne.getNom() + "\" ?");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Supprimer l'événement
                serviceEvenement.supprimer(evenementSelectionne.getEvenement_id());

                // Vider les champs du formulaire
                viderChamps();

                // Rafraîchir la table
                loadEvenements();

                // Réinitialiser l'événement sélectionné
                evenementSelectionne = null;

                // Afficher un message de succès
                afficherAlerte("Succès", "Suppression réussie",
                    "L'événement a été supprimé avec succès.");

            } catch (SQLException e) {
                afficherAlerte("Erreur", "Erreur lors de la suppression",
                    "Une erreur s'est produite : " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void viderChamps() {
        evenementNomField.clear();
        evenementDescriptionArea.clear();
        evenementDateDebutPicker.setValue(null);
        evenementDateFinPicker.setValue(null);
        evenementHeureDebutField.getValueFactory().setValue("00:00");
        evenementHeureFinField.getValueFactory().setValue("00:00");
        evenementLieuField.clear();
        evenementCategorieComboBox.setValue(null);
        evenementBudgetField.clear();
        evenementNbPlacesField.clear();
        evenementImageField.clear();
        imagePreview.setImage(null);
    }


    private void filtrerEvenements(String recherche) {
        if (recherche == null || recherche.isEmpty()) {
            evenementTable.setItems(evenementListComplete);
            return;
        }

        ObservableList<Evenement> evenementsFiltres = evenementListComplete.stream()
            .filter(evenement -> correspondARecherche(evenement, recherche.toLowerCase()))
            .collect(Collectors.toCollection(FXCollections::observableArrayList));

        evenementTable.setItems(evenementsFiltres);
    }


    private boolean correspondARecherche(Evenement evenement, String recherche) {
        return (evenement.getNom() != null &&
            evenement.getNom().toLowerCase().contains(recherche)) ||
            (evenement.getDescription() != null &&
                evenement.getDescription().toLowerCase().contains(recherche)) ||
            (evenement.getLieu() != null &&
                evenement.getLieu().toLowerCase().contains(recherche)) ||
            (evenement.getCategorie() != null &&
                evenement.getCategorie().toLowerCase().contains(recherche)) ||
            String.valueOf(evenement.getBudget()).contains(recherche) ||
            String.valueOf(evenement.getNb_places()).contains(recherche);
    }


    private boolean contientRecherche(Evenement evenement, String recherche) {
        return evenement.getNom().toLowerCase().contains(recherche) ||
            evenement.getDescription().toLowerCase().contains(recherche) ||
            evenement.getLieu().toLowerCase().contains(recherche) ||
            evenement.getCategorie().toLowerCase().contains(recherche) ||
            String.valueOf(evenement.getBudget()).contains(recherche) ||
            String.valueOf(evenement.getNb_places()).contains(recherche);
    }

    private void initializeActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button feedbackButton = new Button("Feedback");

            {
                feedbackButton.setOnAction(event -> {
                    Evenement evenement = getTableView().getItems().get(getIndex());
                    ouvrirListeFeedbacks(evenement);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(feedbackButton);
                }
            }
        });
    }

    private void ouvrirListeFeedbacks(Evenement evenement) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ListeFeedbacks.fxml"));
            Parent root = loader.load();

            ListeFeedbacksController controller = loader.getController();
            controller.initData(evenement);

            Stage stage = new Stage();
            stage.setTitle("Feedbacks - " + evenement.getNom());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            afficherAlerte("Erreur", "Erreur d'ouverture",
                "Impossible d'ouvrir la fenêtre des feedbacks: " + e.getMessage());
        }
    }

    @FXML
    private void effacerRecherche() {
        rechercheField.clear();
        loadEvenements(); // Recharger tous les événements
        effacerRechercheButton.setVisible(false);
    }

    private void appliquerTri() {
        String colonneTri = colonneTriComboBox.getValue();
        boolean descendant = triDescendantCheckBox.isSelected();

        if (colonneTri == null || colonneTri.equals("Aucun tri")) {
            evenementTable.setItems(evenementListComplete);
            return;
        }

        Comparator<Evenement> comparator = creerComparateur(colonneTri);
        if (descendant) {
            comparator = comparator.reversed();
        }

        // Trier la liste complète
        evenementListComplete.sort(comparator);

        // Réappliquer le filtre de recherche après le tri si nécessaire
        String recherche = rechercheField.getText();
        if (recherche != null && !recherche.isEmpty()) {
            filtrerEvenements(recherche);
        } else {
            evenementTable.setItems(evenementListComplete);
        }
    }

    private Comparator<Evenement> creerComparateur(String colonne) {
        switch (colonne) {
            case "Nom":
                return Comparator.comparing(Evenement::getNom, Comparator.nullsLast(String::compareTo));
            case "Description":
                return Comparator.comparing(Evenement::getDescription, Comparator.nullsLast(String::compareTo));
            case "Date de début":
                return Comparator.comparing(Evenement::getDate_debut, Comparator.nullsLast(Timestamp::compareTo));
            case "Date de fin":
                return Comparator.comparing(Evenement::getDate_fin, Comparator.nullsLast(Timestamp::compareTo));
            case "Lieu":
                return Comparator.comparing(Evenement::getLieu, Comparator.nullsLast(String::compareTo));
            case "Catégorie":
                return Comparator.comparing(Evenement::getCategorie, Comparator.nullsLast(String::compareTo));
            case "Budget":
                return Comparator.comparing(Evenement::getBudget);
            case "Nombre de places":
                return Comparator.comparing(Evenement::getNb_places);
            default:
                return (e1, e2) -> 0;
        }
    }

}
