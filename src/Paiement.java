import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Création d'un paiement lorsque l'activité est
 */
public class Paiement {
    private static char prefix = 'F';
    private static int annee;
    private static int numeroSequentiel = -1;

    private final String idPaiement;
    private final double montant;
    private final LocalDate datePaiement;
    private StatutPaiement statutPaiement;
    private double montantRestant;
    private final Activite activite;
    private final MethodePaiement methodePaiement;
    private final Eleve eleve;
    private final TypeActivite typeActivite;

    public Paiement(LocalDate datePaiement, StatutPaiement statutPaiement, Activite activite,
                    MethodePaiement methodePaiement, Eleve eleve) {
        annee = LocalDate.now().getYear();
        numeroSequentiel++;

        this.idPaiement = prefix + "-" + annee + "-" + numeroSequentiel;
        this.montant = activite.getMontant();
        this.datePaiement = datePaiement;
        this.statutPaiement = statutPaiement;
        this.montantRestant = activite.getMontant();
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

    public static void setPrefix(char nouveauPrefix) { prefix = nouveauPrefix; }

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
