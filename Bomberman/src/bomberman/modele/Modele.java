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
	private ArrayList<Malus> malus = new ArrayList<Malus>();
	private Theme theme = new Theme(new String[] {"Bomber", "Bomber", "Bomber", "Bomber"}, 
			"brique.jpg", "brique_grise.jpg", "Bomberman.wav", new int[] {255, 255, 255});
	
	public Modele () {
		plateau.genererTerrain(17, 17);
	}
	
	
	public Plateau getPlateau() {
		return plateau;
	}


	public void createPlayers(int nb){
	    personnages = new ArrayList<Personnage>();
		personnages.add(new Personnage(1,1,theme.getNom_personnages()[0]));
		if (nb >= 2) { personnages.add(new Personnage(1,15,theme.getNom_personnages()[1]));
			if (nb >= 3) { personnages.add(new Personnage (15, 1, theme.getNom_personnages()[2]));
				if (nb == 4) { personnages.add(new Personnage (15, 15, theme.getNom_personnages()[3])); 
				}
			}
		}
	}
	
	public void createMalus(int niveau){
		malus = new ArrayList<Malus>();
		int x = -1;
		int y = -1;
		ArrayList<Integer[]> acces = placesAccessibles();
		for (int i = 0; i < (niveau-1)*2; i++){
			int pos = (int) (Math.random()*acces.size());
			x = acces.get(pos)[0];
			y = acces.get(pos)[1];
			if (x!=-1 && y!=-1){
				malus.add(new Malus(x,y,"pingouinFace.png"));
			}
		}	
	}
	
	public ArrayList<Integer[]> placesAccessibles(){
		ArrayList<Integer[]> accessible = new ArrayList<Integer[]>();
		for (int l = 3; l <= 13; l+=2){
			for (int c = 3; c <= 13; c+=2){
				if (getCase(l,c).estLibre()){
					accessible.add(new Integer[] {l,c});
				}
			}
		}
		return accessible;
	}


	public void creerTheme (int i){
		if (i == 1) {
			theme = new Theme(new String[] {"Mario", "Luigi", "Mario", "Mario"}, 
				"blocMarioCassable.png", "briqueMario.png", "SonMario.wav", new int[] {255, 255, 255});	
		}
		
		if (i == 2) {
			theme = new Theme(new String[] {"Bomber", "Bomber", "Bomber", "Bomber"}, 
				"bloc_tetris_cassable.png", "bloc_tetris_incassable.png", "Tetris.wav", new int[] {255, 255, 255});
		}
	}
	
	public Theme getTheme(){
		return theme ;
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
	
	public int getIdBombe(int x, int y){
		int idBombe = -1;
		for (int id = 0; id < bombes.size(); id++){
			if (bombes.get(id).getX() == x && bombes.get(id).getY() == y){
				idBombe = id;
			}
		}
		return idBombe;
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
	
	public boolean BombeSurCase(int x, int y){
		boolean surCase = false;
		for (Bombe bombe: bombes){
			if (bombe.getX() == x && bombe.getY() == y){
				surCase = true;
			}
		}
		return surCase;
	}
	
	public boolean malusSurCase(int x, int y){
		boolean surCase = false;
		for (Malus mal: malus){
			if (mal.getX() == x && mal.getY() == y){
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

	public ArrayList<Bombe> getListBombe() {
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
	
	public ArrayList<Malus> getMalus() {
		return malus;
	}

	public void setMalus(ArrayList<Malus> malus) {
		this.malus = malus;
	}

	public Explosion getExplosion(int idExplosion) {
		return explosions.get( idExplosion );
	}
	
	public Malus getMal(int idMalus){
		return malus.get( idMalus );
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
