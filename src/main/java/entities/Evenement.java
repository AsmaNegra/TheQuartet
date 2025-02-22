package entities;
import java.util.List;
import java.sql.Timestamp;


public class Evenement {
    private int evenement_id;
    private String nom;
    private String description;
    private Timestamp  date_debut;
    private Timestamp  date_fin;
    private String lieu;
    private String categorie;
    private float budget;
    private String image_event;
    private int nb_places;

    private List<Ticket> tickets;
    private List<Tache> taches;
    private List<Fournisseur> fournisseurs;
    private List<Feedback> feedbacks;
    private List<Utilisateur> listMembres;

    public Evenement() {}

    public Evenement(int evenement_id, String nom, String description, Timestamp date_debut, Timestamp date_fin, String lieu, String categorie, float budget, String image_event, int nb_places) {
        this.evenement_id = evenement_id;
        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin =  date_fin;
        this.lieu = lieu;
        this.categorie = categorie;
        this.budget = budget;
        this.image_event = image_event;
        this.nb_places = nb_places;
    }

    public Evenement(String nom, String description, Timestamp date_debut, Timestamp date_fin, String lieu, String categorie, float budget, String image_event, int nb_places) {
        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.lieu = lieu;
        this.categorie = categorie;
        this.budget = budget;
        this.image_event = image_event;
        this.nb_places = nb_places;
    }

    public Evenement(int evenement_id, String nom, String description, Timestamp date_debut, Timestamp date_fin, String lieu, String categorie, float budget, String image_event,int nb_places, List<Ticket> tickets, List<Tache> taches, List<Fournisseur> fournisseurs, List<Feedback> feedbacks, List<Utilisateur> listMembres) {
        this.evenement_id = evenement_id;
        this.nom = nom;
        this.description = description;
        this.date_debut =date_debut;
        this.date_fin =date_fin;
        this.lieu = lieu;
        this.categorie = categorie;
        this.budget = budget;
        this.image_event = image_event;
        this.nb_places = nb_places;
        this.tickets = tickets;
        this.taches = taches;
        this.fournisseurs = fournisseurs;
        this.feedbacks = feedbacks;
        this.listMembres = listMembres;
    }

    public int getEvenement_id() {
        return evenement_id;
    }

    public void setEvenement_id(int evenement_id) {
        this.evenement_id = evenement_id;
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

    public Timestamp getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public Timestamp getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Timestamp date_fin) {
        this.date_fin = date_fin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getImage_event() {
        return image_event;
    }

    public void setImage_event(String image_event) {
        this.image_event = image_event;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Utilisateur> getListMembres() {
        return listMembres;
    }

    public void setListMembres(List<Utilisateur> listMembres) {
        this.listMembres = listMembres;
    }

    @Override
    public String toString() {
        return "Evenement{" +
            "evenement_id=" + evenement_id +
            ", nom='" + nom + '\'' +
            ", description='" + description + '\'' +
            ", date_debut=" + date_debut +
            ", date_fin=" + date_fin +
            ", lieu='" + lieu + '\'' +
            ", categorie='" + categorie + '\'' +
            ", budget=" + budget +
            ", image_event='" + image_event + '\'' +
            ", nb_places=" + nb_places +
            ", tickets=" + tickets +
            ", taches=" + taches +
            ", fournisseurs=" + fournisseurs +
            ", feedbacks=" + feedbacks +
            ", listMembres=" + listMembres +
            '}';
    }
}
