package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Malus;
import bomberman.modele.Modele;
import bomberman.modele.Personnage;

public class BougerMalus implements ActionListener{
	
	private Controleur controleur;
	private Modele modele;
	private int identifiant;
	
	public BougerMalus(Controleur controleur, Modele modele, int identifiant){
		this.controleur = controleur;
		this.modele = modele;
		this.identifiant = identifiant;
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
			move();
		} catch (Exception e) {
			
		}
	}
	
	public void move(){
		Malus mal = modele.getMalusDepuisId(identifiant);
		int x = mal.getX();
		int y = mal.getY();
		int[] dir_x = new int[] {1,-1,0,0};
		int[] dir_y = new int[] {0,0,1,-1};
		int v_x = mal.getV_x();
		int v_y = mal.getV_y();
		if (controleur.estLibre(x+v_x, y+v_y)){
			mal.setX(x+v_x);
			mal.setY(y+v_y);
			if (modele.PersonnageSurCase(x, y)){
				Personnage personnage = modele.getPersonnageSurPlateau(x, y);
				if (personnage.getVivant()){
				    personnage.perdreVie();
		    		if (personnage.getNb_vies() <= 0){
			    		personnage.mourir();
				    }
				}
			}
		}
		else {
			int n = (int) (Math.random()*4);
			mal.setV_x(dir_x[n]);
			mal.setV_y(dir_y[n]);
		}
		controleur.repaint();
	}

}