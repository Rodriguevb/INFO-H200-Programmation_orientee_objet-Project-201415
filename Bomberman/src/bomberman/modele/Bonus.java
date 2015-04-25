package bomberman.modele;

public class Bonus extends PossedePosition{
	
	private int niveau = 1;
	private int bonus_intensite;
	private int bonus_clavier;
	private int bonus_bombe;
	private int bonus_vie;
	private int bonus_explosion;
	//private int bonus_bloc;
	private int bonus_tunnel;
	
	public Bonus(int x, int y, int intensite, int clavier, int bombe, int vie, int explosion, int bonus_tunnel){
		super(x,y);
		this.bonus_intensite = intensite;
		this.bonus_clavier = clavier;
		this.bonus_bombe = bombe;
		this.bonus_vie = vie;
		this.bonus_explosion = explosion;
		this.bonus_tunnel = bonus_tunnel;
	}
	
	public int getBonus_tunnel() {
		return bonus_tunnel;
	}

	public void setBonus_tunnel(int bonus_tunnel) {
		this.bonus_tunnel = bonus_tunnel;
	}

	public int getBonus_intensite() {
		return bonus_intensite;
	}

	public void setBonus_intensite(int bonus_intensite) {
		this.bonus_intensite = bonus_intensite;
	}

	public int getBonus_clavier() {
		return bonus_clavier;
	}

	public void setBonus_clavier(int bonus_clavier) {
		this.bonus_clavier = bonus_clavier;
	}

	public int getBonus_bombe() {
		return bonus_bombe;
	}

	public void setBonus_bombe(int bonus_bombe) {
		this.bonus_bombe = bonus_bombe;
	}

	public int getBonus_vie() {
		return bonus_vie;
	}

	public void setBonus_vie(int bonus_vie) {
		this.bonus_vie = bonus_vie;
	}

	public int getBonus_explosion() {
		return bonus_explosion;
	}

	public void setBonus_explosion(int bonus_explosion) {
		this.bonus_explosion = bonus_explosion;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

}
