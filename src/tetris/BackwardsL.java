package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BackwardsL extends Block {

	public BackwardsL(int row, int column) {
		super(row, column);
		stopPlace = 22;
		checkRight = 9;
		checkLeft = 1;
		color = GamePanelTetris.CYAN;
		checkSmash = new ArrayList<Location>();
		checkSmash.add(new Location(1,0));
		checkSmash.add(new Location(1,1));
		checkSmash.add(new Location(1,2));
		checkSmash.add(new Location(0,3));
		checkSmash.add(new Location(-1,3));
		checkSmash.add(new Location(-2,2));
		checkSmash.add(new Location(-1,1));
		checkSmash.add(new Location(-1,0));
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
	public void checkCollision() {
		if (GamePanelTetris.map[row][column+1] != GamePanelTetris.BACKGROUND) {
			stop();
		}
	}
	
	@Override
	public void mapping() {
		int xd = row;
		int yd = column;
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				GamePanelTetris.map[xd][yd] = color;
				yd++;
			}else {
				GamePanelTetris.map[xd-1][yd-1] = color;
			}
		}
	}
}
