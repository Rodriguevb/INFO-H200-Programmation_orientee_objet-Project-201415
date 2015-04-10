package bomberman.vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomberman.controleur.Controleur;

public class Bouton_options extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton options.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur; 
	
	
	public Bouton_options(Controleur controleur) {
		super("Options");
		this.controleur = controleur;
		this.addActionListener(this); // mets le bouton sur Žcoute de la souris
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		controleur.switchToOptions();
	}
	
	
}