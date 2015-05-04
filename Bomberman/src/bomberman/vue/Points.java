package bomberman.vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;

public class Points extends JPanel {
	
/**
* La classe qui affiche le nombre de vies et de bonus de chaque personnage.
*/
	
	private static final long serialVersionUID = 1L;
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
		
		points1 = new SousPoints(0, modele);		
		points2 = new SousPoints(1, modele);
		points3 = new SousPoints(2, modele);
		points4 = new SousPoints(3, modele);
		
		liste = new SousPoints[] {points1, points2, points3, points4};
		
		/*for (int i = 0 ; i < controleur.getNbJoueurs() ; i++) {
	    	gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			this.add(liste[i], gbc);
			
		}*/
	}
	
	public void creerPoints(){
		for (int i = 0 ; i < controleur.getNbJoueurs() ; i++) {
	    	gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			this.add(liste[i], gbc);
			
		}
	}
}
		
		
