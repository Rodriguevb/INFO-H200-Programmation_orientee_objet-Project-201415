package bomberman.modele;

import java.util.ArrayList;

public final class Matrice {
	
	/**
	 * Classe qui facilite la manipulation de matrice.
	 */
	private final int width;
	private final int height;
	private final ArrayList<ArrayList<Case>> data;  
	
	
	/**
	 * Constructeur de la classe Matrice
	 * @param width La largeur de la matrice
	 * @param height La hauteur de la matrice
	 */
	public Matrice(int width, int height) {
		this.width  = width;
		this.height = height;
		this.data = new ArrayList<ArrayList<Case>>();
		
		for ( int x = 0; x < width; ++x ) {
			this.data.add( new ArrayList<Case>() );
			for ( int y = 0; y < height; ++y ) {
				this.data.get(x).add( new Case(x,y) );
			}
		}
	}
	
	
	/**
	 * Savoir la largeur de la matrice
	 * @return La largeur de la matrice
	 */
	public int getWidth() {
		return this.width;
	}
	
	
	/**
	 * Savoir la hauteur de la matrice
	 * @return La hauteur de la matrice
	 */
	public int getHeight() {
		return this.height;
	}
	
	
	/**
	 * Recupere une case en connaissant sa position
	 * @param x L'abscisse de la case a trouver
	 * @param y L'ordonnee de la case a trouver
	 * @return La case a recuperer
	 */
	public Case get(int x, int y) {
		return this.data.get(x).get(y);
	}
	
	
	/**
	 * Convertit un element de la matrice en String
	 */
	public String toString() {
		String str = "";
		for (int y = 0 ; y < this.height; ++y){
			for (int x = 0 ; x < this.width ; ++x) {
				str += "  " + get(x,y);
			}
			str += "\n";
		}
		return str;
	}
}
