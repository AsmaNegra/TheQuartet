package controllers;

import entities.Transaction;
import entities.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.control.cell.*;
import javafx.util.Callback;
import services.ServiceTransaction;
import services.ServiceUtilisateurEvenement;

import java.net.URL;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AfficherTransactionUtilisateurController implements Initializable {

    @FXML
    private ComboBox<Utilisateur> utilisateurComboBox;
    @FXML
    private TableView<Transaction> transactionsTable;
    @FXML
    private TableColumn<Transaction, Integer> idColumn;
    @FXML
    private TableColumn<Transaction, Double> montantColumn;
    @FXML
    private TableColumn<Transaction, String> modePaiementColumn;
    @FXML
    private TableColumn<Transaction, String> datePaiementColumn;
    @FXML
    private TableColumn<Transaction, Void> actionsColumn;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<String> sortComboBox;
    @FXML
    private Label messageLabel;

    private final ServiceTransaction serviceTransaction = new ServiceTransaction();
    private final ServiceUtilisateurEvenement serviceUtilisateur = new ServiceUtilisateurEvenement();
    private ObservableList<Transaction> transactionsList = FXCollections.observableArrayList();
    private ObservableList<Transaction> filteredTransactionsList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurerColonnes();
        chargerUtilisateurs();
        configurerRechercheEtTri();

    }

    private void configurerColonnes() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_transaction"));
        montantColumn.setCellValueFactory(new PropertyValueFactory<>("montant_total"));
        modePaiementColumn.setCellValueFactory(new PropertyValueFactory<>("mode_paiement"));
        datePaiementColumn.setCellValueFactory(new PropertyValueFactory<>("date_paiement"));

        actionsColumn.setCellFactory(getActionCellFactory());
    }

    private Callback<TableColumn<Transaction, Void>, TableCell<Transaction, Void>> getActionCellFactory() {
        return param -> new TableCell<>() {
            private final FontAwesomeIconView deleteIcon = new FontAwesomeIconView();

            {
                deleteIcon.setGlyphName("TRASH");
                deleteIcon.setStyle("-fx-fill: red; -fx-cursor: hand;");
                deleteIcon.setOnMouseClicked(event -> {
                    Transaction transaction = getTableView().getItems().get(getIndex());
                    confirmerSuppression(transaction);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : deleteIcon);
            }
        };
    }

    private void confirmerSuppression(Transaction transaction) {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation de suppression");
        confirmationAlert.setHeaderText("Voulez-vous vraiment supprimer cette transaction ?");
        confirmationAlert.setContentText("Cette action est irréversible.");

        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                supprimerTransaction(transaction);
            }
        });
    }

    private void supprimerTransaction(Transaction transaction) {
        try {
            serviceTransaction.supprimer(transaction.getId_transaction());
            transactionsTable.getItems().remove(transaction);
            afficherMessageSucces("Transaction supprimée avec succès.");
        } catch (SQLException e) {
            afficherMessageErreur("Erreur lors de la suppression de la transaction.");
            e.printStackTrace();
        }
    }

    private void chargerUtilisateurs() {
        try {
            List<Utilisateur> utilisateurs = serviceUtilisateur.afficher();
            utilisateurComboBox.getItems().setAll(utilisateurs);

            utilisateurComboBox.setConverter(new StringConverter<>() {
                @Override
                public String toString(Utilisateur utilisateur) {
                    return utilisateur == null ? "" : utilisateur.getUtilisateurId() + " - " + utilisateur.getNom();
                }

                @Override
                public Utilisateur fromString(String string) {
                    return null;
                }
            });

            // Écouteur pour charger les transactions dès qu'un utilisateur est sélectionné
            utilisateurComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {
                    afficherTransactionsUtilisateur(newVal);
                }
            });
        } catch (SQLException e) {
            afficherMessageErreur("Erreur lors du chargement des utilisateurs.");
            e.printStackTrace();
        }
    }

    private void afficherTransactionsUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) {
            transactionsList.clear();
            filteredTransactionsList.clear();
            transactionsTable.getItems().clear();
            afficherMessageAvertissement("Aucun utilisateur sélectionné.");
            return;
        }

        try {
            List<Transaction> transactions = serviceTransaction.getTransactionsByUtilisateurId(utilisateur.getUtilisateurId());
            transactionsList.setAll(transactions);
            filteredTransactionsList.setAll(transactions);

            transactionsTable.setItems(filteredTransactionsList);

            if (transactions.isEmpty()) {
                afficherMessageAvertissement("Aucune transaction trouvée pour cet utilisateur.");
            } else {
                afficherMessageSucces("Transactions chargées : " + transactions.size());
            }
        } catch (SQLException e) {
            afficherMessageErreur("Erreur lors du chargement des transactions.");
            e.printStackTrace();
        }
    }

    private void configurerRechercheEtTri() {
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filtrerTransactions());

        sortComboBox.getItems().addAll(
                "Montant - Croissant", "Montant - Décroissant",
                "Date - Croissant", "Date - Décroissant"
        );

        sortComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> trierTransactions());
    }

    private void filtrerTransactions() {
        String searchText = searchField.getText().toLowerCase().trim();

        if (searchText.isEmpty()) {
            // Si la barre de recherche est vide, rétablir toutes les transactions de l'utilisateur sélectionné
            filteredTransactionsList.setAll(transactionsList);
        } else {
            List<Transaction> filteredList = transactionsList.stream()
                    .filter(t -> String.valueOf(t.getId_transaction()).contains(searchText) ||
                            String.valueOf(t.getMontant_total()).contains(searchText) ||
                            t.getMode_paiement().toLowerCase().contains(searchText))
                    .collect(Collectors.toList());

            filteredTransactionsList.setAll(filteredList);
        }

        transactionsTable.setItems(filteredTransactionsList);
    }
    private void trierTransactions() {
        Comparator<Transaction> comparator = null;
        String selectedSort = sortComboBox.getValue();

        if (selectedSort != null) {
            switch (selectedSort) {
                case "Montant - Croissant":
                    comparator = Comparator.comparing(Transaction::getMontant_total);
                    break;
                case "Montant - Décroissant":
                    comparator = Comparator.comparing(Transaction::getMontant_total).reversed();
                    break;
                case "Date - Croissant":
                    comparator = Comparator.comparing(Transaction::getDate_paiement);
                    break;
                case "Date - Décroissant":
                    comparator = Comparator.comparing(Transaction::getDate_paiement).reversed();
                    break;
            }
        }

        if (comparator != null) {
            FXCollections.sort(transactionsTable.getItems(), comparator);
        }
    }
    private void afficherMessageSucces(String message) {
        messageLabel.setText("✅ " + message);
    }

    private void afficherMessageAvertissement(String message) {
        messageLabel.setText("⚠️ " + message);
    }

    private void afficherMessageErreur(String message) {
        messageLabel.setText("❌ " + message);
    }
}