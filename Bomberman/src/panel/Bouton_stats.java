package panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Bouton_stats extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton statistiques.
	 */
	private static final long serialVersionUID = 1L; 
	
	
	public Bouton_stats() {
		super( "Statistiques");
		this.addActionListener(this); // mets le bouton sur Žcoute de la souris
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
      
}
