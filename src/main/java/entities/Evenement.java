package entities;

import java.util.Date;

public class Evenement {
    private int evenementId;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    private String categorie;
    private Float budget;
    private String imageEvent;

    // Constructeurs
    public Evenement() {}

    public Evenement(int evenementId, String nom, String description, Date dateDebut, Date dateFin, String lieu, String categorie, Float budget, String imageEvent) {
        this.evenementId = evenementId;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
        this.categorie = categorie;
        this.budget = budget;
        this.imageEvent = imageEvent;
    }

    // Getters et Setters
    public int getEvenementId() { return evenementId; }
    public void setEvenementId(int evenementId) { this.evenementId = evenementId; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }

    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }

    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public Float getBudget() { return budget; }
    public void setBudget(Float budget) { this.budget = budget; }

    public String getImageEvent() { return imageEvent; }
    public void setImageEvent(String imageEvent) { this.imageEvent = imageEvent; }

    @Override
    public String toString() {
        return "Evenement{" +
                "evenementId=" + evenementId +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", lieu='" + lieu + '\'' +
                ", categorie='" + categorie + '\'' +
                ", budget=" + budget +
                ", imageEvent='" + imageEvent + '\'' +
                '}';
    }
}

