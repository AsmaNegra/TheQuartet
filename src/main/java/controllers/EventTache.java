package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceFournisseur;
import services.ServiceTache;
import entities.Tache;
import entities.Fournisseur;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class EventTache implements Initializable {
    @FXML
    private ScrollPane fournisseurList;
    @FXML
    private VBox fournisseurContainer;
    @FXML
    private VBox doneTasks;

    @FXML
    private VBox inProgressTasks;

    @FXML
    private VBox todoTasks;


    private final ServiceTache serviceTache = new ServiceTache();
    private Tache draggedTask;
    private  ServiceFournisseur serviceFournisseur = new ServiceFournisseur();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadTasks();
            loadFournisseurs();
            setupDragAndDrop();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadFournisseurs() throws SQLException {
        List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
        populateFournisseurList(fournisseurs); // Display in a VBox
    }

    private void loadTasks() throws SQLException {
        List<Tache> enAttente = serviceTache.afficherTachesToDo();
        List<Tache> enCours = serviceTache.afficherTachesEnCours();
        List<Tache> terminees = serviceTache.afficherTachesDone();


        populateColumn(todoTasks, enAttente);
        populateColumn(inProgressTasks, enCours);
        populateColumn(doneTasks, terminees);
    }

    private void populateColumn(VBox column, List<Tache> tasks) {
        column.getChildren().clear();
        for (Tache task : tasks) {
            HBox taskContainer = new HBox(10);
            taskContainer.setStyle("-fx-background-color: rgba(255, 255, 255, 0.82); -fx-padding: 10; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 10, 0.5, 2, 2);");

            VBox textContainer = new VBox(5);
            Label nameLabel = new Label(task.getNom());
            nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #2b2b2b;");

            Label descriptionLabel = new Label((task.getDescription() != null ? task.getDescription() : ""));
            descriptionLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");

            Label assignedLabel = new Label("Assigné à : " + task.getUserAssocie());
            assignedLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");

            HBox statusContainer = new HBox(10);
            Label relativeTime = new Label(task.getDateLimite().toString());
            Label priorityLabel = new Label("Priorité : " + task.getPriorite());
            statusContainer.getChildren().addAll(relativeTime, priorityLabel);

            // Buttons Container
            VBox buttonContainer = new VBox(10);

            // Create Edit Button with Image
            Button editButton = new Button();
            ImageView editIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/pencil.png")));
            editIcon.setFitWidth(10);  // Set icon width
            editIcon.setFitHeight(10); // Set icon height
            editButton.setGraphic(editIcon);
            editButton.setStyle("-fx-background-color: transparent;"); // Hide default button background
            editButton.setOnAction(event -> modifyTask(task, event));

            // Create Delete Button with Image
            Button deleteButton = new Button();
            ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/delete.png")));
            deleteIcon.setFitWidth(10);
            deleteIcon.setFitHeight(10);
            deleteButton.setGraphic(deleteIcon);
            deleteButton.setStyle("-fx-background-color: transparent;");
            deleteButton.setOnAction(event -> deleteTask(task));

            // Add buttons to button container
            buttonContainer.getChildren().addAll(editButton, deleteButton);

            // Add elements to task container
            textContainer.getChildren().addAll(nameLabel, descriptionLabel, assignedLabel, statusContainer);
            taskContainer.getChildren().addAll(textContainer, buttonContainer);

            // Add task container to column
            column.getChildren().add(taskContainer);
            // 🎯 Ajout du Drag & Drop
            taskContainer.setOnDragDetected(event -> {
                draggedTask = task;
                Dragboard db = taskContainer.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(task.getNom());
                db.setContent(content);
                event.consume();
            });
        }
    }
    private void setupDragAndDrop() {
        // 🚀 Ajouter la gestion du drag and drop pour chaque colonne
        setupDropTarget(todoTasks,"A Faire");
        setupDropTarget(inProgressTasks,"En Cours");
        setupDropTarget(doneTasks,"Terminée");
    }

    private void setupDropTarget(VBox targetColumn, String newStatus) {
        targetColumn.setOnDragOver(event -> {
            if (event.getGestureSource() != targetColumn && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        targetColumn.setOnDragDropped(event -> {
            if (draggedTask != null) {
                try {
                    serviceTache.modifierEtatTache(draggedTask.getTacheId(), newStatus); // Met à jour la BDD
                    loadTasks(); // 🔥 Rafraîchir les tâches après déplacement
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            event.setDropCompleted(true);
            event.consume();
        });
    }

    private void modifyTask(Tache task, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierTache.fxml"));
            Parent root = loader.load();

            // Get the controller and set the task data
            ModifierTache controller = loader.getController();
            controller.setTaskData(task);


            // Load the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteTask(Tache task) {
        try {
            serviceTache.supprimer(task.getTacheId());
            System.out.println(task.getTacheId());
            loadTasks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void RedirectBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjoutTache.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private void populateFournisseurList(List<Fournisseur> fournisseurs) {
        fournisseurContainer.getChildren().clear(); // Clear previous items

        for (Fournisseur fournisseur : fournisseurs) {
            // Create a horizontal container for each supplier
            HBox fournisseurContainerItem = new HBox(20);
            fournisseurContainerItem.setStyle("-fx-background-color: rgba(255, 255, 255, 0.82); "
                    + "-fx-padding: 10; -fx-border-radius: 10px; -fx-background-radius: 10px; "
                    + "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 10, 0.5, 2, 2);");

            VBox textContainer = new VBox(5);

            // Big Text for Name
            Label nameLabel = new Label(fournisseur.getNom());
            nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #2b2b2b;");

            // Type of Service
            Label typeLabel = new Label("Type: " + fournisseur.getTypeService());
            typeLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");

            // Contract State
            Label contractLabel = new Label("État du contrat: " + fournisseur.getContrat());
            contractLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #888;");

            // Phone Number
            Label phoneLabel = new Label("📞 " + fournisseur.getNum_tel());
            phoneLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #444;");

            // Arrange Elements in a horizontal layout
            HBox typeAndContract = new HBox(15);
            typeAndContract.getChildren().addAll(typeLabel, contractLabel);

            // Buttons Container
            HBox buttonContainer = new HBox(10);

            // Create Edit Button with Image
            Button editButton = new Button();
            ImageView editIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/pencil.png")));
            editIcon.setFitWidth(16);  // Set icon width
            editIcon.setFitHeight(16); // Set icon height
            editButton.setGraphic(editIcon);
            editButton.setStyle("-fx-background-color: transparent;"); // Hide default button background
            editButton.setOnAction(event -> modifyFournisseur(fournisseur, event));

            // Create Delete Button with Image
            Button deleteButton = new Button();
            ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/delete.png")));
            deleteIcon.setFitWidth(16);
            deleteIcon.setFitHeight(16);
            deleteButton.setGraphic(deleteIcon);
            deleteButton.setStyle("-fx-background-color: transparent;");
            deleteButton.setOnAction(event -> deleteFournisseur(fournisseur));

            // Add buttons to button container
            buttonContainer.getChildren().addAll(editButton, deleteButton);

            // Add all elements to text container
            textContainer.getChildren().addAll(nameLabel, typeAndContract, phoneLabel);

            // Add text and buttons to the supplier container
            fournisseurContainerItem.getChildren().addAll(textContainer, buttonContainer);

            // Add to VBox inside the ScrollPane
            fournisseurContainer.getChildren().add(fournisseurContainerItem);
        }
    }

    /** ✅ Method to Open Modification Form */
    private void modifyFournisseur(Fournisseur fournisseur, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierFournisseur.fxml"));
            Parent root = loader.load();

            // Get the controller and set the Fournisseur data
            ModifierFournisseur controller = loader.getController();
            controller.setFournisseurData(fournisseur);

            // Load the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** ✅ Method to Delete a Fournisseur */
    private void deleteFournisseur(Fournisseur fournisseur) {
        try {
            ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
            serviceFournisseur.supprimer(fournisseur.getFournisseurId());
            System.out.println("✅ Fournisseur supprimé avec succès!");

            // Reload the updated list
            loadFournisseurs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
