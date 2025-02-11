package entities;
import java.util.Date;

public class Ticket {
    private int id_ticket;
    private Evenement evenement;
    private int id_transaction;
    private String type;
    private String statut;
    private double prix;
    private Date date_validite;

    public Ticket() {
    }

    public Ticket(int id_ticket, Evenement evenement, int id_transaction, String type, String statut,double prix, Date date_validite) {
        this.id_ticket = id_ticket;
        this.evenement = evenement ;
        this.id_transaction = id_transaction;
        this.type = type;
        this.statut = statut;
        this.prix=prix;
        this.date_validite = date_validite;
    }

    public Ticket(Evenement evenement, int id_transaction, String type, String statut,double prix, Date date_validite) {
        this.evenement = evenement;
        this.id_transaction = id_transaction;
        this.type = type;
        this.statut = statut;
        this.prix=prix;
        this.date_validite = date_validite;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public java.sql.Date getDate_validite() {
        return (java.sql.Date) date_validite;
    }

    public String getStatut() {
        return statut;
    }

    public String getType() {
        return type;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public Evenement getEvenement_id () {
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

    public void setEvenement_id (Evenement evenement ) {
        this.evenement  = evenement ;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDate_validite(Date date_validite) {
        this.date_validite = date_validite;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id_ticket=" + id_ticket +
                ", evenement =" + evenement  +
                ", id_transaction=" + id_transaction +
                ", type='" + type + '\'' +
                ", statut='" + statut + '\'' +
                ", prix=" + prix +
                ", date_validite=" + date_validite +
                '}';
    }
}
