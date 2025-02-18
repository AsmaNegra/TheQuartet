package services;

import entities.Evenement;
import entities.Transaction;
import entities.Ticket;
import entities.Utilisateur;
import utils.MyDataBase;
import services.ServiceUtilisateurEvenement;

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

        for (Ticket ticket : transaction.getTickets_associes()) {
            String checkTicketQuery = "SELECT * FROM ticket WHERE id_ticket = ? AND nb_tickets > 0";
            try (PreparedStatement pst = connection.prepareStatement(checkTicketQuery)) {
                pst.setInt(1, ticket.getId_ticket());
                ResultSet rs = pst.executeQuery();
                if (!rs.next()) {
                    throw new SQLException("❌ Ticket non trouvé ou épuisé pour ID: " + ticket.getId_ticket());
                }
            }
        }
        double montantTotal = 0;
        for (Ticket ticket : transaction.getTickets_associes()) {
            montantTotal += ticket.getPrix();
        }
        transaction.setMontant_total(montantTotal);
        String insertTransactionQuery = "INSERT INTO transaction (utilisateur_id, montant_total, mode_paiement, date_paiement) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(insertTransactionQuery, Statement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
            pst.setDouble(2, transaction.getMontant_total());
            pst.setString(3, transaction.getMode_paiement());
            pst.setTimestamp(4, transaction.getDate_paiement());
            pst.executeUpdate();

            // Récupérer l'ID généré pour la transaction
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                transaction.setId_transaction(generatedKeys.getInt(1));
                System.out.println("✅ Transaction ajoutée avec succès avec l'ID: " + transaction.getId_transaction());
            }

            // Ajouter les tickets associés à la transaction
            ServiceTransactionTicket serviceTransactionTicket = new ServiceTransactionTicket();
            serviceTransactionTicket.ajouterTicketsTransaction(transaction);
        }
    }
    public void modifier(Transaction transaction) throws SQLException {
        String checkTransactionQuery = "SELECT * FROM transaction WHERE id_transaction = ?";
        try (PreparedStatement pst = connection.prepareStatement(checkTransactionQuery)) {
            pst.setInt(1, transaction.getId_transaction());
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                System.out.println("❌ Transaction non trouvée.");
                return;
            }
        }
        String checkUtilisateurQuery = "SELECT * FROM utilisateur WHERE utilisateur_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(checkUtilisateurQuery)) {
            pst.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                System.out.println("❌ Utilisateur non trouvé.");
                return;
            }
        }
        for (Ticket ticket : transaction.getTickets_associes()) {
            String checkTicketQuery = "SELECT * FROM ticket WHERE id_ticket = ?";
            try (PreparedStatement pst = connection.prepareStatement(checkTicketQuery)) {
                pst.setInt(1, ticket.getId_ticket());
                ResultSet rs = pst.executeQuery();
                if (!rs.next()) {
                    System.out.println("❌ Ticket non trouvé pour ID: " + ticket.getId_ticket());
                    return;
                }
            }
        }
        double montantTotal = 0;
        for (Ticket ticket : transaction.getTickets_associes()) {
            montantTotal += ticket.getPrix();
        }
        transaction.setMontant_total(montantTotal);
        String updateTransactionQuery = "UPDATE transaction SET montant_total = ?, mode_paiement = ?, date_paiement = ? WHERE id_transaction = ?";
        try (PreparedStatement pst = connection.prepareStatement(updateTransactionQuery)) {
            pst.setDouble(1, transaction.getMontant_total());
            pst.setString(2, transaction.getMode_paiement());
            pst.setTimestamp(3, transaction.getDate_paiement());
            pst.setInt(4, transaction.getId_transaction());
            pst.executeUpdate();
            System.out.println("✅ Transaction mise à jour avec succès.");
        }
        String deleteTransactionTicketsQuery = "DELETE FROM ticket_transaction WHERE transaction_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(deleteTransactionTicketsQuery)) {
            pst.setInt(1, transaction.getId_transaction());
            pst.executeUpdate();
        }
        String insertTransactionTicketQuery = "INSERT INTO ticket_transaction (transaction_id, ticket_id) VALUES (?, ?)";
        try (PreparedStatement pstTicket = connection.prepareStatement(insertTransactionTicketQuery)) {
            for (Ticket ticket : transaction.getTickets_associes()) {
                pstTicket.setInt(1, transaction.getId_transaction());
                pstTicket.setInt(2, ticket.getId_ticket());
                pstTicket.addBatch();
            }
            pstTicket.executeBatch();
            System.out.println("✅ Tickets associés mis à jour.");
        }
    }
    @Override
    public void supprimer(int transactionId) throws SQLException {
        // Récupérer les tickets associés à la transaction
        List<Ticket> ticketsAssocies = getTicketsByTransactionId(transactionId);

        // Supprimer les associations de tickets dans la table 'ticket_transaction'
        String deleteTicketsQuery = "DELETE FROM ticket_transaction WHERE transaction_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(deleteTicketsQuery)) {
            ps.setInt(1, transactionId);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("✅ Associations de tickets supprimées.");
            } else {
                System.out.println("❌ Aucune association de ticket trouvée pour cette transaction.");
            }
        }

        // Incrémenter nb_tickets et mettre à jour le statut des tickets
        String updateTicketQuery = "UPDATE ticket SET nb_tickets = nb_tickets + 1 WHERE id_ticket = ?";
        String updateStatusQuery = "UPDATE ticket SET statut = 'Disponible' WHERE id_ticket = ? AND nb_tickets >= 1";

        try (PreparedStatement updateStmt = connection.prepareStatement(updateTicketQuery);
             PreparedStatement updateStatusStmt = connection.prepareStatement(updateStatusQuery)) {

            for (Ticket ticket : ticketsAssocies) {
                // Incrémenter nb_tickets
                updateStmt.setInt(1, ticket.getId_ticket());
                updateStmt.addBatch();

                // Mettre à jour le statut si nécessaire
                updateStatusStmt.setInt(1, ticket.getId_ticket());
                updateStatusStmt.addBatch();
            }

            // Exécuter les batchs
            updateStmt.executeBatch();
            updateStatusStmt.executeBatch();
        }

        // Supprimer la transaction dans la table 'transaction'
        String deleteTransactionQuery = "DELETE FROM transaction WHERE id_transaction = ?";
        try (PreparedStatement ps = connection.prepareStatement(deleteTransactionQuery)) {
            ps.setInt(1, transactionId);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("✅ Transaction supprimée avec succès.");
            } else {
                System.out.println("❌ Transaction non trouvée.");
            }
        }
    }
    @Override
    public List<Transaction> afficher() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transaction";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ServiceUtilisateurEvenement serviceUtilisateurEvenement= new ServiceUtilisateurEvenement();
                int utilisateurId = rs.getInt("utilisateur_id");
                Utilisateur utilisateur = serviceUtilisateurEvenement.getUtilisateurById(utilisateurId); // Charger l’événement
                Transaction transaction = new Transaction(
                        rs.getInt("id_transaction"),
                        utilisateur,
                        new ArrayList<>(),  // Will be populated later
                        rs.getDouble("montant_total"),
                        rs.getString("mode_paiement"),
                        rs.getTimestamp("date_paiement")
                );
                transactions.add(transaction);
            }
        }
        return transactions;
    }
    public Transaction getTransactionById(int id) throws SQLException {
        String query = "SELECT * FROM transaction WHERE id_transaction = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ServiceUtilisateurEvenement serviceUtilisateurEvenement=new ServiceUtilisateurEvenement();
                int utilisateurId = rs.getInt("utilisateur_id");
                Utilisateur utilisateur = serviceUtilisateurEvenement.getUtilisateurById(1);
                List<Ticket> ticketsAssocies = getTicketsByTransactionId(id);
                Transaction transaction = new Transaction(
                        rs.getInt("id_transaction"),
                        utilisateur,
                        ticketsAssocies,
                        rs.getDouble("montant_total"),
                        rs.getString("mode_paiement"),
                        rs.getTimestamp("date_paiement")
                );

                return transaction;
            }
        }
        return null;
    }

    public List<Ticket> getTicketsByTransactionId(int transactionId) throws SQLException {
        String query = "SELECT t.* FROM ticket t " +
                "INNER JOIN ticket_transaction tt ON t.id_ticket = tt.ticket_id " +
                "WHERE tt.transaction_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, transactionId);
            ResultSet rs = pst.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (rs.next()) {
                ServiceEvenement serviceEvenement= new ServiceEvenement();
                int evenementId = rs.getInt("evenement_id");
                Evenement evenement = serviceEvenement.getEvenementById(evenementId);
                tickets.add(new Ticket(
                        rs.getInt("id_ticket"),
                        evenement,
                        rs.getString("type"),
                        rs.getString("statut"),
                        rs.getDouble("prix"),
                        rs.getTimestamp("date_validite"),
                        rs.getInt("nb_tickets")
                ));
            }
            return tickets;
        }
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
                List<Ticket> ticketsAssocies = getTicketsByTransactionId(transactionId);

                // Construire l'objet Transaction
                Transaction transaction = new Transaction(
                        transactionId,
                        utilisateur,
                        ticketsAssocies,
                        rs.getDouble("montant_total"),
                        rs.getString("mode_paiement"),
                        rs.getTimestamp("date_paiement")
                );

                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
