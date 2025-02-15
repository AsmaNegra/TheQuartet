package services;

import entities.Ticket;
import entities.Transaction;
import entities.Utilisateur;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTransaction implements IService<Transaction> {
    private final Connection connection;

    public ServiceTransaction(Connection connection) {
        this.connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Transaction transaction) throws SQLException {
        // Calcul du montant total de la transaction (somme des prix des tickets associés)
        double montantTotal = calculerMontantTotal(transaction.getId_transaction());

        // Insertion de la transaction
        String sql = "INSERT INTO transaction (utilisateur_id, montant_total, mode_paiement, date_paiement) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
        ps.setDouble(2, montantTotal);  // Montant total calculé
        ps.setString(3, transaction.getMode_paiement());
        ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));  // Date actuelle pour date_paiement

        // Exécution de l'insertion et récupération de l'ID généré
        ps.executeUpdate();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        int transactionId = 0;
        if (generatedKeys.next()) {
            transactionId = generatedKeys.getInt(1);  // Récupérer l'ID de la transaction générée
        }

        // Insertion des tickets associés dans la table transaction_ticket
        if (transaction.getTickets_associes() != null && !transaction.getTickets_associes().isEmpty()) {
            ajouterTicketsAssocies(transactionId, transaction.getTickets_associes());
        }
    }

    private double calculerMontantTotal(int transactionId) throws SQLException {
        double montantTotal = 0;
        String sql = "SELECT t.prix FROM transaction_ticket tt JOIN ticket t ON tt.id_ticket= t.id_ticket WHERE tt.id_transaction = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, transactionId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            montantTotal += rs.getDouble("prix");
        }
        return montantTotal;
    }

    private void ajouterTicketsAssocies(int transactionId, List<Ticket> tickets) throws SQLException {
        String sqlCheck = "SELECT COUNT(*) FROM transaction_ticket WHERE id_transaction = ? AND id_ticket = ?";
        String sqlInsert = "INSERT IGNORE INTO transaction_ticket (id_transaction, id_ticket) VALUES (?, ?)";
        PreparedStatement psCheck = connection.prepareStatement(sqlCheck);
        PreparedStatement psInsert = connection.prepareStatement(sqlInsert);

        for (Ticket ticket : tickets) {
            // Vérifier si le ticket existe déjà pour cette transaction
            psCheck.setInt(1, transactionId);
            psCheck.setInt(2, ticket.getId_ticket());
            ResultSet rs = psCheck.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                // Si le ticket n'existe pas, l'ajouter à transaction_ticket
                psInsert.setInt(1, transactionId);
                psInsert.setInt(2, ticket.getId_ticket());
                psInsert.addBatch(); // Ajout à batch
            }
        }

        // Exécution du batch pour insérer les tickets
        psInsert.executeBatch();
    }


    @Override
    public void modifier(Transaction transaction) throws SQLException {
        String sql = "UPDATE transaction SET utilisateur_id=?, montant_total=?, mode_paiement=?, date_paiement=? WHERE id_transaction=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
        ps.setDouble(2, transaction.getMontant_total());
        ps.setString(3, transaction.getMode_paiement());
        ps.setTimestamp(4, transaction.getDate_paiement());
        ps.setInt(5, transaction.getId_transaction());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql1 = "DELETE FROM transaction_ticket WHERE id_transaction = ?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setInt(1, id);
        ps1.executeUpdate();

        String sql2 = "DELETE FROM transaction WHERE id_transaction = ?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        ps2.setInt(1, id);
        ps2.executeUpdate();
    }

    @Override
    public List<Transaction> afficher() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transaction";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int id_transaction = rs.getInt("id_transaction");
            Utilisateur utilisateur = recupererUtilisateur(rs.getInt("utilisateur_id"));
            List<Ticket> tickets_associes = recupererTicketsAssocies(id_transaction);

            transactions.add(new Transaction(
                    id_transaction,
                    utilisateur,
                    tickets_associes,
                    rs.getDouble("montant_total"),
                    rs.getString("mode_paiement"),
                    rs.getTimestamp("date_paiement")
                     // Ajouter les tickets associés à la transaction
            ));
        }
        return transactions;
    }

    private Utilisateur recupererUtilisateur(int utilisateurId) throws SQLException {
        String sql = "SELECT * FROM utilisateur WHERE utilisateur_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, utilisateurId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Utilisateur(
                    rs.getInt("utilisateur_id"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getString("mot_de_passe"),
                    rs.getString("role"),
                    rs.getString("etat"),
                    rs.getFloat("note_organisateur"),
                    rs.getString("entreprise")
            );
        }
        return null;
    }

    private List<Ticket> recupererTicketsAssocies(int transactionId) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT id_ticket FROM transaction_ticket WHERE id_transaction = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, transactionId);
        ResultSet rs = ps.executeQuery();
        ServiceTicket serviceTicket = new ServiceTicket();
        while (rs.next()) {
            Ticket ticket = serviceTicket.recupererTicketParId(rs.getInt("id_ticket"));
            if (ticket != null) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }
}
