package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.modele.Personnage;

public class Tunnel implements ActionListener{
	
	
	/**
	 * Classe permettant le fonctionnement du bonus_tunnel
	 */
	private Personnage personnage;
	
	
	/**
	 * Constructeur de la classe Tunnel
	 * @param personnage Le personnage
	 */
	public Tunnel(Personnage personnage){
		this.personnage = personnage;
	}

	
	/**
	 * Supprime les effets du bonus_tunnel
	 */
	public void actionPerformed(ActionEvent e) {
		personnage.setTunnel(false);
	}

}
