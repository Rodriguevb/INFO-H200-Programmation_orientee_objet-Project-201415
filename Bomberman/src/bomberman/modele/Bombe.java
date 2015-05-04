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

	
	/**
	 * Constructeur de la classe Bombe
	 * @param x L'abscisse de la bombe
	 * @param y L'ordonnee de la bombe
	 * @param portee La portee de la bombe
	 * @param duree La duree avant que la bombe explose
	 * @param controleur Le controleur
	 * @param idPersonnage L'ID du personnage qui a pose la bombe
	 */
	public Bombe(int x, int y, int portee, int duree, Controleur controleur, int idPersonnage) {
		super(x,y);
		this.portee = portee;
		this.duree = duree;
		this.idPersonnage = idPersonnage;
		this.explosion = new Explosion(x,y,duree+500,this.getPortee(),controleur, this);
		
		
		this.timer = new Timer(duree, explosion );
		this.timer.setRepeats(false);
		this.timer.start();
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
	 * Determine 
	 * @return
	 */
	public Explosion getExplosion() {
		return explosion;
	}

	
	/**
	 * Modifie la valeur de l'attribut explosion
	 * @param explosion L'attribut modifie
	 */
	public void setExplosion(Explosion explosion) {
		this.explosion = explosion;
	}

	
	/**
	 * Savoir la portee de la bombe
	 * @return La portee de la bombe
	 */
	public int getPortee(){
		return portee;
	}

	
	/**
	 * Savoir la duree avant que la bombe explose
	 * @return La duree avant que la bombe explose
	 */
	public int getDuree() {
		return duree;
	}

	
	/**
	 * Modifie la valeur de l'attribut duree
	 * @param duree L'attribut modifie
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

}
