package services;

import entities.*;
import utils.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceFournisseur implements IService<Fournisseur> {
    private Connection connection;

    public ServiceFournisseur() {
        connection = MyDataBase.getInstance().getConnection();
    }

    /** ✅ AJOUTER UN FOURNISSEUR */
    @Override
    public void ajouter(Fournisseur fournisseur) throws SQLException {
        String sql = "INSERT INTO `fournisseur` (`nom`, `type_service`, `contrat`, `num_tel`) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fournisseur.getNom());
        preparedStatement.setString(2, fournisseur.getTypeService());
        preparedStatement.setString(3, fournisseur.getContrat());
        preparedStatement.setString(4, fournisseur.getNum_tel()); // Added num_tel

        preparedStatement.executeUpdate();
        System.out.println("✅ Fournisseur ajouté avec succès !");
    }

    /** ✅ MODIFIER UN FOURNISSEUR */
    @Override
    public void modifier(Fournisseur fournisseur) throws SQLException {
        String sql = "UPDATE `fournisseur` SET `nom` = ?, `type_service` = ?, `contrat` = ?, `num_tel` = ? " +
                "WHERE `fournisseur_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fournisseur.getNom());
        preparedStatement.setString(2, fournisseur.getTypeService());
        preparedStatement.setString(3, fournisseur.getContrat());
        preparedStatement.setString(4, fournisseur.getNum_tel()); // Added num_tel
        preparedStatement.setInt(5, fournisseur.getFournisseurId());

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("✅ Fournisseur modifié avec succès !");
        } else {
            System.out.println("⚠ Aucun fournisseur trouvé !");
        }
    }

    /** ✅ SUPPRIMER UN FOURNISSEUR */
    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `fournisseur` WHERE `fournisseur_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("✅ Fournisseur supprimé avec succès !");
        } else {
            System.out.println("⚠ Aucun fournisseur trouvé avec cet ID !");
        }
    }

    /** ✅ AFFICHER TOUS LES FOURNISSEURS */
    @Override
    public List<Fournisseur> afficher() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        String sql = "SELECT * FROM `fournisseur`";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Fournisseur fournisseur = new Fournisseur(
                    resultSet.getInt("fournisseur_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("type_service"),
                    resultSet.getString("contrat"),
                    resultSet.getString("num_tel") // Added num_tel
            );

            fournisseurs.add(fournisseur);
        }

        return fournisseurs;
    }

    /** ✅ RECHERCHER UN FOURNISSEUR PAR NOM */
    public int rechercherIdParNom(String nom) throws SQLException {
        String sql = "SELECT `fournisseur_id` FROM `fournisseur` WHERE `nom` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nom);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("fournisseur_id"); // Return the fournisseur ID
        } else {
            System.out.println("⚠ Aucun fournisseur trouvé avec le nom : " + nom);
            return -1; // Return -1 if not found
        }
    }

    /** ✅ RECHERCHER UN FOURNISSEUR PAR ID */
    public Fournisseur rechercherParId(int id) throws SQLException {
        String sql = "SELECT * FROM `fournisseur` WHERE `fournisseur_id` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Fournisseur(
                    resultSet.getInt("fournisseur_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("type_service"),
                    resultSet.getString("contrat"),
                    resultSet.getString("num_tel") // Added num_tel
            );
        } else {
            System.out.println("⚠ Aucun fournisseur trouve avec l'ID : " + id);
            return null;
        }
    }

    //////////////////////////////RECHERCHE/////////////////////////////////////////
    /**
     * Recherche des fournisseurs associés à un événement donné et filtrés par un mot-clé.
     */
    public List<Fournisseur> rechercherFournisseursParEventId(int eventId, String keyword) throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();

        String sql = "SELECT f.* FROM fournisseur f " +
                "JOIN fournisseur_evenement fe ON f.fournisseur_id = fe.fournisseur_id " +
                "WHERE fe.evenement_id = ? " +
                "AND (f.nom LIKE ? OR f.type_service LIKE ? OR f.contrat LIKE ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, eventId);
        String searchKeyword = "%" + keyword + "%";
        preparedStatement.setString(2, searchKeyword);
        preparedStatement.setString(3, searchKeyword);
        preparedStatement.setString(4, searchKeyword);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Fournisseur fournisseur = new Fournisseur(
                    resultSet.getInt("fournisseur_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("type_service"),
                    resultSet.getString("contrat"),
                    resultSet.getString("num_tel")
            );
            fournisseurs.add(fournisseur);
        }

        return fournisseurs;
    }

    /////////////////////////////////////////////////////////////////////////////////

    /** ✅ AFFICHER LES FOURNISSEURS D'UN ÉVÉNEMENT SPÉCIFIQUE */
    public List<Fournisseur> afficherFournisseursParEventId(int eventId) throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();

        String sql = "SELECT f.* FROM fournisseur f JOIN fournisseur_evenement fe ON f.fournisseur_id = fe.fournisseur_id WHERE fe.evenement_id =  ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, eventId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Fournisseur fournisseur = new Fournisseur(
                    resultSet.getInt("fournisseur_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("type_service"),
                    resultSet.getString("contrat"),
                    resultSet.getString("num_tel")
            );

            fournisseurs.add(fournisseur);
        }

        return fournisseurs;
    }


}