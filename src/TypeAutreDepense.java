public enum TypeAutreDepense {
    P("Publicité"),
    B("Bureau"),
    T("Téléphone"),
    I("Internet"),
    A("Autre");

    private final String libelle;

    TypeAutreDepense(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return this.libelle; }
}
