package pot.commun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class PotCommun {

	private ArrayList<Character> listeDesLettres;
	
	private PotCommun(){
		this.listeDesLettres = new ArrayList<Character>();
	}
	/** Singleton ----------
	 * On utilise le singleton pour notre pot commun. De manière à ce que le pot commun
	 * soit instancié une seule et unique fois.	 * 
	 * */
	private static class PotCommunHolder {
		private final static PotCommun instance = new PotCommun();
	}
	
	public static PotCommun getInstance() {
		return PotCommunHolder.instance;
	}
	
	
	public void ajoutLettre( char lettre){
		this.listeDesLettres.add(lettre);
	}
		
	
	public static void main(String[] args) {
	

	}

}
