package jeu;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Panel extends JPanel {
	private Plateau plateau;

	
	public Panel(Plateau plateau){
		this.plateau = plateau;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(new ImageIcon("chambre.png").getImage(), 0, 0, null);
		
		for (Case i : plateau.getListe_cases()){ 
			g2d.drawImage(new ImageIcon(i.getNom_image()).getImage(), i.getX(), i.getY(), null);
		}}
}