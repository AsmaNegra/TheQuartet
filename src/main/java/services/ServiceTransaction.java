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
        String checkUtilisateurQuery = "SELECT * FROM utilisateur WHERE utilisateur_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(checkUtilisateurQuery)) {
            pst.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                throw new SQLException("❌ Utilisateur non trouvé.");
            }
        }
        if (transaction.getTicket() == null) {
            throw new SQLException("❌ La transaction doit contenir un seul ticket.");
        }

        Ticket ticket = transaction.getTicket();
        String checkTicketQuery = "SELECT * FROM ticket WHERE id_ticket = ? AND nb_tickets > 0";
        try (PreparedStatement pst = connection.prepareStatement(checkTicketQuery)) {
            pst.setInt(1, ticket.getId_ticket());
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                throw new SQLException("❌ Ticket non trouvé ou épuisé.");
            }
        }

        transaction.setMontant_total(ticket.getPrix());
        String insertTransactionQuery = "INSERT INTO transaction (utilisateur_id, montant_total, mode_paiement, date_paiement, statut) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(insertTransactionQuery, Statement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
            pst.setDouble(2, transaction.getMontant_total());
            pst.setString(3, transaction.getMode_paiement());
            pst.setTimestamp(4, transaction.getDate_paiement());
            pst.setString(5, transaction.getStatut());
            pst.executeUpdate();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                transaction.setId_transaction(generatedKeys.getInt(1));
                System.out.println("✅ Transaction ajoutée avec succès avec l'ID: " + transaction.getId_transaction());
            }
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
        return null;
    }
    public List<Transaction> getTransactionsByUtilisateurId(int utilisateurId) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transaction WHERE utilisateur_id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, utilisateurId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int transactionId = rs.getInt("id_transaction");
                ServiceUtilisateurEvenement serviceUtilisateur = new ServiceUtilisateurEvenement();
                Utilisateur utilisateur = serviceUtilisateur.getUtilisateurById(utilisateurId);
                Ticket ticket= getTicketByTransactionId(transactionId);
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

    public int compterTransactionsPayees(int utilisateurId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM transaction WHERE utilisateur_id = ? AND statut = 'Payée'";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateurId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    /**
     * Count the total number of tickets purchased for events associated with a specific user
     *
     * @param utilisateurId The ID of the user
     * @return The total number of tickets
     * @throws SQLException If a database access error occurs
     */
    public int getNombreTickets(int utilisateurId) throws SQLException {
        Connection connection = MyDataBase.getInstance().getConnection();
        String query = "SELECT COUNT(t.id_transaction) AS nombre_total_transactions " +
            "FROM transaction t " +
            "JOIN ticket_transaction tt ON t.id_transaction = tt.transaction_id " +
            "JOIN ticket tk ON tt.ticket_id = tk.id_ticket " +
            "JOIN evenement e ON tk.evenement_id = e.evenement_id " +
            "JOIN utilisateur_evenement ue ON e.evenement_id = ue.evenement_id " +
            "WHERE ue.utilisateur_id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, utilisateurId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("nombre_total_transactions");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du comptage des tickets: " + e.getMessage());
            throw e;
        }

        return 0;
    }
}
