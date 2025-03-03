package services;

import entities.Transaction;
import entities.Ticket;
import utils.MyDataBase;

import java.sql.*;

public class ServiceTransactionTicket {

    private Connection connection;

    public ServiceTransactionTicket() {
        connection = MyDataBase.getInstance().getConnection();
    }

    public void ajouterTicketTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO ticket_transaction (ticket_id, transaction_id) VALUES (?, ?)";
        String updateQuery = "UPDATE ticket SET nb_tickets = nb_tickets - 1 WHERE id_ticket = ? AND nb_tickets > 0";
        String updateStatusQuery = "UPDATE ticket SET statut = 'Épuisé' WHERE id_ticket = ? AND nb_tickets = 0";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
             PreparedStatement updateStatusStmt = connection.prepareStatement(updateStatusQuery)) {

            Ticket ticket = transaction.getTicket();

            // Vérifier si le ticket est disponible
            String checkTicketQuery = "SELECT nb_tickets FROM ticket WHERE id_ticket = ?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkTicketQuery)) {
                checkStmt.setInt(1, ticket.getId_ticket());
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt("nb_tickets") > 0) {
                    // Ajouter le ticket à la transaction
                    stmt.setInt(1, ticket.getId_ticket());
                    stmt.setInt(2, transaction.getId_transaction());
                    stmt.executeUpdate();

                    // Décrémenter le nombre de tickets
                    updateStmt.setInt(1, ticket.getId_ticket());
                    updateStmt.executeUpdate();

                    // Mettre à jour le statut si nécessaire
                    updateStatusStmt.setInt(1, ticket.getId_ticket());
                    updateStatusStmt.executeUpdate();
                } else {
                    throw new SQLException("❌ Ticket épuisé.");
                }
            }
        }
    }
}
