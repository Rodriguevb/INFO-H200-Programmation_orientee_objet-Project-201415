package bomberman.controleur;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ListenerPlayer implements KeyListener{
	
	/**
	 * Classe permettant d'intercepter les actions du joueur
	 */
	private int key_up;
	private int key_down;
	private int key_left;
	private int key_right;
	private int key_drop;
	private final Controleur controleur;
	private final int idPersonnage;
	

	public ListenerPlayer(Controleur controleur, int idPersonnage){
		this.idPersonnage  = idPersonnage;
		this.controleur = controleur;
	}
	
	public void setKeyForUp(int key_up) {
		this.key_up = key_up;
	}
	
	public void setKeyForDown(int key_down) {
		this.key_down = key_down;
	}
	
	public void setKeyForLeft(int key_left) {
		this.key_left = key_left;
	}
	
	public void setKeyForRight(int key_right) {
		this.key_right = key_right;
	}
	
	public void setKeyForDrop(int key_drop) {
		this.key_drop = key_drop;
	}
	
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		
		if (keyEvent.getKeyCode() == key_up ) {
			controleur.movePersonnageUp( idPersonnage );
		}
		if (keyEvent.getKeyCode() == key_down ) {
			controleur.movePersonnageDown( idPersonnage );
		}
		if (keyEvent.getKeyCode() == key_left ) {
			controleur.movePersonnageLeft( idPersonnage );
		}
		if (keyEvent.getKeyCode() == key_right ) {
			controleur.movePersonnageRight( idPersonnage );
		}
		if (keyEvent.getKeyCode() == key_drop ) {
			controleur.dropBomb( idPersonnage );
		}
		if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE ) {
			controleur.switchToMenu();
		}
		
		
		controleur.repaint();
	}
	
	
	@Override
	public void keyReleased(KeyEvent keyEvent) {
	}
	
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {	
	}
	
	

}
