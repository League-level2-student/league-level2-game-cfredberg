package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Row5 extends Block {

	public Row5(int row, int column) {
		super(row, column);
		stopPlace = 24;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		int d = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 5; i++) {
			g.fillRect(d*BLOCK_WIDTH+x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
			d++;
		}
	}
	
	@Override
	public void checkBottom() {
		if (column == stopPlace) {
			stop();
		}
	}

}
