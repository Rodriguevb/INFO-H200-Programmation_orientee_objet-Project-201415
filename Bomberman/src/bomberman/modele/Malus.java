package bomberman.modele;

public class Malus extends PossedePosition{
	
	private int v_x;
	private int v_y;
	private int nb_vies;
	private String nom_image;
	private int identifiant;

	public Malus(int x, int y, String nom_image, int identifiant) {
		super(x, y);
		this.v_x = 0;
		this.v_y = 1;
		this.nb_vies = 1;
		this.nom_image = nom_image;
		this.identifiant = identifiant;
	}
	
	
	public String getNom_image() {
		return nom_image;
	}


	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}


	public int getV_x() {
		return v_x;
	}


	public void setV_x(int v_x) {
		this.v_x = v_x;
	}


	public int getV_y() {
		return v_y;
	}


	public void setV_y(int v_y) {
		this.v_y = v_y;
	}


	public int getNb_vies() {
		return nb_vies;
	}

	public void setNb_vies(int nb_vies) {
		this.nb_vies = nb_vies;
	}


	public int getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

}
