package bomberman.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import bomberman.controleur.Controleur;

public class Bouton_nbjoueurs extends JComboBox implements ActionListener{

	/**
	 * Classe du bouton Nombre de joueurs.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	
	
	public Bouton_nbjoueurs(Controleur controleur) {
		this.controleur = controleur;
		this.addItem("1 joueur");
		this.addItem("2 joueurs");
		this.addItem("3 joueurs");
		this.addItem("4 joueurs");
	    this.addActionListener(this);
	    this.setForeground(Color.black);
	}

	    public void actionPerformed(ActionEvent e) {
	      controleur.NbJoueurs(this.getSelectedItem());
	    }               
	  }

