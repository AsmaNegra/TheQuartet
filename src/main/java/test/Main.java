package test;

import controllers.DetailsEvenement;
import entities.*;
import services.*;
import utils.MyDataBase;

//import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;



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
        ServiceFeedback serviceFeedback = new ServiceFeedback();

        // Gestion des tickets
        //  gererTickets(serviceTicket);

        // Gestion des transactions
//       gererTransactions(serviceTransaction, serviceTicket);

        // Tester l'ajout d'un événement
        testerAjouterEvenement(serviceEvenement);

        // Tester l'affichage des détails d'un événement
        testerDetailsEvenement(serviceEvenement);

        // Gestion des événements
//        gererEvenements(serviceEvenement);

        // Gestion des feedbacks
//       gererFeedbacks(serviceFeedback, serviceEvenement);

     //   gererFournisseurs(serviceFournisseur, serviceEvenement);

        // Appel de la fonction pour gérer les tâches
//        gererTaches(serviceTache);


    }

    private static void testerAjouterEvenement(ServiceEvenement serviceEvenement) {
        try {
            // Format de date pour parser les chaînes de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            // Dates de début et de fin pour l'événement
            Date dateDebut = dateFormat.parse("12-05-2025 17:00:00");
            Date dateFin = dateFormat.parse("15-05-2025 21:00:00");

            // Création d'un nouvel événement avec nb_places
            Evenement evenement = new Evenement(
                "Conférence Art",                // Nom de l'événement
                "Conférence sur l Art",          // Description
                dateDebut,                      // Date de début
                dateFin,                         // Date de fin
                "Tunis",                         // Lieu
                "Art",                           // Catégorie
                10000.0f,                       // Budget
                "conference.jpg",               // Image de l'événement
                100                             // Nombre de places
            );

            // Ajout de l'événement
            serviceEvenement.ajouter(evenement);
            System.out.println("✅ Événement ajouté avec succès.");

            // Affichage de tous les événements pour vérification
            List<Evenement> evenements = serviceEvenement.afficher();
            System.out.println("\n📋 Liste des événements :");
            for (Evenement e : evenements) {
                System.out.println(e);
            }

        } catch (ParseException e) {
            System.out.println("❌ Erreur de format de date : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void testerDetailsEvenement(ServiceEvenement serviceEvenement) {
        try {
            // Récupérer un événement de la base de données (par exemple, le premier événement)
            List<Evenement> evenements = serviceEvenement.afficher();
            if (!evenements.isEmpty()) {
                Evenement evenement = evenements.get(0); // Prendre le premier événement de la liste

                // Simuler l'affichage des détails dans l'interface
                DetailsEvenement detailsEvenement = new DetailsEvenement();
                detailsEvenement.setResNom(evenement.getNom());
                detailsEvenement.setResDescription(evenement.getDescription());
                detailsEvenement.setResDateDebut(evenement.getDate_debut().toString());
                detailsEvenement.setResDateFin(evenement.getDate_fin().toString());
                detailsEvenement.setResLieu(evenement.getLieu());
                detailsEvenement.setResCategorie(evenement.getCategorie());
                detailsEvenement.setResBudget(String.valueOf(evenement.getBudget()));
                detailsEvenement.setResImageEvent(evenement.getImage_event());
                detailsEvenement.setResNbPlaces(String.valueOf(evenement.getNb_places()));

                // Afficher les détails dans la console (simulation)
                System.out.println("\n📋 Détails de l'événement :");
                System.out.println("Nom : " + evenement.getNom());
                System.out.println("Description : " + evenement.getDescription());
                System.out.println("Date de début : " + evenement.getDate_debut());
                System.out.println("Date de fin : " + evenement.getDate_fin());
                System.out.println("Lieu : " + evenement.getLieu());
                System.out.println("Catégorie : " + evenement.getCategorie());
                System.out.println("Budget : " + evenement.getBudget());
                System.out.println("Image : " + evenement.getImage_event());
                System.out.println("Nombre de places : " + evenement.getNb_places());
            } else {
                System.out.println("❌ Aucun événement trouvé dans la base de données.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void gererTickets(ServiceTicket serviceTicket) {
        try {
            // Ajout de tickets
//            Ticket ticket1 = new Ticket(1, 1, 1, "Standard", "En attente", 50.0, Date.valueOf("2025-02-10"));
//            Ticket ticket2 = new Ticket(2, 2, 2, "VIP", "En attente", 100.0, Date.valueOf("2025-03-15"));

            // Définir le format de la date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Conversion des chaînes en java.util.Date
            Date date1 = dateFormat.parse("2025-02-10");
            Date date2 = dateFormat.parse("2025-03-15");

            // Création des tickets en utilisant java.util.Date
            Ticket ticket1 = new Ticket(1, 1, 1, "Standard", "En attente", 50.0, date1);
            Ticket ticket2 = new Ticket(2, 2, 2, "VIP", "En attente", 100.0, date2);

            serviceTicket.ajouter(ticket1);
            serviceTicket.ajouter(ticket2);
            System.out.println("✅ Tickets ajoutés avec succès.");

            // Affichage des tickets
            afficherTickets(serviceTicket);

            // Modification d'un ticket
            ticket1.setStatut("Complété");
            serviceTicket.modifier(ticket1);
            System.out.println("✅ Ticket modifié avec succès.");

            // Suppression d'un ticket
            serviceTicket.supprimer(ticket2.getId_ticket());
            System.out.println("✅ Ticket supprimé avec succès.");

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void gererTransactions(ServiceTransaction serviceTransaction, ServiceTicket serviceTicket) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date transactionDate = dateFormat.parse("2025-02-07");

            // Récupération des tickets pour la transaction
            List<Ticket> tickets = serviceTicket.afficher();

            // Ajout d'une transaction
//            Transaction transaction1 = new Transaction(1, 1, tickets, 150.0, "en ligne", "Visa", Date.valueOf("2025-02-07"));
            // Création de la transaction en utilisant java.util.Date
            Transaction transaction1 = new Transaction(1, 1, tickets, 150.0, "en ligne", "Visa", transactionDate);
            serviceTransaction.ajouter(transaction1);
            System.out.println("✅ Transaction ajoutée avec succès.");

            // Affichage des transactions
            afficherTransactions(serviceTransaction);

            // Suppression d'une transaction
            serviceTransaction.supprimer(transaction1.getId_transaction());
            System.out.println("✅ Transaction supprimée avec succès.");

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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
            // Format de date pour parser les chaînes de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            // Dates de début et de fin pour l'événement
            Date dateDebut = dateFormat.parse("12-05-2025 17:00:00");
            Date dateFin = dateFormat.parse("15-05-2025 21:00:00");

            // Création d'un nouvel événement avec nb_places
            Evenement evenement = new Evenement(
                "Conférence Art",                // Nom de l'événement
                "Conférence sur l Art",          // Description
                dateDebut,                      // Date de début
                dateFin,                         // Date de fin
                "Tunis",                         // Lieu
                "Art",                           // Catégorie
                10000.0f,                       // Budget
                "conference.jpg",               // Image de l'événement
                100                             // Nombre de places
            );

            // Ajout de l'événement
            serviceEvenement.ajouter(evenement);
            System.out.println("✅ Événement ajouté avec succès.");

            // Modification d'un événement existant (exemple commenté)

//        Evenement evenementModifie = new Evenement(
//            1,                              // ID de l'événement à modifier
//            "Concert",                      // Nouveau nom
//            "Événement musical",            // Nouvelle description
//            dateDebut,                      // Nouvelle date de début
//            dateFin,                        // Nouvelle date de fin
//            "Tunis",                        // Nouveau lieu
//            "Fun",                          // Nouvelle catégorie
//            5000.0f,                        // Nouveau budget
//            "concert.jpg",                  // Nouvelle image
//            200                             // Nouveau nombre de places
//        );
//        serviceEvenement.modifier(evenementModifie);
//        System.out.println("✅ Événement modifié avec succès.");


            // Suppression d'un événement (exemple commenté)

//        serviceEvenement.supprimer(2);      // Supprimer l'événement avec l'ID 1
//        System.out.println("✅ Événement supprimé avec succès.");


            // Affichage de tous les événements
            List<Evenement> evenements = serviceEvenement.afficher();
            System.out.println("\n📋 Liste des événements :");
            for (Evenement e : evenements) {
                System.out.println(e);
            }

        } catch (ParseException e) {
            System.out.println("❌ Erreur de format de date : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void gererFeedbacks(ServiceFeedback serviceFeedback, ServiceEvenement serviceEvenement) {
        try {
            // Création d'un événement et d'un utilisateur pour le feedback
            Evenement evenement = new Evenement();
            evenement.setEvenement_id(3); // Supposons qu'un événement avec l'ID 1 existe

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setUtilisateurId(1); // Supposons qu'un utilisateur avec l'ID 1 existe

            // Création d'un feedback
            Feedback feedback = new Feedback(
                5, // Note
                "Great event!", // Commentaire
                new Date(), // Date_feedback (date actuelle)
                evenement, // Événement
                utilisateur // Utilisateur
            );

            // Ajout du feedback
            serviceFeedback.ajouter(feedback);
            System.out.println("✅ Feedback ajouté avec succès.");

            // Modification du feedback
            feedback.setNote(4);
            feedback.setCommentaire("Good event, but could be better.");
            serviceFeedback.modifier(feedback);
            System.out.println("✅ Feedback modifié avec succès.");

            // Suppression du feedback
            serviceFeedback.supprimer(feedback.getFeedback_id());
            System.out.println("✅ Feedback supprimé avec succès.");

            // Affichage des feedbacks
            afficherFeedbacks(serviceFeedback);

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void afficherFeedbacks(ServiceFeedback serviceFeedback) throws SQLException {
        List<Feedback> feedbacks = serviceFeedback.afficher();
        System.out.println("\n📋 Liste des feedbacks :");
        for (Feedback f : feedbacks) {
            System.out.println(f);
        }
    }


    private static void gererFournisseurs(ServiceFournisseur serviceFournisseur, ServiceEvenement serviceEvenement) {
        try {
            // Création d'un événement pour le fournisseur
            Evenement evenement = new Evenement();
            evenement.setEvenement_id(3);

            // Création d'un fournisseur
            Fournisseur fournisseur = new Fournisseur( "Sonorisation Pro", "Matériel audio", "Contrat signé", evenement);

            // Ajout du fournisseur
            serviceFournisseur.ajouter(fournisseur);
            System.out.println("✅ Fournisseur ajouté avec succès.");

            // Affichage des fournisseurs
            afficherFournisseurs(serviceFournisseur);

            // Modification du fournisseur
//            fournisseur.setTypeService("Matériel vidéo");
//            serviceFournisseur.modifier(fournisseur);
//            System.out.println("✅ Fournisseur modifié avec succès.");

            // Suppression du fournisseur
//            serviceFournisseur.supprimer(fournisseur.getFournisseurId());
//            System.out.println("✅ Fournisseur supprimé avec succès.");

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }
    private static void gererTaches(ServiceTache serviceTache) {
        try {
            // Création d'une tâche avec priorité
            Evenement evenement = new Evenement();
            evenement.setEvenement_id(3);
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setFournisseurId(1);

            Tache tache = new Tache(
                "Préparation de la salle",
                "Préparer la salle pour la conférence",
                "To Do",
                new Date(System.currentTimeMillis()),
                evenement,
                fournisseur,
                "Haute"  // Priorité
            );

            // Ajout de la tâche
            serviceTache.ajouter(tache);
            System.out.println("✅ Tâche ajoutée avec succès.");

            // Affichage des tâches
            List<Tache> taches = serviceTache.afficher();
            System.out.println("\n📋 Liste des tâches :");
            for (Tache t : taches) {
                System.out.println(t);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }




}








