
public class Personnage_mechant extends Personnage {
	
	private int x;
	private int y;
	
	public Personnage_mechant(int x, int y){
		this.x = x;
		this.y = y;
		nombre_vies = 1;
	}
	public void attaquer(){
		//Si case occupée par personnage gentil, déclenche la méthode "perdre une vie" chez le pers gentil 
	}
}