public class Activite {
    private static int prochainIdActivite = 0;

    private final int idActivite;
    private final PlageHoraire horaire;
    private final Eleve eleve;
    private final Voiture voiture;
    private final TypeActivite typeActivite;
    private StatutActivite statutActivite;

    public Activite(PlageHoraire horaire, Eleve eleve, Voiture voiture,
                    TypeActivite typeActivite,  StatutActivite statutActivite) {
        this.idActivite = prochainIdActivite;
        this.horaire = horaire;
        this.eleve = eleve;
        this.voiture = voiture;
        this.typeActivite = typeActivite;
        this.statutActivite = statutActivite;

        prochainIdActivite++;
    }

    public Activite(int idActivite, PlageHoraire horaire, Eleve eleve, Voiture voiture,
                    TypeActivite typeActivite,  StatutActivite statutActivite) {
        this.idActivite = idActivite;
        this.horaire = horaire;
        this.eleve = eleve;
        this.voiture = voiture;
        this.typeActivite = typeActivite;
        this.statutActivite = statutActivite;
    }

    public boolean estSansConflitHoraire() {
        return false;
    }

    public double getMontant() {
        double nbrHeures = horaire.getNombreHeure();

        return switch (typeActivite) {
            case LPA, LPZ, LPS -> (voiture.estDeLEcole() ? 75.0 : 50.0) * nbrHeures;
            case LT -> 45.0 * nbrHeures;
            case ET -> 40.0;
            case EP -> 150.0;
            case EPL -> 85.0;
        };
    }

    public int getId() { return this.idActivite; }
    public PlageHoraire getPlageHoraire() { return this.horaire; }
    public Eleve getEleve() { return this.eleve; }
    public Voiture getVoiture() { return this.voiture; }
    public TypeActivite getType() { return this.typeActivite; }
    public StatutActivite getStatut() { return this.statutActivite; }
    public void setStatut(StatutActivite statut) { this.statutActivite = statut; }

    @Override
    public String toString() {
        return "Activité{id=" + idActivite +
                ", date=" + horaire.getDate() +
                ", heure=" + horaire.getHeureDebut() +
                ", durée=" + horaire.getDuree() +
                ", numSaaqEleve=" + eleve.getNumSAAQ() +
                ", plaque=" + voiture.getPlaque() +
                ", type=" + typeActivite.getLibelle() +
                ", statut=" + statutActivite.getLibelle() +
                "}";
    }
}
