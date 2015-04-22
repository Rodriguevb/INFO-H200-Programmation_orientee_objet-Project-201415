package bomberman.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.controleur.Controleur;

public class Bouton_jouer extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton jouer.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	private int nb_joueurs;
	
	
	public Bouton_jouer(Controleur controleur) {
		super("Jouer");
		this.controleur = controleur;
		this.addActionListener(this); // mets le bouton sur écoute de la souris
		this.nb_joueurs = 1;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controleur.creerJoueurs();
		controleur.switchToJeu();
	}
}