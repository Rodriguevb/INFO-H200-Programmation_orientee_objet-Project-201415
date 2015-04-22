package bomberman.modele;


public class Personnage extends PossedePosition {
	
	private String nom_image;
	private String nom;
	private int nb_vies;
	private boolean vivant;
	
	public Personnage(int x, int y, String nom) {
		super(x,y);
		this.nom = nom;
		this.nom_image = nom+"Face.png";
		this.nb_vies = 2;
		this.vivant = true;
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
	
	public int getNb_vies(){
		return nb_vies;
	}
	
	public void perdreVie(){
		this.nb_vies -= 1;
	}
	
	public boolean getVivant(){
		return vivant;
	}
	
	public void mourir(){
		vivant = false;
	}
}