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
    public Utilisateur getUtilisateurById(int id) throws SQLException {
        String query = "SELECT * FROM utilisateur WHERE utilisateur_id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new Utilisateur(
                            rs.getInt("utilisateur_id"),
                            rs.getString("nom"),
                            rs.getString("email"),
                            rs.getString("mot_de_passe"),
                            rs.getString("role"),
                            rs.getString("etat"),
                            rs.getFloat("note_organisateur"),
                            rs.getString("entreprise")
                    );
                }
            }
        }
        return null;
    }

    // 🔹 Associer un utilisateur à un événement
    public void inscrireUtilisateurAEvenement(int utilisateur_id, int evenement_id) {
        String sql = "INSERT INTO utilisateur_evenement (utilisateur_id, evenement_id) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateur_id);
            stmt.setInt(2, evenement_id);
            stmt.executeUpdate();
            System.out.println("Utilisateur " + utilisateur_id + " inscrit à l'événement " + evenement_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // 🔹 Supprimer un utilisateur de tous ses événements
    public void supprimer(int utilisateur_id) {
        String sql = "DELETE FROM utilisateur_evenement WHERE utilisateur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateur_id);
            stmt.executeUpdate();
            System.out.println("Utilisateur " + utilisateur_id + " supprimé de tous ses événements.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Désinscrire un utilisateur d'un événement spécifique
    public void desinscrireUtilisateurDeEvenement(int utilisateur_id, int evenement_id) {
        String sql = "DELETE FROM utilisateur_evenement WHERE utilisateur_id = ? AND evenement_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateur_id);
            stmt.setInt(2, evenement_id);
            stmt.executeUpdate();
            System.out.println("Utilisateur " + utilisateur_id + " désinscrit de l'événement " + evenement_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Evenement> getEvenementsByUtilisateurId(int utilisateur_id) {
        List<Evenement> evenements = new ArrayList<>();
        String sql = "SELECT e.id, e.nom, e.description, e.date_debut, e.date_fin, e.lieu, e.categorie, e.budget, e.image_event " +
                "FROM evenement e JOIN utilisateur_evenement ue ON e.id = ue.evenement_id WHERE ue.utilisateur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateur_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                evenements.add(new Evenement(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getTimestamp("date_debut"),
                        rs.getTimestamp("date_fin"),
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
