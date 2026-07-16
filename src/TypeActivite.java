public enum TypeActivite {
    LPA("Leçon Pratique sur Autoroute"),
    LPZ("Leçon Pratique dans Zone résidentielle"),
    LPS("Leçon Pratique de Stationnement"),
    LT("Leçon Théorique"),
    ET("Examen Théorique"),
    EP("Examen Pratique"),
    EPL("Examen Pratique avec location");

    private final String libelle;

    TypeActivite(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return this.libelle; }
}
