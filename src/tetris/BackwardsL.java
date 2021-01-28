package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class BackwardsL extends Block {

	public BackwardsL(int row, int column) {
		super(row, column);
		stopPlace = 22;
		checkRight = 9;
		checkLeft = 1;
		color = GamePanelTetris.CYAN;
		// TODO Auto-generated constructor stub
	}
	//Main block is top block
	public void draw(Graphics g) {
		int d = 0;
		g.setColor(Color.CYAN);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(x, d*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d++;
			}else {
				g.fillRect(x-BLOCK_WIDTH, (d-1)*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
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
