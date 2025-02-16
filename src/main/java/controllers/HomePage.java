package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomePage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/AjouterEvenement.fxml"));
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/AjouterTickets.fxml"));
//            Scene scene = new Scene(root);
//            primaryStage.setTitle("Ajout de Tickets");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/AjouterTransaction.fxml")));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Ajout de Tickets");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
