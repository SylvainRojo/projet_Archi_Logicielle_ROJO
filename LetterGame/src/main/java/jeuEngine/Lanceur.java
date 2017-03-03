package jeuEngine;

import pot.commun.PotCommun;

public class Lanceur {

	private PotCommun pot;

	public Lanceur() {
	     this.pot = PotCommun.getInstance();
	}

	public static void main(String[] args) {
	     System.out.println("***WELCOME IN LETTER GAME !***\n");
	     Jeu jeu = new Jeu();
	}
}
