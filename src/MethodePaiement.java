public enum MethodePaiement {
    ESPECE("Espèces"),
    CARTE("Carte"),
    VIREMENT("Virement");

    private final String libelle;

    MethodePaiement(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return this.libelle; }
}
