package controllers;

import entities.Fournisseur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceFournisseur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AdminFournisseur implements Initializable {
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
    private TableView<Fournisseur> fournisseurTable;

    @FXML
    private TableColumn<Fournisseur, Integer> idColumn;

    @FXML
    private TableColumn<Fournisseur, String> nomColumn;

    @FXML
    private TableColumn<Fournisseur, String> typeServiceColumn;

    @FXML
    private TableColumn<Fournisseur, String> contratColumn;

    @FXML
    private TableColumn<Fournisseur, Integer> numTelColumn;

    @FXML
    private TableColumn<Fournisseur, Void> actionsColumn;

    private ServiceFournisseur serviceFournisseur;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialiser le service
        serviceFournisseur = new ServiceFournisseur();

        // Configurer les colonnes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("fournisseurId"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        typeServiceColumn.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        contratColumn.setCellValueFactory(new PropertyValueFactory<>("contrat"));
        numTelColumn.setCellValueFactory(new PropertyValueFactory<>("num_tel"));

        // Définir la colonne Actions avec des boutons icône pour chaque ligne
        actionsColumn.setCellFactory(col -> new TableCell<Fournisseur, Void>() {
            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Fournisseur fournisseur = getTableView().getItems().get(getIndex());

                    // Bouton Modifier avec icône crayon
                    Button editButton = new Button();
                    ImageView editIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/pencil.png")));
                    editIcon.setFitWidth(16);
                    editIcon.setFitHeight(16);
                    editButton.setGraphic(editIcon);
                    editButton.setStyle("-fx-background-color: transparent;");
                    editButton.setOnAction(event -> modifyFournisseur(fournisseur, event));

                    // Bouton Supprimer avec icône poubelle
                    Button deleteButton = new Button();
                    ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/delete.png")));
                    deleteIcon.setFitWidth(16);
                    deleteIcon.setFitHeight(16);
                    deleteButton.setGraphic(deleteIcon);
                    deleteButton.setStyle("-fx-background-color: transparent;");
                    deleteButton.setOnAction(event -> deleteFournisseur(fournisseur));

                    HBox buttons = new HBox(10, editButton, deleteButton);
                    setGraphic(buttons);
                }
            }
        });

        // Charger les données
        try {
            List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
            ObservableList<Fournisseur> observableList = FXCollections.observableArrayList(fournisseurs);
            fournisseurTable.setItems(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement des fournisseurs : " + e.getMessage());
        }
    }

    @FXML
    public void RedirectBackF(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjoutFournisseur.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void modifyFournisseur(Fournisseur fournisseur, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierFournisseur.fxml"));
            Parent root = loader.load();
            ModifierFournisseur controller = loader.getController();
            controller.setFournisseurData(fournisseur);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFournisseur(Fournisseur fournisseur) {
        try {
            serviceFournisseur.supprimer(fournisseur.getFournisseurId());
            List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
            ObservableList<Fournisseur> observableList = FXCollections.observableArrayList(fournisseurs);
            fournisseurTable.setItems(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //////////////////MENU////////////////////////

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
/////////////////////////////////////
}
