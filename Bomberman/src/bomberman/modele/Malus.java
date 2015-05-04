package bomberman.modele;

public class Malus extends PossedePosition{
	
	/**
	 * Classe qui represente un malus
	 */
	private int v_x;
	private int v_y;
	private int nb_vies;
	private String nom_image;
	private int identifiant;

	
	/**
	 * Constructeur de la classe Malus
	 * @param x L'abscisse du malus
	 * @param y L'ordonne du malus
	 * @param nom_image Le nom de l'image
	 * @param identifiant L'ID du malus
	 */
	public Malus(int x, int y, String nom_image, int identifiant) {
		super(x, y);
		this.v_x = 0;
		this.v_y = 1;
		this.nb_vies = 1;
		this.nom_image = nom_image;
		this.identifiant = identifiant;
	}
	
	
	/**
	 * Savoir le nom de l'image du malus
	 * @return Le nom de l'image
	 */
	public String getNom_image() {
		return nom_image;
	}


	/**
	 * Modifie la valeur de l'attribut nom_image
	 * @param nom_image L'attribut modifie
	 */
	public void setNom_image(String nom_image) {
		this.nom_image = nom_image;
	}


	/**
	 * Savoir la diraction en x du malus
	 * @return La direction en x
	 */
	public int getV_x() {
		return v_x;
	}


	/**
	 * Modifie la valeur de l'attribut v_x
	 * @param v_x L'attribut modifie
	 */
	public void setV_x(int v_x) {
		this.v_x = v_x;
	}


	/**
	 * Savoir la direction en y du malus
	 * @return La direction en y
	 */
	public int getV_y() {
		return v_y;
	}


	/**
	 * Modifie la valeur de l'attribut v_y
	 * @param v_y L'attribut modifie
	 */
	public void setV_y(int v_y) {
		this.v_y = v_y;
	}


	/**
	 * Savoir le nombre de vies du malus
	 * @return Le nombre de vies du malus
	 */
	public int getNb_vies() {
		return nb_vies;
	}

	
	/**
	 * Modifie la valeur de l'attribut nb_vies
	 * @param nb_vies L'attribut modifie
	 */
	public void setNb_vies(int nb_vies) {
		this.nb_vies = nb_vies;
	}


	/**
	 * Savoir l'ID du malus
	 * @return L'ID du malus
	 */
	public int getIdentifiant() {
		return identifiant;
	}


	/**
	 * Modifie la valeur de l'attribut identifiant
	 * @param identifiant L'attribut modifie
	 */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

}
