package bomberman.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import bomberman.controleur.Controleur;

public class Bouton_niveau extends JComboBox implements ActionListener{

	/**
	 * Classe du bouton Nombre de joueurs.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	
	
	public Bouton_niveau(Controleur controleur) {
		this.controleur = controleur;
		this.addItem("Facile");
		this.addItem("Moyen");
		this.addItem("Difficile");
	    this.addActionListener(this);
	    this.setForeground(Color.black);
	    this.setFont(new java.awt.Font("Serif",1,25));
	    
	}
	
		/*public void initialise(){
			controleur.NbJoueurs(new String("1 joueur"));
		}*/

	    public void actionPerformed(ActionEvent e) {
	      controleur.Niveau(this.getSelectedItem());
	    }               
	  }
