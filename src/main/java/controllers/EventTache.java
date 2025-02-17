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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceTache;
import entities.Tache;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class EventTache implements Initializable {

    @FXML
    private VBox doneTasks;

    @FXML
    private VBox inProgressTasks;

    @FXML
    private VBox todoTasks;

    private final ServiceTache serviceTache = new ServiceTache();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadTasks() throws SQLException {
        List<Tache> enAttente = serviceTache.afficherTachesToDo();
        List<Tache> enCours = serviceTache.afficherTachesEnCours();
        List<Tache> terminees = serviceTache.afficherTachesDone();

        System.out.println("To Do: " + enAttente.size());
        System.out.println("In Progress: " + enCours.size());
        System.out.println("Done: " + terminees.size());

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
            HBox buttonContainer = new HBox(10);

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
        }
    }

    private void modifyTask(Tache task, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierTache.fxml"));
            Parent root = loader.load();
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
}
