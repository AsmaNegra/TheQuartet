package tn.esprit.entities;

import java.util.Date;

public class Ticket {
    private int id_ticket;
    private int id_event;
    private int id_transaction;
    private String type;
    private String statut;
    private double prix;
    private Date date_validite;

    public Ticket() {
    }

    public Ticket(int id_ticket, int id_event, int id_transaction, String type, String statut,double prix, Date date_validite) {
        this.id_ticket = id_ticket;
        this.id_event = id_event;
        this.id_transaction = id_transaction;
        this.type = type;
        this.statut = statut;
        this.prix=prix;
        this.date_validite = date_validite;
    }

    public Ticket(int id_event, int id_transaction, String type, String statut,double prix, Date date_validite) {
        this.id_event = id_event;
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

    public int getId_event() {
        return id_event;
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

    public void setId_event(int id_event) {
        this.id_event = id_event;
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
                ", id_event=" + id_event +
                ", id_transaction=" + id_transaction +
                ", type='" + type + '\'' +
                ", statut='" + statut + '\'' +
                ", prix=" + prix +
                ", date_validite=" + date_validite +
                '}';
    }
}
