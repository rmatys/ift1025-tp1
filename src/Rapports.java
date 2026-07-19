import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rapports {

    public static void genererRapportEleves(ArrayList<Eleve> eleves) {
        File dir = new File(CSV.getDir());
        if (!dir.exists()) dir.mkdirs();
        File f = new File(dir, "rapportEleves" + CSV.YEAR + ".txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            pw.println("Rapport des élèves - " + CSV.YEAR);
            pw.println("Nombre d'élèves : " + eleves.size());
            pw.println();
            for (Eleve e : eleves) {
                pw.println(e.getNumSAAQ() + " - " + e.getNom() + " " + e.getPrenom());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void genererRapportRevenus(ArrayList<Activite> activites, ArrayList<Paiement> paiements) {
        File dir = new File(CSV.getDir());
        if (!dir.exists()) dir.mkdirs();
        File f = new File(dir, "rapportRevenus" + CSV.YEAR + ".txt");
        double totalPercu = 0;
        int nombreLecons = 0;
        int nombreExamens = 0;
        for (Paiement p : paiements) totalPercu += p.getMontant();
        for (Activite activite : activites) {
            TypeActivite typeActivite = activite.getType();
            if (typeActivite == null) continue;
            switch (typeActivite) {
                case LPA:
                case LPZ:
                case LPS:
                case LT:
                    nombreLecons++;
                    break;
                case ET:
                case EP:
                case EPL:
                    nombreExamens++;
                    break;
                default:
                    break;
            }
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            pw.println("Rapport des revenus - " + CSV.YEAR);
            pw.println("Revenus perçus (paiements) : " + String.format("%.2f", totalPercu));
            pw.println("Nombre de leçons : " + nombreLecons);
            pw.println("Nombre d'examens : " + nombreExamens);
            pw.println();
            pw.println("Détail des paiements :");
            for (Paiement paiement : paiements) {
                pw.println(paiement.getId() + " | " + paiement.getDate() + " | " + paiement.getEleve().getNumSAAQ() + " | " + String.format("%.2f", paiement.getMontant()) + " | " + paiement.getStatutPaiement());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void genererRapportDepensesVoiture(ArrayList<DepenseVoiture> depensesVoiture) {
        File dir = new File(CSV.getDir());
        if (!dir.exists()) dir.mkdirs();
        File f = new File(dir, "rapportDepensesVoiture" + CSV.YEAR + ".txt");
        double totalR = 0;
        double totalE = 0;
        double totalC = 0;
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            pw.println("Rapport des dépenses voiture - " + CSV.YEAR);
            for (DepenseVoiture d : depensesVoiture) {
                pw.println(d.getId() + " | " + d.getPlaque() + " | " + d.getDate() + " | " + d.getCategorie() + " | " + d.getDescription() + " | " + String.format("%.2f", d.getMontant()));
                TypeDepenseVoiture categorie = d.getCategorie();
                if (categorie == null) continue;
                switch (categorie) {
                    case R:
                        totalR += d.getMontant();
                        break;
                    case E:
                        totalE += d.getMontant();
                        break;
                    case C:
                        totalC += d.getMontant();
                        break;
                    default:
                        break;
                }
            }
            pw.println();
            pw.println("Totaux par catégorie :");
            pw.println("Réparations (R) : " + String.format("%.2f", totalR));
            pw.println("Entretien (E) : " + String.format("%.2f", totalE));
            pw.println("Carburant (C) : " + String.format("%.2f", totalC));
            pw.println("Total dépenses voiture : " + String.format("%.2f", totalR + totalE + totalC));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void genererRapportAutresDepenses(ArrayList<AutreDepense> autresDepenses) {
        File dir = new File(CSV.getDir());

        if (!dir.exists()) dir.mkdirs();
        File f = new File(dir, "rapportAutresDepenses" + CSV.YEAR + ".txt");
        Map<TypeAutreDepense, Double> totals = new HashMap<>();
        totals.put(TypeAutreDepense.P, 0.0);
        totals.put(TypeAutreDepense.B, 0.0);
        totals.put(TypeAutreDepense.T, 0.0);
        totals.put(TypeAutreDepense.I, 0.0);
        totals.put(TypeAutreDepense.A, 0.0);

        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            pw.println("Rapport des autres dépenses - " + CSV.YEAR);
            for (AutreDepense d : autresDepenses) {
                pw.println(d.getId() + " | " + d.getDate() + " | " + d.getCategorie() + " | " + d.getDescription() + " | " + String.format("%.2f", d.getMontant()));
                TypeAutreDepense categorie = d.getCategorie();
                if (categorie != null && totals.containsKey(categorie)) {
                    totals.put(categorie, totals.get(categorie) + d.getMontant());
                } else {
                    totals.put(TypeAutreDepense.A, totals.get(TypeAutreDepense.A) + d.getMontant());
                }
            }

            pw.println();
            pw.println("Totaux par catégorie :");
            pw.println("Publicité (P) : " + String.format("%.2f", totals.get(TypeAutreDepense.P)));
            pw.println("Bureau (B) : " + String.format("%.2f", totals.get(TypeAutreDepense.B)));
            pw.println("Téléphone (T) : " + String.format("%.2f", totals.get(TypeAutreDepense.T)));
            pw.println("Internet (I) : " + String.format("%.2f", totals.get(TypeAutreDepense.I)));
            pw.println("Autres (A) : " + String.format("%.2f", totals.get(TypeAutreDepense.A)));
            double somme = 0;
            for (double v : totals.values()) somme += v;
            pw.println("Total autres dépenses : " + String.format("%.2f", somme));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}