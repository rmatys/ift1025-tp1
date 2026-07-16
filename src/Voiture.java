public class Voiture {
    private final static String PLAQUEIMMATRICULATIONECOLE = "A1A1A1";

    private final String plaqueImmatriculation;
    private final String marque;
    private final int anneeFabrication;
    private final double prixAchat;
    private final Kilometrage kilometrageAchat;
    private StatutVoiture statutVoiture;
    private final SuiviKilometrage suiveKilometrage;
    private final DepenseVoiture depenseVoiture;

    public Voiture(String plaqueImmatriculation, String marque, int anneeFabrication,
                   double prixAchat, Kilometrage kilometrageAchat, StatutVoiture statutVoiture,
                   DepenseVoiture depenseVoiture) {
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
        this.prixAchat = prixAchat;
        this.kilometrageAchat = kilometrageAchat;
        this.statutVoiture = statutVoiture;
        this.suiveKilometrage = new SuiviKilometrage(kilometrageAchat);
        this.depenseVoiture = depenseVoiture;
    }

    // faire attention voiture est disponible s'il n'y a pas de conflit d'horaire
    // conflit d'horaire se base plus sur le moniteur
    public boolean estDisponible() { return this.statutVoiture == StatutVoiture.D; }
    public boolean estDeLEcole() { return this.plaqueImmatriculation.equals(PLAQUEIMMATRICULATIONECOLE); }

    public StatutVoiture getStatutVoiture() { return this.statutVoiture; }
}
