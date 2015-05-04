package bomberman.modele;

import java.util.ArrayList;

import javax.swing.Timer;

import bomberman.Audio_simple;
import bomberman.controleur.Clavier;
import bomberman.controleur.Gilet;
import bomberman.controleur.Tunnel;


public class Personnage extends PossedePosition {
	
	/**
	 * Classe qui represente un personnage
	 */
	private String nom_image;
	private String nom;
	private int nb_vies;
	private int nb_bombes;
	private boolean vivant;
	private ArrayList<Bonus> bonus_personnage;
	private boolean tunnel;
	private boolean clavier;
	private boolean gilet;
	
	
	/**
	 * Constructeur de la classe Personnage
	 * @param x L'abscisse du personnage
	 * @param y L'ordonnee du personnage
	 * @param nom Le nom du personnage
	 */
	public Personnage(int x, int y, String nom) {
		super(x,y);
		this.nom = nom;
		this.nom_image = nom+"Face.png";
		this.nb_vies = 1;
		this.nb_bombes = 1;
		this.vivant = true;
		this.bonus_personnage = new ArrayList<Bonus>();
		this.tunnel = false;
		this.clavier = false;
		this.gilet = false;
	}
	

	/**
	 * Savoir si le personnage a le bonus gilet
	 * @return Vrai si le personnage a le bonus gilet
	 */
	public boolean isGilet() {
		return gilet;
	}


	/**
	 * Modifie la valeur de l'attribut gilet
	 * @param gilet L'attribut modifie
	 */
	public void setGilet(boolean gilet) {
		this.gilet = gilet;
	}


	/**
	 * Savoir si le personnage a le bonus clavier
	 * @return Vrai si le personnage a le bonus clavier
	 */
	public boolean isClavier() {
		return clavier;
	}

	
	/**
	 * Modifie la valeur de l'attribut clavier
	 * @param clavier L'attribut modifie
	 */
	public void setClavier(boolean clavier) {
		this.clavier = clavier;
	}

	
	/**
	 * Savoir si le personnage a le bonus tunnel
	 * @return Vrai si le personnage a le bonus tunnel
	 */
	public boolean isTunnel() {
		return tunnel;
	}

	
	/**
	 * Modifie la valeur de l'attribut tunnel
	 * @param tunnel L'attribut modifie
	 */
	public void setTunnel(boolean tunnel) {
		this.tunnel = tunnel;
	}

	
	/**
	 * Savoir le nom du personnage
	 * @return Le nom du personnage
	 */
	public String getNom() {
		return nom;
	}

	
	/**
	 * Modifie la valeur de l'attribut nom
	 * @param nom L'attribut modifie
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	/**
	 * Savoir le nom de l'image du personnage
	 * @return Le nom de l'image du personnage
	 */
	public String getNom_image() {
		return nom_image;
	}

	
	/**
	 * Modifie la valeur de l'attribut nom_image
	 * @param nom_image L'attribut modifie
	 */
	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}
	
	
	/**
	 * Savoir le nombre de vies du personnage
	 * @return Le nombre de vies du personnage
	 */
	public int getNb_vies(){
		return nb_vies;
	}
	
	
	/**
	 * Fait perdre une vie au personnage
	 */
	public void perdreVie(){
		this.nb_vies -= 1;
		Audio_simple son = new Audio_simple("ouch.wav");
			son.start();
	}
	
	
	/**
	 * Fait perdre une bombe au personnage
	 */
	public void perdreBombe(){
		nb_bombes -= 1;
	}
	
	
	/**
	 * Fait gagner une bombe au personnage
	 */
	public void gagnerBombe(){
		nb_bombes += 1;
	}
	
	
	/**
	 * Savoir si le personnage est en vie
	 * @return Vrai si le personnage est en vie
	 */
	public boolean getVivant(){
		return vivant;
	}
	
	
	/**
	 * Permet la mort du personnage
	 */
	public void mourir(){
		vivant = false;
	}
	
	
	/**
	 * Recupere la liste des bonus que detient le personnage
	 * @return La liste des bonus que detient le personnage
	 */
	public ArrayList<Bonus> getBonus_personnage(){
		return bonus_personnage;
	}
	
	
	/**
	 * Permet de deplacer le personnage et de changer son nom image en fonction de sa direction
	 * @param avance_x Le deplacement selon x
	 * @param avance_y Le deplacement selon y
	 */
	public void move(int avance_x, int avance_y) {
		this.x += avance_x;
		this.y += avance_y;
		if (avance_x == 1) this.nom_image = nom + "Droite.png";
		else if (avance_x == -1) this.nom_image = nom + "Gauche.png";
		else if (avance_y == 1) this.nom_image = nom + "Face.png" ;
		else if (avance_y == -1) this.nom_image = nom + "Dos.png" ;
	}
	
	
	/**
	 * Active les effets des bonus : vie, bombe, tunnel, clavier et bouclier
	 */
	public void activerBonus(){
		int idBonus = 0;
		while (idBonus < bonus_personnage.size()){
			if (bonus_personnage.get(idBonus).getBonus_vie() == 1){
				nb_vies++;
				bonus_personnage.remove(idBonus);
			}
			else if (bonus_personnage.get(idBonus).getBonus_bombe() == 1){
				nb_bombes++;
				bonus_personnage.remove(idBonus);
			}
			else if (bonus_personnage.get(idBonus).getBonus_tunnel() == 1){
				tunnel = true;
				bonus_personnage.remove(idBonus);
				Timer timerTunnel = new Timer(10000, new Tunnel(this));
				timerTunnel.setRepeats(false);
				timerTunnel.start();
			}
			else if (bonus_personnage.get(idBonus).getBonus_clavier() == 1){
				clavier = true;
				bonus_personnage.remove(idBonus);
				Timer timerClavier = new Timer(10000, new Clavier(this));
				timerClavier.setRepeats(false);
				timerClavier.start();
			}
			else if (bonus_personnage.get(idBonus).getBonus_bouclier() == 1){
				gilet = true;
				bonus_personnage.remove(idBonus);
				Timer timerGilet = new Timer(10000, new Gilet(this));
				timerGilet.setRepeats(false);
				timerGilet.start();
			}
			else {
				idBonus++;
			}
			Audio_simple son = new Audio_simple("sonBonus.wav");
			son.start();
		}
	}
	
	
	/**
	 * Savoir si le personnage a un bonus clavier dans sa liste bonus_personnage
	 * @return Vrai si le personnage a un bonus clavier dans sa liste bonus_clavier
	 */
	public boolean ownBonusClavier(){
		boolean bonus = false;
		int idBonus = 0;
		while (idBonus < bonus_personnage.size()){
			if (bonus_personnage.get(idBonus).getBonus_clavier() == 1){
				bonus = true;
				bonus_personnage.remove(idBonus);
			}
			else idBonus++;
		}
		return bonus;
	}
	
	
	/**
	 * Retire un bonus de la liste bonus_personnage en connaissant son ID dans la liste
	 * @param idBonus L'ID du bonus dans la liste bonus_personnage
	 */
	public void removeBonus(int idBonus){
		bonus_personnage.remove(idBonus);
	}

	
	/**
	 * Savoir le nombre de bombes du personnage
	 * @return Le nombre de bombes du personnage
	 */
	public int getNb_bombes() {
		return nb_bombes;
	}

	
	/**
	 * Modifie la valeur de l'attribut nb_bombes
	 * @param nb_bombes L'attribut modifie
	 */
	public void setNb_bombes(int nb_bombes) {
		this.nb_bombes = nb_bombes;
	}

}