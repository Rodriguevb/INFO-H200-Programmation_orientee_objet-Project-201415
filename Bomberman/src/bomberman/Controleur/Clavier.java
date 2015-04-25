package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clavier implements ActionListener{
	
	private Controleur controleur;
	private int idPersonnage;
	
	public Clavier(Controleur controleur, int idPersonnage){
		this.controleur = controleur;
		this.idPersonnage = idPersonnage;
	}

	public void actionPerformed(ActionEvent arg0) {
		controleur.resetTouches(idPersonnage);
	}

}
