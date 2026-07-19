import java.time.LocalDate;
import java.util.Objects;

public class Eleve {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private final long numSAAQ;
    private final LocalDate dateDebut;
    private LocalDate dateFin;

    public Eleve(long numSAAQ, String prenom, String nom, String adresse, String telephone, LocalDate dateDebut) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.numSAAQ = numSAAQ;
        this.dateDebut = dateDebut;
        this.dateFin = null;
    }

    public Eleve(long numSAAQ, String prenom, String nom, String adresse, String telephone, LocalDate dateDebut, LocalDate dateFin) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.numSAAQ = numSAAQ;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getPrenom() {
        return prenom;
    }
    public String getNom() {
        return nom;
    }
    public String getAdresse() { return this.adresse; }
    public String getTelephone() {
        return telephone;
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