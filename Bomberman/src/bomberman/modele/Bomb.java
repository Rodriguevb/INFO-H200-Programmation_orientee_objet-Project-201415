package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Controleur;
import bomberman.controleur.Explosion;


public class Bomb extends PossedePosition {
	
	private Timer timer;

	public Bomb(int x, int y, Controleur controleur) {
		super(x,y);
		
		this.timer = new Timer(3000, new Explosion(x,y,controleur) );
		this.timer.setRepeats(false);
		this.timer.start();
	}

}
