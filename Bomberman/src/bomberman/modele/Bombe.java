package bomberman.modele;
import javax.swing.Timer;



public class Bombe extends Case{

	private int duree;
	private int action_x;
	private int action_y;
	private Timer timerBombe;
	
	public Bombe (int x,int y, int duree, int action_x, int action_y){
		super(x,y);
		
		this.duree = duree;
		this.action_x = action_x;
		this.action_y = action_y;
		this.nom_image = "bombe.png";
		explose = new Explose();
		timerBombe = new Timer(3000, explose);
		timerBombe.setRepeats(false);
		timerBombe.start();
	}
	public void exploser(){
		
	}
}