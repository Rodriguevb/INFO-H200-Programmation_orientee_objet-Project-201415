package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Controleur;
import bomberman.controleur.Explosion;

public class Bombe extends PossedePosition {
	
	private Timer timer;
	private int portee;
	private int duree;
	private int idPersonnage;
	private Explosion explosion;

	
	/**
	 * Constructeur de la classe Bombe
	 * @param x L'abscisse de la bombe
	 * @param y L'ordonnee de la bombe
	 * @param controleur
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
	

	public int getIdPersonnage() {
		return idPersonnage;
	}


	public void setIdPersonnage(int idPersonnage) {
		this.idPersonnage = idPersonnage;
	}


	public Explosion getExplosion() {
		return explosion;
	}

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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

}
