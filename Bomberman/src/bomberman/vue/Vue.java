package bomberman.vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	
	
	
	private CardLayout cl = new CardLayout();
	private String[] listContent = {"Menu", "SousMenu", "Explications", "Jeu"};
	private JPanel content = new JPanel();
	private Controleur controleur ;

	
	/**
	 * Constructeur de la classe Vue
	 * @param controleur Le controleur du jeu
	 * @param modele Le modele du jeu
	 */
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
	
	
	/**
	 * Recupere les points
	 * @return les points
	 */
	public Points getPoints(){
		
		return points;
	}
	
	
	/**
	 * Affiche le panel Menu
	 */
	public void switchToMenu() {
		
		cl.show(content, listContent[0]);
	}
	

	/**
	 * Affiche le panel SousMenu
	 */
	public void switchToSousMenu() {
		
		cl.show(content, listContent[1]);
	}
	
	
	/**
	 * Affiche le panel Explications
	 */
	public void switchToExplications() {
		
		cl.show(content, listContent[2]);
	}
	
	
	/**
	 * Affiche le panel Jeu
	 */
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

	
	/**
	 * Recupere le jeu
	 * @return le jeu
	 */
	public Jeu getJeu(){
		return jeu;
	}

}
