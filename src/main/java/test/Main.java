package tn.esprit.test;

import tn.esprit.entities.Ticket;
import tn.esprit.entities.Transaction;
import tn.esprit.services.ServiceTicket;
import tn.esprit.services.ServiceTransaction;
import tn.esprit.utils.MyDataBase;

import java.sql.Date;
package test;

import entities.Evenement;
import entities.Fournisseur;
import entities.Tache;
import services.ServiceTache;
import services.ServiceFournisseur;
import java.sql.SQLException;
import services.ServiceEvenement;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            ServiceTache serviceTache = new ServiceTache();
            ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
Evenement e = new Evenement(1, "A", "B", new Date(), new Date(), "C", "XX", 10000F, "A");
            Fournisseur fournisseur1 = new Fournisseur(1, "Sonorisation Pro", "Matériel audio", "Contrat signé", e);
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

            // ✅ AFFICHER TOUS LES FOURNISSEURS
            List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
            System.out.println("\n📋 Liste des fournisseurs :");
            for (Fournisseur f : fournisseurs) {
                System.out.println(f);
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

            fournisseur1.setTypeService("sonore");
                serviceFournisseur.modifier(fournisseur1);
              serviceFournisseur.supprimer(fournisseur1.getFournisseurId());
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        }

        //Main pour Evenement
        ServiceEvenement se =new ServiceEvenement();

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date dateDebut = dateFormat.parse("12-05-2025 17:00:00");
            Date dateFin = dateFormat.parse("15-05-2025 21:00:00");

            se.ajouter(new Evenement("Conférence Art",
                "Conférence sur l Art",
                dateDebut,
                dateFin,
                "Tunis",
                "Art",
                10000.0f,
                "conference.jpg"
            ));
            System.out.println("Evenement ajoute");

//             se.modifier(new Evenement(1, "Concert", "Événement musical", new Date(), new Date(), "Tunis", "Fun", 5000.0f, "concert.jpg"));
//            System.out.println("Evenement modifie");
//             se.supprimer(1);
//             System.out.println("Evenement supprime");


            List<Evenement> evenements = se.afficher();
            System.out.println("\n--- Liste des événements ---");
            for (Evenement e : evenements) {
                System.out.println(e);
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());        }

        //main pour Feedback
//        ServiceFeedback sf = new ServiceFeedback();
//
//        // Create Evenement and Utilisateur objects for testing
//        Evenement evenement = new Evenement();
//        evenement.setEvenement_id(2); // Assuming an event with ID 1 exists
//
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setUtilisateurId(1); // Assuming a user with ID 1 exists
//
//        // Create a Feedback object
//        Feedback feedback = new Feedback(
//            5, // Note
//            "Great event!", // Commentaire
//            new Date(), // Date_feedback (current date and time)
//            evenement, // Evenement
//            utilisateur // Utilisateur
//        );
//        try {
//            // Add the feedback
////            sf.ajouter(feedback);
////            System.out.println("Feedback ajouté");
//
//            // Update the feedback (assuming the feedback ID is 1)
////            feedback.setFeedback_id(1); // Set the ID of the feedback to update
////            feedback.setNote(4);
////            feedback.setCommentaire("Good event, but could be better.");
////            sf.modifier(feedback);
////            System.out.println("Feedback modifié");
//
//            // Delete the feedback (assuming the feedback ID is 1)
////            sf.supprimer(3);
////            System.out.println("Feedback supprimé");
//
//            // Display all feedbacks
//            List<Feedback> feedbacks = sf.afficher();
//            for (Feedback f : feedbacks) {
//                System.out.println(f);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

    }
}
