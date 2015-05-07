package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Tunnel;

public class BonusTunnel extends Bonus {
	
	/**
	 * Classe des BonusTunnel
	 */
	
	
	/**
	 * Constructeur de la classe BonusTunnel
	 * @param x La position en x du BonusTunnel
	 * @param y La position en y du BonusTunnel
	 * @param personnage Le personnage concerne
	 */
	public BonusTunnel(int x, int y, Personnage personnage){
		super(x,y, "BonusTunnel", personnage);
	}
	
	
	/**
	 * Actionne le BonusTunnel
	 * @param personnage Le personnage concerne
	 */
	public void action(Personnage personnage){
		personnage.setTunnel(true);
		Timer timerTunnel = new Timer(10000, new Tunnel(personnage));
		timerTunnel.setRepeats(false);
		timerTunnel.start();		
	}
}