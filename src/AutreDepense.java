import java.time.LocalDate;

public class AutreDepense {
    private final int idDepense;
    private final LocalDate date;
    private final TypeAutreDepense typeAutreDepense;
    private final String description;
    private final double montant;

    public AutreDepense(int idDepense, LocalDate date, TypeAutreDepense typeAutreDepense,
                        String description, double montant) {
        this.idDepense = idDepense;
        this.date = date;
        this.typeAutreDepense = typeAutreDepense;
        this.description = description.replace(',', '.');
        this.montant = montant;
    }

    public int getId() { return idDepense; }
    public LocalDate getDate() { return date; }
    public TypeAutreDepense getCategorie() { return typeAutreDepense; }
    public String getDescription() { return description; }
    public double getMontant() { return montant; }

    @Override
    public String toString() {
        return "AutreDepense{id=" + idDepense +
                ", date=" + date +
                ", type=" + typeAutreDepense.getLibelle() +
                ", description=" + description +
                ", montant=" + montant +
                "}";
    }
}
