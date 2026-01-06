package h2;

public class Spielstein {
	private int currentRow;
	private int currentCol;
	private Spielbrett brett;

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}

	public Spielbrett getBrett() {
		return brett;
	}

	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}

	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		this.currentRow = indexRow;
		this.currentCol = indexCol;
		this.brett = brett;
	}

	private boolean movesOut() {
		if (currentRow == 0) {
			
		}
		
		return false;
	}
}
