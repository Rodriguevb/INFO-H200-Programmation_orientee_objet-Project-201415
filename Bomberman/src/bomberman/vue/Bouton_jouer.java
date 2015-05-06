package bomberman.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.controleur.Controleur;

public class Bouton_jouer extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton jouer.
	 */
	
	private Controleur controleur = null;	
	
	public Bouton_jouer(Controleur controleur) {
		super("Jouer");
		this.setBackground(new Color(151,201,59));
		this.setFont(new java.awt.Font("Serif",1,35));
		this.controleur = controleur;
		this.addActionListener(this); // mets le bouton sur ecoute de la souris
	}


	public void actionPerformed(ActionEvent e) {
		controleur.switchToSousMenu();
	}
}