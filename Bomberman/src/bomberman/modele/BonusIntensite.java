package bomberman.modele;



public class BonusIntensite extends Bonus {
	
	/**
	 * Classe des BonusIntensite
	 */
	
	
	/**
	 * Constructeur de la classe BonusIntensite
	 * @param x La position en x du BonusIntensite
	 * @param y La position en y du BonusIntensite
	 * @param personnage Le personnage concerne
	 */
	public BonusIntensite(int x, int y, Personnage personnage){
		super(x,y, "BonusIntensite", personnage);
		
	}
	
	
	/**
	 * Actionne le BonusIntensite
	 * @param personnage Le personnage concerne
	 */
	public void action(Personnage personnage){
		personnage.setPortee(2);
	}
} 