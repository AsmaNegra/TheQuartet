package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilConroller {

    @FXML
    private Button btn_inscri;

    @FXML
    private Button ntb_authentifi;

    @FXML
    void inscri(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/InscriptionU.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erreur lors du chargement de la page inscription: " + ex.getMessage());
        }
    }


    @FXML
    void authentifi(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Authentification.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erreur lors du chargement de la page authentification: " + ex.getMessage());
        }
    }
}
