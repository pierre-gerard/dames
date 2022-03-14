package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.*;

public class TestCase {
	static int nbTests;

	@Before
	public void init() {
		System.out.println("Initialisation de la méthode TestCase #" + (++TestCase.nbTests));
	}

	@Test
	public void distanceAvec_enDiagonale() {
		Case c = new Case(2, 3, Couleur.NOIR);

		Case c1 = new Case(1, 2, Couleur.BLANC);
		Case c2 = new Case(0, 5, Couleur.BLANC);
		Case c3 = new Case(5, 0, Couleur.BLANC);
		Case c4 = new Case(6, 7, Couleur.BLANC);

		Assert.assertEquals(c.distanceAvec(c1), 1);
		Assert.assertEquals(c.distanceAvec(c2), 2);
		Assert.assertEquals(c.distanceAvec(c3), 3);
		Assert.assertEquals(c.distanceAvec(c4), 4);
	}
}
