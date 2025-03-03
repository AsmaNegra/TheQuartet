
        package services;

import entities.Role;
import entities.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;
import services.IService;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceUtilisateur implements IService<Utilisateur> {
    private final Connection connection;

    public ServiceUtilisateur() {
        connection = MyDataBase.getInstance().getConnection();
    }


    @Override
    public void ajouter(Utilisateur utilisateur) throws SQLException {
        String sql = "INSERT INTO `utilisateur`(`nom`, `email`, `mot_de_passe`, `role`, `etat`, `note_organisateur`, `entreprise`, `photo_url`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, utilisateur.getNom());
        ps.setString(2, utilisateur.getEmail());
        ps.setString(3, utilisateur.getMotDePasse());
        ps.setString(4, utilisateur.getRole().name());
        ps.setString(5, utilisateur.getEtat());
        ps.setInt(6, utilisateur.getNote_organisateur());
        ps.setString(7, utilisateur.getEntreprise());
        ps.setString(8, utilisateur.getPhotoUrl());

        ps.executeUpdate();

        // Récupérer l'ID auto-incrémenté
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            utilisateur.setUtilisateurId(generatedKeys.getInt(1)); // Affecter l'ID généré à l'utilisateur
        }
    }

    @Override
    public void modifier(Utilisateur utilisateur) throws SQLException {
        String sql = "UPDATE `utilisateur` SET `nom`=?, `email`=?, `mot_de_passe`=?, `role`=?, `photo_url`=? WHERE `utilisateur_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, utilisateur.getNom());
        ps.setString(2, utilisateur.getEmail());
        ps.setString(3, utilisateur.getMotDePasse());
        ps.setString(4, utilisateur.getRole().name());
        ps.setString(5, utilisateur.getPhotoUrl());
        ps.setInt(6, utilisateur.getUtilisateurId());
        ps.executeUpdate();
    }

    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `utilisateur` WHERE `utilisateur_id`=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }


    public List<Utilisateur> afficher() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM `utilisateur`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            // Conversion de la chaîne en énumération Role
            String roleString = rs.getString("role");
            System.out.println(roleString);
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

    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM utilisateur WHERE email = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public boolean updatePassword(String email, String newPassword) throws SQLException {
        String query = "UPDATE utilisateur SET mot_de_passe = ? WHERE email = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, newPassword);
            pst.setString(2, email);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public Utilisateur inscrireAvecGoogle(String nom, String email, String photoUrl) throws SQLException {
        // Vérifier si l'utilisateur existe déjà
        if (emailExists(email)) {
            // Si l'utilisateur existe, le récupérer
            Utilisateur utilisateur = recupererUtilisateurParEmail(email);

            // Ne mettez PAS à jour la session automatiquement
            // L'utilisateur doit toujours entrer son mot de passe

            return utilisateur;
        }

        // Pour les nouveaux utilisateurs seulement:
        // Option 1: Générer un mot de passe aléatoire et demander à l'utilisateur de le changer
        String motDePasseTemporaire = generateRandomPassword();
        String motDePasseHashe = BCrypt.hashpw(motDePasseTemporaire, BCrypt.gensalt());

        // Créer un nouvel utilisateur avec le rôle PARTICIPANT par défaut
        Utilisateur nouvelUtilisateur = new Utilisateur();
        nouvelUtilisateur.setNom(nom);
        nouvelUtilisateur.setEmail(email);
        nouvelUtilisateur.setMotDePasse(motDePasseHashe);
        nouvelUtilisateur.setRole(Role.PARTICIPANT);
        nouvelUtilisateur.setEtat("actif");
        nouvelUtilisateur.setNote_organisateur(0);
        nouvelUtilisateur.setEntreprise("");

        // Si l'URL de la photo est fournie, l'utiliser, sinon utiliser une photo par défaut
        if (photoUrl != null && !photoUrl.isEmpty()) {
            nouvelUtilisateur.setPhotoUrl(photoUrl);
        } else {
            nouvelUtilisateur.setPhotoUrl("default_profile.png");
        }

        // Ajouter l'utilisateur à la base de données
        ajouter(nouvelUtilisateur);

        return nouvelUtilisateur;
    }

    private String generateRandomPassword() {
        // Générer un mot de passe aléatoire
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    public Utilisateur recupererUtilisateurParEmail(String email) throws SQLException {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Utilisateur(
                    rs.getInt("utilisateur_id"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getString("mot_de_passe"),
                    Role.valueOf(rs.getString("role")),
                    rs.getString("etat"),
                    rs.getInt("note_organisateur"),
                    rs.getString("entreprise")
                    //rs.getString("photo_url")
            );
        }
        return null;
    }


    public Utilisateur verifierIdentifiants(String email, String motDePasse) throws SQLException {
        // Récupérer l'utilisateur par email uniquement (pas de vérification de mot de passe à ce stade)
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Utilisateur utilisateur = new Utilisateur(
                    rs.getInt("utilisateur_id"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getString("mot_de_passe"),
                    Role.valueOf(rs.getString("role"))
            );

            // Vérifier le mot de passe avec BCrypt
            if (verifyPassword(motDePasse, utilisateur.getMotDePasse())) {
                return utilisateur; // Authentification réussie
            }
        }
        return null; // Utilisateur non trouvé ou mot de passe incorrect
    }

    /**
     * Méthode pour vérifier un mot de passe avec BCrypt
     * @param plainPassword Le mot de passe saisi par l'utilisateur
     * @param hashedPassword Le hachage stocké dans la base de données
     * @return true si le mot de passe correspond, false sinon
     */
    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        System.out.println("hello");
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}