package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Personnage;

public class Gilet implements ActionListener{
	
	private Personnage personnage;
	
	public Gilet(Personnage personnage){
		this.personnage = personnage;
	}

	public void actionPerformed(ActionEvent arg0) {
		personnage.setGilet(false);
	}
}
