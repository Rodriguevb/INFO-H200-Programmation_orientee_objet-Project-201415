package bomberman.modele;

import java.util.ArrayList;
import java.util.Random;


public class Plateau {
	
	private ArrayList<Case> liste_cases = new ArrayList<Case>();
	
	public Plateau(){
		Personnage_gentil personnage1 = new Personnage_gentil(50,50,1,1,"oeil","bob.png");
		liste_cases.add(personnage1);
		creation_plateau();
		ajout_blocs();
	}
	
	public void creation_plateau(){
		for (int i=0;i<=800;i+=50){
			
			liste_cases.add(new Bloc_incassable(i,0) );
			liste_cases.add(new Bloc_incassable(i,800) );
		}
			
		for (int j=50;j<=750;j+=50){
				
			liste_cases.add(new Bloc_incassable(0,j));
			liste_cases.add(new Bloc_incassable(800,j));
		}
			
		for (int i=100;i<=750;i+=100){
				
			for( int j=100;j<=750;j+=100){
				
				liste_cases.add(new Bloc_incassable(i,j));
				}
		}
					
	}
	
	public void ajout_blocs(){
		int j = 0 ;
		Random rand = new Random();
		
		while (j < 80){
			int i = rand.nextInt(15)+1;
			int k = rand.nextInt(15)+1;
			if (libre(i*50,k*50)){
				liste_cases.add(new Bloc_cassable(i*50,k*50));
				j++;
			}
		}
	}

	public boolean libre(int x,int y){
		boolean is_libre = true;
		for (Case i : liste_cases){
			if (i.getX()==x && i.getY()==y){
				is_libre = false;}
			}
		return is_libre;
	}
	
	public int getPositionX(int i){
		return liste_cases.get(i).getX();
	}
	
	public int getPositionY(int i){
		return liste_cases.get(i).getY();
	}


	public ArrayList<Case> getListe_cases() {
		return liste_cases;
	}


	public void setListe_cases(ArrayList<Case> liste_cases) {
		this.liste_cases = liste_cases;
	}
	
	
	public void bombeExplose(int i){
		liste_cases.remove(i);
	}
	
}