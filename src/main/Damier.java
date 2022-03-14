package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Damier {
	private final static int TAILLE = 8;
	private Case[][] tab;

	public Damier() {
		this.tab = new Case[TAILLE][TAILLE];

		for (int lig = 0; lig < TAILLE; lig++)
			for (int col = 0; col < TAILLE; col++)
				if (((lig + col) % 2) == 0)
					tab[lig][col] = new Case(lig, col, Couleur.NOIR);
				else
					tab[lig][col] = new Case(lig, col, Couleur.BLANC);
	}

	public Case getCase(int lig, int col) {
		return tab[lig][col];
	}

	public void setCase(int lig, int col, Case c) {
		tab[lig][col] = c;
	}

	@Override
	public String toString() {
		return "Damier [tab=" + Arrays.toString(tab) + "]";
	}

	/*
	 * @return null si pas en diagonale
	 * @return liste vide si même case ou à côté
	 * @return liste des pièces entre, si en diagonale
	 */
	public ArrayList<Piece> piecesEntre(Case orig, Case dest) {
		ArrayList<Piece> liste = null;

		switch (orig.distanceAvec(dest)) {
		case (-1):
			break;
		case (0):
		case (1):
			liste = new ArrayList<Piece>();
			break;
		default:
			liste = new ArrayList<Piece>();
			int incrLig = 1, incrCol = 1;
			if (orig.getLigne() > dest.getLigne())
				incrLig = -1;
			if (orig.getColonne() > dest.getColonne())
				incrCol = -1;

			for (int lig = orig.getLigne() + incrLig; lig != dest.getLigne(); lig += incrLig)
				for (int col = orig.getColonne() + incrCol; col != dest.getColonne(); col += incrCol)
					if (this.getCase(lig, col).getPiece() != null)
						liste.add(getCase(lig, col).getPiece());
		}
		return liste;
	}

	public String joliString() {
		String str = "";
		for (int lig = 0; lig < TAILLE; lig++) {
			for (int col = 0; col < TAILLE; col++)
				str += getCase(lig, col).joliString();
			str += "\n";
		}
		return str;
	}

	public static void main(String[] args) {
		Damier damier = new Damier();

		System.out.println(damier.joliString());

		damier.getCase(0, 0).setPiece(new Pion(Couleur.NOIR));
		damier.getCase(1, 1).setPiece(new Pion(Couleur.BLANC));
		damier.getCase(3, 1).setPiece(new Pion(Couleur.NOIR));
		damier.getCase(1, 4).setPiece(new Pion(Couleur.BLANC));

		System.out.println(damier.joliString());
	}
}
