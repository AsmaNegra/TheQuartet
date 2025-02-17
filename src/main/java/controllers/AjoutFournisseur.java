package controllers;

import entities.Fournisseur;
import entities.Evenement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.ServiceFournisseur;
import java.io.IOException;
import java.sql.SQLException;

public class AjoutFournisseur {



    @FXML
    private TextField nomField;

    @FXML
    private ComboBox<String> typeServiceComboBox;

    @FXML
    private ComboBox<String> contratComboBox; // New ComboBox for contract state

    private final ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
    @FXML
    private TextField numTelField; // New field for phone number

    @FXML
    private void handleSubmit() {
        try {
            Fournisseur fournisseur = new Fournisseur();
            Evenement evenement = new Evenement();
            evenement.setEvenement_id(4);
            fournisseur.setNom(nomField.getText());
            fournisseur.setTypeService(typeServiceComboBox.getValue());
            fournisseur.setContrat(contratComboBox.getValue()); // Get selected value from dropdown
            fournisseur.setEvenement(evenement);
            fournisseur.setNum_tel(Integer.parseInt(numTelField.getText())); // Get phone number
            serviceFournisseur.ajouter(fournisseur);
            System.out.println("✅ Fournisseur ajouté avec succès !");
            // Chargement de la vue des détails
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();

            // Changement de scène
            nomField.getScene().setRoot(root);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void RedirectBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
