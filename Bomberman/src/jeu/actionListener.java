package jeu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionListener implements ActionListener {
		private Plateau plateau;
		private Vue vue;
		
		
		public actionListener(Plateau plateau, Vue vue){
			this.plateau = plateau;
			this.vue = vue;
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int i = 0;
			while (i < plateau.getListe_cases().size()){
				if (plateau.getListe_cases().get(i) instanceof Bombe){
					try{
						if (plateau.getListe_cases().get(i).explose.isExplosion()){
							plateau.bombeExplose(i);
							vue.getFrame().Repaint();
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

