package test;

//import controllers.DetailsEvenement;
import entities.*;
import services.*;
import utils.MyDataBase;

import java.sql.SQLException;
import java.sql.Timestamp;
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

        // Tester l'ajout d'un événement
       // testerAjouterEvenement(serviceEvenement);

        // Tester l'affichage des détails d'un événement
        //testerDetailsEvenement(serviceEvenement);

        // Gestion des événements
   //    gererEvenements(serviceEvenement);

        // Gestion des tickets
      //  gererTickets(serviceTicket);

        // Gestion des transactions
      //  gererTransactions(serviceTransaction, serviceTicket);

        // Gestion des feedbacks
//       gererFeedbacks(serviceFeedback, serviceEvenement);

     //   gererFournisseurs(serviceFournisseur, serviceEvenement);

        // Appel de la fonction pour gérer les tâches
//        gererTaches(serviceTache);


    }

    private static void testerAjouterEvenement(ServiceEvenement serviceEvenement) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            // Format de date pour parser les chaînes de date
            Date dateDebutUtil = dateFormat.parse("12-05-2025 17:00:00");
            Date dateFinUtil = dateFormat.parse("15-05-2025 21:00:00");

            Timestamp dateDebut = new Timestamp(dateDebutUtil.getTime());
            Timestamp dateFin = new Timestamp(dateFinUtil.getTime());

// Création d'un nouvel événement avec nb_places
            Evenement evenement = new Evenement(
                    "Conférence Art",                // Nom de l'événement
                    "Conférence sur l'Art",           // Description
                    dateDebut,                        // Date de début
                    dateFin,                          // Date de fin
                    "Tunis",                          // Lieu
                    "Cirque",                         // Catégorie
                    10000.0f,                         // Budget
                    "conference.jpg",                 // Image de l'événement
                    100                                // Nombre de places
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

//    private static void testerDetailsEvenement(ServiceEvenement serviceEvenement) {
//        try {
//            // Récupérer un événement de la base de données (par exemple, le premier événement)
//            List<Evenement> evenements = serviceEvenement.afficher();
//            if (!evenements.isEmpty()) {
//                Evenement evenement = evenements.get(0); // Prendre le premier événement de la liste
//
//                // Simuler l'affichage des détails dans l'interface
//                DetailsEvenement detailsEvenement = new DetailsEvenement();
//                detailsEvenement.setResNom(evenement.getNom());
//                detailsEvenement.setResDescription(evenement.getDescription());
//                detailsEvenement.setResDateDebut(evenement.getDate_debut().toString());
//                detailsEvenement.setResDateFin(evenement.getDate_fin().toString());
//                detailsEvenement.setResLieu(evenement.getLieu());
//                detailsEvenement.setResCategorie(evenement.getCategorie());
//                detailsEvenement.setResBudget(String.valueOf(evenement.getBudget()));
//                detailsEvenement.setResImageEvent(evenement.getImage_event());
//                detailsEvenement.setResNbPlaces(String.valueOf(evenement.getNb_places()));
//
//                // Afficher les détails dans la console (simulation)
//                System.out.println("\n📋 Détails de l'événement :");
//                System.out.println("Nom : " + evenement.getNom());
//                System.out.println("Description : " + evenement.getDescription());
//                System.out.println("Date de début : " + evenement.getDate_debut());
//                System.out.println("Date de fin : " + evenement.getDate_fin());
//                System.out.println("Lieu : " + evenement.getLieu());
//                System.out.println("Catégorie : " + evenement.getCategorie());
//                System.out.println("Budget : " + evenement.getBudget());
//                System.out.println("Image : " + evenement.getImage_event());
//                System.out.println("Nombre de places : " + evenement.getNb_places());
//            } else {
//                System.out.println("❌ Aucun événement trouvé dans la base de données.");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("❌ Erreur SQL : " + e.getMessage());
//        }
//    }

    private static void gererTickets(ServiceTicket serviceTicket) {
        try {
            ServiceEvenement serviceEvenement=new ServiceEvenement();
            Evenement evenement1 = serviceEvenement.getEvenementById(3); // Remplace 1 par un ID valide
            Evenement evenement2 = serviceEvenement.getEvenementById(4); // Remplace 2 par un ID valide

            if (evenement1 == null || evenement2 == null) {
                System.out.println("❌ Impossible d'ajouter des tickets : les événements n'existent pas.");
                return;
            }
            // Ajout des tickets
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Timestamp dateValidite1 = new Timestamp(dateFormat.parse("15-02-2025 18:41:54").getTime());
            Timestamp dateValidite2 = new Timestamp(dateFormat.parse("15-02-2025 18:41:54").getTime());

            // Ajout des tickets
            Ticket ticket1 = new Ticket(evenement1, "VIP", "En attente", 180.0, dateValidite1, 50);
            Ticket ticket2 = new Ticket(evenement2, "Standard", "En attente", 150.0, dateValidite2, 80);

            serviceTicket.ajouter(ticket1);
            serviceTicket.ajouter(ticket2);
            System.out.println("✅ Tickets ajoutés avec succès.");

            // Affichage des tickets après ajout
            afficherTickets(serviceTicket);

            // Modification d'un ticket
            ticket1.setStatut("Complété");
            serviceTicket.modifier(ticket1);
            System.out.println("✅ Ticket modifié avec succès.");

            // Affichage après modification
            afficherTickets(serviceTicket);

            // Suppression d'un ticket
            serviceTicket.supprimer(ticket2.getId_ticket());
            System.out.println("✅ Ticket supprimé avec succès.");

            // Affichage après suppression
            afficherTickets(serviceTicket);

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private static void gererTransactions(ServiceTransaction serviceTransaction, ServiceTicket serviceTicket) {
        try {
            // Récupération des tickets disponibles
            List<Ticket> tickets = serviceTicket.afficher();

            if (tickets == null || tickets.isEmpty()) {
                System.out.println("❌ Aucun ticket disponible. Impossible d'ajouter une transaction.");
                return;
            }

            // Création de la date actuelle au format Timestamp
            Timestamp dateActuelle = new Timestamp(System.currentTimeMillis());

            // Création et ajout de la transaction
           // Transaction transaction = new Transaction(1,1, tickets, 150.0, "en ligne", "Visa", dateActuelle);
        //    serviceTransaction.ajouter(transaction);
            System.out.println("✅ Transaction ajoutée avec succès.");

            // Affichage des transactions après ajout
            afficherTransactions(serviceTransaction);

            // Suppression de la transaction ajoutée
         //   serviceTransaction.supprimer(transaction.getId_transaction());
            System.out.println("✅ Transaction supprimée avec succès.");

            // Affichage des transactions après suppression
            afficherTransactions(serviceTransaction);

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
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
            Date dateDebutUtil = dateFormat.parse("12-05-2025 17:00:00");
            Date dateFinUtil = dateFormat.parse("15-05-2025 21:00:00");

            // Conversion des Date en Timestamp
            Timestamp dateDebut = new Timestamp(dateDebutUtil.getTime());
            Timestamp dateFin = new Timestamp(dateFinUtil.getTime());

            // Création d'un nouvel événement avec nb_places
            Evenement evenement = new Evenement(
                    "Conférence Art",                // Nom de l'événement
                    "Conférence sur l'Art",          // Description
                    dateDebut,                       // Date de début
                    dateFin,                         // Date de fin
                    "Tunis",                         // Lieu
                    "Cirque",                           // Catégorie
                    10000.0f,                        // Budget
                    "conference.jpg",                // Image de l'événement
                    100                              // Nombre de places
            );

            // Ajout de l'événement
            serviceEvenement.ajouter(evenement);
            System.out.println("✅ Événement ajouté avec succès.");

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
                "Haute" , // Priorité
                    "A"
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








