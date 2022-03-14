package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.*;

public class TestDamier {
	static int nbTests;

	Damier damier;

	@Before
	public void init() {
		System.out.println("Initialisation de la méthode TestDamier #" + (++TestCase.nbTests));
		damier = new Damier();
	}

	@Test
	public void piecesEntre_pasDiagonale() {
		Case orig, dest;

		orig = damier.getCase(2, 3);
		dest = damier.getCase(0, 2);
		orig.setPiece(new Pion(Couleur.BLANC)); // juste pour l'affichage
		dest.setPiece(new Pion(Couleur.BLANC)); // juste pour l'affichage
		System.out.println(damier.joliString());

		Assert.assertEquals(damier.piecesEntre(orig, dest), null);
	}
}
