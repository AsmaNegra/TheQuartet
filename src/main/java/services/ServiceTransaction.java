package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Ticket;
import entities.Transaction;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ServiceTransaction implements IService<Transaction>{
    private final Connection connection;

    public ServiceTransaction(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouter(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO `transaction`(`utilisateur_id`, `tickets_associes`, `montant_total`, `methode_paiement`, `type_paiement`, `date_paiement`) VALUES (?, ?, ?, ?, ?, ?)";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTicketsAssocies;
        try {
            jsonTicketsAssocies = objectMapper.writeValueAsString(transaction.getTickets_associes());
        } catch (JsonProcessingException e) {
            throw new SQLException("Erreur lors de la conversion des tickets associés en JSON", e);
        }

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, transaction.getUtilisateur_id().getUtilisateurId());
        ps.setString(2, jsonTicketsAssocies); // Insérer les tickets associés en JSON
        ps.setDouble(3, transaction.getMontant_total());
        ps.setString(4, transaction.getMethode_paiement());
        ps.setString(5, transaction.getType_paiement());
        ps.setDate(6, transaction.getDate_paiement());

        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur d'exécution de la requête : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void modifier(Transaction transaction) throws SQLException {
        String sql= "UPDATE `transaction` SET `utilisateur_id`=?,`tickets_associes`=?,`montant_total`=?,`methode_paiement`=?,`type_paiement`=?,`date_paiement`=? WHERE id_transaction =?";
        // Convertir la liste des tickets associés en JSON
        ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper
        String jsonTicketsAssocies;
        try {
            jsonTicketsAssocies = objectMapper.writeValueAsString(transaction.getTickets_associes());
        } catch (JsonProcessingException e) {
            throw new SQLException("Erreur lors de la conversion des tickets associés en JSON", e);
        }
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setInt(1, transaction.getUtilisateur_id());
        ps.setString(2, jsonTicketsAssocies);        ps.setDouble(3,transaction.getMontant_total());
        ps.setString(4,transaction.getMethode_paiement());
        ps.setString(5,transaction.getType_paiement());
        ps.setDate(6,transaction.getDate_paiement());
        ps.setInt(7,transaction.getId_transaction());
        ps.executeUpdate(sql);
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql="DELETE FROM `transaction` WHERE id_transaction = ?";
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public List<Transaction> afficher() throws SQLException {
        List<Transaction> transactions =new ArrayList<>();
        String sql = "SELECT * FROM `transaction`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql );

        ObjectMapper objectMapper = new ObjectMapper();
        while (rs.next()){
            List<Ticket> tickets_associes;
            try {
                tickets_associes = objectMapper.readValue(rs.getString(3), new TypeReference<List<Ticket>>() {});
            } catch (JsonProcessingException e) {
                throw new SQLException("Erreur lors de la désérialisation des tickets associés", e);
            }
            transactions.add(new Transaction(rs.getInt(1), rs.getInt(2),tickets_associes,rs.getDouble(4),rs.getString(5),rs.getString(6),rs.getDate(7)));
        }
        return transactions;
    }
}
