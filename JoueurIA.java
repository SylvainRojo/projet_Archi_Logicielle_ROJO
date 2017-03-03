package joueur;

import java.io.IOException;
import java.util.ArrayList;


public class JoueurIA extends Joueur{
    public int id = 2;
    public JoueurIA() {
        this.mots = new ArrayList<String>();
        this.mots.add("a");
        this.mots.add("aa");
        this.mots.add("loup");
        this.mots.add("loupe");
    }

    public int round() {
        System.out.println("Bot !");

        pot.ajoutLettre(this.prendreLettre());
        pot.ajoutLettre(this.prendreLettre());

        String letters = " ";
        for (char item : pot.getListeDeLettres()) {
            letters += " " + new StringBuilder().append(item).toString();
        }
        System.out.println("Pot Commun : "+letters);
        System.out.println("Je fais un mot ! (Bot)");

        System.out.println("Vérif mot \n");
        String testMot = createWord();
            

        if(testMot == ""){
            System.out.println("J'y arrive pas (Bot):(\n");
        }else {
            this.mots.add(testMot);
            System.out.println("Mot : '" + testMot + "' Bon !");
            this.wordSuccess(testMot);
        }
        return this.id;
    }

    public String createWord() {
        String testMot = "";
        int prefix = 1;
        ArrayList<Integer> used_mots = new ArrayList<Integer>();
        int initial_indice;

        for(int i=0; i< this.pot.getListeDeLettres().size(); i++){
            used_mots.add(i);
            initial_indice = i;
            testMot = this.pot.getListeDeLettres().get(i).toString();

            for(int j=0; j<this.pot.getListeDeLettres().size(); j++){
                if(used_mots.contains(j)){
                    break;
                } else {
                    used_mots.add(j);
                    testMot = testMot + this.pot.getListeDeLettres().get(j).toString();
                    try {
                        if(this.pot.estDansLeDico(testMot) == false){
                            used_mots.remove(j);
                            break;
                        } else {
                            if(this.pot.verifDico(testMot, false) == testMot){
                                return testMot;
                            } else {
                                prefix = prefix + 1;
                                j=-1;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



        String word = "";
        ArrayList<Integer> checked_position = new ArrayList<Integer>();
        int word_length = word.length();
        System.out.println("taille du pot commun : "+this.pot.getListeDeLettres().size());
        for(int i = 0; i < this.pot.getListeDeLettres().size(); i++)
        {
            System.out.println("i : "+i);
            System.out.println("Rajout de l'indice : "+i);
            checked_position.add(i);
            word = this.pot.getListeDeLettres().get(i).toString();
            
            for(int j = 0; j < this.pot.getListeDeLettres().size(); j++)
            {
                System.out.println("indice lettre complémentaire testée : "+j);
                if(checked_position.contains(j)){
                    if(j+1 < this.pot.getListeDeLettres().size()){
                        System.out.println("valeur j : "+j);
                        
                        j++;
                        System.out.println("j+i : "+j);
                    }
                    if(j+1 == this.pot.getListeDeLettres().size()){
                        System.out.println("j+1=longueur pot commun");
                        break;
                    }
                }
                String item = this.pot.getListeDeLettres().get(j).toString();
                word=word+item;
                System.out.println("Combinaisons testées = "+word);
                try {
                    if(this.pot.estDansLeDico(word) == false){ 
                        System.out.println("mot non trouvé, valeur de j : "+j);
                        word=word.substring(0, word.length()-1);
                    } else {
                        System.out.println("mot contenu");
                        System.out.println("Rajout de l'indice : "+j);
                        checked_position.add(j);
                        j=0;
                        if(this.pot.verifDico(word, false) == word){ 
                            return word;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            checked_position.remove(i);
        }
        return "";
    }
}
