package bomberman.modele;


public class Case extends PossedePosition {
	
	
	/**
	 * Classe qui représente une case
	 */
	protected String nom_image;
	protected int Nombre_bombes;
	protected Explose explose;

	
	public Case (int x, int y){
		super(x,y);
		
	}
	
	
	public void move(int go_x, int go_y){
		
	}
	 
	public void Dim_Nombre_bombes(){
		
	}
	
	
	public String getNom_image() {
		return nom_image;
	}
	
	
	public void setfNom_image(String nom_image) {
		this.nom_image = nom_image;
	}
	
	
	public int getNombre_bombes() {
		return Nombre_bombes;
	}
	public void setNombre_bombes(int nombre_bombes) {
		Nombre_bombes = nombre_bombes;
	}
	 
}

