package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class BackwardsL extends Block {

	public BackwardsL(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
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

}
