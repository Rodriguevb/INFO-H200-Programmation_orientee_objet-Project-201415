package bomberman.modele;

import javax.swing.Timer;

import bomberman.controleur.Clavier;

public class BonusClavier extends Bonus {
	
	
	public BonusClavier(int x, int y, Personnage personnage){
		super(x,y, "BonusClavier", personnage);
		
	}
	
	public void action(Personnage personnage){
		personnage.setClavier(true);
		Timer timerClavier = new Timer(10000, new Clavier(personnage));
		timerClavier.setRepeats(false);
		timerClavier.start();
	}

}