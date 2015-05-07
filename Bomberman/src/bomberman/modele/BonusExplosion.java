package bomberman.modele;



public class BonusExplosion extends Bonus {
	
	/**
	 * Classe des BonusExplosion
	 */
	
	
	/**
	 * Constructeur de la classe BonusExplosion
	 * @param x La position en x du BonusExplosion
	 * @param y La position en y du BonusExplosion
	 * @param personnage Le personnage concerne
	 */
	public BonusExplosion(int x, int y, Personnage personnage){
		super(x,y, "BonusExplosion", personnage);
		
	}
	
	
	/**
	 * Actionne le BonusExplosion
	 * @param personnage Le personnage concerne
	 */
	public void action(Personnage personnage){
		int deltaDuree = (int) (Math.random()*2000)-1000;
		personnage.setDuree(personnage.getDuree() + deltaDuree);
	}
}