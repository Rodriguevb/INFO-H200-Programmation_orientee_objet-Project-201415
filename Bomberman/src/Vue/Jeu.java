package Vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controleur.Controleur;
import jeu.Case;
import jeu.Plateau;

public class Jeu extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Plateau plateau = new Plateau();
	private Controleur controleur = null; 
	
	
	public Jeu(Controleur controleur){
		super();
		this.controleur  = controleur;
		this.addKeyListener(this);
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("chambre.png").getImage(), 0, 0, null);
		
		for (Case i : plateau.getListe_cases()){ 
			g2d.drawImage(new ImageIcon(i.getNom_image()).getImage(), i.getX(), i.getY(), null);
		}
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
