import java.time.LocalDate;

/**
 * Création d'un paiement lorsque l'activité est
 */
public class Paiement {
    private final String idPaiement;
    private final double montant;
    private LocalDate datePaiement;
    private StatutPaiement statutPaiement;
    private double montantRestant;
    private final Activite activite;
    private final MethodePaiement methodePaiement;
    private final Eleve eleve;
    private final TypeActivite typeActivite;

    public Paiement(int numeroSequentiel, LocalDate datePaiement, StatutPaiement statutPaiement, Activite activite,
                    MethodePaiement methodePaiement, Eleve eleve) {
        double montant = activite.getMontant();
        double montantRestant = -1;
        if (statutPaiement.equals(StatutPaiement.P)) {
            montantRestant = 0.0;
        } else if (statutPaiement.equals(StatutPaiement.PP)) {
            montantRestant = montant;
        } else if (statutPaiement.equals(StatutPaiement.I)) {
            montantRestant = montant;
        } else {
            System.err.println("Erreur: Stuatut du paiement manquant, valeur donnée : " + statutPaiement);
        }

        this.idPaiement = "F-" + LocalDate.now().getYear() + "-" + String.format("%05d", numeroSequentiel);
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.statutPaiement = statutPaiement;
        this.montantRestant = montantRestant;
        this.activite = activite;
        this.methodePaiement = methodePaiement;
        this.eleve = eleve;
        this.typeActivite = activite.getType();
    }

    public Paiement(String id, double montant, LocalDate datePaiement,
                    StatutPaiement statutPaiement, double montantRestant,
                    Activite activite, MethodePaiement methodePaiement, Eleve eleve) {
        this.idPaiement = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.statutPaiement = statutPaiement;
        this.montantRestant = montantRestant;
        this.activite = activite;
        this.methodePaiement = methodePaiement;
        this.eleve = eleve;
        this.typeActivite = activite.getType();
    }

    public String getId() { return this.idPaiement; }
    public double getMontant() { return this.montant; }
    public LocalDate getDate() { return this.datePaiement; }
    public StatutPaiement getStatutPaiement() {return this.statutPaiement; }
    public double getMontantRestant() { return this.montantRestant; }
    public Activite getActivite() { return this.activite; }
    public MethodePaiement getMethodePaiement() { return this.methodePaiement; }
    public Eleve getEleve() { return this.eleve; }
    public TypeActivite getTypeActivite() { return this.typeActivite; }

    public void setEtat(StatutPaiement statut) { this.statutPaiement = statut; }
    public void setMontantRestant(double montantRestant) { this.montantRestant = montantRestant; }
    public void setDate(LocalDate datePaiement) { this.datePaiement = datePaiement; }

    @Override
    public String toString() {
        return "Paiement{id=" + idPaiement +
                ", montant=" + montant +
                ", montantRestant=" + montantRestant +
                ", datePaiement=" + datePaiement +
                ", statut=" + statutPaiement +
                ", typeActivite=" + typeActivite +
                ", numSaaqEleve=" + eleve.getNumSAAQ() +
                "}";
    }
}
