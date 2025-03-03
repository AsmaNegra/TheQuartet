package controllers;

import entities.Fournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.ServiceFournisseur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AdminFournisseur implements Initializable {

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
}
