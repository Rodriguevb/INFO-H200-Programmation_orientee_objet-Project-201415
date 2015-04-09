package bomberman.controleur;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bomberman.modele.Bomb;
import bomberman.modele.Case;
import bomberman.modele.Modele;
import bomberman.modele.Personnage;
import bomberman.vue.Vue;


public class Controleur {
	
	private Vue vue       = null;
	private Modele modele = null;
	
	private int personnage = 0;
	
	
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
	
	
	public void movePersonnageUp(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );

		if ( estLibre(personnage.getX(), personnage.getY()-1) ) {
			personnage.move(0, -1);
		}
	}
	
	
	public void movePersonnageDown(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		
		if ( estLibre(personnage.getX(), personnage.getY()+1) ) {
			personnage.move(0, 1);
		}
	}
	
	
	public void movePersonnageLeft(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		
		if ( estLibre(personnage.getX()-1, personnage.getY()) ) {
			personnage.move(-1, 0);
		}
	}
	
	
	public void movePersonnageRight(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		
		if ( estLibre(personnage.getX()+1, personnage.getY()) ) {
			personnage.move(1, 0);
		}
	}


	public Point getPersonnagePosition(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		return new Point( personnage.getX(), personnage.getY() );
	}
	
	public boolean estLibre(int x, int y) {
		return modele.getPlateau().getMatrice().get(x, y).estLibre();
	}
	
	
	public boolean estBlocIncassable(int x, int y) {
		return modele.getPlateau().getMatrice().get(x, y).estBlocIncassable();
	}
	
	public boolean estBlocCassable(int x, int y) {
		return modele.getPlateau().getMatrice().get(x, y).estBlocCassable();
	}


	public int getMapWidth() {
		return modele.getPlateau().getWidth();
	}


	public int getMapHeight() {
		return modele.getPlateau().getHeight();
	}


	public int getSizePersonnage() {
		return modele.getListPersonnages().size();
	}


	public void dropBomb(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		modele.getListBomb().add( new Bomb(personnage.getX(), personnage.getY(), this) );
	}


	public int getSizeBomb() {
		return modele.getListBomb().size();
	}


	public Point getBombPosition(int idBomb) {
		Bomb bomb = modele.getBomb( idBomb );
		return new Point( bomb.getX(), bomb.getY() );
	}


	public void makeExplosion(int x, int y, Explosion explosion) {
		modele.getListExplosion().add( explosion );
		addExplosionUp(x,y);
		addExplosionDown(x,y);
		addExplosionLeft(x,y);
		addExplosionRight(x,y);
		vue.repaint();
	}


	public int getSizeExplosion() {
		return modele.getListExplosion().size();
	}


	public Point getExplosionPosition(int idExplosion) {
		Explosion explosion = modele.getExplosion( idExplosion );
		return new Point( explosion.getX(), explosion.getY() );
	}
	
	
	public void addExplosionUp(int x, int y){
		y += 1;
		while( estLibre(x,y) ){
			modele.getListExplosion().add( new Explosion(x,y,this) );
			y += 1;
		}
	}
	
	public void addExplosionDown(int x, int y){
		y -= 1;
		while( estLibre(x,y) ){
			modele.getListExplosion().add( new Explosion(x,y,this) );
			y -= 1;
		}
	}
	
	public void addExplosionLeft(int x, int y){
		x -= 1;
		while( estLibre(x,y) ){
			modele.getListExplosion().add( new Explosion(x,y,this) );
			x -= 1;
		}
	}
	
	public void addExplosionRight(int x, int y){
		x += 1;
		while( estLibre(x,y) ){
			modele.getListExplosion().add( new Explosion(x,y,this) );
			x += 1;
		}
	}

}

