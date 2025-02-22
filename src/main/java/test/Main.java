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
        ServiceTache serviceTache = new ServiceTache();
        ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        ServiceFeedback serviceFeedback = new ServiceFeedback();
        ServiceTransaction serviceTransaction = new ServiceTransaction();
        ServiceUtilisateurEvenement serviceUtilisateurEvenement = new ServiceUtilisateurEvenement();

        // Gestion des événements
        // gererEvenements(serviceEvenement);
        // Tester l'ajout d'un événement
        // testerAjouterEvenement(serviceEvenement);

        // Tester l'affichage des détails d'un événement
        //testerDetailsEvenement(serviceEvenement);

        // Gestion des événements
        //    gererEvenements(serviceEvenement);


        //ajouter des Tickets
        //ajouterTickets(serviceTicket,serviceEvenement);
        // Gestion des tickets

        //afficherTickets(serviceTicket);
        // Modifier tickets
        //modifierTicket(serviceTicket);
        //Supprimer des tickets
        //supprimerTicket(serviceTicket);

        //Gestion des transaction
        //ajouterTransaction(serviceTransaction, serviceUtilisateurEvenement, serviceTicket);


        // Gestion des transactions
        //afficherTransactions(serviceTransaction);

        //Modifier des transactions
        //modifierTransaction(serviceTransaction, serviceUtilisateurEvenement,serviceTicket);

        //supprimer une transaction
        //supprimerTransaction(serviceTransaction);


    }

    private static void afficherTickets(ServiceTicket serviceTicket) throws SQLException {
        List<Ticket> tickets = serviceTicket.afficher();
        System.out.println("\n📋 Liste des tickets :");
        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }

    private static void ajouterTickets(ServiceTicket serviceTicket, ServiceEvenement serviceEvenement) throws SQLException {
        try {
            // Récupérer un événement existant
            Evenement event = serviceEvenement.getEvenementById(3);
            if (event == null) {
                System.out.println("Aucun événement trouvé, création annulée.");
                return;
            }

            Ticket ticket = new Ticket(event, "VIP", "Disponible", 100.0, Timestamp.valueOf("2025-05-10 18:00:00"), 50);
            serviceTicket.ajouter(ticket);
            System.out.println("✅ Tickets ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void modifierTicket(ServiceTicket serviceTicket) throws SQLException {
        try {
            // Récupérer un ticket existant (par exemple, avec l'ID 1)
            Ticket ticket = serviceTicket.getTicketById(5); // Supposons que l'ID du ticket est 1
            if (ticket == null) {
                System.out.println("Aucun ticket trouvé pour cet ID.");
                return;
            }
            // Modifier certains attributs (ex. : type, statut, prix,nb_tickets)
            ticket.setType("Standard");
            ticket.setStatut("Indisponible");
            ticket.setPrix(80.0);
            ticket.setNb_tickets(30);

            // Appliquer la modification
            serviceTicket.modifier(ticket);
            System.out.println("✅ Ticket modifié avec succès.");
            System.out.println("Ticket modifié : " + ticket);
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void supprimerTicket(ServiceTicket serviceTicket) throws SQLException {
        try {
            Ticket ticket = serviceTicket.getTicketById(15); // Supposons que l'ID du ticket est 5
            if (ticket == null) {
                System.out.println("Aucun ticket trouvé pour cet ID.");
                return;
            }

            // Appliquer la suppression
            serviceTicket.supprimer(20);
            System.out.println("✅ Ticket supprimé avec succès.");
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void afficherTransactions(ServiceTransaction serviceTransaction) throws SQLException {
        List<Transaction> transactions = serviceTransaction.afficher();
        System.out.println("\n📋 Liste des transactions :");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    private static void ajouterTransaction(ServiceTransaction serviceTransaction, ServiceUtilisateurEvenement serviceUtilisateur, ServiceTicket serviceTicket) throws SQLException {
        try {
            // Récupérer un utilisateur existant
            Utilisateur utilisateur = serviceUtilisateur.getUtilisateurById(1); // Exemple: ID 1
            if (utilisateur == null) {
                System.out.println("❌ Aucun utilisateur trouvé, création annulée.");
                return;
            }

            // Récupérer des tickets existants
            Ticket ticket1 = serviceTicket.getTicketById(67);
            Ticket ticket2 = serviceTicket.getTicketById(65);
            if (ticket1 == null || ticket2 == null) {
                System.out.println("❌ Un ou plusieurs tickets non trouvés.");
                return;
            }

            // Créer une liste de tickets associés
            List<Ticket> ticketsAssocies = List.of(ticket1);

            // Créer une transaction
            Transaction transaction = new Transaction(utilisateur, ticketsAssocies, 0.0, "Carte bancaire", Timestamp.valueOf("2025-05-10 18:00:00"));

            // Ajouter la transaction
            serviceTransaction.ajouter(transaction);

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void modifierTransaction(ServiceTransaction serviceTransaction, ServiceUtilisateurEvenement serviceUtilisateurEvenement, ServiceTicket serviceTicket) throws SQLException {
        try {
            // Récupérer une transaction existante (par exemple, ID 1)
            Transaction transaction = serviceTransaction.getTransactionById(15);  // Exemple: ID 1
            if (transaction == null) {
                System.out.println("❌ Aucune transaction trouvée.");
                return;
            }

            // Modifier les informations de la transaction
            Utilisateur utilisateur = serviceUtilisateurEvenement.getUtilisateurById(1);  // Exemple: ID 1
            if (utilisateur == null) {
                System.out.println("❌ Aucun utilisateur trouvé.");
                return;
            }

            // Récupérer des tickets existants
            Ticket ticket1 = serviceTicket.getTicketById(7); // Exemple: ID 3
            Ticket ticket2 = serviceTicket.getTicketById(9); // Exemple: ID 4
            if (ticket1 == null || ticket2 == null) {
                System.out.println("❌ Un ou plusieurs tickets non trouvés.");
                return;
            }

            // Créer une liste de tickets associés pour la modification
            List<Ticket> ticketsAssocies = List.of(ticket1, ticket2);

            // Mettre à jour les tickets associés à la transaction
            transaction.setTickets_associes(ticketsAssocies);
            transaction.setMode_paiement("Carte bancaire");
            transaction.setDate_paiement(Timestamp.valueOf("2025-06-10 18:00:00"));

            // Modifier la transaction
            serviceTransaction.modifier(transaction);

        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

    private static void supprimerTransaction(ServiceTransaction serviceTransaction) throws SQLException {
        try {
            int transactionId = 24;
            serviceTransaction.supprimer(transactionId);
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }

//
//    private static void testerAjouterEvenement(ServiceEvenement serviceEvenement) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//
//            // Format de date pour parser les chaînes de date
//            Date dateDebutUtil = dateFormat.parse("12-05-2025 17:00:00");
//            Date dateFinUtil = dateFormat.parse("15-05-2025 21:00:00");
//            // Conversion en Timestamp
//            Timestamp dateDebut = new Timestamp(dateDebutUtil.getTime());
//            Timestamp dateFin = new Timestamp(dateFinUtil.getTime());
//            // Création d'un nouvel événement avec nb_places
//            Evenement evenement = new Evenement(
//                "Conférence Art",                // Nom de l'événement
//                "Conférence sur l Art",          // Description
//                    (Timestamp) dateDebut,                      // Date de début
//                    (Timestamp) dateFin,                         // Date de fin
//                "Tunis",                         // Lieu
//                "Concert",                           // Catégorie
//                10000.0f,                       // Budget
//                "conference.jpg",               // Image de l'événement
//                100                             // Nombre de places
//            );
//
//            // Ajout de l'événement
//            serviceEvenement.ajouter(evenement);
//            System.out.println("✅ Événement ajouté avec succès.");
//
//            // Affichage de tous les événements pour vérification
//            List<Evenement> evenements = serviceEvenement.afficher();
//            System.out.println("\n📋 Liste des événements :");
//            for (Evenement e : evenements) {
//                System.out.println(e);
//            }
//
//        } catch (ParseException e) {
//            System.out.println("❌ Erreur de format de date : " + e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("❌ Erreur SQL : " + e.getMessage());
//        }
//    }

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


//    private static void gererFeedbacks(ServiceFeedback serviceFeedback, ServiceEvenement serviceEvenement) {
//        try {
//            // Création d'un événement et d'un utilisateur pour le feedback
//            Evenement evenement = new Evenement();
//            evenement.setEvenement_id(3); // Supposons qu'un événement avec l'ID 1 existe
//
//            Utilisateur utilisateur = new Utilisateur();
//            utilisateur.setUtilisateurId(1); // Supposons qu'un utilisateur avec l'ID 1 existe
//
//            // Création d'un feedback
//            Feedback feedback = new Feedback(
//                5, // Note
//                "Great event!", // Commentaire
//                new Date(), // Date_feedback (date actuelle)
//                evenement, // Événement
//                utilisateur // Utilisateur
//            );
//
//            // Ajout du feedback
//            serviceFeedback.ajouter(feedback);
//            System.out.println("✅ Feedback ajouté avec succès.");
//
//            // Modification du feedback
//            feedback.setNote(4);
//            feedback.setCommentaire("Good event, but could be better.");
//            serviceFeedback.modifier(feedback);
//            System.out.println("✅ Feedback modifié avec succès.");
//
//            // Suppression du feedback
//            serviceFeedback.supprimer(feedback.getFeedback_id());
//            System.out.println("✅ Feedback supprimé avec succès.");
//
//            // Affichage des feedbacks
//            afficherFeedbacks(serviceFeedback);
//
//        } catch (SQLException e) {
//            System.out.println("❌ Erreur SQL : " + e.getMessage());
//        }
//    }


//    private static void afficherFeedbacks(ServiceFeedback serviceFeedback) throws SQLException {
//        List<Feedback> feedbacks = serviceFeedback.afficher();
//        System.out.println("\n📋 Liste des feedbacks :");
//        for (Feedback f : feedbacks) {
//            System.out.println(f);
//        }
//    }


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
            Fournisseur fournisseur = new Fournisseur("Sonorisation Pro", "Matériel audio", "Contrat signé", evenement, 1);

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
                    "Haute", // Priorité
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
            throw new RuntimeException(e);
        }
    }
}

//        } catch (SQLException e) {
//            System.out.println("❌ Erreur SQL : " + e.getMessage());
//        }
//    }
//    private static void afficherFournisseurs(ServiceFournisseur serviceFournisseur) throws SQLException {
//        List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
//        System.out.println("\n📋 Liste des fournisseurs :");
//        for (Fournisseur f : fournisseurs) {
//            System.out.println(f);
//        }
//    }








