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
    public void initialize() {
        // Enable drag and drop for all task columns
        enableDragAndDrop(todoTasks);
        enableDragAndDrop(inProgressTasks);
        enableDragAndDrop(doneTasks);

        // Add sample tasks
        addTask(todoTasks, "Task 1");
        addTask(todoTasks, "Task 2");
        addTask(inProgressTasks, "Task 3");
        addTask(doneTasks, "Task 4");
    }

    private void addTask(VBox column, String taskText) {
        Label task = new Label(taskText);
        task.setStyle("-fx-background-color: white; -fx-padding: 5px 10px; -fx-border-radius: 5px; -fx-border-color: #ccc; -fx-font-size: 14px;");

        // Enable Drag-and-Drop for Task
        task.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = task.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(task.getText()); // Store the task text
            db.setContent(content);
            db.setDragView(task.snapshot(null, null)); // Use snapshot of task as drag preview
            event.consume();
        });

        task.setOnDragDone(DragEvent::consume);
        column.getChildren().add(task);
    }

    private void enableDragAndDrop(VBox column) {
        column.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != column && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        column.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
                Label draggedTask = new Label(db.getString());
                draggedTask.setStyle("-fx-background-color: white; -fx-padding: 5px 10px; -fx-border-radius: 5px; -fx-border-color: #ccc; -fx-font-size: 14px;");

                // Enable dragging for new task
                draggedTask.setOnDragDetected((MouseEvent e) -> {
                    Dragboard dragboard = draggedTask.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(draggedTask.getText());
                    dragboard.setContent(content);
                    dragboard.setDragView(draggedTask.snapshot(null, null));
                    e.consume();
                });

                ((VBox) event.getGestureSource()).getChildren().removeIf(node -> node instanceof Label && ((Label) node).getText().equals(db.getString()));
                column.getChildren().add(draggedTask);
                event.setDropCompleted(true);
            }
            event.consume();
        });
    }
    @FXML
    void RedirectBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjoutTache.fxml"));
            Parent root = loader.load();

            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace(); // Meilleur pour le débogage
        }
    }

}
