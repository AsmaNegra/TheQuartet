package services;

import entities.Ticket;
import entities.Evenement;
import services.ServiceEvenement;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTicket implements IService<Ticket> {

    private Connection connection;

    public ServiceTicket() {
        connection = MyDataBase.getInstance().getConnection();
    }

    private boolean evenementExiste(int evenement_id) throws SQLException {
        String query = "SELECT COUNT(*) FROM evenement WHERE evenement_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, evenement_id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void ajouter(Ticket t) throws SQLException {
        if (!evenementExiste(t.getEvenement().getEvenement_id())) {
            throw new SQLException("Événement non existant, impossible de créer des tickets");
        }
        String query = "INSERT INTO ticket (evenement_id, type, statut, prix, date_validite, nb_tickets) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, t.getEvenement().getEvenement_id());
            pst.setString(2, t.getType());
            pst.setString(3, t.getStatut());
            pst.setDouble(4, t.getPrix());
            pst.setTimestamp(5, t.getDate_validite());
            pst.setInt(6, t.getNb_tickets());
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Ticket ajouté avec succès !");
            } else {
                System.out.println("L'ajout du ticket a échoué, aucune ligne affectée.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erreur lors de l'ajout du ticket", e);
        }
    }

    @Override
    public void modifier(Ticket t) throws SQLException {
        if (!evenementExiste(t.getEvenement().getEvenement_id())) {
            throw new SQLException("Événement non existant, impossible de modifier le ticket");
        }
        String query = "UPDATE ticket SET evenement_id=?, type=?, statut=?, prix=?, date_validite=?, nb_tickets=? WHERE id_ticket=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, t.getEvenement().getEvenement_id());
            pst.setString(2, t.getType());
            pst.setString(3, t.getStatut());
            pst.setDouble(4, t.getPrix());
            pst.setTimestamp(5, t.getDate_validite());
            pst.setInt(6, t.getNb_tickets());
            pst.setInt(7, t.getId_ticket());
            pst.executeUpdate();
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String query = "DELETE FROM ticket WHERE id_ticket=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    @Override
    public List<Ticket> afficher() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM ticket";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                ServiceEvenement serviceEvenement= new ServiceEvenement();
                int evenementId = rs.getInt("evenement_id");
                Evenement evenement = serviceEvenement.getEvenementById(evenementId); // Charger l’événement
                Ticket t = new Ticket(
                        rs.getInt("id_ticket"),
                        evenement,
                        rs.getString("type"),
                        rs.getString("statut"),
                        rs.getDouble("prix"),
                        rs.getTimestamp("date_validite"),
                        rs.getInt("nb_tickets")
                );
                tickets.add(t);
            }
        }
        return tickets;
    }

    public Ticket getTicketById(int id) throws SQLException {
        Ticket ticket = null;
        String query = "SELECT * FROM ticket WHERE id_ticket = ?"; // Requête SQL pour récupérer un ticket par ID
        try (PreparedStatement stmt = connection.prepareStatement(query)) {  // Utilisation de PreparedStatement
            stmt.setInt(1, id);  // On définit le paramètre (id_ticket)

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ServiceEvenement serviceEvenement= new ServiceEvenement();
                    int evenementId = rs.getInt("evenement_id");
                    Evenement evenement = serviceEvenement.getEvenementById(evenementId); // Charger l’événement
                    // Si le ticket existe, on le crée à partir des données récupérées
                    int idTicket = rs.getInt("id_ticket");
                    String type = rs.getString("type");
                    String statut = rs.getString("statut");
                    double prix = rs.getDouble("prix");
                    Timestamp dateLimite = rs.getTimestamp("date_validite");
                    int quantite = rs.getInt("nb_tickets");

                    // Créer l'objet Ticket en utilisant les données récupérées
                    ticket = new Ticket(idTicket, evenement, type, statut, prix, dateLimite, quantite);
                }
            }
        }
        return ticket; // Retourne le ticket trouvé ou null si pas trouvé
    }


}
