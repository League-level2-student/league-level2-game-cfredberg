package tetris;

public class Block {
	final int BLOCK_WIDTH = 20;
	final int BLOCK_HEIGHT = 20;
	
	int x;
	int y;
	
	int row;
	int column;
	public Block(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void update() {
		
	}
	
	public void down() {
		column = column - 1;
		y = calculator(column);
	}
	
	public void left() {
		row = row - 1;
		x = calculator(row);
	}
	
	public void right() {
		row = row + 1;
		x = calculator(row);
	}
	
	public int calculator(int RoC) {
		return (RoC + 1) * 20 - 10;
	}
}
