package services;

import entities.Tache;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceTache implements IService<Tache> {
    private Connection connection;

    public ServiceTache() {
        connection = MyDataBase.getInstance().getConnection();
    }


    /** ✅ AJOUTER UNE TÂCHE (sans tacheId) */
    @Override
    public void ajouter(Tache tache) throws SQLException {
        String sql = "INSERT INTO `tache` (`nom`, `description`, `statut`, `date_limite`, `evenement_id`, `fournisseur_id`, `priorite`, `user_associe`, `budget`)" +
                " VALUES (?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tache.getNom());
        preparedStatement.setString(2, tache.getDescription());
        preparedStatement.setString(3, tache.getStatut());
        preparedStatement.setDate(4, new java.sql.Date(tache.getDateLimite().getTime()));
        preparedStatement.setInt(5, tache.getEvenement().getEvenement_id());
        preparedStatement.setInt(6, tache.getFournisseur().getFournisseurId());
        preparedStatement.setString(7, tache.getPriorite());
        preparedStatement.setString(8, tache.getUserAssocie());
        preparedStatement.setFloat(9, tache.getBudget());

        preparedStatement.executeUpdate();
        System.out.println("✅ Tâche ajoutée avec succès !");
    }

    /** ✅ MODIFIER UNE TÂCHE */
    @Override
    public void modifier(Tache tache) throws SQLException {
        String sql = "UPDATE `tache` SET `nom` = ?, `description` = ?, `statut` = ?, `date_limite` = ?, `evenement_id` = ?, `fournisseur_id` = ?, `priorite` = ?, `user_associe` = ?, `budget` = ? " +
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
        preparedStatement.setDouble(9, tache.getBudget());
        preparedStatement.setInt(10, tache.getTacheId());

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("✅ Tâche modifiée avec succès !");
        } else {
            System.out.println("⚠ Tâche non trouvée !");
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
            ServiceEvenement serviceEvenement= new ServiceEvenement();
            ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
            Tache tache = new Tache(
                    resultSet.getInt("tache_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("description"),
                    resultSet.getString("statut"),
                    resultSet.getDate("date_limite"),
                    serviceEvenement.getEvenementById(resultSet.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(resultSet.getInt("fournisseur_id")),
                    resultSet.getString("priorite"),
                    resultSet.getString("user_associe"),
                    resultSet.getFloat("budget")
            );
            taches.add(tache);
        }

        return taches;
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
                    resultSet.getString("user_associe"),
                    resultSet.getFloat("budget")
            ));
        }

        return taches;
    }

    // Afficher les tâches "A faire" pour un événement donné
    public List<Tache> afficherTachesToDoByEvenement(int evenementId) throws SQLException {
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'A faire' AND `evenement_id` = ?";
        List<Tache> taches = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, evenementId);
        ResultSet resultSet = ps.executeQuery();

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
                    resultSet.getString("user_associe"),
                    resultSet.getFloat("budget")
            ));
        }

        return taches;
    }

    // Afficher les tâches "En Cours" pour un événement donné
    public List<Tache> afficherTachesEnCoursByEvenement(int evenementId) throws SQLException {
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'En Cours' AND `evenement_id` = ?";
        List<Tache> taches = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, evenementId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            taches.add(new Tache(
                    rs.getInt("tache_id"),
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getString("statut"),
                    rs.getDate("date_limite"),
                    serviceEvenement.getEvenementById(rs.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(rs.getInt("fournisseur_id")),
                    rs.getString("priorite"),
                    rs.getString("user_associe"),
                    rs.getFloat("budget")
            ));
        }

        return taches;
    }

    // Afficher les tâches "Terminée" pour un événement donné
    public List<Tache> afficherTachesDoneByEvenement(int evenementId) throws SQLException {
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'Terminée' AND `evenement_id` = ?";
        List<Tache> taches = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, evenementId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            taches.add(new Tache(
                    rs.getInt("tache_id"),
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getString("statut"),
                    rs.getDate("date_limite"),
                    serviceEvenement.getEvenementById(rs.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(rs.getInt("fournisseur_id")),
                    rs.getString("priorite"),
                    rs.getString("user_associe"),
                    rs.getFloat("budget")
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
     * Recherche des tâches "A faire" dont le nom ou la description contient le mot-clé
     * pour un événement donné.
     */
    public List<Tache> rechercherTachesToDo(String keyword, int evenementId) throws SQLException {
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'A faire' AND `evenement_id` = ? " +
                "AND ( `nom` LIKE ? OR `description` LIKE ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, evenementId);
        preparedStatement.setString(2, "%" + keyword + "%");
        preparedStatement.setString(3, "%" + keyword + "%");

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
                    resultSet.getString("user_associe"),
                    resultSet.getFloat("budget")
            );
            taches.add(tache);
        }
        return taches;
    }

    /**
     * Recherche des tâches "En Cours" dont le nom ou la description contient le mot-clé
     * pour un événement donné.
     */
    public List<Tache> rechercherTachesEnCours(String keyword, int evenementId) throws SQLException {
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'En Cours' AND `evenement_id` = ? " +
                "AND ( `nom` LIKE ? OR `description` LIKE ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, evenementId);
        preparedStatement.setString(2, "%" + keyword + "%");
        preparedStatement.setString(3, "%" + keyword + "%");

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
                    resultSet.getString("user_associe"),
                    resultSet.getFloat("budget")
            );
            taches.add(tache);
        }
        return taches;
    }

    /**
     * Recherche des tâches "Terminée" dont le nom ou la description contient le mot-clé
     * pour un événement donné.
     */
    public List<Tache> rechercherTachesDone(String keyword, int evenementId) throws SQLException {
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        List<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM `tache` WHERE `statut` = 'Terminée' AND `evenement_id` = ? " +
                "AND ( `nom` LIKE ? OR `description` LIKE ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, evenementId);
        preparedStatement.setString(2, "%" + keyword + "%");
        preparedStatement.setString(3, "%" + keyword + "%");

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
                    resultSet.getString("user_associe"),
                    resultSet.getFloat("budget")
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
            tache.setBudget(rs.getFloat("budget"));
            // Note : L'événement et le fournisseur ne sont pas initialisés ici.
            return tache;
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////////////////////////

//////////////////////////          TRI         ////////////////////////////////////////////////////
    /* Trie toutes les tâches par priorité personnalisée (Haute, Moyenne, Basse).*/
public List<Tache> trierTachesParPriorite(int evenementId) throws SQLException {
    List<Tache> taches = new ArrayList<>();
    ServiceEvenement serviceEvenement = new ServiceEvenement();
    ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
    String sql = "SELECT * FROM `tache` WHERE evenement_id = ? " +
            "ORDER BY CASE priorite " +
            "    WHEN 'Haute' THEN 1 " +
            "    WHEN 'Moyenne' THEN 2 " +
            "    WHEN 'Basse' THEN 3 " +
            "    ELSE 4 END ASC";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, evenementId);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
        Tache tache = new Tache(
                rs.getInt("tache_id"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getString("statut"),
                rs.getDate("date_limite"),
                serviceEvenement.getEvenementById(rs.getInt("evenement_id")),
                serviceFournisseur.rechercherParId(rs.getInt("fournisseur_id")),
                rs.getString("priorite"),
                rs.getString("user_associe"),
                rs.getFloat("budget")
        );
        taches.add(tache);
    }
    return taches;
}

    /* Trie toutes les tâches par date limite (du plus proche au plus lointain). */
    public List<Tache> trierTachesParDate(int evenementId) throws SQLException {
        List<Tache> taches = new ArrayList<>();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        String sql = "SELECT * FROM `tache` WHERE evenement_id = ? ORDER BY `date_limite` ASC";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, evenementId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Tache tache = new Tache(
                    rs.getInt("tache_id"),
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getString("statut"),
                    rs.getDate("date_limite"),
                    serviceEvenement.getEvenementById(rs.getInt("evenement_id")),
                    serviceFournisseur.rechercherParId(rs.getInt("fournisseur_id")),
                    rs.getString("priorite"),
                    rs.getString("user_associe"),
                    rs.getFloat("budget")
            );
            taches.add(tache);
        }
        return taches;
    }
///////////////////////////////////////////////////////////////////////////////////////////
    /** ✅ Récupérer les KPI des fournisseurs sur les tâches */
    public Map<String, Map<String, Object>> getKpiFournisseurs() throws SQLException {
        String sql = "SELECT f.nom AS fournisseur, " +
                "COUNT(t.tache_id) AS total_taches, " +
                "SUM(CASE WHEN t.statut = 'Terminée' THEN 1 ELSE 0 END) AS taches_terminees, " +
                "ROUND((SUM(CASE WHEN t.statut = 'Terminée' THEN 1 ELSE 0 END) / COUNT(t.tache_id)) * 100, 2) AS taux_completion " +
                "FROM tache t " +
                "JOIN fournisseur f ON t.fournisseur_id = f.fournisseur_id " +
                "GROUP BY f.nom " +
                "ORDER BY taux_completion DESC";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        Map<String, Map<String, Object>> kpiMap = new HashMap<>();

        while (resultSet.next()) {
            Map<String, Object> details = new HashMap<>();
            details.put("total_taches", resultSet.getInt("total_taches"));
            details.put("taches_terminees", resultSet.getInt("taches_terminees"));
            details.put("taux_completion", resultSet.getDouble("taux_completion"));

            kpiMap.put(resultSet.getString("fournisseur"), details);
        }

        return kpiMap;
    }
    /** 📌 Analyse la personnalité d'un utilisateur en fonction des tâches */
    public String analyserPersonnaliteUtilisateur(int utilisateurId) throws SQLException {
        String sql = "SELECT " +
                "SUM(CASE WHEN t.statut = 'Terminée' THEN 1 ELSE 0 END) AS taches_terminees, " +
                "SUM(CASE WHEN t.statut = 'En cours' OR t.statut = 'A faire' THEN 1 ELSE 0 END) AS taches_non_terminees " +
                "FROM tache t " +
                "JOIN utilisateur_evenement ue ON t.evenement_id = ue.evenement_id " +
                "WHERE ue.utilisateur_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, utilisateurId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int tachesTerminees = resultSet.getInt("taches_terminees");
            int tachesNonTerminees = resultSet.getInt("taches_non_terminees");
            int totalTaches = tachesTerminees + tachesNonTerminees;

            if (totalTaches == 0) {
                return "❔ Impossible de déterminer la personnalité (aucune tâche trouvée)";
            }

            double tauxCompletion = (double) tachesTerminees / totalTaches * 100;

            if (tauxCompletion >= 90) {
                return "🏆 Champion ultime ! Toujours au top, un modèle d'organisation.";
            } else if (tauxCompletion >= 75) {
                return "🔥 Travailleur acharné ! Peu de choses lui échappent.";
            } else if (tauxCompletion >= 50) {
                return "⚖ Équilibré, mais peut mieux faire. Parfois efficace, parfois distrait.";
            } else if (tauxCompletion >= 25) {
                return "⏳ Procrastinateur... il repousse souvent ses tâches.";
            } else {
                return "🐢 Fainéant légendaire... toujours en retard et rarement productif.";
            }
        }

        return "❌ Utilisateur non trouvé.";
    }
//////////KPIS///////////////////////////////
public int getTachesEnRetardUtilisateur(int utilisateurId) throws SQLException {
    String sql = "SELECT COUNT(*) AS total FROM tache " +
            "WHERE statut != 'Terminée' AND date_limite < NOW() " +
            "AND evenement_id IN (SELECT evenement_id FROM utilisateur_evenement WHERE utilisateur_id = ?)";

    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, utilisateurId);
    ResultSet rs = ps.executeQuery();

    return rs.next() ? rs.getInt("total") : 0;
}

    public int getTotalTachesUtilisateur(int utilisateurId) throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM tache " +
                "WHERE evenement_id IN (SELECT evenement_id FROM utilisateur_evenement WHERE utilisateur_id = ?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, utilisateurId);
        ResultSet rs = ps.executeQuery();

        return rs.next() ? rs.getInt("total") : 0;
    }

    public double calculerPourcentageTachesTerminees(int evenementId) throws SQLException {
        String sql = "SELECT " +
                "SUM(CASE WHEN statut = 'Terminée' THEN 1 ELSE 0 END) AS taches_terminees, " +
                "COUNT(*) AS total_taches " +
                "FROM tache WHERE evenement_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, evenementId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int tachesTerminees = resultSet.getInt("taches_terminees");
            int totalTaches = resultSet.getInt("total_taches");

            if (totalTaches == 0) {
                return 0.0; // Événement sans tâches, retour 0%
            }

            return (double) tachesTerminees / totalTaches * 100;
        }

        return 0.0;
    }
    /** ✅ CALCULER LE POURCENTAGE DU BUDGET UTILISÉ PAR RAPPORT À L'ÉVÉNEMENT */
    public Map<String, Double> calculerBudgetEvenement(int evenementId) throws SQLException {
        String sql = "SELECT e.budget AS budget_total, COALESCE(SUM(t.budget), 0) AS budget_utilise " +
                "FROM evenement e " +
                "LEFT JOIN tache t ON e.evenement_id = t.evenement_id " +
                "WHERE e.evenement_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, evenementId);
        ResultSet resultSet = preparedStatement.executeQuery();

        Map<String, Double> budgetDetails = new HashMap<>();

        if (resultSet.next()) {
            double budgetTotal = resultSet.getDouble("budget_total");
            double budgetUtilise = resultSet.getDouble("budget_utilise");

            double pourcentageUtilise = (budgetTotal > 0) ? (budgetUtilise / budgetTotal) * 100 : 0;
            double budgetRestant = budgetTotal - budgetUtilise;

            budgetDetails.put("budget_total", budgetTotal);
            budgetDetails.put("budget_utilise", budgetUtilise);
            budgetDetails.put("pourcentage_utilise", pourcentageUtilise);
            budgetDetails.put("budget_restant", budgetRestant);
        }

        return budgetDetails;
    }

    ///////////////////////////////////////////
}
