package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Malus;

public class BougerMalus implements ActionListener{
	
	private Malus mal;
	private Controleur controleur;
	
	public BougerMalus(Malus mal, Controleur controleur){
		this.mal = mal;
		this.controleur = controleur;
	}

	public void actionPerformed(ActionEvent arg0) {
		int x = mal.getX();
		int y = mal.getY();
		int v = mal.getVitesse();
		if (controleur.estLibre(x, y+v)){
			mal.setY(y+v);
		}
		else {
			mal.setVitesse(-v);
			if (v > 0) mal.setNom_image("pingouinFace.png");
			else mal.setNom_image("pingouinDos.png");
		}
		controleur.repaint();
	}

}
