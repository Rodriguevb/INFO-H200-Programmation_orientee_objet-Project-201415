package bomberman.modele;
public class Bloc_cassable extends Bloc {
	
	
	
	public Bloc_cassable(int x, int y){
		super(x,y);
		
		this.nom_image = "brique.JPG";
		
	}
	public void disparaitre(){
		// fait disparaitre le bloc
		// appeler avec une certaine chance le constructeur d'un objet bonus
	}
}