package bomberman.modele;

public abstract class Bonus extends PossedePosition{
	
	/**
	 * Classe representant les bonus
	 */

	protected Personnage personnage ;
	protected String nom ;
	protected Boolean estValide ;
	
	/**
	 * Constructeur de la classe Bonus
	 * @param x L'abscisse du bonus
	 * @param y L'ordonnee du Bonus
	 * @param nom Le nom du Bonus
	 * @param personnage Le personnage concerné
	 */
	public Bonus(int x, int y, String nom, Personnage personnage){
		super(x,y);
		this.personnage = personnage ;
		this.nom = nom ;
	}
	
	
	/** 
	 * Declare la methode action abstraite des bonus
	 * @param personnage
	 */
	public abstract void action(Personnage personnage);
	
	
	/**
	 * Determine le nom du bonus
	 * @return Le nom du bonus
	 */
	public String getNom(){
		return nom ;
	}

}
