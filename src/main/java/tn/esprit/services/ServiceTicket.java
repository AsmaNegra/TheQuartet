package tn.esprit.services;

import tn.esprit.entities.Ticket;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ServiceTicket implements ISevrice<Ticket>{
    private final Connection connection;

    public ServiceTicket() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Ticket ticket) throws SQLException {
        String sql ="INSERT INTO `ticket`(`id_event`, `id_transaction`, `type`, `statut`,`prix`, `date_validite`) VALUES ("+ticket.getId_event()+","+ticket.getId_transaction()+",'"+ticket.getType()+"','"+ticket.getStatut()+"',"+ticket.getPrix()+",'"+ticket.getDate_validite()+"')";
        Statement statement= connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public void modifier(Ticket ticket) throws SQLException {
        String sql = "UPDATE `ticket` SET `id_event`=?, `id_transaction`=?, `type`=?, `statut`=?, `prix`=?, `date_validite`=? WHERE id_ticket = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ticket.getId_event());
        ps.setInt(2, ticket.getId_transaction());
        ps.setString(3, ticket.getType());
        ps.setString(4, ticket.getStatut());
        ps.setDouble(5, ticket.getPrix());
        ps.setDate(6, ticket.getDate_validite());
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

    @Override
    public List<Ticket> afficher() throws SQLException {
        List<Ticket> tickets =new ArrayList<>();
        String sql = "SELECT * FROM `ticket`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql );
        while (rs.next()) {
            tickets.add(new Ticket(
                    rs.getInt(1), // id_ticket
                    rs.getInt(2), // id_event
                    rs.getInt(3), // id_transaction
                    rs.getString(4), // type
                    rs.getString(5), // statut
                    rs.getDouble(6), // prix
                    rs.getDate(7)  // date_validite
            ));
        }
        return tickets;
    }
}
