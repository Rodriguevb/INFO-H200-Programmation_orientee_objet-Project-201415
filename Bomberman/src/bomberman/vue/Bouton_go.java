package bomberman.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.Audio;
import bomberman.controleur.Controleur;
import bomberman.modele.Modele;

public class Bouton_go extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton go.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	private Modele modele = null ;
	private int nb_joueurs;
	
	
	public Bouton_go(Controleur controleur, Modele modele) {
		super("C'est parti !");
		this.setLocation(200,300);
		this.controleur = controleur;
		this.modele = modele;
		this.addActionListener(this); // mets le bouton sur ecoute de la souris
		this.setNb_joueurs(1);
	}


	public int getNb_joueurs() {
		return nb_joueurs;
	}


	public void setNb_joueurs(int nb_joueurs) {
		this.nb_joueurs = nb_joueurs;
	}
	


	public void actionPerformed(ActionEvent e) {
		controleur.switchToJeu();
		controleur.creerJoueurs();
		controleur.creerMalus();
		Audio son = new Audio(modele.getTheme().getNom_son());
		son.start();
		controleur.jeuEnMarche(true);
		controleur.moveMalus();
	}	
}