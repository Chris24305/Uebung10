package h1;

public class Grid {
	
	private Cell[][] gridArray;
	
	public Cell[][] getGridArray() {
		return this.gridArray;
	}
	public void setGridArray(Cell[][] a) {
		this.gridArray = a;
	}
	
	public Grid(Cell[] cells, int gridRows, int gridCols) {
		this.gridArray = new Cell[gridRows][gridCols];
		
		row: for (int i = 0; i < gridRows; i++ ) {
		col:	for (int j = 0; j < gridCols; j++ ) {
					for (Cell cellIsAlive : cells) {
						if ((cellIsAlive.getIndexRow() == i) && (cellIsAlive.getIndexCol() == j)) {
							Cell cell = new Cell(i, j, true);
							gridArray[i][j] = cell;
							continue col;
						}
					}
				Cell cell = new Cell(i, j);
				gridArray[i][j] = cell;
			}
		}
		
		 for (int i = 0; i < gridRows; i++ ) {
			for (int j = 0; j < gridCols; j++ ) {
				Cell cell;
				cell = gridArray[i][j];
				cell.countLivingNeighbors(gridArray);
			}
		}	
	}
	
	public void computeNextGen () {
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray.length; j++) {
				gridArray[i][j].setAlive(gridArray[i][j].getIsAliveNextGen());
			}
		}
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray.length; j++) {
				gridArray[i][j].countLivingNeighbors(gridArray);
			}
		}
	}
	
	public void computeGeneration (int n) {
		for (int i = 0; i<n; i++) {
			computeNextGen();
		}
	}
}
