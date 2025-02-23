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
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
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
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "EN COURS" */
    public List<Tache> afficherTachesEnCours() throws SQLException {
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
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
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            ));
        }

        return taches;
    }

    /** ✅ AFFICHER LES TÂCHES "DONE" */
    public List<Tache> afficherTachesDone() throws SQLException {
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
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
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
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

    /** ✅ MODIFIER L'ÉTAT D'UNE TÂCHE */
    public void modifierEtatTache(int tacheId, String nouvelEtat) throws SQLException {
        String sql = "UPDATE `tache` SET `statut` = ? WHERE `tache_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nouvelEtat);
        preparedStatement.setInt(2, tacheId);

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("✅ État de la tâche modifié avec succès !");
        } else {
            System.out.println("⚠ Aucune tâche trouvée avec cet ID !");
        }
    }
    ////////////////////////////////////////RECHERCHE//////////////////////////////////

    /**
     * Recherche des tâches "A faire" dont le nom ou la description contient le mot-clé.
     */
    public List<Tache> rechercherTachesToDo(String keyword) throws SQLException {
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'A faire' AND ( `nom` LIKE ? OR `description` LIKE ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + keyword + "%");
        preparedStatement.setString(2, "%" + keyword + "%");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Tache tache = new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            );
            taches.add(tache);
        }
        return taches;
    }

    /**
     * Recherche des tâches "En Cours" dont le nom ou la description contient le mot-clé.
     */
    public List<Tache> rechercherTachesEnCours(String keyword) throws SQLException {
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'En Cours' AND ( `nom` LIKE ? OR `description` LIKE ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + keyword + "%");
        preparedStatement.setString(2, "%" + keyword + "%");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Tache tache = new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            );
            taches.add(tache);
        }
        return taches;
    }

    /**
     * Recherche des tâches "Terminée" dont le nom ou la description contient le mot-clé.
     */
    public List<Tache> rechercherTachesDone(String keyword) throws SQLException {
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'Terminée' AND ( `nom` LIKE ? OR `description` LIKE ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + keyword + "%");
        preparedStatement.setString(2, "%" + keyword + "%");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Tache tache = new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            );
            taches.add(tache);
        }
        return taches;
    }

    /**
     * Recherche une tâche par son nom.
     *
     * @param nom Le nom de la tâche à rechercher.
     * @return La tâche correspondante si elle existe, sinon null.
     * @throws SQLException en cas d'erreur d'accès à la base de données.
     */
    public Tache chercherTacheParNom(String nom) throws SQLException {
        String sql = "SELECT * FROM tache WHERE nom = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nom);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // Vous pouvez adapter la création de l'objet Tache selon vos besoins.
            Tache tache = new Tache();
            tache.setTacheId(rs.getInt("tache_id"));
            tache.setNom(rs.getString("nom"));
            tache.setDescription(rs.getString("description"));
            tache.setStatut(rs.getString("statut"));
            tache.setDateLimite(rs.getDate("date_limite"));
            tache.setPriorite(rs.getString("priorite"));
            tache.setUserAssocie(rs.getString("user_associe"));
            // Note : L'événement et le fournisseur ne sont pas initialisés ici.
            return tache;
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////////////////////////

//////////////////////////          TRI         ////////////////////////////////////////////////////
    /* Trie toutes les tâches par priorité personnalisée (Haute, Moyenne, Basse).*/
    public List<Tache> trierTachesParPriorite() throws SQLException {
        List<Tache> taches = new ArrayList<>();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        // On utilise CASE pour définir l'ordre de tri en fonction des valeurs textuelles.
        String sql = "SELECT * FROM `tache` " +
                "ORDER BY CASE priorite " +
                "    WHEN 'Haute' THEN 1 " +
                "    WHEN 'Moyenne' THEN 2 " +
                "    WHEN 'Basse' THEN 3 " +
                "    ELSE 4 END ASC";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Tache tache = new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            );
            taches.add(tache);
        }

        return taches;
    }

    /* Trie toutes les tâches par date limite (du plus proche au plus lointain). */
    public List<Tache> trierTachesParDate() throws SQLException {
        List<Tache> taches = new ArrayList<>();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        String sql = "SELECT * FROM `tache` ORDER BY `date_limite` ASC";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Tache tache = new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe")
            );
            taches.add(tache);
        }

        return taches;
    }
///////////////////////////////////////////////////////////////////////////////////////////

}
