
package controllers;

import entities.Evenement;
import entities.Feedback;
import entities.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.ServiceFeedback;
import utils.BadWordsFilter;

import java.sql.SQLException;
import java.util.Date;

public class AjouterFeedbackController {
    @FXML
    private Label nomEvenementLabel;

    @FXML
    private Spinner<Integer> noteSpinner;

    @FXML
    private TextArea commentaireArea;

    @FXML
    private Button ajouterButton;

    @FXML
    private Button annulerButton;

    private Evenement evenement;
    private ServiceFeedback serviceFeedback;
    private ListeFeedbacksController parentController;

    @FXML
    public void initialize() {
        serviceFeedback = new ServiceFeedback();

        // Configuration du Spinner pour la note
        SpinnerValueFactory<Integer> valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 5);
        noteSpinner.setValueFactory(valueFactory);
    }

    public void initData(Evenement evenement, ListeFeedbacksController parentController) {
        this.evenement = evenement;
        this.parentController = parentController;
        nomEvenementLabel.setText(evenement.getNom());
    }

    @FXML
    private void ajouterFeedback() {
        if (!validerChamps()) {
            return;
        }

        try {
            Feedback feedback = new Feedback();
            feedback.setNote(noteSpinner.getValue());
            feedback.setCommentaire(commentaireArea.getText());
            feedback.setDate_feedback(new Date());
            feedback.setEvenement_id(evenement);

            // TODO: Remplacer par l'utilisateur actuellement connecté
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setUtilisateurId(1); // À remplacer par l'ID de l'utilisateur connecté
            feedback.setUtilisateur_id(utilisateur);

            serviceFeedback.ajouter(feedback);

            // Rafraîchir la liste des feedbacks dans la fenêtre parente
            if (parentController != null) {
                parentController.refreshFeedbacks();
            }

            // Fermer la fenêtre
            fermerFenetre();

        } catch (SQLException e) {
            afficherErreur("Erreur lors de l'ajout du feedback", e.getMessage());
        }
    }

    private boolean validerChamps() {
        String commentaire = commentaireArea.getText().trim();

        if (commentaire.isEmpty()) {
            afficherMessage("Champs requis", "Le commentaire est obligatoire.",
                "Veuillez saisir un commentaire.", Alert.AlertType.ERROR);
            return false;
        }

        if (BadWordsFilter.containsBadWords(commentaire)) {
            String badWords = BadWordsFilter.findBadWords(commentaire);
            afficherMessage("Contenu inapproprié",
                "Le commentaire contient des mots inappropriés",
                "Veuillez supprimer les mots inappropriés" ,
                Alert.AlertType.ERROR);
            return false;
        }

        return true;
    }

    private void afficherMessage(String titre, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(titre);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    @FXML
    private void annuler() {
        fermerFenetre();
    }

    private void fermerFenetre() {
        Stage stage = (Stage) annulerButton.getScene().getWindow();
        stage.close();
    }

    private void afficherErreur(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(titre);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
