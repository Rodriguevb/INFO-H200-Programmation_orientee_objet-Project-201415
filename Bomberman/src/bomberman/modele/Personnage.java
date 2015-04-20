package bomberman.modele;


public class Personnage extends PossedePosition {
	
	private String nom_image;
	private String nom;
	
	public Personnage(int x, int y, String nom) {
		super(x,y);
		this.nom = nom;
		this.nom_image = nom+"Face.png";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom_image() {
		return nom_image;
	}

	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}
}