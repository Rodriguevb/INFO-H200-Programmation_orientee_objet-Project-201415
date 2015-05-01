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
		int v = mal.getVitesse();
		if (controleur.estLibre(x, y+v)){
			mal.setY(y+v);
			y = y+v;
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
			mal.setVitesse(-v);
			if (v < 0) mal.setNom_image("pingouinFace.png");
			else mal.setNom_image("pingouinDos.png");
		}
		controleur.repaint();
	}

}