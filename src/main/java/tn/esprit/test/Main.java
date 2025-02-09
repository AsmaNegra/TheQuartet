package tn.esprit.test;

import tn.esprit.entities.Ticket;
import tn.esprit.entities.Transaction;
import tn.esprit.services.ServiceTicket;
import tn.esprit.services.ServiceTransaction;
import tn.esprit.utils.MyDataBase;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Initialisation de la connexion à la base de données
        MyDataBase dbInstance = MyDataBase.getInstance();

        // Création des services
        ServiceTicket serviceTicket = new ServiceTicket();
        ServiceTransaction serviceTransaction = new ServiceTransaction(dbInstance.getConnection());

        // Exemple d'ajout de tickets
        Ticket ticket1 = new Ticket(1, 1, 1, "Standard", "En attente", 50.0, Date.valueOf("2025-02-10"));
        Ticket ticket2 = new Ticket(2, 2, 2, "VIP", "En attente", 100.0, Date.valueOf("2025-03-15"));

        try {
            // Ajout de tickets
            serviceTicket.ajouter(ticket1);
            serviceTicket.ajouter(ticket2);
            System.out.println("Tickets ajoutés avec succès.");

            // Affichage des tickets
            List<Ticket> tickets = serviceTicket.afficher();
            System.out.println("Liste des tickets:");
            for (Ticket t : tickets) {
                System.out.println(t);
            }

            // Exemple d'ajout d'une transaction
            Transaction transaction1 = new Transaction(1, 1, tickets, 150.0, "en ligne", "Visa", Date.valueOf("2025-02-07"));
            serviceTransaction.ajouter(transaction1);
            System.out.println("Transaction ajoutée avec succès.");

            // Affichage des transactions
            List<Transaction> transactions = serviceTransaction.afficher();
            System.out.println("Liste des transactions:");
            for (Transaction t : transactions) {
                System.out.println(t);
            }

            // Exemple de modification d'un ticket
            ticket1.setStatut("Complété");
            serviceTicket.modifier(ticket1);
            System.out.println("Ticket modifié avec succès.");

            // Exemple de suppression de ticket
            serviceTicket.supprimer(ticket2.getId_ticket());
            System.out.println("Ticket supprimé avec succès.");

            // Exemple de suppression de transaction
            serviceTransaction.supprimer(transaction1.getId_transaction());
            System.out.println("Transaction supprimée avec succès.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
