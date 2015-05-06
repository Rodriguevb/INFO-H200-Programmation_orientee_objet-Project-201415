package bomberman.vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;

public class Points extends JPanel {
	
/**
* La classe qui affiche le nombre de vies et de bonus de chaque personnage.
*/
	
	
	private Modele modele = null;
	private Controleur controleur = null ;
	private GridBagConstraints gbc;
	private SousPoints points1;		
	private SousPoints points2;
	private SousPoints points3;
	private SousPoints points4;
	private SousPoints[] liste;

	public Points(Controleur controleur, Modele modele){
		
		this.modele = modele ;
		this.controleur = controleur ;
		this.setBackground(new Color(0,0,0));
		
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		

	}
	
	public void creerPoints(){
	
		
		for (int i = 0 ; i < controleur.getNbJoueurs() ; i++) {
			SousPoints points = new SousPoints(i, controleur.getPersonnageNom(i), modele);
	    	gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.insets = new Insets(15,0,15,0) ;
			this.add(points, gbc);
			
		}
	}
}
		
		
