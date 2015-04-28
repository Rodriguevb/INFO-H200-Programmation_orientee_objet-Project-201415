package bomberman.modele;


public abstract class PossedePosition {
	
	
	protected int x = 0;
	protected int y = 0;
	
	public PossedePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
}
