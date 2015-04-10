package bomberman;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;
import bomberman.vue.Vue;

public class Main {
	
	
	public static void main(String[] args) {
		
		Controleur controleur = new Controleur();
		Modele modele         = new Modele();
		Vue vue               = new Vue(controleur);
		
		controleur.link( vue ); // lier la vue au controleur
		controleur.link( modele ); // lier le modèle au controleur
		
	}

}