
public class Vue {
	private Plateau plateau;
	private Frame frame ;
	
	public Vue(Plateau plateau){
		this.plateau=plateau;
		frame = new Frame (plateau);
	}

	public Plateau getPlateau() {
		return plateau;
	}


	public Frame getFrame() {
		return frame;
	}
	
	
}