package services;

import entities.Evenement;
import entities.Ticket;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ServiceTicket implements IService<Ticket> {
    private final Connection connection;

    public ServiceTicket() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Ticket ticket) throws SQLException {
        String req = "INSERT INTO ticket (evenement_id, type, statut, prix, date_validite, nb_tickets) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, ticket.getEvenement().getEvenement_id());
        ps.setString(2, ticket.getType());
        ps.setString(3, ticket.getStatut());
        ps.setDouble(4, ticket.getPrix());
        ps.setTimestamp(5, ticket.getDate_validite());
        ps.setInt(6, ticket.getNb_tickets());
        ps.executeUpdate();

        // Récupération de l'ID généré
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            ticket.setId_ticket(rs.getInt(1)); // Assurez-vous que votre classe Ticket a un setter pour l'ID
        }
    }

    @Override
    public void modifier(Ticket ticket) throws SQLException {
        Evenement evenement = ticket.getEvenement();
        if (evenement != null) {
            Timestamp dateValidite = (Timestamp) evenement.getDate_fin();

            String sql = "UPDATE `ticket` SET `evenement_id`=?,`type`=?, `statut`=?, `prix`=?, `date_validite`=? ,`nb_tickets`=? WHERE id_ticket = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ticket.getEvenement().getEvenement_id());
            ps.setString(2, ticket.getType());
            ps.setString(3, ticket.getStatut());
            ps.setDouble(4, ticket.getPrix());
            ps.setTimestamp(5, dateValidite);
            ps.setInt(6, ticket.getNb_tickets());
            ps.setInt(7, ticket.getId_ticket());

            ps.executeUpdate();
        } else {
            System.out.println("Erreur : L'événement avec ID " + ticket.getEvenement().getEvenement_id() + " n'existe pas.");
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `ticket` WHERE id_ticket = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public Evenement recupererEvenementParId(int evenement_id) throws SQLException {
        String sql = "SELECT * FROM evenement WHERE evenement_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, evenement_id);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            return new Evenement(
                    rs.getInt("evenement_id"),
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getTimestamp("date_debut"),
                    rs.getTimestamp("date_fin"),
                    rs.getString("lieu"),
                    rs.getString("categorie"),
                    rs.getFloat("budget"),
                    rs.getString("image_event"),
                    rs.getInt("nb_places")
            );
        } else {
            System.out.println("⚠️ Avertissement : Aucun événement trouvé pour l'ID " + evenement_id);
            return null;
        }
    }

    @Override
    public List<Ticket> afficher() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String req = "SELECT * FROM ticket";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            int evenementId = rs.getInt("evenement_id");
            ServiceEvenement serviceEvenement = new ServiceEvenement();
            Evenement evenement = serviceEvenement.getEvenementById(evenementId);

            if (evenement == null) {
                System.out.println("⚠️ Avertissement : Aucun événement trouvé pour l'ID " + evenementId);
            }

            Ticket ticket = new Ticket(
                    rs.getInt("id_ticket"),
                    evenement,
                    rs.getString("type"),
                    rs.getString("statut"),
                    rs.getDouble("prix"),
                    rs.getTimestamp("date_validite"),
                    rs.getInt("nb_tickets")
            );
            tickets.add(ticket);
        }
        return tickets;
    }


    public Ticket recupererTicketParId(int ticketId) throws SQLException {
        // SQL pour récupérer les détails du ticket par ID
        String sql = "SELECT * FROM `ticket` WHERE id_ticket = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ticketId);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            int evenementId = rs.getInt("evenement_id");
            Evenement evenement = recupererEvenementParId(evenementId);

            return new Ticket(
                    rs.getInt("id_ticket"),
                    evenement, // Peut être null si l'événement n'est pas trouvé
                    rs.getString("type"),
                    rs.getString("statut"),
                    rs.getDouble("prix"),
                    rs.getTimestamp("date_validite"),
                    rs.getInt("nb_tickets")
            );
        } else {
            System.out.println("⚠️ Aucun ticket trouvé pour l'ID " + ticketId);
            return null;
        }
    }
}
