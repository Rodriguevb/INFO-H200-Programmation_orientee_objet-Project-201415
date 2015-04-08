package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fenetre.Fenetre;
import jeu.Controleur;
import jeu.Plateau;
import jeu.Vue;

public class Bouton_jouer extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton jouer.
	 */
	private static final long serialVersionUID = 1L;
	private Fenetre fenetre = null;
	
	
	public Bouton_jouer(Fenetre fenetre) {
		super( "Jouer" );
		this.fenetre = fenetre;
		this.addActionListener(this); // mets le bouton sur Žcoute de la souris
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		fenetre.getContentPane().removeAll();
		fenetre.setContentPane( new Jeu() );
		fenetre.getContentPane().validate();
	}
	      
}