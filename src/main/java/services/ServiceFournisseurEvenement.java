package services;

import entities.Evenement;
import entities.Fournisseur;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceFournisseurEvenement {
    private Connection connection;

    public ServiceFournisseurEvenement() {
        connection = MyDataBase.getInstance().getConnection();
    }

    // 🔹 Associer un fournisseur à un événement
    public void associerFournisseurAEvenement(int fournisseurId, int evenementId) {
        String sql = "INSERT INTO fournisseur_evenement (fournisseur_id, evenement_id) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fournisseurId);
            stmt.setInt(2, evenementId);
            stmt.executeUpdate();
            System.out.println("Fournisseur " + fournisseurId + " associé à l'événement " + evenementId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Supprimer un fournisseur de tous ses événements
    public void supprimerFournisseurDeTousEvenements(int fournisseurId) {
        String sql = "DELETE FROM fournisseur_evenement WHERE fournisseur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fournisseurId);
            stmt.executeUpdate();
            System.out.println("Fournisseur " + fournisseurId + " supprimé de tous ses événements.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Désassocier un fournisseur d'un événement spécifique
    public void desassocierFournisseurDeEvenement(int fournisseurId, int evenementId) {
        String sql = "DELETE FROM fournisseur_evenement WHERE fournisseur_id = ? AND evenement_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fournisseurId);
            stmt.setInt(2, evenementId);
            stmt.executeUpdate();
            System.out.println("Fournisseur " + fournisseurId + " désassocié de l'événement " + evenementId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Récupérer tous les fournisseurs associés à un événement
    public List<Fournisseur> getFournisseursByEvenementId(int evenementId) {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        String sql = "SELECT f.fournisseur_id, f.nom, f.type_service, f.contrat, f.num_tel " +
                "FROM fournisseur f " +
                "JOIN fournisseur_evenement fe ON f.fournisseur_id = fe.fournisseur_id " +
                "WHERE fe.evenement_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, evenementId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                fournisseurs.add(new Fournisseur(
                        rs.getInt("fournisseur_id"),
                        rs.getString("nom"),
                        rs.getString("type_service"),
                        rs.getString("contrat"),
                        rs.getString("num_tel")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fournisseurs;
    }

    // 🔹 Récupérer tous les événements associés à un fournisseur
    public List<Evenement> getEvenementsByFournisseurId(int fournisseurId) {
        List<Evenement> evenements = new ArrayList<>();
        String sql = "SELECT e.evenement_id, e.nom, e.description, e.date_debut, e.date_fin, e.lieu, e.categorie, e.budget, e.image_evenement, e.nb_places " +
                "FROM evenement e " +
                "JOIN fournisseur_evenement fe ON e.evenement_id = fe.evenement_id " +
                "WHERE fe.fournisseur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, fournisseurId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                evenements.add(new Evenement(
                        rs.getInt("evenement_id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getTimestamp("date_debut"),
                        rs.getTimestamp("date_fin"),
                        rs.getString("lieu"),
                        rs.getString("categorie"),
                        rs.getFloat("budget"),
                        rs.getString("image_evenement"),
                        rs.getInt("nb_places")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evenements;
    }

    // 🔹 Afficher tous les fournisseurs
    public List<Fournisseur> afficherTousLesFournisseurs() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        String sql = "SELECT * FROM fournisseur";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                fournisseurs.add(new Fournisseur(
                        rs.getInt("fournisseur_id"),
                        rs.getString("nom"),
                        rs.getString("type_service"),
                        rs.getString("contrat"),
                        rs.getString("num_tel")
                ));
            }
        }
        return fournisseurs;
    }
}