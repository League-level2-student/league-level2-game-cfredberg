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
		checkLefts = new ArrayList<Location>();
		checkRights = new ArrayList<Location>();
		checkBottoms = new ArrayList<Location>();
		checkLefts1 = new ArrayList<Location>();
		checkRights1 = new ArrayList<Location>();
		checkBottoms1 = new ArrayList<Location>();
		checkLefts2 = new ArrayList<Location>();
		checkRights2 = new ArrayList<Location>();
		checkBottoms2 = new ArrayList<Location>();
		checkLefts3 = new ArrayList<Location>();
		checkRights3 = new ArrayList<Location>();
		checkBottoms3 = new ArrayList<Location>();
		checkRights.add(new Location(1,0));
		checkRights.add(new Location(1,1));
		checkRights.add(new Location(1,2));
		checkBottoms.add(new Location(0,3));
		checkBottoms.add(new Location(-1,3));
		checkLefts.add(new Location(-2,2));
		checkLefts.add(new Location(-1,1));
		checkLefts.add(new Location(-1,0));
		checkLefts1.add(new Location(-1,0));
		checkLefts1.add(new Location(1,1));
		checkRights1.add(new Location(3,0));
		checkRights1.add(new Location(3,1));
		checkBottoms1.add(new Location(0,1));
		checkBottoms1.add(new Location(1,1));
		checkBottoms1.add(new Location(2,2));
		checkLefts2.add(new Location(-1,-2));
		checkLefts2.add(new Location(-1,-1));
		checkLefts2.add(new Location(-1,0));
		checkBottoms2.add(new Location(0,1));
		checkBottoms2.add(new Location(1,-1));
		checkRights2.add(new Location(2,-2));
		checkRights2.add(new Location(1,-1));
		checkRights2.add(new Location(1,0));
		checkRights3.add(new Location(-1,-1));
		checkRights3.add(new Location(1,0));
		checkBottoms3.add(new Location(-2,1));
		checkBottoms3.add(new Location(-1,1));
		checkBottoms3.add(new Location(0,1));
		checkLefts3.add(new Location(-3,-1));
		checkLefts3.add(new Location(-3,0));
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
	
	public void draw1(Graphics g) {
		int d = 0;
		g.setColor(Color.CYAN);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(d*BLOCK_HEIGHT+x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d++;
			}else {
				g.fillRect((d-1)*BLOCK_WIDTH, y-BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
			}
		}
	}
	
	public void draw2(Graphics g) {
		int d = 0;
		g.setColor(Color.CYAN);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(x, d*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d--;
			}else {
				g.fillRect(x+BLOCK_WIDTH, (d-1)*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			}
		}
	}
	
	public void draw3(Graphics g) {
		int d = 0;
		g.setColor(Color.CYAN);
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				g.fillRect(d*BLOCK_HEIGHT+x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
				d--;
			}else {
				g.fillRect((d-1)*BLOCK_WIDTH, y-BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
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
