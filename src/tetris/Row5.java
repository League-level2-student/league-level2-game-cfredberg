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
		checkRights = new ArrayList<Location>();
		checkBottoms = new ArrayList<Location>();
		checkRights.add(new Location(5,0));
		checkBottoms.add(new Location(4,1));
		checkBottoms.add(new Location(3,1));
		checkBottoms.add(new Location(2,1));
		checkBottoms.add(new Location(1,1));
		checkBottoms.add(new Location(0,1));
		checkLefts.add(new Location(-1,0));
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		int d = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 5; i++) {
			g.fillRect(d*BLOCK_WIDTH+x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
			d++;
		}
	}
	
	public void draw1(Graphics g) {
		int d = 0;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 5; i++) {
			g.fillRect(x, d*BLOCK_HEIGHT+y, BLOCK_WIDTH, BLOCK_HEIGHT);
			d++;
		}
	}
	
	@Override
	public void mapping() {
		int xd = row;
		int yd = column;
		for (int i = 0; i < 5; i++) {
			GamePanelTetris.map[xd][yd] = color;
			xd++;
		}
	}
	
}
