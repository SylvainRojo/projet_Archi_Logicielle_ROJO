package pot.commun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.text.Normalizer;

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
	
	
	public void ajoutLettre( char lettre){
		this.listeDesLettres.add(lettre);
	}
		
	
	public static void main(String[] args) {
	

	}

}
