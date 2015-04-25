package bomberman.controleur;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import bomberman.modele.Bombe;
import bomberman.modele.Bonus;
import bomberman.modele.Modele;
import bomberman.modele.Mort;
import bomberman.modele.Personnage;
import bomberman.vue.Vue;


public class Controleur {
	
	private Vue vue;
	private Modele modele;
	private int nb_joueurs = 1;
	private int niveau = 1;
	private ListenerPlayer listenerPlayer1;
	private ListenerPlayer listenerPlayer2;
	private ListenerPlayer listenerPlayer3;
	private ListenerPlayer listenerPlayer4;
	
	
	/**
	 * Lie la vue au controleur
	 * @param vue La vue.
	 */
	public void link(Vue vue) {
		this.vue = vue;
	}
	
	
	/**
	 * Lie le modele au controleur
	 * @param modele Le modele.
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
	 * Passe l'affichage au sous-menu
	 */
	public void switchToSousMenu() {
		vue.switchToSousMenu();
	}
	
	/**
	 * Passe l'affichage aux explications
	 */
	
	public void switchToExplications() {
		vue.switchToExplications();
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
	
	public void NbJoueurs(Object NbJoueurs){
		nb_joueurs = 1;
		if (NbJoueurs == "2 joueurs"){
			nb_joueurs = 2 ;}
		if (NbJoueurs == "3 joueurs"){
			nb_joueurs = 3 ;}
		if (NbJoueurs == "4 joueurs"){
			nb_joueurs = 4 ;}
	}
	
	
	public int getNbJoueurs(){
		return nb_joueurs;
	}
	
	public void ChoixJoueurs(Object Choix){
		String nom = "Mickey" ;
		if (Choix == "Bomber") nom = "Bomber" ;
		modele.creerListeNomJoueurs(nom);
	}
	
	public void Niveau(Object Niveau){
		niveau = 1;
		if (Niveau == "Moyen"){
			niveau = 2;
		}
		if (Niveau == "Difficile"){
			niveau = 3;
		}
	}
	
	// Essayer de réduire la méthode plus tard.
	public void creerJoueurs(){
		modele.createPlayers(nb_joueurs);
		listenerPlayer1 = new ListenerPlayer(this, 0);
		listenerPlayer1.setKeyForUp( KeyEvent.VK_UP );
		listenerPlayer1.setKeyForDown( KeyEvent.VK_DOWN );
		listenerPlayer1.setKeyForLeft( KeyEvent.VK_LEFT );
		listenerPlayer1.setKeyForRight( KeyEvent.VK_RIGHT );
		listenerPlayer1.setKeyForDrop( KeyEvent.VK_SPACE );
		vue.getJeu().addKeyListener( listenerPlayer1 );
		if (nb_joueurs >= 2){
			listenerPlayer2 = new ListenerPlayer(this, 1);
			listenerPlayer2.setKeyForUp( KeyEvent.VK_Z );
			listenerPlayer2.setKeyForDown( KeyEvent.VK_S );
			listenerPlayer2.setKeyForLeft( KeyEvent.VK_Q );
			listenerPlayer2.setKeyForRight( KeyEvent.VK_D );
			listenerPlayer2.setKeyForDrop( KeyEvent.VK_X );
			vue.getJeu().addKeyListener( listenerPlayer2 );
		}
		if (nb_joueurs >= 3){
			listenerPlayer3 = new ListenerPlayer(this, 2);
			listenerPlayer3.setKeyForUp( KeyEvent.VK_Y );
			listenerPlayer3.setKeyForDown( KeyEvent.VK_H );
			listenerPlayer3.setKeyForLeft( KeyEvent.VK_G );
			listenerPlayer3.setKeyForRight( KeyEvent.VK_J );
			listenerPlayer3.setKeyForDrop( KeyEvent.VK_N );
			vue.getJeu().addKeyListener( listenerPlayer3 );
		}
		if (nb_joueurs == 4){
			listenerPlayer4 = new ListenerPlayer(this, 3);
			listenerPlayer4.setKeyForUp( KeyEvent.VK_O );
			listenerPlayer4.setKeyForDown( KeyEvent.VK_L );
			listenerPlayer4.setKeyForLeft( KeyEvent.VK_K );
			listenerPlayer4.setKeyForRight( KeyEvent.VK_M );
			listenerPlayer4.setKeyForDrop( KeyEvent.VK_P );
			vue.getJeu().addKeyListener( listenerPlayer4 );
		}
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
		if ( estLibre(x,y) && personnage.getVivant()) {
			personnage.move(0, -1);
			personnage.setNom_image(personnage.getNom()+"Dos.png");
		}
		if ( estBonus(x,y) ){
			/*Bonus bonus = modele.getBonus(modele.getIdBonus(x,y));
			personnage.getBonus_personnage().add(new Bonus(bonus.getX(), bonus.getY(), bonus.get))*/
			int idBonus = modele.getIdBonus(x, y);
			addBonus(personnage,idBonus,x,y);
			modele.removeBonusDuPlateau(x,y);
			personnage.activerBonus();
			changerTouches(personnage);
		}
	}
	
	private void changerTouches(Personnage personnage){
		if (personnage.ownBonusClavier()){
			int idPersonnage = modele.getIdPersonnage(personnage.getX(), personnage.getY());
			recupererTouches(idPersonnage);
		}
	}
	
	
	
	private void recupererTouches(int idPersonnage) {
		if (idPersonnage == 0){
			listenerPlayer1.setKeyForUp( KeyEvent.VK_DOWN );
			listenerPlayer1.setKeyForDown( KeyEvent.VK_UP );
			listenerPlayer1.setKeyForLeft( KeyEvent.VK_RIGHT );
			listenerPlayer1.setKeyForRight( KeyEvent.VK_LEFT );
		}
		if (idPersonnage == 1){
			listenerPlayer2.setKeyForUp( KeyEvent.VK_S );
			listenerPlayer2.setKeyForDown( KeyEvent.VK_Z );
			listenerPlayer2.setKeyForLeft( KeyEvent.VK_D );
			listenerPlayer2.setKeyForRight( KeyEvent.VK_Q );
		}
		if (idPersonnage == 2){
			listenerPlayer3.setKeyForUp( KeyEvent.VK_H );
			listenerPlayer3.setKeyForDown( KeyEvent.VK_Y );
			listenerPlayer3.setKeyForLeft( KeyEvent.VK_J );
			listenerPlayer3.setKeyForRight( KeyEvent.VK_G );
		}
		if (idPersonnage == 3){
			listenerPlayer4.setKeyForUp( KeyEvent.VK_L );
			listenerPlayer4.setKeyForDown( KeyEvent.VK_O );
			listenerPlayer4.setKeyForLeft( KeyEvent.VK_M );
			listenerPlayer4.setKeyForRight( KeyEvent.VK_K );
		}
		Timer timerTouches = new Timer(10000, new Clavier(this, idPersonnage));
		timerTouches.setRepeats(false);
		timerTouches.start();
	}
	
	public void resetTouches(int idPersonnage){
		if (idPersonnage == 0){
			listenerPlayer1.setKeyForUp( KeyEvent.VK_UP );
			listenerPlayer1.setKeyForDown( KeyEvent.VK_DOWN );
			listenerPlayer1.setKeyForLeft( KeyEvent.VK_LEFT );
			listenerPlayer1.setKeyForRight( KeyEvent.VK_RIGHT );
		}
		if (idPersonnage == 1){
			listenerPlayer2.setKeyForUp( KeyEvent.VK_Z );
			listenerPlayer2.setKeyForDown( KeyEvent.VK_S );
			listenerPlayer2.setKeyForLeft( KeyEvent.VK_Q );
			listenerPlayer2.setKeyForRight( KeyEvent.VK_D );
		}
		if (idPersonnage == 2){
			listenerPlayer3.setKeyForUp( KeyEvent.VK_Y );
			listenerPlayer3.setKeyForDown( KeyEvent.VK_H );
			listenerPlayer3.setKeyForLeft( KeyEvent.VK_G );
			listenerPlayer3.setKeyForRight( KeyEvent.VK_J );
		}
		if (idPersonnage == 3){
			listenerPlayer4.setKeyForUp( KeyEvent.VK_O );
			listenerPlayer4.setKeyForDown( KeyEvent.VK_L );
			listenerPlayer4.setKeyForLeft( KeyEvent.VK_K );
			listenerPlayer4.setKeyForRight( KeyEvent.VK_M );
		}
	}


	private void addBonus(Personnage personnage, int idBonus, int x, int y){
		String type_bonus = getTypeBonus(idBonus);
		if (type_bonus == "bonus_intensite1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,1,0,0,0,0));
		}
		if (type_bonus == "bonus_clavier1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,1,0,0,0));
		}
		if (type_bonus == "bonus_bombe1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,0,1,0,0));
		}
		if (type_bonus == "bonus_vie1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,0,0,1,0));
		}
		if (type_bonus == "bonus_explosion1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,0,0,0,1));
		}
	}
	
	private boolean estBonus(int x, int y) {
		return modele.bonusSurCase(x, y);
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
		if ( estLibre(x,y) && personnage.getVivant()) {
			personnage.move(0, 1);
			personnage.setNom_image(personnage.getNom()+"Face.png");
		}
		if ( estBonus(x,y) ){
			/*Bonus bonus = modele.getBonus(modele.getIdBonus(x,y));
			personnage.getBonus_personnage().add(new Bonus(bonus.getX(), bonus.getY(), bonus.get))*/
			int idBonus = modele.getIdBonus(x, y);
			addBonus(personnage,idBonus,x,y);
			modele.removeBonusDuPlateau(x,y);
			personnage.activerBonus();
			changerTouches(personnage);
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
		if ( estLibre(x,y) && personnage.getVivant()) {
			personnage.move(-1, 0);
			personnage.setNom_image(personnage.getNom()+"Gauche.png");
		}
		if ( estBonus(x,y) ){
			/*Bonus bonus = modele.getBonus(modele.getIdBonus(x,y));
			personnage.getBonus_personnage().add(new Bonus(bonus.getX(), bonus.getY(), bonus.get))*/
			int idBonus = modele.getIdBonus(x, y);
			addBonus(personnage,idBonus,x,y);
			modele.removeBonusDuPlateau(x,y);
			personnage.activerBonus();
			changerTouches(personnage);
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
		if ( estLibre(x,y) && personnage.getVivant()) {
			personnage.move(1, 0);
			personnage.setNom_image(personnage.getNom()+"Droite.png");
		}
		if ( estBonus(x,y) ){
			/*Bonus bonus = modele.getBonus(modele.getIdBonus(x,y));
			personnage.getBonus_personnage().add(new Bonus(bonus.getX(), bonus.getY(), bonus.get))*/
			int idBonus = modele.getIdBonus(x, y);
			addBonus(personnage,idBonus,x,y);
			modele.removeBonusDuPlateau(x,y);
			personnage.activerBonus();
			changerTouches(personnage);
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
	
	public boolean estPersonnage(int x, int y){
		return modele.PersonnageSurCase(x,y);
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
	 * Savoir le nombre de morts sur le tableau
	 * @return Le nombre de morts
	 */
	public int getSizeMorts() {
		return modele.getListMorts().size();
	}
	
	public int getSizeBonus(){
		return modele.getListBonus().size();
	}

	/**
	 * Retourne la position du personnage elimine
	 * @param idPersonnage L'ID du personnage elimine
 	 * @return La position
	 */
	public Point getMortPosition(int id) {
		Mort mort = modele.getMort( id );
		int x = mort.getX();
		int y = mort.getY();
		return new Point(x,y);
	}
	
	public Point getBonusPosition(int id){
		Bonus bonus = modele.getBonus( id );
		int x = bonus.getX();
		int y = bonus.getY();
		return new Point(x,y);
	}
	
	public String getTypeBonus(int id){
		String type = "sans";
		Bonus bonus = modele.getBonus( id );
		if (bonus.getBonus_intensite() == 1){
			type = "bonus_intensite1.png";
		}
		if (bonus.getBonus_clavier() == 1){
			type = "bonus_clavier1.png";
		}
		if (bonus.getBonus_bombe() == 1){
			type = "bonus_bombe1.png";
		}
		if (bonus.getBonus_vie() == 1){
			type = "bonus_vie1.png";
		}
		if (bonus.getBonus_explosion() == 1){
			type = "bonus_explosion1.png";
		}
		return type;
	}
	


	/**
	 * Lache une bombe a l'endroit du personnage
	 * @param idPersonnage L'ID du personnage
	 */
	public void dropBomb(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		Point point = getPersonnagePosition( idPersonnage );
		int x = point.x;
		int y = point.y;
		int portee = getPortee(personnage);
		int duree = getDuree(personnage);
		System.out.println(portee);
		if ( casePasDeBomb( x,y ) && personnage.getVivant()){
			modele.getListBomb().add( new Bombe(x,y,portee,duree,this) );
		}
	}
	
	public int getPortee(Personnage personnage){
		int porteeBombe = 1;
		int idBonus = 0;
		while (idBonus < personnage.getBonus_personnage().size()){
			if (bonus_provisoire(personnage, idBonus).getBonus_intensite() == 1){
				porteeBombe++;
				personnage.removeBonus(idBonus);
			}
			else idBonus++;
		}
		return porteeBombe;
	}
	
	public int getDuree(Personnage personnage){
		int dureeBombe = 3000;
		int idBonus = 0;
		while (idBonus < personnage.getBonus_personnage().size()){
			if (bonus_provisoire(personnage, idBonus).getBonus_explosion() == 1){
				dureeBombe = dureeBombe - 500;
				personnage.removeBonus(idBonus);
			}
			else idBonus++;
		}
		return dureeBombe;
	}
	
	public Bonus bonus_provisoire(Personnage personnage, int idBonus){
		return personnage.getBonus_personnage().get(idBonus);
	}
	
	
	/**
	 * Savoir si la case possede une bombe ou non.
	 * @param x,y Position de la case ˆ verifier.
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
		if (estPersonnage(x,y)){
			modele.getPersonnageSurPlateau(x, y).perdreVie();
			System.out.println(modele.getPersonnageSurPlateau(x, y).getNb_vies());
			if (modele.getPersonnageSurPlateau(x, y).getNb_vies()==0){
				modele.getPersonnageSurPlateau(x, y).mourir();
				/*removePersonnage(x,y);
				modele.getListMorts().add(new Mort(x,y));*/
			}
		}
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
	 * Ajoute des explosions en chaine 
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnee de l'explosion
	 * @param portee La portee de l'explosion
	 */
	public void addExplosionUp(int x, int y, int portee){
		y -= 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && !estPersonnage(x,y) && p<portee){
			addExplosion(x,y);
			y -= 1;
			p += 1;
		}
		if( estBlocCassable(x,y) && p<portee){
			removeBlocCassable(x,y);
			double random = Math.random();
					if (random > 0.5){
						modele.createBonus(x, y, niveau);
					}
			addExplosion(x,y);
		}
		if (estPersonnage(x,y) && p<portee){
			modele.getPersonnageSurPlateau(x, y).perdreVie();
			System.out.println(modele.getPersonnageSurPlateau(x, y).getNb_vies());
			if (modele.getPersonnageSurPlateau(x, y).getNb_vies()==0){
				modele.getPersonnageSurPlateau(x, y).mourir();
				/*removePersonnage(x,y);
				modele.getListMorts().add(new Mort(x,y));*/
			}
			addExplosion(x,y);
		}
	}

	
	/**
	 * Ajoute des explosions en chaine
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnee de l'explosion
	 * @param portee La portee de l'explosion
	 */
	public void addExplosionDown(int x, int y, int portee){
		y += 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && !estPersonnage(x,y) && p<portee){
			addExplosion(x,y);
			y += 1;
			p += 1;
		}
		if( estBlocCassable(x,y) && p<portee){
			removeBlocCassable(x,y);
			double random = Math.random();
			    if (random > 0.5){
				    modele.createBonus(x, y, niveau);
			    }
			addExplosion(x,y);
		}
		if (estPersonnage(x,y) && p<portee){
			modele.getPersonnageSurPlateau(x, y).perdreVie();
			System.out.println(modele.getPersonnageSurPlateau(x, y).getNb_vies());
			if (modele.getPersonnageSurPlateau(x, y).getNb_vies()==0){
				modele.getPersonnageSurPlateau(x, y).mourir();
				/*removePersonnage(x,y);
				modele.getListMorts().add(new Mort(x,y));*/
			}
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Ajoute des explosions en chaine
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnee de l'explosion
	 * @param portee La portee de l'explosion
	 */
	public void addExplosionLeft(int x, int y, int portee){
		x -= 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && !estPersonnage(x,y) && p<portee){
			addExplosion(x,y);
			x -= 1;
			p += 1;
		}
		if( estBlocCassable(x,y) && p<portee){
			removeBlocCassable(x,y);
			double random = Math.random();
				if (random > 0.5){
				    modele.createBonus(x, y, niveau);
			    }
			addExplosion(x,y);
		}
		if (estPersonnage(x,y) && p<portee){
			modele.getPersonnageSurPlateau(x, y).perdreVie();
			System.out.println(modele.getPersonnageSurPlateau(x, y).getNb_vies());
			if (modele.getPersonnageSurPlateau(x, y).getNb_vies()==0){
				modele.getPersonnageSurPlateau(x, y).mourir();
				/*removePersonnage(x,y);
				modele.getListMorts().add(new Mort(x,y));*/
			}
			addExplosion(x,y);
		}
	}
	
	
	/**
	 * Ajoute des explosions en chaine
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnee de l'explosion
	 * @param portee La portee de l'explosion
	 */
	public void addExplosionRight(int x, int y, int portee){
		x += 1;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && !estPersonnage(x,y) && p<portee){
			addExplosion(x,y);
			x += 1;
			p += 1;
		}
		if( estBlocCassable(x,y) && p<portee){
			removeBlocCassable(x,y);
			double random = Math.random();
			    if (random > 0.5){
				    modele.createBonus(x, y, niveau);
			    }
			addExplosion(x,y);
		}
		if (estPersonnage(x,y) && p<portee){
			modele.getPersonnageSurPlateau(x, y).perdreVie();
			System.out.println(modele.getPersonnageSurPlateau(x, y).getNb_vies());
			if (modele.getPersonnageSurPlateau(x, y).getNb_vies()==0){
				modele.getPersonnageSurPlateau(x, y).mourir();
				/*removePersonnage(x,y);
				modele.getListMorts().add(new Mort(x,y));*/
			}
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
	
	/*private void removePersonnage(int x, int y){
		modele.removePersonnageDuPlateau(x,y);
	}*/
	
	
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

