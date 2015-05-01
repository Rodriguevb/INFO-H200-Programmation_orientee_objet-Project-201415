package bomberman.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.controleur.Controleur;

public class Bouton_explications extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton Explications.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	private int nb_joueurs;
	
	
	public Bouton_explications(Controleur controleur) {
		super("Comment jouer ?");
		this.setBackground(new Color(154,201,59));
		this.setFont(new java.awt.Font("Serif",1,25));
		this.controleur = controleur;
		this.addActionListener(this); // mets le bouton sur ecoute de la souris
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controleur.switchToExplications();
	}


	public int getNb_joueurs() {
		return nb_joueurs;
	}


	public void setNb_joueurs(int nb_joueurs) {
		this.nb_joueurs = nb_joueurs;
	}
}