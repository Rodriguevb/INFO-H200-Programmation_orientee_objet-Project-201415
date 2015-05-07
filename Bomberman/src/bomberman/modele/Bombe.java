package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Controleur;
import bomberman.controleur.Explosion;

public class Bombe extends PossedePosition {
	
	/**
	 * Classe qui represente une bombe
	 */
	private Timer timer;
	private int portee;
	private int duree;
	private int idPersonnage;
	private Explosion explosion;
	private int idMalus ;

	
	/**
	 * Constructeur de la classe Bombe
	 * @param x L'abscisse de la bombe
	 * @param y L'ordonnee de la bombe
	 * @param portee La portee de la bombe
	 * @param duree La duree avant que la bombe explose
	 * @param controleur Le controleur
	 * @param idPersonnage L'ID du personnage qui a pose la bombe
	 * @param idMalus L'ID du malus qui a pose la bombe
	 */
	public Bombe(int x, int y, int portee, int duree, Controleur controleur, int idPersonnage, int idMalus) {
		super(x,y);
		this.portee = portee;
		this.setDuree(duree);
		this.idPersonnage = idPersonnage;
		this.idMalus = idMalus ;
		this.explosion = new Explosion(x,y,duree+500,this.getPortee(),controleur, this, idMalus);
		
		
		this.timer = new Timer(duree, explosion );
		this.timer.setRepeats(false);
		this.timer.start();
	}
	
	
	/**
	 * Determine l'ID du Malus qui a pose la bombe
	 * @return L'ID du Malus
	 */
	public int getIdMalus() {
		return idMalus;
	}


	/**
	 * Modifie la valeur de l'attribut portee
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}


	/**
	 * Determine l'ID du personnage qui a pose la bombe
	 * @return L'ID du personnage
	 */
	public int getIdPersonnage() {
		return idPersonnage;
	}


	/**
	 * Modifie la valeur de l'attribut idPersonnage
	 * @param idPersonnage L'attribut modifie
	 */
	public void setIdPersonnage(int idPersonnage) {
		this.idPersonnage = idPersonnage;
	}


	/**
	 * Determine l'explosion de la bombe
	 * @return L'explosion
	 */
	public Explosion getExplosion() {
		return explosion;
	}

	
	/**
	 * Savoir la portee de la bombe
	 * @return La portee de la bombe
	 */
	public int getPortee(){
		return portee;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}

}
