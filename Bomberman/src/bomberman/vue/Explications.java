package bomberman.vue;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;

public class Explications extends JPanel {
	
	private static final long serialVersionUID = 1L;

	
	/**
	 * La classe qui affiche les regles du jeu.
	 */
	
	
	/**
	 * Constructeur de la classe Explications
	 * @param controleur Le controleur du jeu
	 */
	public Explications(Controleur controleur) {
		
		setLayout(null);
		Bouton_retour bouton = new Bouton_retour(controleur);
		bouton.setBounds(10, 800, 120, 30);
		bouton.setBackground(new Color(60,160,81));
		this.add(bouton); 
		
	
	}
	
	
	/**
	 * Affiche les images de la classe Explications
	 * @param g Objet graphique
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("Explications.png").getImage(), 0, 0, 850, 850, null);
	}
}
