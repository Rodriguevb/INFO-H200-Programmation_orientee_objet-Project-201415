import java.util.ArrayList;

import javax.swing.JFrame;


public class Frame extends JFrame {
	private Plateau plateau;
	private Panel panel;
	

	
	public Frame (Plateau plateau){
		this.plateau = plateau;
		this.setSize(868,897);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		panel = new Panel(plateau);
		this.setContentPane(panel);
		this.setVisible(true);
		
	}
	
	public void Repaint(){
		panel.repaint();
	}

	}