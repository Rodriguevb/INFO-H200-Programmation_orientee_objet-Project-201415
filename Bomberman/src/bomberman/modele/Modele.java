package bomberman.modele;

import java.awt.Point;
import java.util.ArrayList;

import bomberman.controleur.Explosion;

public class Modele {
	
	/**
	 * Classe représentant la base de données.
	 */
	private Plateau plateau = new Plateau();
	private ArrayList<Personnage> personnages = new ArrayList<Personnage>();
	private ArrayList<Bombe>       bombs       = new ArrayList<Bombe>();
	private ArrayList<Explosion>  explosions  = new ArrayList<Explosion>();
	
	public Modele () {
		
		plateau.genererTerrain(17, 17);
		
		personnages.add( new Personnage(1,1,"Mickey") );
	}
	
	public Plateau getPlateau() {
		return plateau;
	}


	public Personnage getPersonnage(int idPersonnage) {
		return personnages.get( idPersonnage );
	}
	
	public Bombe getBomb(int idBomb) {
		return bombs.get( idBomb );
	}

	public ArrayList<Personnage> getListPersonnages() {
		return personnages;
	}

	public ArrayList<Bombe> getListBomb() {
		return bombs;
	}

	public ArrayList<Explosion> getListExplosion() {
		return explosions;
	}

	public Explosion getExplosion(int idExplosion) {
		return explosions.get( idExplosion );
	}

	public Case getCase(int x, int y) {
		return plateau.getMatrice().get(x,y);
	}
}
