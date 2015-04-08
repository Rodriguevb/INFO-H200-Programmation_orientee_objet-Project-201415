package bomberman.vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import bomberman.controleur.Controleur;

public class Vue extends JFrame{
	
	/**
	 * La fenetre
	 */
	private static final long serialVersionUID = 1L;
	
	private Menu menu = null;
	private Jeu  jeu  = null;

	public Vue (Controleur controleur){
		super("bomberman");
	    this.setSize(800, 600);
	    this.setMinimumSize( new Dimension(500,400) );
	    this.setMaximumSize( new Dimension(800,600) );
	    this.setLocationRelativeTo(null); // Centre la fenetre au milieu de l'Žcran
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termine le processus lorsqu'on clique sur la croix rouge
	    this.setVisible(true); // Rend la fenetre visible
	    
	    menu = new Menu(controleur);
	    jeu  = new Jeu(controleur);
	    
	    menu.setFocusable(true);
	    jeu.setFocusable(true);
	    
	    this.switchToMenu();
	}
	
	
	public void switchToMenu() {
		this.getContentPane().removeAll();
		this.getContentPane().add( menu );
		this.getContentPane().setFocusable( true );
		this.getContentPane().requestFocus();
		menu.requestFocus();
		this.getContentPane().validate();
	}
	
	public void switchToJeu() {
		this.getContentPane().removeAll();
		this.getContentPane().add( jeu );
		this.getContentPane().setFocusable( true );
		this.getContentPane().requestFocus();
		jeu.requestFocus();
		this.getContentPane().validate();
	}
	
}
