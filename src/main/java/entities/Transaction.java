package entities;

import java.sql.Timestamp;
import java.util.List;
import java.time.LocalDateTime;

public class Transaction {
    private int id_transaction;
    private Utilisateur utilisateur;
    List<Ticket> tickets_associes;
    private double montant_total;
    private String mode_paiement;
    private Timestamp date_paiement;

    public Transaction() {
    }

    public Transaction(int id_transaction, Utilisateur utilisateur, List<Ticket> tickets_associes, double montant_total, String mode_paiement, Timestamp date_paiement) {
        this.id_transaction = id_transaction;
        this.utilisateur = utilisateur;
        this.date_paiement = date_paiement;
        this.mode_paiement = mode_paiement;
        this.montant_total = montant_total;
        this.tickets_associes = tickets_associes;
    }

    public Transaction(Utilisateur utilisateur , List<Ticket> tickets_associes, double montant_total, String mode_paiement, Timestamp date_paiement) {
        this.utilisateur = utilisateur;
        this.tickets_associes = tickets_associes;
        this.montant_total = montant_total;
        this.mode_paiement = mode_paiement;
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

    public String getMode_paiement() {
        return mode_paiement;
    }

    public void setMode_paiement(String mode_paiement) {
        this.mode_paiement = mode_paiement;
    }

    public Timestamp getDate_paiement() {
        return date_paiement;
    }

    public void setDate_paiement(Timestamp date_paiement) {
        this.date_paiement = date_paiement;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id_transaction=" + id_transaction +
                ", utilisateur=" + utilisateur +
                ", tickets_associes=" + tickets_associes +
                ", montant_total=" + montant_total +
                ", mode_paiement='" + mode_paiement + '\'' +
                ", date_paiement=" + date_paiement +
                '}';
    }
}
