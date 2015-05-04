package bomberman.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;

public class Jeu extends JPanel {
	
	/**
	 * Permettre d'afficher les constituants du plateau
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur = null;
	private Modele modele;
	private Points points;
	
	
	int taille_img = 50;
	
	ImageIcon img_bomb       = new ImageIcon("bombe.png");
	ImageIcon img_explosion  = new ImageIcon("explosion.png");

	
	/**
	 * Constructeur de la classe Jeu
	 * @param controleur
	 */
	public Jeu(Controleur controleur, Modele modele, Points points){
	
		super();
		setLayout(null);
		this.controleur  = controleur;
		this.modele = modele;
		this.points = new Points(controleur, modele);
		this.add(points);
		points.setBounds(850,0,250,900);
		this.add(new Bouton_retour(controleur));
		
	}
	
	
	/**
	 * Afficher les differents elements du plateau
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		String img_blocCassable = modele.getTheme().getImage_bloc_cassable();
		String img_blocIncassable = modele.getTheme().getImage_bloc_incassable();
		
		
		// Afficher le fond d'ecran.
		this.setBackground(new Color(0,0,0));
		//g2d.drawImage(new ImageIcon("chambre.png").getImage(), 0, 0, null);
		
		
		// Afficher le plateau de depart avec les blocs.
		for( int x = 0; x < controleur.getMapWidth(); ++x ) {
			for( int y = 0; y < controleur.getMapHeight(); ++y ) {
				
				if ( controleur.estBlocIncassable(x,y) ) {
					
					g2d.drawImage( new ImageIcon(img_blocIncassable).getImage(), x*taille_img, y*taille_img, null);
				}
				if ( controleur.estBlocCassable(x,y) ) {
					g2d.drawImage( new ImageIcon(img_blocCassable).getImage(), x*taille_img, y*taille_img, null);
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
		
		// Afficher les bonus.
		for (int id = 0; id < controleur.getSizeBonus(); ++id){
			Point point = controleur.getBonusPosition( id );
			String image = controleur.getTypeBonus(id);
			g2d.drawImage(new ImageIcon(image).getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
		}
		
		// Afficher les personnages.
		for ( int id = 0; id < controleur.getNumberPersonnage(); ++id ){
			if (modele.getPersonnage(id).getVivant()){
			    Point point = controleur.getPersonnagePosition( id );
			    String img_personnage = controleur.getPersonnageNomImage( id );
			    g2d.drawImage(new ImageIcon(img_personnage).getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
			}
		}
		// Afficher les personnages mechants (malus)
		for ( int id = 0; id < modele.getMalus().size(); ++id ){
		    Point point = controleur.getMalusPosition( id );
		    String img_malus = modele.getMalus().get(id).getNom_image();
		    g2d.drawImage(new ImageIcon(img_malus).getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
		}
		
		// Afficher les morts.
		/*for (int id = 0; id < controleur.getSizeMorts(); ++id){
			Point point = controleur.getMortPosition( id );
			String image = "mort.png";
			g2d.drawImage(new ImageIcon(image).getImage(), point.x*taille_img, point.y*taille_img, taille_img, taille_img, null);
		}*/
		
		
	}


	public Points getPoints() {
		return points;
	}


	public void setPoints(Points points) {
		this.points = points;
	}
} 

