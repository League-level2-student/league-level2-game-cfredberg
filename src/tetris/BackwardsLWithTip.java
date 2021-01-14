package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class BackwardsLWithTip extends Block {

	public BackwardsLWithTip(int row, int column) {
		super(row, column);
		stopPlace = 22;
		checkRight = 9;
		checkLeft = 1;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		int xd = 0;
		int yd = 0;
		g.setColor(Color.MAGENTA);
		for (int i = 0; i < 4; i++) {
			g.fillRect(xd*BLOCK_WIDTH+x, yd*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			if (i == 0) {
				yd++;
			}else if (i == 1) {
				xd--;
			}else if (i == 2) {
				yd++;
			}
		}
	}
	
	@Override
	public void checkBottom() {
		if (column == stopPlace) {
			stop();
		}
	}


}
