package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Evenement;
import entities.Feedback;
import entities.Utilisateur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceEvenement;
import services.ServiceFeedback;
import services.ServiceUtilisateurEvenement;
import utils.AiUtility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class EventFeedbackController implements Initializable {
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
    private Button backButton;
    @FXML
    private Label eventNameLabel;
    @FXML
    private ImageView eventImageView;
    @FXML
    private Label eventTitleLabel;
    @FXML
    private Label eventDateLabel;
    @FXML
    private Label eventLocationLabel;
    @FXML
    private Label eventCategoryLabel;
    @FXML
    private HBox averageRatingContainer;
    @FXML
    private Label ratingValueLabel;
    @FXML
    private Label totalReviewsLabel;
    @FXML
    private VBox reviewsContainer;
    @FXML
    private Button addReviewButton;

    private ServiceFeedback serviceFeedback = new ServiceFeedback();
    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private ServiceUtilisateurEvenement serviceUtilisateurEvenement = new ServiceUtilisateurEvenement();

    private Evenement currentEvent;
    private Utilisateur currentUser; // This would be set from your authentication system

    // For star rating in popup
    private int selectedRating = 0;
    private HBox ratingStarsContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // This will be filled when setCurrentEvent is called
    }

    public void setCurrentEvent(Evenement event) {
        this.currentEvent = event;

        // Set current user (for testing purposes - replace with actual user session)
        // Normally you would get this from your authentication system
        this.currentUser = serviceUtilisateurEvenement.getUtilisateurById(1); // Replace with actual logged in user ID

        updateUI();
    }

    private void updateUI() {
        if (currentEvent == null) return;

        // Set event details
        eventNameLabel.setText("Avis sur l'événement: " + currentEvent.getNom());
        eventTitleLabel.setText(currentEvent.getNom());

        // Format dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        eventDateLabel.setText("Date: " + dateFormat.format(currentEvent.getDate_debut()) +
                " - " + dateFormat.format(currentEvent.getDate_fin()));

        eventLocationLabel.setText("Lieu: " + currentEvent.getLieu());
        eventCategoryLabel.setText("Catégorie: " + currentEvent.getCategorie());

        // Load event image
        try {
            if (currentEvent.getImage_event() != null && !currentEvent.getImage_event().isEmpty()) {
                String projectPath = System.getProperty("user.dir");
                String fullPath = projectPath + "/src/main/resources/" + currentEvent.getImage_event();
                File file = new File(fullPath);
                if (file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    eventImageView.setImage(image);
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading event image: " + e.getMessage());
        }

        // Load reviews
        loadReviews();
    }

    private void loadReviews() {
        try {
            reviewsContainer.getChildren().clear();

            // Get all feedbacks for this event
            List<Feedback> feedbacks = serviceFeedback.getFeedbacksByEventId(currentEvent.getEvenement_id());

            if (feedbacks.isEmpty()) {
                Label noReviewsLabel = new Label("Aucun avis pour cet événement pour le moment.");
                noReviewsLabel.setStyle("-fx-font-style: italic; -fx-text-fill: #645F71;");
                reviewsContainer.getChildren().add(noReviewsLabel);

                // Update average rating display
                updateAverageRating(0, 0);
                return;
            }

            // Calculate average rating
            double averageRating = 0;
            try {
                averageRating = serviceFeedback.getAverageRatingForEvent(currentEvent.getEvenement_id());
            } catch (SQLException e) {
                System.err.println("Error calculating average rating: " + e.getMessage());
                e.printStackTrace();
            }

            // Update average rating display
            updateAverageRating(averageRating, feedbacks.size());

            // Add each review
            for (Feedback feedback : feedbacks) {
                VBox reviewCard = createReviewCard(feedback);
                reviewsContainer.getChildren().add(reviewCard);
            }

        } catch (SQLException e) {
            System.err.println("Error loading reviews: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void updateAverageRating(double rating, int count) {
        // Clear previous stars
        averageRatingContainer.getChildren().clear();

        // Add stars based on rating
        for (int i = 1; i <= 5; i++) {
            FontAwesomeIconView star = new FontAwesomeIconView(FontAwesomeIcon.STAR);
            star.setSize("1.5em");

            if (i <= Math.round(rating)) {
                star.getStyleClass().add("star-filled");
                star.setFill(Color.valueOf("#f8ce0b"));
            } else {
                star.getStyleClass().add("star-empty");
                star.setFill(Color.valueOf("#CCCCCC"));
            }

            averageRatingContainer.getChildren().add(star);
        }

        // Update labels
        ratingValueLabel.setText(String.format("%.1f/5", rating));
        totalReviewsLabel.setText("(" + count + " avis)");
    }

    private VBox createReviewCard(Feedback feedback) {
        VBox reviewCard = new VBox(10);
        reviewCard.getStyleClass().add("review-card");

        // User info and date
        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.CENTER_LEFT);

        // User avatar (circle with first letter)
        Circle userAvatar = new Circle(20);
        userAvatar.setFill(Color.valueOf("#d87769"));

        String userName = feedback.getUtilisateur_id().getNom();
        Label avatarLabel = new Label(userName.substring(0, 1).toUpperCase());
        avatarLabel.setTextFill(Color.WHITE);
        avatarLabel.setStyle("-fx-font-weight: bold;");

        StackPane avatarPane = new StackPane(userAvatar, avatarLabel);

        // User name and date
        VBox userInfoBox = new VBox(5);
        Label nameLabel = new Label(userName);
        nameLabel.getStyleClass().add("review-author");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Label dateLabel = new Label(dateFormat.format(feedback.getDate_feedback()));
        dateLabel.getStyleClass().add("review-date");

        userInfoBox.getChildren().addAll(nameLabel, dateLabel);

        // Star rating
        HBox ratingBox = new HBox(2);
        ratingBox.setAlignment(Pos.CENTER_RIGHT);
        ratingBox.getStyleClass().add("star-rating");
        HBox.setHgrow(ratingBox, Priority.ALWAYS);

        for (int i = 1; i <= 5; i++) {
            FontAwesomeIconView star = new FontAwesomeIconView(FontAwesomeIcon.STAR);
            star.setSize("1.2em");

            if (i <= feedback.getNote()) {
                star.getStyleClass().add("star-filled");
                star.setFill(Color.valueOf("#f8ce0b"));
            } else {
                star.getStyleClass().add("star-empty");
                star.setFill(Color.valueOf("#CCCCCC"));
            }

            ratingBox.getChildren().add(star);
        }

        headerBox.getChildren().addAll(avatarPane, userInfoBox, ratingBox);

        // Comment section
        VBox commentBox = new VBox(5);
        Label commentLabel = new Label(feedback.getCommentaire());
        commentLabel.getStyleClass().add("review-comment");
        commentLabel.setWrapText(true);

        // Add action buttons only if the feedback belongs to the current user
        if (currentUser != null && feedback.getUtilisateur_id().getUtilisateurId() == currentUser.getUtilisateurId()) {
            HBox actionButtonsBox = new HBox(10);
            actionButtonsBox.setAlignment(Pos.CENTER_RIGHT);

            // Edit button
            Button editButton = new Button();
            editButton.getStyleClass().add("action-button");
            editButton.getStyleClass().add("edit-button");
            FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
            editIcon.setFill(Color.WHITE);
            editButton.setGraphic(editIcon);
            editButton.setTooltip(new Tooltip("Modifier"));

            // Delete button
            Button deleteButton = new Button();
            deleteButton.getStyleClass().add("action-button");
            deleteButton.getStyleClass().add("delete-button");
            FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
            deleteIcon.setFill(Color.WHITE);
            deleteButton.setGraphic(deleteIcon);
            deleteButton.setTooltip(new Tooltip("Supprimer"));

            // Add event handlers
            editButton.setOnAction(e -> showEditFeedbackDialog(feedback));
            deleteButton.setOnAction(e -> confirmDeleteFeedback(feedback));

            actionButtonsBox.getChildren().addAll(editButton, deleteButton);
            commentBox.getChildren().addAll(commentLabel, actionButtonsBox);
        } else {
            commentBox.getChildren().add(commentLabel);
        }

        // Add all sections to the review card
        reviewCard.getChildren().addAll(headerBox, new Separator(), commentBox);

        return reviewCard;
    }

    /**
     * Affiche une boîte de dialogue pour modifier un feedback
     */
    private void showEditFeedbackDialog(Feedback feedback) {
        try {
            // Créer une boîte de dialogue
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Modifier votre avis");

            // Créer le contenu de la boîte de dialogue
            VBox dialogContent = new VBox(15);
            dialogContent.setPadding(new Insets(20));
            dialogContent.getStyleClass().add("review-dialog");
            dialogContent.setPrefWidth(500);

            // Informations sur l'événement
            Label titleLabel = new Label("Modifier votre avis sur " + feedback.getEvenement_id().getNom());
            titleLabel.getStyleClass().add("review-dialog-title");

            // Zone de commentaire
            Label commentLabel = new Label("Votre commentaire:");
            TextArea commentArea = new TextArea(feedback.getCommentaire());
            commentArea.setPrefRowCount(5);
            commentArea.getStyleClass().add("comment-area");
            commentArea.setWrapText(true);

            // Évaluation par étoiles
            Label ratingLabel = new Label("Votre note:");
            ratingLabel.getStyleClass().add("rating-instruction");

            // Créer le sélecteur d'étoiles
            selectedRating = feedback.getNote();
            ratingStarsContainer = new HBox(5);
            ratingStarsContainer.setAlignment(Pos.CENTER_LEFT);
            ratingStarsContainer.getStyleClass().add("rating-selector");

            for (int i = 1; i <= 5; i++) {
                final int starValue = i;
                FontAwesomeIconView star = new FontAwesomeIconView(FontAwesomeIcon.STAR);
                star.setSize("1.5em");

                if (i <= selectedRating) {
                    star.setFill(Color.valueOf("#f8ce0b"));
                    star.getStyleClass().add("star-filled");
                } else {
                    star.setFill(Color.valueOf("#CCCCCC"));
                    star.getStyleClass().add("star-empty");
                }

                // Événement de clic pour les étoiles
                star.setOnMouseClicked(e -> {
                    selectedRating = starValue;
                    updateStarRating();
                });

                ratingStarsContainer.getChildren().add(star);
            }

            // Ajouter tous les éléments à la boîte de dialogue
            dialogContent.getChildren().addAll(
                    titleLabel,
                    new Separator(),
                    commentLabel,
                    commentArea,
                    ratingLabel,
                    ratingStarsContainer
            );

            // Définir le contenu de la boîte de dialogue
            dialog.getDialogPane().setContent(dialogContent);

            // Ajouter des boutons
            ButtonType submitButtonType = new ButtonType("Mettre à jour", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButtonType = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(submitButtonType, cancelButtonType);

            // Styliser la boîte de dialogue
            dialog.getDialogPane().getStylesheets().add(getClass().getResource("/feedback_styles.css").toExternalForm());

            // Afficher la boîte de dialogue et traiter le résultat
            Optional<ButtonType> result = dialog.showAndWait();

            // Dans la méthode showEditFeedbackDialog de EventFeedbackController.java
// Remplacez la section de validation et de mise à jour du feedback par le code suivant:

            if (result.isPresent() && result.get() == submitButtonType) {
                // Valider l'entrée
                String comment = commentArea.getText().trim();

                if (comment.isEmpty()) {
                    showAlert("Commentaire requis", "Veuillez ajouter un commentaire pour soumettre votre avis.");
                    return;
                }

                if (selectedRating == 0) {
                    showAlert("Note requise", "Veuillez donner une note (1-5 étoiles) pour soumettre votre avis.");
                    return;
                }

                // Vérifier si le commentaire modifié contient des mots inappropriés
                AiUtility.ModerationResult moderationResult = AiUtility.moderateComment(comment);

                if (moderationResult.estInapproprie()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Contenu inapproprié détecté");
                    alert.setHeaderText("Votre commentaire contient du contenu inapproprié");

//                    VBox dialogContent = new VBox(10);
                    dialogContent.setPadding(new Insets(10));

                    Label reasonLabel = new Label("Raison: " + moderationResult.getRaison());
                    reasonLabel.setWrapText(true);

                    Label suggestionLabel = new Label("Suggestion de commentaire modéré:");
                    suggestionLabel.setStyle("-fx-font-weight: bold;");

                    Label moderatedCommentLabel = new Label(moderationResult.getCommentaireModere());
                    moderatedCommentLabel.setWrapText(true);
                    moderatedCommentLabel.setStyle("-fx-font-style: italic;");

                    dialogContent.getChildren().addAll(reasonLabel, new Separator(), suggestionLabel, moderatedCommentLabel);

                    alert.getDialogPane().setContent(dialogContent);

                    ButtonType useModeratedButton = new ButtonType("Utiliser version modérée");
                    ButtonType editButton = new ButtonType("Modifier mon commentaire");
                    ButtonType cancelButton = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(useModeratedButton, editButton, cancelButton);

                    Optional<ButtonType> moderationResponse = alert.showAndWait();

                    if (moderationResponse.isPresent()) {
                        if (moderationResponse.get() == useModeratedButton) {
                            // Utiliser la version modérée du commentaire
                            comment = moderationResult.getCommentaireModere();
                        } else if (moderationResponse.get() == editButton) {
                            // Retourner à la boîte de dialogue pour modification
                            commentArea.setText(comment);
                            showEditFeedbackDialog(feedback);
                            return;
                        } else {
                            // Annuler la modification du commentaire
                            return;
                        }
                    } else {
                        return;
                    }
                }

                // Mettre à jour le feedback avec le commentaire approuvé ou modéré
                feedback.setNote(selectedRating);
                feedback.setCommentaire(comment);

                try {
                    serviceFeedback.modifier(feedback);

                    // Actualiser les avis
                    loadReviews();

                    // Afficher un message de succès
                    showAlert("Avis mis à jour", "Votre avis a été mis à jour avec succès.", Alert.AlertType.INFORMATION);
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la mise à jour de l'avis: " + e.getMessage());
                    e.printStackTrace();
                    showAlert("Erreur", "Une erreur s'est produite lors de la mise à jour de votre avis: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Erreur", "Une erreur s'est produite: " + e.getMessage());
        }
    }

    /**
     * Demande confirmation avant de supprimer un feedback
     */
    private void confirmDeleteFeedback(Feedback feedback) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmation de suppression");
        confirmAlert.setHeaderText("Supprimer votre avis");
        confirmAlert.setContentText("Êtes-vous sûr de vouloir supprimer votre avis ? Cette action est irréversible.");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Supprimer le feedback
                serviceFeedback.supprimer(feedback.getFeedback_id());

                // Actualiser les avis
                loadReviews();

                // Afficher un message de succès
                showAlert("Avis supprimé", "Votre avis a été supprimé avec succès.", Alert.AlertType.INFORMATION);
            } catch (SQLException e) {
                System.err.println("Erreur lors de la suppression de l'avis: " + e.getMessage());
                e.printStackTrace();
                showAlert("Erreur", "Une erreur s'est produite lors de la suppression de votre avis: " + e.getMessage());
            }
        }
    }

    @FXML
    void handleBackButton(ActionEvent event) {
        try {
            // Navigate back to the events view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));
            Parent root = loader.load();
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showAddReviewDialog(ActionEvent event) {
        try {
            // Check if user is registered for this event
            boolean isRegistered = false;
            try {
                List<Utilisateur> registeredUsers = serviceUtilisateurEvenement.getUtilisateursByEvenementId(currentEvent.getEvenement_id());
                for (Utilisateur user : registeredUsers) {
                    if (user.getUtilisateurId() == currentUser.getUtilisateurId()) {
                        isRegistered = true;
                        break;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // If not registered, show message
            if (!isRegistered) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Avis impossible");
                alert.setContentText("Vous devez être inscrit à cet événement pour pouvoir donner votre avis.");
                alert.showAndWait();
                return;
            }

            // Check if user has already reviewed
            try {
                if (serviceFeedback.userHasReviewed(currentUser.getUtilisateurId(), currentEvent.getEvenement_id())) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Avis déjà donné");
                    alert.setContentText("Vous avez déjà donné votre avis sur cet événement.");
                    alert.showAndWait();
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Create a dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Donner votre avis");

            // Create the dialog content
            VBox dialogContent = new VBox(15);
            dialogContent.setPadding(new Insets(20));
            dialogContent.getStyleClass().add("review-dialog");
            dialogContent.setPrefWidth(500);

            // Event info
            Label titleLabel = new Label("Votre avis sur " + currentEvent.getNom());
            titleLabel.getStyleClass().add("review-dialog-title");

            HBox eventInfoBox = new HBox(15);
            eventInfoBox.setAlignment(Pos.CENTER_LEFT);

            // Event image
            ImageView imageView = new ImageView();
            imageView.setFitHeight(80);
            imageView.setFitWidth(120);
            imageView.setPreserveRatio(true);

            if (currentEvent.getImage_event() != null && !currentEvent.getImage_event().isEmpty()) {
                String projectPath = System.getProperty("user.dir");
                String fullPath = projectPath + "/src/main/resources/" + currentEvent.getImage_event();
                File file = new File(fullPath);
                if (file.exists()) {
                    imageView.setImage(new Image(file.toURI().toString()));
                }
            }

            // Event details
            VBox detailsBox = new VBox(5);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Label dateLabel = new Label("Date: " + dateFormat.format(currentEvent.getDate_debut()));
            Label locationLabel = new Label("Lieu: " + currentEvent.getLieu());
            Label categoryLabel = new Label("Catégorie: " + currentEvent.getCategorie());

            dateLabel.setStyle("-fx-text-fill: #645F71;");
            locationLabel.setStyle("-fx-text-fill: #645F71;");
            categoryLabel.setStyle("-fx-text-fill: #645F71;");

            // Récupérer et afficher la note moyenne actuelle
            double averageRating = 0;
            int reviewCount = 0;
            try {
                averageRating = serviceFeedback.getAverageRatingForEvent(currentEvent.getEvenement_id());
                reviewCount = serviceFeedback.countFeedbacksForEvent(currentEvent.getEvenement_id());
            } catch (SQLException e) {
                System.err.println("Erreur lors de la récupération de la note moyenne: " + e.getMessage());
            }

            // Afficher la note moyenne
            HBox averageRatingBox = new HBox(5);
            averageRatingBox.setAlignment(Pos.CENTER_LEFT);

            Label avgRatingLabel = new Label("Note moyenne: ");
            avgRatingLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #645F71;");

            HBox starsBox = new HBox(2);
            for (int i = 1; i <= 5; i++) {
                FontAwesomeIconView star = new FontAwesomeIconView(FontAwesomeIcon.STAR);
                star.setSize("1em");

                if (i <= Math.round(averageRating)) {
                    star.setFill(Color.valueOf("#f8ce0b"));
                } else {
                    star.setFill(Color.valueOf("#CCCCCC"));
                }

                starsBox.getChildren().add(star);
            }

            Label ratingValueLabel = new Label(String.format("%.1f/5", averageRating));
            ratingValueLabel.setStyle("-fx-text-fill: #645F71;");

            Label reviewCountLabel = new Label(" (" + reviewCount + " avis)");
            reviewCountLabel.setStyle("-fx-text-fill: #645F71; -fx-font-style: italic;");

            averageRatingBox.getChildren().addAll(avgRatingLabel, starsBox, ratingValueLabel, reviewCountLabel);

            detailsBox.getChildren().addAll(dateLabel, locationLabel, categoryLabel, averageRatingBox);

            eventInfoBox.getChildren().addAll(imageView, detailsBox);

            // Separator
            Separator separator = new Separator();

            // Comment area
            Label commentLabel = new Label("Votre commentaire:");
            TextArea commentArea = new TextArea();
            commentArea.setPromptText("Partagez votre expérience...");
            commentArea.setPrefRowCount(5);
            commentArea.getStyleClass().add("comment-area");
            commentArea.setWrapText(true);

            // Star rating
            Label ratingLabel = new Label("Votre note:");
            ratingLabel.getStyleClass().add("rating-instruction");

            // Create star rating selector
            selectedRating = 0;
            ratingStarsContainer = new HBox(5);
            ratingStarsContainer.setAlignment(Pos.CENTER_LEFT);
            ratingStarsContainer.getStyleClass().add("rating-selector");

            for (int i = 1; i <= 5; i++) {
                final int starValue = i;
                FontAwesomeIconView star = new FontAwesomeIconView(FontAwesomeIcon.STAR);
                star.setSize("1.5em");
                star.setFill(Color.valueOf("#CCCCCC"));
                star.getStyleClass().add("star-empty");

                // Click event for rating stars
                star.setOnMouseClicked(e -> {
                    selectedRating = starValue;
                    updateStarRating();
                });

                ratingStarsContainer.getChildren().add(star);
            }

            // Add all elements to dialog
            dialogContent.getChildren().addAll(
                    titleLabel,
                    eventInfoBox,
                    separator,
                    commentLabel,
                    commentArea,
                    ratingLabel,
                    ratingStarsContainer
            );

            // Set dialog content
            dialog.getDialogPane().setContent(dialogContent);

            // Add buttons
            ButtonType submitButtonType = new ButtonType("Soumettre", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButtonType = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(submitButtonType, cancelButtonType);

            // Style the dialog
            dialog.getDialogPane().getStylesheets().add(getClass().getResource("/feedback_styles.css").toExternalForm());

            // Show dialog and handle result
            Optional<ButtonType> result = dialog.showAndWait();


            if (result.isPresent() && result.get() == submitButtonType) {
                // Validate input
                String comment = commentArea.getText().trim();

                if (comment.isEmpty()) {
                    showAlert("Commentaire requis", "Veuillez ajouter un commentaire pour soumettre votre avis.");
                    return;
                }

                if (selectedRating == 0) {
                    showAlert("Note requise", "Veuillez donner une note (1-5 étoiles) pour soumettre votre avis.");
                    return;
                }

                // Vérifier si le commentaire contient des mots inappropriés
                AiUtility.ModerationResult moderationResult = AiUtility.moderateComment(comment);

                if (moderationResult.estInapproprie()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Contenu inapproprié détecté");
                    alert.setHeaderText("Votre commentaire contient du contenu inapproprié");

//                    VBox dialogContent = new VBox(10);
                    dialogContent.setPadding(new Insets(10));

                    Label reasonLabel = new Label("Raison: " + moderationResult.getRaison());
                    reasonLabel.setWrapText(true);

                    Label suggestionLabel = new Label("Suggestion de commentaire modéré:");
                    suggestionLabel.setStyle("-fx-font-weight: bold;");

                    Label moderatedCommentLabel = new Label(moderationResult.getCommentaireModere());
                    moderatedCommentLabel.setWrapText(true);
                    moderatedCommentLabel.setStyle("-fx-font-style: italic;");

                    dialogContent.getChildren().addAll(reasonLabel, new Separator(), suggestionLabel, moderatedCommentLabel);

                    alert.getDialogPane().setContent(dialogContent);

                    ButtonType useModeratedButton = new ButtonType("Utiliser version modérée");
                    ButtonType editButton = new ButtonType("Modifier mon commentaire");
                    ButtonType cancelButton = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(useModeratedButton, editButton, cancelButton);

                    Optional<ButtonType> moderationResponse = alert.showAndWait();

                    if (moderationResponse.isPresent()) {
                        if (moderationResponse.get() == useModeratedButton) {
                            // Utiliser la version modérée du commentaire
                            comment = moderationResult.getCommentaireModere();
                        } else if (moderationResponse.get() == editButton) {
                            // Retourner à la boîte de dialogue pour modification
                            commentArea.setText(comment);
                            showAddReviewDialog(event);
                            return;
                        } else {
                            // Annuler l'ajout du commentaire
                            return;
                        }
                    } else {
                        return;
                    }
                }

                // Save feedback with approved or moderated comment
                Feedback feedback = new Feedback(
                        selectedRating,
                        comment,
                        new Date(),
                        currentEvent,
                        currentUser
                );

                try {
                    serviceFeedback.ajouter(feedback);

                    // Refresh reviews
                    loadReviews();

                    // Show success message
                    showAlert("Avis ajouté", "Votre avis a été ajouté avec succès.", Alert.AlertType.INFORMATION);
                } catch (SQLException e) {
                    System.err.println("Error adding feedback: " + e.getMessage());
                    e.printStackTrace();
                    showAlert("Erreur", "Une erreur s'est produite lors de l'ajout de votre avis: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Erreur", "Une erreur s'est produite: " + e.getMessage());
        }
    }

    private void updateStarRating() {
        // Update star colors based on selected rating
        for (int i = 0; i < ratingStarsContainer.getChildren().size(); i++) {
            FontAwesomeIconView star = (FontAwesomeIconView) ratingStarsContainer.getChildren().get(i);

            if (i < selectedRating) {
                star.setFill(Color.valueOf("#f8ce0b"));
                star.getStyleClass().remove("star-empty");
                star.getStyleClass().add("star-filled");
            } else {
                star.setFill(Color.valueOf("#CCCCCC"));
                star.getStyleClass().remove("star-filled");
                star.getStyleClass().add("star-empty");
            }
        }
    }

    private void showAlert(String title, String message) {
        showAlert(title, message, Alert.AlertType.ERROR);
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    //////////////////////MENU//////////////////////////
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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewAllEvents.fxml"));

            //FXMLLoader loader = new FXMLLoader(getClass().getResource("/EvenementAll.fxml"));

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
/////////////////////////////////////
    /////////////////////////////////////////////////////////
}
