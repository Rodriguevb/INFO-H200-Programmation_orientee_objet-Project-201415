package bomberman.vue;


import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;

public class Menu extends JPanel {
	
	/**
	 * La classe qui affiche le menu.
	 */
	private static final long serialVersionUID = 1L;
	

	public Menu(Controleur controleur) {
		this.add( new Bouton_nbjoueurs(controleur));
		this.add( new Bouton_jouer(controleur) );
		
		//this.add( new Bouton_options(controleur) );
		//this.add( new Bouton_stats() );
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("fond_bomber.jpg").getImage(), 0, 0, 850, 850, null);
	}
}
