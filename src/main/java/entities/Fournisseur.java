package entities;

public class Fournisseur {
    private int fournisseurId;
    private String nom;
    private String typeService;
    private String contrat;
    private String num_tel; // Added field

    // Constructors
    public Fournisseur() {}

    public Fournisseur(int fournisseurId, String nom, String typeService, String contrat, String num_tel) {
        this.fournisseurId = fournisseurId;
        this.nom = nom;
        this.typeService = typeService;
        this.contrat = contrat;
        this.num_tel = num_tel; // Added initialization
    }

    public Fournisseur(String nom, String typeService, String contrat, String num_tel) {
        this.nom = nom;
        this.typeService = typeService;
        this.contrat = contrat;
        this.num_tel = num_tel; // Added initialization
    }

    // Getters and Setters
    public int getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(int fournisseurId) { this.fournisseurId = fournisseurId; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getTypeService() { return typeService; }
    public void setTypeService(String typeService) { this.typeService = typeService; }

    public String getContrat() { return contrat; }
    public void setContrat(String contrat) { this.contrat = contrat; }

    // Added getter and setter for num_tel
    public String getNum_tel() { return num_tel; }
    public void setNum_tel(String num_tel) { this.num_tel = num_tel; }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "fournisseurId=" + fournisseurId +
                ", nom='" + nom + '\'' +
                ", typeService='" + typeService + '\'' +
                ", contrat='" + contrat + '\'' +
                ", num_tel=" + num_tel + // Added to toString()
                '}';
    }
}