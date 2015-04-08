package jeu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Explose implements ActionListener {
	private boolean explosion;
	
	public boolean isExplosion() {
		return explosion;
	}


	public void setExplosion(boolean explosion) {
		this.explosion = explosion;
	}


	public Explose(){
		explosion = false;
	}
	

	public void actionPerformed(ActionEvent arg0) {
		explosion = true;
		
	}

}
