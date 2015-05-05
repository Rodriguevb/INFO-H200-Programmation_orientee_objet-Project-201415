package bomberman.modele;

public class Bonus extends PossedePosition{
	
	/**
	 * Classe representant les bonus
	 */

	Personnage personnage ;
	String nom ;
	Boolean estValide ;
	
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
	public Bonus(int x, int y, String nom, Personnage personnage){
		super(x,y);
		this.personnage = personnage ;
		this.nom = nom ;
		estValide = false ;
	}
	
	
	public void action(Personnage personnage){
		
	}
	
	public String getNom(){
		return nom ;
		
	}
	
	public void setEstValide(Boolean estValide){
		this.estValide = estValide ;
	}
	
	public boolean getEstValide(){
		return estValide ;
		
	}
}
