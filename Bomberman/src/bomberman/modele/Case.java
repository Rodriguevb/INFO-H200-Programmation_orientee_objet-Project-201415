package bomberman.modele;


public class Case extends PossedePosition {
	
	
	
	private boolean possedeBlocCassable = false;
	private boolean possedeBlocIncassable = false;
	private boolean possedeBombe = false;
	private boolean possedePersonnage = false;


	/**
	 * Constructeur de la classe Case
	 * @param x l'abscisse de la case
	 * @param y l'ordonnée de la case
	 */
	public Case(int x, int y) {
		super(x,y);
	}
	
	
	/**
	 * Indiquer si la case possède un bloc cassable.
	 * @param valeur Bloc cassable présent ou non.
	 */
	public void setPossedeBlocCassable(boolean valeur) {
		possedeBlocCassable = valeur;
		if ( possedeBlocCassable ){
			possedeBlocIncassable = false;
			possedeBombe = false;
			possedePersonnage = false;
		}
	}
	
	
	/**
	 * Indiquer si la case possède un bloc incassable.
	 * @param valeur Bloc incassable présent ou non.
	 */
	public void setPossedeBlocIncassable(boolean valeur) {
		possedeBlocIncassable = valeur;
		if ( possedeBlocIncassable ){
			possedeBlocCassable = false;
			possedeBombe = false;
			possedePersonnage = false;
		}
	}
	
	
	/**
	 * Indiquer si la case possède une bombe.
	 * @param valeur Bombe présente ou non.
	 */
	public void setPossedeBombe(boolean valeur) {
		possedeBombe = valeur;
		if ( possedeBombe ){
			possedeBlocIncassable = false;
			possedeBlocCassable = false;
			possedePersonnage = false;
		}
	}
	
	
	/**
	 * Indiquer si la case possède un personnage.
	 * @param valeur Personnage présent ou non.
	 */
	public void setPossedePersonnage(boolean valeur) {
		possedePersonnage = valeur;
		if ( possedePersonnage ){
			possedeBlocIncassable = false;
			possedeBombe = false;
			possedeBlocCassable = false;
		}
	}
	
	
	/**
	 * Savoir si il n'y a rien sur la case.
	 * @return Vrai si le contenu est vide.
	 */
	public boolean estLibre() {
		return !getPossedeBlocCassable() && !getPossedeBlocIncassable() && !getPossedeBombe() && !getPossedePersonnage();
	}
	
	
	/**
	 * Savoir si la case est occupée par un bloc incassable.
	 * @return Vrai si il a un bloc incassable.
	 */
	public boolean getPossedeBlocIncassable() {
		return possedeBlocIncassable;
	}
	
	
	/**
	 * Savoir si la case est occupée par un bloc cassable.
	 * @return Vrai si il a un bloc cassable.
	 */
	public boolean getPossedeBlocCassable() {
		return possedeBlocCassable;
	}
	
	
	/**
	 * Savoir si la case est occupée par une bombe.
	 * @return Vrai si il a une bombe.
	 */
	public boolean getPossedeBombe() {
		return possedeBombe;
	}
	
	
	/**
	 * Savoir si la case est occupée par un personnage.
	 * @return Vrai si il a un personnage.
	 */
	public boolean getPossedePersonnage() {
		return possedePersonnage;
	}
	
	
	/**
	 * Rendre la case libre.
	 */
	public void rendreLibre() {
		possedePersonnage = false;
		possedeBlocIncassable = false;
		possedeBombe = false;
		possedeBlocCassable = false;
	}
}
