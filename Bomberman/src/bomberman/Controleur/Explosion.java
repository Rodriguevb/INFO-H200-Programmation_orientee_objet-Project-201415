package bomberman.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bomberman.modele.PossedePosition;

public class Explosion extends PossedePosition implements ActionListener {
	
	
	private Controleur controleur;

	public Explosion(int x, int y, Controleur controleur) {
		super(x,y);
		this.controleur = controleur;
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		this.controleur.makeExplosion( getX(), getY(), this );
	}

}
