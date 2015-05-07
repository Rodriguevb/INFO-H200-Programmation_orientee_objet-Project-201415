package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Gilet;

public class BonusGilet extends Bonus {
	
	/**
	 * Classe des BonusGilet
	 */
	
	
	/**
	 * Constructeur de la classe BonusGilet
	 * @param x La position en x du BonusGilet
	 * @param y La position en y du BonusGilet
	 * @param personnage Le personnage concerne
	 */
	public BonusGilet(int x, int y, Personnage personnage){
		super(x,y, "BonusGilet", personnage);
	}
	
	
	/**
	 * Actionne le BonusGilet
	 * @param personnage Le personnage concerne
	 */
	public void action(Personnage personnage){
	personnage.setGilet(true);
	Timer timerGilet = new Timer(10000, new Gilet(personnage));
	timerGilet.setRepeats(false);
	timerGilet.start();
	}
}
