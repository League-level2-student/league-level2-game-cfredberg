package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class LBlock extends Block {

	public LBlock(int row, int column) {
		super(row, column);
		stopPlace = 22;
		checkRight = 8;
		checkLeft = 0;
		color = GamePanelTetris.YELLOW;
		checkLefts = new ArrayList<Location>();
		checkRights = new ArrayList<Location>();
		checkBottoms = new ArrayList<Location>();
		checkRights.add(new Location(1,0));
		checkRights.add(new Location(1,1));
		checkRights.add(new Location(2,2));
		checkBottoms.add(new Location(1,3));
		checkBottoms.add(new Location(0,3));
		checkLefts.add(new Location(-1,2));
		checkLefts.add(new Location(-1,1));
		checkLefts.add(new Location(-1,0));
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
	
	public void draw1(Graphics g) {
		int d = 0;
		g.setColor(Color.YELLOW);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(d*BLOCK_WIDTH+x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d++;
			}else {
				g.fillRect((d-1)*BLOCK_WIDTH+x, (-1)*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			}
		}
	}
	
	public void draw2(Graphics g) {
		int d = 0;
		g.setColor(Color.YELLOW);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(x, d*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d--;
			}else {
				g.fillRect(x-BLOCK_WIDTH, (d-1)*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			}
		}
	}
	
	public void draw3(Graphics g) {
		int d = 0;
		g.setColor(Color.YELLOW);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(d*BLOCK_WIDTH+x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d--;
			}else {
				g.fillRect((d-1)*BLOCK_WIDTH+x, BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
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
				GamePanelTetris.map[xd+1][yd-1] = color;
			}
		}
	}
}
