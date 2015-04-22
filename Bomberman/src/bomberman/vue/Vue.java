package bomberman.vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;

public class Vue extends JFrame{
	
	/**
	 * La fenetre
	 */
	private static final long serialVersionUID = 1L;
	
	private final Menu menu;
	private final Jeu  jeu;
	private final Object option;
	private Modele modele;

	public Vue (Controleur controleur, Modele modele){
		super("Bomberman");
	    this.setSize(860, 890);
	    this.setMinimumSize( new Dimension(500,400) );
	    this.setMaximumSize( new Dimension(900,1100) );
	    this.setLocationRelativeTo(null); // Centre la fenetre au milieu de l'Žcran
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termine le processus lorsqu'on clique sur la croix rouge
	    this.setVisible(true); // Rend la fenetre visible
	    
	    this.modele = modele;
	    
	    menu = new Menu(controleur);
	    jeu  = new Jeu(controleur, modele);
	    option = null; // TODO: Option(controleur)
	    
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
		this.getContentPane().requestFocus(); // permet au clavier de fonctionner sur le panel
		jeu.requestFocus();
		this.getContentPane().validate();
	}


	public void switchToOptions() {
		this.getContentPane().removeAll();
		//TODO this.getContentPane().add( option );
		this.getContentPane().setFocusable( true );
		this.getContentPane().requestFocus(); // permet au clavier de fonctionner sur le panel
		//TODO option.requestFocus();
		this.getContentPane().validate();
	}
	
	public Jeu getJeu(){
		return jeu;
	}
	
}
