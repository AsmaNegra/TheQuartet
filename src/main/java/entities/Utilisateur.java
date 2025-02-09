package entities;

import java.util.List;

public class Utilisateur {
    private int utilisateurId;
    private String nom;
    private String email;
    private String motDePasse;
    private String role;
    private String etat;
    private float noteOrganisateur;
    private String entreprise;
    private List<Evenement> evenements;


    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(int utilisateurId, String nom, String email, String motDePasse, String role,String etat, float noteOrganisateur, String entreprise, List<Evenement> evenements) {
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.etat = etat;
        this.noteOrganisateur = noteOrganisateur;
        this.entreprise = entreprise;
        this.evenements = evenements;
    }
    public Utilisateur(int utilisateurId, String nom, String email, String motDePasse, String role,String etat, float noteOrganisateur, String entreprise) {
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.etat = etat;
        this.noteOrganisateur = noteOrganisateur;
        this.entreprise = entreprise;
    }

    // Getters et Setters
    public int getUtilisateurId() { return utilisateurId; }
    public void setUtilisateurId(int utilisateurId) { this.utilisateurId = utilisateurId; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }

    public float getNoteOrganisateur() { return noteOrganisateur; }
    public void setNoteOrganisateur(float noteOrganisateur) { this.noteOrganisateur = noteOrganisateur; }

    public String getEntreprise() { return entreprise; }
    public void setEntreprise(String entreprise) { this.entreprise = entreprise; }

    public List<Evenement> getEvenements() { return evenements; }
    public void setEvenements(List<Evenement> evenements) { this.evenements = evenements; }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "utilisateurId=" + utilisateurId +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", etat=" + etat +
                ", noteOrganisateur=" + noteOrganisateur +
                ", entreprise='" + entreprise + '\'' +
                ", evenements=" + evenements +
                '}';
    }
}
