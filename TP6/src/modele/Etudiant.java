package modele;

public class Etudiant {
    private String code;
    private String nom;
    private String prenom;
    private Groupe groupe;

    public String getCode() {
        return this.code;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public Groupe getGroupe() {
        return this.groupe;
    }

    public Etudiant(String code, String nom, String prenom, Groupe groupe) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "[code=" + this.code + "]";
    }

}
