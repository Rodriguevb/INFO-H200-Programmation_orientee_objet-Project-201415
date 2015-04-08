package bomberman.controleur;

import bomberman.modele.Modele;
import bomberman.vue.Vue;


public class Controleur {
	
	private Vue vue       = null;
	private Modele modele = null;
	
	
	public Controleur (){
	}
	
	
	public void link(Vue vue) {
		this.vue = vue;
	}
	

	public void link(Modele modele) {
		this.modele = modele;
	}
	
	public void switchToMenu() {
		vue.switchToMenu();
	}
	
	public void switchToJeu() {
		vue.switchToJeu();
	}


	public void repaint() {
		vue.repaint();
	}
	
}

