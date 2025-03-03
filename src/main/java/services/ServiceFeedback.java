
package services;

import entities.Evenement;
import entities.Feedback;
import entities.Utilisateur;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceFeedback implements IService<Feedback> {
    private Connection connection;

    public ServiceFeedback() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO feedback (note, commentaire, date_feedback, evenement_id, utilisateur_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, feedback.getNote());
            ps.setString(2, feedback.getCommentaire());
            ps.setTimestamp(3, new Timestamp(feedback.getDate_feedback().getTime()));
            ps.setInt(4, feedback.getEvenement_id().getEvenement_id());
            ps.setInt(5, feedback.getUtilisateur_id().getUtilisateurId());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    feedback.setFeedback_id(generatedKeys.getInt(1));
                }
            }
        }
    }

    @Override
    public void modifier(Feedback feedback) throws SQLException {
        String sql = "UPDATE feedback SET note = ?, commentaire = ? WHERE feedback_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, feedback.getNote());
            ps.setString(2, feedback.getCommentaire());
            ps.setInt(3, feedback.getFeedback_id());
            ps.executeUpdate();
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM feedback WHERE feedback_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Feedback> afficher() throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT f.*, e.*, u.* FROM feedback f " +
            "JOIN evenement e ON f.evenement_id = e.evenement_id " +
            "JOIN utilisateur u ON f.utilisateur_id = u.utilisateur_id";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                feedbacks.add(extractFeedbackFromResultSet(rs));
            }
        }
        return feedbacks;
    }

    public List<Feedback> getFeedbacksParEvenement(int evenementId) throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT f.feedback_id, f.note, f.commentaire, f.date_feedback, " +
            "e.evenement_id, e.nom AS nom_evenement, " +
            "u.utilisateur_id, u.nom AS nom_utilisateur " +
            "FROM feedback f " +
            "JOIN evenement e ON f.evenement_id = e.evenement_id " +
            "JOIN utilisateur u ON f.utilisateur_id = u.utilisateur_id " +
            "WHERE e.evenement_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, evenementId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                feedbacks.add(extractFeedbackFromResultSet(rs));
            }
        }
        return feedbacks;
    }

    private Feedback extractFeedbackFromResultSet(ResultSet rs) throws SQLException {
        // Créer l'événement
        Evenement evenement = new Evenement();
        evenement.setEvenement_id(rs.getInt("evenement_id"));
        evenement.setNom(rs.getString("nom_evenement")); // Utiliser l'alias

        // Créer l'utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
        utilisateur.setNom(rs.getString("nom_utilisateur")); // Utiliser l'alias

        // Créer le feedback
        Feedback feedback = new Feedback();
        feedback.setFeedback_id(rs.getInt("feedback_id"));
        feedback.setNote(rs.getInt("note"));
        feedback.setCommentaire(rs.getString("commentaire"));
        feedback.setDate_feedback(rs.getTimestamp("date_feedback"));
        feedback.setEvenement_id(evenement);
        feedback.setUtilisateur_id(utilisateur);

        return feedback;
    }

    /**
     * Récupérer tous les feedbacks pour un événement spécifique
     */
    public List<Feedback> getFeedbacksByEventId(int eventId) throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT f.feedback_id, f.note, f.commentaire, f.date_feedback, " +
            "e.evenement_id, e.nom AS nom_evenement, e.description, e.date_debut, e.date_fin, e.lieu, e.categorie, e.image_event, " +
            "u.utilisateur_id, u.nom AS nom_utilisateur, u.email " +
            "FROM feedback f " +
            "JOIN evenement e ON f.evenement_id = e.evenement_id " +
            "JOIN utilisateur u ON f.utilisateur_id = u.utilisateur_id " +
            "WHERE e.evenement_id = ? " +
            "ORDER BY f.date_feedback DESC";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, eventId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                feedbacks.add(extractDetailedFeedbackFromResultSet(rs));
            }
        }
        return feedbacks;
    }

    /**
     * Récupérer tous les feedbacks pour un utilisateur spécifique
     */
    public List<Feedback> getFeedbacksByUserId(int userId) throws SQLException {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT f.feedback_id, f.note, f.commentaire, f.date_feedback, " +
            "e.evenement_id, e.nom AS nom_evenement, e.description, e.date_debut, e.date_fin, e.lieu, e.categorie, e.image_event, " +
            "u.utilisateur_id, u.nom AS nom_utilisateur, u.email " +
            "FROM feedback f " +
            "JOIN evenement e ON f.evenement_id = e.evenement_id " +
            "JOIN utilisateur u ON f.utilisateur_id = u.utilisateur_id " +
            "WHERE u.utilisateur_id = ? " +
            "ORDER BY f.date_feedback DESC";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                feedbacks.add(extractDetailedFeedbackFromResultSet(rs));
            }
        }
        return feedbacks;
    }

    /**
     * Extraire un feedback détaillé depuis le ResultSet
     */
    private Feedback extractDetailedFeedbackFromResultSet(ResultSet rs) throws SQLException {
        // Créer l'événement avec plus de détails
        Evenement evenement = new Evenement();
        evenement.setEvenement_id(rs.getInt("evenement_id"));
        evenement.setNom(rs.getString("nom_evenement"));

        // Ajouter plus de détails si disponibles dans le ResultSet
        try {
            evenement.setDescription(rs.getString("description"));
            evenement.setDate_debut(rs.getTimestamp("date_debut"));
            evenement.setDate_fin(rs.getTimestamp("date_fin"));
            evenement.setLieu(rs.getString("lieu"));
            evenement.setCategorie(rs.getString("categorie"));
            evenement.setImage_event(rs.getString("image_event"));
        } catch (SQLException e) {
            // Ignorer les colonnes qui n'existent pas dans certaines requêtes
        }

        // Créer l'utilisateur avec plus de détails
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
        utilisateur.setNom(rs.getString("nom_utilisateur"));

        // Ajouter plus de détails si disponibles
        try {
            utilisateur.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            // Ignorer les colonnes qui n'existent pas dans certaines requêtes
        }

        // Créer le feedback
        Feedback feedback = new Feedback();
        feedback.setFeedback_id(rs.getInt("feedback_id"));
        feedback.setNote(rs.getInt("note"));
        feedback.setCommentaire(rs.getString("commentaire"));
        feedback.setDate_feedback(rs.getTimestamp("date_feedback"));
        feedback.setEvenement_id(evenement);
        feedback.setUtilisateur_id(utilisateur);

        return feedback;
    }

    /**
     * Vérifier si un utilisateur a déjà laissé un avis sur un événement
     */
    public boolean userHasReviewed(int userId, int eventId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM feedback WHERE utilisateur_id = ? AND evenement_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, eventId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }

        return false;
    }

    /**
     * Calculer la note moyenne d'un événement
     */
    public double getAverageRatingForEvent(int eventId) throws SQLException {
        String sql = "SELECT AVG(note) FROM feedback WHERE evenement_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, eventId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double avg = rs.getDouble(1);
                return avg > 0 ? avg : 0; // Retourner 0 si NULL
            }
        }

        return 0.0;
    }

    /**
     * Compter le nombre d'avis pour un événement
     */
    public int countFeedbacksForEvent(int eventId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM feedback WHERE evenement_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, eventId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }

        return 0;
    }

    /**
     * Récupérer les événements les mieux notés
     */
    public List<Evenement> getTopRatedEvents(int limit) throws SQLException {
        List<Evenement> topEvents = new ArrayList<>();
        String sql = "SELECT e.*, AVG(f.note) as avg_rating, COUNT(f.feedback_id) as review_count " +
            "FROM evenement e " +
            "JOIN feedback f ON e.evenement_id = f.evenement_id " +
            "GROUP BY e.evenement_id " +
            "HAVING COUNT(f.feedback_id) >= 1 " + // Au moins 1 avis
            "ORDER BY avg_rating DESC, review_count DESC " +
            "LIMIT ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, limit);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Evenement event = new Evenement();
                event.setEvenement_id(rs.getInt("evenement_id"));
                event.setNom(rs.getString("nom"));
                event.setDescription(rs.getString("description"));
                event.setDate_debut(rs.getTimestamp("date_debut"));
                event.setDate_fin(rs.getTimestamp("date_fin"));
                event.setLieu(rs.getString("lieu"));
                event.setCategorie(rs.getString("categorie"));
                event.setImage_event(rs.getString("image_event"));

                // Vous pourriez stocker la note moyenne dans un champ supplémentaire si nécessaire

                topEvents.add(event);
            }
        }

        return topEvents;
    }

    /**
     * Récupérer les avis récents (tous événements confondus)
     */
    public List<Feedback> getRecentFeedbacks(int limit) throws SQLException {
        List<Feedback> recentFeedbacks = new ArrayList<>();
        String sql = "SELECT f.feedback_id, f.note, f.commentaire, f.date_feedback, " +
            "e.evenement_id, e.nom AS nom_evenement, " +
            "u.utilisateur_id, u.nom AS nom_utilisateur " +
            "FROM feedback f " +
            "JOIN evenement e ON f.evenement_id = e.evenement_id " +
            "JOIN utilisateur u ON f.utilisateur_id = u.utilisateur_id " +
            "ORDER BY f.date_feedback DESC " +
            "LIMIT ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, limit);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                recentFeedbacks.add(extractFeedbackFromResultSet(rs));
            }
        }

        return recentFeedbacks;
    }
}


