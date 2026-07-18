import java.time.LocalDate;

public class DepenseVoiture {
    private static int prochainIdDepense = 0;

    private final int idDepense;
    private final String plaque;
    private final LocalDate date;
    private final TypeDepenseVoiture typeDepenseVoiture;
    private final String description;
    private final double montant;

    public DepenseVoiture(String plaque, LocalDate date,
                          TypeDepenseVoiture typeDepenseVoiture, String description,
                          double montant) {
        this.idDepense = prochainIdDepense;
        this.plaque = plaque;
        this.date = date;
        this.typeDepenseVoiture = typeDepenseVoiture;
        this.description = description.replace(',', '.');
        this.montant = montant;

        prochainIdDepense++;
    }

    public DepenseVoiture(int idDepense, String plaque, LocalDate date,
                          TypeDepenseVoiture typeDepenseVoiture, String description,
                          double montant) {
        this.idDepense = idDepense;
        this.plaque = plaque;
        this.date = date;
        this.typeDepenseVoiture = typeDepenseVoiture;
        this.description = description.replace(',', '.');
        this.montant = montant;
    }

    public int getId() { return idDepense; }
    public String getPlaque() { return plaque; }
    public LocalDate getDate() { return date; }
    public TypeDepenseVoiture getCategorie() { return typeDepenseVoiture; }
    public String getDescription() { return description; }
    public double getMontant() { return montant; }

    @Override
    public String toString() {
        return "AutreDepense{id=" + idDepense +
                ", plaque=" + plaque +
                ", date=" + date +
                ", type=" + typeDepenseVoiture.getLibelle() +
                ", description=" + description +
                ", montant=" + montant +
                "}";
    }
}
