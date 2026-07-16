import java.time.LocalDate;
import java.time.LocalTime;

public class PlageHoraire {
    private LocalDate date;
    private LocalTime heureDebut;
    private int duree;

    public boolean intersect(PlageHoraire horaire) {
        if (datesDifferente(this, horaire)) return false;
        return this.heureDebut.isBefore(horaire.getHeureFin())
                && this.getHeureFin().isAfter(horaire.getHeureDebut());
    }

    @Override
    public String toString() {
        return date + " " + heureDebut + "-" + this.getHeureFin();
    }

    public LocalDate getDate() { return this.date; }
    public LocalTime getHeureDebut() { return this.heureDebut; }
    public LocalTime getHeureFin() { return this.heureDebut.plusMinutes(duree); }
    public int getDuree() { return duree; }
    public double getDureeHeure() { return (double) duree / 60; }

    public static boolean datesDifferente(PlageHoraire horaire1, PlageHoraire horaire2) {
        return !horaire1.date.isEqual(horaire2.getDate());
    }
}
