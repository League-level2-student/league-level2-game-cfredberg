package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Row5 extends Block {

	public Row5(int row, int column) {
		super(row, column);
		stopPlace = 24;
		checkLeft = 0;
		checkRight = 5;
		color = GamePanelTetris.BLUE;
		checkSmash = new ArrayList<Location>();
		//Continue working on "checkSmash"
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
	
	@Override
	public void checkCollision() {
		if (GamePanelTetris.map[row][column+1] != GamePanelTetris.BACKGROUND) {
			stop();
		}
	}
	
	@Override
	public void mapping() {
		int xd = row;
		int yd = column;
		for (int i = 0; i < 5; i++) {
			GamePanelTetris.map[xd][yd] = color;
			xd++;
		}
	}
}
