package bomberman.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;




import bomberman.modele.Modele ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SousPoints extends JPanel {
	
	int idPersonnage ;
	Modele modele;
	JLabel labelVie ;
	JLabel labelBombe ;
	
	public SousPoints (int id, Modele modele){
		
		setLayout(null);
		this.setPreferredSize(new Dimension(100, 160));
		
		idPersonnage = id ;
		this.modele = modele ;
		Label nom_perso = new Label("Joueur " + Integer.toString(id + 1));
		nom_perso.setBounds(0, 0, 90, 20);
		nom_perso.setFont(new java.awt.Font("Comic Sans MS",1,20));
		nom_perso.setForeground(new Color(175,175,175));
		nom_perso.setBackground(new Color(0,0,0));
		this.setBackground(new Color(0,0,0));
		this.add(nom_perso);
		
		labelVie = new JLabel();
		labelVie.setFont(new java.awt.Font("Comic Sans MS",1,15));
		labelVie.setForeground(new Color(175,175,175));
		labelVie.setBounds(50,40,30,30);		
		this.add(labelVie);
		
		labelBombe = new JLabel();
		labelBombe.setFont(new java.awt.Font("Comic Sans MS",1,15));
		labelBombe.setForeground(new Color(175,175,175));
		labelBombe.setBounds(50,80,30,30);
		this.add(labelBombe);
}
	

	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		int Nombre_Vies = modele.getPersonnage( idPersonnage ).getNb_vies();
		int Nombre_Bombes = modele.getPersonnage( idPersonnage ).getNb_bombes();
		
		g2d.drawImage(new ImageIcon("Coeur(1).png").getImage(), 0, 40, 30, 30, null);
		g2d.drawImage(new ImageIcon("bombe.png").getImage(), 0, 80, 30, 30, null);
			
		
		labelVie.setText(Integer.toString(Nombre_Vies));
		labelBombe.setText(Integer.toString(Nombre_Bombes));
		
	}

}
