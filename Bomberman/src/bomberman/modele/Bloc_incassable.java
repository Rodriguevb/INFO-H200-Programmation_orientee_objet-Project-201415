package bomberman.modele;
public class Bloc_incassable extends Bloc {
	
	protected int x = 0;
	protected int y = 0;
	protected int color = 0; 
	
	public Bloc_incassable(int x, int y){
		super();
		
		this.x = x;
		this.y = y;
		this.nom_image = "brique_grise.JPG";
		
	}
	
	public Bloc_incassable(){
		super();
		this.nom_image = "brique_grise.JPG";
	}
}
