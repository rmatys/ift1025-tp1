import java.util.ArrayList;

public class Voiture {
    private final String plaqueImmatriculation;
    private final String marque;
    private final int anneeFabrication;
    private final double prixAchat;
    private final int kilometrageAchat;
    private StatutVoiture statutVoiture;
    private final int kilometrageActuel;
    private final ArrayList<DepenseVoiture> depensesVoiture;

    public Voiture(String plaqueImmatriculation, String marque, int anneeFabrication,
                   double prixAchat, int kilometrageAchat, StatutVoiture statutVoiture,
                   int kilometrageActuel) {
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
        this.prixAchat = prixAchat;
        this.kilometrageAchat = kilometrageAchat;
        this.statutVoiture = statutVoiture;
        this.kilometrageActuel = kilometrageActuel;
        this.depensesVoiture = new ArrayList<>();
    }

    public Voiture(String plaqueImmatriculation, String marque, int anneeFabrication,
                   double prixAchat, int kilometrageAchat, StatutVoiture statutVoiture,
                   int kilometrageActuel, ArrayList<DepenseVoiture> depensesVoiture) {
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
        this.prixAchat = prixAchat;
        this.kilometrageAchat = kilometrageAchat;
        this.statutVoiture = statutVoiture;
        this.kilometrageActuel = kilometrageActuel;
        this.depensesVoiture = depensesVoiture;
    }

    // faire attention voiture est disponible s'il n'y a pas de conflit d'horaire
    // conflit d'horaire se base plus sur le moniteur
    public boolean estDisponible() { return this.statutVoiture == StatutVoiture.D; }
    public boolean estDeLEcole() { return this.plaqueImmatriculation != null; }


    public void updateDepenses(ArrayList<DepenseVoiture> depenses) {
        this.depensesVoiture.clear();

        for (DepenseVoiture depense : depenses) {
            if (depense.getPlaque().equals(this.plaqueImmatriculation)) this.depensesVoiture.add(depense);
        }
    }


    public String getPlaque() { return plaqueImmatriculation; }
    public String getMarque() { return marque; }
    public int getAnnee() { return anneeFabrication; }
    public double getPrix() { return prixAchat; }
    public int getKmAchat() { return kilometrageAchat; }
    public int getKm() { return kilometrageActuel; }
    public ArrayList<DepenseVoiture> getDepensesVoiture() { return depensesVoiture; }

    public StatutVoiture getEtat() { return statutVoiture; }
    public void setEtat(StatutVoiture etat) { this.statutVoiture = etat; }

    @Override
    public String toString() {
        return "Voiture{plaque=" + plaqueImmatriculation +
                ", marque=" + marque +
                ", anneeFabrication=" + anneeFabrication +
                ", prixAchat=" + prixAchat +
                ", kilometrageAchat=" + kilometrageAchat +
                ", statutVoiture=" + statutVoiture.getLibelle() +
                ", kilometrageActuel=" + kilometrageActuel +
                "}";
    }
}
