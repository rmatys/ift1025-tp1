//package notUsed;
//
//public class Moniteur extends Personne {
//
//    public Moniteur(String nom, String prenom, String adresse, String telephone) {
//        super(nom, prenom, adresse, telephone);
//    }
//
//    @Override
//    public String informations() {
//        return "Moniteur{nom=" + nom +
//                ", prenom=" + prenom +
//                ", adresse=" + adresse +
//                ", telephone=" + telephone +
//                "}";
//    }
//
//    public boolean plageHoraireDisponible(PlageHoraire horaire2) {
//        if (horaire2 == null) return true;
//
//        for (Activite activite : activites) {
//            PlageHoraire horaire1 = activite.getPlageHoraire();
//            if (horaire1 != null && horaire1.intersect(horaire2)) return false;
//        }
//        return true;
//    }
//
//    public void ajouterSeance(Activite activite) {
//        if (activite != null) activites.add(activite);
//    }
//}