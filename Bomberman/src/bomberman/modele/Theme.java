package bomberman.modele;


public class Theme {
	
	private String[] nom_personnages ;
	private String image_bloc_cassable ;
	private String image_bloc_incassable ;
	private String nom_son ;
	private int[] couleur_fond ;
	
	public Theme (String[] nom_personnages, String image_bloc_cassable, String image_bloc_incassable, String nom_son, int[] couleur_fond ){
		this.nom_personnages = nom_personnages;
		this.image_bloc_cassable = image_bloc_cassable;
		this.image_bloc_incassable = image_bloc_incassable ;
		this.nom_son = nom_son ;
		this.couleur_fond = couleur_fond;
	}

	public String[] getNom_personnages() {
		return nom_personnages;
	}

	public String getImage_bloc_cassable() {
		return image_bloc_cassable;
	}

	public String getImage_bloc_incassable() {
		return image_bloc_incassable;
	}

	public String getNom_son() {
		return nom_son;
	}

	public int[] getCouleur_fond() {
		return couleur_fond;
	}
	
	

}
