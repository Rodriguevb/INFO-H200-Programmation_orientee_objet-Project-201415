package bomberman.modele;

public abstract class PossedePosition {
	
	
	private int x = 0;
	private int y = 0;
	
	
	public PossedePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() {
		return this.x;
	}
	
	
	public int getY() {
		return this.y;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
}
