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
        String sql = "INSERT INTO `fournisseur` (`fournisseur_id`, `nom`, `type_service`, `contrat`, `evenement_id`) " +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, fournisseur.getFournisseurId());
        preparedStatement.setString(2, fournisseur.getNom());
        preparedStatement.setString(3, fournisseur.getTypeService());
        preparedStatement.setString(4, fournisseur.getContrat());
        preparedStatement.setInt(5, fournisseur.getEvenementId().getEvenement_id());

        preparedStatement.executeUpdate();
        System.out.println("✅ Fournisseur ajouté avec succès !");
    }

    /** ✅ MODIFIER UN FOURNISSEUR */
    @Override
    public void modifier(Fournisseur fournisseur) throws SQLException {
        String sql = "UPDATE `fournisseur` SET `nom` = ?, `type_service` = ?, `contrat` = ?, `evenement_id` = ? " +
                "WHERE `fournisseur_id` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fournisseur.getNom());
        preparedStatement.setString(2, fournisseur.getTypeService());
        preparedStatement.setString(3, fournisseur.getContrat());
        preparedStatement.setInt(4, fournisseur.getEvenementId().getEvenement_id());
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
                    null
            );
            fournisseurs.add(fournisseur);
        }
        return fournisseurs;
    }
}
