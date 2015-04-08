package bomberman.vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Bouton_options extends JButton implements ActionListener{
	
	
	/**
	 * Classe du bouton options.
	 */
	private static final long serialVersionUID = 1L; 
	
	
	public Bouton_options() {
		super("Options");
		this.addActionListener(this); // mets le bouton sur Žcoute de la souris
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}