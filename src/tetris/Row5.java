package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Row5 extends Block {

	public Row5(int row, int column) {
		super(row, column);
		stopPlace = 24;
		checkLeft = 0;
		checkRight = 5;
		color = GamePanelTetris.BLUE;
		checkLefts = new ArrayList<Location>();
		checkLefts1 = new ArrayList<Location>();
		checkRights = new ArrayList<Location>();
		checkRights1 = new ArrayList<Location>();
		checkBottoms = new ArrayList<Location>();
		checkBottoms1 = new ArrayList<Location>();
		checkRights.add(new Location(5,0));
		checkBottoms.add(new Location(4,1));
		checkBottoms.add(new Location(3,1));
		checkBottoms.add(new Location(2,1));
		checkBottoms.add(new Location(1,1));
		checkBottoms.add(new Location(0,1));
		checkLefts.add(new Location(-1,0));
		checkLefts1.add(new Location(-1,0));
		checkLefts1.add(new Location(-1,1));
		checkLefts1.add(new Location(-1,2));
		checkLefts1.add(new Location(-1,3));
		checkLefts1.add(new Location(-1,4));
		checkBottoms1.add(new Location(0,5));
		checkRights1.add(new Location(1,0));
		checkRights1.add(new Location(1,1));
		checkRights1.add(new Location(1,2));
		checkRights1.add(new Location(1,3));
		checkRights1.add(new Location(1,4));
		checkLefts2 = new ArrayList<Location>();
		checkLefts3 = new ArrayList<Location>();
		checkRights2 = new ArrayList<Location>();
		checkRights3 = new ArrayList<Location>();
		checkBottoms2 = new ArrayList<Location>();
		checkBottoms3 = new ArrayList<Location>();
		checkRights2.add(new Location(5,0));
		checkBottoms2.add(new Location(4,1));
		checkBottoms2.add(new Location(3,1));
		checkBottoms2.add(new Location(2,1));
		checkBottoms2.add(new Location(1,1));
		checkBottoms2.add(new Location(0,1));
		checkLefts2.add(new Location(-1,0));
		checkLefts3.add(new Location(-1,0));
		checkLefts3.add(new Location(-1,1));
		checkLefts3.add(new Location(-1,2));
		checkLefts3.add(new Location(-1,3));
		checkLefts3.add(new Location(-1,4));
		checkBottoms3.add(new Location(0,5));
		checkRights3.add(new Location(1,0));
		checkRights3.add(new Location(1,1));
		checkRights3.add(new Location(1,2));
		checkRights3.add(new Location(1,3));
		checkRights3.add(new Location(1,4));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		stopPlace = 24;
		checkLeft = 0;
		checkRight = 5;
		int d = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 5; i++) {
			g.fillRect(d*BLOCK_WIDTH+x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
			d++;
		}
	}
	
	@Override
	public void draw1(Graphics g) {
		stopPlace = 20;
		checkLeft = 0;
		checkRight = 9;
		int d = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 5; i++) {
			g.fillRect(x, d*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			d++;
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
	public void mapping() {
		int xd = row;
		int yd = column;
		if (GamePanelTetris.blockState == 0 || GamePanelTetris.blockState == 2) {
			for (int i = 0; i < 5; i++) {
				GamePanelTetris.map[xd][yd] = color;
				xd++;
			}
		}else {
			for (int i = 0; i < 5; i++) {
				GamePanelTetris.map[xd][yd] = color;
				yd--;
			}
		}
	}
	
}
