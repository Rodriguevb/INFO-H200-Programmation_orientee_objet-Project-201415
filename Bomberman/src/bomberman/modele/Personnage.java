package bomberman.modele;


public class Personnage extends Case {
	
	protected int nombre_vies ;
	protected String nom_image;
	protected boolean up;
	protected boolean down;
	protected boolean left;
	protected boolean right;
	protected int vitesse;
	
	public Personnage(int x, int y){
		super(x,y);
	}
	
	public String getNom_image(){
		return nom_image;
	}
	
	
	public void move(int go_x, int go_y){
		int x = getX();
		int y = getY();
		
		setX( x + go_x*vitesse );
		setY( y + go_y*vitesse );
	 }
	 
	public void perdre_vie(){
		
	}
	
	public void mourir(){
		
	}
	
}