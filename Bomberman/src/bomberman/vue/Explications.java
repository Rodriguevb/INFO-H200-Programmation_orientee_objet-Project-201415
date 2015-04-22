package bomberman.vue;


import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;

public class Explications extends JPanel {
	
	/**
	 * La classe qui affiche les explications.
	 */
	private static final long serialVersionUID = 1L;
	

	public Explications(Controleur controleur) {

		this.add(new Bouton_retour(controleur));   
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("Explications.png").getImage(), 0, 0, 850, 850, null);
	}
}
