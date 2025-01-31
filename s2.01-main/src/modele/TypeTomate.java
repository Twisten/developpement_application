package modele;

public enum TypeTomate {

    TOUTES("Toutes"), TOMATES_CERISES("Cerises & Cocktails (16)"), TOMATES("Autres Tomates (47)");

    private final String dénomination;

    TypeTomate(String dénomination) {
        this.dénomination = dénomination;
    }

    public static TypeTomate getTypeTomate(String dénomination) {
        for (TypeTomate t : TypeTomate.values()) {
            if (t.getDénomination().equals(dénomination)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return dénomination;
    }

    public String getDénomination() {
        return this.dénomination;
    }

}
