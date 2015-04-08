package jeu;
public class Bloc_cassable extends Bloc {
	
	public Bloc_cassable(int pos_x, int pos_y){
		this.x = pos_x;
		this.y = pos_y;
		this.nom_image = "brique.JPG";
		
	}
	public void disparaitre(){
		// fait disparaitre le bloc
		// appeler avec une certaine chance le constructeur d'un objet bonus
	}
}