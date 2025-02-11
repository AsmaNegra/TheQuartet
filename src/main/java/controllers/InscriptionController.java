package controllers;

import entities.Ticket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class InscriptionController {

    @FXML
    private TextField lbPrenom;

    @FXML
    private TextField lbNom;

    @FXML
    private Button btnValider;

    @FXML
    void savePerson(ActionEvent event) {
        try {
            Personne p = new personne();
            p.setNom(lbNom.getText());
            p.setPrenom(lbPrenom.getText());
            PersonneService ps = new PersonneService();
            ps.addEntity(p);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetailsPerson.fxml"));
            Parent root = loader.load();
            DetailsPerson dps = loader.getController();
            dps.setResNom(lbNom.getText());
            dps.setResPrenom(lbPrenom.getText());
            lbPrenom.getScene().setRoot(root);
        } catch (IOException e){
            throw new RuntimeException(e)   ;
        }
    }
}
