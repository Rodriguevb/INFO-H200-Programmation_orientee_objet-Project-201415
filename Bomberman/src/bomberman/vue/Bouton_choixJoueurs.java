package bomberman.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import bomberman.controleur.Controleur;

public class Bouton_choixJoueurs extends JComboBox implements ActionListener{

	/**
	 * Classe du bouton Choix des joueurs.
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	private int numJoueur ;
	
	public Bouton_choixJoueurs(Controleur controleur) {
		
		this.controleur = controleur;
		this.addItem("Bomber");
		this.addItem("Mickey");
	    this.addActionListener(this);
	    this.setForeground(Color.black);
	    
	}
	
		/*public void initialise(){
			controleur.NbJoueurs(new String("1 joueur"));
		}*/

	    public void actionPerformed(ActionEvent e) {
	      controleur.ChoixJoueurs(this.getSelectedItem());
	    }               
	  }
