package bomberman.vue;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import bomberman.controleur.Controleur;

public class Menu extends JPanel {
	
	/**
	 * La classe qui affiche le menu.
	 */
	private static final long serialVersionUID = 1L;
	

	public Menu(Controleur controleur) {
		
		JButton bouton_jouer = new Bouton_jouer(controleur);
		bouton_jouer.setPreferredSize(new Dimension(240, 70));	
		JButton bouton_explications = new Bouton_explications(controleur);
		bouton_explications.setPreferredSize(new Dimension(240, 70));	

	
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    gbc.gridheight = 1;
	    gbc.insets = new Insets(-125,0,25,0) ;
	    this.add(bouton_jouer, gbc);
	    //--------------------------------------------
	    gbc.insets = new Insets(0,0,0,0) ;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    gbc.gridy = 1 ;	
	    this.add(bouton_explications, gbc);	
	    //---------------------------------------------
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("fond_bomber.jpg").getImage(), 0, 0, 850, 850, null);
	}
}


