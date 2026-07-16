public enum StatutVoiture {
    R("Réparation"),
    V("Vendu"),
    D("Disponible");

    private final String libelle;

    StatutVoiture(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return this.libelle; }
}
