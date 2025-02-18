package controllers;

import entities.Transaction;
import entities.Utilisateur;
import entities.Ticket;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceTransaction;
import services.ServiceUtilisateurEvenement;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

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
    private TableView<Ticket> ticketsTable;
    @FXML
    private TableColumn<Ticket, Integer> ticketIdColumn;
    @FXML
    private TableColumn<Ticket, String> typeColumn;
    @FXML
    private TableColumn<Ticket, Double> prixColumn;
    @FXML
    private TableColumn<Ticket, String> statutColumn;
    @FXML
    private TableColumn<Ticket, String> dateValiditeColumn;
    @FXML
    private Label messageLabel;

    private final ServiceTransaction serviceTransaction = new ServiceTransaction();
    private final ServiceUtilisateurEvenement serviceUtilisateur = new ServiceUtilisateurEvenement();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurerColonnes();
        chargerUtilisateurs();
        ajouterListenerSelectionTransaction();
    }

    /**
     * Configure les colonnes des tableaux.
     */
    private void configurerColonnes() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_transaction"));
        montantColumn.setCellValueFactory(new PropertyValueFactory<>("montant_total"));
        modePaiementColumn.setCellValueFactory(new PropertyValueFactory<>("mode_paiement"));
        datePaiementColumn.setCellValueFactory(new PropertyValueFactory<>("date_paiement"));

        ticketIdColumn.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        statutColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        dateValiditeColumn.setCellValueFactory(new PropertyValueFactory<>("date_validite"));
    }

    /**
     * Charge la liste des utilisateurs dans le ComboBox.
     */
    private void chargerUtilisateurs() {
        try {
            List<Utilisateur> utilisateurs = serviceUtilisateur.afficher();
            utilisateurComboBox.getItems().addAll(utilisateurs);

            // Ajoute un écouteur pour charger les transactions dès qu'un utilisateur est sélectionné
            utilisateurComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {
                    afficherTransactionsUtilisateur(newVal);
                }
            });

        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors du chargement des utilisateurs.");
            e.printStackTrace();
        }
    }

    /**
     * Affiche les transactions d'un utilisateur sélectionné.
     */
    private void afficherTransactionsUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) {
            transactionsTable.getItems().clear();
            ticketsTable.getItems().clear();
            messageLabel.setText("⚠️ Aucun utilisateur sélectionné.");
            return;
        }

        try {
            List<Transaction> transactions = serviceTransaction.getTransactionsByUtilisateurId(utilisateur.getUtilisateurId());
            transactionsTable.getItems().setAll(transactions);
            ticketsTable.getItems().clear(); // Effacer les tickets lorsqu'on change d'utilisateur

            if (transactions.isEmpty()) {
                messageLabel.setText("⚠️ Aucune transaction trouvée pour cet utilisateur.");
            } else {
                messageLabel.setText("✅ Transactions chargées : " + transactions.size());
            }

        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors du chargement des transactions.");
            e.printStackTrace();
        }
    }

    /**
     * Ajoute un écouteur pour afficher les tickets d'une transaction sélectionnée.
     */
    private void ajouterListenerSelectionTransaction() {
        transactionsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            afficherTicketsTransaction(newVal);
        });
    }

    /**
     * Affiche les tickets associés à une transaction.
     */
    private void afficherTicketsTransaction(Transaction transaction) {
        if (transaction == null) {
            ticketsTable.getItems().clear();
            messageLabel.setText("⚠️ Aucune transaction sélectionnée.");
            return;
        }

        try {
            List<Ticket> ticketsAssocies = serviceTransaction.getTicketsByTransactionId(transaction.getId_transaction());

            if (ticketsAssocies.isEmpty()) {
                messageLabel.setText("⚠️ Aucun ticket associé à cette transaction.");
            } else {
                messageLabel.setText("✅ Tickets trouvés : " + ticketsAssocies.size());
            }

            ticketsTable.getItems().clear();
            ticketsTable.getItems().setAll(ticketsAssocies);

        } catch (SQLException e) {
            messageLabel.setText("❌ Erreur lors du chargement des tickets.");
            e.printStackTrace();
        }
    }
}
