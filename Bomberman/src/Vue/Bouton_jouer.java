package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controleur.Controleur;

public class Bouton_jouer extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton jouer.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	
	
	public Bouton_jouer(Controleur controleur) {
		super("Jouer");
		this.controleur = controleur;
		this.addActionListener(this); // mets le bouton sur �coute de la souris
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controleur.switchToJeu();
	}
}