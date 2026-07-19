import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PlageHoraire {
    private final LocalDate date;
    private final LocalTime heureDebut;
    private final int duree;

    public PlageHoraire(LocalDate date, LocalTime heureDebut, int duree) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.duree = duree;
    }

    public PlageHoraire(String date, String heureDebut, int duree) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.heureDebut = LocalTime.parse(heureDebut, DateTimeFormatter.ofPattern("HH:mm"));
        this.duree = duree;
    }

    public boolean estEnConflitHoraire(ArrayList<PlageHoraire> horaires) {
        for (PlageHoraire horaire : horaires) {
            if (this.intersect(horaire)) return true;
        }
        return false;
    }

    public boolean intersect(PlageHoraire horaire) {
        if (datesDifferente(this, horaire)) return false;
        return this.heureDebut.isBefore(horaire.getHeureFin())
                && this.getHeureFin().isAfter(horaire.getHeureDebut());
    }

    public static boolean datesDifferente(PlageHoraire horaire1, PlageHoraire horaire2) {
        return !horaire1.date.isEqual(horaire2.getDate());
    }

    public LocalDate getDate() { return this.date; }
    public LocalTime getHeureDebut() { return this.heureDebut; }
    public LocalTime getHeureFin() { return this.heureDebut.plusMinutes(duree); }
    public int getDuree() { return duree; }
    public double getNombreHeure() { return (double) duree / 60; }

    @Override
    public String toString() {
        return date + " " + heureDebut + "-" + this.getHeureFin();
    }
}
