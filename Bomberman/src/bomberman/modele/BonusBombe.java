package bomberman.modele;

public class BonusBombe extends Bonus {
	

	public BonusBombe(int x, int y, Personnage personnage){
		super(x,y, "BonusBombe", personnage);
	}
	
	public void action(Personnage personnage){
		this.personnage = personnage ;
		personnage.gagnerBombe();
	}

}
