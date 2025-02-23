package controllers;

import entities.Tache;
import entities.Utilisateur;
import entities.Fournisseur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.ServiceTache;
import services.ServiceUtilisateurEvenement;
import services.ServiceFournisseur;
import entities.Evenement;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AjoutTache implements Initializable {

    @FXML
    private DatePicker dateLimitePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField nomField;

    @FXML
    private Button submitButton;

    @FXML
    private ComboBox<String> prioriteComboBox;

    @FXML
    private ComboBox<String> statutComboBox;

    @FXML
    private ComboBox<String> userAssocieComboBox;

    @FXML
    private ComboBox<String> fournisseurComboBox;

    private int evenementId = 3; // Default event ID for testing

    @FXML
    public void initialize() throws SQLException {
        populateUserAssocieComboBox();
        populateFournisseurComboBox();
    }

    private void populateUserAssocieComboBox() {
        ServiceUtilisateurEvenement service = new ServiceUtilisateurEvenement();
        List<Utilisateur> utilisateurs = service.getUtilisateursByEvenementIdNour(3);

        userAssocieComboBox.getItems().clear();
        for (Utilisateur user : utilisateurs) {
            userAssocieComboBox.getItems().add(user.getNom());
        }
    }

    private void populateFournisseurComboBox() throws SQLException {
        ServiceFournisseur service = new ServiceFournisseur();
        List<Fournisseur> fournisseurs = service.afficher();

        fournisseurComboBox.getItems().clear();
        for (Fournisseur fournisseur : fournisseurs) {
            fournisseurComboBox.getItems().add(fournisseur.getNom());
        }
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        try {
            // Validation des champs obligatoires
            if (nomField.getText().isEmpty()) {
                showAlert("Erreur de validation", "Le nom de la tâche est obligatoire.");
                return;
            }
            if (nomField.getText().length() < 4) {
                showAlert("Erreur de validation", "Le nom de la tâche doit contenir au moins 4 caractères.");
                return;
            }
            if (dateLimitePicker.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner une date limite.");
                return;
            }
            if (prioriteComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner une priorité.");
                return;
            }
            if (statutComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner un statut.");
                return;
            }
            if (userAssocieComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner un utilisateur associé.");
                return;
            }
            if (fournisseurComboBox.getValue() == null) {
                showAlert("Erreur de validation", "Veuillez sélectionner un fournisseur.");
                return;
            }

            // Vérification que la date limite n'est pas antérieure à aujourd'hui
            LocalDate selectedDate = dateLimitePicker.getValue();
            if (selectedDate.isBefore(LocalDate.now())) {
                showAlert("Erreur de validation", "La date limite ne peut pas être antérieure à aujourd'hui.");
                return;
            }

            // Vérification de l'unicité de la tâche par nom
            ServiceTache st = new ServiceTache();
            Tache existingTask = st.chercherTacheParNom(nomField.getText());
            if (existingTask != null) {
                showAlert("Erreur de validation", "Une tâche avec ce nom existe déjà.");
                return;
            }

            // Création d'un nouvel objet Tache
            Tache t = new Tache();
            Evenement e = new Evenement();
            e.setEvenement_id(evenementId);
            Fournisseur f = new Fournisseur();
            f.setNom(fournisseurComboBox.getValue());
            ServiceFournisseur service = new ServiceFournisseur();
            f.setFournisseurId(service.rechercherIdParNom(fournisseurComboBox.getValue()));

            // Attribution des valeurs des champs
            t.setNom(nomField.getText());
            t.setDescription(descriptionField.getText().isEmpty() ? null : descriptionField.getText());
            t.setPriorite(prioriteComboBox.getValue());
            t.setStatut(statutComboBox.getValue());
            t.setEvenement(e);
            t.setFournisseur(f);
            t.setUserAssocie(userAssocieComboBox.getValue());

            // Conversion de la date
            t.setDateLimite(Date.valueOf(selectedDate));

            // Sauvegarde de la tâche
            st.ajouter(t);

            // Chargement de la vue des détails
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventTache.fxml"));
            Parent root = loader.load();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateLimitePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #EEEEEE;");
                }
            }
        });

    }
}
