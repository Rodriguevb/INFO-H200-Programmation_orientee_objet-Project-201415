package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Controleur;
import bomberman.controleur.Explosion;

public class Bombe extends PossedePosition {
	
	private Timer timer;
	private int portee;

	
	/**
	 * Constructeur de la classe Bombe
	 * @param x L'abscisse de la bombe
	 * @param y L'ordonnée de la bombe
	 * @param controleur
	 */
	public Bombe(int x, int y, Controleur controleur) {
		super(x,y);
		this.portee = 1;
		
		
		this.timer = new Timer(3000, new Explosion(x,y,4000,this.getPortee(),controleur, this) );
		this.timer.setRepeats(false);
		this.timer.start();
	}
	
	
	public int getPortee(){
		return portee;
	}

}
