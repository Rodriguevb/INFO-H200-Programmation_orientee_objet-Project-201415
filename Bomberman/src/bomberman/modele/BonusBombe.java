package bomberman.modele;

public class BonusBombe extends Bonus {
	
	/**
	 * Classe des BonusBombe
	 */
	

	/**
	 * Constructeur de la classe BonusBombe
	 * @param x La position en x du BonusBombe
	 * @param y La position en y du BonusBombe
	 * @param personnage Le personnage concerne
	 */
	public BonusBombe(int x, int y, Personnage personnage){
		super(x,y, "BonusBombe", personnage);
	}
	
	
	/**
	 * Actionne le BonusBombe
	 * @param personnage Le personnage concerne
	 */
	public void action(Personnage personnage){
		this.personnage = personnage ;
		personnage.gagnerBombe();
	}

}
