package controllers;

import entities.Evenement;
import entities.Fournisseur;
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

public class ModifierFournisseur {

    @FXML
    private TextField nomField;

    @FXML
    private ComboBox<String> typeServiceComboBox;

    @FXML
    private ComboBox<String> contratComboBox;

    @FXML
    private TextField numTelField;

    @FXML
    private Button submitButton;

    private Fournisseur selectedFournisseur;
    private final ServiceFournisseur serviceFournisseur = new ServiceFournisseur();

    /** ✅ Method to Set Fournisseur Data */
    public void setFournisseurData(Fournisseur fournisseur) {
        this.selectedFournisseur = fournisseur;

        nomField.setText(fournisseur.getNom());

        // Populate Type Service ComboBox
        typeServiceComboBox.getItems().clear();
        typeServiceComboBox.getItems().addAll("Traiteur", "Transport", "Décoration", "Sonorisation",
                "Photographie", "Sécurité", "Logistique", "Location de matériel",
                "Animation", "Hébergement", "Restauration", "Vidéographie",
                "Nettoyage", "Service floral", "Gestion des billets",
                "Service technique", "Éclairage", "DJ & Musique",
                "Production audiovisuelle", "Catering VIP");
        typeServiceComboBox.setValue(fournisseur.getTypeService());

        // Populate Contract State ComboBox
        contratComboBox.getItems().clear();
        contratComboBox.getItems().addAll("En attente", "Signé", "Expiré");
        contratComboBox.setValue(fournisseur.getContrat());

        // Set Phone Number
        numTelField.setText(String.valueOf(fournisseur.getNum_tel()));
    }

    /** ✅ Handle Fournisseur Update */
    @FXML
    public void updateFournisseur(ActionEvent event) {
        try {
            selectedFournisseur.setNom(nomField.getText());
            selectedFournisseur.setTypeService(typeServiceComboBox.getValue());
            selectedFournisseur.setContrat(contratComboBox.getValue());
            selectedFournisseur.setNum_tel(Integer.parseInt(numTelField.getText()));
             // Call service to update the database
            System.out.println(selectedFournisseur);
            serviceFournisseur.modifier(selectedFournisseur);

            // Redirect back to Fournisseur list
            redirectBack(event);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** ✅ Redirect to Fournisseur List */
    @FXML
    public void redirectBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml")); // Change to your actual FXML file
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
