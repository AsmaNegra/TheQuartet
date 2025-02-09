package entities;
import java.util.Date;

public class Tache {
    private int tacheId;
    private String nom;
    private String description;
    private String statut; // Peut être 'En attente', 'En cours', 'Terminée'
    private Date dateLimite;
    private Evenement evenement;
    private Fournisseur fournisseur;

    public Tache() {}

    public Tache(int tacheId, String nom, String description, String statut, Date dateLimite, Evenement evenement, Fournisseur fournisseur) {
        this.tacheId = tacheId;
        this.nom = nom;
        this.description = description;
        this.statut = statut;
        this.dateLimite = dateLimite;
        this.evenement = evenement;
        this.fournisseur = fournisseur;
    }
    public Tache( String nom, String description, String statut, Date dateLimite, Evenement evenement, Fournisseur fournisseur) {
        this.nom = nom;
        this.description = description;
        this.statut = statut;
        this.dateLimite = dateLimite;
        this.evenement = evenement;
        this.fournisseur = fournisseur;
    }

    public int getTacheId() {
        return tacheId;
    }
    public void setTacheId(int tacheId) {
        this.tacheId = tacheId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    public Date getDateLimite() {
        return dateLimite;
    }
    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
    public Evenement getEvenement() {
        return evenement;
    }
    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
    public Fournisseur getFournisseur() {
        return fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    @Override
    public String toString() {
        return "Tache{" +
                "tacheId=" + tacheId +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", statut='" + statut + '\'' +
                ", dateLimite=" + dateLimite +
                ", evenementId=" + (evenement != null ? evenement.getEvenementId() : "null") +
                ", fournisseurId=" + (fournisseur != null ? fournisseur.getFournisseurId() : "null") +
                '}';
    }

}
