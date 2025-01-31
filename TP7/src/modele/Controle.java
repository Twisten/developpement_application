package modele;

import java.util.ArrayList;
import java.util.List;

public class Controle {
    private String code;
    private String designation;
    private float coefficient;
    private Type type;
    private List<Etudiant> etudiants;
    private List<Float> notes;

    public Controle(String code, String designation, Type type,
            float coefficient, List<Etudiant> etudiants) {
        this.code = code;
        this.designation = designation;
        this.coefficient = coefficient;
        this.type = type;
        this.etudiants = etudiants;
        this.notes = new ArrayList<>();
        for (int i = 0; i < this.etudiants.size(); i++) {
            this.notes.add(-1F);
        }
    }

    public String getCode() {
        return this.code;
    }

    public Type getType() {
        return this.type;
    }

    public String getDesignation() {
        return this.designation;
    }

    public float getCoefficient() {
        return this.coefficient;
    }

    public float moyenne() {
        float somme = 0.0F;
        for (Float v : this.notes) {
            somme += v;
        }
        return somme / this.notes.size();
    }

    public float moyenne(Groupe groupe) {
        float somme = 0.0F;
        int nbEtudiants = 0;
        for (int i = 0; i < this.etudiants.size(); i++) {
            if (this.etudiants.get(i).getGroupe() == groupe) {
                somme += this.notes.get(i);
                nbEtudiants++;
            }
        }
        if (nbEtudiants == 0) {
            return 0.0F;
        }
        return somme / nbEtudiants;
    }

    public List<Etudiant> getEtudiants(Groupe groupe) {
        List<Etudiant> resultat = new ArrayList<>();
        for (Etudiant e : this.etudiants) {
            if (e.getGroupe() == groupe) {
                resultat.add(e);
            }
        }
        return resultat;
    }

    public List<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    public List<Float> getNotes() {
        return this.notes;
    }

    public List<Float> getNotes(Groupe groupe) {
        List<Float> resultat = new ArrayList<>();
        for (int i = 0; i < this.etudiants.size(); i++) {
            if (this.etudiants.get(i).getGroupe() == groupe) {
                resultat.add(this.notes.get(i));
            }
        }
        return resultat;
    }

    public void setNote(String codeEtu, float note)
            throws IllegalArgumentException {
        if (note < 0.0F || note > 20.0F) {
            throw new IllegalArgumentException("Note invalide");
        }
        boolean trouve = false;
        int i;
        for (i = 0; i < this.etudiants.size() && !trouve; i++) {
            if (this.etudiants.get(i).getCode().equals(codeEtu)) {
                trouve = true;
            }
        }
        if (!trouve) {
            throw new IllegalArgumentException("Code �tudiant invalide");
        }
        this.notes.set(i - 1, note);
    }

    public float getNote(String codeEtu) throws IllegalArgumentException {
        int i;
        boolean trouve = false;
        for (i = 0; i < this.etudiants.size() && !trouve; i++) {
            if (this.etudiants.get(i).getCode().equals(codeEtu)) {
                trouve = true;
            }
        }
        if (!trouve) {
            throw new IllegalArgumentException("Code �tudiant invalide");
        }
        return this.notes.get(i - 1);
    }

}
