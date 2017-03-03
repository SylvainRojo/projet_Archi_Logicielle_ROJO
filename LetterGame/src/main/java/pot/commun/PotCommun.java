package pot.commun;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Dictionary;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.io.IOException;
import java.text.Normalizer;
import fr.esiea.unique.binome.name.dictionary.*;

public class PotCommun {

	private ArrayList<Character> listeDesLettres;
	private Dictionary dico; 
	
	private PotCommun(){
		this.listeDesLettres = new ArrayList<Character>();
		this.dico = new Dictionary();
	}
	/** Singleton 
	 * On utilise le singleton pour notre pot commun. De manière à ce que le pot commun
	 * soit instancié une seule et unique fois.	  
	 * */
	// Holder du PotCommun
	private static class PotCommunHolder {
		private final static PotCommun instance = new PotCommun();
	}
	
	// Le get de l'instance
	public static PotCommun getInstance() {
		return PotCommunHolder.instance;
	}
	
	// Ajout de lettre
	public void ajoutLettre( char lettre){
		this.listeDesLettres.add(lettre);
	}
	
	// Le get de la liste des lettres
	public ArrayList<Character> getListeDeLettres(){
		return this.listeDesLettres;
	}
	
	public String suppressionAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
	
	
    public String verifDico(String mot, Boolean check1) throws IOException {
        String nouveauFormat = this.suppressionAccent(mot);
        if (check1 == true) {
            boolean flag = comparerPotCommun(nouveauFormat);
            if (flag) {
                System.out.println("dico.isWord... : "+nouveauFormat);
                return dico.isWord(nouveauFormat);
            } else {
                return "";
            }
        } else {
            return dico.isWord(nouveauFormat);
        }
    }	
    
    public boolean estDansLeDico(String mot) throws IOException {
        String nouveauFormat = this.suppressionAccent(mot);
        return dico.containsWord(mot);
    }
    
    
    
    public boolean comparerPotCommun(String mot) {
        ArrayList<Character> motEnChar = new ArrayList<Character>();
        for (char c : mot.toCharArray()) {
        	motEnChar.add(c);
        }
        boolean flag = false;
        for (Character item : motEnChar) {
            System.out.println(this.getListeDeLettres().contains(item));
            if (this.getListeDeLettres().contains(item)) {
                flag = true;
            }else {
                flag = false;
            }
        }
        return flag;
    }
	
	public static void main(String[] args) {
	

	}

}
