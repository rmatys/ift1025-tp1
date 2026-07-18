import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    AutoEcole autoEcole = new AutoEcole();

    void main() {
        autoEcole.chargerEleves();
        autoEcole.chargerActivites();
        autoEcole.chargerDepenses();
        autoEcole.chargerVoitures();

        gestionAutoEcole();

        sauvegarde();
    }

    // Menus

    public void gestionAutoEcole() {
        System.out.println("============================================");
        System.out.println("                AUTO-ÉCOLE");

        while(true) {
            System.out.println("============================================");
            System.out.println("1. Gestion des élèves");
            System.out.println("2. Gestion des activités");
            System.out.println("3. Gestion des paiements");
            System.out.println("4. Gestion des véhicules");
            System.out.println("5. Génération de rapports");
            System.out.println("6. Aide pour les types de valeurs");
            System.out.println("7. Quitter");
            System.out.println("============================================");
            System.out.print("Votre choix: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        gestionEleves();
                        break;
                    case 2:
                        gestionActivites();
                        break;
                    case 3:
                        gestionPaiements();
                        break;
                    case 4:
                        gestionVoiture();
                        break;
                    case 5:
                        gestionRapports();
                        break;
                    case 6:
                        help();
                        continue;
                    case 7:
                        System.out.println("Bonne journée!");
                        return;
                    default:
                        System.out.println("Erreur: il faut un chiffre qui correspond à l'une des options. Réessaie");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Erreur: il faut un chiffre (integer) qui correspond à l'une des options. Réessaie");
            }
        }
    }

    public void gestionEleves() {
        System.out.println("--------------------------------------------");
        System.out.println("            GESTION DES ÉLÈVES");

        while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("1. Inscrire un nouvel élève");
            System.out.println("2. Rechercher un élève");
            System.out.println("3. Supprimer un élève");
            System.out.println("4. Afficher la liste des élèves");
            System.out.println("5. Retour au menu principal");
            System.out.println("--------------------------------------------");
            System.out.print("Votre choix: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        ajoutEleve();
                        break;
                    case 2:
                        rechercheEleve();
                        break;
                    case 3:
                        supprimerEleve();
                        break;
                    case 4:
                        afficherEleves();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Erreur: il faut un chiffre qui correspond à l'une des options. Réessaie");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Erreur: il faut un chiffre (integer) qui correspond à l'une des options. Réessaie");
            }
        }
    }

    public void gestionActivites() {
        System.out.println("--------------------------------------------");
        System.out.println("            GESTION DES ACTIVITÉS");

        while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("1. Planifier une nouvelle activité");
            System.out.println("2. Rechercher une activité");
            System.out.println("3. Modifier une activité");
            System.out.println("4. Annuler une activité");
            System.out.println("5. Marquer une activité comme complétée");
            System.out.println("6. Afficher les activités d'un élève");
            System.out.println("7. Retour au menu principal");
            System.out.println("--------------------------------------------");
            System.out.print("Votre choix: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        ajoutActivite();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Erreur: il faut un chiffre qui correspond à l'une des options. Réessaie");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Erreur: il faut un chiffre (integer) qui correspond à l'une des options. Réessaie");
            }
        }
    }

    public void gestionPaiements() {
        System.out.println("--------------------------------------------");
        System.out.println("            GESTION DES PAIEMENTS");

        while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("1. Générer une facture pour une activité");
            System.out.println("2. Enregistrer un paiement");
            System.out.println("3. Modifier le statut d'un paiement");
            System.out.println("4. Rechercher un paiement");
            System.out.println("5. Afficher les paiements d'un élève");
            System.out.println("6. Afficher les impayés");
            System.out.println("7. Retour au menu principal");
            System.out.println("--------------------------------------------");
            System.out.print("Votre choix: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Erreur: il faut un chiffre qui correspond à l'une des options. Réessaie");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Erreur: il faut un chiffre (integer) qui correspond à l'une des options. Réessaie");
            }
        }
    }

    public void gestionVoiture() {
        System.out.println("--------------------------------------------");
        System.out.println("            GESTION DES VOITURES");

        while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("1. Ajouter une voiture");
            System.out.println("1. Rechercher une voiture");
            System.out.println("2. Modifier l'état d'une voiture");
            System.out.println("3. Enregistrer une dépense");
            System.out.println("4. Mettre à jour le kilométrage");
            System.out.println("5. Afficher l'historique des dépenses");
            System.out.println("6. Afficher la liste des voitures");
            System.out.println("7. Retour au menu principal");
            System.out.println("--------------------------------------------");
            System.out.print("Votre choix: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Erreur: il faut un chiffre qui correspond à l'une des options. Réessaie");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Erreur: il faut un chiffre (integer) qui correspond à l'une des options. Réessaie");
            }
        }
    }

    public void gestionRapports() {
        System.out.println("--------------------------------------------");
        System.out.println("            GESTION DES RAPPORTS");

        while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("1. Rapport des élèves");
            System.out.println("2. Rapport de revenus");
            System.out.println("3. Rapport des dépenses de voiture");
            System.out.println("4. Rapport des autres dépenses");
            System.out.println("5. Retour au menu principal");
            System.out.println("--------------------------------------------");
            System.out.print("Votre choix: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Erreur: il faut un chiffre qui correspond à l'une des options. Réessaie");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Erreur: il faut un chiffre (integer) qui correspond à l'une des options. Réessaie");
            }
        }
    }


    // Ajouts

    public void ajoutEleve() {
        int bonneLongueur = 5;

        while (true) {
            System.out.println("Ajout d'un nouvel élève");
            System.out.println("Donner les informations sous ce format:");
            System.out.println("NumSAAQ,Nom,Prenom,Adresse,Telephone");
            System.out.println("ex: 123456789,Dupont,Marie,adr1,5145551234");
            System.out.print("Votre entrée: ");
            String ligne = scanner.nextLine();

            String[] infosEleve = ligne.split(",");

            if (infosEleve.length != bonneLongueur) {
                System.out.println("Erreur: il faut exactement " + bonneLongueur + " informations séparées par des virgules. Réessaie");
                continue;
            }

            try {
                for (int i=0; i<bonneLongueur; i++) {
                    infosEleve[i] = infosEleve[i].trim();
                }

                long numSAAQ = Long.parseLong(infosEleve[0]);
                String nom = infosEleve[1];
                String prenom = infosEleve[2];
                String adresse = infosEleve[3];
                String tel = infosEleve[4];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String auj = LocalDate.now().format(formatter);
                LocalDate dateAuj = LocalDate.parse(auj, formatter);

                autoEcole.ajouterEleve(new Eleve(numSAAQ, nom, prenom, adresse, tel, dateAuj));
                break;

            } catch (NumberFormatException e) {
                System.out.println("Erreur: le NumSAAQ doit être un nombre valide. Réessaie");
            } catch (Exception e) {
                System.out.println("Erreur: entrée invalide (" + e.getMessage() + "). Réessaie");
            }
        }
    }

    public void ajoutActivite() {
        int bonneLongueur = 7;

        while (true) {
            System.out.println("Ajout d'une nouvelle activité");
            System.out.println("Donner les informations sous ce format:");
            System.out.println("Type,NumSAAQ,Date,Heure,Duree,Statut,Plaque");
            System.out.println("ex: LPA,123456789,12-04-2026,9:00,90,C,ABC123");
            System.out.print("Votre entrée: ");
            String ligne = scanner.nextLine();

            String[] infosActivite = ligne.split(",");

            if (infosActivite.length != bonneLongueur) {
                System.out.println("Erreur: il faut exactement " + bonneLongueur + " informations séparées par des virgules. Réessaie");
                continue;
            }

            try {
                for (int i=0; i<bonneLongueur; i++) {
                    infosActivite[i] = infosActivite[i].trim();
                }

                TypeActivite type = TypeActivite.valueOf(infosActivite[0]);
                long numSAAQ = Long.parseLong(infosActivite[1]);
                LocalDate date = LocalDate.parse(infosActivite[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                LocalTime heure = LocalTime.parse(infosActivite[3], DateTimeFormatter.ofPattern("HH:mm"));
                int duree = Integer.parseInt(infosActivite[4]);
                StatutActivite statut = StatutActivite.valueOf(infosActivite[5]);
                String plaque = infosActivite[6];

                PlageHoraire horaire = new PlageHoraire(date, heure, duree);
                Eleve eleve = autoEcole.rechercherEleve(numSAAQ);
                Voiture voiture = autoEcole.rechercherVoiture(plaque);

                if (eleve == null) {
                    System.out.println("Erreur: aucun élève trouvé avec le NumSAAQ " + numSAAQ + ". Réessaie");
                    continue;
                }

                autoEcole.ajouterActivite(new Activite(horaire, eleve, voiture, type, statut));
                break;

            } catch (NumberFormatException e) {
                System.out.println("Erreur: le NumSAAQ ou la durée doit être un nombre valide. Réessaie");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur: " + e.getMessage() + ". Réessaie");
            }
        }
    }

    public void ajoutDepenseVoiture() {
        int bonneLongueur = 5;

        while (true) {
            System.out.println("Ajout d'une nouvelle dépense pour une voiture de l'école");
            System.out.println("Donner les informations sous ce format:");
            System.out.println("Plaque,Date,Categorie,Description,Montant");
            System.out.println("ex: ABC123,25-05-2026,R,Remplacement freins,350.00");
            System.out.print("Votre entrée: ");
            String ligne = scanner.nextLine();

            String[] infosDepense = ligne.split(",");

            if (infosDepense.length != bonneLongueur) {
                System.out.println("Erreur: il faut exactement " + bonneLongueur + " informations séparées par des virgules. Réessaie");
                continue;
            }

            try {
                for (int i=0; i<bonneLongueur; i++) {
                    infosDepense[i] = infosDepense[i].trim();
                }

                String plaque = infosDepense[0];
                LocalDate date = LocalDate.parse(infosDepense[1], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                TypeDepenseVoiture categorie = TypeDepenseVoiture.valueOf(infosDepense[2]);
                String description = infosDepense[3];
                double montant = Double.parseDouble(infosDepense[4]);

                if (montant < 0) {
                    System.out.println("Erreur: le montant ne peut pas être négatif. Réessaie");
                    continue;
                }

                autoEcole.ajouterDepenseVoiture(new DepenseVoiture(plaque, date, categorie, description, montant));
                break;

            } catch (NumberFormatException e) {
                System.out.println("Erreur: le montant doit être un nombre valide. Réessaie");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur: " + e.getMessage() + ". Réessaie");
            }
        }
    }

    public void ajoutAutreDepense() {
        int bonneLongueur = 4;

        while (true) {
            System.out.println("Ajout d'une nouvelle dépense pour une voiture de l'école");
            System.out.println("Donner les informations sous ce format:");
            System.out.println("Date,Categorie,Description,Montant");
            System.out.println("ex: 25-05-2026,P,Publicité école,350.00");
            System.out.print("Votre entrée: ");
            String ligne = scanner.nextLine();

            String[] infosDepense = ligne.split(",");

            if (infosDepense.length != bonneLongueur) {
                System.out.println("Erreur: il faut exactement " + bonneLongueur + " informations séparées par des virgules. Réessaie");
                continue;
            }

            try {
                for (int i=0; i<bonneLongueur; i++) {
                    infosDepense[i] = infosDepense[i].trim();
                }

                LocalDate date = LocalDate.parse(infosDepense[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                TypeAutreDepense categorie = TypeAutreDepense.valueOf(infosDepense[1]);
                String description = infosDepense[2];
                double montant = Double.parseDouble(infosDepense[3]);

                if (montant < 0) {
                    System.out.println("Erreur: le montant ne peut pas être négatif. Réessaie");
                    continue;
                }

                autoEcole.ajouterAutreDepense(new AutreDepense(date, categorie, description, montant));
                break;

            } catch (NumberFormatException e) {
                System.out.println("Erreur: le montant doit être un nombre valide. Réessaie");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur: " + e.getMessage() + ". Réessaie");
            }
        }
    }

    public void ajoutVoiture() {
        int bonneLongueur = 7;

        while (true) {
            System.out.println("Ajout d'une nouvelle activité");
            System.out.println("Donner les informations sous ce format:");
            System.out.println("Marque,Plaque,Annee,Prix,KmAchat,Etat,Km");
            System.out.println("ex: Toyota,ABC123,2020,25000.00,15000,D,45230");
            System.out.print("Votre entrée: ");
            String ligne = scanner.nextLine();

            String[] infosVoiture = ligne.split(",");

            if (infosVoiture.length != bonneLongueur) {
                System.out.println("Erreur: il faut exactement " + bonneLongueur + " informations séparées par des virgules. Réessaie");
                continue;
            }

            try {
                for (int i=0; i<bonneLongueur; i++) {
                    infosVoiture[i] = infosVoiture[i].trim();
                }

                String marque = infosVoiture[0];
                String plaque = infosVoiture[1];
                int annee = Integer.parseInt(infosVoiture[2]);
                double prix = Double.parseDouble(infosVoiture[3]);
                int kmAchat = Integer.parseInt(infosVoiture[4]);
                StatutVoiture etat = StatutVoiture.valueOf(infosVoiture[5]);
                int km = Integer.parseInt(infosVoiture[6]);

                if (prix < 0 || kmAchat < 0 || km < 0) {
                    System.out.println("Erreur: le prix et le kilométrage ne peuvent pas être négatifs. Réessaie");
                    continue;
                }

                ArrayList<DepenseVoiture> depenses = autoEcole.trouverDepensesVoitureSelonPlaque(plaque);

                autoEcole.ajouterVoiture(new Voiture(marque, plaque, annee, prix, kmAchat, etat, km, depenses));
                break;

            } catch (NumberFormatException e) {
                System.out.println("Erreur: l'année, le prix ou le kilométrage doit être un nombre valide. Réessaie");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur: " + e.getMessage() + ". Réessaie.");
            }
        }
    }


    // Recherche

    public void rechercheEleve() {
        while(true) {
            System.out.println("Recherche d'un élève par son numéro SAAQ");
            System.out.print("Numéro SAAQ: ");

             try {
                 long numSAAQ = scanner.nextLong();
                 scanner.nextLine();

                 Eleve eleve = autoEcole.rechercherEleve(numSAAQ);

                 if (eleve == null) {
                     System.out.println("Aucun élève attaché à ce numéro.");
                     return;
                 }

                 System.out.println(" - " + eleve);

             } catch (Exception e) {
                 System.out.println("Erreur: il faut un numéro (long). Réessaie");
             }
        }
    }

    public void rechercheActivite() {
        while(true) {
            System.out.println("Recherche d'une activité par son ID");
            System.out.print("ID de l'activité: ");

            try {
                int id = scanner.nextInt();
                scanner.nextLine();

                Activite activite = autoEcole.rechercherActivite(id);

                if (activite == null) {
                    System.out.println("Aucune activité attaché à cet identificateur.");
                    return;
                }

                System.out.println(" - " + activite);

            } catch (Exception e) {
                System.out.println("Erreur: il faut un numéro (int). Réessaie");
            }
        }
    }

    public void recherchePaiements() {
        while(true) {
            System.out.println("Recherche d'un paiement par son ID (format \"F-AAAA-XXXXX\")");
            System.out.print("ID: ");

            try {
                String id = scanner.nextLine();

                Paiement paiement = autoEcole.rechercherPaiement(id);

                if (paiement == null) {
                    System.out.println("Aucun paiement attaché à cet identifiant.");
                    return;
                }

                System.out.println(" - " + paiement);

            } catch (Exception e) {
                System.out.println("Erreur: il faut un identifiant (String format \"F-AAAA-XXXXX\"). Réessaie");
            }
        }
    }

    public void rechercheVoiture() {
        while(true) {
            System.out.println("Recherche d'une voiture par sa plaque d'immatriculation");
            System.out.print("Plaque d'immatriculation: ");

            try {
                String plaque = scanner.nextLine();

                Voiture voiture = autoEcole.rechercherVoiture(plaque);

                if (voiture == null) {
                    System.out.println("Voiture de l'extérieur.");
                    return;
                }

                System.out.println(" - " + voiture);

            } catch (Exception e) {
                System.out.println("Erreur: il faut un numéro (long). Réessaie");
            }
        }
    }


    // Supprimer

    public void supprimerEleve() {
        while(true) {
            System.out.println("Recherche d'un élève par son numéro SAAQ");
            System.out.print("Numéro SAAQ: ");

            try {
                long numSAAQ = scanner.nextLong();
                scanner.nextLine();

                Eleve eleve = autoEcole.rechercherEleve(numSAAQ);

                if (eleve == null) {
                    System.out.println("Aucun élève attaché à ce numéro.");
                    return;
                }

                autoEcole.supprimerEleve(numSAAQ);

            } catch (Exception e) {
                System.out.println("Erreur: il faut un numéro (long). Réessaie");
            }
        }
    }


    // Afficher

    public void afficherEleves() {
        System.out.println("Liste de tous les élèves de l'école: ");
        for (Eleve eleve : autoEcole.getEleves()) System.out.println(" - " + eleve);
    }

    // Autres méthodes

    public void help() {
        System.out.println("------------------------------------------------------");
        System.out.println("Voici les règles pour les différents types de valeurs");

        System.out.print("MethodePaiement: ");
        for (MethodePaiement m : MethodePaiement.values()) {
            System.out.print(m + "(" + m.getLibelle() + ") - ");
        }
        System.out.println();

        System.out.print("StatutActivite: ");
        for (StatutActivite s : StatutActivite.values()) {
            System.out.print(s + "(" + s.getLibelle() + ") - ");
        }
        System.out.println();

        System.out.print("StatutPaiement: ");
        for (StatutPaiement s : StatutPaiement.values()) {
            System.out.print(s + "(" + s.getLibelle() + ") - ");
        }
        System.out.println();

        System.out.print("StatutVoiture: ");
        for (StatutVoiture s : StatutVoiture.values()) {
            System.out.print(s + "(" + s.getLibelle() + ") - ");
        }
        System.out.println();

        System.out.print("TypeActivite: ");
        for (TypeActivite t : TypeActivite.values()) {
            System.out.print(t + "(" + t.getLibelle() + ") - ");
        }
        System.out.println();

        System.out.print("TypeAutreDepense: ");
        for (TypeAutreDepense t : TypeAutreDepense.values()) {
            System.out.print(t + "(" + t.getLibelle() + ") - ");
        }
        System.out.println();

        System.out.print("TypeDepenseVoiture: ");
        for (TypeDepenseVoiture t : TypeDepenseVoiture.values()) {
            System.out.print(t + "(" + t.getLibelle() + ") - ");
        }
        System.out.println();

        System.out.println("NumSAAQ: long");
        System.out.println("Téléphone: String");
        System.out.println("Date: format JJ-MM-AAAA");
        System.out.println("Heure: format HH:MM");
        System.out.println("Duree: int (minute)");
        System.out.println("Plaque: String (3 lettres, 3 chiffres)");
        System.out.println("ID: int");
        System.out.println("Montant: double");
        System.out.println("Prix: double");
        System.out.println("Kilomètres: int");

        System.out.println("------------------------------------------------------");
    }

    public void sauvegarde() {
        autoEcole.sauvegarderEleves();
        autoEcole.sauvegarderActivites();
        autoEcole.sauvegarderDepensesVoiture();
        autoEcole.sauvegarderAutresDepenses();
        autoEcole.sauvegarderVoitures();
        System.out.println("Sauvegarde terminée");
    }
}
