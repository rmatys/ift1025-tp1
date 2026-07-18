public enum TypeDepenseVoiture {
    R("Réparation"),
    E("Entretien"),
    C("Carburant");

    private final String libelle;

    TypeDepenseVoiture(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return this.libelle; }
}
