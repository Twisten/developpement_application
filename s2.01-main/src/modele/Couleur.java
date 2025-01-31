package modele;

public enum Couleur {

    TOUTES("Toutes"), BLEU("Bleu"), VERT("Vert"), ROUGE("Rouge"), ORANGE("Orange"), JAUNE("Jaune"), NOIR("Noir"), MULTICOLORE("Multicolore");
    private final String dénomination;

    Couleur(String dénomination) {
        this.dénomination = dénomination;
    }

    public static Couleur getCouleur(String dénomination) {
        for (Couleur c : Couleur.values()) {
            if (c.getDénomination().equals(dénomination)) {
                return c;
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
