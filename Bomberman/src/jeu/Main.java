package jeu;
import Controleur.Controleur;
import Modele.Modele;
import Vue.Vue;

public class Main {
	
	
	public static void main(String[] args) {
		
		Controleur controleur = new Controleur();
		Modele modele         = new Modele();
		Vue vue               = new Vue(controleur);
		
		controleur.link( vue );
		controleur.link( modele );
		
	}

}
