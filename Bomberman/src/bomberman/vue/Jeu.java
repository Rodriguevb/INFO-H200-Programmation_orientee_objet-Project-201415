package bomberman.vue;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Case;
import bomberman.modele.MyKeyListener;
import bomberman.modele.Plateau;

public class Jeu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plateau plateau = new Plateau();
	private Controleur controleur = null; 
	
	
	public Jeu(Controleur controleur){
		super();
		this.controleur  = controleur;
		
		//kListener1 = new MyKeyListener(38,40,37,39,32, 0, plateau,bomberman.vue);
		//kListener2 = new MyKeyListener(90,87,81,83,10, 1,plateau,bomberman.vue);
		
		this.addKeyListener( new MyKeyListener(38,40,37,39,32, 0, plateau, controleur) );
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("chambre.png").getImage(), 0, 0, null);
		
		for (Case i : plateau.getListe_cases()){ 
			g2d.drawImage(new ImageIcon(i.getNom_image()).getImage(), i.getX(), i.getY(), null);
		}
	}

}
