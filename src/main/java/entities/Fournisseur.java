package entities;

public class Fournisseur {
    private int fournisseurId;
    private String nom;
    private String typeService;
    private String contrat;
    private Evenement evenement;

    // Constructeurs
    public Fournisseur() {}

    public Fournisseur(int fournisseurId, String nom, String typeService, String contrat, Evenement evenement) {
        this.fournisseurId = fournisseurId;
        this.nom = nom;
        this.typeService = typeService;
        this.contrat = contrat;
        this.evenement = evenement;
    }

    // Getters et Setters
    public int getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(int fournisseurId) { this.fournisseurId = fournisseurId; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getTypeService() { return typeService; }
    public void setTypeService(String typeService) { this.typeService = typeService; }

    public String getContrat() { return contrat; }
    public void setContrat(String contrat) { this.contrat = contrat; }

    public Evenement getEvenementId() { return evenement; }
    public void setEvenement(Evenement evenement) { this.evenement = evenement; }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "fournisseurId=" + fournisseurId +
                ", nom='" + nom + '\'' +
                ", typeService='" + typeService + '\'' +
                ", contrat='" + contrat + '\'' +
                ", evenementId=" + evenement +
                '}';
    }
}
