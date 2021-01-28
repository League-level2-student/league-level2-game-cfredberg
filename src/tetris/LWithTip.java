package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class LWithTip extends Block {

	public LWithTip(int row, int column) {
		super(row, column);
		stopPlace = 22;
		checkRight = 8;
		checkLeft = 0;
		color = GamePanelTetris.GREEN;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		int xd = 0;
		int yd = 0;
		g.setColor(Color.GREEN);
		for (int i = 0; i < 4; i++) {
			g.fillRect(xd*BLOCK_WIDTH+x, yd*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			if (i == 0) {
				yd++;
			}else if (i == 1) {
				xd++;
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

	@Override
	public void mapping() {
		
	}

}
