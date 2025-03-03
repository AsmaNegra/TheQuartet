package entities;

import java.util.Date;

public class Tache {
    private int tacheId;
    private String nom;
    private String description;
    private String statut; // Peut être 'En attente', 'En cours', 'Terminée'
    private Date dateLimite;
    private String priorite;
    private Evenement evenement;
    private Fournisseur fournisseur;
    private String userAssocie;
    private float budget; // Ajout de l'attribut budget

    public Tache() {}

    public Tache(int tacheId, String nom, String description, String statut, Date dateLimite,
                 Evenement evenement, Fournisseur fournisseur, String priorite, String userAssocie, float budget) {
        this.tacheId = tacheId;
        this.nom = nom;
        this.description = description;
        this.statut = statut;
        this.dateLimite = dateLimite;
        this.evenement = evenement;
        this.fournisseur = fournisseur;
        this.priorite = priorite;
        this.userAssocie = userAssocie;
        this.budget = budget;
    }

    public Tache(String nom, String description, String statut, Date dateLimite,
                 Evenement evenement, Fournisseur fournisseur, String priorite, String userAssocie, float budget) {
        this.nom = nom;
        this.description = description;
        this.statut = statut;
        this.dateLimite = dateLimite;
        this.evenement = evenement;
        this.fournisseur = fournisseur;
        this.priorite = priorite;
        this.userAssocie = userAssocie;
        this.budget = budget;
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

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
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

    public String getUserAssocie() {
        return userAssocie;
    }

    public void setUserAssocie(String userAssocie) {
        this.userAssocie = userAssocie;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "tacheId=" + tacheId +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", statut='" + statut + '\'' +
                ", dateLimite=" + dateLimite +
                ", priorite='" + priorite + '\'' +
                ", evenement=" + evenement +
                ", fournisseur=" + fournisseur +
                ", userAssocie='" + userAssocie + '\'' +
                ", budget=" + budget +
                '}';
    }
}
