import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CSV {
    public static final int YEAR = LocalDate.now().getYear();

    // Élèves
    public static ArrayList<Eleve> lireEleves() {
        ArrayList<Eleve> eleves = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getDir() + "eleves" + YEAR + ".csv"))) {
            String ligne = br.readLine();

            while ((ligne = br.readLine()) != null) {
                String[] infosEleve = ligne.split(",");

                Long numSaaq = Long.parseLong(infosEleve[0]);
                String nom = infosEleve[1];
                String prenom = infosEleve[2];
                String adresse = infosEleve[3];
                String tel = infosEleve[4];
                LocalDate dateDebut = LocalDate.parse(infosEleve[5], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                LocalDate dateFin = LocalDate.parse(infosEleve[6], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                eleves.add(new Eleve(numSaaq, nom, prenom, adresse, tel, dateDebut, dateFin));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return eleves;
    }

    public static void ecrireEleves(ArrayList<Eleve> eleves) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(getDir() + "eleves" + YEAR + ".csv"))) {

            pw.println("NumSAAQ,Nom,Prenom,Adresse,Telephone,Date,DateFin");

            for (Eleve e : eleves) {
                pw.println(e.getNumSAAQ() + "," +
                           e.getNom() + "," +
                           e.getPrenom() + "," +
                           e.getAdresse() + "," +
                           e.getTelephone() + "," +
                           e.getDateDebut() + "," +
                           e.getDateFin());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Activités
    public static ArrayList<Activite> lireActivites(ArrayList<Eleve> eleves, ArrayList<Voiture> voitures) {

        ArrayList<Activite> activites = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getDir() + "activites" + YEAR + ".csv"))) {
            String ligne = br.readLine();

            while ((ligne = br.readLine()) != null) {
                String[] t = ligne.split(",");

                int idActivite = Integer.parseInt(t[0]);
                String type = t[1];
                long numSAAQ = Long.parseLong(t[2]);
                String date = t[3];
                String heure = t[4];
                int duree = Integer.parseInt(t[5]);
                double montant = Double.parseDouble(t[6]); // je peux juste le recalculer puisque le montant d'une activité suit le tableau dans les instructions
                String statut = t[7];
                String plaque = t[8];

                PlageHoraire horaire = new PlageHoraire(date, heure, duree);
                Eleve eleve = chercherEleve(eleves, numSAAQ);
                Voiture voiture = chercherVoiture(voitures, plaque);
                TypeActivite typeActivite = TypeActivite.valueOf(type);
                StatutActivite statutActivite = StatutActivite.valueOf(statut);

                activites.add(new Activite(idActivite, horaire, eleve, voiture, typeActivite, statutActivite));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return activites;
    }

    public static void ecrireActivites(ArrayList<Activite> activites) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(getDir() + "activites" + YEAR + ".csv"))) {

            pw.println("ID_Activite,Type,NumSAAQ,Date,Heure,Duree,Montant,Statut,Plaque");

            for (Activite activite : activites) {
                pw.println(activite.getId() + "," +
                        activite.getType() + "," +
                        activite.getEleve().getNumSAAQ() + "," +
                        activite.getPlageHoraire().getDate() + "," +
                        activite.getPlageHoraire().getHeureDebut() + "," +
                        activite.getPlageHoraire().getDuree() + "," +
                        activite.getMontant() + "," +
                        activite.getStatut() + "," +
                        activite.getVoiture().getPlaque());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Paiements
    public static ArrayList<Paiement> lirePaiements(ArrayList<Activite> activites, ArrayList<Eleve> eleves) {
        ArrayList<Paiement> paiements = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getDir() + "paiements" + YEAR + ".csv"))) {
            String ligne = br.readLine();

            while ((ligne = br.readLine()) != null) {
                String[] t = ligne.split(",");


                String idPaiement = t[0];
                int idActivite = Integer.parseInt(t[1]);
                long numSAAQ = Long.parseLong(t[2]);
                double montant = Double.parseDouble(t[3]);
                double montantRestant = Double.parseDouble(t[4]);
                LocalDate date = LocalDate.parse(t[5], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                StatutPaiement statut = StatutPaiement.valueOf(t[6]);
                MethodePaiement methode = MethodePaiement.valueOf(t[7]);
                TypeActivite motif = TypeActivite.valueOf(t[8]);

                Activite activite = null;
                for (Activite a : activites) {
                    if (a.getId() == idActivite) activite = a;
                }

                Eleve eleve = null;
                for (Eleve e : eleves) {
                    if (e.getNumSAAQ() == numSAAQ) eleve = e;
                }

                if (activite == null || eleve == null) {
                    System.err.println("Erreur: chaque paiement devrait avoir une activité et un élève. Skipping ID: " + idPaiement);
                    continue;
                }

                paiements.add(new Paiement(idPaiement, montant, date, statut, montantRestant, activite, methode, eleve));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return paiements;
    }

    public static void ecrirePaiements(ArrayList<Paiement> paiements) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(getDir() + "paiements" + YEAR + ".csv"))) {

            pw.println("ID_Paiement,ID_Activite,NumSAAQ,Montant,MontantRestant,Date,Statut,Methode,Motif");

            for (Paiement paiement : paiements) {
                pw.println(paiement.getId() + "," +
                        paiement.getActivite().getId() + "," +
                        paiement.getEleve().getNumSAAQ() + "," +
                        paiement.getMontant() + "," +
                        paiement.getMontantRestant() + "," +
                        paiement.getDate() + "," +
                        paiement.getStatutPaiement() + "," +
                        paiement.getMethodePaiement() + "," +
                        paiement.getTypeActivite());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Voitures
    public static ArrayList<Voiture> lireVoitures(ArrayList<DepenseVoiture> depensesVoiture) {
        ArrayList<Voiture> voitures = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getDir() + "voitures" + YEAR + ".csv"))) {
            String ligne = br.readLine();

            while ((ligne = br.readLine()) != null) {
                String[] t = ligne.split(",");

                String marque = t[0];
                String plaque = t[1];
                int annee = Integer.parseInt(t[2]);
                double prix = Double.parseDouble(t[3]);
                int kmAchat = Integer.parseInt(t[4]);
                String etat = t[5];
                int km = Integer.parseInt(t[6]);

                StatutVoiture statut = StatutVoiture.valueOf(etat);
                ArrayList<DepenseVoiture> depensesVoiturePlaque = filtrerParPlaque(depensesVoiture, plaque);

                voitures.add(new Voiture(plaque, marque, annee, prix, kmAchat, statut, km, depensesVoiturePlaque));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return voitures;
    }

    public static void ecrireVoitures(ArrayList<Voiture> voitures) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(getDir() + "voitures" + YEAR + ".csv"))) {

            pw.println("Marque,Plaque,Annee,Prix,KmAchat,Etat,Km");

            for (Voiture v : voitures) {
                pw.println(v.getMarque() + "," +
                           v.getPlaque() + "," +
                           v.getAnnee() + "," +
                           v.getPrix() + "," +
                           v.getKmAchat() + "," +
                           v.getEtat() + "," +
                           v.getKm());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dépenses voiture
    public static ArrayList<DepenseVoiture> lireDepensesVoiture() {

        ArrayList<DepenseVoiture> depenses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getDir() + "depenses_voiture" + YEAR + ".csv"))) {
            String ligne = br.readLine();

            while ((ligne = br.readLine()) != null) {
                String[] t = ligne.split(",");

                int id = Integer.parseInt(t[0]);
                String plaque = t[1];
                String date = t[2];
                String categorie = t[3];
                String description = t[4];
                double montant = Double.parseDouble(t[5]);

                LocalDate dateDepense = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                TypeDepenseVoiture categorieVoiture = TypeDepenseVoiture.valueOf(categorie);

                depenses.add(new DepenseVoiture(id, plaque, dateDepense, categorieVoiture, description, montant));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return depenses;
    }

    public static void ecrireDepensesVoiture(ArrayList<DepenseVoiture> depenses) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(getDir() + "depenses_voiture" + YEAR + ".csv"))) {

            pw.println("ID_Depense,Plaque,Date,Categorie,Description,Montant");

            for (DepenseVoiture d : depenses) {
                pw.println(d.getId() + "," +
                           d.getPlaque() + "," +
                           d.getDate() + "," +
                           d.getCategorie() + "," +
                           d.getDescription() + "," +
                           d.getMontant());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Autres dépenses
    public static ArrayList<AutreDepense> lireAutresDepenses() {
        ArrayList<AutreDepense> depenses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getDir() + "autres_depenses" + YEAR + ".csv"))) {
            String ligne = br.readLine(); // skip header

            while ((ligne = br.readLine()) != null) {
                String[] t = ligne.split(",");

                int id = Integer.parseInt(t[0]);
                String date = t[1];
                String categorie = t[2];
                String description = t[3];
                double montant = Double.parseDouble(t[4]);

                LocalDate dateDepense = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                TypeAutreDepense typeDepense = TypeAutreDepense.valueOf(categorie);

                depenses.add(new AutreDepense(id, dateDepense, typeDepense, description, montant));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return depenses;
    }

    public static void ecrireAutresDepenses(ArrayList<AutreDepense> depenses) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(getDir() + "autres_depenses" + YEAR + ".csv"))) {

            pw.println("ID_Depense,Date,Categorie,Description,Montant");

            for (AutreDepense d : depenses) {
                pw.println(d.getId() + "," +
                           d.getDate() + "," +
                           d.getCategorie() + "," +
                           d.getDescription() + "," +
                           d.getMontant());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthodes utilitaires
    private static Eleve chercherEleve(ArrayList<Eleve> eleves, long numSAAQ) {
        for (Eleve e : eleves) {
            if (e.getNumSAAQ() == numSAAQ) {
                return e;
            }
        }
        return null;
    }

    private static Voiture chercherVoiture(ArrayList<Voiture> voitures, String plaque) {
        for (Voiture v : voitures) {
            if (v.getPlaque().equals(plaque)) {
                return v;
            }
        }
        return null;
    }

    private static ArrayList<DepenseVoiture> filtrerParPlaque(ArrayList<DepenseVoiture> depenses, String plaque) {
        ArrayList<DepenseVoiture> temp = new ArrayList<>();
        for (DepenseVoiture depense : depenses) {
            if (depense.getPlaque().equals(plaque)) temp.add(depense);
        }

        return temp;
    }

    public static String getDir() {
        return System.getProperty("user.dir") + "\\data\\";
    }
}