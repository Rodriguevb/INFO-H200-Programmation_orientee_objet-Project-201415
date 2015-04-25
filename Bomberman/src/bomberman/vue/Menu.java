package bomberman.vue;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;

public class Menu extends JPanel {
	
	/**
	 * La classe qui affiche le menu.
	 */
	private static final long serialVersionUID = 1L;
	

	public Menu(Controleur controleur) {
		
		setLayout(null);
		JButton bouton_jouer = new Bouton_jouer(controleur);
		JButton bouton_explications = new Bouton_explications(controleur);
		bouton_jouer.setBounds(290,170,240,70);
		bouton_explications.setBounds(290, 280, 240, 70);
		this.add(bouton_jouer);
		this.add(bouton_explications);
		
		this.add(new Bouton_explications(controleur));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("fond_bomber.jpg").getImage(), 0, 0, 850, 850, null);
	}
}


