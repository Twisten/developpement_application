package modele;

import java.util.ArrayList;
import java.util.List;

public class Controles {
    private List<Controle> controles;

    public Controles() {
        this.controles = new ArrayList<>();
    }

    public void addControle(Controle controle) {
        this.controles.add(controle);
    }

    public Controle getControle(String code) {
        for (Controle c : this.controles) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    public List<String> getCodesControles() {
        List<String> codes = new ArrayList<>();
        for (Controle c : this.controles) {
            codes.add(c.getCode());
        }
        return codes;
    }

    public int getNbControles() {
        return this.controles.size();
    }

}
