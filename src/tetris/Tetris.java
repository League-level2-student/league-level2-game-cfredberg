package tetris;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Tetris {
	JFrame frame = new JFrame("Tetris");
	GamePanelTetris panel = new GamePanelTetris();
	final static int WIDTH = 300;
	final static int HEIGHT = 600;
	ImageIcon logo = new ImageIcon("src/tetris/logo.jpg");
	
	public static void main(String[] args) {
		Tetris tet = new Tetris();
		tet.run();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(logo.getImage());
		frame.add(panel);
		
		frame.pack();
	}
}
