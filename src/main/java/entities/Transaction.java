package entities;

import java.util.Date;
import java.util.List;

public class Transaction {
    private int id_transaction;
    private Utilisateur utilisateur;
    List<Ticket> tickets_associes;
    private double montant_total;
    private String methode_paiement;
    private String type_paiement;
    private Date date_paiement;

    public Transaction() {
    }

    public Transaction(int id_transaction, Utilisateur utilisateur, List<Ticket> tickets_associes, double montant_total, String methode_paiement, String type_paiement, Date date_paiement) {
        this.id_transaction = id_transaction;
        this.utilisateur = utilisateur;
        this.date_paiement = date_paiement;
        this.type_paiement = type_paiement;
        this.methode_paiement = methode_paiement;
        this.montant_total = montant_total;
        this.tickets_associes = tickets_associes;
    }

    public Transaction(Utilisateur utilisateur , List<Ticket> tickets_associes, double montant_total, String methode_paiement, String type_paiement, Date date_paiement) {
        this.utilisateur = utilisateur;
        this.tickets_associes = tickets_associes;
        this.montant_total = montant_total;
        this.methode_paiement = methode_paiement;
        this.type_paiement = type_paiement;
        this.date_paiement = date_paiement;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) { this.id_transaction = id_transaction; }

    public Utilisateur getUtilisateur_id() {
        return utilisateur;
    }

    public void setUtilisateur_id(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Ticket> getTickets_associes() {
        return tickets_associes;
    }

    public void setTickets_associes(List<Ticket> tickets_associes) {
        this.tickets_associes = tickets_associes;
    }

    public double getMontant_total() {
        return montant_total;
    }

    public void setMontant_total(double montant_total) {
        this.montant_total = montant_total;
    }

    public String getMethode_paiement() {
        return methode_paiement;
    }

    public void setMethode_paiement(String methode_paiement) {
        this.methode_paiement = methode_paiement;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public java.sql.Date getDate_paiement() {
        return (java.sql.Date) date_paiement;
    }

    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }
    @Override
    public String toString() {
        StringBuilder ticketsString = new StringBuilder();
        if (tickets_associes != null && !tickets_associes.isEmpty()) {
            for (Ticket ticket : tickets_associes) {
                ticketsString.append(ticket.toString()).append(", ");
            }
            // Supprimer la dernière virgule et l'espace
            if (ticketsString.length() > 2) {
                ticketsString.setLength(ticketsString.length() - 2);
            }
        }

        return "Transaction{" +
                "id_transaction=" + id_transaction +
                ", utilisateur=" + utilisateur +
                ", tickets_associes=[" + ticketsString.toString() + "]" +
                ", montant_total=" + montant_total +
                ", methode_paiement='" + methode_paiement + '\'' +
                ", type_paiement='" + type_paiement + '\'' +
                ", date_paiement=" + date_paiement +
                '}';
    }

}
