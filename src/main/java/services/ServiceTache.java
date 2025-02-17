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

    /** ✅ AJOUTER UNE TÂCHE (sans tacheId) */
    @Override
    public void ajouter(Tache tache) throws SQLException {
        String sql = "INSERT INTO `tache` (`nom`, `description`, `statut`, `date_limite`, `evenement_id`, `fournisseur_id`, `priorite`, `user_associe`)" +
                " VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tache.getNom());
        preparedStatement.setString(2, tache.getDescription());
        preparedStatement.setString(3, tache.getStatut());
        preparedStatement.setDate(4, new java.sql.Date(tache.getDateLimite().getTime()));
        preparedStatement.setInt(5, tache.getEvenement().getEvenement_id());
        preparedStatement.setInt(6, tache.getFournisseur().getFournisseurId());
        preparedStatement.setString(7, tache.getPriorite());
        preparedStatement.setString(8, tache.getUserAssocie());

        preparedStatement.executeUpdate();
        System.out.println("✅ Tâche ajoutée avec succès !");
    }

    /** ✅ MODIFIER UNE TÂCHE */
    @Override
    public void modifier(Tache tache) throws SQLException {
        String sql = "UPDATE `tache` SET `nom` = ?, `description` = ?, `statut` = ?, `date_limite` = ?, `evenement_id` = ?, `fournisseur_id` = ?, `priorite` = ?, `user_associe` = ? " +
                "WHERE `tache_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tache.getNom());
        preparedStatement.setString(2, tache.getDescription());
        preparedStatement.setString(3, tache.getStatut());
        preparedStatement.setDate(4, new java.sql.Date(tache.getDateLimite().getTime()));
        preparedStatement.setInt(5, tache.getEvenement().getEvenement_id());
        preparedStatement.setInt(6, tache.getFournisseur().getFournisseurId());
        preparedStatement.setString(7, tache.getPriorite());
        preparedStatement.setString(8, tache.getUserAssocie());
        preparedStatement.setInt(9, tache.getTacheId());

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
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    null,
                    null,
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
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
                    null,
                    null,
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "EN COURS" */
    public List<Tache> afficherTachesEnCours() throws SQLException {
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'En Cours'";
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
                    null,
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "DONE" */
    public List<Tache> afficherTachesDone() throws SQLException {
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'Terminée'";
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
                    null,
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "TO DO" */
    public List<Tache> afficherTachesToDo() throws SQLException {
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'A faire'";
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
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            ));
        }

        return taches;
    }
}
