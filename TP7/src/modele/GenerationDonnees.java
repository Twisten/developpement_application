package modele;

import java.util.ArrayList;
import java.util.List;

public class GenerationDonnees {

    public static void main(String[] args) {
        Controles controles = genererDonnees();
    }

    public static Controles genererDonnees() {
        final String[][] tabEtudiants = {
                { "001", "Valentine", "Alexandre", "A", "00.00", "05.00",
                        "00.00" },
                { "002", "Virginie", "Allain", "F", "15.24", "18.06", "15.62" },
                { "003", "Helene", "Aubry", "D", "04.62", "13.07", "03.78" },
                { "004", "Celina", "Auger", "D", "10.31", "13.15", "06.95" },
                { "005", "Arnaude", "Barbier", "D", "09.07", "15.92", "04.42" },
                { "006", "Jerome", "Baron", "E", "08.48", "14.14", "06.97" },
                { "007", "Maurice", "Becker", "C", "02.93", "17.65", "04.19" },
                { "008", "Yves", "Begue", "E", "05.87", "15.62", "07.36" },
                { "009", "Arnaude", "Benoit", "C", "06.41", "10.96", "06.30" },
                { "010", "Sylvie", "Blin", "C", "14.97", "19.11", "11.65" },
                { "011", "Agathe", "Blot", "F", "11.93", "16.98", "12.69" },
                { "012", "Victoire", "Bodin", "A", "15.81", "18.41", "09.33" },
                { "013", "Olivier", "Boulay-Roy", "A", "09.70", "14.53",
                        "07.24" },
                { "014", "Margaud", "Bousquet", "D", "15.19", "14.53",
                        "11.80" },
                { "015", "Thibaut-Xavier", "Boutin", "A", "15.36", "14.94",
                        "13.01" },
                { "016", "Agathe", "Briand-Thibault", "C", "07.61", "14.02",
                        "10.31" },
                { "017", "Lucy", "Brun", "C", "07.75", "13.77", "06.29" },
                { "018", "Arnaude", "Chauvet", "F", "06.45", "12.29", "07.00" },
                { "019", "Lucie Colin", "Colin", "D", "09.52", "12.34",
                        "08.85" },
                { "020", "Gabrielle Collet", "Collet", "B", "05.84", "12.58",
                        "08.44" },
                { "021", "Margot", "Coulon", "A", "15.69", "16.69", "11.72" },
                { "022", "Daisy", "Courtois", "C", "16.50", "19.56", "12.45" },
                { "023", "Jacqueline", "Da Silva", "C", "09.11", "06.75",
                        "07.12" },
                { "024", "Jean", "David", "A", "13.22", "17.84", "11.26" },
                { "025", "Anais", "Delmas", "B", "05.52", "17.97", "07.88" },
                { "026", "Clemence", "De Sousa-Labbe", "F", "16.33", "15.81",
                        "14.36" },
                { "027", "Augustin", "Dumont", "C", "05.17", "15.15", "08.09" },
                { "028", "Alphonse-Lucas", "Ferreira", "A", "08.80", "16.91",
                        "03.83" },
                { "029", "Thibault", "Guyon", "E", "05.44", "10.01", "08.17" },
                { "030", "Marcel", "Imbert-Bodin", "E", "16.00", "18.22",
                        "10.41" },
                { "031", "Celine", "Jacob", "B", "14.54", "12.23", "00.00" },
                { "032", "Auguste", "Jacques", "B", "13.58", "15.75", "08.36" },
                { "033", "Denis", "Labbe", "A", "13.83", "13.77", "09.65" },
                { "034", "Benjamin", "Launay", "F", "13.60", "16.14", "13.73" },
                { "035", "Denis", "Lebon", "D", "07.34", "15.59", "04.54" },
                { "036", "Emile", "Legros", "F", "12.42", "16.26", "14.30" },
                { "037", "Jacqueline", "Le Hamon", "B", "06.46", "09.27",
                        "10.53" },
                { "038", "Hortense", "Lejeune", "B", "00.47", "10.80",
                        "02.49" },
                { "039", "Madeleine", "Lemoine", "B", "10.98", "14.24",
                        "05.83" },
                { "040", "Michelle-Maggie", "Lenoir", "F", "10.23", "18.12",
                        "13.45" },
                { "041", "Frederique", "Leroux", "C", "09.90", "17.55",
                        "09.08" },
                { "042", "Isaac", "Le Roux", "C", "06.06", "18.43", "09.53" },
                { "043", "Xavier", "Letellier de la Girard", "D", "10.56",
                        "14.61", "03.47" },
                { "044", "Bernadette", "Martins", "B", "09.12", "15.43",
                        "11.09" },
                { "045", "Luce", "Martins", "D", "15.91", "14.43", "10.71" },
                { "046", "Theodore", "Marty", "A", "12.41", "16.91", "08.52" },
                { "047", "Camille", "Masson", "B", "06.98", "16.16", "06.42" },
                { "049", "Alice", "Menard du Mendes", "F", "08.98", "12.91",
                        "09.23" },
                { "050", "Claudine", "Meunier", "A", "16.30", "17.42",
                        "00.00" },
                { "051", "Bertrand-Marcel", "Meyer", "E", "02.59", "13.93",
                        "02.83" },
                { "052", "Diane", "Millet", "A", "16.03", "19.00", "09.42" },
                { "053", "Edouard", "Moulin", "D", "00.00", "02.00", "00.00" },
                { "054", "Roland", "Pages-Baron", "C", "08.99", "11.60",
                        "04.39" },
                { "055", "Margaret", "Perez", "F", "09.12", "15.50", "10.10" },
                { "056", "Richard", "Pottier du Bonnet", "F", "16.03", "20.00",
                        "14.13" },
                { "060", "Elodie", "Renaud de la Ferreira", "E", "12.99",
                        "16.22", "11.25" },
                { "061", "Franck", "Rocher", "C", "11.97", "18.97", "11.69" },
                { "062", "Emmanuel", "Sauvage", "A", "18.29", "19.37",
                        "15.67" },
                { "063", "Noemie", "Tanguy", "B", "13.32", "17.41", "12.13" },
                { "064", "Michel-Richard", "Techer", "E", "11.03", "13.83",
                        "10.07" },
                { "065", "Daniel-Richard", "Texier", "B", "11.78", "16.97",
                        "10.94" },
                { "066", "Jerome", "Vincent", "E", "07.66", "15.62", "06.32" }

        };

        final String[][] tabControles = {
                { "R2.01-1", "Traduction TAD en Java", "ECRIT", "0.2" },
                { "R2.01-2", "Programmation objets en Java", "ECRIT", "0.4" },
                { "R2.01-3", "Conception UML", "ECRIT", "0.4" } };

        // création de la liste des étudiants
        List<Etudiant> promotion = new ArrayList<>();
        for (int i = 0; i < tabEtudiants.length; i++) {
            promotion.add(new Etudiant(tabEtudiants[i][0], tabEtudiants[i][2],
                    tabEtudiants[i][1], Groupe.valueOf(tabEtudiants[i][3])));
        }

        // création des contrôles avec les étudiants
        Controles controles = new Controles();
        for (int i = 0; i < tabControles.length; i++) {
            controles.addControle(new Controle(tabControles[i][0],
                    tabControles[i][1], Type.valueOf(tabControles[i][2]),
                    Float.parseFloat(tabControles[i][3]), promotion));
        }

        // ajout des notes pour chaque contrôle
        for (int i = 0; i < controles.getNbControles(); i++) {
            String codeControle = controles.getCodesControles().get(i);
            Controle c = controles.getControle(codeControle);
            for (int j = 0; j < tabEtudiants.length; j++) {
                c.setNote(tabEtudiants[j][0],
                        Float.parseFloat(tabEtudiants[j][i + 4]));
            }
        }
        return controles;
    }

}
