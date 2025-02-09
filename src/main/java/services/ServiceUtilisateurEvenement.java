package services;

import entities.Evenement;
import entities.Utilisateur;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceUtilisateurEvenement {
    private Connection connection;

    public ServiceUtilisateurEvenement() {
        connection = MyDataBase.getInstance().getConnection();
    }
    

    // 🔹 Associer un utilisateur à un événement
    public void inscrireUtilisateurAEvenement(int utilisateurId, int evenementId) {
        String sql = "INSERT INTO utilisateur_evenement (utilisateur_id, evenement_id) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateurId);
            stmt.setInt(2, evenementId);
            stmt.executeUpdate();
            System.out.println("Utilisateur " + utilisateurId + " inscrit à l'événement " + evenementId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // 🔹 Supprimer un utilisateur de tous ses événements
    public void supprimer(int utilisateurId) {
        String sql = "DELETE FROM utilisateur_evenement WHERE utilisateur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateurId);
            stmt.executeUpdate();
            System.out.println("Utilisateur " + utilisateurId + " supprimé de tous ses événements.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Désinscrire un utilisateur d'un événement spécifique
    public void desinscrireUtilisateurDeEvenement(int utilisateurId, int evenementId) {
        String sql = "DELETE FROM utilisateur_evenement WHERE utilisateur_id = ? AND evenement_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateurId);
            stmt.setInt(2, evenementId);
            stmt.executeUpdate();
            System.out.println("Utilisateur " + utilisateurId + " désinscrit de l'événement " + evenementId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Evenement> getEvenementsByUtilisateurId(int utilisateurId) {
        List<Evenement> evenements = new ArrayList<>();
        String sql = "SELECT e.id, e.nom, e.description, e.date_debut, e.date_fin, e.lieu, e.categorie, e.budget, e.image_event " +
                "FROM evenement e JOIN utilisateur_evenement ue ON e.id = ue.evenement_id WHERE ue.utilisateur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateurId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                evenements.add(new Evenement(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),
                        rs.getString("lieu"),
                        rs.getString("categorie"),
                        rs.getFloat("budget"),
                        rs.getString("image_event")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evenements;
    }

    // 🔹 Récupérer tous les utilisateurs inscrits à un événement
    public List<Utilisateur> getUtilisateursByEvenementId(int evenementId) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT u.id, u.nom, u.email FROM utilisateur u " +
                "JOIN utilisateur_evenement ue ON u.id = ue.utilisateur_id WHERE ue.evenement_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, evenementId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                utilisateurs.add(new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        null, null, null, 0, null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
}
