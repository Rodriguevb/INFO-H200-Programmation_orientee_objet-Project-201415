package bomberman.modele;

import java.util.ArrayList;

public final class Matrice {
	
	/**
	 * Classe qui facilite la manipulation de matrice.
	 */
	
	private final int width;
	private final int height;
	private final ArrayList<ArrayList<Case>> data;  
	
	
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
	
	
	public int getWidth() {
		return this.width;
	}
	
	
	public int getHeight() {
		return this.height;
	}
	
	
	public Case get(int x, int y) {
		return this.data.get(x).get(y);
	}
	
	
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
