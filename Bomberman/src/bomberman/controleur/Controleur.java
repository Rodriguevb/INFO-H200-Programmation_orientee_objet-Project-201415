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
	 * Lie le mod�le au controleur
	 * @param modele Le mod�le.
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
			personnage.setNom_image(personnage.getNom()+"Dos.png");
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
			personnage.setNom_image(personnage.getNom()+"Face.png");
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
			personnage.setNom_image(personnage.getNom()+"Gauche.png");
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
			personnage.setNom_image(personnage.getNom()+"Droite.png");
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
	
	public String getPersonnageNomImage(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		String nom_image = personnage.getNom_image();
		return nom_image;
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
	 * L‰che une bombe ˆ l'endroit du personnage
	 * @param idPersonnage L'ID du personnage
	 */
	public void dropBomb(int idPersonnage) {
		Point point = getPersonnagePosition( idPersonnage );
		int x = point.x;
		int y = point.y;
		
		if ( casePasDeBomb( x,y ) ){
			modele.getListBomb().add( new Bombe(x,y,this) );
		}
	}
	
	
	/**
	 * Savoir si la case poss�de une bombe ou non.
	 * @param x,y Position de la case ˆ vŽrifier.
	 * @return Vrai si il y a une bombe ˆ l'emplacement.
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
		int portee = explosion.getPortee();
		addExplosionUp(x,y,portee);
		addExplosionDown(x,y,portee);
		addExplosionLeft(x,y,portee);
		addExplosionRight(x,y,portee);
		vue.repaint();
	}


	/**
	 * Savoir le nombre d'explosions prŽsentes sur le plateau
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
	 * Ajoute des explosions en cha�?ne 
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnŽe de l'explosion
	 */
	public void addExplosionUp(int x, int y, int portee){
		y -= 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && p<portee){
			addExplosion(x,y);
			y -= 1;
			p += 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}

	
	/**
	 * Ajoute des explosions en cha�?ne
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnŽe de l'explosion
	 */
	public void addExplosionDown(int x, int y, int portee){
		y += 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && p<portee){
			addExplosion(x,y);
			y += 1;
			p += 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Ajoute des explosions en cha�?ne
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnŽe de l'explosion
	 */
	public void addExplosionLeft(int x, int y, int portee){
		x -= 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && p<portee){
			addExplosion(x,y);
			x -= 1;
			p += 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Ajoute des explosions en cha�?ne
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnŽe de l'explosion
	 */
	public void addExplosionRight(int x, int y, int portee){
		x += 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && p<portee){
			addExplosion(x,y);
			x += 1;
			p += 1;
		}
		if( estBlocCassable(x,y) ){
			removeBlocCassable(x,y);
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Supprimer le bloc cassable
	 * @param x L'abscisse du bloc cassable
	 * @param y L'ordonnŽe du bloc cassable
	 */
	private void removeBlocCassable(int x, int y) {
		modele.getCase(x,y).rendreLibre();
	}
	
	
	/**
	 * Ajouter une explosion 
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnŽe de l'explosion
	 */
	private void addExplosion(int x, int y){
		modele.getListExplosion().add( new Explosion(x,y,1000,0,this,null) );
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

