package entities;
import java.sql.Timestamp;


public class Ticket {
    private int id_ticket;
    private Evenement evenement;
    private String type;
    private String statut="En attente";
    private double prix;
    private Timestamp date_validite;
    private int nb_tickets;

    public Ticket() {
    }

    public Ticket(int id_ticket, Evenement evenement, String type, String statut,double prix, Timestamp date_validite, int nb_tickets) {
        this.id_ticket = id_ticket;
        this.evenement = evenement ;
        this.type = type;
        this.statut = statut;
        this.prix=prix;
        this.date_validite = date_validite;
        this.nb_tickets=nb_tickets;
    }

    public Ticket(Evenement evenement, String type, String statut,double prix, Timestamp date_validite, int nb_tickets) {
        this.evenement = evenement;
        this.type = type;
        this.statut = statut;
        this.prix=prix;
        this.date_validite = date_validite;
        this.nb_tickets=nb_tickets;
    }

    public int getNb_tickets() {
        return nb_tickets;
    }

    public void setNb_tickets(int nb_tickets) {
        this.nb_tickets = nb_tickets;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public Timestamp getDate_validite() {
        return  date_validite;
    }

    public String getStatut() {
        return statut;
    }

    public String getType() {
        return type;
    }

    public Evenement getEvenement () {
        return evenement ;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public void setEvenement (Evenement evenement ) {
        this.evenement  = evenement ;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDate_validite(Timestamp date_validite) {
        this.date_validite = date_validite;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id_ticket=" + id_ticket +
                ", evenement =" + evenement  +
                ", type='" + type + '\'' +
                ", statut='" + statut + '\'' +
                ", prix=" + prix +
                ", date_validite=" + date_validite +
                ", nb_ticktes=" + nb_tickets +
                '}';
    }

}
