package bomberman.controleur;

import java.awt.Point;

import bomberman.modele.Bombe;
import bomberman.modele.Modele;
import bomberman.modele.Personnage;
import bomberman.vue.Vue;


public class Controleur {
	
	private Vue vue;
	private Modele modele;
	
	
	/**
	 * Lie la vue au controleur
	 * @param vue La vue.
	 */
	public void link(Vue vue) {
		this.vue = vue;
	}
	
	
	/**
	 * Lie le modèle au controleur
	 * @param modele Le modèle.
	 */
	public void link(Modele modele) {
		this.modele = modele;
	}
	
	
	/**
	 * Passe l'affichage au menu
	 */
	public void switchToMenu() {
		vue.switchToMenu();
	}
	
	
	/**
	 * Passe l'affichage au jeu
	 */
	public void switchToJeu() {
		vue.switchToJeu();
	}
	
	public void switchToOptions() {
		vue.switchToOptions();
	}
	
	
	/**
	 * Redessine
	 */
	public void repaint() {
		vue.repaint();
	}
	
	
	/**
	 * Bouge le personnage une case au dessus
	 * @param idPersonnage L'ID du personnage
	 */
	public void movePersonnageUp(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		int x = personnage.getX();
		int y = personnage.getY();
		y -= 1;
		if ( estLibre(x,y) ) {
			personnage.move(0, -1);
		}
	}
	
	
	/**
	 * Bouge le personnage une case vers le bas
	 * @param idPersonnage L'ID du personnage
	 */
	public void movePersonnageDown(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		int x = personnage.getX();
		int y = personnage.getY();
		y += 1;
		if ( estLibre(x,y) ) {
			personnage.move(0, 1);
		}
	}
	
	
	/**
	 * Bouge le personnage vers la gauche
	 * @param idPersonnage L'ID du personnage
	 */
	public void movePersonnageLeft(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		int x = personnage.getX();
		int y = personnage.getY();
		x -= 1;
		if ( estLibre(x,y) ) {
			personnage.move(-1, 0);
		}
	}
	
	
	/**
	 * Bouge le personnage vers la droite
	 * @param idPersonnage L'ID du personnage
	 */
	public void movePersonnageRight(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		int x = personnage.getX();
		int y = personnage.getY();
		x += 1;
		if ( estLibre(x,y) ) {
			personnage.move(1, 0);
		}
	}


	/**
	 * Retourne la position du personnage
	 * @param idPersonnage L'ID du personnage
 	 * @return La position
	 */
	public Point getPersonnagePosition(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		int x = personnage.getX();
		int y = personnage.getY();
		return new Point(x,y);
	}
	
	
	/**
	 * Savoir si la case est libre
	 * @param x,y La position de la case.
	 * @return Vrai si la case est libre
	 */
	public boolean estLibre(int x, int y) {
		return modele.getCase(x,y).estLibre();
	}
	
	
	/**
	 * Savoir si la case contient un bloc incassable
	 * @param x,y Position de la case.
	 * @return Vrai si le case contient un bloc incassable
	 */
	public boolean estBlocIncassable(int x, int y) {
		return modele.getCase( x,y ).getPossedeBlocIncassable();
	}
	
	
	/**
	 * Savoir si la case contient un bloc cassable
	 * @param x,y Position de la case.
	 * @return Vrai si la case contient un bloc cassable
	 */
	public boolean estBlocCassable(int x, int y) {
		return modele.getCase( x,y ).getPossedeBlocCassable();
	}
	

	/**
	 * Savoir la longueur du plateau
	 * @return La longueur du plateau
	 */
	public int getMapWidth() {
		return modele.getPlateau().getWidth();
	}


	/**
	 * Savoir la largeur du plateau
	 * @return La largeur du plateau
	 */
	public int getMapHeight() {
		return modele.getPlateau().getHeight();
	}


	/**
	 * Savoir le nombre de personnage
	 * @return Le nombre de personnage
	 */
	public int getNumberPersonnage() {
		return modele.getListPersonnages().size();
	}


	/**
	 * Lâche une bombe à l'endroit du personnage
	 * @param idPersonnage L'ID du personnage
	 */
	public void dropBomb(int idPersonnage) {
		Point point = getPersonnagePosition( idPersonnage );
		int x = point.x;
		int y = point.y;
		
		if ( casePasDeBomb( x,y ) ){
			modele.getListBomb().add( new Bombe(x,y, this) );
		}
	}
	
	
	/**
	 * Savoir si la case possède une bombe ou non.
	 * @param x,y Position de la case à vérifier.
	 * @return Vrai si il y a une bombe à l'emplacement.
	 */
	private boolean casePasDeBomb(int x, int y) {	
		return !modele.getCase(x,y).getPossedeBombe();
	}


	/**
	 * Savoir le nombre de bombes sur le plateau
	 * @return Le nombre de bombes
	 */
	public int getSizeBomb() {
		return modele.getListBomb().size();
	}


	/**
	 * Savoir la position de la bombe
	 * @param idBomb L'ID de la bombe
	 * @return La position de la bombe
	 */
	public Point getBombPosition(int idBomb) {
		Bombe bombe = modele.getBomb( idBomb );
		int x = bombe.getX();
		int y = bombe.getY();
		return new Point(x,y);
	}


	/**
	 * Provoque une explosion en croix.
	 * @param explosion L'origine de l'explosion en chaine
	 */
	public void makeExplosion(Explosion explosion) {
		modele.getListExplosion().add( explosion );
		int x = explosion.getX();
		int y = explosion.getY();
		addExplosionUp(x,y);
		addExplosionDown(x,y);
		addExplosionLeft(x,y);
		addExplosionRight(x,y);
		vue.repaint();
	}


	/**
	 * Savoir le nombre d'explosions présentes sur le plateau
	 * @return Le nombre d'explosions
	 */
	public int getSizeExplosion() {
		return modele.getListExplosion().size();
	}


	/**
	 * Savoir la position de l'explosion
	 * @param idExplosion L'ID de l'explosion
	 * @return La position de l'explosion
	 */
	public Point getExplosionPosition(int idExplosion) {
		Explosion explosion = modele.getExplosion( idExplosion );
		int x = explosion.getX();
		int y = explosion.getY();
		return new Point(x,y);
	}
	
	
	/**
	 * Ajoute des explosions en chaîne 
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnée de l'explosion
	 */
	public void addExplosionUp(int x, int y){
		y -= 1;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) ){
			addExplosion(x,y);
			y -= 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}

	
	/**
	 * Ajoute des explosions en chaîne
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnée de l'explosion
	 */
	public void addExplosionDown(int x, int y){
		y += 1;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) ){
			addExplosion(x,y);
			y += 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Ajoute des explosions en chaîne
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnée de l'explosion
	 */
	public void addExplosionLeft(int x, int y){
		x -= 1;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) ){
			addExplosion(x,y);
			x -= 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Ajoute des explosions en chaîne
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnée de l'explosion
	 */
	public void addExplosionRight(int x, int y){
		x += 1;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) ){
			addExplosion(x,y);
			x += 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Supprimer le bloc cassable
	 * @param x L'abscisse du bloc cassable
	 * @param y L'ordonnée du bloc cassable
	 */
	private void removeBlocCassable(int x, int y) {
		modele.getCase(x,y).rendreLibre();
	}
	
	
	/**
	 * Ajouter une explosion 
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnée de l'explosion
	 */
	private void addExplosion(int x, int y){
		modele.getListExplosion().add( new Explosion(x,y,this,null) );
	}


	/**
	 * Supprimer la bombe
	 * @param bombe 
	 */
	public void removeBombe(Bombe bombe) {
		modele.getListBomb().remove( bombe );
		repaint();
	}
	
	
	/**
	 * Supprimer l'explosion
	 * @param explosion
	 */
	public void removeExplosion(Explosion explosion){
		modele.getListExplosion().remove(explosion);
		repaint();
	}

}

