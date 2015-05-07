package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bomberman.Audio_simple;
import bomberman.modele.Bombe;
import bomberman.modele.PossedePosition;

public class Explosion extends PossedePosition implements ActionListener {
	
	/**
	 * Classe qui represente une explosion
	 */
	private Controleur controleur;
	private Bombe bombe;
	private Timer timer;
	private int duree;
	private int portee;
	private boolean bombeExplosee;
	private int idMalus;

	
	/**
	 * Constructeur de la classe Explosion
	 * @param x L'abscisse de l'explosion 
	 * @param y L'ordonnee de l'explosion
	 * @param duree Le temps d'affichage de l'explosion
	 * @param portee La portee de l'explosion
	 * @param controleur Le controleur
	 * @param bombe La bombe
	 */
	public Explosion(int x, int y, int duree, int portee, Controleur controleur, Bombe bombe, int idMalus) {
		super(x,y);
		this.duree = duree;
		this.controleur = controleur;
		this.bombe = bombe;
		this.portee = portee;
		this.bombeExplosee = false;
		this.idMalus = idMalus ;	
		this.timer = new Timer(duree, new SuppressionExplosion(controleur, this) );
		this.timer.setRepeats(false);
		this.timer.start();
	}
	
	
	public int getIdMalus() {
		return idMalus;
	}


	public void setIdMalus(int idMalus) {
		this.idMalus = idMalus;
	}


	/**
	 * Determine la portee de l'explosion
	 * @return La portee de l'explosion
	 */
	public int getPortee(){
		return portee;
	}


	/**
	 * Provoque l'explosion
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		if (!bombeExplosee){
		    if ( bombe != null ){
			    this.controleur.removeBombe( bombe );
    			bombe = null;
	    	}
		    this.controleur.makeExplosion( this );
		    Audio_simple son = new Audio_simple("Explosion.wav");
			son.start();
		}
	}
    
	
	/**
	 * Savoir si une bombe a explose
	 * @return Vrai si la bombe a explose
	 */
	public boolean isBombeExplosee() {
		return bombeExplosee;
	}

	
	/**
	 * Change la valeur de l'attribut bombeExplosee
	 * @param bombeExplosee L'attribut modifie
	 */
	public void setBombeExplosee(boolean bombeExplosee) {
		this.bombeExplosee = bombeExplosee;
	}

	
	/**
	 * Savoir la duree d'affichage de l'explosion
	 * @return La duree d'affichage de l'explosion
	 */
	public int getDuree() {
		return duree;
	}

}
