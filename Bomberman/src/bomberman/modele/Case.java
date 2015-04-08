package bomberman.modele;


public class Case {
	protected String nom_image;
	protected int x;
	protected int y;
	protected int Nombre_bombes;
	protected Explose explose;

	public Case (){
		
	}
	 public void move(int go_x, int go_y){


	 }
	 
	public void Dim_Nombre_bombes(){
		
	}
	
	public String getNom_image() {
		return nom_image;
	}
	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getNombre_bombes() {
		return Nombre_bombes;
	}
	public void setNombre_bombes(int nombre_bombes) {
		Nombre_bombes = nombre_bombes;
	}
	 
}

