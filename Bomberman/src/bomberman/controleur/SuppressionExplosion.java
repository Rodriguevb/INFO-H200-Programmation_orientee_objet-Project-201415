package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	/**
	 * Classe permettant la suppresion de l'explosion
	 */

	public class SuppressionExplosion implements ActionListener {
		private Controleur controleur;
		private Explosion explosion;
		
	public SuppressionExplosion(Controleur controleur, Explosion explosion) {
		this.controleur = controleur;
		this.explosion = explosion;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controleur.removeExplosion( this.explosion );
	}

}
