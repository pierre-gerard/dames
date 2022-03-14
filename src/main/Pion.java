package main;

public class Pion extends Piece {
	
	public Pion (Couleur c) {
		super(c);
	}

	public String joliString() {
		if (this.couleur==Couleur.NOIR)
			return ("x");
		else
			return ("o");
	}

	public static void main(String[] args) {
		Piece p1 = new Pion(Couleur.NOIR);
		System.out.println(p1.joliString());
		Piece p2 = new Pion(Couleur.BLANC);
		System.out.println(p2.joliString());
	}
}
