package controllers;

import entities.Evenement;
import entities.Fournisseur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceEvenement;
import services.ServiceFournisseur;
import services.ServiceFournisseurEvenement;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AssignerFaE implements Initializable {
//ATTRIBUTS MENU//
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
    ////////////
    @FXML
    private TableColumn<?, ?> actionsColumn;

    @FXML
    private TableColumn<?, ?> contratColumn;

    @FXML
    private Label eventDescriptionLabel;

    @FXML
    private Label eventNameLabel;

    @FXML
    private TableView<Fournisseur> fournisseurTable;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nomColumn;

    @FXML
    private TableColumn<?, ?> numTelColumn;

    @FXML
    private Pane pane_event;
    private final ChangeListener<Fournisseur> selectionListener = (obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            handleFournisseurSelection(newSelection);
        }
    };

    @FXML
    private TableColumn<?, ?> typeServiceColumn;

    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
    private ServiceFournisseurEvenement serviceFournisseurEvenement = new ServiceFournisseurEvenement();
    private int currentEventId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        serviceFournisseur = new ServiceFournisseur();
        serviceFournisseurEvenement = new ServiceFournisseurEvenement();

        // Configurer les colonnes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("fournisseurId"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        typeServiceColumn.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        contratColumn.setCellValueFactory(new PropertyValueFactory<>("contrat"));
        numTelColumn.setCellValueFactory(new PropertyValueFactory<>("num_tel"));

        try {
            List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
            if (fournisseurs == null || fournisseurs.isEmpty()) {
                System.out.println("Aucun fournisseur trouvé.");
                return; // Prevent setting empty data
            }
            ObservableList<Fournisseur> observableList = FXCollections.observableArrayList(fournisseurs);
            fournisseurTable.setItems(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement des fournisseurs : " + e.getMessage());
        }

        // Attach listener
        fournisseurTable.getSelectionModel().selectedItemProperty().addListener(selectionListener);

        fournisseurTable.setRowFactory(table -> new TableRow<Fournisseur>() {
            @Override
            protected void updateItem(Fournisseur item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    // Appliquer une animation de fondu à l'apparition de la ligne
                    setOpacity(0);
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(300), this);
                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);
                    fadeIn.play();
                }
            }
        });

    }


    private void refreshTableView() {
        try {
            List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
            ObservableList<Fournisseur> observableList = FXCollections.observableArrayList(fournisseurs);

            // Avoid setting an empty list to prevent IndexOutOfBoundsException
            if (!observableList.isEmpty()) {
                fournisseurTable.setItems(observableList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du rechargement des fournisseurs : " + e.getMessage());
        }
    }

    private void handleFournisseurSelection(Fournisseur selectedFournisseur) {
        if (selectedFournisseur == null) {
            return;
        }

        fournisseurTable.getSelectionModel().selectedItemProperty().removeListener(selectionListener);

        Dialog<ButtonType> confirmationDialog = new Dialog<>();
        confirmationDialog.setTitle("Confirmation");
        confirmationDialog.setHeaderText(null);
        confirmationDialog.getDialogPane().getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        confirmationDialog.getDialogPane().getStyleClass().add("modern-dialog");

        Label messageLabel = new Label("Voulez-vous vraiment ajouter ce fournisseur ?");
        messageLabel.getStyleClass().add("dialog-text");

        VBox content = new VBox(15);
        content.setAlignment(Pos.CENTER);
        content.getChildren().addAll(messageLabel);
        confirmationDialog.getDialogPane().setContent(content);

        ButtonType yesButton = new ButtonType("✔ Oui", ButtonBar.ButtonData.OK_DONE);
        ButtonType noButton = new ButtonType("✖ Non", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirmationDialog.getDialogPane().getButtonTypes().setAll(yesButton, noButton);

        // Apply confirm-button style
        confirmationDialog.getDialogPane().lookupButton(yesButton).getStyleClass().add("confirm-button");
        confirmationDialog.getDialogPane().lookupButton(noButton).getStyleClass().add("confirm-button");

        Optional<ButtonType> result = confirmationDialog.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            serviceFournisseurEvenement.associerFournisseurAEvenement(selectedFournisseur.getFournisseurId(), currentEventId);
            System.out.println("Fournisseur " + selectedFournisseur.getFournisseurId() + " associé à l'événement " + currentEventId);
            refreshTableView();
        }

        if (!fournisseurTable.getItems().isEmpty()) {
            fournisseurTable.getSelectionModel().clearSelection();
        }

        fournisseurTable.getSelectionModel().selectedItemProperty().addListener(selectionListener);
    }

    @FXML
    void RedirectBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cette méthode est appelée depuis l'autre écran pour initialiser les données de l'événement
    public void initEventData(int eventId) {
        this.currentEventId = eventId;
        try {
            // Charger les détails de l'événement
            Evenement event = serviceEvenement.getEvenementById(eventId);
            if (event != null) {
                eventNameLabel.setText(event.getNom());
                eventDescriptionLabel.setText(event.getDescription());
                String imagePath = event.getImage_event();
                if (imagePath != null && !imagePath.isEmpty()) {
                    // Encoder les espaces dans le chemin
                    String encodedPath = imagePath.replace(" ", "%20");
                    pane_event.setStyle("-fx-background-image: url('" + encodedPath + "');"
                            + " -fx-background-size: cover;"
                            + " -fx-background-position: center center;");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

@FXML
    private void retourPage(ActionEvent event) {
    try {
        Node source = (Node) event.getSource();
        Integer eventId = this.currentEventId;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
        Parent root = loader.load();
        EventTache ajoutTacheController = loader.getController();
        ajoutTacheController.initEventData(eventId);
        Scene scene = source.getScene();
        scene.setRoot(root);
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
}
