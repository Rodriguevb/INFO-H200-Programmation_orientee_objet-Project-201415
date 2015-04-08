package jeu;
import panel.Fenetre;
import panel.Menu;



public class Main {
	
	
	public static void main(String[] args) {
		
		
		Fenetre fenetre = new Fenetre();
		
		Menu menu = new Menu(fenetre);
		
		fenetre.setContentPane(menu);
		fenetre.setVisible(true);

		//coucou
	}

}
