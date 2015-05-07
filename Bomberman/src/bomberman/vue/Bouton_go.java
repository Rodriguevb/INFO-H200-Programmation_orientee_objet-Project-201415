package bomberman.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.Audio;
import bomberman.controleur.Controleur;
import bomberman.modele.Modele;



public class Bouton_go extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Classe du bouton go.
	 */
	
	private Controleur controleur = null;
	private Modele modele = null ;

	
	public Bouton_go(Controleur controleur, Modele modele) {
		super("C'est parti !");
		this.setLocation(200,300);
		this.controleur = controleur;
		this.modele = modele;
		this.addActionListener(this); // mets le bouton sur ecoute de la souris
		this.setFont(new java.awt.Font("Serif",1,30));
	}


	public void actionPerformed(ActionEvent e) {
		
		controleur.creerJoueurs();
		controleur.creerMalus();
		controleur.moveMalus();
		controleur.dropBombMalus();
		controleur.switchToJeu();
		Audio son = new Audio(modele.getTheme().getNom_son());
		son.start();

		
	}	
}