package bomberman.modele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bomberman.Controleur.Controleur;

public class actionListener implements ActionListener {
		private Plateau plateau;
		private Controleur controleur;
		
		
		public actionListener(Plateau plateau, Controleur controleur){
			this.plateau = plateau;
			this.controleur = controleur;
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = 0;
			while (i < plateau.getListe_cases().size()){
				if (plateau.getListe_cases().get(i) instanceof Bombe){
					try{
						if (plateau.getListe_cases().get(i).explose.isExplosion()){
							plateau.bombeExplose(i);
							controleur.repaint();
						}
						else
							i ++;
					} catch (Exception e){
						System.out.println("Erreur!");
					}
				}
				else
					i ++;
			}
			
		}

	}

