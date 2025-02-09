package entities;
import java.util.Date;

public class Tache {
    private int tacheId;
    private String nom;
    private String description;
    private String statut; // Peut être 'En attente', 'En cours', 'Terminée'
    private Date dateLimite;
    private Evenement evenement;
    private Fournisseur fournisseur;

    // Getters et Setters
}
