public class Activite {
    private static int prochainIdActivite = 0;

    private final int idActivite;
    private final PlageHoraire horaire;
    private final Eleve eleve;
    private final Moniteur moniteur;
    private final Voiture voiture;
    private final TypeActivite typeActivite;
    private StatutActivite statutActivite;

    public Activite(PlageHoraire horaire, Eleve eleve, Moniteur moniteur,
                    Voiture voiture, TypeActivite typeActivite,  StatutActivite statutActivite) {
        this.idActivite = prochainIdActivite;
        this.horaire = horaire;
        this.eleve = eleve;
        this.moniteur = moniteur;
        this.voiture = voiture;
        this.typeActivite = typeActivite;
        this.statutActivite = statutActivite;

        prochainIdActivite++;
    }

    public double getMontant() {

    }

    public int getIdActivite() { return this.idActivite; }
    public PlageHoraire getPlageHoraire() { return this.horaire; }
    public Eleve getEleve() { return this.eleve; }
    public Moniteur getMoniteur() { return this.moniteur; }
    public Voiture getVoiture() { return this.voiture; }
    public TypeActivite getTypeActivite() { return this.typeActivite; }
    public StatutActivite getStatutActivite() { return this.statutActivite; }
    public void setStatutActivite(StatutActivite statut) { this.statutActivite = statutActivite; }
}
