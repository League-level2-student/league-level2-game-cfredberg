package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class TwoByTwo extends Block {

	public TwoByTwo(int row, int column) {
		super(row, column);
		stopPlace = 23;
		checkRight = 9;
		checkLeft = 1;
		color = GamePanelTetris.PINK;
		checkLefts = new ArrayList<Location>();
		checkRights = new ArrayList<Location>();
		checkBottoms = new ArrayList<Location>();
		checkRights.add(new Location(1,0));
		checkRights.add(new Location(1,1));
		checkBottoms.add(new Location(0,2));
		checkBottoms.add(new Location(-1,2));
		checkLefts.add(new Location(-2,1));
		checkLefts.add(new Location(-2,0));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		int xd = 0;
		int yd = 0;
		g.setColor(Color.PINK);
		g.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
		for (int i = 0; i < 4; i++) {
			g.fillRect(xd*BLOCK_WIDTH+x, yd*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			if (i == 0) {
				yd++;
			}else if (i == 1) {
				xd--;
			}else if (i == 2) {
				yd--;
			}
		}
	}
	
	@Override
	public void draw1(Graphics g) {
		draw(g);
	}
	
	@Override
	public void draw2(Graphics g) {
		draw(g);
	}
	
	@Override
	public void draw3(Graphics g) {
		draw(g);
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
			GamePanelTetris.map[xd][yd] = color;
			if (i == 0) {
				yd++;
			}else if (i == 1) {
				xd--;
			}else if (i == 2) {
				yd--;
			}
		}
	}
}
