package bomberman.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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

	public Points(Controleur controleur, Modele modele){
		
		this.modele = modele ;
		this.controleur = controleur ;
		this.setBackground(new Color(0,0,0));
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		SousPoints points1 = new SousPoints(0, modele);		
		SousPoints points2 = new SousPoints(1, modele);
		SousPoints points3 = new SousPoints(2, modele);
		SousPoints points4 = new SousPoints(3, modele);
		
		SousPoints[] liste = {points1, points2, points3, points4};
		
		for (int i = 0 ; i < controleur.getNbJoueurs() ; i++) {
	    	gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			this.add(liste[i], gbc);
			
		}
	}
}
		
		
