package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Malus;
import bomberman.modele.Modele;
import bomberman.modele.Personnage;

public class BougerMalus implements ActionListener{
	
	
	/**
	 * Classe permettant le mouvement des malus
	 */
	private Controleur controleur;
	private Modele modele;
	private int identifiant;
	private boolean [] directionsPossibles = {false, false, false, false};
	
	
	/**
	 * Constructeur de la classe BougerMalus
	 * @param controleur Le controleur
	 * @param modele Le modele
	 * @param identifiant L'identifiant du Malus
	 */
	public BougerMalus(Controleur controleur, Modele modele, int identifiant){
		this.controleur = controleur;
		this.modele = modele;
		this.identifiant = identifiant;
	}
    
	
	/**
	 * Appelle la methode move()
	 */
	public void actionPerformed(ActionEvent arg0) {
		move();
	}
	
	
	/**
	 * Faire bouger le Malus qui a le meme identifiant
	 */
	public void move(){
		Malus mal = modele.getMalusDepuisId(identifiant);
		if (mal != null) { 
		int x = mal.getX();
		int y = mal.getY();
		int[] dir_x = new int[] {1,-1,0,0};
		int[] dir_y = new int[] {0,0,1,-1};
		int v_x = mal.getV_x();
		int v_y = mal.getV_y();
		
		changeDirectionsPossibles(x, y);
		
		if (controleur.estLibre(x+v_x, y+v_y)){
			mal.setX(x+v_x);
			mal.setY(y+v_y);
			if (modele.PersonnageSurCase(x, y)){
				Personnage personnage = modele.getPersonnageSurPlateau(x, y);
				if (personnage.getVivant() && !personnage.isGilet()){
				    personnage.perdreVie();
		    		if (personnage.getNb_vies() <= 0){
			    		personnage.mourir();
				    }
				}
			}
		}
		else {
			while(!controleur.estLibre(x+v_x, y+v_y)){
			int n = (int) (Math.random()*4);
			v_x = dir_x[n];
			v_y = dir_y[n];
			}
			mal.setV_x(v_x);
			mal.setV_y(v_y);
			
		}
		}
		controleur.repaint();
	
}	
	
	public void changeDirectionsPossibles(int x, int y){
		
		if (controleur.estLibre(x, y-1)){
			directionsPossibles[0] = true ;}
		if (controleur.estLibre(x+1, y)){
			directionsPossibles[1] = true ;}
		if (controleur.estLibre(x, y+1)){
			directionsPossibles[2] = true ;}
		if (controleur.estLibre(x-1, y)){
			directionsPossibles[3] = true ;}	
		
	}

}