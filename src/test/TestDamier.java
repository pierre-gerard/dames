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

	@Test
	public void piecesEntre_memeCase() {
		Case c;

		c = damier.getCase(2, 3);
		c.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage
		System.out.println(damier.joliString());

		Assert.assertEquals(damier.piecesEntre(c, c).size(), 0);
	}

	@Test
	public void piecesEntre_aCote() {
		Case orig, dest;

		orig = damier.getCase(2, 3);
		dest = damier.getCase(1, 2);
		orig.setPiece(new Pion(Couleur.BLANC)); // juste pour l'affichage
		dest.setPiece(new Pion(Couleur.BLANC)); // juste pour l'affichage
		System.out.println(damier.joliString());

		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 0);
	}

	@Test
	public void piecesEntre_versBasDroite() {
		Case orig, dest;

		orig = damier.getCase(2, 3);
		dest = damier.getCase(6, 7);
		orig.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage
		dest.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage

		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 0);

		Case entre1 = damier.getCase(4, 5);
		entre1.setPiece(new Pion(Couleur.BLANC));
		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 1);

		Case entre2 = damier.getCase(3, 4);
		entre2.setPiece(new Pion(Couleur.BLANC));
		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 2);
	}

	@Test
	public void piecesEntre_versHautDroite() {
		Case orig, dest;

		orig = damier.getCase(2, 3);
		dest = damier.getCase(0, 5);
		orig.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage
		dest.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage

		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 0);

		Case entre = damier.getCase(1, 4);
		entre.setPiece(new Pion(Couleur.BLANC));
		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 1);
	}

	@Test
	public void piecesEntre_versHautGauche() {
		Case orig, dest;

		orig = damier.getCase(2, 3);
		dest = damier.getCase(0, 1);
		orig.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage
		dest.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage

		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 0);

		Case entre = damier.getCase(1, 2);
		entre.setPiece(new Pion(Couleur.BLANC));
		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 1);
	}

	@Test
	public void piecesEntre_versBasGauche() {
		Case orig, dest;

		orig = damier.getCase(2, 3);
		dest = damier.getCase(5, 0);
		orig.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage
		dest.setPiece(new Pion(Couleur.NOIR)); // juste pour l'affichage

		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 0);

		Case entre1 = damier.getCase(4, 2);
		entre1.setPiece(new Pion(Couleur.BLANC));
		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 1);

		Case entre2 = damier.getCase(3, 2);
		entre2.setPiece(new Pion(Couleur.BLANC));
		System.out.println(damier.joliString());
		Assert.assertEquals(damier.piecesEntre(orig, dest).size(), 2);
	}
}
