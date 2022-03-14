package main;

public class Case {
	private int ligne;
	private int colonne;
	private Couleur couleur;

	private Piece piece;

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK_FORE = "\u001B[30m";
	private static final String ANSI_WHITE_FORE = "\u001B[37m";
	private static final String ANSI_BLACK_BACK = "\u001B[40m";
	private static final String ANSI_WHITE_BACK = "\u001B[47m";

	public Case(int lig, int col, Couleur c) {
		this.piece = null;
		this.ligne = lig;
		this.colonne = col;
		this.couleur = c;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {
		return "Case [ligne=" + ligne + ", colonne=" + colonne + ", piece=" + piece + "]";
	}

	public String joliString() {
		String str = "";

		if (this.getCouleur().equals(Couleur.NOIR))
			str += ANSI_BLACK_BACK + ANSI_WHITE_FORE;
		else
			str += ANSI_WHITE_BACK + ANSI_BLACK_FORE;

		str += " ";
		if (piece == null)
			str += " ";
		else
			str += piece.joliString();
		str += " ";

		str += ANSI_RESET;

		return str;
	}

	/*
	 * @return -1 si pas en diagonale
	 * 
	 * @return 0 si même case
	 * 
	 * @return nb de cases entre si en diagonale
	 */
	public int distanceAvec(Case dest) {
		int deltaLig = Math.abs(dest.getLigne() - this.getLigne());
		int deltaCol = Math.abs(dest.getColonne() - this.getColonne());

		if (deltaLig != deltaCol)
			return -1;
		else
			return deltaLig;
	}

	public static void main(String[] args) {
		Case c;

		c = new Case(2, 3, Couleur.NOIR);
		c.setPiece(new Pion(Couleur.NOIR));
		System.out.println(c.joliString());

		c = new Case(2, 3, Couleur.NOIR);
		c.setPiece(new Pion(Couleur.BLANC));
		System.out.println(c.joliString());

		c = new Case(2, 3, Couleur.BLANC);
		c.setPiece(null);
		System.out.println(c.joliString());

		c = new Case(2, 3, Couleur.NOIR);
		c.setPiece(null);
		System.out.println(c.joliString());

		c = new Case(2, 3, Couleur.BLANC);
		c.setPiece(new Pion(Couleur.NOIR));
		System.out.println(c.joliString());

		c = new Case(2, 3, Couleur.BLANC);
		c.setPiece(new Pion(Couleur.BLANC));
		System.out.println(c.joliString());
	}
}
