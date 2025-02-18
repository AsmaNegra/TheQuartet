package services;

import entities.Transaction;
import entities.Ticket;
import utils.MyDataBase;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ServiceTransactionTicket {

    private Connection connection;

    public ServiceTransactionTicket() {
        connection = MyDataBase.getInstance().getConnection();
    }

    public void ajouterTicketsTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO ticket_transaction (ticket_id, transaction_id) VALUES (?, ?)";
        String updateQuery = "UPDATE ticket SET nb_tickets = nb_tickets - 1 WHERE id_ticket = ? AND nb_tickets > 0";
        String updateStatusQuery = "UPDATE ticket SET statut = 'Épuisé' WHERE id_ticket = ? AND nb_tickets = 0";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
             PreparedStatement updateStatusStmt = connection.prepareStatement(updateStatusQuery)) {

            for (Ticket ticket : transaction.getTickets_associes()) {
                // Vérifier si le ticket est disponible
                String checkTicketQuery = "SELECT nb_tickets FROM ticket WHERE id_ticket = ?";
                try (PreparedStatement checkStmt = connection.prepareStatement(checkTicketQuery)) {
                    checkStmt.setInt(1, ticket.getId_ticket());
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt("nb_tickets") > 0) {
                        // Ajouter le ticket à la transaction
                        stmt.setInt(1, ticket.getId_ticket());
                        stmt.setInt(2, transaction.getId_transaction());
                        stmt.addBatch();

                        // Décrémenter le nombre de tickets
                        updateStmt.setInt(1, ticket.getId_ticket());
                        updateStmt.addBatch();

                        // Mettre à jour le statut si nécessaire
                        updateStatusStmt.setInt(1, ticket.getId_ticket());
                        updateStatusStmt.addBatch();
                    } else {
                        throw new SQLException("Le ticket avec l'ID " + ticket.getId_ticket() + " n'a plus de stock disponible.");
                    }
                }
            }

            // Exécuter les batchs
            stmt.executeBatch();
            updateStmt.executeBatch();
            updateStatusStmt.executeBatch();
        }
    }
    public void supprimerTicketDeTransaction(Transaction transaction, Ticket ticket) throws SQLException {
        // 1. Vérifier si le ticket est bien associé à la transaction
        String checkQuery = "SELECT * FROM ticket_transaction WHERE transaction_id = ? AND ticket_id = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, transaction.getId_transaction());
            checkStmt.setInt(2, ticket.getId_ticket());
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next()) {
                throw new SQLException("❌ Ce ticket n'est pas associé à cette transaction.");
            }
        }

        // 2. Supprimer le ticket de la transaction
        String deleteQuery = "DELETE FROM ticket_transaction WHERE transaction_id = ? AND ticket_id = ?";
        try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
            deleteStmt.setInt(1, transaction.getId_transaction());
            deleteStmt.setInt(2, ticket.getId_ticket());
            int affectedRows = deleteStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("❌ Échec de la suppression du ticket.");
            }
        }

        // 3. Réajouter 1 au stock du ticket
        String updateTicketQuery = "UPDATE ticket SET nb_tickets = nb_tickets + 1 WHERE id_ticket = ?";
        try (PreparedStatement updateStmt = connection.prepareStatement(updateTicketQuery)) {
            updateStmt.setInt(1, ticket.getId_ticket());
            updateStmt.executeUpdate();
        }

        // 4. Vérifier si le statut du ticket doit être mis à jour (de "Épuisé" à "Disponible")
        String updateStatusQuery = "UPDATE ticket SET statut = 'Disponible' WHERE id_ticket = ? AND nb_tickets > 0";
        try (PreparedStatement updateStatusStmt = connection.prepareStatement(updateStatusQuery)) {
            updateStatusStmt.setInt(1, ticket.getId_ticket());
            updateStatusStmt.executeUpdate();
        }

        // 5. Mettre à jour le montant total de la transaction
        String updateMontantQuery = "UPDATE transaction SET montant_total = montant_total - ? WHERE id_transaction = ?";
        try (PreparedStatement updateMontantStmt = connection.prepareStatement(updateMontantQuery)) {
            updateMontantStmt.setDouble(1, ticket.getPrix());
            updateMontantStmt.setInt(2, transaction.getId_transaction());
            updateMontantStmt.executeUpdate();
        }

        System.out.println("✅ Ticket supprimé de la transaction avec succès !");
    }


}
