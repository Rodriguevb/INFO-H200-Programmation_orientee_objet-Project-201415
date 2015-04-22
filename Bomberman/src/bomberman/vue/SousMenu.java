package bomberman.vue;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;

public class SousMenu extends JPanel {
	
	/**
	 * La classe qui affiche le menu.
	 */
	private static final long serialVersionUID = 1L;
	

	public SousMenu(Controleur controleur) {

		this.add(new Bouton_retour(controleur));
		this.add(new Bouton_nbjoueurs(controleur));   
		this.add(new Bouton_niveau(controleur));
		this.add(new Bouton_go(controleur));
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("fond_bomber.jpg").getImage(), 0, 0, 850, 850, null);
	}
}
