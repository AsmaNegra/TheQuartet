package test;

import entities.Evenement;
import entities.Fournisseur;
import entities.Tache;
import services.ServiceTache;
import services.ServiceFournisseur;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ServiceTache serviceTache = new ServiceTache();
            ServiceFournisseur serviceFournisseur = new ServiceFournisseur();
Evenement e = new Evenement(1, "A", "B", new Date(), new Date(), "C", "XX", 10000F, "A");
            Fournisseur fournisseur1 = new Fournisseur(1, "Sonorisation Pro", "Matériel audio", "Contrat signé", e);

            // ✅ AFFICHER TOUS LES FOURNISSEURS
            List<Fournisseur> fournisseurs = serviceFournisseur.afficher();
            System.out.println("\n📋 Liste des fournisseurs :");
            for (Fournisseur f : fournisseurs) {
                System.out.println(f);
            }
            fournisseur1.setTypeService("sonore");
                serviceFournisseur.modifier(fournisseur1);
              serviceFournisseur.supprimer(fournisseur1.getFournisseurId());
        } catch (SQLException e) {
            System.out.println("❌ Erreur SQL : " + e.getMessage());
        }
    }
}
