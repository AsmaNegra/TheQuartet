package Test;

import Entities.Evenement;
import Entities.Utilisateur;
import Services.ServiceEvenement;
import Entities.Feedback;
import Services.ServiceFeedback;


import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Main pour Evenement
        ServiceEvenement se =new ServiceEvenement();

        try{
            Utilisateur organisateur = new Utilisateur();
            organisateur.setUtilisateurId(1);

            se.ajouter(new Evenement("Conférence Art",
                "Conférence sur l Art",
                new SimpleDateFormat("dd-MM-yyyy").parse("12-05-2025"),
                new SimpleDateFormat("dd-MM-yyyy").parse("15-05-2025"),
                "Tunis",
                "Art",
                10000.0f,
                "conference.jpg",
                organisateur));
            System.out.println("Evenement ajoute");

//             se.modifier(new Evenement(1, "Concert", "Événement musical", new Date(), new Date(), "Tunis", "Fun", 5000.0f, "concert.jpg", organisateur));
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
