package services;

import entities.Transaction;
import entities.Ticket;

import java.sql.*;
import java.util.List;

public class ServiceTransactionTicket {

    private Connection connection;

    public ServiceTransactionTicket(Connection connection) {
        this.connection = connection;
    }

    public void ajouterTicketsTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO ticket_transaction (ticket_id, transaction_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (Ticket ticket : transaction.getTickets_associes()) {
                stmt.setInt(1, ticket.getId_ticket());
                stmt.setInt(2, transaction.getId_transaction());
                stmt.addBatch(); // Ajoute les tickets au batch
            }
            stmt.executeBatch(); // Exécute le batch
        }
    }
}
