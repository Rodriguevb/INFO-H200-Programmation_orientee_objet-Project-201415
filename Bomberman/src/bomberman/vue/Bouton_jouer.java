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
		this.setLocation(200,300);
		this.controleur = controleur;
		this.addActionListener(this); // mets le bouton sur ecoute de la souris
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controleur.switchToSousMenu();
	}


	public int getNb_joueurs() {
		return nb_joueurs;
	}


	public void setNb_joueurs(int nb_joueurs) {
		this.nb_joueurs = nb_joueurs;
	}
}