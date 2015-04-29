package bomberman.modele;


public class Case extends PossedePosition {
	
	
	
	private boolean possedeBlocCassable = false;
	private boolean possedeBlocIncassable = false;
	private boolean possedeBombe = false;
	private boolean possedePersonnage = false;
	private boolean possedeMalus = false;


	/**
	 * Constructeur de la classe Case
	 * @param x l'abscisse de la case
	 * @param y l'ordonnee de la case
	 */
	public Case(int x, int y) {
		super(x,y);
	}
	
	
	/**
	 * Indiquer si la case possede un bloc cassable.
	 * @param valeur Bloc cassable present ou non.
	 */
	public void setPossedeBlocCassable(boolean valeur) {
		possedeBlocCassable = valeur;
		if ( possedeBlocCassable ){
			possedeBlocIncassable = false;
			possedeBombe = false;
			possedePersonnage = false;
			possedeMalus = false;
		}
	}
	
	
	/**
	 * Indiquer si la case possede un bloc incassable.
	 * @param valeur Bloc incassable present ou non.
	 */
	public void setPossedeBlocIncassable(boolean valeur) {
		possedeBlocIncassable = valeur;
		if ( possedeBlocIncassable ){
			possedeBlocCassable = false;
			possedeBombe = false;
			possedePersonnage = false;
			possedeMalus = false;
		}
	}
	
	
	/**
	 * Indiquer si la case possede une bombe.
	 * @param valeur Bombe presente ou non.
	 */
	public void setPossedeBombe(boolean valeur) {
		possedeBombe = valeur;
		if ( possedeBombe ){
			possedeBlocIncassable = false;
			possedeBlocCassable = false;
			possedePersonnage = false;
			possedeMalus = false;
		}
	}
	
	
	/**
	 * Indiquer si la case possede un personnage.
	 * @param valeur Personnage present ou non.
	 */
	public void setPossedePersonnage(boolean valeur) {
		possedePersonnage = valeur;
		if ( possedePersonnage ){
			possedeBlocIncassable = false;
			possedeBombe = false;
			possedeBlocCassable = false;
			possedeMalus = false;
		}
	}
	/**
	 * Indiquer si la case possede un malus.
	 * @param valeur Malus present ou non.
	 */
	public void setPossedeMalus(boolean valeur) {
		possedeMalus = valeur;
		if ( possedeMalus ){
			possedeBlocIncassable = false;
			possedeBombe = false;
			possedeBlocCassable = false;
			possedePersonnage = false;
		}
	}
	
	
	/**
	 * Savoir si il n'y a rien sur la case.
	 * @return Vrai si le contenu est vide.
	 */
	public boolean estLibre() {
		return !getPossedeBlocCassable() && !getPossedeBlocIncassable() && !getPossedeBombe() && !getPossedePersonnage() && !getPossedeMalus();
	}
	
	
	/**
	 * Savoir si la case est occupee par un bloc incassable.
	 * @return Vrai si il a un bloc incassable.
	 */
	public boolean getPossedeBlocIncassable() {
		return possedeBlocIncassable;
	}
	
	
	/**
	 * Savoir si la case est occupee par un bloc cassable.
	 * @return Vrai si il a un bloc cassable.
	 */
	public boolean getPossedeBlocCassable() {
		return possedeBlocCassable;
	}
	
	
	/**
	 * Savoir si la case est occupee par une bombe.
	 * @return Vrai si il a une bombe.
	 */
	public boolean getPossedeBombe() {
		return possedeBombe;
	}
	
	
	/**
	 * Savoir si la case est occupee par un personnage.
	 * @return Vrai si il a un personnage.
	 */
	public boolean getPossedePersonnage() {
		return possedePersonnage;
	}
	
	/**
	 * Savoir si la case est occupee par un malus.
	 * @return Vrai si il a un malus.
	 */
	public boolean getPossedeMalus() {
		return possedeMalus;
	}
	
	
	/**
	 * Rendre la case libre.
	 */
	public void rendreLibre() {
		possedePersonnage = false;
		possedeBlocIncassable = false;
		possedeBombe = false;
		possedeBlocCassable = false;
		possedeMalus = false;
	}
}
