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
	
	public int getIdPersonnage(int x, int y){
		int idPersonnage = -1;
		for (int id = 0; id < personnages.size(); ++id){
			if (personnages.get(id).getX() == x && personnages.get(id).getY() == y){
				idPersonnage = id;
			}
		}
		return idPersonnage;
	}
	
	public Personnage getPersonnageSurPlateau(int x, int y){
		for (Personnage personnage: personnages){
			if (personnage.getX()==x && personnage.getY() == y){
				return personnage;
			}
		}
		return null;
	}
	
	public boolean PersonnageSurCase(int x, int y){
		boolean surCase = false;
		String SsurCase = "false";
		for (Personnage personnage: personnages){
			if (personnage.getX() == x && personnage.getY() == y){
				surCase = true;
				SsurCase = "true";
			}
		}

		System.out.println(SsurCase);
		return surCase;
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
	
	public void removePersonnageDuPlateau(int x, int y){
		int id = getIdPersonnage(x,y);
		personnages.remove(id);
	}
}
