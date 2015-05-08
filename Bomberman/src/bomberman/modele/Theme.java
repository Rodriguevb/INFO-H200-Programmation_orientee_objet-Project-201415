package bomberman.modele;


public class Theme {
	
	/**
	 * Classe coordonnant le choix du theme
	 */
	private String nomTheme ;
	private String[] nom_personnages ;
	private String nom_son ;

	
	/**
	 * Constructeur de la classe Theme
	 * @param nomTheme lLe nom du theme
	 * @param nom_personnages La liste des noms des images des personnages
	 * @param nom_son Le nom du fichier son
	 */
	public Theme (String nomTheme, String[] nom_personnages, String nom_son){
		this.nomTheme = nomTheme ;
		this.nom_personnages = nom_personnages;
		this.nom_son = nom_son ;
	}

	
	/**
	 * Savoir le nom du theme
	 * @return Le nom du theme
	 */
	public String getNomTheme() {
		return nomTheme;
	}
	
	
	/**
	 * Savoir la liste des noms des images des personnages
	 * @return La liste des noms des images des personnages
	 */
	public String[] getNom_personnages() {
		return nom_personnages;
	}

		
	/**
	 * Savoir le nom du fichier son
	 * @return Le nom du fichier son
	 */
	public String getNom_son() {
		return nom_son;
	}



}
