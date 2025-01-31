package modele;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Tests {
	private Tomates mesArticles;
	private List<Tomate> tomates;
	private Panier panier;

	@Before
	public void setUp() {
		mesArticles = GenerationArticles.générationDeBaseDesTomates();
		tomates = mesArticles.getLesTomates();
		panier = new Panier();
	}

	@Test
	public void testFiltreTypeCerise() {
		List<Tomate> tomatesCerises = new ArrayList<>();
		for (Tomate t : tomates) {
			if (t.getTypeGraine() == TypeTomate.TOMATES_CERISES) {
				tomatesCerises.add(t);
			}
		}
		assertEquals(tomatesCerises, mesArticles.tomatesDeType(TypeTomate.TOMATES_CERISES));
	}

	@Test
	public void testFiltreTypeCouleurBleu() {
		List<Tomate> tomatesCouleurBleu = new ArrayList<>();
		for (Tomate t : tomates) {
			if (t.getCouleur() == Couleur.BLEU) {
				tomatesCouleurBleu.add(t);
			}
		}
		assertEquals(tomatesCouleurBleu, mesArticles.tomatesDeCouleur(Couleur.BLEU));
	}

	@Test
	public void testAjoutPanier() {
		Tomate tomate = new Tomate(TypeTomate.TOMATES, Couleur.NOIR, "Tomate Noire de Crimée", null, "Noire_Crimee-1",
				"Résistante à la sécheresse. Beaux fruits de 120-150 g pouvant même atteindre 500 g. \r\n" + "\r\n"
						+ "Peau lisse devenant rouge trés sombre à pourpre à maturité. Sa chair est dense, son goût puissant et sucré.\r\n"
						+ "\r\n" + "Une variété locale lui ressemble beaucoup : La Charbonnière du Berry, extra !",
				50, 3.85F);
		panier.ajouterArticle(tomate, 1);
		assertEquals(panier.prixTotal(), 8.35f, 0.01f);
	}

	@Test
	public void testModificationPanier() {
		Tomate tomate = new Tomate(TypeTomate.TOMATES, Couleur.NOIR, "Tomate Noire de Crimée", null, "Noire_Crimee-1",
				"Résistante à la sécheresse. Beaux fruits de 120-150 g pouvant même atteindre 500 g. \r\n" + "\r\n"
						+ "Peau lisse devenant rouge trés sombre à pourpre à maturité. Sa chair est dense, son goût puissant et sucré.\r\n"
						+ "\r\n" + "Une variété locale lui ressemble beaucoup : La Charbonnière du Berry, extra !",
				50, 3.85F);
		panier.ajouterArticle(tomate, 2);
		panier.modifierQuantitéArticle(tomate, 1);
		assertEquals(panier.prixTotal(), 8.35f, 0.01f);
	}

	@Test
	public void testSuppressionPanier() {
		Tomate tomate = new Tomate(TypeTomate.TOMATES, Couleur.NOIR, "Tomate Noire de Crimée", null, "Noire_Crimee-1",
				"Résistante à la sécheresse. Beaux fruits de 120-150 g pouvant même atteindre 500 g. \r\n" + "\r\n"
						+ "Peau lisse devenant rouge trés sombre à pourpre à maturité. Sa chair est dense, son goût puissant et sucré.\r\n"
						+ "\r\n" + "Une variété locale lui ressemble beaucoup : La Charbonnière du Berry, extra !",
				50, 3.85F);
		panier.ajouterArticle(tomate, 3);
		panier.vider();
		assertEquals(0, panier.prixTotal(), 0.01f);
	}
}
