package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Personnage;

public class Gilet implements ActionListener{
	
	
	/**
	 * Classe permettant le fonctionnement du bonus_bouclier
	 */
	private Personnage personnage;
	
	
	/**
	 * Constructeur de la classe Gilet
	 * @param personnage Le personnage ayant obtenu un bonus_bouclier
	 */
	public Gilet(Personnage personnage){
		this.personnage = personnage;
	}

	
	/**
	 * Supprime les effets du bonus_bouclier
	 */
	public void actionPerformed(ActionEvent arg0) {
		personnage.setGilet(false);
	}
}
