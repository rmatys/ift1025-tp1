public enum MethodePaiement {
    E("Espèces"),
    C("Carte"),
    V("Virement");

    private final String libelle;

    MethodePaiement(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return this.libelle; }
}
