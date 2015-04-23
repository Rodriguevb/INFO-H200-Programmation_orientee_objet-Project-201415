package bomberman.modele;

import java.util.ArrayList;


public class Personnage extends PossedePosition {
	
	private String nom_image;
	private String nom;
	private int nb_vies;
	private int nb_bombes;
	private boolean vivant;
	private ArrayList<Bonus> bonus_personnage;
	
	public Personnage(int x, int y, String nom) {
		super(x,y);
		this.nom = nom;
		this.nom_image = nom+"Face.png";
		this.nb_vies = 2;
		this.nb_bombes = 10;
		this.vivant = true;
		this.bonus_personnage = new ArrayList<Bonus>();
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
	
	public ArrayList<Bonus> getBonus_personnage(){
		return bonus_personnage;
	}
	
	public void activerBonus(){
		int idBonus = 0;
		while (idBonus < bonus_personnage.size()){
			if (bonus_personnage.get(idBonus).getBonus_vie() == 1){
				nb_vies++;
				bonus_personnage.remove(idBonus);
			}
			else if (bonus_personnage.get(idBonus).getBonus_bombe() == 1){
				nb_bombes++;
				bonus_personnage.remove(idBonus);
			}
			else {
				idBonus++;
			}
		}
	}
	
	public void removeBonus(int idBonus){
		bonus_personnage.remove(idBonus);
	}

	public int getNb_bombes() {
		return nb_bombes;
	}

	public void setNb_bombes(int nb_bombes) {
		this.nb_bombes = nb_bombes;
	}
}