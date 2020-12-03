package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Row5 extends Block {

	public Row5(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
	}
}
