package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bomberman.modele.Bombe;
import bomberman.modele.PossedePosition;

public class Explosion extends PossedePosition implements ActionListener {
	
	/**
	 * Classe qui représente une explosion
	 */
	private Controleur controleur;
	private Bombe bombe;
	private Timer timer;

	
	/**
	 * 
	 * @param x l'abscisse de l'explosion 
	 * @param y l'ordonnée de l'explosion
	 * @param controleur
	 * @param bombe
	 */
	public Explosion(int x, int y, Controleur controleur, Bombe bombe) {
		super(x,y);
		this.controleur = controleur;
		this.bombe = bombe;
		
		this.timer = new Timer(1000, new SuppressionExplosion(controleur, this) );
		this.timer.setRepeats(false);
		this.timer.start();
	}


	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if ( bombe != null ){
			this.controleur.removeBombe( bombe );
			bombe = null;
		}
		this.controleur.makeExplosion( this );
	}

}
