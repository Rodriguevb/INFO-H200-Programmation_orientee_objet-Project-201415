package Vue;

import javax.swing.JPanel;

import Controleur.Controleur;

public class Menu extends JPanel {
	
	/**
	 * La classe qui affiche le menu.
	 */
	private static final long serialVersionUID = 1L;
	

	public Menu(Controleur controleur) {
		this.add( new Bouton_jouer(controleur) );
		this.add( new Bouton_options() );
		this.add( new Bouton_stats() );
	}

}
