package bomberman.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import bomberman.controleur.Controleur;

public class Bouton_choixTheme extends JComboBox implements ActionListener{

	/**
	 * Classe du bouton Choix des joueurs.
	 */

	private Controleur controleur = null;
	
	public Bouton_choixTheme(Controleur controleur) {
		
		this.controleur = controleur;
		this.addItem("Mario");
		this.addItem("Tetris");
	    this.addActionListener(this);
	    this.setForeground(Color.black);
	    this.setFont(new java.awt.Font("Serif",1,25));
	    
	}
	

	public void actionPerformed(ActionEvent e) {
	    controleur.ChoixTheme(this.getSelectedItem());
	    
	    }               
	  }
