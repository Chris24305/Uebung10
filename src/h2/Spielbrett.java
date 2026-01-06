package h2;

public class Spielbrett {
	private Feld[][] brett;
	private int dim;
	
	public Feld[][] getBrett() {
		return this.brett;
	}
	public void setBrett(Feld[][] brett) {
		this.brett = brett;
	}
	
	public int getDim() {
		return this.dim;
	}
	public void setDim(int dim) {
		this.dim = dim;
	}
	
	public Spielbrett(int dim) {
		this.dim = dim;
		this.brett = new Feld[this.dim][this.dim];
	}
}
