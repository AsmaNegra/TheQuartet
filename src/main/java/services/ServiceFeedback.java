package services;

import entities.Feedback;
import entities.Evenement;
import entities.Utilisateur;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceFeedback implements IService<Feedback>{
    private Connection connection;

    public ServiceFeedback() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO `feedback` (`note`, `commentaire`, `date_feedback`, `evenement_id`, `utilisateur_id`) " +
            "VALUES (" + feedback.getNote() + ", '" +
            feedback.getCommentaire() + "', '" +
            new java.sql.Timestamp(feedback.getDate_feedback().getTime()) + "', " +
            feedback.getEvenement_id().getEvenement_id() + ", " +
            feedback.getUtilisateur_id().getUtilisateurId() + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    @Override
    public void modifier(Feedback feedback) throws SQLException {
        String sql = "UPDATE `feedback` SET `note`=?, `commentaire`=?, `date_feedback`=?, `evenement_id`=?, `utilisateur_id`=? WHERE `feedback_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, feedback.getNote());
        ps.setString(2, feedback.getCommentaire());
        ps.setTimestamp(3, new java.sql.Timestamp(feedback.getDate_feedback().getTime()));
        ps.setInt(4, feedback.getEvenement_id().getEvenement_id());
        ps.setInt(5, feedback.getUtilisateur_id().getUtilisateurId());
        ps.setInt(6, feedback.getFeedback_id());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `feedback` WHERE `feedback_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Feedback> afficher() throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT * FROM `feedback`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Evenement evenement = new Evenement();
            evenement.setEvenement_id(rs.getInt("evenement_id"));

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));

            Feedback feedback = new Feedback(
                rs.getInt("feedback_id"),
                rs.getInt("note"),
                rs.getString("commentaire"),
                rs.getTimestamp("date_feedback"),
                evenement,
                utilisateur
            );
            feedbacks.add(feedback);
        }
        return feedbacks;
    }
}
