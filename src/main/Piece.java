package main;

public abstract class Piece {
	protected Case c;

	protected Couleur couleur;

	Piece(Couleur c) {
		this.couleur = c;
	}

	public Case getCase() {
		return c;
	}

	public void setCase(Case c) {
		this.c = c;
		c.setPiece(this);
	}

	public Couleur getCouleur() {
		return couleur;
	}

	@Override
	public String toString() {
		return "Piece [c=" + c + ", couleur=" + couleur + "]";
	}

	public abstract String joliString();
}
