package bomberman.modele;

public class BonusVie extends Bonus {
	
	
	public BonusVie(int x, int y, Personnage personnage){
		super(x,y, "BonusVie", personnage);
	}
	
	public void action(Personnage personnage){
		this.personnage = personnage ;
		personnage.gagnerVie();
	}

}
