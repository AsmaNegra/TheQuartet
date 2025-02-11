package test;

import entities.*;
import services.*;
import utils.MyDataBase;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Initialisation de la connexion à la base de données
        MyDataBase dbInstance = MyDataBase.getInstance();

        // Création des services
        ServiceTicket serviceTicket = new ServiceTicket();
        ServiceTransaction serviceTransaction = new ServiceTransaction(dbInstance.getConnection());
        ServiceTache serviceTache = new ServiceTache();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();

        // Ajout de tickets
        Ticket ticket1 = new Ticket(1, 1, 1, "Standard", "En attente", 50.0, Date.valueOf("2025-02-10"));
        Ticket ticket2 = new Ticket(2, 2, 2, "VIP", "En attente", 100.0, Date.valueOf("2025-03-15"));

        try {
            serviceTicket.ajouter(ticket1);
            serviceTicket.ajouter(ticket2);
            System.out.println("✅ Tickets ajoutés avec succès.");

            // Affichage des tickets
            afficherTickets(serviceTicket);

            // Ajout d'une transaction
            Transaction transaction1 = new Transaction(1, 1, List.of(ticket1, ticket2), 150.0, "en ligne", "Visa", Date.valueOf("2025-02-07"));
            serviceTransaction.ajouter(transaction1);
            System.out.println("✅ Transaction ajoutée avec succès.");

            // Affichage des transactions
            afficherTransactions(serviceTransaction);

            // Modification d'un ticket
            ticket1.setStatut("Complété");
            serviceTicket.modifier(ticket1);
            System.out.println("✅ Ticket modifié avec succès.");

            // Suppression d'un ticket
            serviceTicket.supprimer(ticket2.getId_ticket());
            System.out.println("✅ Ticket supprimé avec succès.");

            // Suppression d'une transaction
            serviceTransaction.supprimer(transaction1.getId_transaction());
            System.out.println("✅ Transaction supprimée avec succès.");

            // Gestion des fournisseurs
            Evenement evenement = new Evenement(1, "A", "B", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), "C", "XX", 10000F, "A");
            Fournisseur fournisseur1 = new Fournisseur(1, "Sonorisation Pro", "Matériel audio", "Contrat signé", evenement);
            serviceFournisseur.modifier(fournisseur1);
            serviceFournisseur.supprimer(fournisseur1.getFournisseurId());

            // Affichage des fournisseurs
            afficherFournisseurs(serviceFournisseur);
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        }

        // Gestion des événements
        gererEvenements(serviceEvenement);
    }

    private static void afficherTickets(ServiceTicket serviceTicket) throws SQLException {
        List<Ticket> tickets = serviceTicket.afficher();
        System.out.println("\n📋 Liste des tickets :");
        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }

    private static void afficherTransactions(ServiceTransaction serviceTransaction) throws SQLException {
        List<Transaction> transactions = serviceTransaction.afficher();
        System.out.println("\n📋 Liste des transactions :");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    private static void afficherFournisseurs(ServiceFournisseur serviceFournisseur) throws SQLException {
        List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
        System.out.println("\n📋 Liste des fournisseurs :");
        for (Fournisseur f : fournisseurs) {
            System.out.println(f);
        }
    }


    private static void gererEvenements(ServiceEvenement serviceEvenement) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Timestamp dateDebut = new java.sql.Timestamp(dateFormat.parse("2025-05-12 17:00:00").getTime());
            java.sql.Timestamp dateFin = new java.sql.Timestamp(dateFormat.parse("2025-05-15 21:00:00").getTime());

            Evenement evenement = new Evenement(
                    "Conférence Art",
                    "Conférence sur l'Art",
                    dateDebut,
                    dateFin,
                    "Tunis",
                    "Art",
                    10000.0f,
                    "conference.jpg"
            );

            serviceEvenement.ajouter(evenement);
            System.out.println("✅ Événement ajouté avec succès.");

            // Affichage des événements
            List<Evenement> evenements = serviceEvenement.afficher();
            System.out.println("\n📋 Liste des événements :");
            for (Evenement e : evenements) {
                System.out.println(e);
            }
        } catch (ParseException | SQLException e) {
            System.out.println("❌ Erreur : " + e.getMessage());
        }
    }

}


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



