package bomberman.controleur;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
	private Point[] directions = {new Point (0,-1), new Point (1,0), new Point (0,1), new Point (-1, 0)};
	
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

		int v_x = mal.getV_x();
		int v_y = mal.getV_y();
		
		changeDirectionsPossibles(x, y);
		int n = randomNombre();
		
		if (existeDirectionPossible()){
		while (directionsPossibles[n] == false || faireDemiTour(v_x, v_y, n) == false){
			n = randomNombre();}	
			
			x = x + directions[n].x ;
			y = y + directions[n].y ;		
			mal.setV_x(directions[n].x);
			mal.setV_y(directions[n].y);
			mal.setX(x);
			mal.setY(y);
			
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
		}
		controleur.repaint();
	
}	
	
	public void changeDirectionsPossibles(int x, int y){
		
		if (controleur.estLibre(x, y-1)){
			directionsPossibles[0] = true ;}
		else directionsPossibles[0] = false ;
		
		if (controleur.estLibre(x+1, y)){
			directionsPossibles[1] = true ;}
		else directionsPossibles[1] = false ;
		
		if (controleur.estLibre(x, y+1)){
			directionsPossibles[2] = true ;}
		else directionsPossibles[2] = false ;
		
		if (controleur.estLibre(x-1, y)){
			directionsPossibles[3] = true ;}
		else directionsPossibles[3] = false ;
		
	}
	
	public boolean existeDirectionPossible() {
		Boolean existe = false ;
		for (Boolean bool : directionsPossibles){
			if (bool == true) existe = true ;
		}
		return existe ;
	}
	
	public int randomNombre(){
		Random r = new Random(); 
		int n = r.nextInt(4);
		return n ;
	}
	
	public boolean faireDemiTour(int v_x, int v_y, int n){
		boolean demiTour = true ;
		int i = 0 ;
		if (v_x == -directions[n].x && v_y == -directions[n].y) {
			demiTour = false ;
		
			for (Boolean bool : directionsPossibles){
			if (bool == false) i++ ;}
			if (i == 3) demiTour = true ;
		}
		
		return demiTour ;
	}

}