package test;

import entities.*;
import services.*;
import utils.MyDataBase;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Initialisation de la connexion à la base de données
            MyDataBase dbInstance = MyDataBase.getInstance();

            // Création des services
            ServiceTache serviceTache = new ServiceTache();
            ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
            ServiceEvenement serviceEvenement = new ServiceEvenement();
            ServiceTicket serviceTicket = new ServiceTicket();
            ServiceTransaction serviceTransaction = new ServiceTransaction();
            ServiceUtilisateurEvenement serviceUtilisateurEvenement = new ServiceUtilisateurEvenement();

            // Création des événements
            Evenement evenement3 = new Evenement( 1, "A", "B", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "C", "XX", 10000F, "A");
            Evenement evenement4 = new Evenement(2, "AA", "BB", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "CC", "XXX", 10000F, "AA");


            // Création de l'utilisateur
            Utilisateur utilisateur1 = new Utilisateur(320, "mohamed", "mohamed@esprit.tn", "mohamed", "participant", "xxx", 3.56F, "Esprit", List.of(evenement3, evenement4));

            // Création des tickets
            Ticket ticket1 = new Ticket( evenement3, "VIP", "En attente", 180.0, (Timestamp) evenement3.getDate_fin(), 50);
            Ticket ticket2 = new Ticket( evenement3, "Standard", "En attente", 150.0, (Timestamp) evenement4.getDate_fin(), 80);

            // Ajout des tickets
            serviceTicket.ajouter(ticket1);
            serviceTicket.ajouter(ticket2);
            System.out.println("✅ Tickets ajoutés avec succès.");

            // Affichage des tickets
            afficherTickets(serviceTicket);

            // Ajout d'une transaction
            Timestamp dateActuelle = new Timestamp(System.currentTimeMillis());
            Transaction transaction1 = new Transaction(utilisateur1, List.of(ticket1, ticket2), 150.0, "en ligne", dateActuelle);
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
//            Evenement evenement = new Evenement(1, "A", "B", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), "C", "XX", 10000F, "A");
//            Fournisseur fournisseur1 = new Fournisseur(1, "Sonorisation Pro", "Matériel audio", "Contrat signé", evenement);
//            serviceFournisseur.modifier(fournisseur1);
//            serviceFournisseur.supprimer(fournisseur1.getFournisseurId());
//
//            // Affichage des fournisseurs
//            afficherFournisseurs(serviceFournisseur);
            // Gestion des événements
//        gererEvenements(serviceEvenement);

            // Gestion des feedbacks
//       gererFeedbacks(serviceFeedback, serviceEvenement);

            //   gererFournisseurs(serviceFournisseur, serviceEvenement);

            // Appel de la fonction pour gérer les tâches
            gererTaches(serviceTache);
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
            e.printStackTrace();
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
        // Fonction d'exemple pour gérer les événements
        try {
            Evenement evenement = new Evenement(
                    "Conférence Art",
                    "Conférence sur l'Art",
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis() + 3600 * 1000), // 1h après
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
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
            e.printStackTrace();
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
