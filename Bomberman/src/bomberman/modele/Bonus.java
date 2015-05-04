package bomberman.modele;

public class Bonus extends PossedePosition{
	
	/**
	 * Classe representant les bonus
	 */
	private int bonus_intensite;
	private int bonus_clavier;
	private int bonus_bombe;
	private int bonus_vie;
	private int bonus_explosion;
	private int bonus_tunnel;
	private int bonus_bouclier;
	
	
	/**
	 * Constructeur de la classe Bonus
	 * @param x L'abscisse du bonus
	 * @param y L'ordonnee du Bonus
	 * @param intensite Le bonus intensite
	 * @param clavier Le bonus clavier
	 * @param bombe Le bonus bombe
	 * @param vie Le bonus vie
	 * @param explosion Le bonus explosion
	 * @param tunnel Le bonus tunnel
	 * @param bouclier Le bonus bouclier
	 */
	public Bonus(int x, int y, int intensite, int clavier, int bombe, int vie, int explosion, int tunnel, int bouclier){
		super(x,y);
		this.bonus_intensite = intensite;
		this.bonus_clavier = clavier;
		this.bonus_bombe = bombe;
		this.bonus_vie = vie;
		this.bonus_explosion = explosion;
		this.bonus_tunnel = tunnel;
		this.bonus_bouclier = bouclier;
	}
	
	
	/**
	 * Savoir s'il s'agit d'un bonus tunnel
	 * @return La valeur du bonus tunnel (1 si c'est un bonus tunnel, 0 sinon)
	 */
	public int getBonus_tunnel() {
		return bonus_tunnel;
	}

	
	/**
	 * Modifie la valeur de l'attribut bonus_tunnel
	 * @param bonus_tunnel L'attribut modifie
	 */
	public void setBonus_tunnel(int bonus_tunnel) {
		this.bonus_tunnel = bonus_tunnel;
	}

	
	/**
	 * Savoir s'il s'agit d'un bonus intensite
	 * @return La valeur du bonus intensite (1 si c'est un bonus intensite, 0 sinon)
	 */
	public int getBonus_intensite() {
		return bonus_intensite;
	}

	
	/**
	 * Modifie la valeur de l'attribut bonus_intensite
	 * @param bonus_intensite L'attribut modifie
	 */
	public void setBonus_intensite(int bonus_intensite) {
		this.bonus_intensite = bonus_intensite;
	}

	
	/**
	 * Savoir s'il s'agit d'un bonus clavier
	 * @return La valeur du bonus clavier (1 si c'est un bonus clavier, 0 sinon)
	 */
	public int getBonus_clavier() {
		return bonus_clavier;
	}

	
	/**
	 * Modifie la valeur de l'attribut bonus_clavier
	 * @param bonus_clavier L'attribut modifie
	 */
	public void setBonus_clavier(int bonus_clavier) {
		this.bonus_clavier = bonus_clavier;
	}

	
	/**
	 * Savoir s'il s'agit d'un bonus bombe
	 * @return La valeur du bonus bombe (1 si c'est un bonus bombe, 0 sinon)
	 */
	public int getBonus_bombe() {
		return bonus_bombe;
	}

	
	/**
	 * Modifie la valeur de l'attribut bonus_bombe
	 * @param bonus_bombe L'attribut modifie
	 */
	public void setBonus_bombe(int bonus_bombe) {
		this.bonus_bombe = bonus_bombe;
	}

	
	/**
	 * Savoir s'il s'agit d'un bonus vie
	 * @return La valeur du bonus vie (1 si c'est un bonus vie, 0 sinon)
	 */
	public int getBonus_vie() {
		return bonus_vie;
	}

	
	/**
	 * Modifie la valeur de l'attribut bonus_vie
	 * @param bonus_vie L'attribut modifie
	 */
	public void setBonus_vie(int bonus_vie) {
		this.bonus_vie = bonus_vie;
	}

	
	/**
	 * Savoir s'il s'agit d'un bonus explosion
	 * @return La valeur du bonus explosion (1 si c'est un bonus explosion, 0 sinon)
	 */
	public int getBonus_explosion() {
		return bonus_explosion;
	}

	
	/**
	 * Modifie la valeur de l'attribut bonus_explosion
	 * @param bonus_explosion L'attribut modifie
	 */
	public void setBonus_explosion(int bonus_explosion) {
		this.bonus_explosion = bonus_explosion;
	}


	/**
	 * Savoir s'il s'agit d'un bonus bouclier
	 * @return La valeur du bonus bouclier (1 si c'est un bonus bouclier, 0 sinon)
	 */
	public int getBonus_bouclier() {
		return bonus_bouclier;
	}

	
	/**
	 * Modifie la valeur de l'attribut bonus_bouclier
	 * @param bonus_bouclier L'attribut modifie
	 */
	public void setBonus_bouclier(int bonus_bouclier) {
		this.bonus_bouclier = bonus_bouclier;
	}

}
