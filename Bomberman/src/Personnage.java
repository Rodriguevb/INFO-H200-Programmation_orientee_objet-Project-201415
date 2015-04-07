public class Personnage extends Case {
	
	protected int x ;
	protected int y ;
	protected int nombre_vies ;
	protected String nom_image;
	protected boolean up;
	protected boolean down;
	protected boolean left;
	protected boolean right;
	protected int vitesse;
	
	public Personnage(){
		
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String getNom_image(){
		return nom_image;
	}
	
	/*public void setUp(boolean up){
		this.up=up;
	}
	
	public void setNombre_vies(int nombre_vies){
		this.nombre_vies=nombre_vies;
	}
*/
	 public void move(int go_x, int go_y){

		x+=go_x*vitesse;
		y+=go_y*vitesse;
	 }
	 
	public void perdre_vie(){
		
	}
	
	public void mourir(){
		
	}
	
}