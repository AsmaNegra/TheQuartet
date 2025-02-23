package controllers;

import entities.Evenement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import services.ServiceEvenement;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class ViewAllEventsController implements Initializable {
    @FXML
    private TilePane eventsContainer;

    @FXML
    private HBox categoriesContainer;

    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private Button selectedCategoryButton = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCategories();
        loadEvents();
        // Configuration du TilePane
        eventsContainer.setPrefColumns(2); // 2 colonnes
        eventsContainer.setHgap(20); // Espacement horizontal
        eventsContainer.setVgap(20); // Espacement vertical
    }

    private void loadEvents() {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetailsEvenement.fxml"));
            Parent root = loader.load();

            DetailsEvenement detailsController = loader.getController();
            DetailsEvenement.setCurrentEvenement(event);
            detailsController.initialize();

            Scene scene = eventsContainer.getScene();
            Stage stage = (Stage) scene.getWindow();
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
            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                if (event.getCategorie().equals(category)) {
                    createEventCard(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createEventCard(Evenement event) {
        VBox eventCard = new VBox(10);
        eventCard.getStyleClass().add("event-card");
        eventCard.setPrefWidth(340);
        eventCard.setPadding(new Insets(20));

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
                    eventCard.getChildren().add(imageView);
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur de chargement d'image: " + e.getMessage());
        }

        // Informations de l'événement
        Label titleLabel = new Label(event.getNom());
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Label dateLabel = new Label("Date: " + dateFormat.format(event.getDate_debut()));
        Label lieuLabel = new Label("Lieu: " + event.getLieu());
        Label categorieLabel = new Label("Catégorie: " + event.getCategorie());
        categorieLabel.setStyle("-fx-text-fill: #f49617;");

        Button detailsButton = new Button("Détails");
        detailsButton.getStyleClass().add("category-button");
        detailsButton.setOnAction(e -> showEventDetails(event));

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(detailsButton);

        eventCard.getChildren().addAll(
            titleLabel,
            dateLabel,
            lieuLabel,
            categorieLabel,
            buttonBox
        );

        eventsContainer.getChildren().add(eventCard);
    }
}


