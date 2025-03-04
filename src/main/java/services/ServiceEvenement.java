package services;

import java.sql.Timestamp;
import java.util.*;

import entities.Evenement;
import utils.MyDataBase;

import java.sql.*;
import java.util.Date;

public class ServiceEvenement implements IService<Evenement>{
    private Connection connection;

    public ServiceEvenement() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Evenement evenement) throws SQLException {
        // Vérifier si un événement avec le même nom existe déjà
        Optional<Evenement> existingEvent = getEvenementParNom(evenement.getNom());
        if (existingEvent.isPresent()) {
            throw new SQLException("Un événement avec le nom '" + evenement.getNom() + "' existe déjà.");
        }
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
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
//            connection.commit();

            // Récupérer l'ID généré
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    evenement.setEvenement_id(generatedKeys.getInt(1)); // Affectez l'ID à l'objet
                }
            }
        }catch (SQLException e) {
//            connection.rollback(); // Annuler en cas d'erreur
            System.err.println("Erreur SQL lors de l'ajout : " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void modifier(Evenement evenement) throws SQLException {
        // Vérifier si un autre événement avec le même nom existe déjà
        Optional<Evenement> existingEvent = getEvenementParNom(evenement.getNom());
        if (existingEvent.isPresent() && existingEvent.get().getEvenement_id() != evenement.getEvenement_id()) {
            throw new SQLException("Un autre événement avec le nom '" + evenement.getNom() + "' existe déjà.");
        }

        String sql = "UPDATE evenement SET nom=?, description=?, date_debut=?, date_fin=?, lieu=?, categorie=?, budget=?, image_event=?, nb_places=? WHERE evenement_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, evenement.getNom());
            ps.setString(2, evenement.getDescription());
            ps.setTimestamp(3, evenement.getDate_debut());
            ps.setTimestamp(4, evenement.getDate_fin());
            ps.setString(5, evenement.getLieu());
            ps.setString(6, evenement.getCategorie());
            ps.setFloat(7, evenement.getBudget());
            ps.setString(8, evenement.getImage_event());
            ps.setInt(9, evenement.getNb_places());
            ps.setInt(10, evenement.getEvenement_id());
            ps.executeUpdate();
        }
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
        String sql = "SELECT * FROM `evenement` ORDER BY `evenement_id` DESC";

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



    public Evenement getEvenementById(int evenementId) throws SQLException {
        Evenement evenement = null;
        String query = "SELECT * FROM evenement WHERE evenement_id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, evenementId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                evenement = new Evenement();
                evenement.setEvenement_id(rs.getInt("evenement_id"));
                evenement.setNom(rs.getString("nom"));
                evenement.setDescription(rs.getString("description"));
                evenement.setDate_debut(rs.getTimestamp("date_debut"));
                evenement.setDate_fin(rs.getTimestamp("date_fin"));
                evenement.setLieu(rs.getString("lieu"));
                evenement.setCategorie(rs.getString("categorie"));
                evenement.setBudget(rs.getFloat("budget"));
                evenement.setImage_event(rs.getString("image_event"));
            }
        }
        return evenement;
    }
    public Optional<Evenement> getEvenementParNom(String nom) throws SQLException {
        String sql = "SELECT * FROM evenement WHERE nom = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Evenement evenement = new Evenement(
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
                evenement.setEvenement_id(rs.getInt("evenement_id"));
                return Optional.of(evenement);
            }
            return Optional.empty();
        }
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
    public List<String> getCategories() throws SQLException {
        Set<String> uniqueCategories = new HashSet<>();  // Utiliser un Set pour éliminer les doublons
        String sql = "SELECT DISTINCT categorie FROM listecategorieevent ORDER BY categorie";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String categorie = rs.getString("categorie");
                if (categorie != null && !categorie.trim().isEmpty()) {
                    uniqueCategories.add(categorie);
                }
            }
        }
        return new ArrayList<>(uniqueCategories);
    }

    // Ajoutez cette méthode à votre ServiceEvenement
    public List<Evenement> afficherParVues() throws SQLException {
        List<Evenement> evenements = new ArrayList<>();
        String sql = "SELECT e.*, COALESCE(v.view_count, 0) as view_count " +
            "FROM evenement e " +
            "LEFT JOIN event_views v ON e.evenement_id = v.event_id " +
            "ORDER BY view_count DESC, e.evenement_id DESC";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Evenement evenement = new Evenement(
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
                evenement.setEvenement_id(rs.getInt("evenement_id"));
                evenements.add(evenement);
            }
        }
        return evenements;
    }
    public int getTotalEvenementsUtilisateur(int utilisateurId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM utilisateur_evenement ue " +
                "JOIN evenement e ON ue.evenement_id = e.evenement_id " +
                "WHERE ue.utilisateur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, utilisateurId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }

        return 0;
    }
}
