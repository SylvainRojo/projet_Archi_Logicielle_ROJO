package joueur;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import pot.commun.PotCommun;


public abstract class Joueur {
    protected ArrayList<String> mots;
    protected PotCommun pot = PotCommun.getInstance();
    protected Scanner sc = new Scanner(System.in);
    protected ArrayList<String> motDeladversaire;

    protected char prendreLettre() {
        Random rand = new Random();
        char randLetter = (char)(rand.nextInt(26) + 'a');
        return randLetter;
    }
    abstract int round();

    void setadvListe(ArrayList<String> advListe){
        this.motDeladversaire = advListe;
    }

     ArrayList<String> getmotDeladversaire(){
        return this.motDeladversaire;
    }

    void wordSuccess(String testMot) {
        ArrayList<Character> motEnChar = new ArrayList<Character>();
        for (char c : testMot.toCharArray()) {
            motEnChar.add(c);
        }
        for (Character item : motEnChar) {
            if (pot.getListeDeLettres().contains(item)) {
                pot.getListeDeLettres().remove(item);
            }
        }
        for (Character value : pot.getListeDeLettres()) {
            System.out.println("Value = " + value);
        }
        pot.ajoutLettre(this.prendreLettre());
        //L'IA peut rejouer
        if(this.mots.size() < 10){
            this.round();
        } else {
            return;
        }
    }
}
