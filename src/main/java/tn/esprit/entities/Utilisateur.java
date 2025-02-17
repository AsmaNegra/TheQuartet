package tn.esprit.entities;

public class Utilisateur {
    private int utilisateurId;
    private String nom;
    private String email;
    private String motDePasse;
    private Role role; // Peut être 'Admin', 'Participant', 'Organisateur'
    private String etat;
    private int note_organisateur;
    private String entreprise;
    // private List<Evenement> evenements;



    public Utilisateur(int utilisateurId, String nom,String email,String motDePasse,Role role) {
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;


    }
    public Utilisateur(int utilisateurId, String nom,String email,String motDePasse,Role role,String etat, int note_organisateur, String entreprise) {
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.etat = etat;
        this.note_organisateur = note_organisateur;
        this.entreprise = entreprise;

    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNote_organisateur() {
        return note_organisateur;
    }

    public void setNote_organisateur(int note_organisateur) {
        this.note_organisateur = note_organisateur;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    //public List<Evenement> getEvenements() {
    //   return evenements;
    // }

    // public void setEvenements(List<Evenement> evenements) {
    //     this.evenements = evenements;
    //  }

}
