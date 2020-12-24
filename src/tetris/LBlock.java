package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class LBlock extends Block {

	public LBlock(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		int d = 0;
		g.setColor(Color.YELLOW);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(x, d*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d++;
			}else {
				g.fillRect(BLOCK_WIDTH+x, (d-1)*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			}
		}
	}
}
