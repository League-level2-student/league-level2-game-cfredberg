package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class LWithTip extends Block {

	public LWithTip(int row, int column) {
		super(row, column);
		stopPlace = 22;
		checkRight = 8;
		checkLeft = 0;
		color = GamePanelTetris.GREEN;
		checkLefts = new ArrayList<Location>();
		checkRights = new ArrayList<Location>();
		checkBottoms = new ArrayList<Location>();
		checkLefts1 = new ArrayList<Location>();
		checkRights1 = new ArrayList<Location>();
		checkBottoms1 = new ArrayList<Location>();
		checkRights.add(new Location(1,0));
		checkRights.add(new Location(2,1));
		checkRights.add(new Location(2,2));
		checkBottoms.add(new Location(1,3));
		checkBottoms.add(new Location(0,2));
		checkLefts.add(new Location(-1,1));
		checkLefts.add(new Location(-1,0));
		checkLefts1.add(new Location(-2,0));
		checkLefts1.add(new Location(-3,1));
		checkBottoms1.add(new Location(-2,2));
		checkBottoms1.add(new Location(-1,2));
		checkBottoms1.add(new Location(0,1));
		checkRights1.add(new Location(1,0));
		checkRights1.add(new Location(0,1));
		checkLefts2 = new ArrayList<Location>();
		checkRights2 = new ArrayList<Location>();
		checkBottoms2 = new ArrayList<Location>();
		checkLefts3 = new ArrayList<Location>();
		checkRights3 = new ArrayList<Location>();
		checkBottoms3 = new ArrayList<Location>();
		checkRights2.add(new Location(1,0));
		checkRights2.add(new Location(2,1));
		checkRights2.add(new Location(2,2));
		checkBottoms2.add(new Location(1,3));
		checkBottoms2.add(new Location(0,2));
		checkLefts2.add(new Location(-1,1));
		checkLefts2.add(new Location(-1,0));
		checkLefts3.add(new Location(-2,0));
		checkLefts3.add(new Location(-3,1));
		checkBottoms3.add(new Location(-2,2));
		checkBottoms3.add(new Location(-1,2));
		checkBottoms3.add(new Location(0,1));
		checkRights3.add(new Location(1,0));
		checkRights3.add(new Location(0,1));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		stopPlace = 22;
		checkRight = 8;
		checkLeft = 0;
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
	public void draw1(Graphics g) {
		stopPlace = 23;
		checkRight = 9;
		checkLeft = 2;
		int xd = 0;
		int yd = 0;
		g.setColor(Color.GREEN);
		for (int i = 0; i < 4; i++) {
			g.fillRect(xd*BLOCK_WIDTH+x, yd*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			if (i == 0) {
				xd--;
			}else if (i == 1) {
				yd++;
			}else if (i == 2) {
				xd--;
			}
		}
	}
	
	@Override
	public void draw2(Graphics g) {
		draw(g);
	}
	
	@Override
	public void draw3(Graphics g) {
		draw1(g);
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
		if (GamePanelTetris.blockState == 0 || GamePanelTetris.blockState == 2) {
			for (int i = 0; i < 4; i++) {
				GamePanelTetris.map[xd][yd] = color;
				if (i == 0) {
					yd++;
				}else if (i == 1) {
					xd++;
				}else if (i == 2) {
					yd++;
				}
			}
		}else {
			for (int i = 0; i < 4; i++) {
				GamePanelTetris.map[xd][yd] = color;
				if (i == 0) {
					xd--;
				}else if (i == 1) {
					yd++;
				}else if (i == 2) {
					xd--;
				}
			}
		}
	}
	
}
