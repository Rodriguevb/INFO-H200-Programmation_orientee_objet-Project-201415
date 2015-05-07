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
	private ArrayList<Bonus> bonus = new ArrayList<Bonus>();
	private ArrayList<Malus> malus = new ArrayList<Malus>();
	private Theme theme = new Theme(new String[] {"Mario", "Luigi", "Yoshi", "Bowser"}, 
			"blocMarioCassable.png", "briqueMario.png", "SonMario.wav", new int[] {255, 255, 255});
	private int width = 17;
	private int height = 17;
	
	
	/**
	 * Constructeur de la classe Modele
	 */
	public Modele () {
		plateau.genererTerrain(width, height);
	}
	
	
	/**
	 * Recupere le plateau
	 * @return Le plateau a recuperer
	 */
	public Plateau getPlateau() {
		return plateau;
	}


	/**
	 * Cree les personnages en fonction du nombre de joueurs
	 * @param nb Le nombre de joueurs
	 */
	public void createPlayers(int nb){
	    personnages = new ArrayList<Personnage>();
		personnages.add(new Personnage(1,1,theme.getNom_personnages()[0]));
		if (nb >= 2) { personnages.add(new Personnage(1,height-2,theme.getNom_personnages()[1]));
			if (nb >= 3) { personnages.add(new Personnage (width-2, 1, theme.getNom_personnages()[2]));
				if (nb == 4) { personnages.add(new Personnage (width-2, height-2, theme.getNom_personnages()[3])); 
				}
			}
		}
	}
	
	
	/**
	 * Cree les malus en fonction du niveau de difficulte
	 * @param niveau Le niveau de difficulte
	 */
	public void createMalus(int niveau){
		malus = new ArrayList<Malus>();
		int x = -1;
		int y = -1;
		ArrayList<Integer[]> acces = placesAccessibles();
		for (int i = 0; i < (niveau-1)*2; i++){
			int pos = (int) (Math.random()*acces.size());
			x = acces.get(pos)[0];
			y = acces.get(pos)[1];
			if (x!=-1 && y!=-1 && !malusSurCase(x,y)){
				malus.add(new Malus(x,y,"pingouinFace.png",i+1));
			}
			else i--;
		}	
	}
	
	
	/**
	 * Genere une liste des cases non occupees
	 * @return La liste des case non occupees
	 */
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


	/**
	 * Choisit le theme du jeu 
	 * @param i Le theme choisi
	 */
	public void creerTheme (int i){
		if (i == 0){
			theme = new Theme(new String[] {"Mario", "Luigi", "Yoshi", "Bowser"}, 
				"blocMarioCassable.png", "briqueMario.png", "SonMario.wav", new int[] {255, 255, 255});	
			
		}
		if (i == 1) {
			theme = new Theme(new String[] {"BomberOrange", "BomberVert", "BomberNoir", "Bomber"}, 
				"bloc_tetris_cassable.png", "bloc_tetris_incassable.png", "Tetris.wav", new int[] {255, 255, 255});
		}
	}
	
	
	/**
	 * Recupere le theme du jeu
	 * @return Le theme du jeu
	 */
	public Theme getTheme(){
		return theme ;
	}
	
	
	/**
	 * Cree un bonus aleatoirement a la place d'un bloc detruit en fonction du niveau de difficulte
	 * @param x L'abscisse du bonus
	 * @param y L'ordonnee du bonus
	 * @param niveau Le niveau de difficulte
	 */
	public void createBonus(int x, int y, int niveau){
		int random = (int)(Math.random()*100);
		if (random <= 5*(4-niveau)){
			bonus.add(new BonusIntensite(x,y,null));
		}
		if (random > 5*(4-niveau) && random <= 10*(4-niveau)){
			bonus.add(new BonusBombe(x,y,null));
		}
		if (random > 10*(4-niveau) && random <= 30+(5*(4-niveau))){
			bonus.add(new BonusVie(x, y, null));
		}
		if (random > 30+(5*(4-niveau)) && random <= 55+(5*(4-niveau))){
			bonus.add(new BonusExplosion(x, y, null));
		}
		if (random > 55+(5*(4-niveau)) && random < 65+(5*(4-niveau))){
			bonus.add(new BonusClavier(x,y,null));
		}
		if (random > 65+(5*(4-niveau)) && random < 110+(5*(4-niveau))){
			bonus.add(new BonusTunnel(x,y,null));
		}
		if (random > 110+(5*(4-niveau))){
			bonus.add(new BonusGilet(x,y,null));
		}
	}
	
	
	/**
	 * Recupere un personnage dans la liste personnages
	 * @param idPersonnage L'ID du personnage dans la liste
	 * @return Le personnage a recuperer
	 */
	public Personnage getPersonnage(int idPersonnage) {
		return personnages.get( idPersonnage );
	}
	
	
	/**
	 * Savoir l'ID d'un personnage dans la liste personnages en fonction de sa position sur le plateau
	 * @param x L'abscisse du personnage
	 * @param y L'ordonne du personnage
	 * @return L'ID du personnage
	 */
	public int getIdPersonnage(int x, int y){
		int idPersonnage = -1;
		for (int id = 0; id < personnages.size(); ++id){
			if (personnages.get(id).getX() == x && personnages.get(id).getY() == y){
				idPersonnage = id;
			}
		}
		return idPersonnage;
	}
	
	
	/**
	 * Recupere le nom d'un personnage dans la liste personnages grace a son ID
	 * @param idPersonnage L'ID du personnage dans personnages
	 * @return Le nom du personnage
	 */
	public String getNomPersonnage(int idPersonnage) {
		return personnages.get( idPersonnage ).getNom();
	}
	
	
	/**
	 * Savoir l'ID d'un bonus dans la liste bonus en fonction de sa position sur le plateau
	 * @param x L'abscisse du bonus
	 * @param y L'ordonne du bonus
	 * @return L'ID du bonus
	 */
	public int getIdBonus(int x, int y){
		int idBonus = -1;
		for (int id = 0; id < bonus.size(); ++id){
			if (bonus.get(id).getX() == x && bonus.get(id).getY() == y){
				idBonus = id;
			}
		}
		return idBonus;
	}
	
	
	/**
	 * Savoir l'ID d'une bombe dans la liste bombes en fonction de sa position sur le plateau
	 * @param x L'abscisse du bombe
	 * @param y L'ordonne du bombe
	 * @return L'ID de la bombe
	 */
	public int getIdBombe(int x, int y){
		int idBombe = -1;
		for (int id = 0; id < bombes.size(); id++){
			if (bombes.get(id).getX() == x && bombes.get(id).getY() == y){
				idBombe = id;
			}
		}
		return idBombe;
	}
	
	
	/**
	 * Savoir l'ID d'un malus dans la liste malus en fonction de sa position sur le plateau
	 * @param x L'abscisse du malus
	 * @param y L'ordonne du malus
	 * @return L'ID du malus
	 */
	public int getIdMalus(int x, int y){
		int idMalus = -1;
		for (int id = 0; id < malus.size(); id++){
			if (malus.get(id).getX() == x && malus.get(id).getY() == y){
				idMalus = id;
			}
		}
		return idMalus;
	}
	
	
	/**
	 * Recupere un personnage dans la liste personnages en fonction de sa position
	 * @param x L'abscisse du personnage
	 * @param y L'ordonnee du personnage
	 * @return Le personnage a recuperer
	 */
	public Personnage getPersonnageSurPlateau(int x, int y){
		for (Personnage personnage: personnages){
			if (personnage.getX()==x && personnage.getY() == y){
				return personnage;
			}
		}
		return null;
	}
	
	
	/**
	 * Permet de savoir s'il y a un personnage sur une case
	 * @param x L'abscisse de la case
	 * @param y L'ordonnee de la case
	 * @return Vrai s'il y a un personnage sur la case
	 */
	public boolean PersonnageSurCase(int x, int y){
		boolean surCase = false;
		for (Personnage personnage: personnages){
			if (personnage.getX() == x && personnage.getY() == y){
				surCase = true;
			}
		}
		return surCase;
	}
	
	
	/**
	 * Permet de savoir s'il y a un bonus sur une case
	 * @param x L'abscisse de la case
	 * @param y L'ordonnee de la case
	 * @return Vrai s'il y a un bonus sur la case
	 */
	public boolean bonusSurCase(int x, int y){
		boolean surCase = false;
		for (Bonus bon: bonus){
			if (bon.getX() == x && bon.getY() == y){
				surCase = true;
			}
		}
		return surCase;
	}
	
	
	/**
	 * Permet de savoir s'il y a une bombe sur une case
	 * @param x L'abscisse de la case
	 * @param y L'ordonnee de la case
	 * @return Vrai s'il y a une bombe sur la case
	 */
	public boolean BombeSurCase(int x, int y){
		boolean surCase = false;
		for (Bombe bombe: bombes){
			if (bombe.getX() == x && bombe.getY() == y){
				surCase = true;
			}
		}
		return surCase;
	}
	
	
	/**
	 * Permet de savoir s'il y a un malus sur une case
	 * @param x L'abscisse de la case
	 * @param y L'ordonnee de la case
	 * @return Vrai s'il y a un malus sur la case
	 */
	public boolean malusSurCase(int x, int y){
		boolean surCase = false;
		for (Malus mal: malus){
			if (mal.getX() == x && mal.getY() == y){
				surCase = true;
			}
		}
		return surCase;
	}
	
	
	/**
	 * Recupere une bombe dans la liste bombes
	 * @param idBombe L'ID de la bombe dans la liste
	 * @return La bombe a recuperer
	 */
	public Bombe getBomb(int idBombe) {
		return bombes.get( idBombe );
	}
	
	
	/**
	 * Recupere un bonus dans la liste bonus
	 * @param idBonus L'ID du bonus dans la liste
	 * @return Le bonus a recuperer
	 */
	public Bonus getBonus(int idBonus){
		return bonus.get( idBonus );
	}

	
	/**
	 * Recupere la liste des personnages
	 * @return La liste des personnages
	 */
	public ArrayList<Personnage> getListPersonnages() {
		return personnages;
	}

	
	/**
	 * Recupere la liste des bombes
	 * @return La liste des bombes
	 */
	public ArrayList<Bombe> getListBombe() {
		return bombes;
	}

	
	/**
	 * Recupere la liste des explosions
	 * @return La liste des explosions
	 */
	public ArrayList<Explosion> getListExplosion() {
		return explosions;
	}
	

	/**
	 * Recupere la liste des bonus
	 * @return La liste des bonus
	 */
	public ArrayList<Bonus> getListBonus(){
		return bonus;
	}
	
	
	/**
	 * Recupere la liste des malus
	 * @return La liste des malus
	 */
	public ArrayList<Malus> getMalus() {
		return malus;
	}

	/*public void setMalus(ArrayList<Malus> malus) {
		this.malus = malus;
	}*/

	
	/**
	 * Recupere une explosion dans la liste explosions
	 * @param idExplosion L'ID de l'explosion dans la liste
	 * @return L'explosion a recuperer
	 */
	public Explosion getExplosion(int idExplosion) {
		return explosions.get( idExplosion );
	}
	
	
	/**
	 * Recupere un malus dans la liste malus
	 * @param idMalus L'ID du malus dans la liste
	 * @return Le malus a recuperer
	 */
	public Malus getMal(int idMalus){
		return malus.get( idMalus );
	}

	
	/**
	 * Recupere une case dans la matrice en connaissant sa position
	 * @param x L'abscisse de la case
	 * @param y L'ordonnee de la case
	 * @return La case a recuperer
	 */
	public Case getCase(int x, int y) {
		return plateau.getMatrice().get(x,y);
	}
	
	
	/**
	 * Retire un personnage de la liste personnages en connaissant sa position
	 * @param x L'abscisse du personnage
	 * @param y L'ordonnee du personnage
	 */
	public void removePersonnageDuPlateau(int x, int y){
		int id = getIdPersonnage(x,y);
		personnages.remove(id);
	}
	
	
	/**
	 * Retire un bonus de la liste bonus en connaissant sa position
	 * @param x L'abscisse du bonus
	 * @param y L'ordonnee du bonus
	 */
	public void removeBonusDuPlateau(int x, int y){
		int id = getIdBonus(x,y);
		bonus.remove(id);
	}
	
	
	/**
	 * Retire un malus de la liste malus en connaissant sa position
	 * @param x L'abscisse du malus
	 * @param y L'ordonnee du malus
	 */
	public void removeMalusDuPlateau(int x, int y){
		int id = getIdMalus(x,y);
		malus.remove(id);
	}
	
	
	/**
	 * Permet de recuperer un malus dans la liste malus en cannaisant l'ID du malus dans la liste
	 * @param identifiant L'ID du malus dans la liste
	 * @return Le malus a recuperer
	 */
	public Malus getMalusDepuisId(int identifiant){
		for (Malus mal: malus){
			if (mal.getIdentifiant() == identifiant){
				return mal;
			}
		}
		return null;
	}
}
