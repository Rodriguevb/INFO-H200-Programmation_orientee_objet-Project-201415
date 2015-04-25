package bomberman.vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;

public class Vue extends JFrame{
	
	/**
	 * La fenetre
	 */
	private static final long serialVersionUID = 1L;
	
	private final Menu menu;
	private final SousMenu sousmenu;
	private final Explications explications ;
	private final Jeu  jeu;
	private final Points points;
	private final Object option;
	private Modele modele;
	
	
	CardLayout cl = new CardLayout();
	String[] listContent = {"Menu", "SousMenu", "Explications", "Jeu"};
	JPanel content = new JPanel();
	int indice = 0;
	
	public Vue(Controleur controleur, Modele modele){
		
		super("Bomberman");
	    this.setSize(860, 890);
	    this.setMinimumSize( new Dimension(860,890) );
	    this.setMaximumSize( new Dimension(900,1100) );
	    this.setLocationRelativeTo(null); // Centre la fenetre au milieu de l'Žcran
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Termine le processus lorsqu'on clique sur la croix rouge
	    
	    
	    
		menu = new Menu(controleur);
		sousmenu = new SousMenu (controleur);
		points = new Points(controleur,modele);
		jeu  = new Jeu(controleur, modele,points);
		explications = new Explications (controleur);  
		option = null; // TODO: Option(controleur)
		
		this.modele = modele;
	    
	    content.setLayout(cl); 
	    content.add(menu, listContent[0]);
	    content.add(sousmenu, listContent[1]);
	    content.add(explications, listContent[2]);
	    content.add(jeu,listContent[3]);

	
	    //menu.setFocusable(true);
	    //jeu.setFocusable(true);
	    
	    //this.switchToMenu();
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.setVisible(true); // Rend la fenetre visible
	}
	
	
	public Points getPoints(){
		return points;
	}
	
	public void switchToMenu() {
		/*this.getContentPane().removeAll();
		this.getContentPane().add( menu );
		this.getContentPane().setFocusable( true );
		this.getContentPane().requestFocus();
		menu.requestFocus();
		this.getContentPane().validate();
		*/
		cl.show(content, listContent[0]);
	}
	

	public void switchToSousMenu() {
	/*	this.getContentPane().removeAll();
		this.getContentPane().add( sousmenu );
		this.getContentPane().setFocusable( true );
		this.getContentPane().requestFocus(); // permet au clavier de fonctionner sur le panel
		sousmenu.requestFocus();
		this.getContentPane().validate();
	*/	
		cl.show(content, listContent[1]);
	}
	
	public void switchToExplications() {
	/*	this.getContentPane().removeAll();
		this.getContentPane().add( explications );
		this.getContentPane().setFocusable( true );
		this.getContentPane().requestFocus(); // permet au clavier de fonctionner sur le panel
		explications.requestFocus();
		this.getContentPane().validate();
	*/
		cl.show(content, listContent[2]);
	}
	
	public void switchToJeu() {
		/*this.getContentPane().removeAll();
		this.getContentPane().add( jeu );
		
		this.getContentPane().requestFocus(); // permet au clavier de fonctionner sur le panel
		jeu.requestFocus();
		this.getContentPane().validate();*/
	
		cl.show(content, listContent[3]);
		this.setSize(1200,890);
		 this.setLocationRelativeTo(null);
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
