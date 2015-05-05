package bomberman.modele;

import javax.swing.Timer;


public class BonusExplosion extends Bonus {
	
	
	public BonusExplosion(int x, int y, Personnage personnage){
		super(x,y, "BonusExplosion", personnage);
		
	}
	
	public void action(Personnage personnage){
		System.out.println("Explosion");
	}
}