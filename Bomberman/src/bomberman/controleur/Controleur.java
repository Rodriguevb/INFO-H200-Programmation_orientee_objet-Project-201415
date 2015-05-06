package bomberman.controleur;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import bomberman.modele.Bombe;
import bomberman.modele.Bonus;
import bomberman.modele.BonusBombe;
import bomberman.modele.BonusClavier;
import bomberman.modele.BonusExplosion;
import bomberman.modele.BonusGilet;
import bomberman.modele.BonusIntensite;
import bomberman.modele.BonusTunnel;
import bomberman.modele.BonusVie;
import bomberman.modele.Malus;
import bomberman.modele.Modele;
import bomberman.modele.Personnage;
import bomberman.vue.Vue;


public class Controleur {
	
	
	/**
	 * Classe 
	 */
	private Vue vue;
	private Modele modele;
	private int nb_joueurs = 2;
	private int niveau = 1;
	private int[][] touches = {{KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT,KeyEvent.VK_SPACE},
			{KeyEvent.VK_Z,KeyEvent.VK_S,KeyEvent.VK_Q,KeyEvent.VK_D,KeyEvent.VK_X},
			{KeyEvent.VK_Y,KeyEvent.VK_H,KeyEvent.VK_G,KeyEvent.VK_J,KeyEvent.VK_N},
			{KeyEvent.VK_O,KeyEvent.VK_L,KeyEvent.VK_K,KeyEvent.VK_M,KeyEvent.VK_P}};


	/**
	 * Lie la vue au controleur
	 * @param vue La vue
	 */
	public void link(Vue vue) {
		this.vue = vue;
	}
	
	
	/**
	 * Lie le modele au controleur
	 * @param modele Le modele
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
	
	
	/**
	 * Passe l'affichage aux options
	 */
	public void switchToOptions() {
		vue.switchToOptions();
	}
	
	
	/**
	 * Redessine/actualise l'affichage
	 */
	public void repaint() {
		vue.repaint();
	}
	
	
	/**
	 * Initialise le nombre de joueurs
	 * @param NbJoueurs Le nombre de joueurs
	 */
	public void NbJoueurs(Object NbJoueurs){
		nb_joueurs = 2;
		if (NbJoueurs == "2 joueurs"){
			nb_joueurs = 2 ;}
		if (NbJoueurs == "3 joueurs"){
			nb_joueurs = 3 ;}
		if (NbJoueurs == "4 joueurs"){
			nb_joueurs = 4 ;}
	}
	
	
	/**
	 * Permet de connaitre le nombre de joueurs
	 * @return Le nombre de joueurs
	 */
	public int getNbJoueurs(){
		return nb_joueurs;
	}
	
	
	/**
	 * Choisit le theme du jeu
	 * @param Choix Le choix du theme
	 */
	public void ChoixTheme(Object Choix){
		int Choixtheme = 0 ;
		if (Choix == "Tetris") Choixtheme = 1 ;
		if (Choix == "Mario") Choixtheme = 0 ;
		
		modele.creerTheme(Choixtheme);
	}
	
	
	/**
	 * Choisit le niveau de difficulte
	 * @param Niveau Le niveau de la partie
	 */
	public void Niveau(Object Niveau){
		niveau = 1;
		if (Niveau == "Moyen"){
			niveau = 2;
		}
		if (Niveau == "Difficile"){
			niveau = 3;
		}
	}
	
	
	/**
	 * Cree les joueurs et attribue a chaque joueur des touches
	 */
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
	
	
	/**
	 * Cree les Malus dans le modele
	 */
	public void creerMalus() {
		modele.createMalus(niveau);
	}
	
	
	/**
	 * Cree un timer a chaque Malus pour qu'il puisse se deplacer
	 */
	public void moveMalus(){
		for (int i = 0; i < modele.getMalus().size(); i++){
			Malus mal = modele.getMalus().get(i);
		    Timer timerMalus = new Timer(600, new BougerMalus(this, modele, mal.getIdentifiant()));
		    timerMalus.start();
		} 
	}
	
	
	/**
	 * Bouge le personnage d'une case
	 * @param idPersonnage L'ID du personnage
	 * @param avance_x Direction en x
	 * @param avance_y Direction en y
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
		if ( estMalus(x,y) && personnage.getVivant() && !personnage.isGilet()){
			personnage.perdreVie();
			if (personnage.getNb_vies() <= 0){
				personnage.mourir();

			}
		}
	}
	
	
	/**
	 * Savoir quel personnage a depose la bombe
	 * @param x Position de la bombe en x
	 * @param y Position de la bombe en y
	 * @param idPersonnage L'ID du personnage
	 * @return Vrai si la bombe appartient au personnage
	 */
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

	
    /**
     * Active le bonus_tunnel lorsqu'un personnage en a recupere un
     * @param personnage Le personnage
     * @param x La position en x ou le personnage souhaite aller
     * @param y La position en y ou le personnage souhaite aller
     */
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

	
    /**
     * Permet au personnage de recuperer un bonus
     * @param personnage Le personnage
     * @param idBonus L'ID du bonus
     * @param x La position du personnage en x
     * @param y La position du personnage en y
     */
	private void addBonus(Personnage personnage, int idBonus, int x, int y){
		Bonus bonus = modele.getBonus( idBonus );
		String type_bonus = bonus.getNom();
		if (type_bonus == "BonusIntensite"){
			personnage.getBonus_personnage().add(new BonusIntensite(x,y,personnage));
		}
		if (type_bonus == "BonusClavier"){
			personnage.getBonus_personnage().add(new BonusClavier(x,y,personnage));
		}
		if (type_bonus == "BonusBombe"){
			personnage.getBonus_personnage().add(new BonusBombe(x,y,personnage));
		}
		if (type_bonus == "BonusVie"){
			personnage.getBonus_personnage().add(new BonusVie(x,y,personnage));
		}
		if (type_bonus == "BonusExplosion"){
			personnage.getBonus_personnage().add(new BonusExplosion(x,y,personnage));
		}
		if (type_bonus == "BonusTunnel"){
			personnage.getBonus_personnage().add(new BonusTunnel(x,y,personnage));
		}
		if (type_bonus == "BonusGilet"){
			personnage.getBonus_personnage().add(new BonusGilet(x,y,personnage));
		}
	}
	
	
	/**
	 * Permet de savoir si un bonus est present sur une case
	 * @param x La position en x de la case
	 * @param y La position en y de la case
	 * @return Vrai si presence d'un bonus sur la case
	 */
	private boolean estBonus(int x, int y) {
		return modele.bonusSurCase(x, y);
	}
	
	
	/**
	 * Permet de savoir si un malus est present sur une case
	 * @param x La position en x de la case
	 * @param y La position en y de la case
	 * @return Vrai si presence d'un malus sur la case
	 */
	private boolean estMalus(int x, int y){
		return modele.malusSurCase(x, y);
	}

	
	/**
	 * Retourne la position du personnage
	 * @param idPersonnage L'ID du personnage
 	 * @return La position du personnage
	 */
	public Point getPersonnagePosition(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		int x = personnage.getX();
		int y = personnage.getY();
		return new Point(x,y);
	}
	
	
	/**
	 * Recupere le nom_image d'un personnage
	 * @param idPersonnage L'ID du personnage
	 * @return Le nom_image du personnage
	 */
	public String getPersonnageNomImage(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		String nom_image = personnage.getNom_image();
		return nom_image;
	}
	
	/**
	 * Recupere le nom d'un personnage
	 * @param idPersonnage L'ID du personnage
	 * @return Le nom du personnage
	 */
	public String getPersonnageNom(int idPersonnage) {
		Personnage personnage = modele.getPersonnage( idPersonnage );
		String nom = personnage.getNom();
		return nom;
	}
	
	/**
	 * Determine le gagnant s'il ne reste qu'un personnage
	 * @return l'ID du gagnant
	 */
	public int getGagnant(){
		int i = 0 ;
		int idGagnant = -1 ;
		for (int id = 0 ; id < this.nb_joueurs ; id ++){
			if (modele.getPersonnage (id).getVivant()){
				i++ ;
				idGagnant = id ;
			}
		}
		
		if (i != 1) idGagnant = -1 ;
		return idGagnant ;
	}
	
	
	/**
	 * Recupere la position d'un malus
	 * @param idMalus L'ID du malus
	 * @return La position du malus
	 */
	public Point getMalusPosition(int idMalus){
		Malus mal = modele.getMal( idMalus );
		int x = mal.getX();
		int y = mal.getY();
		return new Point(x,y);
	}
	
	
	/**
	 * Verifie si la case est libre
	 * @param x La position de la case en x
	 * @param y La position de la case en y
	 * @return Vrai si la case est libre
	 */
	public boolean estLibre(int x, int y) {
		return modele.getCase(x,y).estLibre();
	}
	
	
	/**
	 * Savoir si la case contient un bloc incassable
	 * @param x La position de la case en x
	 * @param y La position de la case en y
	 * @return Vrai si le case contient un bloc incassable
	 */
	public boolean estBlocIncassable(int x, int y) {
		return modele.getCase( x,y ).getPossedeBlocIncassable();
	}
	
	
	/**
	 * Savoir si la case contient un bloc cassable
	 * @param x La position de la case en x
	 * @param y La position de la case en y
	 * @return Vrai si la case contient un bloc cassable
	 */
	public boolean estBlocCassable(int x, int y) {
		return modele.getCase( x,y ).getPossedeBlocCassable();
	}
	
	
	/**
	 * Savoir si la case contient un personnage
	 * @param x La position de la case en x
	 * @param y La position de la case en y
	 * @return Vrai si la case contient un personnage
	 */
	public boolean estPersonnage(int x, int y){
		return modele.PersonnageSurCase(x,y);
	}
	
	
	/**
	 * Savoir si la case contient une bombe
	 * @param x La position de la case en x
	 * @param y La position de la case en y
	 * @return Vrai si la case contient une bombe
	 */
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
	 * Savoir le nombre de personnages
	 * @return Le nombre de personnages
	 */
	public int getNumberPersonnage() {
		return modele.getListPersonnages().size();
	}
	

	
	/**
	 * Savoir le nombre de bonus sur le tableau
	 * @return Le nombre de bonus
	 */
	public int getSizeBonus(){
		return modele.getListBonus().size();
	}

	
	/**
	 * Recupere la position d'un bonus
	 * @param id L'ID du bonus
	 * @return La position du bonus
	 */
	public Point getBonusPosition(int id){
		Bonus bonus = modele.getBonus( id );
		int x = bonus.getX();
		int y = bonus.getY();
		return new Point(x,y);
	}
	
	
	/**
	 * Savoir le type de bonus et lui attribuer une image
	 * @param id L'ID du bonus
	 * @return Le type du bonus
	 */
	public String getNomBonus(int id){
		String type = "sans";
		Bonus bonus = modele.getBonus( id );
		if (bonus.getNom() == "BonusIntensite"){
			type = "bonus_intensite1.png";
		}
		if (bonus.getNom() == "BonusClavier"){
			type = "bonus_clavier1.png";
		}
		if (bonus.getNom() == "BonusBombe"){
			type = "bonus_bombe1.png";
		}
		if (bonus.getNom() == "BonusVie"){
			type = "Coeur(1).png";
		}
		if (bonus.getNom() == "BonusExplosion"){
			type = "bonus_explosion1.png";
		}
		if (bonus.getNom() == "BonusTunnel"){
			type = "bonus_tunnel.png";
		}
		if (bonus.getNom() == "BonusGilet"){
			type = "jacket.png";
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
		int portee = personnage.getPortee();
		int duree = personnage.getDuree();
		if ( casePasDeBomb( x,y ) && personnage.getVivant() && personnage.getNb_bombes() > 0){
			modele.getListBombe().add( new Bombe(x,y,portee,duree,this,idPersonnage) );
			personnage.perdreBombe();
		}
		personnage.setPortee(1);
		personnage.setDuree(1500);
		
	}
	
	
	/**
	 * Savoir si la case possede une bombe
	 * @param x La position en x de la case a verifier
	 * @param y La position en y de la case a verifier
	 * @return Vrai s'il y a une bombe a l'emplacement
	 */
	private boolean casePasDeBomb(int x, int y) {	
		return !modele.getCase(x,y).getPossedeBombe();
	}


	/**
	 * Savoir le nombre de bombes sur le tableau
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
	 * Provoque une explosion en croix
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
			if (personnage.getVivant() && !personnage.isGilet()){
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
	 * Savoir le nombre d'explosions presentes sur le tableau
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
	 * @param direction_x Direction de propagation en x
	 * @param direction_y Direction de propagation en y
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
			if (personnage.getVivant() && !personnage.isGilet()){
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
			removeBombe(modele.getListBombe().get(idBombe));
			makeExplosion(new Explosion(x,y,500,porteeBombe,this,null));
		}
		if (estMalus(x,y) && p<portee){
			modele.removeMalusDuPlateau(x, y);
			addExplosion(x,y);
		}
	}


	/**
	 * Supprime le bloc cassable
	 * @param x L'abscisse du bloc cassable
	 * @param y L'ordonnee du bloc cassable
	 */
	private void removeBlocCassable(int x, int y) {
		modele.getCase(x,y).rendreLibre();
	}
	
	
	/**
	 * Ajoute une explosion 
	 * @param x L'abscisse de l'explosion
	 * @param y L'ordonnee de l'explosion
	 */
	private void addExplosion(int x, int y){
		modele.getListExplosion().add( new Explosion(x,y,500,0,this,null) );
	}


	/**
	 * Supprime la bombe
	 * @param bombe La bombe
	 */
	public void removeBombe(Bombe bombe) {
		int idPersonnage = bombe.getIdPersonnage();
		modele.getPersonnage(idPersonnage).gagnerBombe();
		modele.getListBombe().remove( bombe );
		repaint();
	}
	
	
	/**
	 * Supprime l'explosion
	 * @param explosion L'explosion
	 */
	public void removeExplosion(Explosion explosion){
		modele.getListExplosion().remove(explosion);
		repaint();
	}

}

