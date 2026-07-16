public enum StatutActivite {
    C("complétée"),
    NC("non complétée");

    private final String libelle;

    StatutActivite(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return libelle; }
}
