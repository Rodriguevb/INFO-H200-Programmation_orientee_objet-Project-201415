package bomberman.vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.controleur.Controleur;

public class Bouton_retour extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton retour.
	 */
	
	private Controleur controleur; 
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur du bouton Retour
	 * @param controleur Le Controleur du jeu
	 */
	public Bouton_retour(Controleur controleur) {
		super("Retour au menu");
		this.controleur = controleur;
		this.setFont(new java.awt.Font("Serif",1,12));
		this.addActionListener(this); // met le bouton sur ecoute de la souris
	}


	/**
	 * Active l'effet du bouton Retour
	 */
	public void actionPerformed(ActionEvent arg0) {
		controleur.switchToMenu();
	}
	
	
}