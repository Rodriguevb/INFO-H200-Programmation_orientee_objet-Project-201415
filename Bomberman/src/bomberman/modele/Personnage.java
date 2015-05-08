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
	private String direction;
	private String nom;
	private int nb_vies;
	private int nb_bombes;
	private boolean vivant;
	private ArrayList<Bonus> bonus_personnage;
	private boolean tunnel;
	private boolean clavier;
	private boolean gilet;
	private int porteeBombe;
	private int dureeBombe;
	
	
	/**
	 * Constructeur de la classe Personnage
	 * @param x L'abscisse du personnage
	 * @param y L'ordonnee du personnage
	 * @param nom Le nom du personnage
	 */
	public Personnage(int x, int y, String nom) {
		super(x,y);
		this.nom = nom;
		this.direction = "Face" ;
		this.nb_vies = 1;
		this.nb_bombes = 1;
		this.vivant = true;
		this.bonus_personnage = new ArrayList<Bonus>();
		this.tunnel = false;
		this.clavier = false;
		this.gilet = false;
		this.porteeBombe = 1 ;
		this.dureeBombe = 1500 ;
	}
	

	public int getDuree() {
		return dureeBombe;
	}


	public void setDuree(int duree) {
		dureeBombe = duree ;
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
	
	public int getPortee(){
		return porteeBombe ;
	}
	
	public void setPortee(int portee){
		porteeBombe = portee ;
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
	 * Savoir la direction du personnage
	 * @return La direction du personnage
	 */
	public String getDirection() {
		return direction;
	}

	
	/**
	 * Modifie la valeur de l'attribut direction
	 * @param direction L'attribut modifie
	 */
	public void setDirection(String direction) {
		this.direction = direction;
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
	 * Fait gagner une vie au personnage
	 */
	public void gagnerVie(){
		this.nb_vies ++ ;
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
		if (avance_x == 1) direction = "Droite" ;
		else if (avance_x == -1) direction = "Gauche";
		else if (avance_y == 1) direction = "Face" ;
		else if (avance_y == -1) direction = "Dos" ;
	}
	
	
	/**
	 * Active les effets des bonus
	 */
	public void activerBonus(){
		int idBonus = 0;
		while (idBonus < bonus_personnage.size()){
			bonus_personnage.get(idBonus).action(this);
			bonus_personnage.remove(idBonus);
		}
			Audio_simple son = new Audio_simple("sonBonus.wav");
			son.start();
		
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