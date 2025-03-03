package services;

import entities.Evenement;
import entities.Transaction;
import entities.Ticket;
import entities.Utilisateur;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTransaction implements IService<Transaction> {

    private Connection connection;

    public ServiceTransaction() {
        connection = MyDataBase.getInstance().getConnection();
    }

    public void ajouter(Transaction transaction) throws SQLException {
        // ✅ Vérifier que l'utilisateur existe
        String checkUtilisateurQuery = "SELECT * FROM utilisateur WHERE utilisateur_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(checkUtilisateurQuery)) {
            pst.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                throw new SQLException("❌ Utilisateur non trouvé.");
            }
        }

        // ✅ Vérifier que **seul un ticket** est associé
        if (transaction.getTicket() == null) {
            throw new SQLException("❌ La transaction doit contenir un seul ticket.");
        }

        // ✅ Vérifier que le ticket existe et est disponible
        Ticket ticket = transaction.getTicket();
        String checkTicketQuery = "SELECT * FROM ticket WHERE id_ticket = ? AND nb_tickets > 0";
        try (PreparedStatement pst = connection.prepareStatement(checkTicketQuery)) {
            pst.setInt(1, ticket.getId_ticket());
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                throw new SQLException("❌ Ticket non trouvé ou épuisé.");
            }
        }

        // ✅ Définir le montant total de la transaction (prix du seul ticket)
        transaction.setMontant_total(ticket.getPrix());

        // ✅ Insérer la transaction
        String insertTransactionQuery = "INSERT INTO transaction (utilisateur_id, montant_total, mode_paiement, date_paiement, statut) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(insertTransactionQuery, Statement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
            pst.setDouble(2, transaction.getMontant_total());
            pst.setString(3, transaction.getMode_paiement());
            pst.setTimestamp(4, transaction.getDate_paiement());
            pst.setString(5, transaction.getStatut());
            pst.executeUpdate();

            // ✅ Récupérer l'ID généré
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                transaction.setId_transaction(generatedKeys.getInt(1));
                System.out.println("✅ Transaction ajoutée avec succès avec l'ID: " + transaction.getId_transaction());
            }

            // ✅ Ajouter **un seul ticket** à la transaction
            ServiceTransactionTicket serviceTransactionTicket = new ServiceTransactionTicket();
            serviceTransactionTicket.ajouterTicketTransaction(transaction);
        }
    }

    @Override
    public void modifier(Transaction transaction) throws SQLException {
    }

    @Override
    public void supprimer(int id) throws SQLException {

    }

    @Override
    public List<Transaction> afficher() throws SQLException {
        return List.of();
    }

    // ✅ Modification pour récupérer un **seul ticket** par transaction
    public Ticket getTicketByTransactionId(int transactionId) throws SQLException {
        String query = "SELECT t.* FROM ticket t " +
                "INNER JOIN ticket_transaction tt ON t.id_ticket = tt.ticket_id " +
                "WHERE tt.transaction_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, transactionId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ServiceEvenement serviceEvenement = new ServiceEvenement();
                Evenement evenement = serviceEvenement.getEvenementById(rs.getInt("evenement_id"));
                return new Ticket(
                        rs.getInt("id_ticket"),
                        evenement,
                        rs.getString("type"),
                        rs.getString("statut"),
                        rs.getDouble("prix"),
                        rs.getTimestamp("date_validite"),
                        rs.getInt("nb_tickets")
                );
            }
        }
        return null;
    }

    public void marquerCommePayee(int transactionId) throws SQLException {
        String query = "UPDATE transaction SET statut = 'Payée' WHERE id_transaction = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, transactionId);
            pst.executeUpdate();
        }
    }
    public Transaction getTransactionById(int id) throws SQLException {
        String query = "SELECT t.*, u.utilisateur_id, u.nom, u.email, tk.* " +
                "FROM transaction t " +
                "JOIN utilisateur u ON t.utilisateur_id = u.utilisateur_id " +
                "JOIN ticket_transaction tt ON t.id_transaction = tt.transaction_id " +
                "JOIN ticket tk ON tt.ticket_id = tk.id_ticket " +
                "WHERE t.id_transaction = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // ✅ Récupération de l'utilisateur
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setEmail(rs.getString("email"));

                // ✅ Récupération du ticket unique
                Ticket ticket = new Ticket();
                ticket.setId_ticket(rs.getInt("id_ticket"));
                ticket.setType(rs.getString("type"));
                ticket.setStatut(rs.getString("statut"));
                ticket.setPrix(rs.getDouble("prix"));
                ticket.setDate_validite(rs.getTimestamp("date_validite"));
                ticket.setNb_tickets(rs.getInt("nb_tickets"));

                // ✅ Création et retour de la transaction
                return new Transaction(
                        rs.getInt("id_transaction"),
                        utilisateur,
                        ticket, // ⚠️ Un seul ticket par transaction maintenant
                        rs.getDouble("montant_total"),
                        rs.getString("mode_paiement"),
                        rs.getTimestamp("date_paiement"),
                        rs.getString("statut")
                );
            }
        }
        return null; // 🚨 Retourne null si aucune transaction trouvée
    }
    public List<Transaction> getTransactionsByUtilisateurId(int utilisateurId) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transaction WHERE utilisateur_id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, utilisateurId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int transactionId = rs.getInt("id_transaction");

                // Récupérer l'utilisateur associé à la transaction
                ServiceUtilisateurEvenement serviceUtilisateur = new ServiceUtilisateurEvenement();
                Utilisateur utilisateur = serviceUtilisateur.getUtilisateurById(utilisateurId);

                // Récupérer les tickets associés à cette transaction
                Ticket ticket= getTicketByTransactionId(transactionId);

                // Construire l'objet Transaction
                Transaction transaction = new Transaction(
                        transactionId,
                        utilisateur,
                        ticket,
                        rs.getDouble("montant_total"),
                        rs.getString("mode_paiement"),
                        rs.getTimestamp("date_paiement"),
                        rs.getString("statut")
                );

                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
