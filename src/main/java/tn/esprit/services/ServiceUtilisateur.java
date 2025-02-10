package tn.esprit.services;

import tn.esprit.entities.Utilisateur;
import tn.esprit.utils.MyDataBase;
import tn.esprit.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceUtilisateur implements IService<Utilisateur> {
    private final Connection connection;

    public ServiceUtilisateur() {
        connection = MyDataBase.getInstance().getConnection();
    }


    @Override
    public void ajouter_Utili(Utilisateur utilisateur) throws SQLException {
        String sql = "INSERT INTO `utilisateur`(`nom`, `email`, `mot_de_passe`, `role`, `etat`, `note_organisateur`, `entreprise`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, utilisateur.getNom());
        ps.setString(2, utilisateur.getEmail());
        ps.setString(3, utilisateur.getMotDePasse());
        ps.setString(4, utilisateur.getRole().name());
        ps.setString(5, utilisateur.getEtat());
        ps.setInt(6, utilisateur.getNote_organisateur());
        ps.setString(7, utilisateur.getEntreprise());

        ps.executeUpdate();

        // Récupérer l'ID auto-incrémenté
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            utilisateur.setUtilisateurId(generatedKeys.getInt(1)); // Affecter l'ID généré à l'utilisateur
        }
    }

    @Override
    public void modifier_Utili(Utilisateur utilisateur) throws SQLException {
        String sql = "UPDATE `utilisateur` SET `nom`=?, `email`=?, `mot_de_passe`=?, `role`=?, `etat`=?, `note_organisateur`=?, `entreprise`=? WHERE `utilisateur_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, utilisateur.getNom());
        ps.setString(2, utilisateur.getEmail());
        ps.setString(3, utilisateur.getMotDePasse());
        ps.setString(4, utilisateur.getRole().name());
        ps.setString(5, utilisateur.getEtat());
        ps.setInt(6, utilisateur.getNote_organisateur());
        ps.setString(7, utilisateur.getEntreprise());
        ps.setInt(8, utilisateur.getUtilisateurId());
        ps.executeUpdate();
    }

    public void supprimer_Utili(int id) throws SQLException {
        String sql = "DELETE FROM `utilisateur` WHERE `utilisateur_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }


    public List<Utilisateur> afficher_Utili() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM `utilisateur`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            // Conversion de la chaîne en énumération Role
            String roleString = rs.getString("role");
            Role role = Role.valueOf(roleString);

            utilisateurs.add(new Utilisateur(
                    rs.getInt("utilisateur_id"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getString("mot_de_passe"),
                    role,  // Assignation du rôle converti
                    rs.getString("etat"),
                    rs.getInt("note_organisateur"),
                    rs.getString("entreprise")
            ));
        }
        return utilisateurs;
    }


}
