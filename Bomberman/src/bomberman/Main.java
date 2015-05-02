package bomberman;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;
import bomberman.vue.Vue;


public class Main {
	
	
	/**
	 * Lancer le programme.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controleur controleur = new Controleur();
		Modele modele         = new Modele();
		Vue vue               = new Vue(controleur,modele);
		
		controleur.link( vue ); // lier la vue au controleur
		controleur.link( modele ); // lier le modele au controleur
		
		
		
		
	}

}