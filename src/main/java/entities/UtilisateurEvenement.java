package entities;

public class UtilisateurEvenement {
    private Utilisateur utilisateur;
    private Evenement evenement;

    // Constructeurs
    public UtilisateurEvenement() {}

    public UtilisateurEvenement(Utilisateur utilisateur, Evenement evenement) {
        this.utilisateur = utilisateur;
        this.evenement = evenement;
    }

    // Getters et Setters
    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Evenement getEvenement() { return evenement; }
    public void setEvenement(Evenement evenement) { this.evenement = evenement; }

    @Override
    public String toString() {
        return "UtilisateurEvenement{" +
                "utilisateur=" + utilisateur +
                ", evenement=" + evenement +
                '}';
    }
}
