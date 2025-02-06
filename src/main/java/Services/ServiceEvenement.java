package Services;

import Entities.Evenement;
import Entities.Utilisateur;
import Utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceEvenement implements IService<Evenement>{
    private Connection connection;

    public ServiceEvenement() {
        connection = MyDataBase.getInstance().getConnection();
    }


    @Override
    public void ajouter(Evenement evenement) throws SQLException {
        String sql = "INSERT INTO `evenement` (`nom`, `description`, `date_debut`, `date_fin`, `lieu`, `categorie`, `budget`, `image_event`, `organisateur_id`) " +
            "VALUES ('" + evenement.getNom() + "', '" +
            evenement.getDescription() + "', '" +
            new java.sql.Date(evenement.getDate_debut().getTime()) + "', '" +
            new java.sql.Date(evenement.getDate_fin().getTime()) + "', '" +
            evenement.getLieu() + "', '" +
            evenement.getCategorie() + "', " +
            evenement.getBudget() + ", '" +
            evenement.getImage_event() + "', " +
            evenement.getOrganisateur_id().getUtilisateurId() + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public void modifier(Evenement evenement) throws SQLException {
        String sql = "UPDATE `evenement` SET `nom`=?, `description`=?, `date_debut`=?, `date_fin`=?, `lieu`=?, `categorie`=?, `budget`=?, `image_event`=?, `organisateur_id`=? WHERE `evenement_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, evenement.getNom());
        ps.setString(2, evenement.getDescription());
        ps.setDate(3, new java.sql.Date(evenement.getDate_debut().getTime()));
        ps.setDate(4, new java.sql.Date(evenement.getDate_fin().getTime()));
        ps.setString(5, evenement.getLieu());
        ps.setString(6, evenement.getCategorie());
        ps.setFloat(7, evenement.getBudget());
        ps.setString(8, evenement.getImage_event());
        ps.setInt(9, evenement.getOrganisateur_id().getUtilisateurId());
        ps.setInt(10, evenement.getEvenement_id());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `evenement` WHERE `evenement_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Evenement> afficher() throws SQLException {
        List<Evenement> evenements = new ArrayList<>();
        String sql = "SELECT * FROM `evenement`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Utilisateur organisateur = new Utilisateur();
            organisateur.setUtilisateurId(rs.getInt("organisateur_id"));

            Evenement evenement = new Evenement(
                rs.getInt("evenement_id"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getDate("date_debut"),
                rs.getDate("date_fin"),
                rs.getString("lieu"),
                rs.getString("categorie"),
                rs.getFloat("budget"),
                rs.getString("image_event"),
                organisateur
            );
            evenements.add(evenement);
        }
        return evenements;
    }
}
