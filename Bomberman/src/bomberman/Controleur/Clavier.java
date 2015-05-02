package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Personnage;

public class Clavier implements ActionListener{
	
	
	/**
	 * Classe permettant le fonctionnement du bonus_clavier
	 */
	private Personnage personnage;
	
	
	/**
	 * Constructeur de la classe Clavier
	 * @param personnage Le personnage ayant obtenu un bonus_clavier
	 */
	public Clavier(Personnage personnage){
		this.personnage = personnage;
	}
    
	
	/**
	 * Supprime les effets du bonus_clavier
	 */
	public void actionPerformed(ActionEvent arg0) {
		personnage.setClavier(false);
	}

}
