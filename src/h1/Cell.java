package h1;

public class Cell {
	private int indexRow;
	private int indexCol;
	private int numLivingNeighbors;
	private boolean alive;
	private boolean isAliveNextGen;

	// Getter
	public int getIndexRow() {
		return this.indexRow;
	}

	public int getIndexCol() {
		return this.indexCol;
	}

	public int getNumLivingNeighbors() {
		return this.numLivingNeighbors;
	}

	public boolean getAlive() {
		return this.alive;
	}

	public boolean getIsAliveNextGen() {
		return this.isAliveNextGen;
	}

	// Setter
	public void setIndexRow(int a) {
		this.indexRow = a;
	}

	public void setIndexCol(int a) {
		this.indexCol = a;
	}

	public void setNumLivingNeighbors(int a) {
		this.numLivingNeighbors = a;
	}

	public void setAlive(boolean a) {
		this.alive = a;
	}

	public void setIsAliveNextGen(boolean a) {
		this.isAliveNextGen = a;
	}

	// Contructor
	public Cell(int indexRow, int indexCol, boolean alive) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;
		this.alive = alive;
	}

	public Cell(int indexRow, int indexCol) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;
	}

	public void countLivingNeighbors(Cell[][] gridArray) {
		int numLivingNeighbors = 0;
		if (this.indexRow - 1 >= 0) {
			if (this.indexCol - 1 >= 0) {
				if (gridArray[indexRow - 1][indexCol - 1].getAlive()) {
					numLivingNeighbors++;
				}
			}
			if (this.indexCol + 1 < gridArray[0].length) {
				if (gridArray[indexRow - 1][indexCol + 1].getAlive()) {
					numLivingNeighbors++;
				}
			}
			if (gridArray[this.indexRow - 1][this.indexCol].getAlive()) {
				numLivingNeighbors++;
			}
		}

		if (this.indexRow + 1 < gridArray.length ) {
			if (this.indexCol - 1 >= 0) {
				if (gridArray[indexRow + 1][indexCol - 1].getAlive()) {
					numLivingNeighbors++;
				}
			}
			if (this.indexCol + 1 < gridArray[0].length) {
				if (gridArray[indexRow + 1][indexCol + 1].getAlive()) {
					numLivingNeighbors++;
				}
			}
			if (gridArray[this.indexRow + 1][this.indexCol].getAlive()) {
				numLivingNeighbors++;
			}
		}

		if (this.indexCol - 1 >= 0) {
			if (gridArray[this.indexRow][this.indexCol - 1].getAlive()) {
				numLivingNeighbors++;
			}
		}
		if (this.indexCol + 1 < gridArray[0].length) {
			if (gridArray[this.indexRow][this.indexCol + 1].getAlive()) {
				numLivingNeighbors++;
			}
		}
		this.numLivingNeighbors = numLivingNeighbors;
		decideNextStatus();
	}
	
	private void decideNextStatus () {
		if (this.alive) {
			if (this.numLivingNeighbors !=2 && this.numLivingNeighbors != 3) {
				isAliveNextGen = false;
			} else {
				isAliveNextGen = true;
			}
		} else {
			if (this.numLivingNeighbors == 3) {
				isAliveNextGen = true;
			} else {
				isAliveNextGen = false;
			}
		}
	}
}
