package bomberman.modele;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import bomberman.controleur.Controleur;


public class MyKeyListener implements KeyListener{
		
	private int n_up;
	private int n_down;
	private int n_left;
	private int n_right;
	private int n_drop;
	private int personnage;
	private Plateau plateau;
	private Controleur controleur = null;
	
	
	public MyKeyListener(int n_up, int n_down, int n_left, int n_right, int n_drop, int personnage, Plateau plateau, Controleur controleur){
		this.n_up = n_up;
		this.n_down = n_down;
		this.n_left = n_left;
		this.n_right = n_right;
		this.n_drop = n_drop;
		this.controleur = controleur;
		this.plateau = plateau;
		this.personnage = personnage;
	}


	public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == n_up && plateau.libre(plateau.getPositionX(personnage),plateau.getPositionY(personnage)-50))
					plateau.getListe_cases().get(personnage).move(0,-1);
				if (e.getKeyCode() == n_down && plateau.libre(plateau.getPositionX(personnage),plateau.getPositionY(personnage)+50))
					plateau.getListe_cases().get(personnage).move(0, 1);
				if (e.getKeyCode() == n_left && plateau.libre(plateau.getPositionX(personnage)-50,plateau.getPositionY(personnage)))
					plateau.getListe_cases().get(personnage).move(-1, 0);
				if (e.getKeyCode() == n_right && plateau.libre(plateau.getPositionX(personnage)+50,plateau.getPositionY(personnage)))
					plateau.getListe_cases().get(personnage).move(1,0);
				
				if (e.getKeyCode() == n_drop && plateau.getListe_cases().get(personnage).getNombre_bombes() !=0) {

					plateau.getListe_cases().add(new Bombe(plateau.getPositionX(personnage),plateau.getPositionY(personnage),10,5,5));
					plateau.getListe_cases().get(personnage).Dim_Nombre_bombes();	
				}
				
				controleur.repaint();
		
	}
	
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==n_up) 
			plateau.getListe_cases().get(personnage).move(0,0);
		if (e.getKeyCode()==n_down) 
			plateau.getListe_cases().get(personnage).move(0,0);
		if (e.getKeyCode()==n_left) 
			plateau.getListe_cases().get(personnage).move(0,0);
		if (e.getKeyCode()==n_right) 
			plateau.getListe_cases().get(personnage).move(0,0);
		
		controleur.repaint();
		
	}
	
	
	public void keyTyped(KeyEvent arg0) {	
	}
	
	

}
