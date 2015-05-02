package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	
public class SuppressionExplosion implements ActionListener {
	
	
    /**
     * Classe permettant la suppresion de l'explosion
     */
	private Controleur controleur;
	private Explosion explosion;
		
	
	/**
	 * Constructeur de la classe SuppressionExplosion
	 * @param controleur Le controleur
	 * @param explosion L'explosion
	 */
	public SuppressionExplosion(Controleur controleur, Explosion explosion) {
		this.controleur = controleur;
		this.explosion = explosion;
	}
	
    
	/**
	 * Supprime l'explosion
	 */
	public void actionPerformed(ActionEvent e) {
		this.controleur.removeExplosion( this.explosion );
	}

}
