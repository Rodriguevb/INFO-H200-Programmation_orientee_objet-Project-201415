package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Personnage;

public class Tunnel implements ActionListener{
	
	private Personnage personnage;
	
	public Tunnel(Personnage personnage){
		this.personnage = personnage;
	}

	public void actionPerformed(ActionEvent e) {
		personnage.setTunnel(false);
	}

}
