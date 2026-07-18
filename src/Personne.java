import java.util.ArrayList;
import java.util.Objects;

public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String telephone;
    protected ArrayList<Activite> activites;

    public Personne(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.activites = new ArrayList<>();
    }

    public String nomComplet() { return this.prenom + " " + this.nom; }

    public void ajouterActivites(Activite activite) {
        if (activite != null) activites.add(activite);
    }
    public ArrayList<Activite> getActivites() {
        return activites;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() { return this.adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}