package bomberman.modele;


public class Theme {
	
	/**
	 * Classe coordonnant le choix du theme
	 */
	private String[] nom_personnages ;
	private String image_bloc_cassable ;
	private String image_bloc_incassable ;
	private String nom_son ;
	private int[] couleur_fond ;
	
	
	/**
	 * Constructeur de la classe Theme
	 * @param nom_personnages La liste des noms des images des personnages
	 * @param image_bloc_cassable Le nom de l'image des blocs cassables
	 * @param image_bloc_incassable Le nom de l'image des blocs incassables
	 * @param nom_son Le nom du fichier son
	 * @param couleur_fond La couleur du fond
	 */
	public Theme (String[] nom_personnages, String image_bloc_cassable, String image_bloc_incassable, String nom_son, int[] couleur_fond ){
		this.nom_personnages = nom_personnages;
		this.image_bloc_cassable = image_bloc_cassable;
		this.image_bloc_incassable = image_bloc_incassable ;
		this.nom_son = nom_son ;
		this.couleur_fond = couleur_fond;
	}

	
	/**
	 * Savoir la liste des noms des images des personnages
	 * @return La liste des noms des images des personnages
	 */
	public String[] getNom_personnages() {
		return nom_personnages;
	}

	
	/**
	 * Savoir le nom de l'image des blocs cassables
	 * @return Le nom de l'image des blocs cassables
	 */
	public String getImage_bloc_cassable() {
		return image_bloc_cassable;
	}

	
	/**
	 * Savoir le nom de l'image des blocs incassables
	 * @return Le nom de l'image des blocs incassables
	 */
	public String getImage_bloc_incassable() {
		return image_bloc_incassable;
	}

	
	/**
	 * Savoir le nom du fichier son
	 * @return Le nom du fichier son
	 */
	public String getNom_son() {
		return nom_son;
	}

	
	/**
	 * Savoir la couleur du fond
	 * @return La couleur du fond
	 */
	public int[] getCouleur_fond() {
		return couleur_fond;
	}
	
	

}
