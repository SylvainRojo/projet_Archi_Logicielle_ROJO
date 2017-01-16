package pot.commun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class PotCommun {

	List<String> listeDesLettres = new ArrayList<String>();
	
	public void ajoutLettre(int nbLettre, String lettre){
		
		for( int i = 0; i < nbLettre; i++  ){
			listeDesLettres.add(lettre);
		}
		
	}
	
	public void enleverLettre(int nbLettre, List<String> listeAEnlever){

		// remove les lettres de ListLettre présentent dans listeDesLettres
		
	}
	
	
	public static void main(String[] args) {
	

	}

}
