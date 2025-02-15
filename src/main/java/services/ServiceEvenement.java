package services;

import java.sql.Timestamp;
import java.util.Date;
import entities.Evenement;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceEvenement implements IService<Evenement>{
    private Connection connection;

    public ServiceEvenement() {
        connection = MyDataBase.getInstance().getConnection();
    }


//    @Override
//    public void ajouter(Evenement evenement) throws SQLException {
//        String sql = "INSERT INTO `evenement` (`nom`, `description`, `date_debut`, `date_fin`, `lieu`, `categorie`, `budget`, `image_event`, `nb_places`) " +
//            "VALUES ('" + evenement.getNom() + "', '" +
//            evenement.getDescription() + "', '" +
//            new java.sql.Timestamp(evenement.getDate_debut().getTime()) + "', '" +
//            new java.sql.Timestamp(evenement.getDate_fin().getTime()) + "', '" +
//            evenement.getLieu() + "', '" +
//            evenement.getCategorie() + "', " +
//            evenement.getBudget() + ", '" +
//            evenement.getImage_event() + "', " +
//            evenement.getNb_places() + ")";
//        Statement statement = connection.createStatement();
//        statement.executeUpdate(sql);
//    }

    @Override
    public void ajouter(Evenement evenement) throws SQLException {
        // Vérifier si la catégorie existe
        String checkCategorySql = "SELECT COUNT(*) FROM listecategorieevent WHERE categorie = ?";
        try (PreparedStatement checkPs = connection.prepareStatement(checkCategorySql)) {
            checkPs.setString(1, evenement.getCategorie());
            ResultSet rs = checkPs.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                throw new SQLException("Catégorie invalide : " + evenement.getCategorie());
            }
        }

        // Si la catégorie existe, procéder à l'insertion
        String sql = "INSERT INTO `evenement` (`nom`, `description`, `date_debut`, `date_fin`, `lieu`, `categorie`, `budget`, `image_event`, `nb_places`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, evenement.getNom());
            ps.setString(2, evenement.getDescription());
            ps.setTimestamp(3, new Timestamp(evenement.getDate_debut().getTime()));
            ps.setTimestamp(4, new Timestamp(evenement.getDate_fin().getTime()));
            ps.setString(5, evenement.getLieu());
            ps.setString(6, evenement.getCategorie());
            ps.setFloat(7, evenement.getBudget());
            ps.setString(8, evenement.getImage_event());
            ps.setInt(9, evenement.getNb_places());

            ps.executeUpdate();
        }
    }

    @Override
    public void modifier(Evenement evenement) throws SQLException {
        String sql = "UPDATE `evenement` SET `nom`=?, `description`=?, `date_debut`=?, `date_fin`=?, `lieu`=?, `categorie`=?, `budget`=?, `image_event`=?, `nb_places`=? WHERE `evenement_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, evenement.getNom());
        ps.setString(2, evenement.getDescription());
        ps.setTimestamp(3, new java.sql.Timestamp(evenement.getDate_debut().getTime()));
        ps.setTimestamp(4, new java.sql.Timestamp(evenement.getDate_fin().getTime()));
        ps.setString(5, evenement.getLieu());
        ps.setString(6, evenement.getCategorie());
        ps.setFloat(7, evenement.getBudget());
        ps.setString(8, evenement.getImage_event());
        ps.setInt(9, evenement.getNb_places());
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

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Evenement evenement = new Evenement(
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getTimestamp("date_debut"),  // Récupération directe du Timestamp
                    rs.getTimestamp("date_fin"),    // Récupération directe du Timestamp
                    rs.getString("lieu"),
                    rs.getString("categorie"),
                    rs.getFloat("budget"),
                    rs.getString("image_event"),
                    rs.getInt("nb_places")
                );
                evenement.setEvenement_id(rs.getInt("evenement_id"));
                evenements.add(evenement);
            }
        }
        return evenements;
    }
    public Evenement getEvenementById(int id) {
        String query = "SELECT * FROM evenement WHERE evenement_id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Evenement> getAllEvenements() {
        List<Evenement> evenements = new ArrayList<>();
        String sql = "SELECT * FROM evenement";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Evenement evenement = new Evenement(
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
                evenements.add(evenement);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des événements : " + e.getMessage());
        }

        return evenements;
    }
}
