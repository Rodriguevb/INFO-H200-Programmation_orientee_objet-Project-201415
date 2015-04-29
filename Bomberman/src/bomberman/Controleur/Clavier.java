package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Personnage;

public class Clavier implements ActionListener{
	
	private Personnage personnage;
	
	public Clavier(Personnage personnage){
		this.personnage = personnage;
	}

	public void actionPerformed(ActionEvent arg0) {
		personnage.setClavier(false);
	}

}
