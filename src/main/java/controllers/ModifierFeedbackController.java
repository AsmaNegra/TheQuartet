package controllers;

import entities.Evenement;
import entities.Feedback;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.ServiceFeedback;
import utils.BadWordsFilter;

import java.sql.SQLException;

public class ModifierFeedbackController {
    @FXML
    private Label nomEvenementLabel;

    @FXML
    private Spinner<Integer> noteSpinner;

    @FXML
    private TextArea commentaireArea;

    @FXML
    private Button modifierButton;

    @FXML
    private Button annulerButton;

    private Feedback feedback;
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

    public void initData(Feedback feedback, ListeFeedbacksController parentController) {
        this.feedback = feedback;
        this.parentController = parentController;

        // Remplir les champs avec les données existantes
        nomEvenementLabel.setText(feedback.getEvenement_id().getNom());
        noteSpinner.getValueFactory().setValue(feedback.getNote());
        commentaireArea.setText(feedback.getCommentaire());
    }

    @FXML
    private void modifierFeedback() {
        if (!validerChamps()) {
            return;
        }

        try {
            // Mettre à jour les valeurs du feedback
            feedback.setNote(noteSpinner.getValue());
            feedback.setCommentaire(commentaireArea.getText());

            // Sauvegarder les modifications
            serviceFeedback.modifier(feedback);

            // Rafraîchir la liste des feedbacks dans la fenêtre parente
            if (parentController != null) {
                parentController.refreshFeedbacks();
            }

            // Afficher un message de succès
            afficherMessage("Succès", "Modification réussie",
                "Le feedback a été modifié avec succès.", Alert.AlertType.INFORMATION);

            // Fermer la fenêtre
            fermerFenetre();

        } catch (SQLException e) {
            afficherMessage("Erreur", "Erreur lors de la modification",
                e.getMessage(), Alert.AlertType.ERROR);
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


    @FXML
    private void annuler() {
        fermerFenetre();
    }

    private void fermerFenetre() {
        Stage stage = (Stage) annulerButton.getScene().getWindow();
        stage.close();
    }

    private void afficherMessage(String titre, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(titre);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
