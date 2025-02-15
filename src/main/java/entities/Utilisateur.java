package entities;
import java.util.List;

public class Utilisateur {
    private int utilisateur_id;
    private String nom;
    private String email;
    private String motDePasse;
    private String role;
    private String etat;
    private float note_organisateur;
    private String entreprise;
    private List<Evenement> evenements;


    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(int utilisateur_id, String nom, String email, String motDePasse, String role,String etat, float note_organisateur, String entreprise, List<Evenement> evenements) {
        this.utilisateur_id = utilisateur_id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.etat = etat;
        this.note_organisateur = note_organisateur;
        this.entreprise = entreprise;
        this.evenements = evenements;
    }
    public Utilisateur(int utilisateur_id, String nom, String email, String motDePasse, String role,String etat, float note_organisateur, String entreprise) {
        this.utilisateur_id = utilisateur_id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.etat = etat;
        this.note_organisateur = note_organisateur;
        this.entreprise = entreprise;
    }

    // Getters et Setters
    public int getUtilisateur_id() { return utilisateur_id; }
    public void setUtilisateur_id(int utilisateur_id) { this.utilisateur_id = utilisateur_id; }

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

    public float getNoteOrganisateur() { return note_organisateur; }
    public void setNoteOrganisateur(float noteOrganisateur) { this.note_organisateur = noteOrganisateur; }

    public String getEntreprise() { return entreprise; }
    public void setEntreprise(String entreprise) { this.entreprise = entreprise; }

    public List<Evenement> getEvenements() { return evenements; }
    public void setEvenements(List<Evenement> evenements) { this.evenements = evenements; }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "utilisateur_id=" + utilisateur_id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", etat=" + etat +
                ", note_organisateur=" + note_organisateur +
                ", entreprise='" + entreprise + '\'' +
                ", evenements=" + evenements +
                '}';
    }
}
