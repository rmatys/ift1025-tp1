import java.lang.reflect.Type;
import java.time.LocalDate;

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

    public Paiement(double montant, LocalDate datePaiement, StatutPaiement statutPaiement,
                    Activite activite, MethodePaiement methodePaiement, Eleve eleve) {
        annee = LocalDate.now().getYear();
        numeroSequentiel++;

        this.idPaiement = prefix + "-" + annee + "-" + numeroSequentiel;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.statutPaiement = statutPaiement;
        this.montantRestant = montant;
        this.activite = activite;
        this.methodePaiement = methodePaiement;
        this.eleve = eleve;
        this.typeActivite = activite.getTypeActivite();
    }

    public String getIdPaiement() { return this.idPaiement; }
    public double getMontant() { return this.montant; }
    public LocalDate getDatePaiement() { return this.datePaiement; }
    public StatutPaiement getStatutPaiement() {return this.statutPaiement; }
    public double getMontantRestant() { return this.montantRestant; }
    public Activite getActivite() { return this.activite; }
    public MethodePaiement getMethodePaiement() { return this.methodePaiement; }
    public Eleve getEleve() { return this.eleve; }
    public TypeActivite getTypeActivite() { return this.typeActivite; }

    public static void setPrefix(char nouveauPrefix) { prefix = nouveauPrefix; }
}
