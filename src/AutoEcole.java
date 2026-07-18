import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AutoEcole {
    private ArrayList<Eleve> eleves;
    private ArrayList<Activite> activites;
    private ArrayList<Paiement> paiements;
    private ArrayList<Voiture> voitures;
    private ArrayList<DepenseVoiture> depensesVoiture;
    private ArrayList<AutreDepense> autresDepenses;

    public AutoEcole() {
        this.eleves = new ArrayList<>();
        this.activites = new ArrayList<>();
        this.paiements = new ArrayList<>();
        this.voitures = new ArrayList<>();
        this.depensesVoiture = new ArrayList<>();
        this.autresDepenses = new ArrayList<>();
    }


    // Méthodes de gestion des élèves

    public void ajouterEleve(Eleve eleve) {
        eleves.add(eleve);
    }

    public void supprimerEleve(long numSAAQ) {
        eleves.removeIf(eleve -> eleve.getNumSAAQ() == numSAAQ);
    }

    public Eleve rechercherEleve(long numSAAQ) {
        for (Eleve eleve : eleves) {
            if (eleve.getNumSAAQ() == numSAAQ) {
                return eleve;
            }
        }
        return null;
    }

    public void modifierEleve(Eleve updated) {
        for (int i = 0; i < eleves.size(); i++) {
            if (eleves.get(i).equals(updated)) {
                eleves.set(i, updated);
            }
        }
    }


    // Méthodes de gestion des activités

    public void ajouterActivite(Activite activite) {
    activites.add(activite);
    }

    public void annulerActivite(int id) {
        activites.removeIf(activite -> activite.getId() == id);
    }

    public Activite rechercherActivite(int id) {
        for (Activite activite : activites) {
            if (activite.getId() == id) {
                return activite;
            }
        }
        return null;
    }

    public void completerActivite(int id) {
        Activite activite = rechercherActivite(id);
        if (activite != null) {
            activite.setStatut(StatutActivite.C);

            TypeActivite type = activite.getType();
            if (type.equals(TypeActivite.EP) || type.equals(TypeActivite.EPL)) {
                activite.getEleve().setDateFin(LocalDate.now());
            }
        }
    }


    // Méthodes de gestion des paiements

    public void ajouterPaiement(Paiement paiement) { paiements.add(paiement); }

    public Paiement rechercherPaiement(String id) {
        for (Paiement paiement : paiements) {
            if (paiement.getId().equals(id)) {
                return paiement;
            }
        }
        return null;
    }

    public ArrayList<Paiement> paiementsEleve(Eleve eleve) {
        ArrayList<Paiement> res = new ArrayList<>();
        for (Paiement paiement : paiements) {
            if (paiement.getEleve().equals(eleve)) {
                res.add(paiement);
            }
        }
        return res;
    }


    // Méthodes de gestion des voitures

    public void ajouterVoiture(Voiture voiture) { voitures.add(voiture); }

    public Voiture rechercherVoiture(String plaque) {
        for (Voiture voiture : voitures) {
            if (voiture.getPlaque().equals(plaque)) {
                return voiture;
            }
        }
        return null;
    }

    public void changerEtatVoiture(String plaque, StatutVoiture etat) {
        Voiture voiture = rechercherVoiture(plaque);
        if (voiture != null) {
            voiture.setEtat(etat);
        }
    }


    // Méthodes de gestion des dépenses

    public void ajouterDepenseVoiture(DepenseVoiture depense) { depensesVoiture.add(depense); }
    public void ajouterAutreDepense(AutreDepense depense) { autresDepenses.add(depense); }

    public ArrayList<DepenseVoiture> trouverDepensesVoitureSelonPlaque(String plaque) {
        ArrayList<DepenseVoiture> depensesVoiturePlaque = new ArrayList<>();

        for (DepenseVoiture depense : this.depensesVoiture) {
            if (depense.getPlaque().equals(plaque)) depensesVoiturePlaque.add(depense);
        }

        return depensesVoiturePlaque;
    }


    // Lecture des fichiers CSV

    public void chargerEleves() { eleves = CSV.lireEleves(); }
    public void chargerVoitures() { voitures = CSV.lireVoitures(depensesVoiture); }
    public void chargerPaiements() { paiements = CSV.lirePaiements(activites, eleves); }
    public void chargerActivites() { activites = CSV.lireActivites(eleves,voitures); }
    public void chargerDepenses() {
        depensesVoiture = CSV.lireDepensesVoiture();
        autresDepenses = CSV.lireAutresDepenses();
    }

    // Sauvegarde

    public void sauvegarderEleves() { CSV.ecrireEleves(eleves); }
    public void sauvegarderActivites() { CSV.ecrireActivites(activites); }
    public void sauvegarderPaiements() { CSV.ecrirePaiements(paiements);}
    public void sauvegarderDepensesVoiture() { CSV.ecrireDepensesVoiture(depensesVoiture); }
    public void sauvegarderAutresDepenses() { CSV.ecrireAutresDepenses(autresDepenses); }
    public void sauvegarderVoitures() {
        CSV.ecrireVoitures(voitures);
    }


    // Rapports
    
    public void genererRapportEleves() {
        Rapports.genererRapportEleves(eleves, "Rapports", 2026);
    }
    public void genererRapportRevenus() {
        Rapports.genererRapportRevenus(activites, paiements, "Rapports", 2026);
    }

    public void genererRapportDepensesVoiture() {
        Rapports.genererRapportDepensesVoiture(depensesVoiture, "Rapports", 2026);
    }

    public void genererRapportAutresDepenses() {
        Rapports.genererRapportAutresDepenses(autresDepenses, "Rapports", 2026);
    }


    // Méthodes utilitaires

    public double calculerRevenus() {
        double total = 0;
        for (Activite activite : activites) {
            total += activite.getMontant();
        }
        
        for (Paiement paiement : paiements) {
            total += paiement.getMontant();
        }
        return total;
    }

    public double calculerDepenses() {
        double total = 0;
        for (DepenseVoiture depense : depensesVoiture) {
            total += depense.getMontant();
        }
    
        for (AutreDepense depense : autresDepenses) {
            total += depense.getMontant();
        }
        return total;
    }

    public double benefice() { return calculerRevenus() - calculerDepenses(); }
    public int nombreElevesActifs() { return eleves.size(); }
    public int nombreActivites() { return activites.size(); }
    public int nombrePaiements() { return paiements.size(); }

    public ArrayList<Eleve> getEleves() { return eleves; }
    public ArrayList<Activite> getActivites() { return activites; }
    public ArrayList<Paiement> getPaiements() { return paiements; }
    public ArrayList<Voiture> getVoitures() { return voitures; }
    public ArrayList<DepenseVoiture> getDepensesVoiture() { return depensesVoiture; }
    public ArrayList<AutreDepense> getAutresDepenses() { return autresDepenses; }
}