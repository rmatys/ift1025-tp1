public enum StatutPaiement {
    P("Payé"),
    I("Impayé"),
    PP("Partiellement payé");

    private final String libelle;

    StatutPaiement(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return this.libelle; }
}
