import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Main {
	
	
	public static void main(String[] args) {
		
		Plateau plateau = new Plateau();
		Vue vue = new Vue(plateau);
		Controleur controleur = new Controleur(plateau, vue);

		
	}

}
