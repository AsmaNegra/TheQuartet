package services;

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


    public void ajouter(Evenement evenement) throws SQLException {
        String req = "INSERT INTO evenement (nom, description, date_debut, date_fin, lieu, categorie, budget, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, evenement.getNom());
        ps.setString(2, evenement.getDescription());
        ps.setTimestamp(3, evenement.getDate_debut());
        ps.setTimestamp(4, evenement.getDate_fin());
        ps.setString(5, evenement.getLieu());
        ps.setString(6, evenement.getCategorie());
        ps.setFloat(7, evenement.getBudget());
        ps.setString(8, evenement.getImage_event());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            evenement.setEvenement_id(rs.getInt(1)); // Met à jour l'ID de l'événement
            System.out.println("✅ ID de l'événement récupéré : " + evenement.getEvenement_id());
        } else {
            System.out.println("⚠️ Aucun ID généré pour l'événement !");
        }
    }

    @Override
    public void modifier(Evenement evenement) throws SQLException {
        String sql = "UPDATE `evenement` SET `nom`=?, `description`=?, `date_debut`=?, `date_fin`=?, `lieu`=?, `categorie`=?, `budget`=?, `image_event`=? WHERE `evenement_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, evenement.getNom());
        ps.setString(2, evenement.getDescription());
        ps.setTimestamp(3, new java.sql.Timestamp(evenement.getDate_debut().getTime()));
        ps.setTimestamp(4, new java.sql.Timestamp(evenement.getDate_fin().getTime()));
        ps.setString(5, evenement.getLieu());
        ps.setString(6, evenement.getCategorie());
        ps.setFloat(7, evenement.getBudget());
        ps.setString(8, evenement.getImage_event());
        ps.setInt(9, evenement.getEvenement_id());
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


            Evenement evenement = new Evenement(
                rs.getInt("evenement_id"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getTimestamp("date_debut"),
                rs.getTimestamp("date_fin"),
                rs.getString("lieu"),
                rs.getString("categorie"),
                rs.getFloat("budget"),
                rs.getString("image_event")
            );
            evenements.add(evenement);
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
                        rs.getString("image_event")
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
                        rs.getString("image_event")
                );
                evenements.add(evenement);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des événements : " + e.getMessage());
        }

        return evenements;
    }

}
