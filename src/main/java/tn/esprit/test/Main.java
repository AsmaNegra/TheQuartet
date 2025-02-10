package tn.esprit.test;

import tn.esprit.entities.Utilisateur;
import tn.esprit.entities.Role;
import tn.esprit.services.ServiceUtilisateur;
import tn.esprit.utils.MyDataBase;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialisation de la connexion à la base de données
        MyDataBase dbInstance = MyDataBase.getInstance();

        // Création du service utilisateur
        ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();

        // Scanner pour prendre les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoisissez une option :");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Modifier un utilisateur");
            System.out.println("3. Supprimer un utilisateur");
            System.out.println("4. Afficher les utilisateurs");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1: // Ajouter un utilisateur
                    System.out.println("\nEntrez les détails de l'utilisateur à ajouter :");
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Mot de passe : ");
                    String motDePasse = scanner.nextLine();
                    System.out.print("Role (ADMIN, PARTICIPANT, ORGANISATEUR) : ");
                    String roleInput = scanner.nextLine();
                    Role role = Role.valueOf(roleInput.toUpperCase());
                    System.out.print("Etat : ");
                    String etat = scanner.nextLine();
                    System.out.print("Note organisateur : ");
                    int noteOrganisateur = scanner.nextInt();
                    scanner.nextLine(); // Consommer le retour à la ligne
                    System.out.print("Entreprise : ");
                    String entreprise = scanner.nextLine();

                    Utilisateur utilisateur = new Utilisateur(0, nom, email, motDePasse, role, etat, noteOrganisateur, entreprise);
                    try {
                        serviceUtilisateur.ajouter_Utili(utilisateur);
                        System.out.println("Utilisateur ajouté avec succès.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Erreur lors de l'ajout de l'utilisateur.");
                    }
                    break;

                case 2: // Modifier un utilisateur
                    System.out.print("\nEntrez l'ID de l'utilisateur à modifier : ");
                    int idUtilisateur = scanner.nextInt();
                    scanner.nextLine(); // Consommer le retour à la ligne

                    // Récupérer l'utilisateur à partir de l'ID
                    try {
                        List<Utilisateur> utilisateurs = serviceUtilisateur.afficher_Utili();
                        Utilisateur utilisateurAModifier = null;
                        for (Utilisateur u : utilisateurs) {
                            if (u.getUtilisateurId() == idUtilisateur) {
                                utilisateurAModifier = u;
                                break;
                            }
                        }

                        if (utilisateurAModifier != null) {
                            System.out.println("Utilisateur trouvé : " + utilisateurAModifier.getNom());
                            System.out.print("Nouveau nom : ");
                            String nouveauNom = scanner.nextLine();
                            utilisateurAModifier.setNom(nouveauNom);

                            System.out.print("Nouveau email : ");
                            String nouvelEmail = scanner.nextLine();
                            utilisateurAModifier.setEmail(nouvelEmail);

                            System.out.print("Nouveau mot de passe : ");
                            String nouveauMotDePasse = scanner.nextLine();
                            utilisateurAModifier.setMotDePasse(nouveauMotDePasse);

                            System.out.print("Nouveau rôle (ADMIN, PARTICIPANT, ORGANISATEUR) : ");
                            String nouveauRole = scanner.nextLine();
                            utilisateurAModifier.setRole(Role.valueOf(nouveauRole.toUpperCase()));

                            System.out.print("Nouvel état : ");
                            String nouvelEtat = scanner.nextLine();
                            utilisateurAModifier.setEtat(nouvelEtat);

                            System.out.print("Nouvelle note organisateur : ");
                            int nouvelleNoteOrganisateur = scanner.nextInt();
                            utilisateurAModifier.setNote_organisateur(nouvelleNoteOrganisateur);

                            scanner.nextLine(); // Consommer le retour à la ligne
                            System.out.print("Nouvelle entreprise : ");
                            String nouvelleEntreprise = scanner.nextLine();
                            utilisateurAModifier.setEntreprise(nouvelleEntreprise);

                            // Appel à la méthode de modification
                            serviceUtilisateur.modifier_Utili(utilisateurAModifier);
                            System.out.println("Utilisateur modifié avec succès.");
                        } else {
                            System.out.println("Utilisateur avec cet ID non trouvé.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Erreur lors de la récupération des utilisateurs.");
                    }
                    break;

                case 3: // Supprimer un utilisateur
                    System.out.print("\nEntrez l'ID de l'utilisateur à supprimer : ");
                    int idASupprimer = scanner.nextInt();
                    try {
                        serviceUtilisateur.supprimer_Utili(idASupprimer);
                        System.out.println("Utilisateur supprimé avec succès.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Erreur lors de la suppression de l'utilisateur.");
                    }
                    break;

                case 4: // Afficher les utilisateurs
                    try {
                        List<Utilisateur> utilisateurs = serviceUtilisateur.afficher_Utili();
                        System.out.println("\nListe des utilisateurs :");
                        for (Utilisateur u : utilisateurs) {
                            System.out.println("ID: " + u.getUtilisateurId() + ", Nom: " + u.getNom() + ", Email: " + u.getEmail() + ", Rôle: " + u.getRole());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Erreur lors de l'affichage des utilisateurs.");
                    }
                    break;

                case 5: // Quitter
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}
