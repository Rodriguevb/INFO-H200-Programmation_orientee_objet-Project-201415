package bomberman.modele;

import java.util.ArrayList;

import javax.swing.Timer;

import bomberman.Audio_simple;
import bomberman.controleur.Clavier;
import bomberman.controleur.Tunnel;


public class Personnage extends PossedePosition {
	
	private String nom_image;
	private String nom;
	private int nb_vies;
	private int nb_bombes;
	private boolean vivant;
	private ArrayList<Bonus> bonus_personnage;
	private boolean tunnel;
	private boolean clavier;
	
	public Personnage(int x, int y, String nom) {
		super(x,y);
		this.nom = nom;
		this.nom_image = nom+"Face.png";
		this.nb_vies = 2;
		this.nb_bombes = 10;
		this.vivant = true;
		this.bonus_personnage = new ArrayList<Bonus>();
		this.tunnel = false;
		this.clavier = false;
	}

	public boolean isClavier() {
		return clavier;
	}

	public void setClavier(boolean clavier) {
		this.clavier = clavier;
	}

	public boolean isTunnel() {
		return tunnel;
	}

	public void setTunnel(boolean tunnel) {
		this.tunnel = tunnel;
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
		Audio_simple son = new Audio_simple("ouch.wav");
			son.start();
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
	
	public void move(int avance_x, int avance_y) {
		this.x += avance_x;
		this.y += avance_y;
		if (avance_x == 1) this.nom_image = nom + "Droite.png";
		else if (avance_x == -1) this.nom_image = nom + "Gauche.png";
		else if (avance_y == 1) this.nom_image = nom + "Face.png" ;
		else if (avance_y == -1) this.nom_image = nom + "Dos.png" ;
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
			else if (bonus_personnage.get(idBonus).getBonus_tunnel() == 1){
				tunnel = true;
				bonus_personnage.remove(idBonus);
				Timer timerTunnel = new Timer(10000, new Tunnel(this));
				timerTunnel.setRepeats(false);
				timerTunnel.start();
			}
			else if (bonus_personnage.get(idBonus).getBonus_clavier() == 1){
				clavier = true;
				bonus_personnage.remove(idBonus);
				Timer timerClavier = new Timer(10000, new Clavier(this));
				timerClavier.setRepeats(false);
				timerClavier.start();
			}
			else {
				idBonus++;
			}
		}
	}
	
	public boolean ownBonusClavier(){
		boolean bonus = false;
		int idBonus = 0;
		while (idBonus < bonus_personnage.size()){
			if (bonus_personnage.get(idBonus).getBonus_clavier() == 1){
				bonus = true;
				bonus_personnage.remove(idBonus);
			}
			else idBonus++;
		}
		return bonus;
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