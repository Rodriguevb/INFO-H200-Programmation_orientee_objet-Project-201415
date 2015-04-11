package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Controleur;
import bomberman.controleur.Explosion;

public class Bombe extends PossedePosition {
	
	private Timer timer;

	
	/**
	 * Constructeur de la classe Bombe
	 * @param x L'abscisse de la bombe
	 * @param y L'ordonnée de la bombe
	 * @param controleur
	 */
	public Bombe(int x, int y, Controleur controleur) {
		super(x,y);
		
		this.timer = new Timer(3000, new Explosion(x,y,4000,controleur, this) );
		this.timer.setRepeats(false);
		this.timer.start();
	}

}
