package panel;

import javax.swing.JPanel;

public class Menu extends JPanel {
	
	/**
	 * La classe qui affiche le menu.
	 */
	private static final long serialVersionUID = 1L;
	

	public Menu(Fenetre fenetre) {
		this.add(new Bouton_jouer(fenetre));
		this.add(new Bouton_options());
		this.add(new Bouton_stats());
		

	}

}
