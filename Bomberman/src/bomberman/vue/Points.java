package bomberman.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele ;

public class Points extends JPanel {
	
/**
* La classe qui affiche le nombre de vies et de bonus de chaque personnage.
*/
	
	private static final long serialVersionUID = 1L;
	private Modele modele = null;
	private Controleur controleur = null ;
	private ArrayList<LabelNombre> listeLabels = new ArrayList<LabelNombre>();

	public Points(Controleur controleur, Modele modele){
		this.modele = modele ;
		this.controleur = controleur ;
		setLayout(null);
		this.setBackground(new Color(0,0,0));
		CreationListeLabels();
		CreationTrame();
		
		
	
	}
	
	public void CreationTrame (){
	
		Label label1 = new Label("Etat du jeu");
		label1.setFont(new java.awt.Font("Comic Sans MS",1,40));
		label1.setForeground(new Color(175,175,175));
		label1.setBounds(60,30,300,50);
		this.add(label1);
		for (LabelNombre label : listeLabels){
			this.add(label);
		}
	}	
	
	public void CreationListeLabels(){
		
		for (int i = 0 ; i < 4 ; i++){
			for (int j = 0 ; j < 2 ; j++){
			listeLabels.add(new LabelNombre(i, j, "", 140 + 150*i + 40 *j));
			}
		}
	}
		
		


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for ( int id = 0; id < controleur.getNumberPersonnage(); ++id ){

			    int Nombre_Vies = modele.getPersonnage( id ).getNb_vies();
			    g2d.drawImage(new ImageIcon("personnage1.png").getImage(), 50, 100+150*id, 80, 30, null);
			    g2d.drawImage(new ImageIcon("bonus_vie.png").getImage(), 50, 140+150*id, 30, 30, null);
			    g2d.drawImage(new ImageIcon("bonus_intensite1.png").getImage(), 50, 180+150*id, 30, 30, null);
			
		for (LabelNombre label : listeLabels){
			if (label.getPersonnageConcerne() == id && label.getObjetConcerne() == 0){
				label.setText(Integer.toString(Nombre_Vies));
				System.out.println(label.getNbAffiche());
				
			}
			
		}
		}
	}
	
	
	
}

