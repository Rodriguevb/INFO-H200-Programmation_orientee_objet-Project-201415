package bomberman.modele;


public class Plateau {
	
	
	/**
	 * Classe contenant la matrice de la carte et facilitant les changements
	 */
	private Matrice matrice;
	
	
	/**
	 * Genere le terrain de jeu
	 * @param width La largeur du plateau
	 * @param height La hauteur du plateau
	 */
	public void genererTerrain(int width, int height) {
		matrice = new Matrice(width,height);
		addLimit( matrice );
		addIncassable( matrice );
		addRandom( matrice );
		removePositionPlayer( matrice );
	}
	
	
	/**
	 * Fixe les limites du plateau grace a des blocs incassables
	 * @param matrice La matrice du jeu
	 */
	public static void addLimit( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		// On ajoute les cases incassables en haut et en bas.
		for ( int x = 0; x < width; ++x ){
			matrice.get(x, 0).setPossedeBlocIncassable( true );
			matrice.get(x, height-1).setPossedeBlocIncassable( true );
		}
		
		// On ajoute les cases incassable à gauche et à droite.
		for ( int y = 0; y < height; ++y ){
			matrice.get(0, y).setPossedeBlocIncassable( true );
			matrice.get(width-1, y).setPossedeBlocIncassable( true );
		}
	}
	
	
	/**
	 * Ajoute des blocs incassables une case sur deux, une ligne sur deux
	 * @param matrice La matrice du jeu
	 */
	public static void addIncassable( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		// On ajoute les cases incassables
		for ( int x = 2; x < width; x+=2 ){
			for ( int y = 2; y < height; y+=2 ){
				matrice.get(x, y).setPossedeBlocIncassable( true );
			}
		}
	}
	
	
	/**
	 * Remplir la matrice de blocs cassables un peu partout
	 * @param matrice La matrice a remplir
	 */
	public static void addRandom( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		int toAdd = (width-2)*(height-2)/2; // On remplit la moitie de la map.
		int added = 0;
		
		while ( added < toAdd ) {
			int x = randomInt(width);
			int y = randomInt(height);
			if ( matrice.get(x, y).estLibre() ) {
				added += 1;
				matrice.get(x, y).setPossedeBlocCassable( true );
			}
		}
	}
	
	
	/**
	 * Rend libre les coins de la matrice et les cases adjacentes
	 * @param matrice La matrice du jeu
	 */
	public static void removePositionPlayer( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		matrice.get(1,1).rendreLibre();
		matrice.get(2,1).rendreLibre();
		matrice.get(1,2).rendreLibre();
		
		matrice.get(width-2,1).rendreLibre();
		matrice.get(width-3,1).rendreLibre();
		matrice.get(width-2,2).rendreLibre();
		
		matrice.get(width-2,height-2).rendreLibre();
		matrice.get(width-3,height-2).rendreLibre();
		matrice.get(width-2,height-3).rendreLibre();
		
		matrice.get(1,height-2).rendreLibre();
		matrice.get(1,height-3).rendreLibre();
		matrice.get(2,height-2).rendreLibre();
	}
	
	
	/**
	 * Recupere la matrice du jeu
	 * @return La matrice du jeu
	 */
	public Matrice getMatrice() {
		return this.matrice;
	}
	
	
	/**
	 * Genere un nombre aleatoire de 0 a un maximum
	 * @param maxNbRandom Le maximum
	 * @return Le nombre aleatoire
	 */
	public static int randomInt(int maxNbRandom) {
		return (int)(Math.floor(Math.random() * maxNbRandom));
	}


	/**
	 * Savoir la hauteur de la matrice
	 * @return La hauteur de la matrice
	 */
	public int getHeight() {
		return matrice.getHeight();
	}
	
	
    /**
     * Savoir la largeur de la matrice
     * @return La largeur de la matrice
     */
	public int getWidth() {
		return matrice.getWidth();
	}
}