package tetris;

import java.awt.Dimension;

import javax.swing.*;

public class Tetris {
	JFrame frame = new JFrame("Tetris");
	JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		Tetris tet = new Tetris();
		tet.run();
	}
	
	public void run() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(300, 600));
		frame.pack();
		
	}
}
