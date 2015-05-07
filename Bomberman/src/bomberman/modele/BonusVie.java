package bomberman.modele;

public class BonusVie extends Bonus {

	/**
	 * Classe des BonusVie
	 */
	
	
	/**
	 * Constructeur de la classe BonusVie
	 * @param x La position en x du BonusVie
	 * @param y La position en y du BonusVie
	 * @param personnage Le personnage concerne
	 */
	public BonusVie(int x, int y, Personnage personnage){
		super(x,y, "BonusVie", personnage);
	}
	
	
	/**
	 * Actionne le BonusVie
	 * @param personnage Le personnage concerne
	 */
	public void action(Personnage personnage){
		this.personnage = personnage ;
		personnage.gagnerVie();
	}

}
