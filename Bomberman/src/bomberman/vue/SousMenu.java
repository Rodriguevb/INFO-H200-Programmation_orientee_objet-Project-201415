package bomberman.vue;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele ;

public class SousMenu extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * La classe qui affiche le menu.
	 */
	
		
	public SousMenu(Controleur controleur, Modele modele) {


				
		Bouton_retour bouton_retour = new Bouton_retour(controleur);
		bouton_retour.setPreferredSize(new Dimension(200, 40));
		bouton_retour.setBackground(new Color(151,201,59));
		bouton_retour.setFont(new java.awt.Font("Serif",1,20));
		
		Bouton_nbjoueurs bouton_nbjoueurs = new Bouton_nbjoueurs(controleur); 
		bouton_nbjoueurs.setPreferredSize(new Dimension(130, 40));	
		bouton_nbjoueurs.setBackground(new Color(151,201,59));
		
	    Bouton_niveau bouton_niveau = new Bouton_niveau(controleur);
	    bouton_niveau.setPreferredSize(new Dimension(110, 40));	
	    bouton_niveau.setBackground(new Color(151,201,59));
	    
		Bouton_choixTheme bouton_choixTheme = new Bouton_choixTheme(controleur);
		bouton_choixTheme.setPreferredSize(new Dimension(100, 40));
		bouton_choixTheme.setBackground(new Color(151,201,59));
		
		Bouton_go bouton_go = new Bouton_go(controleur, modele);
		bouton_go.setPreferredSize(new Dimension(250, 80));
		bouton_go.setBackground(new Color(151,201,59));
	

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
    	
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0.2;
		gbc.anchor = GridBagConstraints.CENTER ;
		this.add(bouton_retour, gbc);
		//-------------------------------------------
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2 ;	
		//-------------------------------------------
		gbc.insets = new Insets(0,0,0,-30) ;
		gbc.gridx = 0;
		gbc.gridy = 1 ;
		gbc.gridwidth = 1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.PAGE_START ;
		this.add(bouton_nbjoueurs, gbc);
		//-------------------------------------------
		gbc.gridx = 1 ;	
		gbc.gridy = 1 ;
		gbc.weighty = 0.1;
		gbc.insets = new Insets(0,0,0,0) ;
		gbc.anchor = GridBagConstraints.PAGE_START ;
		this.add(bouton_choixTheme, gbc);
		//-------------------------------------------
		gbc.insets = new Insets(0,-30,0,0) ;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2 ;	
		gbc.gridy = 1 ;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.PAGE_START ;
		this.add(bouton_niveau, gbc);
		//-------------------------------------------
		gbc.gridwidth = 1 ;
		gbc.insets = new Insets(0,0,0,0) ;
		gbc.gridx = 1 ;	
		gbc.gridy = 2 ;
		gbc.weighty = 0.7;
		gbc.anchor = GridBagConstraints.PAGE_START ;
		this.add(bouton_go, gbc);
		//-------------------------------------------
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2 ;	
		gbc.gridy = 2 ;
}		

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("fond_bomber.jpg").getImage(), 0, 0, 850, 850, null);
	}
	

}

