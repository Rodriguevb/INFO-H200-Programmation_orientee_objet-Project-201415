package bomberman.vue;



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
	
	/**
	 * La classe qui affiche le menu.
	 */
	private static final long serialVersionUID = 1L;
	
		
	public SousMenu(Controleur controleur, Modele modele) {

		
		Bouton_retour bouton_retour = new Bouton_retour(controleur);
		bouton_retour.setPreferredSize(new Dimension(220, 50));	
		
		Bouton_nbjoueurs bouton_nbjoueurs = new Bouton_nbjoueurs(controleur); 
		bouton_nbjoueurs.setPreferredSize(new Dimension(200, 50));	
		
	    Bouton_niveau bouton_niveau = new Bouton_niveau(controleur);
	    bouton_niveau.setPreferredSize(new Dimension(200, 50));	
	    
		Bouton_choixTheme bouton_choixTheme = new Bouton_choixTheme(controleur);
		bouton_choixTheme.setPreferredSize(new Dimension(200, 50));	
		
		Bouton_go bouton_go = new Bouton_go(controleur, modele);
		bouton_go.setPreferredSize(new Dimension(230, 60));	
	

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
    	
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		this.add(bouton_retour, gbc);
		//-------------------------------------------
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2 ;	
		//-------------------------------------------
		gbc.gridx = 0;
		gbc.gridy = 1 ;
		gbc.gridwidth = 1;
		this.add(bouton_nbjoueurs, gbc);
		//-------------------------------------------
		gbc.gridx = 1 ;	
		gbc.gridy = 1 ;
		this.add(bouton_choixTheme, gbc);
		//-------------------------------------------
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 2 ;	
		gbc.gridy = 1 ;
		this.add(bouton_niveau, gbc);
		//-------------------------------------------
		gbc.gridwidth = 1 ;
		gbc.gridx = 1 ;	
		gbc.gridy = 2 ;
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

