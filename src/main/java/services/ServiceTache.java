package services;

import entities.Tache;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTache implements IService<Tache> {
    private Connection connection;

    public ServiceTache() {
        connection = MyDataBase.getInstance().getConnection();
    }

    /** ✅ AJOUTER UNE TÂCHE */
    @Override
    public void ajouter(Tache tache) throws SQLException {
        String sql = "INSERT INTO `tache` (`tache_id`, `nom`, `description`, `statut`, `date_limite`, `evenement_id`, `fournisseur_id`)" +
                " VALUES (?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, tache.getTacheId());
        preparedStatement.setString(2, tache.getNom());
        preparedStatement.setString(3, tache.getDescription());
        preparedStatement.setString(4, tache.getStatut());
        preparedStatement.setDate(5, new java.sql.Date(tache.getDateLimite().getTime()));
        preparedStatement.setInt(6, tache.getEvenement().getEvenement_id());
        preparedStatement.setInt(7, tache.getFournisseur().getFournisseurId());

        preparedStatement.executeUpdate();
        System.out.println("✅ Tâche ajoutée avec succès !");
    }

    /** ✅ MODIFIER UNE TÂCHE */
    @Override
    public void modifier(Tache tache) throws SQLException {
        String sql = "UPDATE `tache` SET `nom` = ?, `description` = ?, `statut` = ?, `date_limite` = ?, `evenement_id` = ?, `fournisseur_id` = ? " +
                "WHERE `tache_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tache.getNom());
        preparedStatement.setString(2, tache.getDescription());
        preparedStatement.setString(3, tache.getStatut());
        preparedStatement.setDate(4, new java.sql.Date(tache.getDateLimite().getTime()));
        preparedStatement.setInt(5, tache.getEvenement().getEvenement_id());
        preparedStatement.setInt(6, tache.getFournisseur().getFournisseurId());
        preparedStatement.setInt(7, tache.getTacheId());

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("✅ Tâche modifiée avec succès !");
        } else {
            System.out.println("⚠ Tâche non trouvée !");
        }
    }

    /** ✅ SUPPRIMER UNE TÂCHE */
    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `tache` WHERE `tache_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("✅ Tâche supprimée avec succès !");
        } else {
            System.out.println("⚠ Aucune tâche trouvée avec cet ID !");
        }
    }

    /** ✅ AFFICHER TOUTES LES TÂCHES */
    @Override
    public List<Tache> afficher() throws SQLException {
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM `tache`";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Tache tache = new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    null,
                    null
            );

            taches.add(tache);
        }

        return taches;
    }
    /** ✅ AFFICHER LES TÂCHES PAR ÉVÉNEMENT */
    public List<Tache> afficherParEvenement(int evenementId) throws SQLException {
        String sql = "SELECT * FROM `tache` WHERE `evenement_id` = ?";
        List<Tache> taches = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, evenementId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            taches.add(new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    null, // Charger l'événement séparément si nécessaire
                    null  // Charger le fournisseur séparément si nécessaire
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "EN COURS" */
    public List<Tache> afficherTachesEnCours() throws SQLException {
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'En cours'";
        List<Tache> taches = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            taches.add(new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    null,
                    null
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "DONE" */
    public List<Tache> afficherTachesDone() throws SQLException {
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'Done'";
        List<Tache> taches = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            taches.add(new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    null,
                    null
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "TO DO" */
    public List<Tache> afficherTachesToDo() throws SQLException {
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'To Do'";
        List<Tache> taches = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            taches.add(new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    null,
                    null
            ));
        }

        return taches;
    }


}
