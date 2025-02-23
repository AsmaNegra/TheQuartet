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
    private ComboBox<String> contratComboBox;

    @FXML
    private TextField numTelField;

    private final ServiceFournisseur serviceFournisseur = new ServiceFournisseur();

    @FXML
    private void handleSubmit() {
        try {
            if (!validateInput()) {
                return;
            }

            Fournisseur fournisseur = new Fournisseur();


            fournisseur.setNom(nomField.getText());
            fournisseur.setTypeService(typeServiceComboBox.getValue());
            fournisseur.setContrat(contratComboBox.getValue());
            fournisseur.setNum_tel(Integer.parseInt(numTelField.getText()));

            serviceFournisseur.ajouter(fournisseur);
            System.out.println("✅ Fournisseur ajouté avec succès !");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
            nomField.getScene().setRoot(root);
        } catch (IOException | SQLException e) {
            showAlert("Erreur", "Une erreur est survenue lors de l'ajout du fournisseur.");
        }
    }

    private boolean validateInput() {
        if (nomField.getText().isEmpty()) {
            showAlert("Champ vide", "Le champ Nom ne peut pas être vide.");
            return false;
        }
        if (typeServiceComboBox.getValue() == null) {
            showAlert("Sélection requise", "Veuillez sélectionner un type de service.");
            return false;
        }
        if (contratComboBox.getValue() == null) {
            showAlert("Sélection requise", "Veuillez sélectionner un état de contrat.");
            return false;
        }
        if (!numTelField.getText().matches("\\d{8,15}")) {
            showAlert("Numéro invalide", "Le numéro de téléphone doit contenir uniquement des chiffres et avoir une longueur valide (8-15 caractères).");
            return false;
        }
        return true;
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
