package services;

import entities.Fournisseur;
import utils.MyDataBase;

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
        String sql = "INSERT INTO `fournisseur` (`nom`, `type_service`, `contrat`, `evenement_id`, `num_tel`) " +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fournisseur.getNom());
        preparedStatement.setString(2, fournisseur.getTypeService());
        preparedStatement.setString(3, fournisseur.getContrat());
        preparedStatement.setInt(4, fournisseur.getEvenementId().getEvenement_id());
        preparedStatement.setInt(5, fournisseur.getNum_tel()); // Added num_tel

        preparedStatement.executeUpdate();
        System.out.println("✅ Fournisseur ajouté avec succès !");
    }

    /** ✅ MODIFIER UN FOURNISSEUR */
    @Override
    public void modifier(Fournisseur fournisseur) throws SQLException {
        String sql = "UPDATE `fournisseur` SET `nom` = ?, `type_service` = ?, `contrat` = ?, `evenement_id` = ?, `num_tel` = ? " +
                "WHERE `fournisseur_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fournisseur.getNom());
        preparedStatement.setString(2, fournisseur.getTypeService());
        preparedStatement.setString(3, fournisseur.getContrat());
        preparedStatement.setInt(4, fournisseur.getEvenementId().getEvenement_id());
        preparedStatement.setInt(5, fournisseur.getNum_tel()); // Added num_tel
        preparedStatement.setInt(6, fournisseur.getFournisseurId());

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
                    null,
                    resultSet.getInt("num_tel") // Added num_tel
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
                    null,
                    resultSet.getInt("num_tel") // Added num_tel
            );
        } else {
            System.out.println("⚠ Aucun fournisseur trouvé avec l'ID : " + id);
            return null;
        }
    }
    //////////////////////////////RECHERCHE/////////////////////////////////////////
    /**
     * Recherche des fournisseurs dont le nom, le type de service ou le contrat contient le mot-clé.
     */
    public List<Fournisseur> rechercherFournisseurs(String keyword) throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        String sql = "SELECT * FROM `fournisseur` WHERE `nom` LIKE ? OR `type_service` LIKE ? OR `contrat` LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String searchKeyword = "%" + keyword + "%";
        preparedStatement.setString(1, searchKeyword);
        preparedStatement.setString(2, searchKeyword);
        preparedStatement.setString(3, searchKeyword);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Fournisseur fournisseur = new Fournisseur(
                    resultSet.getInt("fournisseur_id"),
                    resultSet.getString("nom"),
                    resultSet.getString("type_service"),
                    resultSet.getString("contrat"),
                    null, // L'objet Evenement associé n'est pas chargé ici
                    resultSet.getInt("num_tel")
            );
            fournisseurs.add(fournisseur);
        }
        return fournisseurs;
    }

    /////////////////////////////////////////////////////////////////////////////////
}