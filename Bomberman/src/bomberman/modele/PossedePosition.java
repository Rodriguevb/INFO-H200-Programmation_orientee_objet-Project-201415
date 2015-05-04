package bomberman.modele;


public abstract class PossedePosition {
	
	/**
	 * Classe des objets possedant une position
	 */
	protected int x = 0;
	protected int y = 0;
	
	
	/**
	 * Constructeur de la classe PossedePosition
	 * @param x L'abscisse de l'objet
	 * @param y L'ordonnee de l'objet
	 */
	public PossedePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * Modifie la valeur de l'attribut x
	 * @param x L'attribut modifie
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	
	/**
	 * Modifie la valeur de l'attribut y
	 * @param y L'attribut modifie
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	/**
	 * Savoir l'abscisse de l'objet
	 * @return L'abscisse de l'objet
	 */
	public int getX() {
		return x;
	}
	
	
	/**
	 * Savoir l'ordonnee de l'objet
	 * @return L'ordonnee de l'objet
	 */
	public int getY() {
		return y;
	}
	
}
