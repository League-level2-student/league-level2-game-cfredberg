package tetris;

import java.awt.Graphics;

public class ObjectManager {
	Row5 row5;
	
	public ObjectManager(Row5 row5) {
		this.row5 = row5;
	}
	
	public void draw(Graphics g) {
		row5.draw(g);
	}
	
	public void update() {
		
	}
}
