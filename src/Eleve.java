import java.time.LocalDate;
import java.util.Objects;

public class Eleve extends Personne {
    private final long numSAAQ;
    private final LocalDate dateDebut;
    private LocalDate dateFin;

    public Eleve(long numSAAQ, String prenom, String nom, String adresse, String telephone, LocalDate dateDebut) {
        super(nom, prenom, adresse, telephone);
        this.numSAAQ = numSAAQ;
        this.dateDebut = dateDebut;
        this.dateFin = null;
    }

    public Eleve(long numSAAQ, String prenom, String nom, String adresse, String telephone, LocalDate dateDebut, LocalDate dateFin) {
        super(nom, prenom, adresse, telephone);
        this.numSAAQ = numSAAQ;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public long getNumSAAQ() {
        return this.numSAAQ;
    }

    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    public LocalDate getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eleve)) return false;
        Eleve eleve = (Eleve) o;
        return Objects.equals(this.numSAAQ, eleve.numSAAQ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSAAQ);
    }

    @Override
    public String toString() {
        return "Eleve{numSAAQ=" + numSAAQ +
                ", nom=" + nom +
                ", prenom=" + prenom +
                ", telephone=" + telephone +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                "}";
    }
}