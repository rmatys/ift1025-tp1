import java.time.LocalDate;
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
        sauvegarderEleves();
    }

    public void supprimerEleve(long numSAAQ) {
        eleves.removeIf(eleve -> eleve.getNumSAAQ() == numSAAQ);
        sauvegarderEleves();
    }

    public Eleve rechercherEleve(long numSAAQ) {
        for (Eleve eleve : eleves) {
            if (eleve.getNumSAAQ() == numSAAQ) {
                return eleve;
            }
        }
        return null;
    }


    // Méthodes de gestion des activités

    public void ajouterActivite(Activite activite) {
        activites.add(activite);
        sauvegarderActivites();
    }

    public void annulerActivite(int id) {
        activites.removeIf(activite -> activite.getId() == id);
        sauvegarderActivites();
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
        sauvegarderActivites();
    }

    public int prochainIdActivite() {
        int max = 0;
        for (Activite activite : activites) {
            max = Math.max(activite.getId(), max);
        }
        return max + 1;
    }


    // Méthodes de gestion des paiements

    public void ajouterPaiement(Paiement paiement) {
        paiements.add(paiement);
        sauvegarderPaiements();
    }

    public Paiement rechercherPaiement(String id) {
        for (Paiement paiement : paiements) {
            if (paiement.getId().equals(id)) {
                return paiement;
            }
        }
        return null;
    }


    // Méthodes de gestion des voitures

    public void ajouterVoiture(Voiture voiture) {
        voitures.add(voiture);
        sauvegarderVoitures();
    }

    public Voiture rechercherVoiture(String plaque) {
        for (Voiture voiture : voitures) {
            if (voiture.getPlaque().equals(plaque)) {
                return voiture;
            }
        }
        return null;
    }


    // Méthodes de gestion des dépenses

    public void ajouterDepenseVoiture(DepenseVoiture depense) {
        depensesVoiture.add(depense);
        sauvegarderDepensesVoiture();
    }
    public void ajouterAutreDepense(AutreDepense depense) {
        autresDepenses.add(depense);
        sauvegarderAutresDepenses();
    }

    public ArrayList<DepenseVoiture> trouverDepensesVoitureSelonPlaque(String plaque) {
        ArrayList<DepenseVoiture> depensesVoiturePlaque = new ArrayList<>();

        for (DepenseVoiture depense : this.depensesVoiture) {
            if (depense.getPlaque().equals(plaque)) depensesVoiturePlaque.add(depense);
        }

        return depensesVoiturePlaque;
    }

    public int prochainIdDepenseVoiture() {
        int max = 0;
        for (DepenseVoiture depense : depensesVoiture) {
            max = Math.max(depense.getId(), max);
        }
        return max + 1;
    }

    public int prochainIdAutreDepense() {
        int max = 0;
        for (AutreDepense depense : autresDepenses) {
            max = Math.max(depense.getId(), max);
        }
        return max + 1;
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

    public ArrayList<Eleve> getEleves() { return eleves; }
    public ArrayList<Activite> getActivites() { return activites; }
    public ArrayList<Paiement> getPaiements() { return paiements; }
    public ArrayList<Voiture> getVoitures() { return voitures; }
    public ArrayList<DepenseVoiture> getDepensesVoiture() { return depensesVoiture; }
    public ArrayList<AutreDepense> getAutresDepenses() { return autresDepenses; }
}