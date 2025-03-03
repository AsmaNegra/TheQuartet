package controllers;
import entities.Evenement;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceEvenement;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class ViewAllEventsController implements Initializable {
    @FXML private Button btnSitemap;
    @FXML private Button btnGift;
    @FXML private Button btnHome;
    @FXML private Button btnHome1;
    @FXML private AnchorPane sidebar;
    @FXML private TilePane eventsContainer;
    @FXML private HBox categoriesContainer;
    @FXML private TextField searchField;
    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private Button selectedCategoryButton = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadCategories();
        loadEvents();
        eventsContainer.setPrefColumns(2);
        eventsContainer.setHgap(20);
        eventsContainer.setVgap(20);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterEventsByName(newValue);
        });
    }

    private void loadEvents() {
        String searchText = searchField.getText();
        filterEventsByName(searchText);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterTransaction.fxml"));
            Parent root = loader.load();
            AjouterTransactionController transactionController = loader.getController();
            if (transactionController != null) {
                transactionController.setCurrentEvenement(event);
                transactionController.updateUI();
            } else {
                System.err.println("Erreur : Impossible de charger AjouterTransactionController.");
            }
            Stage stage = (Stage) eventsContainer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'interface AjouterTransaction.fxml");
            e.printStackTrace();
        }
    }
    private void loadCategories() {
        try {
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
                categoryButton.getStyleClass().add("category-button");
                categoryButton.setMinWidth(Button.USE_PREF_SIZE);
                categoryButton.setPrefWidth(Button.USE_COMPUTED_SIZE);
                categoryButton.setMaxWidth(Button.USE_PREF_SIZE);
                categoryButton.setTextAlignment(TextAlignment.CENTER);
                categoryButton.setWrapText(false);
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
        if (selectedCategoryButton != null) {
            selectedCategoryButton.getStyleClass().remove("category-button-selected");
        }
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
    private void filterEventsByName(String searchText) {
        try {
            eventsContainer.getChildren().clear();
            List<Evenement> evenements = serviceEvenement.afficher();

            for (Evenement event : evenements) {
                if (event.getNom().toLowerCase().contains(searchText.toLowerCase())) {
                    createEventCard(event);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    /////////////////////////////////////////////////////////
}


