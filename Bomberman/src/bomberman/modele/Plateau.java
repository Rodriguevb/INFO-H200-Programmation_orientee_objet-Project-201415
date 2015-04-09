package bomberman.modele;


public class Plateau {
	
	
	/**
	 * Classe contenant la matrice de la carte et facilitant les changements.
	 */
	private Matrice matrice = new Matrice(17,17);
	
	
	public void genererTerrain(int width, int height) {
		matrice = new Matrice(width,height);
		addLimit( matrice );
		addIncassable( matrice );
		addRandom( matrice );
		removePositionPlayer( matrice );
	}
	
	
	public static void addLimit( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		// On ajoute les cases incassables en haut et en bas.
		for ( int x = 0; x < width; ++x ){
			matrice.get(x, 0).setOccupation( new BlocIncassable() );
			matrice.get(x, height-1).setOccupation( new BlocIncassable() );
		}
		
		// On ajoute les cases incassable à gauche et à droite.
		for ( int y = 0; y < height; ++y ){
			matrice.get(0, y).setOccupation( new BlocIncassable() );
			matrice.get(width-1, y).setOccupation( new BlocIncassable() );
		}
	}
	
	
	public static void addIncassable( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		// On ajoute les cases incassables
		for ( int x = 2; x < width; x+=2 ){
			for ( int y = 2; y < height; y+=2 ){
				matrice.get(x, y).setOccupation( new BlocIncassable() );
			}
		}
	}
	
	
	public static void addRandom( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		int toAdd = (width-2)*(height-2)/8*5; // On remplit les 5/8 de la map.
		int added = 0;
		
		while ( added < toAdd ) {
			int x = randomInt(width);
			int y = randomInt(height);
			if ( matrice.get(x, y).estLibre() ) {
				added += 1;
				matrice.get(x, y).setOccupation( new BlocCassable() );
			}
		}
	}
	
	
	public static void removePositionPlayer( Matrice matrice ) {
		int width  = matrice.getWidth();
		int height = matrice.getHeight();
		
		matrice.get(1,1).setOccupation( null );
		matrice.get(2,1).setOccupation( null );
		matrice.get(1,2).setOccupation( null );
		
		matrice.get(width-2,1).setOccupation( null );
		matrice.get(width-3,1).setOccupation( null );
		matrice.get(width-2,2).setOccupation( null );
		
		matrice.get(width-2,height-2).setOccupation( null );
		matrice.get(width-3,height-2).setOccupation( null );
		matrice.get(width-2,height-3).setOccupation( null );
		
		matrice.get(1,height-2).setOccupation( null );
		matrice.get(1,height-3).setOccupation( null );
		matrice.get(2,height-2).setOccupation( null );
	}
	
	
	public Matrice getMatrice() {
		return this.matrice;
	}
	
	
	public static int randomInt(int maxNbRandom) {
		return (int)(Math.floor(Math.random() * maxNbRandom));
	}


	public int getHeight() {
		return matrice.getHeight();
	}
	
	
	public int getWidth() {
		return matrice.getWidth();
	}
}