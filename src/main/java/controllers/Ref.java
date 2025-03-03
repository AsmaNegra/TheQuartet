package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Ref {

    @FXML
    private AnchorPane sidebar;

    @FXML
    private Label labelUser;

    @FXML
    private Button btnTousEvenements, btnMesEvenements, btnLesFournisseurs, btnAdminEvenements, btnListUser, btnMyAccount, btnLogout;

    @FXML
    void expandSidebar(MouseEvent event) {
        Timeline expandTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        expandTimeline.getKeyFrames().add(keyFrame);
        expandTimeline.play();

        btnTousEvenements.setText("Tous les événements");
        btnMesEvenements.setText("Mes événements");
        btnLesFournisseurs.setText("Les fournisseurs");
        btnAdminEvenements.setText("Admin événements");
        btnListUser.setText("Liste des utilisateurs");
        btnMyAccount.setText("Mon compte");
        btnLogout.setText("Déconnexion");
        labelUser.setVisible(true);
    }

    @FXML
    void collapseSidebar(MouseEvent event) {
        Timeline collapseTimeline = new Timeline();
        KeyValue widthValue = new KeyValue(sidebar.prefWidthProperty(), 70);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), widthValue);
        collapseTimeline.getKeyFrames().add(keyFrame);
        collapseTimeline.play();

        btnTousEvenements.setText("");
        btnMesEvenements.setText("");
        btnLesFournisseurs.setText("");
        btnAdminEvenements.setText("");
        btnListUser.setText("");
        btnMyAccount.setText("");
        btnLogout.setText("");
        labelUser.setVisible(false);
    }

    @FXML
    void handleTousEvenementsClick(ActionEvent event) {
        navigateTo(event, "/ViewAllEvents.fxml");
    }

    @FXML
    void handleMesEvenementsClick(ActionEvent event) {
        navigateTo(event, "/EventOrganisation.fxml");
    }

    @FXML
    void handleLesFournisseursClick(ActionEvent event) {
        navigateTo(event, "/AdminFournisseur.fxml");
    }

    @FXML
    void handleAdminEvenementsClick(ActionEvent event) {
        navigateTo(event, "/EvenementAll.fxml");
    }

    @FXML
    void handleListUserClick(ActionEvent event) {
        navigateTo(event, "/AdminDashboard.fxml");
    }

    @FXML
    void handleMyAccountClick(ActionEvent event) {
        navigateTo(event, "/ViewUserInfo.fxml");
    }

    @FXML
    void handleLogoutClick(ActionEvent event) {
        navigateTo(event, "/Login.fxml");
    }

    private void navigateTo(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
