package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class EventTache {

    @FXML
    private VBox doneColumn;

    @FXML
    private VBox doneTasks;

    @FXML
    private VBox inProgressColumn;

    @FXML
    private VBox inProgressTasks;

    @FXML
    private VBox todoColumn;

    @FXML
    private VBox todoTasks;

    @FXML
    void RedirectBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjoutTache.fxml"));
            Parent root = loader.load();

            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

}
