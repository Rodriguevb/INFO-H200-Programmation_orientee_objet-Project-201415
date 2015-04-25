package bomberman.modele;

import java.util.ArrayList;

import bomberman.controleur.Explosion;

public class Modele {
	
	/**
	 * Classe representant la base de donnees.
	 */
	private Plateau plateau = new Plateau();
	private ArrayList<Personnage> personnages;
	private ArrayList<Bombe>       bombes       = new ArrayList<Bombe>();
	private ArrayList<Explosion>  explosions   = new ArrayList<Explosion>();
	private ArrayList<Mort> morts = new ArrayList<Mort>();
	private ArrayList<Bonus> bonus = new ArrayList<Bonus>();
	private ArrayList<String> nomJoueurs = new ArrayList<String>();
	
	public Modele () {
		plateau.genererTerrain(17, 17);
		creerListeNomBase ("Bomber");
	}
	
	
	public Plateau getPlateau() {
		return plateau;
	}


	public void createPlayers(int nb){
	    personnages = new ArrayList<Personnage>();
		personnages.add(new Personnage(1,1,nomJoueurs.get(1)));
		if (nb >= 2) { personnages.add(new Personnage(1,15,nomJoueurs.get(2)));
			if (nb >= 3) { personnages.add(new Personnage (15, 1, nomJoueurs.get(3)));
				if (nb == 4) { personnages.add(new Personnage (15, 15, nomJoueurs.get(4))); 
				}
			}
		}
		
	}
	
	
	public void creerListeNomBase (String Nom){
		for (int i = 0; i <= 4 ; i++){
			nomJoueurs.add(Nom);
		}
	}
	
	public void creerListeNomJoueurs (String Nom){
		for (int i = 0; i <= 4 ; i++){
			nomJoueurs.set(i,Nom);
		}
		
		
	}
	
	
	public void createBonus(int x, int y, int niveau){
		int random = (int)(Math.random()*200);
		if (random <= 5*(4-niveau)){
			bonus.add(new Bonus(x,y,1,0,0,0,0,0));
		}
		if (random > 5*(4-niveau) && random <= 10*(4-niveau)){
			bonus.add(new Bonus(x,y,0,0,1,0,0,0));
		}
		if (random > 10*(4-niveau) && random <= 60+(5*(4-niveau))){
			bonus.add(new Bonus(x,y,0,0,0,1,0,0));
		}
		if (random > 60+(5*(4-niveau)) && random <= 85+(5*(4-niveau))){
			bonus.add(new Bonus(x,y,0,0,0,0,1,0));
		}
		if (random > 85+(5*(4-niveau)) && random < 95+(5*(4-niveau))){
			bonus.add(new Bonus(x,y,0,1,0,0,0,0));
		}
		if (random > 95+(5*(4-niveau))){
			bonus.add(new Bonus(x,y,0,0,0,0,0,1));
		}
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
	
	public int getIdBonus(int x, int y){
		int idBonus = -1;
		for (int id = 0; id < bonus.size(); ++id){
			if (bonus.get(id).getX() == x && bonus.get(id).getY() == y){
				idBonus = id;
			}
		}
		return idBonus;
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
		for (Personnage personnage: personnages){
			if (personnage.getX() == x && personnage.getY() == y){
				surCase = true;
			}
		}
		return surCase;
	}
	
	public boolean bonusSurCase(int x, int y){
		boolean surCase = false;
		for (Bonus bon: bonus){
			if (bon.getX() == x && bon.getY() == y){
				surCase = true;
			}
		}
		return surCase;
	}
	
	public Bombe getBomb(int idBomb) {
		return bombes.get( idBomb );
	}
	
	public Mort getMort(int idMort) {
		return morts.get( idMort );
	}
	
	public Bonus getBonus(int idBonus){
		return bonus.get( idBonus );
	}

	public ArrayList<Personnage> getListPersonnages() {
		return personnages;
	}

	public ArrayList<Bombe> getListBomb() {
		return bombes;
	}

	public ArrayList<Explosion> getListExplosion() {
		return explosions;
	}
	
	public ArrayList<Mort> getListMorts() {
		return morts;
	}
	
	public ArrayList<Bonus> getListBonus(){
		return bonus;
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
	
	public void removeBonusDuPlateau(int x, int y){
		int id = getIdBonus(x,y);
		bonus.remove(id);
	}
}
