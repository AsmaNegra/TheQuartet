package controllers;

import entities.Evenement;
import entities.Fournisseur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceFournisseur;

import java.io.IOException;
import java.sql.SQLException;

public class ModifierFournisseur {
    @FXML
    public Button btnLogout;
    @FXML
    private Button btnSitemap;
    @FXML
    private Button btnGift;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnHome1;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private Label labelUser;

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
            selectedFournisseur.setNum_tel(numTelField.getText());
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminFournisseur.fxml")); // Change to your actual FXML file
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void expandSidebar(MouseEvent event) {
        // Animate sidebar expansion (e.g., from 70 to 200 pixels)
        Timeline expandTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        expandTimeline.getKeyFrames().add(keyFrame);
        expandTimeline.play();

        // Set the text for each button
        btnSitemap.setText("Mes evenements");
        btnGift.setText("Admin");
        btnHome.setText("Tous les evenements");
        btnHome1.setText("My Account");
        btnLogout.setText("Logout");
        labelUser.setVisible(true);
    }

    @FXML
    void collapseSidebar(MouseEvent event) {
        // Animate sidebar collapse (e.g., back to 70 pixels)
        Timeline collapseTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 70);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        collapseTimeline.getKeyFrames().add(keyFrame);
        collapseTimeline.play();

        // Clear the text for each button
        btnSitemap.setText("");
        btnGift.setText("");
        btnHome.setText("");
        btnHome1.setText("");
        btnLogout.setText("");
        labelUser.setVisible(false);
    }



    @FXML
    void handleGiftClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminFournisseur.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleHomeClick(ActionEvent event) {
        try {

            // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ref.fxml"));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleSitemapClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventOrganisation.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLogoutClick(ActionEvent event) {

    }
}
