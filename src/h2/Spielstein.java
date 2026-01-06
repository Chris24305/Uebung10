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
		Feld feld = brett.getBrett()[currentRow][currentCol];
		if (currentRow == 0 && feld.getDirection() == 'U') {
			return true;
		}
		if (currentRow + 1 == brett.getDim() && feld.getDirection() == 'D') {
			return true;
		}
		if (currentCol == 0 && feld.getDirection() == 'L') {
			return true;
		}
		if (currentCol + 1 == brett.getDim() && feld.getDirection() == 'R') {
			return true;
		}
		return false;
	}
	
	public void go(int n) {
		
		for (int i = 0; i < n; i++) {
			Feld feld = brett.getBrett()[currentRow][currentCol];
			if (movesOut()) continue;
			if (feld.isBoese()) continue;
			if (feld.getDirection() == 'U') currentRow --;
			if (feld.getDirection() == 'D') currentRow ++;
			if (feld.getDirection() == 'L') currentCol --;
			if (feld.getDirection() == 'R') currentCol ++;
		}
	}
}
