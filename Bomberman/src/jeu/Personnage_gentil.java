package jeu;



public class Personnage_gentil extends Personnage{
	
	private String name ;
	private int nombre_bombes;
	
	public Personnage_gentil(int x, int y, int nombre_vies, int nombre_bombes, String name, String nom_image){
		this.x = x;
		this.y = y;
		this.nombre_vies = nombre_vies;
		this.nombre_bombes = nombre_bombes;
		this.name = name;
		this.nom_image = nom_image;
		up = false;
		down = false;
		left = false;
		right = false;
		vitesse=50;
		explose = new Explose();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNombre_bombes() {
		return nombre_bombes;
	}

	public void Dim_Nombre_bombes() {
		nombre_bombes -=1;
	}
	
}