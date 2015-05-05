package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Tunnel;

public class BonusTunnel extends Bonus {
	
	
	public BonusTunnel(int x, int y, Personnage personnage){
		super(x,y, "BonusTunnel", personnage);
	}
	
	public void action(Personnage personnage){
		personnage.setTunnel(true);
		Timer timerTunnel = new Timer(10000, new Tunnel(personnage));
		timerTunnel.setRepeats(false);
		timerTunnel.start();		
	}
}