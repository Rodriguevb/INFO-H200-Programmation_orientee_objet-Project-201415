package panel;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	/**
	 * La fenetre
	 */
	private static final long serialVersionUID = 1L;

	public Fenetre (){
		super("Bomberman");
	    this.setSize(800, 600);
	    this.setMinimumSize( new Dimension(500,400) );
	    this.setMaximumSize( new Dimension(800,600) );
	    this.setLocationRelativeTo(null); // Centre la fenetre au milieu de l'Žcran
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termine le processus lorsqu'on clique sur la croix rouge
	     
	    this.setVisible(true); // Rend la fenetre visible
	}
}
