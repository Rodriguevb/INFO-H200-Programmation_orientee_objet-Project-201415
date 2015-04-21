package bomberman.vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.controleur.ListenerPlayer;

public class Jeu extends JPanel {
	
	/**
	 * Permettre d'afficher les constituants du plateau
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	
	
	int taille_img = 50;
	ImageIcon blocIncassable = new ImageIcon("brique_grise.JPG");
	ImageIcon blocCassable   = new ImageIcon("brique.JPG");
	//ImageIcon img_personnage = new ImageIcon("bob.png");
	ImageIcon img_bomb       = new ImageIcon("bombe.png");
	ImageIcon img_explosion  = new ImageIcon("explosion.png");
	
	
	/**
	 * Constructeur de la classe Jeu
	 * @param controleur
	 */
	public Jeu(Controleur controleur){
		super();
		this.controleur  = controleur;
		
		//kListener1 = new ListenerPlayer(38,40,37,39,32, 0, plateau,bomberman.vue);
		//kListener2 = new ListenerPlayer(90,87,81,83,10, 1,plateau,bomberman.vue);
		
		//this.addKeyListener( new ListenerPlayer(38,40,37,39,32, controleur, 0) );
		
		ListenerPlayer listenerPlayer1 = new ListenerPlayer(controleur, 0);
		listenerPlayer1.setKeyForUp( KeyEvent.VK_UP );
		listenerPlayer1.setKeyForDown( KeyEvent.VK_DOWN );
		listenerPlayer1.setKeyForLeft( KeyEvent.VK_LEFT );
		listenerPlayer1.setKeyForRight( KeyEvent.VK_RIGHT );
		listenerPlayer1.setKeyForDrop( KeyEvent.VK_SPACE );
		
		this.addKeyListener( listenerPlayer1 );
	}
	
	
	/**
	 * Afficher les differents elements du plateau
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		// Afficher le fond d'ecran.
		g2d.drawImage(new ImageIcon("chambre.png").getImage(), 0, 0, null);
		
		
		// Afficher le plateau de depart avec les blocs.
		for( int x = 0; x < controleur.getMapWidth(); ++x ) {
			for( int y = 0; y < controleur.getMapHeight(); ++y ) {
				
				if ( controleur.estBlocIncassable(x,y) ) {
					g2d.drawImage( blocIncassable.getImage(), x*taille_img, y*taille_img, null);
				}
				if ( controleur.estBlocCassable(x,y) ) {
					g2d.drawImage( blocCassable.getImage(), x*taille_img, y*taille_img, null);
				}
				
			}
		}
		
		// Afficher les bombes.
		for ( int id = 0; id < controleur.getSizeBomb(); ++id ){
			Point point = controleur.getBombPosition( id );
			g2d.drawImage( img_bomb.getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
		}
		
		// Afficher les explosions.
		for ( int id = 0; id < controleur.getSizeExplosion(); ++id ){
			Point point = controleur.getExplosionPosition( id );
			g2d.drawImage( img_explosion.getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
		}
		
		
		// Afficher les personnages.
		for ( int id = 0; id < controleur.getNumberPersonnage(); ++id ){
			Point point = controleur.getPersonnagePosition( id );
			String img_personnage = controleur.getPersonnageNomImage( id );
			g2d.drawImage(new ImageIcon(img_personnage).getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
		}
		
		// Afficher les morts.
		for (int id = 0; id < controleur.getSizeMorts(); ++id){
			Point point = controleur.getMortPosition( id );
			String image = "mort.png";
			g2d.drawImage(new ImageIcon(image).getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
		}
	}
} 

