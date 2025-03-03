package controllers;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import entities.Utilisateur;
import services.ServiceUtilisateur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @FXML
    private PieChart pieChartUsers;
    // Nouveaux éléments pour la sidebar
    @FXML
    private AnchorPane sidebar;
    @FXML
    private Label labelUser;

    private final int EXPANDED_WIDTH = 200;
    private final int COLLAPSED_WIDTH = 70;
    private boolean isSidebarExpanded = false;

    private ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();
    private Utilisateur currentUser;

    @FXML
    public void initialize() {
        initializeColumns();

        loadUsers();
        loadUserRoleChart(); // Ajoutez cette ligne

        // Initialiser la sidebar comme repliée par défaut
        sidebar.setPrefWidth(COLLAPSED_WIDTH);
    }

    public void initData(Utilisateur user) {
        this.currentUser = user;
        if (user != null && labelUser != null) {
            labelUser.setText(user.getNom());
        }
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
            userTable.getItems().setAll(serviceUtilisateur.afficher());
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
                    serviceUtilisateur.supprimer(user.getUtilisateurId());
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

    // Nouvelles méthodes pour gérer la sidebar
    @FXML
    public void expandSidebar() {
        if (!isSidebarExpanded) {
            TranslateTransition slideOut = new TranslateTransition(Duration.seconds(0.3), sidebar);
            sidebar.setPrefWidth(EXPANDED_WIDTH);
            labelUser.setVisible(true);
            isSidebarExpanded = true;
        }
    }
    private void loadUserRoleChart() {
        try {
            // Récupérer tous les utilisateurs
            List<Utilisateur> users = serviceUtilisateur.afficher();

            // Compter les utilisateurs par rôle
            Map<String, Integer> roleCount = new HashMap<>();

            for (Utilisateur user : users) {
                String role = user.getRole().name();
                roleCount.put(role, roleCount.getOrDefault(role, 0) + 1);
            }

            // Créer les données pour le PieChart
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

            for (Map.Entry<String, Integer> entry : roleCount.entrySet()) {
                pieChartData.add(new PieChart.Data(entry.getKey() + " (" + entry.getValue() + ")", entry.getValue()));
            }

            // Mettre à jour le PieChart
            pieChartUsers.setData(pieChartData);

            // Ajouter des tooltips pour afficher le pourcentage
            pieChartData.forEach(data -> {
                double total = users.size();
                double percentage = (data.getPieValue() / total) * 100;
                String text = String.format("%.1f%%", percentage);

                Tooltip tooltip = new Tooltip(text);
                Tooltip.install(data.getNode(), tooltip);

                // Ajouter un listener pour mettre en évidence au survol
                data.getNode().setOnMouseEntered(event -> data.getNode().setStyle("-fx-opacity: 0.8;"));
                data.getNode().setOnMouseExited(event -> data.getNode().setStyle("-fx-opacity: 1;"));
            });

        } catch (SQLException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du chargement des données du graphique");
        }
    }
    @FXML
    public void collapseSidebar() {
        if (isSidebarExpanded) {
            TranslateTransition slideIn = new TranslateTransition(Duration.seconds(0.3), sidebar);
            sidebar.setPrefWidth(COLLAPSED_WIDTH);
            labelUser.setVisible(false);
            isSidebarExpanded = false;
        }
    }

    @FXML
    public void handleSitemapClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Sitemap.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Sitemap : " + e.getMessage());
        }
    }

    @FXML
    public void handleGiftClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gift.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Gift : " + e.getMessage());
        }
    }

    @FXML
    public void handleHomeClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Home : " + e.getMessage());
        }
    }

    @FXML
    public void handleUserClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserProfile.fxml"));
            Parent root = loader.load();
            UserProfileController controller = loader.getController();
            if (currentUser != null) {
                controller.initData(currentUser);
            }
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du chargement de la page Profil : " + e.getMessage());
        }
    }

    @FXML
    public void handleLogout() {
        try {
            Parent authentificationPage = FXMLLoader.load(getClass().getResource("/Authentification.fxml"));
            Stage stage = (Stage) sidebar.getScene().getWindow();
            stage.setScene(new Scene(authentificationPage));
            stage.show();
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Erreur", "Erreur lors du retour à la page d'authentification : " + e.getMessage());
        }
    }
}