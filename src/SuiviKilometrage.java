import java.util.ArrayList;
import java.util.Arrays;

public class SuiviKilometrage {
    private final ArrayList<Kilometrage> suivi = new ArrayList<>();

    public SuiviKilometrage(Kilometrage... kilometrages) {
        suivi.addAll(Arrays.asList(kilometrages));
    }

    public boolean addKilometrage(Kilometrage newKilometrage) {
        int annee = newKilometrage.annee();
        for (Kilometrage kilometrage : suivi) {
            if (annee == kilometrage.annee()) return false;
        }

        suivi.add(newKilometrage);
        return true;
    }
}
