package bomberman.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import bomberman.controleur.Controleur;

public class Bouton_nbjoueurs extends JComboBox implements ActionListener{

	/**
	 * Classe du bouton Nombre de joueurs.
	 */

	private Controleur controleur = null;
	
	
	public Bouton_nbjoueurs(Controleur controleur) {
		this.controleur = controleur;
		this.addItem("2 joueurs");
		this.addItem("3 joueurs");
		this.addItem("4 joueurs");
	    this.addActionListener(this);
	   // this.setForeground(new Color(130,189,49));
	    this.setBackground(new Color(151,201,59));
	    this.setFont(new java.awt.Font("Serif",1,25));
	    
	}
	
	public void actionPerformed(ActionEvent e) {
	      controleur.NbJoueurs(this.getSelectedItem());
	    }               
	  }

