package services;

import entities.Evenement;
import entities.Ticket;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ServiceTicket implements IService<Ticket>{
    private final Connection connection;

    public ServiceTicket() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Ticket ticket) throws SQLException {
        String sql ="INSERT INTO `ticket`(`evenement_id`, `id_transaction`, `type`, `statut`,`prix`, `date_validite`) VALUES " +
            "("+ticket.getEvenement_id()+","+ticket.getId_transaction()+",'"+ticket.getType()+"','"+ticket.getStatut()+"',"+ticket.getPrix()+",'"+new java.sql.Date(ticket.getDate_validite().getTime())+"')";
        Statement statement= connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public void modifier(Ticket ticket) throws SQLException {
        String sql = "UPDATE `ticket` SET `evenement_id`=?, `id_transaction`=?, `type`=?, `statut`=?, `prix`=?, `date_validite`=? WHERE id_ticket = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ticket.getEvenement_id().getEvenement_id());
        ps.setInt(2, ticket.getId_transaction());
        ps.setString(3, ticket.getType());
        ps.setString(4, ticket.getStatut());
        ps.setDouble(5, ticket.getPrix());
//        ps.setDate(6, ticket.getDate_validite());
        ps.setDate(6, new java.sql.Date(ticket.getDate_validite().getTime()));
        ps.setInt(7, ticket.getId_ticket());
        ps.executeUpdate(); // Corrigé ici
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql="DELETE FROM `ticket` WHERE id_ticket = ?";
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
    public Evenement recupererEvenementParId(int idEvenement) throws SQLException {
        String sql = "SELECT * FROM evenement WHERE evenement_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idEvenement);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            return new Evenement(
                    rs.getInt("evenement_id"),
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getDate("date_debut"),
                    rs.getDate("date_fin"),
                    rs.getString("lieu"),
                    rs.getString("categorie"),
                    rs.getFloat("budget"),
                    rs.getString("image_event")
            );
        }
        return null; // Retourne null si aucun événement trouvé (à gérer selon tes besoins)
    }
    @Override
    public List<Ticket> afficher() throws SQLException {
        List<Ticket> tickets =new ArrayList<>();
        String sql = "SELECT * FROM `ticket`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql );
        while (rs.next()) {
            Evenement evenement = recupererEvenementParId(rs.getInt(2)); // Récupérer l'événement
            tickets.add(new Ticket(
                    rs.getInt(1), // id_ticket
                    evenement, // evenement
                    rs.getInt(3), // id_transaction
                    rs.getString(4), // type
                    rs.getString(5), // statut
                    rs.getDouble(6), // prix
//                    rs.getDate(7)  // date_validite
                new java.util.Date(rs.getDate("date_validite").getTime())
            ));
        }
        return tickets;
    }
}
