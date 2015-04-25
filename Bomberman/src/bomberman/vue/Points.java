package bomberman.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele ;

public class Points extends JPanel {
	
/**
* La classe qui affiche les points et les bonus.
*/
	
	private static final long serialVersionUID = 1L;
	private Modele modele = null;
	private Controleur controleur = null ;

	public Points(Controleur controleur, Modele modele){
		this.modele = modele ;
		this.controleur = controleur ;
		setLayout(null);
		Creation_Trame();
		this.setBackground(new Color(0,0,0));
		
	}
	
	public void Creation_Trame (){
	
		Label label1 = new Label("Etat du jeu");
		label1.setFont(new java.awt.Font("Comic Sans MS",1,40));
		label1.setForeground(new Color(175,175,175));
		label1.setBounds(60,30,300,50);
		this.add(label1);
		//for ( int id = 0; id < controleur.getNumberPersonnage(); ++id );
			//Points.add(new Texte());

}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		this.setBackground(new Color(0,0,0));
		
		for ( int id = 0; id < controleur.getNumberPersonnage(); ++id ){

			    int Nombre_Vies = modele.getPersonnage( id ).getNb_vies();
			    g2d.drawImage(new ImageIcon("personnage1.png").getImage(), 50, 100+130*id, 80, 20, null);
			    g2d.drawImage(new ImageIcon("bonus_vie.png").getImage(), 50, 140+130*id, 30, 30, null);
			    g2d.drawImage(new ImageIcon("bonus_intensite1.png").getImage(), 50, 180+130*id, 30, 30, null);
			    
			    
			}
		
	}
	
}

