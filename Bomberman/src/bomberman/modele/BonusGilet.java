package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Gilet;

public class BonusGilet extends Bonus {
	
	
	public BonusGilet(int x, int y, Personnage personnage){
		super(x,y, "BonusGilet", personnage);
	}
	
	public void action(Personnage personnage){
	personnage.setGilet(true);
	Timer timerGilet = new Timer(10000, new Gilet(personnage));
	timerGilet.setRepeats(false);
	timerGilet.start();
	}
}
