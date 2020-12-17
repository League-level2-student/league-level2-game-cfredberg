package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanelTetris extends JPanel implements ActionListener, KeyListener {

	Font header = new Font("Arial", Font.BOLD, 35);
	Font instructions = new Font("Arial", Font.BOLD, 20);
	Font smallInstructions = new Font("Arial", Font.BOLD, 15);
	
	final int MENU = 0;
	final int INST = 1;
	final int GAME = 2;
	final int END = 3;
	
	Timer frameDraw;
	
	int currentState = MENU;
	
	int x = 10;
	int y = 10;
	
	Block block = new Block (4, 0);
	
	//Row5 row5 = new Row5(0, 0);
	
	//ObjectManager objm = new ObjectManager(row5);
	
	public GamePanelTetris() {
		frameDraw = new Timer(1000/3,this);
	    frameDraw.start();
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
		g.setColor(new Color(0, 52, 179));
		g.fillRect(0, 0, Tetris.WIDTH, Tetris.HEIGHT);
		
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
		block.draw(g);
		if (block.isMove == true) {
			block.down();
		}
		
		if (block.column == 24) {
			block.stop();
		}
		
		if (block.isMove == false) {
			block = new Row5(4,0);
		}
	}
	
	public void drawEndState (Graphics g) {
		
	}
	
	public void updateGameState() {
		//objm.update();
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
		}
		
		if (currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				block.left();
			}
			
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				block.right();
			}
			
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				block.down();
			}
			
			if (e.getKeyCode()==KeyEvent.VK_UP) {
				//Rotate object
			}
			
			if (e.getKeyCode()==KeyEvent.VK_SPACE) {
				block.column = 23;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == GAME){
		    updateGameState();
		}
		repaint();
	}
	
}
