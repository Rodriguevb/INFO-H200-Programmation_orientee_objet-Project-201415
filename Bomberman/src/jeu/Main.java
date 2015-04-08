package jeu;
import panel.Menu;
import fenetre.Fenetre;



public class Main {
	
	
	public static void main(String[] args) {
		
		
		Fenetre fenetre = new Fenetre();
		
		Menu menu = new Menu(fenetre);
		
		fenetre.setContentPane(menu);
		fenetre.setVisible(true);

		
	}

}
