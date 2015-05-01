package bomberman.controleur;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import bomberman.modele.Bombe;
import bomberman.modele.Bonus;
import bomberman.modele.Malus;
import bomberman.modele.Modele;
import bomberman.modele.Mort;
import bomberman.modele.Personnage;
import bomberman.vue.Vue;


public class Controleur {
	
	private Vue vue;
	private Modele modele;
	private int nb_joueurs = 1;
	private int niveau = 1;
	boolean EtatJeu = false ;
	private int[][] touches = {{KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT,KeyEvent.VK_SPACE},
			{KeyEvent.VK_Z,KeyEvent.VK_S,KeyEvent.VK_Q,KeyEvent.VK_D,KeyEvent.VK_X},
			{KeyEvent.VK_Y,KeyEvent.VK_H,KeyEvent.VK_G,KeyEvent.VK_J,KeyEvent.VK_N},
			{KeyEvent.VK_O,KeyEvent.VK_L,KeyEvent.VK_K,KeyEvent.VK_M,KeyEvent.VK_P}};


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
	
	public void jeuEnMarche(boolean etat){
		EtatJeu = etat ;
	}
	
	public boolean isJeuEnCours(){
		return EtatJeu;
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
	
	public void ChoixTheme(Object Choix){
		int Choixtheme = 0 ;
		if (Choix == "Mario") Choixtheme = 1 ;
		if (Choix == "Tetris") Choixtheme = 2 ;

		
		modele.creerTheme(Choixtheme);
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
	
	public void creerJoueurs(){
		modele.createPlayers(nb_joueurs);
		for (int i=0; i< nb_joueurs; i++){
			ListenerPlayer listenerPlayer = new ListenerPlayer (this, i, modele.getPersonnage(i));
			listenerPlayer.setKeyForUp(touches[i][0]);
			listenerPlayer.setKeyForDown(touches[i][1]);
			listenerPlayer.setKeyForLeft(touches[i][2]);
			listenerPlayer.setKeyForRight(touches[i][3]);
			listenerPlayer.setKeyForDrop(touches[i][4]);
			vue.getJeu().addKeyListener(listenerPlayer);
		}

	}
	
	public void creerMalus() {
		modele.createMalus(niveau);
	}
	
	public void moveMalus(){
		for (int i = 0; i < modele.getMalus().size(); i++){
			Malus mal = modele.getMalus().get(i);
		    Timer timerMalus = new Timer(500, new BougerMalus(this, modele, mal.getIdentifiant()));
		    timerMalus.start();
		} 
	}
	
	
	/**
	 * Bouge le personnage d une case
	 * @param idPersonnage L'ID du personnage
	 */
	public void movePersonnage(int idPersonnage, int avance_x, int avance_y) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		int x = personnage.getX();
		int y = personnage.getY();
		x += avance_x;
		y += avance_y;
		activerTunnel(personnage, x,y);
		if ( estLibre(x,y) && personnage.getVivant() && bombePersonnage(x,y,idPersonnage)) {
			personnage.move(avance_x, avance_y);
		}
		if ( estBonus(x,y) && personnage.getVivant()){
			int idBonus = modele.getIdBonus(x, y);
			addBonus(personnage,idBonus,x,y);
			modele.removeBonusDuPlateau(x,y);
			personnage.activerBonus();
		}
		if ( estMalus(x,y) && personnage.getVivant()){
			personnage.perdreVie();
			if (personnage.getNb_vies() <= 0){
				personnage.mourir();
			}
		}
	}
	
	
	
	
	private boolean bombePersonnage(int x, int y, int idPersonnage) {
		int idBombe = modele.getIdBombe(x, y);
		if (idBombe != -1){
		    Bombe bombe = modele.getListBombe().get(idBombe);
	    	if (bombe.getIdPersonnage() != idPersonnage){
	    		return false;
	    	}
		}
		return true;
	}


	private void activerTunnel(Personnage personnage, int x, int y) {
		if (y == 0 && personnage.isTunnel() && estLibre(x,15)){
			personnage.setY(15);
			y = 15;
		}
		else if (y == 16 && personnage.isTunnel() && estLibre(x,1)){
			personnage.setY(1);
			y = 1;
		}
		else if (x == 0 && personnage.isTunnel() && estLibre(15,y)){
			personnage.setX(15);
			x = 15;
		}
		else if (x == 16 && personnage.isTunnel() && estLibre(1,y)){
			personnage.setX(1);
			x = 1;
		}
	}


	private void addBonus(Personnage personnage, int idBonus, int x, int y){
		String type_bonus = getTypeBonus(idBonus);
		if (type_bonus == "bonus_intensite1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,1,0,0,0,0,0));
		}
		if (type_bonus == "bonus_clavier1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,1,0,0,0,0));
		}
		if (type_bonus == "bonus_bombe1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,0,1,0,0,0));
		}
		if (type_bonus == "bonus_vie1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,0,0,1,0,0));
		}
		if (type_bonus == "bonus_explosion1.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,0,0,0,1,0));
		}
		if (type_bonus == "bonus_tunnel.png"){
			personnage.getBonus_personnage().add(new Bonus(x,y,0,0,0,0,0,1));
		}
	}
	
	private boolean estBonus(int x, int y) {
		return modele.bonusSurCase(x, y);
	}
	
	private boolean estMalus(int x, int y){
		return modele.malusSurCase(x, y);
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
	
	public Point getMalusPosition(int idMalus){
		Malus mal = modele.getMal( idMalus );
		int x = mal.getX();
		int y = mal.getY();
		return new Point(x,y);
	}
	
	
	/**
	 * Verifier si la case est libre
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
	
	public boolean estBombe(int x, int y){
		return modele.BombeSurCase(x,y);
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
		if (bonus.getBonus_tunnel() == 1){
			type = "bonus_tunnel.png";
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
		if ( casePasDeBomb( x,y ) && personnage.getVivant() && personnage.getNb_bombes() > 0){
			modele.getListBombe().add( new Bombe(x,y,portee,duree,this,idPersonnage) );
			personnage.perdreBombe();
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
		int dureeBombe = 1500;
		int idBonus = 0;
		while (idBonus < personnage.getBonus_personnage().size()){
			if (bonus_provisoire(personnage, idBonus).getBonus_explosion() == 1){
				int deltaDuree = (int) (Math.random()*2000)-1000;
				dureeBombe = dureeBombe + deltaDuree;
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
		return modele.getListBombe().size();
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
		addExplosion(x,y, 1, 0, portee);
		addExplosion(x,y, -1, 0, portee);
		addExplosion(x,y, 0, 1, portee);
		addExplosion(x,y, 0, -1, portee);
		if (estPersonnage(x,y)){
			Personnage personnage = modele.getPersonnageSurPlateau(x, y);
			if (personnage.getVivant()){
	    		personnage.perdreVie();
    			if (personnage.getNb_vies()<=0){
				    personnage.mourir();
			    }
			}
		}
		if (estMalus(x,y)){
			modele.removeMalusDuPlateau(x, y);
		}
		vue.repaint();
	}


	/**
	 * Savoir le nombre d'explosions presentes sur le plateau
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
	public void addExplosion(int x, int y, int direction_x, int direction_y, int portee){
		x += direction_x ;
		y += direction_y;
		int p = 0;
		while( !estBlocIncassable(x,y) && !estBlocCassable(x,y) && !estPersonnage(x,y) && !estBombe(x,y) && !estMalus(x,y) && p<portee){
			addExplosion(x,y);
			x += direction_x ;
			y += direction_y;
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
			Personnage personnage = modele.getPersonnageSurPlateau(x,y);
			if (personnage.getVivant()){
		    	personnage.perdreVie();
	    		if (personnage.getNb_vies()<=0){
	            personnage.mourir();
		    	}
			}
			addExplosion(x,y);
		}
		if (estBombe(x,y) && p<portee){
			int idBombe = modele.getIdBombe(x, y);
			Bombe bombe = modele.getListBombe().get(idBombe);
			int porteeBombe = bombe.getPortee();
			bombe.getExplosion().setBombeExplosee(true);
			makeExplosion(new Explosion(x,y,500,porteeBombe,this,null));
			removeBombe(modele.getListBombe().get(idBombe));
		}
		if (estMalus(x,y) && p<portee){
			modele.removeMalusDuPlateau(x, y);
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
	 * @param y L'ordonnee de l'explosion
	 */
	private void addExplosion(int x, int y){
		modele.getListExplosion().add( new Explosion(x,y,500,0,this,null) );
	}


	/**
	 * Supprimer la bombe
	 * @param bombe 
	 */
	public void removeBombe(Bombe bombe) {
		int idPersonnage = bombe.getIdPersonnage();
		modele.getPersonnage(idPersonnage).gagnerBombe();
		modele.getListBombe().remove( bombe );
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

