package tn.esprit.contollers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tn.esprit.entities.Role;
import tn.esprit.services.ServiceUtilisateur;
import tn.esprit.entities.Utilisateur;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

public class AdminDashboardController {
    @FXML
    private TableView<Utilisateur> userTable;
    @FXML
    private TableColumn<Utilisateur, Integer> idColumn;
    @FXML
    private TableColumn<Utilisateur, String> nomColumn;
    @FXML
    private TableColumn<Utilisateur, String> emailColumn;
    @FXML
    private TableColumn<Utilisateur, String> roleColumn;
    @FXML
    private TableColumn<Utilisateur, String> etatColumn;
    @FXML
    private TableColumn<Utilisateur, String> entrepriseColumn;
    @FXML
    private TableColumn<Utilisateur, Void> actionColumn;

    private ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();
    private Utilisateur currentUser;

    @FXML
    public void initialize() {
        initializeColumns();
        loadUsers();
    }

    public void initData(Utilisateur user) {
        this.currentUser = user;
        loadUsers();
    }

    private void initializeColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("utilisateurId"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        etatColumn.setCellValueFactory(new PropertyValueFactory<>("etat"));
        entrepriseColumn.setCellValueFactory(new PropertyValueFactory<>("entreprise"));

        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editBtn = new Button("Modifier");
            private final Button deleteBtn = new Button("Supprimer");
            private final HBox buttons = new HBox(5, editBtn, deleteBtn);

            {
                editBtn.setOnAction(event -> {
                    Utilisateur user = getTableView().getItems().get(getIndex());
                    editUser(user);
                });

                deleteBtn.setOnAction(event -> {
                    Utilisateur user = getTableView().getItems().get(getIndex());
                    deleteUser(user);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : buttons);
            }
        });
    }

    private void loadUsers() {
        try {
            userTable.getItems().setAll(serviceUtilisateur.afficher_Utili());
        } catch (SQLException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du chargement des utilisateurs");
        }
    }

    private void editUser(Utilisateur user) {
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditUser.fxml"));
              Parent root = loader.load();
              EditUserController controller = loader.getController();
              controller.initData(user, this::loadUsers);

              Stage stage = new Stage();
              stage.setScene(new Scene(root));
              stage.show();
          } catch (IOException e) {
              showAlert(AlertType.ERROR, "Erreur", "Erreur lors de l'ouverture du formulaire de modification");
          }
      }


    @FXML
    private void retour(ActionEvent event) {
        try {
            Parent authentificationPage = FXMLLoader.load(getClass().getResource("/Authentification.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(authentificationPage));
            stage.show();
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du retour à la page d'authentification : " + e.getMessage());
        }
    }

    private void deleteUser(Utilisateur user) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Voulez-vous vraiment supprimer cet utilisateur ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    serviceUtilisateur.supprimer_Utili(user.getUtilisateurId());
                    loadUsers();
                } catch (SQLException e) {
                    showAlert(AlertType.ERROR, "Erreur", "Erreur lors de la suppression");
                }
            }
        });
    }

    private void showAlert(AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
