package bomberman.modele;

public class Malus extends PossedePosition{
	
	private int vitesse;
	private int nb_vies;
	private String nom_image;

	public Malus(int x, int y, String nom_image) {
		super(x, y);
		this.vitesse = 1;
		this.nb_vies = 1;
		this.nom_image = nom_image;
	}
	
	
	public String getNom_image() {
		return nom_image;
	}


	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}


	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getNb_vies() {
		return nb_vies;
	}

	public void setNb_vies(int nb_vies) {
		this.nb_vies = nb_vies;
	}

}