package bomberman.controleur;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import bomberman.modele.Personnage;


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
	private Personnage personnage;
	

	/**
	 * Constructeur de la classe ListenerPlayer
	 * @param controleur Le controleur
	 * @param idPersonnage L'ID du personnage
	 * @param personnage Le personnage
	 */
	public ListenerPlayer(Controleur controleur, int idPersonnage, Personnage personnage){
		this.idPersonnage  = idPersonnage;
		this.controleur = controleur;
		this.personnage = personnage;
	}
	
	
	/**
	 * Change la valeur de l'attribut key_up
	 * @param key_up
	 */
	public void setKeyForUp(int key_up) {
		this.key_up = key_up;
	}
	
	
	/**
	 * Change la valeur de l'attribut key_down
	 * @param key_down
	 */
	public void setKeyForDown(int key_down) {
		this.key_down = key_down;
	}
	
	
	/**
	 * Change la valeur de l'attribut key_left
	 * @param key_left
	 */
	public void setKeyForLeft(int key_left) {
		this.key_left = key_left;
	}
	
	
	/**
	 * Change la valeur de l'attribut key_right
	 * @param key_right
	 */
	public void setKeyForRight(int key_right) {
		this.key_right = key_right;
	}
	
	
	/**
	 * Change la valeur de l'attribut key_drop
	 * @param key_drop
	 */
	public void setKeyForDrop(int key_drop) {
		this.key_drop = key_drop;
	}
	
	
	/**
	 * Reagit lorsqu'une touche est pressee
	 */
	public void keyPressed(KeyEvent keyEvent) {
		if (keyEvent.getKeyCode() == key_up ) {
			if (personnage.isClavier()) {
				controleur.movePersonnage( idPersonnage, 0, 1 );
			}
			else controleur.movePersonnage( idPersonnage, 0, -1 );
		}
		if (keyEvent.getKeyCode() == key_down ) {
			if (personnage.isClavier()) {
				controleur.movePersonnage( idPersonnage, 0, -1 );
			}
			else controleur.movePersonnage( idPersonnage, 0, 1 );
		}
		if (keyEvent.getKeyCode() == key_left ) {
			if (personnage.isClavier()) {
				controleur.movePersonnage( idPersonnage, 1, 0 );
			}
			else controleur.movePersonnage( idPersonnage, -1, 0 );
		}
		if (keyEvent.getKeyCode() == key_right ) {
			if (personnage.isClavier()) {
				controleur.movePersonnage( idPersonnage, -1, 0 );
			}
			else controleur.movePersonnage( idPersonnage, 1, 0 );
		}
		if (keyEvent.getKeyCode() == key_drop ) {
			controleur.dropBomb( idPersonnage );
		}
		controleur.repaint();
	}
	
	
	/**
	 * Reagit lorsqu'une touche est relachee
	 */
	public void keyReleased(KeyEvent keyEvent) {
	}
	
	
	/**
	 * Reagit lorsqu'une touche est pressee
	 */
	public void keyTyped(KeyEvent keyEvent) {	
	}
	
}
