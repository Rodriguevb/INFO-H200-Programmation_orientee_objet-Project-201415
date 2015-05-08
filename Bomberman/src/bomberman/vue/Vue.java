package bomberman.vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;

public class Vue extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * La fenetre
	 */

	
	private final Menu menu;
	private final SousMenu sousmenu;
	private final Explications explications ;
	private final Jeu  jeu;
	private final Points points;
	
	
	
	private CardLayout cl = new CardLayout();
	private String[] listContent = {"Menu", "SousMenu", "Explications", "Jeu"};
	private JPanel content = new JPanel();
	private Controleur controleur ;

	
	public Vue(Controleur controleur, Modele modele){
		
		super("Bomberman");
	    this.setSize(860, 890);
	    this.controleur = controleur ;
	    //this.setMinimumSize( new Dimension(860,890) );
	    //this.setMaximumSize( new Dimension(860,890) );
	    this.setLocationRelativeTo(null); 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    
		menu = new Menu(controleur);
		sousmenu = new SousMenu (controleur, modele);
		points = new Points(controleur, modele);
		jeu  = new Jeu(controleur, modele,points);
		explications = new Explications (controleur);  
		
	    
	    content.setLayout(cl); 
	    content.add(menu, listContent[0]);
	    content.add(sousmenu, listContent[1]);
	    content.add(explications, listContent[2]);
	    content.add(jeu,listContent[3]);

	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.setVisible(true); 
	}
	
	
	public Points getPoints(){
		
		return points;
	}
	
	public void switchToMenu() {
		
		cl.show(content, listContent[0]);
	}
	

	public void switchToSousMenu() {
		
		cl.show(content, listContent[1]);
	}
	
	public void switchToExplications() {
		
		cl.show(content, listContent[2]);
	}
	
	public void switchToJeu() {
		
		cl.show(content, listContent[3]);
		this.setSize((controleur.getMapWidth())*50+150, (controleur.getMapHeight())*50+45);
		this.setLocationRelativeTo(null);
		this.getContentPane().setFocusable( true );
		this.getContentPane().requestFocus(); // permet au clavier de fonctionner sur le panel
		jeu.requestFocus();
		this.getContentPane().validate();
		points.creerPoints();
		points.setBounds(controleur.getMapWidth()*50, 0, 150, (controleur.getMapHeight())*50+45);
		
		
	}

	public Jeu getJeu(){
		return jeu;
	}

}
