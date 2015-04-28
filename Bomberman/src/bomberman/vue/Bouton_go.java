package bomberman.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.Audio;
import bomberman.controleur.Controleur;

public class Bouton_go extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton go.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	private int nb_joueurs;
	
	
	public Bouton_go(Controleur controleur) {
		super("C'est parti !");
		this.setLocation(200,300);
		this.controleur = controleur;
		this.addActionListener(this); // mets le bouton sur ecoute de la souris
		this.setNb_joueurs(1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controleur.switchToJeu();
		controleur.creerJoueurs();
		Audio son = new Audio("SonMario.wav");
		son.start();
		controleur.jeuEnMarche(true);
	}


	public int getNb_joueurs() {
		return nb_joueurs;
	}


	public void setNb_joueurs(int nb_joueurs) {
		this.nb_joueurs = nb_joueurs;
	}
}