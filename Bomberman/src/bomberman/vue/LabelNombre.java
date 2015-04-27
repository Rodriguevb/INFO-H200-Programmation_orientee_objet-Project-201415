package bomberman.vue;

import java.awt.Color;

import javax.swing.JLabel;

import bomberman.controleur.Controleur;
import bomberman.modele.Modele;


public class LabelNombre extends JLabel {
	
	private static final long serialVersionUID = 1L;
	private Modele modele = null;
	private Controleur controleur = null ;
	private Integer personnageConcerne ;
	private Integer objetConcerne ;
	private String nbAffiche ;
	
	
	public LabelNombre (int id, int objet , String nb, int y){
		super(nb);
		this.controleur = controleur ;
		this.modele = modele ;
		this.nbAffiche = nb ;
		this.personnageConcerne = id;
		this.objetConcerne = objet;	
		this.setFont(new java.awt.Font("Comic Sans MS",1,15));
		this.setForeground(new Color(175,175,175));
		this.setBounds(100,y,30,30);		
	}


	public String getNbAffiche() {
		return nbAffiche;
	}


	public Integer getPersonnageConcerne() {
		return personnageConcerne;
	}


	public Integer getObjetConcerne() {
		return objetConcerne;
	}

}