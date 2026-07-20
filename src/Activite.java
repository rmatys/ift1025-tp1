public class Activite {
    private final int idActivite;
    private final PlageHoraire horaire;
    private final Eleve eleve;
    private final String plaqueVoiture;
    private final TypeActivite typeActivite;
    private StatutActivite statutActivite;

    public Activite(int idActivite, PlageHoraire horaire, Eleve eleve, String plaqueVoiture,
                    TypeActivite typeActivite,  StatutActivite statutActivite) {
        this.idActivite = idActivite;
        this.horaire = horaire;
        this.eleve = eleve;
        this.plaqueVoiture = plaqueVoiture;
        this.typeActivite = typeActivite;
        this.statutActivite = statutActivite;
    }

    public double getMontant() {
        double nbrHeures = horaire.getNombreHeure();

        return switch (typeActivite) {
            case LPA, LPZ, LPS -> ((!plaqueVoiture.isBlank()) ? 75.0 : 50.0) * nbrHeures;
            case LT -> 45.0 * nbrHeures;
            case ET -> 40.0;
            case EP -> 150.0;
            case EPL -> 85.0;
        };
    }

    public int getId() { return this.idActivite; }
    public PlageHoraire getPlageHoraire() { return this.horaire; }
    public Eleve getEleve() { return this.eleve; }
    public String getPlaque() { return this.plaqueVoiture; }
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
                ", plaque=" + plaqueVoiture +
                ", type=" + typeActivite.getLibelle() +
                ", statut=" + statutActivite.getLibelle() +
                "}";
    }
}
