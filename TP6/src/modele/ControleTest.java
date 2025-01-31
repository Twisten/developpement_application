package modele;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControleTest {
    private Controle controle;
    List<Etudiant> etudiants;

    @Before
    public void setUp() throws Exception {
        this.etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("002", "Allain", "Virginie", Groupe.F));
        etudiants.add(new Etudiant("003", "Aubry", "Helene", Groupe.D));
        etudiants.add(new Etudiant("004", "Allain", "Virginie", Groupe.F));
        etudiants.add(new Etudiant("005", "Auger", "Celina", Groupe.D));
        etudiants.add(new Etudiant("006", "Baron", "Jerome", Groupe.E));
        etudiants.add(new Etudiant("007", "Becker", "Maurice", Groupe.C));
        etudiants.add(new Etudiant("008", "Begue", "Yves", Groupe.D));
        etudiants.add(new Etudiant("009", "Benoit", "Arnaude", Groupe.C));
        etudiants.add(new Etudiant("010", "Blin", "Sylvie", Groupe.C));
        this.controle = new Controle("S2.01-1", "SAE prog. Java", Type.ECRIT,
                1F, etudiants);
        this.controle.setNote("002", 12.5F);
        this.controle.setNote("004", 10.F);
        this.controle.setNote("003", 8.5F);
        this.controle.setNote("010", 3.5F);
        this.controle.setNote("006", 14.5F);
        this.controle.setNote("005", 18.5F);
        this.controle.setNote("009", 11.0F);
        this.controle.setNote("007", 12.5F);
        this.controle.setNote("008", 12.5F);

    }

    @After
    public void tearDown() throws Exception {
        this.controle = null;
    }

    @Test
    public void testCode() {
        assertEquals("S2.01-1", controle.getCode());
    }

    @Test
    public void testDesignation() {
        assertEquals("SAE prog. Java", controle.getDesignation());
    }

    @Test
    public void testType() {
        assertEquals(Type.ECRIT, controle.getType());
    }

    @Test
    public void testEtudiants() {
        assertEquals(
                "[[code=002], [code=003], [code=004], [code=005], [code=006], "
                        + "[code=007], [code=008], [code=009], [code=010]]",
                controle.getEtudiants().toString());
    }

    @Test
    public void testNotes() {
        assertEquals("[12.5, 8.5, 10.0, 18.5, 14.5, 12.5, 12.5, 11.0, 3.5]",
                controle.getNotes().toString());
    }

    @Test
    public void testMoyenne() {
        assertEquals(11.5F, controle.moyenne(), 0.0F);
    }

    @Test
    public void testEtudiantsGroupe() {
        assertEquals("[[code=007], [code=009], [code=010]]",
                controle.getEtudiants(Groupe.C).toString());
    }

    @Test
    public void testNotesGroupe() {
        assertEquals("[12.5, 11.0, 3.5]",
                controle.getNotes(Groupe.C).toString());
    }

    @Test
    public void testMoyenneGroupe() {
        assertEquals(9.0F, controle.moyenne(Groupe.C), 0.0F);
    }

    @Test
    public void testMoyenneGroupeVide() {
        assertEquals(0.0F, controle.moyenne(Groupe.A), 0.0F);
    }

    @Test
    public void testSetNote() {
        controle.setNote("003", 19.0F);
        assertEquals(19.0F, controle.getNote("003"), 0.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noteInvalideSuperieureA20() {
        controle.setNote("003", 22F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noteInvalideNegative() {
        controle.setNote("003", -1F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void codeEtudiantInexistant() {
        controle.setNote("012", 18F);
    }

}
