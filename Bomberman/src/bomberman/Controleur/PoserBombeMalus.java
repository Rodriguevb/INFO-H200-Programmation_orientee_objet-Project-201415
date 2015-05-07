package bomberman.controleur;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import bomberman.modele.Bombe;
import bomberman.modele.Malus;
import bomberman.modele.Modele;
import bomberman.modele.Personnage;

public class PoserBombeMalus implements ActionListener{
	
	
	/**
	 * Classe permettant le mouvement des malus
	 */
	private Controleur controleur;
	private Modele modele;
	private int identifiant;
	
	/**
	 * Constructeur de la classe PoserBombeMalus
	 * @param controleur Le controleur
	 * @param modele Le modele
	 * @param identifiant L'identifiant du Malus
	 */
	public PoserBombeMalus(Controleur controleur, Modele modele, int identifiant){
		this.controleur = controleur;
		this.modele = modele;
		this.identifiant = identifiant;
	}
    
	
	/**
	 * Appelle la methode move()
	 */
	public void actionPerformed(ActionEvent arg0) {
		 poserBombe();
	}
	
	
	/**
	 * Faire bouger le Malus qui a le meme identifiant
	 */
	public void poserBombe(){
		Malus mal = modele.getMalusDepuisId(identifiant);
		if (mal != null) { 
		int x = mal.getX();
		int y = mal.getY();
		int portee = 1 ;
		int duree = 1500 ;
		modele.getListBombe().add( new Bombe(x,y, portee, duree, controleur, -1, identifiant) );
			
		}
	}
}