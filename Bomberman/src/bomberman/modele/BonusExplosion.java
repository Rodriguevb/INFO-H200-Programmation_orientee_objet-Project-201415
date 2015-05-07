package bomberman.modele;

import javax.swing.Timer;


public class BonusExplosion extends Bonus {
	
	
	public BonusExplosion(int x, int y, Personnage personnage){
		super(x,y, "BonusExplosion", personnage);
		
	}
	
	public void action(Personnage personnage){
		int deltaDuree = (int) (Math.random()*2000)-1000;
		personnage.setDuree(personnage.getDuree() + deltaDuree);
	}
}