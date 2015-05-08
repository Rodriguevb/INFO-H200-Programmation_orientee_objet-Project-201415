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
	
	
	private static final long serialVersionUID = 1L;
	private int idPersonnage ;
	private Modele modele;
	private JLabel labelVie ;
	private JLabel labelBombe ;
	private JLabel labelGilet ;
	private JLabel labelTunnel ;
	
	
	/**
	 * Constructeur de la classe SousPoints
	 * @param id L'identifiant du joueur
	 * @param nom Le nom du personnage
	 * @modele Le modele du jeu
	 */
	public SousPoints (int id, String nom, Modele modele){
		
		setLayout(null);
		this.setPreferredSize(new Dimension(100, 160));
		
		idPersonnage = id ;
		this.modele = modele ;
		Label nom_perso = new Label(nom);
		nom_perso.setBounds(0, 0, 90, 20);
		nom_perso.setFont(new java.awt.Font("Comic Sans MS",1,20));
		nom_perso.setForeground(new Color(175,175,175));
		nom_perso.setBackground(new Color(0,0,0));
		this.setBackground(new Color(0,0,0));
		this.add(nom_perso);
		
		labelVie = new JLabel();
		labelVie.setFont(new java.awt.Font("Comic Sans MS",1,15));
		labelVie.setForeground(new Color(175,175,175));
		labelVie.setBounds(50,30,25,25);		
		this.add(labelVie);
		
		labelBombe = new JLabel();
		labelBombe.setFont(new java.awt.Font("Comic Sans MS",1,15));
		labelBombe.setForeground(new Color(175,175,175));
		labelBombe.setBounds(50,60,25,25);
		this.add(labelBombe);
		
		labelGilet = new JLabel();
		labelGilet.setFont(new java.awt.Font("Comic Sans MS",1,15));
		labelGilet.setForeground(new Color(175,175,175));
		labelGilet.setBounds(50,90,40,25);
		this.add(labelGilet);
		
		labelTunnel = new JLabel();
		labelTunnel.setFont(new java.awt.Font("Comic Sans MS",1,15));
		labelTunnel.setForeground(new Color(175,175,175));
		labelTunnel.setBounds(50,120,40,25);
		this.add(labelTunnel);
}
	

	
	/**
	 * Affiche les images de SousPoints
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		int Nombre_Vies = modele.getPersonnage( idPersonnage ).getNb_vies();
		int Nombre_Bombes = modele.getPersonnage( idPersonnage ).getNb_bombes();
		boolean Possede_gilet = modele.getPersonnage( idPersonnage ).isGilet();
		boolean Possede_Tunnel = modele.getPersonnage( idPersonnage ).isTunnel();
		
		g2d.drawImage(new ImageIcon("BonusVie.png").getImage(), 0, 30, 25, 25, null);
		g2d.drawImage(new ImageIcon("BonusBombe.png").getImage(), 0, 60, 25, 25, null);
		g2d.drawImage(new ImageIcon("jacket.png").getImage(), 0, 90, 25, 25, null);
		g2d.drawImage(new ImageIcon("BonusTunnel.png").getImage(), 0, 120, 25, 25, null);
			
		
		labelVie.setText(Integer.toString(Nombre_Vies));
		labelBombe.setText(Integer.toString(Nombre_Bombes));
		labelGilet.setText(Boolean.toString(Possede_gilet));
		labelTunnel.setText(Boolean.toString(Possede_Tunnel));
		
	}

}
