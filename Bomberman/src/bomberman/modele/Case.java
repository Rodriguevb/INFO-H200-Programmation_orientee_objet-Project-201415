package bomberman.modele;

public class Case extends PossedePosition {
	
	
	
	private Object object;


	public Case(int x, int y) {
		super(x, y);
	}
	
	
	public void setOccupation(Object object) {
		this.object = object;
	}
	
	
	public boolean estLibre() {
		return this.object == null;
	}


	public boolean estBlocIncassable() {
		return this.object instanceof BlocIncassable;
	}


	public boolean estBlocCassable() {
		return this.object instanceof BlocCassable;
	}
}
