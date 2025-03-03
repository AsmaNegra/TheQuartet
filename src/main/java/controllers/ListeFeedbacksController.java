package controllers;

import entities.Evenement;
import entities.Feedback;
import entities.Utilisateur;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.ServiceFeedback;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

public class ListeFeedbacksController {
    @FXML
    private Label nomEvenementLabel;

    @FXML
    private TableView<Feedback> feedbackTable;

    @FXML
    private TableColumn<Feedback, Integer> noteColumn;

    @FXML
    private TableColumn<Feedback, String> commentaireColumn;

    @FXML
    private TableColumn<Feedback, Date> dateColumn;

    @FXML
    private TableColumn<Feedback, String> utilisateurColumn;

    @FXML
    private TableColumn<Feedback, Void> actionsColumn;

    @FXML
    private Button ajouterButton;

    @FXML
    private Button fermerButton;

    @FXML
    private Button effacerRechercheButton;

    @FXML
    private ComboBox<String> noteFilterComboBox;

    @FXML
    private DatePicker dateFilterPicker;

    @FXML
    private Button resetFilterButton;

    private Evenement evenement;
    private ServiceFeedback serviceFeedback;
    private ObservableList<Feedback> feedbackList;
    @FXML
    private TextField rechercheField;

    private ObservableList<Feedback> feedbackListComplete = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serviceFeedback = new ServiceFeedback();
        feedbackList = FXCollections.observableArrayList();

        // Configuration des colonnes
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        noteColumn.setCellFactory(column -> new TableCell<Feedback, Integer>() {
            @Override
            protected void updateItem(Integer note, boolean empty) {
                super.updateItem(note, empty);
                if (empty || note == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText("★".repeat(note));
                    setStyle("-fx-text-fill: gold; -fx-font-size: 18px; -fx-font-weight: bold;");
                }
            }
        });

        commentaireColumn.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date_feedback"));
        utilisateurColumn.setCellValueFactory(cellData -> {
            Feedback feedback = cellData.getValue();
            if (feedback != null && feedback.getUtilisateur_id() != null) {
                return new SimpleStringProperty(feedback.getUtilisateur_id().getNom());
            }
            return new SimpleStringProperty("");
        });

        // Configuration des actions
        setupActionsColumn();

        // Configuration de la recherche
        rechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrerFeedbacks(newValue);
        });

        noteFilterComboBox.getItems().addAll(
            "Toutes les notes",
            "5 étoiles",
            "4 étoiles",
            "3 étoiles",
            "2 étoiles",
            "1 étoile"
        );
        noteFilterComboBox.setValue("Toutes les notes");

        // Ajouter les listeners pour les filtres
        noteFilterComboBox.valueProperty().addListener((obs, oldVal, newVal) -> appliquerFiltres());
        dateFilterPicker.valueProperty().addListener((obs, oldVal, newVal) -> appliquerFiltres());

        // Configurer le bouton de réinitialisation
        resetFilterButton.setOnAction(e -> resetFiltres());
    }

    private void filtrerFeedbacks(String recherche) {
        appliquerFiltres();
    }

    private boolean correspondARecherche(Feedback feedback, String recherche) {
        return (feedback.getCommentaire() != null &&
            feedback.getCommentaire().toLowerCase().contains(recherche))
            || (feedback.getUtilisateur_id() != null &&
            feedback.getUtilisateur_id().getNom().toLowerCase().contains(recherche))
            || (String.valueOf(feedback.getNote()).contains(recherche))
            || (feedback.getDate_feedback() != null &&
            feedback.getDate_feedback().toString().toLowerCase().contains(recherche));
    }


    private void setupActionsColumn() {
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button modifierBtn = new Button("Modifier");
            private final Button supprimerBtn = new Button("Supprimer");
            private final HBox box = new HBox(5, modifierBtn, supprimerBtn);

            {
                modifierBtn.setOnAction(event -> {
                    Feedback feedback = getTableView().getItems().get(getIndex());
                    modifierFeedback(feedback);
                });

                supprimerBtn.setOnAction(event -> {
                    Feedback feedback = getTableView().getItems().get(getIndex());
                    supprimerFeedback(feedback);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(box);
                }
            }
        });
    }

    public void initData(Evenement evenement) {
        this.evenement = evenement;
        nomEvenementLabel.setText(evenement.getNom());
        chargerFeedbacks();
    }

    private void chargerFeedbacks() {
        try {
            feedbackListComplete.clear();
            feedbackListComplete.addAll(serviceFeedback.getFeedbacksParEvenement(evenement.getEvenement_id()));

            // Appliquer le filtre courant
            String rechercheCourante = rechercheField.getText();
            if (rechercheCourante != null && !rechercheCourante.isEmpty()) {
                filtrerFeedbacks(rechercheCourante);
            } else {
                feedbackTable.setItems(feedbackListComplete);
            }
        } catch (SQLException e) {
            afficherErreur("Erreur lors du chargement des feedbacks", e.getMessage());
        }
    }

    @FXML
    private void ajouterFeedback() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterFeedback.fxml"));
            Parent root = loader.load();

            AjouterFeedbackController controller = loader.getController();
            controller.initData(evenement, this);

            Stage stage = new Stage();
            stage.setTitle("Ajouter un feedback");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            afficherErreur("Erreur", "Impossible d'ouvrir la fenêtre d'ajout : " + e.getMessage());
        }
    }

    private void modifierFeedback(Feedback feedback) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierFeedback.fxml"));
            Parent root = loader.load();

            ModifierFeedbackController controller = loader.getController();
            controller.initData(feedback, this);

            Stage stage = new Stage();
            stage.setTitle("Modifier le feedback");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            afficherErreur("Erreur", "Impossible d'ouvrir la fenêtre de modification : " + e.getMessage());
        }
    }

    private void supprimerFeedback(Feedback feedback) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation de suppression");
        confirmation.setHeaderText("Supprimer le feedback");
        confirmation.setContentText("Êtes-vous sûr de vouloir supprimer ce feedback ?");

        if (confirmation.showAndWait().get() == ButtonType.OK) {
            try {
                serviceFeedback.supprimer(feedback.getFeedback_id());
                chargerFeedbacks();
            } catch (SQLException e) {
                afficherErreur("Erreur lors de la suppression", e.getMessage());
            }
        }
    }

    @FXML
    private void fermer() {
        Stage stage = (Stage) fermerButton.getScene().getWindow();
        stage.close();
    }

    private void afficherErreur(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(titre);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void refreshFeedbacks() {
        chargerFeedbacks();
    }

    @FXML
    private void effacerRecherche() {
        rechercheField.clear();
        feedbackTable.setItems(feedbackListComplete);
        effacerRechercheButton.setVisible(false);
    }

    private void appliquerFiltres() {
        if (feedbackListComplete == null) return;

        ObservableList<Feedback> feedbacksFiltres = feedbackListComplete.stream()
            .filter(feedback -> passerFiltreNote(feedback))
            .filter(feedback -> passerFiltreDate(feedback))
            .filter(feedback -> passerFiltreRecherche(feedback))
            .collect(Collectors.toCollection(FXCollections::observableArrayList));

        feedbackTable.setItems(feedbacksFiltres);
    }

    private boolean passerFiltreNote(Feedback feedback) {
        String filtre = noteFilterComboBox.getValue();
        if (filtre == null || filtre.equals("Toutes les notes")) return true;

        int note = feedback.getNote();
        switch (filtre) {
            case "5 étoiles": return note == 5;
            case "4 étoiles": return note == 4;
            case "3 étoiles": return note == 3;
            case "2 étoiles": return note == 2;
            case "1 étoile": return note == 1;
            default: return true;
        }
    }

    private boolean passerFiltreDate(Feedback feedback) {
        LocalDate dateFiltre = dateFilterPicker.getValue();
        if (dateFiltre == null) return true;

        LocalDate feedbackDate = feedback.getDate_feedback().toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

        return feedbackDate.equals(dateFiltre);
    }

    private boolean passerFiltreRecherche(Feedback feedback) {
        String recherche = rechercheField.getText();
        if (recherche == null || recherche.trim().isEmpty()) return true;

        String rechercheLower = recherche.toLowerCase();
        return (feedback.getCommentaire() != null &&
            feedback.getCommentaire().toLowerCase().contains(rechercheLower))
            || (feedback.getUtilisateur_id() != null &&
            feedback.getUtilisateur_id().getNom().toLowerCase().contains(rechercheLower))
            || (String.valueOf(feedback.getNote()).contains(rechercheLower))
            || (feedback.getDate_feedback() != null &&
            feedback.getDate_feedback().toString().toLowerCase().contains(rechercheLower));
    }

    @FXML
    private void resetFiltres() {
        rechercheField.clear();
        noteFilterComboBox.setValue("Toutes les notes");
        dateFilterPicker.setValue(null);
        feedbackTable.setItems(feedbackListComplete);
    }
}
