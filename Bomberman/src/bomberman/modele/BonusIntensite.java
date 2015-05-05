package bomberman.modele;



public class BonusIntensite extends Bonus {
	
	
	public BonusIntensite(int x, int y, Personnage personnage){
		super(x,y, "BonusIntensite", personnage);
		
	}
	
	public void action(Personnage personnage){
		System.out.println("Bonus intensité");
	}
} 