package joueur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class JoueurHumain extends Joueur {
    public int id = 1;
    public JoueurHumain() {
        this.mots = new ArrayList<String>();
    }

    public int round() {
        System.out.println("A ton tour !");

        pot.ajoutLettre(this.prendreLettre());
        pot.ajoutLettre(this.prendreLettre());

        String letters = " ";
        for (char item : pot.getListeDeLettres()) {
            letters += " " + new StringBuilder().append(item).toString();
        }
        System.out.println("Pot Commun : "+letters);

        int choix = this.sc.nextInt();
        switch (choix) {
            case 1:
                this.motPotCommun();
                break;
            case 2:
                if (this.mots.size()>0) {
                    this.mesMots();
                }else {
                    System.out.println("Tu n'as pas encore de mot !");
                }
                break;
            case 3:
                this.volerMot();
                break;
            default:
                this.motPotCommun();
        }
        return this.id;
    }

    void motPotCommun() {
        System.out.println("Fait un mot !");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        try {
            String testMot = pot.verifDico(word, true);
            if(testMot == ""){
                System.out.println("Ce mot n'existe pas :(\n");
            }else {
                this.mots.add(testMot);
                System.out.println("Mot : '" + testMot + "' bon ! Tire une lettre !\n");
                this.wordSuccess(testMot);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void mesMots() {
        System.out.println("Peux-tu utiliser un de tes mots et les lettres du pot commun ?");

        String words = " ";
        for (String item : this.mots) {
            words += item;
            words += " ";
        }
        System.out.println("Ton mot : "+words);
        String mSelection = this.sc.next();

        if (!this.mots.contains(mSelection)) {
            System.out.println("Ce n'est pas ton mot !");
            this.mesMots();
        }
        else
        {
            System.out.println("Choisi une lettre du pot commun pour terminer ton mot :");
            String selection = sc.next();
            if (pot.comparerPotCommun(selection) == true){
                System.out.println("Essaie avec cette lettre : "+mSelection);
                try {
                    String motC = mSelection + selection;
                    System.out.println("Ton mot est : "+motC);
                    String result = pot.verifDico(motC, false);
                    if(result == ""){
                        System.out.println("Ce mot n'est pas dans le dico :(\n");
                    }else {
                        this.mots.add(result);
                        System.out.println("Mot : '" + result + "' bon ! Tire une autre lettre ! \n");
                        this.wordSuccess(result);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Dans le pot commun !");
                this.mesMots();
            }
        }
    }

    void volerMot() {
        System.out.println("Utilise un mot de l'adversaire !");
        String words = " ";
        for (String item : this.getmotDeladversaire()) {
            words += item;
            words += " ";
        }
        System.out.println("Le mot : "+words);
        String mSelection = this.sc.next();

        if (!this.getmotDeladversaire().contains(mSelection)) {
            this.volerMot();
        } else {
            System.out.println("Dans le pot commun :");
            String lettreChoisie = sc.next();
            if (pot.comparerPotCommun(lettreChoisie) == true){
                System.out.println("Créer ton mot avec : "+mSelection);
                try {
                    String motC = mSelection + lettreChoisie;
                    System.out.println("Tu as créé : "+motC);
                    String result = pot.verifDico(motC, false);
                    if(result == ""){
                        System.out.println("Ca n'exist pas :(\n");
                    }else {
                        this.mots.add(result);
                        System.out.println("Mot: '" + result + "' Bon ! Tire une autre lettre ! \n");
                        this.wordSuccess(result);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Pot Commun !");
                this.mesMots();
            }
        }
    }
}
