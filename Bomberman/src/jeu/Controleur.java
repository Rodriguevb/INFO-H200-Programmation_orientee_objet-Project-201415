package jeu;
import javax.swing.Timer;


public class Controleur {
	private Plateau plateau; 
	private keyListener kListener1;
	private keyListener kListener2;
	//private keyListener kListener3;
	
	public Controleur (Plateau plateau){
		this.plateau = plateau;
		kListener1 = new keyListener(38,40,37,39,32, 0, plateau,vue);
		kListener2 = new keyListener(90,87,81,83,10, 1,plateau,vue);
		
		vue.getFrame().addKeyListener(kListener1);
		vue.getFrame().addKeyListener(kListener2);
		actionListener aListener = new actionListener(plateau, vue);
		Timer timer = new Timer(200, aListener);
		timer.start();
		//vue.getFrame().addKeyListener(kListener3);
		//kListener3 = new keyListener(84,86,70,71,7, plateau, vue);
	}
	
}

