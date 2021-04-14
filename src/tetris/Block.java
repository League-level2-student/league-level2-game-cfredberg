package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;



public class Block {
	final int BLOCK_WIDTH = 20;
	final int BLOCK_HEIGHT = 20;
	
	int x;
	int y;
	
	int row;
	int column;
	int stopPlace;
	int checkLeft;
	int checkRight;
	int color;
	int jumpD;
	
	ArrayList<Location> checkLefts;
	ArrayList<Location> checkRights;
	ArrayList<Location> checkBottoms;
	ArrayList<Location> checkLefts1;
	ArrayList<Location> checkRights1;
	ArrayList<Location> checkBottoms1;
	ArrayList<Location> checkLefts2;
	ArrayList<Location> checkRights2;
	ArrayList<Location> checkBottoms2;
	ArrayList<Location> checkLefts3;
	ArrayList<Location> checkRights3;
	ArrayList<Location> checkBottoms3;
	
	boolean isMove = true;
	public Block(int row, int column) {
		this.row = row;
		this.column = column;
		x = calculator(row);
		y = calculator(column);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
	}
	
	public void update() {
		
	}
	
	public void stop() {
		isMove = false;
	}
	
	public void checkBottom() {
		
	}
	
	public void checkCollision() {
		
	}
	
	public void down() {
		column = column + 1;
		y = calculator(column);
	}
	
	public void left() {
		row = row - 1;
		x = calculator(row);
	}
	
	public void right() {
		row = row + 1;
		x = calculator(row);
	}
	
	public int calculator(int RoC) {
		return (RoC + 1) * 20 - 10;
	}
	
	public void mapping() {
		
	}
	
	public int spaceBar() {
		jumpD = 0;
		while(true) {
			for (int i = 0; i<checkBottoms.size(); i++) {
				if (GamePanelTetris.map[row+checkBottoms.get(i).x][column+checkBottoms.get(i).y+jumpD] != GamePanelTetris.BACKGROUND) {
					return jumpD;
				}
			}
			jumpD++;
		}
	}
}
