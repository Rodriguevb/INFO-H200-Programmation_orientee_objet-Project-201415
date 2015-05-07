package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Clavier;

public class BonusClavier extends Bonus {
	
	/**
	 * Classe des BonusClavier
	 */
	
	/**
	 * Constructeur de la classe BonusClavier
	 * @param x La position en x du BonusClavier
	 * @param y La position en y du BonusClavier
	 * @param personnage Le personnage concerne
	 */
	public BonusClavier(int x, int y, Personnage personnage){
		super(x,y, "BonusClavier", personnage);
		
	}
	
	
	/**
	 * Actionne le BonusClavier
	 * @param personnage Le personnage concerne
	 */
	public void action(Personnage personnage){
		personnage.setClavier(true);
		Timer timerClavier = new Timer(10000, new Clavier(personnage));
		timerClavier.setRepeats(false);
		timerClavier.start();
	}

}