package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanelTetris extends JPanel implements ActionListener, KeyListener {

	Font header = new Font("Arial", Font.BOLD, 35);
	Font instructions = new Font("Arial", Font.BOLD, 20);
	Font smallInstructions = new Font("Arial", Font.BOLD, 15);
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	final int MENU = 0;
	final int INST = 1;
	final int GAME = 2;
	final int END = 3;
	
	final static int MAGENTA = 0;
	final static int YELLOW = 1;
	final static int GREEN = 2;
	final static int BLUE = 3;
	final static int BLACK = 4;
	final static int PINK = 5;
	final static int CYAN = 6;
	final static int BACKGROUND = 7;
	final static int MAP_END = 8;
	
	Timer frameDraw;
	Timer colisionTimer;
	
	int currentState = MENU;
	
	final int BL = 0;
	final int BLWT = 1;
	final int LB = 2;
	final int LWT = 3;
	final int R5 = 4;
	final int TB = 5;
	final int TBT = 6;
	
	int x = 10;
	int y = 10;
	
	boolean cont = true;
	
	String blockPicker;
	
	Block block;
	
	ArrayList<Block> oldBlocks = new ArrayList<Block>();
	static int[][] map;
	
	public GamePanelTetris() {
		frameDraw = new Timer(1000/3,this);
	    frameDraw.start();
	    
	    randomShapePicker();
	    randomShapeDrawer();
	    randomShapePicker();
	    
	    map = new int[10][26];
	    
	    for (int i = 0; i < map.length; i++) {
	    	for (int j = 0; j < map[0].length; j++) {
	    		map[i][j] = BACKGROUND;
	    	}
	    }
	    
	    for (int i = 0; i < 10; i++) {
	    	map[i][25] = MAP_END;
	    }
	    
	    if (needImage) {
	        loadImage (blockPicker);
	    }
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if (currentState == INST){
			drawInstructionState(g);
		}else if(currentState == GAME){
			drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
	
	public void drawMenuState (Graphics g) {
		g.setColor(new Color(0, 52, 179));
		g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
		
		g.setColor(Color.CYAN);
		g.fillOval(70, 40, 150, 80);
		
		g.setColor(Color.BLACK);
		g.setFont(header);
		g.drawString("TETRIS", 80, 90);
		
		g.setFont(instructions);
		g.drawString("Press 'P' to play.", 65, 300);
		g.drawString("Press 'I' for instructions.", 30, 350);
	}
	
	public void drawInstructionState (Graphics g) {
		g.setColor(new Color(0, 52, 179));
		g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
		
		g.setColor(Color.CYAN);
		g.fillOval(5, 40, 280, 80);
		
		g.setColor(Color.BLACK);
		g.setFont(header);
		g.drawString("INSTRUCTIONS", 15, 90);
		
		g.setFont(smallInstructions);
		g.drawString("Use the left and right arrow keys", 25, 200);
		g.drawString("to move each tile left and right.", 30, 215);
		
		g.setColor(Color.ORANGE);
		g.drawString("Press 'Escape' to go back to the menu.", 0, 560);
	}
	
	public void drawGameState (Graphics g) {
		//Background
		g.setColor(new Color(0, 52, 179));
		g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
		
		for (int i = 0; i < map.length; i++) {
	    	for (int j = 0; j < map[0].length; j++) {
	    		switch (map[i][j]) {
	    		case BACKGROUND:
	    			g.setColor(new Color(0, 52, 179));
	    			break;
	    		case MAGENTA:
	    			g.setColor(Color.MAGENTA);
	    			break;
	    		case YELLOW:
	    			g.setColor(Color.YELLOW);
	    			break;
	    		case GREEN:
	    			g.setColor(Color.GREEN);
	    			break;
	    		case BLUE:
	    			g.setColor(Color.BLUE);
	    			break;
	    		case BLACK:
	    			g.setColor(Color.BLACK);
	    			break;
	    		case PINK:
	    			g.setColor(Color.PINK);
	    			break;
	    		case CYAN:
	    			g.setColor(Color.CYAN);
	    			break;
	    		case MAP_END:
	    			g.setColor(new Color(0,52,179));
	    		}
	    		g.fillRect(calculator(i), calculator(j), 20, 20);
	    	}
	    }
		
		if (block == null) {
			randomShapePicker();
			randomShapeDrawer();
			randomShapePicker();
		}
		
		block.draw(g);
		
		for (int i = 0; i < oldBlocks.size(); i++) {
			oldBlocks.get(i).draw(g);
		}
		
		if (block.isMove == true) {
			block.down();
		}
		
		if (block.isMove == false) {
			block.mapping();
			randomShapeDrawer();
			randomShapePicker();
			needImage = true;
			gotImage = false;
			loadImage(blockPicker);
		}
		
		//Grid
		
		int x1 = x;
		int y1 = y;
		
		g.setColor(Color.CYAN);
		for (int i = 0; i < 25; i++) {
			for (int p = 0; p < 10; p++) {
				g.drawRect(x, y, 20, 20);
				x = x + 20;
			}
			x = x1;
			y = y + 20;
		}
		y = y1;
		
		g.setFont(instructions);
		g.drawString("NEXT:", 220, 90);
		g.drawRect(220, 100, 50, 50);
		
		if (gotImage) {
			g.drawImage(image, 221, 102, 48, 48, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(221, 101, 48, 20);
		}
		
		bottomCollisions();
	}
	
	public void bottomCollisions() {
		for (int i = 0; block != null && i < block.checkBottoms.size(); i++) {
			int xIndex = block.row + block.checkBottoms.get(i).x;
			int yIndex = block.column + block.checkBottoms.get(i).y;
			if (yIndex > block.stopPlace) {
				yIndex = block.stopPlace;
				block.column = block.stopPlace;
				block.stop();
			} else {
				if (map[xIndex][yIndex] != BACKGROUND) {
					if (block.column == 0) {
						block = null;
						currentState = END;
						return;
					}
					block.stop();
				}
			}
		}

	}
	
	public boolean rightCollisions() {
		boolean rightCollisionBool = false;
		if (block.row != block.checkRight) {
			for (int i = 0; i<block.checkRights.size(); i++) {
				if (map[block.row+block.checkRights.get(i).x][block.column+block.checkRights.get(i).y] != BACKGROUND) {
					rightCollisionBool = true;
				}
			}
		}
		return rightCollisionBool;
	}
	
	public boolean leftCollisions() {
		boolean leftCollisionBool = false;
		for (int i = 0; i<block.checkLefts.size(); i++) {
			if (map[block.row+block.checkLefts.get(i).x][block.column+block.checkLefts.get(i).y] != BACKGROUND) {
				leftCollisionBool = true;
			}
		}
		return leftCollisionBool;
	}
	
	public void drawEndState (Graphics g) {
		map = new int[10][26];
		
		for (int i = 0; i < map.length; i++) {
	    	for (int j = 0; j < map[0].length; j++) {
	    		map[i][j] = BACKGROUND;
	    	}
	    }
	    
	    for (int i = 0; i < 10; i++) {
	    	map[i][25] = MAP_END;
	    }
		
		g.setColor(new Color(0, 52, 179));
		g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
	}
	
	public void randomShapePicker() {
		Random rnd = new Random();
		int rndBlock = rnd.nextInt(7);
		if (rndBlock == BL) {
			blockPicker = "BackwardsL.jpg";
		}else if (rndBlock == BLWT) {
			blockPicker = "BackwardsLWithTip.jpg";
		}else if (rndBlock == LB) {
			blockPicker = "LBlock.jpg";
		}else if (rndBlock == LWT) {
			blockPicker = "LWithTip.jpg";
		}else if (rndBlock == R5) {
			blockPicker = "row5.jpg";
		}else if (rndBlock == TB) {
			blockPicker = "TBlock.jpg";
		}else if (rndBlock == TBT) {
			blockPicker = "TwoByTwo.jpg";
		}
	}
	
	public void randomShapeDrawer() {
		if (blockPicker.equals("BackwardsL.jpg")) {
			block = new BackwardsL(4,0);
		}else if (blockPicker.equals("BackwardsLWithTip.jpg")) {
			block = new BackwardsLWithTip(4,0);
		}else if (blockPicker.equals("LBlock.jpg")) {
			block = new LBlock(4,0);
		}else if (blockPicker.equals("LWithTip.jpg")) {
			block = new LWithTip(4,0);
		}else if (blockPicker.equals("row5.jpg")) {
			block = new Row5(4,0);
		}else if (blockPicker.equals("TBlock.jpg")) {
			block = new TBlock(4,0);
		}else if (blockPicker.equals("TwoByTwo.jpg")) {
			block = new TwoByTwo(4,0);
			blockPicker = "TwoByTwo.jpg";
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_I && currentState == MENU) {
			currentState = INST;
		}else if (e.getKeyCode()==KeyEvent.VK_P && currentState == MENU) {
			currentState = GAME;
		}else if (e.getKeyCode()==KeyEvent.VK_ESCAPE && currentState == INST) {
			currentState = MENU;
		}else if (e.getKeyCode()==KeyEvent.VK_M && currentState == END) {
			currentState = MENU;
		}
		
		if (currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				if (block.row > block.checkLeft) {
					if (leftCollisions() == false) {
						block.left();
					}
				}
			}
			
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				if (block.row < block.checkRight) {
					if (rightCollisions() == false) {
						block.right();
					}
				}
			}
			
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				frameDraw.setDelay(10);
			}
			
			if (e.getKeyCode()==KeyEvent.VK_UP) {
				//Rotate object
			}
			
			if (e.getKeyCode()==KeyEvent.VK_SPACE) {
				//block.column = block.stopPlace-1;
				block.column = block.column+block.spaceBar();
				block.stop();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			frameDraw.setDelay(1000/3);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		bottomCollisions();
		repaint();
	}
	
	public int calculator(int RoC) {
		return (RoC + 1) * 20 - 10;
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
