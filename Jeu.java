package jeuEngine;

import joueur.Joueur;
import joueur.JoueurHumain;
import joueur.JoueurIA;
import pot.commun.PotCommun;

public class Jeu {
    private PotCommun pot;
    private Joueur user;
    private Joueur IA;

    public Jeu() {
        this.pot = PotCommun.getInstance();
        
        this.user = new JoueurHumain();
        this.IA = new JoueurIA();

        
        this.gameCycle();
    }

    public void gameCycle() {
        Joueur player = this.debut();
        int idPlayer = player.round();
        while(this.user.mots.size()<10 || IA.mots.size()<10) {
            System.out.println("IA score : "+IA.mots.size());
            System.out.println("User score : "+user.mots.size());
            if (idPlayer == 2){
                user.setadvListe(IA.mots);
                idPlayer = user.round();
            }else {
                user.setadvListe(user.mots);
                idPlayer = IA.round();
            }
        }
        String letters = " ";
        for (String item : user.mots) {
            letters += " " + item;
        }
        System.out.println(letters+"\n");
    }

    public Joueur debut() {
        System.out.println("C'est parti !!!\n");

        char p1Letter = this.user.prendreLettre();
        pot.ajoutLettre(p1Letter);

        char IALetter = this.IA.prendreLettre();
        pot.ajoutLettre(IALetter);

        Joueur winner = this.user;
        if(p1Letter > IALetter) {
            winner = this.IA;
        } else {
            winner = this.user;
        }
        return winner;
    }
}
