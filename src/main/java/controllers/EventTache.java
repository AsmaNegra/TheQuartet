package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class EventTache implements Initializable {
    //BOUTTON MENU//
    @FXML private Button btnSitemap;
    @FXML private Button btnGift;
    @FXML private Button btnHome;
    @FXML private Button btnHome1;
    @FXML private AnchorPane sidebar;
    ////////////////
    private final ServiceTicket serviceTicket = new ServiceTicket();

    @FXML
    private VBox ticketsContainer;
    @FXML
    private ListView<Utilisateur> ListeUtilisateur;
    @FXML
    private ScrollPane fournisseurList;
    @FXML
    private VBox fournisseurContainer;
    @FXML
    private VBox doneTasks;
    @FXML
    private Pane pane_event;
    @FXML
    private ChoiceBox<?> filterT;
    @FXML
    private VBox inProgressTasks;
    @FXML
    private VBox todoTasks;
    @FXML
    private TextField rechercheT;
    @FXML
    private TextField rechercheTicketField;
    @FXML
    private TextField rechercheF;
    @FXML
    private Label eventNameLabel;
    @FXML
    private Label eventDescriptionLabel;

    private ServiceEvenement serviceEvenement = new ServiceEvenement();
    private int currentEventId;
    private final ServiceTache serviceTache = new ServiceTache();
    private Tache draggedTask;
    private ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
    private ServiceUtilisateurEvenement serviceUtilisateurEvenement = new ServiceUtilisateurEvenement();
    private EventTache eventTacheController;
    public void setEventTacheController(EventTache eventTacheController) {
        this.eventTacheController = eventTacheController;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupDragAndDrop();

        ListeUtilisateur.setCellFactory(param -> new ListCell<Utilisateur>() {
            @Override
            protected void updateItem(Utilisateur utilisateur, boolean empty) {
                super.updateItem(utilisateur, empty);
                if (empty || utilisateur == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    VBox vbox = new VBox(2); // 2px d'espacement entre les lignes
                    Label nomLabel = new Label(utilisateur.getNom());
                    nomLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #333;");
                    Label emailLabel = new Label(utilisateur.getEmail());
                    emailLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #777;");

                    vbox.getChildren().addAll(nomLabel, emailLabel);
                    // Créer un séparateur horizontal
                    Separator separator = new Separator();

                    // Disposer le label et le séparateur verticalement
                    VBox container = new VBox(2); // 2px d'espacement
                    container.getChildren().addAll(vbox, separator);

                    setGraphic(container);
                }
            }
        });


        // Listener sur le ChoiceBox pour appliquer le tri
        filterT.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if ("Aucun tri".equals(newVal)) {
                    loadTasks();
                } else if ("Par Priorité".equals(newVal)) {
                    // Appel de la méthode avec currentEventId
                    List<Tache> tasksSorted = serviceTache.trierTachesParPriorite(currentEventId);
                    List<Tache> todo = new ArrayList<>();
                    List<Tache> inProgress = new ArrayList<>();
                    List<Tache> done = new ArrayList<>();
                    for (Tache t : tasksSorted) {
                        if ("A faire".equalsIgnoreCase(t.getStatut())) {
                            todo.add(t);
                        } else if ("En Cours".equalsIgnoreCase(t.getStatut())) {
                            inProgress.add(t);
                        } else if ("Terminée".equalsIgnoreCase(t.getStatut())) {
                            done.add(t);
                        }
                    }
                    populateColumn(todoTasks, todo);
                    populateColumn(inProgressTasks, inProgress);
                    populateColumn(doneTasks, done);
                } else if ("Par Date".equals(newVal)) {
                    // Appel de la méthode avec currentEventId
                    List<Tache> tasksSorted = serviceTache.trierTachesParDate(currentEventId);
                    List<Tache> todo = new ArrayList<>();
                    List<Tache> inProgress = new ArrayList<>();
                    List<Tache> done = new ArrayList<>();
                    for (Tache t : tasksSorted) {
                        if ("A faire".equalsIgnoreCase(t.getStatut())) {
                            todo.add(t);
                        } else if ("En Cours".equalsIgnoreCase(t.getStatut())) {
                            inProgress.add(t);
                        } else if ("Terminée".equalsIgnoreCase(t.getStatut())) {
                            done.add(t);
                        }
                    }
                    populateColumn(todoTasks, todo);
                    populateColumn(inProgressTasks, inProgress);
                    populateColumn(doneTasks, done);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        // Listener pour la recherche de tâches
        rechercheT.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.trim().isEmpty()) {

                    loadTasks();
                } else {
                    List<Tache> enAttente = serviceTache.rechercherTachesToDo(newValue, currentEventId);
                    List<Tache> enCours = serviceTache.rechercherTachesEnCours(newValue, currentEventId);
                    List<Tache> terminees = serviceTache.rechercherTachesDone(newValue, currentEventId);
                    populateColumn(todoTasks, enAttente);
                    populateColumn(inProgressTasks, enCours);
                    populateColumn(doneTasks, terminees);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        // Listener pour la recherche de fournisseurs
        rechercheF.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.trim().isEmpty()) {
                    loadFournisseurs();
                } else {
                    List<Fournisseur> filteredFournisseurs = serviceFournisseur.rechercherFournisseursParEventId(currentEventId,newValue);
                    populateFournisseurList(filteredFournisseurs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        // Listener pour la recherche de Tickets
        rechercheTicketField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                filterTickets(newValue);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

//////////////////////////LOADS//////////////////////////////////////////////////////////////////////////////
private void loadUtilisateurs() throws SQLException {
    System.out.println("event id : "+ currentEventId);
    List<Utilisateur> utilisateurs = serviceUtilisateurEvenement.getUtilisateursByEvenementId(currentEventId);
    System.out.println("Nombre d'utilisateurs récupérés : " + utilisateurs.size());
    ListeUtilisateur.getItems().clear();
    ListeUtilisateur.getItems().addAll(utilisateurs);
}
    private void filterTickets(String keyword) throws SQLException {
        List<Ticket> allTickets = serviceTicket.getTicketsByEvenementId(currentEventId);
        if (keyword == null || keyword.trim().isEmpty()) {
            populateTicketsCards(allTickets);
            return;
        }
        List<Ticket> filteredTickets = new ArrayList<>();
        for (Ticket ticket : allTickets) {
            if (ticket.getType().toLowerCase().contains(keyword.toLowerCase()) ||
                    ticket.getStatut().toLowerCase().contains(keyword.toLowerCase()) ||
                    ticket.getDate_validite().toString().toLowerCase().contains(keyword.toLowerCase()) ||
                    String.valueOf(ticket.getPrix()).contains(keyword) ||
                    String.valueOf(ticket.getNb_tickets()).contains(keyword)) {
                filteredTickets.add(ticket);
            }
        }
        populateTicketsCards(filteredTickets);
    }
    public void loadTickets() {
        try {
            List<Ticket> tickets = serviceTicket.getTicketsByEvenementId(currentEventId);

            ticketsContainer.getChildren().clear();
            VBox allRows = new VBox(15);
            allRows.setAlignment(Pos.CENTER);

            HBox currentRow = new HBox(20);
            currentRow.setAlignment(Pos.CENTER);
            int count = 0;

            for (Ticket ticket : tickets) {
                AnchorPane ticketBox = new AnchorPane();
                ticketBox.setPrefWidth(300);
                ticketBox.setPrefHeight(200);
                ticketBox.setMinWidth(300);
                ticketBox.setMaxWidth(300);
                ticketBox.getStyleClass().addAll("ticket-container", "pane", "background_color");
                VBox vbox = new VBox(10);
                vbox.setAlignment(Pos.CENTER);
                vbox.getStyleClass().add("colored_card");
                vbox.setPadding(new Insets(10));
                Label typeLabel = new Label("Type : " + ticket.getType());
                typeLabel.getStyleClass().add("ticket-title");
                Label priceLabel = new Label("Prix : " + ticket.getPrix() + " TND");
                priceLabel.getStyleClass().add("ticket-details");
                Label statusLabel = new Label("Statut : " + ticket.getStatut());
                statusLabel.getStyleClass().add("ticket-details");
                Label quantityLabel = new Label("Quantité : " + ticket.getNb_tickets());
                quantityLabel.getStyleClass().add("ticket-details");
                HBox actionButtons = new HBox(10);
                actionButtons.setAlignment(Pos.CENTER);
                Button modifyButton = new Button();
                modifyButton.getStyleClass().add("action-button");
                FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
                editIcon.setFill(Color.WHITE);
                editIcon.setSize("16");
                modifyButton.setGraphic(editIcon);
                modifyButton.setOnAction(e -> modifierTicket(ticket));
                Button deleteButton = new Button();
                deleteButton.getStyleClass().add("action-button");
                deleteButton.getStyleClass().add("delete-button");
                FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                deleteIcon.setFill(Color.WHITE);
                deleteIcon.setSize("16");
                deleteButton.setGraphic(deleteIcon);
                deleteButton.setOnAction(e -> supprimerTicket(ticket));
                actionButtons.getChildren().addAll(modifyButton, deleteButton);
                vbox.getChildren().addAll(typeLabel, priceLabel, statusLabel, quantityLabel, actionButtons);
                ticketBox.getChildren().add(vbox);
                AnchorPane.setTopAnchor(vbox, 0.0);
                AnchorPane.setBottomAnchor(vbox, 0.0);
                AnchorPane.setLeftAnchor(vbox, 0.0);
                AnchorPane.setRightAnchor(vbox, 0.0);
                currentRow.getChildren().add(ticketBox);
                count++;
                if (count % 2 == 0) {
                    allRows.getChildren().add(currentRow);
                    currentRow = new HBox(20);
                    currentRow.setAlignment(Pos.CENTER);
                }
            }
            if (!currentRow.getChildren().isEmpty()) {
                allRows.getChildren().add(currentRow);
            }
            ticketsContainer.getChildren().add(allRows);

        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des tickets.");
            e.printStackTrace();
        }
    }

    private void supprimerTicket(Ticket ticket) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Voulez-vous vraiment supprimer ce ticket ?");
        alert.setContentText("Type de ticket : " + ticket.getType() + "\nPrix : " + ticket.getPrix() + " TND");

        ButtonType buttonYes = new ButtonType("Oui", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonYes, buttonNo);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonYes) {
            try {
                serviceTicket.supprimer(ticket.getId_ticket());

                Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                confirmation.setTitle("Suppression réussie");
                confirmation.setHeaderText(null);
                confirmation.setContentText("Le ticket a été supprimé avec succès !");
                confirmation.showAndWait();
                loadTickets();

            } catch (SQLException e) {
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText("Une erreur est survenue lors de la suppression");
                errorAlert.setContentText("Veuillez réessayer.");
                errorAlert.showAndWait();
            }
        }
    }
    private void modifierTicket(Ticket ticket) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierTicket.fxml"));
            Parent root = loader.load();
            ModifierTicketsController modifierTicketController = loader.getController();
            modifierTicketController.setTicket(ticket, this);
            Stage stage = new Stage();
            stage.setTitle("Modifier un Ticket");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'interface de modification du ticket.");
            e.printStackTrace();
        }
    }


    //    public void refreshTickets() {
//        loadTickets();
//    }
    @FXML
    private void ajouterTicket(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterTickets.fxml"));
            Parent root = loader.load();

            AjouterTicketsController ajouterTicketsController = loader.getController();
            ajouterTicketsController.initEventData(currentEventId); // Transmettre l’ID de l’événement

            Stage stage = new Stage();
            stage.setTitle("Ajouter un Ticket");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateTicketsCards(List<Ticket> tickets) {
        ticketsContainer.getChildren().clear();
        VBox allRows = new VBox(15);
        allRows.setAlignment(Pos.CENTER);
        HBox currentRow = new HBox(20);
        currentRow.setAlignment(Pos.CENTER);
        int count = 0;

        for (Ticket ticket : tickets) {
            // Conteneur principal du ticket
            AnchorPane ticketBox = new AnchorPane();
            ticketBox.setPrefWidth(300);
            ticketBox.setPrefHeight(200);
            ticketBox.setMinWidth(300);
            ticketBox.setMaxWidth(300);
            ticketBox.getStyleClass().addAll("ticket-container", "pane", "background_color");

            // VBox interne pour afficher les infos
            VBox vbox = new VBox(10);
            vbox.setAlignment(Pos.CENTER);
            vbox.getStyleClass().add("colored_card");
            vbox.setPadding(new Insets(10));

            // Labels du ticket
            Label typeLabel = new Label("Type : " + ticket.getType());
            typeLabel.getStyleClass().add("ticket-title");

            Label priceLabel = new Label("Prix : " + ticket.getPrix() + " TND");
            priceLabel.getStyleClass().add("ticket-details");

            Label statusLabel = new Label("Statut : " + ticket.getStatut());
            statusLabel.getStyleClass().add("ticket-details");

            Label quantityLabel = new Label("Quantité : " + ticket.getNb_tickets());
            quantityLabel.getStyleClass().add("ticket-details");

            // Actions (Modifier / Supprimer)
            HBox actionButtons = new HBox(10);
            actionButtons.setAlignment(Pos.CENTER);

            // Bouton Modifier
            Button modifyButton = new Button();
            modifyButton.getStyleClass().add("action-button");
            FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
            editIcon.setFill(Color.WHITE);
            editIcon.setSize("16");
            modifyButton.setGraphic(editIcon);
            modifyButton.setOnAction(e -> modifierTicket(ticket));

            // Bouton Supprimer
            Button deleteButton = new Button();
            deleteButton.getStyleClass().add("action-button");
            deleteButton.getStyleClass().add("delete-button");
            FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
            deleteIcon.setFill(Color.WHITE);
            deleteIcon.setSize("16");
            deleteButton.setGraphic(deleteIcon);
            deleteButton.setOnAction(e -> supprimerTicket(ticket));

            actionButtons.getChildren().addAll(modifyButton, deleteButton);

            // Ajouter les éléments au VBox
            vbox.getChildren().addAll(typeLabel, priceLabel, statusLabel, quantityLabel, actionButtons);

            // Ajouter le VBox au conteneur principal
            ticketBox.getChildren().add(vbox);
            AnchorPane.setTopAnchor(vbox, 0.0);
            AnchorPane.setBottomAnchor(vbox, 0.0);
            AnchorPane.setLeftAnchor(vbox, 0.0);
            AnchorPane.setRightAnchor(vbox, 0.0);

            // Ajouter à la ligne actuelle
            currentRow.getChildren().add(ticketBox);
            count++;

            // Si deux tickets sont ajoutés, créer une nouvelle ligne
            if (count % 2 == 0) {
                allRows.getChildren().add(currentRow);
                currentRow = new HBox(20);
                currentRow.setAlignment(Pos.CENTER);
            }
        }

        // Ajouter la dernière ligne si elle n'est pas vide
        if (!currentRow.getChildren().isEmpty()) {
            allRows.getChildren().add(currentRow);
        }

        // Ajouter tout dans le container principal
        ticketsContainer.getChildren().add(allRows);
    }



    private void loadFournisseurs() throws SQLException {
        List<Fournisseur> fournisseurs = serviceFournisseur.afficherFournisseursParEventId(currentEventId);
        populateFournisseurList(fournisseurs);
    }

    // Cette méthode utilise currentEventId pour charger les tâches
    private void loadTasks() throws SQLException {
        List<Tache> enAttente = serviceTache.afficherTachesToDoByEvenement(currentEventId);
        List<Tache> enCours   = serviceTache.afficherTachesEnCoursByEvenement(currentEventId);
        List<Tache> terminees = serviceTache.afficherTachesDoneByEvenement(currentEventId);
        populateColumn(todoTasks, enAttente);
        populateColumn(inProgressTasks, enCours);
        populateColumn(doneTasks, terminees);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////POPULATE/////////////////////////////////////////////////////////
    private void populateColumn(VBox column, List<Tache> tasks) {
        column.getChildren().clear();
        for (Tache task : tasks) {
            HBox taskContainer = new HBox(10);
            String baseStyle = "-fx-background-color: rgba(255, 255, 255, 0.82); " +
                    "-fx-padding: 10; " +
                    "-fx-border-radius: 10px; " +
                    "-fx-background-radius: 10px; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 10, 0.5, 2, 2);";
            taskContainer.setStyle(baseStyle);

            VBox textContainer = new VBox(5);
            Label nameLabel = new Label(task.getNom());
            nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #2b2b2b;");
            Label descriptionLabel = new Label(task.getDescription() != null ? task.getDescription() : "");
            descriptionLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");
            Label assignedLabel = new Label("Assigné à : " + task.getUserAssocie());
            assignedLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");

            String textColor = "#2b2b2b";
            if ("Haute".equalsIgnoreCase(task.getPriorite())) {
                textColor = "rgba(255, 0, 0, 0.6)";
            } else if ("Moyenne".equalsIgnoreCase(task.getPriorite())) {
                textColor = "rgba(255, 165, 0, 0.6)";
            } else if ("Basse".equalsIgnoreCase(task.getPriorite())) {
                textColor = "rgba(0, 128, 0, 0.6)";
            }
            Label priorityLabel = new Label("Priorité : " + task.getPriorite());
            priorityLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: " + textColor + ";");

            HBox statusContainer = new HBox(10);
            Label relativeTime = new Label(task.getDateLimite().toString());
            statusContainer.getChildren().addAll(relativeTime, priorityLabel);

            VBox buttonContainer = new VBox(10);
            Button editButton = new Button();
            ImageView editIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/pencil.png")));
            editIcon.setFitWidth(13);
            editIcon.setFitHeight(13);
            editButton.setGraphic(editIcon);
            editButton.setStyle("-fx-background-color: transparent;");
            editButton.setOnAction(event -> modifyTask(task, event));
            Button deleteButton = new Button();
            ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/delete.png")));
            deleteIcon.setFitWidth(13);
            deleteIcon.setFitHeight(13);
            deleteButton.setGraphic(deleteIcon);
            deleteButton.setStyle("-fx-background-color: transparent;");
            deleteButton.setOnAction(event -> deleteTask(task));
            buttonContainer.getChildren().addAll(editButton, deleteButton);
            textContainer.getChildren().addAll(nameLabel, descriptionLabel, assignedLabel, statusContainer);
            taskContainer.getChildren().addAll(textContainer, buttonContainer);
            column.getChildren().add(taskContainer);

            taskContainer.setOnDragDetected(event -> {
                draggedTask = task;
                Dragboard db = taskContainer.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(task.getNom());
                db.setContent(content);
                event.consume();
            });
        }
    }

    private void setupDragAndDrop() {
        setupDropTarget(todoTasks, "A Faire");
        setupDropTarget(inProgressTasks, "En Cours");
        setupDropTarget(doneTasks, "Terminée");
    }

    private void setupDropTarget(VBox targetColumn, String newStatus) {
        targetColumn.setOnDragOver(event -> {
            if (event.getGestureSource() != targetColumn && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        targetColumn.setOnDragDropped(event -> {
            if (draggedTask != null) {
                try {
                    serviceTache.modifierEtatTache(draggedTask.getTacheId(), newStatus);
                    loadTasks();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            event.setDropCompleted(true);
            event.consume();
        });
    }

    private void modifyTask(Tache task, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierTache.fxml"));
            Parent root = loader.load();
            ModifierTache controller = loader.getController();
            controller.setTaskData(task);
            controller.initEventData(currentEventId);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTask(Tache task) {
        try {
            serviceTache.supprimer(task.getTacheId());
            loadTasks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void redirectToAjoutTache(ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Integer eventId = this.currentEventId;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ajoutTache.fxml"));
            Parent root = loader.load();
            AjoutTache ajoutTacheController = loader.getController();
            ajoutTacheController.initEventData(eventId);
            Scene scene = source.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AssignerFournisseur(ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Integer eventId = this.currentEventId;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AssignerFaE.fxml"));
            Parent root = loader.load();
            AssignerFaE ajoutTacheController = loader.getController();
            ajoutTacheController.initEventData(eventId);
            Scene scene = source.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void populateFournisseurList(List<Fournisseur> fournisseurs) {
        fournisseurContainer.getChildren().clear();
        for (Fournisseur fournisseur : fournisseurs) {
            HBox fournisseurContainerItem = new HBox(20);
            fournisseurContainerItem.setStyle("-fx-background-color: rgba(255, 255, 255, 0.82); " +
                    "-fx-padding: 10; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 10, 0.5, 2, 2);");
            VBox textContainer = new VBox(5);
            Label nameLabel = new Label(fournisseur.getNom());
            nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #2b2b2b;");
            Label typeLabel = new Label("Type: " + fournisseur.getTypeService());
            typeLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666;");
            Label contractLabel = new Label("État du contrat: " + fournisseur.getContrat());
            contractLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #888;");
            Label phoneLabel = new Label("📞 " + fournisseur.getNum_tel());
            phoneLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #444;");
            HBox typeAndContract = new HBox(15);
            typeAndContract.getChildren().addAll(typeLabel, contractLabel);
            HBox buttonContainer = new HBox(10);
            Button deleteButton = new Button();
            ImageView deleteIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/delete.png")));
            deleteIcon.setFitWidth(16);
            deleteIcon.setFitHeight(16);
            deleteButton.setGraphic(deleteIcon);
            deleteButton.setStyle("-fx-background-color: transparent;");
            deleteButton.setOnAction(event -> deleteFournisseur(fournisseur));
            buttonContainer.getChildren().addAll(deleteButton);
            textContainer.getChildren().addAll(nameLabel, typeAndContract, phoneLabel);
            fournisseurContainerItem.getChildren().addAll(textContainer, buttonContainer);
            fournisseurContainer.getChildren().add(fournisseurContainerItem);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////
//    private void modifyFournisseur(Fournisseur fournisseur, ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ModifierFournisseur.fxml"));
//            Parent root = loader.load();
//            ModifierFournisseur controller = loader.getController();
//            controller.setFournisseurData(fournisseur);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void deleteFournisseur(Fournisseur fournisseur) {
        try {
            ServiceFournisseurEvenement serviceFournisseurEvenement = new ServiceFournisseurEvenement();
            serviceFournisseurEvenement.desassocierFournisseurDeEvenement(fournisseur.getFournisseurId(),currentEventId);
            loadFournisseurs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode appelée par l'écran précédent pour initialiser l'événement courant
    public void initEventData(int eventId) {
        this.currentEventId = eventId;
        try {
            Evenement event = serviceEvenement.getEvenementById(eventId);
            if (event != null) {
                eventNameLabel.setText(event.getNom());
                eventDescriptionLabel.setText(event.getDescription());
                String imagePath = event.getImage_event();
                if (imagePath != null && !imagePath.isEmpty()) {
                    String encodedPath = imagePath.replace(" ", "%20");
                    pane_event.setStyle("-fx-background-image: url('" + encodedPath + "');"
                            + " -fx-background-size: cover;"
                            + " -fx-background-position: center center;");
                }
            }
            // Maintenant que currentEventId est défini, on peut charger les loads qui necessitent l'event id
            loadTasks();
            loadFournisseurs();
            loadUtilisateurs();
            loadTickets();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void retourPage(ActionEvent event) {
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



    ////////////////////////////MENU///////////////////////////////////////////////////////////////////////
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
    //////////////////////////////////////////////////////////////////////////

}
