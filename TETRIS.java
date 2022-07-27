// @author Carl Barcenas
// TETRIS recreation for MU Data Structures Class
// 2019

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class TETRIS {
	// GLOBAL VARIABLES
	// Components and Containers:
	static JFrame frame = new JFrame("TETRIS");
	static JPanel fPanel = new JPanel();
	static JPanel gameBoard = new JPanel();
	static JLabel scoreLabel = new JLabel();
	
	// Arrays:
	static Point[][] grid = { // Point array to establish a grid system in gameboard JPanel
			{
				new Point(36, 36), new Point(36, 72), new Point(36, 108), new Point(36, 144), new Point(36, 180), new Point(36, 216), new Point(36, 252), new Point(36, 288), new Point(36, 324), new Point(36, 360), new Point(36, 396), new Point(36, 432), new Point(36, 468), new Point(36, 504), new Point(36, 540), new Point(36, 576), new Point(36, 612), new Point(36, 648), new Point(36, 684), new Point(36, 720), new Point(36, 756), 
				},
				{
				new Point(72, 36), new Point(72, 72), new Point(72, 108), new Point(72, 144), new Point(72, 180), new Point(72, 216), new Point(72, 252), new Point(72, 288), new Point(72, 324), new Point(72, 360), new Point(72, 396), new Point(72, 432), new Point(72, 468), new Point(72, 504), new Point(72, 540), new Point(72, 576), new Point(72, 612), new Point(72, 648), new Point(72, 684), new Point(72, 720), new Point(72, 756), 
				},
				{
				new Point(108, 36), new Point(108, 72), new Point(108, 108), new Point(108, 144), new Point(108, 180), new Point(108, 216), new Point(108, 252), new Point(108, 288), new Point(108, 324), new Point(108, 360), new Point(108, 396), new Point(108, 432), new Point(108, 468), new Point(108, 504), new Point(108, 540), new Point(108, 576), new Point(108, 612), new Point(108, 648), new Point(108, 684), new Point(108, 720), new Point(108, 756), 
				},
				{
				new Point(144, 36), new Point(144, 72), new Point(144, 108), new Point(144, 144), new Point(144, 180), new Point(144, 216), new Point(144, 252), new Point(144, 288), new Point(144, 324), new Point(144, 360), new Point(144, 396), new Point(144, 432), new Point(144, 468), new Point(144, 504), new Point(144, 540), new Point(144, 576), new Point(144, 612), new Point(144, 648), new Point(144, 684), new Point(144, 720), new Point(144, 756), 
				},
				{
				new Point(180, 36), new Point(180, 72), new Point(180, 108), new Point(180, 144), new Point(180, 180), new Point(180, 216), new Point(180, 252), new Point(180, 288), new Point(180, 324), new Point(180, 360), new Point(180, 396), new Point(180, 432), new Point(180, 468), new Point(180, 504), new Point(180, 540), new Point(180, 576), new Point(180, 612), new Point(180, 648), new Point(180, 684), new Point(180, 720), new Point(180, 756), 
				},
				{
				new Point(216, 36), new Point(216, 72), new Point(216, 108), new Point(216, 144), new Point(216, 180), new Point(216, 216), new Point(216, 252), new Point(216, 288), new Point(216, 324), new Point(216, 360), new Point(216, 396), new Point(216, 432), new Point(216, 468), new Point(216, 504), new Point(216, 540), new Point(216, 576), new Point(216, 612), new Point(216, 648), new Point(216, 684), new Point(216, 720), new Point(216, 756), 
				},
				{
				new Point(252, 36), new Point(252, 72), new Point(252, 108), new Point(252, 144), new Point(252, 180), new Point(252, 216), new Point(252, 252), new Point(252, 288), new Point(252, 324), new Point(252, 360), new Point(252, 396), new Point(252, 432), new Point(252, 468), new Point(252, 504), new Point(252, 540), new Point(252, 576), new Point(252, 612), new Point(252, 648), new Point(252, 684), new Point(252, 720), new Point(252, 756), 
				},
				{
				new Point(288, 36), new Point(288, 72), new Point(288, 108), new Point(288, 144), new Point(288, 180), new Point(288, 216), new Point(288, 252), new Point(288, 288), new Point(288, 324), new Point(288, 360), new Point(288, 396), new Point(288, 432), new Point(288, 468), new Point(288, 504), new Point(288, 540), new Point(288, 576), new Point(288, 612), new Point(288, 648), new Point(288, 684), new Point(288, 720), new Point(288, 756), 
				},
				{
				new Point(324, 36), new Point(324, 72), new Point(324, 108), new Point(324, 144), new Point(324, 180), new Point(324, 216), new Point(324, 252), new Point(324, 288), new Point(324, 324), new Point(324, 360), new Point(324, 396), new Point(324, 432), new Point(324, 468), new Point(324, 504), new Point(324, 540), new Point(324, 576), new Point(324, 612), new Point(324, 648), new Point(324, 684), new Point(324, 720), new Point(324, 756), 
				},
				{
				new Point(360, 36), new Point(360, 72), new Point(360, 108), new Point(360, 144), new Point(360, 180), new Point(360, 216), new Point(360, 252), new Point(360, 288), new Point(360, 324), new Point(360, 360), new Point(360, 396), new Point(360, 432), new Point(360, 468), new Point(360, 504), new Point(360, 540), new Point(360, 576), new Point(360, 612), new Point(360, 648), new Point(360, 684), new Point(360, 720), new Point(360, 756), 
				},
				{
				new Point(396, 36), new Point(396, 72), new Point(396, 108), new Point(396, 144), new Point(396, 180), new Point(396, 216), new Point(396, 252), new Point(396, 288), new Point(396, 324), new Point(396, 360), new Point(396, 396), new Point(396, 432), new Point(396, 468), new Point(396, 504), new Point(396, 540), new Point(396, 576), new Point(396, 612), new Point(396, 648), new Point(396, 684), new Point(396, 720), new Point(396, 756), 
				},
				{
				new Point(432, 36), new Point(432, 72), new Point(432, 108), new Point(432, 144), new Point(432, 180), new Point(432, 216), new Point(432, 252), new Point(432, 288), new Point(432, 324), new Point(432, 360), new Point(432, 396), new Point(432, 432), new Point(432, 468), new Point(432, 504), new Point(432, 540), new Point(432, 576), new Point(432, 612), new Point(432, 648), new Point(432, 684), new Point(432, 720), new Point(432, 756), 
				}
	};
	private final static Point[][][] Tetraminos = { // Point array that holds the different shapes
			// I-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
			},
			
			// J-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
			},
			
			// L-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
			},
			
			// O-Piece
			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
			},
			
			// S-Piece
			{
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
			},
			
			// T-Piece
			{
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
			},
			
			// Z-Piece
			{
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
			}
	};
	static boolean[][] isFilled = new boolean[12][21]; // Boolean array that tells which grid is filled
	static final Color[] shapeColor = { // Color array that holds what color the Tetramino is
			Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.PINK, Color.WHITE
			};
	static int currShape; // int that determines the current shape of Tetraminos
	static int rotation; // int that determines the current rotation of Tetraminos
	static Point pieceOrigin; // Point that keeps track of the Tetramino position
	static ArrayList<Integer> nextShapes = new ArrayList<Integer>(); // Array that holds future currShape variables
	static int score = 0;
	static int Speed = 750;
	static int totalClearedRows = 0;
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END VARIABLES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public static void main(String[] args)	{
		configureBoard(); // Configures the board
		
		//------------KEYLISTENER CONTROLS-------------------
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					rotate(1);
					break;
				case KeyEvent.VK_DOWN:
					drop();
					break;
				case KeyEvent.VK_LEFT:
					move(-1);
					break;
				case KeyEvent.VK_RIGHT:
					move(1);
					break;
				} 
			}
			
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		System.out.println("file:\\\\c\\Users\\carlb\\eclipse-workspace\\TetrisV1\\Music\\Tetris");
		PlayMusic("file:/Users/carlb/eclipse-workspace/TetrisV1/Music/Tetris.wav");
		
		//-----------------------------TIMER / RUNNER --------------------
		insertShape(); // Insert first shape
		drawBlock(); // Draw first shape
		
		new Thread() {
			@Override public void run() {
				while (true) {
					try {
						Thread.sleep(Speed);
						drop(); // Drops every timer tick
						updateSpeed(); // Alters speed
						
						
					} catch ( InterruptedException e ) {}
				}
			}
		}.start();
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END MAIN METHOD~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void PlayMusic(String filepath)	{
		try {
			AudioClip clip = Applet.newAudioClip(
				new URL(filepath));
				clip.loop();
			} catch (MalformedURLException murle) {
				System.out.println(murle);
			}
		
	}
	
	// SPEED UPDATE
	// Alters speed for every cleared row
	public static void updateSpeed()	{
		int dSpeed = 0;
		if(Speed - dSpeed >= 201) {
			dSpeed = 25 * totalClearedRows;
			Speed = Speed - dSpeed;
		}
		totalClearedRows=0;
	}
	
	// Checks for a game over
	public static void gameOver()	{
		for(int i = 1; i < 11; i++)	{
			if(isFilled[i][3] == true)	{
				JOptionPane.showMessageDialog(frame, "Game Over");
				
				Speed = 100000;
			}
		}
	}
	
	// First method to run the game; Defines which int currShape is based off of the nextShapes array. 
	// Defines initial pieceOrigin point.
	public static void insertShape()	{
		pieceOrigin = new Point(4, 0);
		rotation = 0;
		
		// Refills nextShapes array with integers
		if (nextShapes.isEmpty()) {
			Collections.addAll(nextShapes, 0, 1, 2, 3, 4, 5, 6);
			Collections.shuffle(nextShapes);
		}
		
		currShape = nextShapes.get(0); // Sets currShape as the next int in nextShapes
		nextShapes.remove(0); // Removes the next int in nextShapes
	}

	// Checks whether the Tetramino will collide from a change in position
	// Returns true if the shape collides and false if otherwise
	public static boolean collisionCheck(int x, int y, int rotation)	{
		for (Point p : Tetraminos[currShape][rotation]) {
			if (isFilled[p.x + x][p.y + y] == true) {
				return true;
			}
		}
		return false;
	}
	
	// Moves the current shape down by 1 row and redraws. Fixes piece to board if it collides
	public static void drop()	{ 
		if (collisionCheck(pieceOrigin.x, pieceOrigin.y + 1, rotation) != true) {
			clearBlock();
			pieceOrigin.y += 1;
			drawBlock();
		} else {
			fixPieceToBoard();
		}		
	}
	
	// Fixes the shape to the board when it reaches the bottom
	public static void fixPieceToBoard()	{
		for (Point p : Tetraminos[currShape][rotation]) {
			// Updates isFilled variable
			isFilled[p.x+pieceOrigin.x][p.y+pieceOrigin.y] = true;
		}
		
		clearRows(); // Checks for cleared rows
		insertShape(); // Inserts a new shape
		gameOver();
	}
	
	// Checks if a row is filled and clears the row if true
	public static void clearRows() {
		boolean gap;
		int numClears = 0;
		
		// Scans each row and checks if there is a single gap between blocks in the row
		for (int j = 19; j > 0; j--) {
			gap = false;
			for (int i = 1; i < 11; i++) {
				if (isFilled[i][j] == false) {
					gap = true;
					break; // Breaks from loop if there is a gap
				}
			}
			if (gap == false) {
				deleteRow(j); // Deletes row if there is no gap and increases j counter by 1 to move down everything
				j += 1;
				numClears += 1; // Increases number of cleared rows
				totalClearedRows += 1;
			}
		}
		
		// Updates the score
		score = score + (numClears * 2);
		scoreLabel.setText("Score: " + score);
	}
		
	// Deletes and redraws the filled row
	public static void deleteRow(int row) {
		// Moves isFilled array down by 1 row
		for (int j = row-1; j > 0; j--) {
			for (int i = 1; i < 11; i++) {
				isFilled[i][j+1] = isFilled[i][j];
			}
		}
		
		// Clears the filled row
		for(int i = 1; i < 11; i++)	{
			gameBoard.getComponentAt(grid[i][row]).setBackground(Color.WHITE);
		}
		
		// Shifts the visual shapes.
		for(int i = 0; i < 11; i++)	{
			for(int j = row-1; j > 0; j--)	{
				Color temp = gameBoard.getComponentAt(grid[i][j]).getBackground();
				gameBoard.getComponentAt(grid[i][j+1]).setBackground(temp);
			}
		}
	}
	
	//-------------------------------DRAWING, MOVEMENT, AND CONFIGURATIONS---------------------------------------
	// Draws the position of the Tetramino
	public static void drawBlock()	{
		for (Point p : Tetraminos[currShape][rotation]) {	
				gameBoard.getComponentAt(grid[p.x + pieceOrigin.x][p.y+pieceOrigin.y]).setBackground(shapeColor[currShape]);
		}
	}

	// Clears the previous position of the Tetramino so that drawBlock can draw the new position.
	public static void clearBlock()	{
		for (Point p : Tetraminos[currShape][rotation]) {
			gameBoard.getComponentAt(grid[p.x + pieceOrigin.x][p.y+pieceOrigin.y]).setBackground(Color.WHITE);
		}
	}
	
	// Checks if a lateral movement is possible, changes the x coordinate of pieceOrigin, and redraws.
	public static void move(int dx)	{
		if (collisionCheck(pieceOrigin.x + dx, pieceOrigin.y, rotation) != true) {
			clearBlock();
			pieceOrigin.x += dx;	
			drawBlock();
		}
	}
	
	// Checks if a rotation is possible, changes the rotation global variable, and redraws.
	public static void rotate(int dr) {
		int newRotation = (rotation + dr) % 4;
		if (collisionCheck(pieceOrigin.x, pieceOrigin.y, newRotation) != true) {
			clearBlock();
			rotation = newRotation;
			drawBlock();
		}
	}
	
	// Configures the board: frame, fPanel, gameBoard, and isFilled array
	public static void configureBoard()	{
		// (1.) Configure Window / Frame-------------
				frame.setSize(1920, 1080);
				frame.setVisible(true);
				frame.setResizable(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBackground(Color.ORANGE);
				
				
				// (2.) Configure Frame Panel----------------
				fPanel.setSize(1920, 1080);
				fPanel.setPreferredSize(new Dimension(1920, 1080));
				fPanel.setBackground(Color.GRAY);
				fPanel.setVisible(true);
				fPanel.setLocation(0,0);
				fPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));
				fPanel.setBorder(BorderFactory.createLoweredBevelBorder());
				// Add to window
				frame.add(fPanel);
				
				// (3.) Configure Game Board----------------
				gameBoard.setPreferredSize(new Dimension(448, 781));		//374, 744));
				gameBoard.setBackground(Color.DARK_GRAY);
				gameBoard.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));
				gameBoard.setBorder(BorderFactory.createLoweredBevelBorder());
				// Set GridBagLayout
				gameBoard.setLayout(new GridBagLayout());
				GridBagConstraints layoutConst = null;
				// Use a for loop for the rows and columns of the grid
				for(int i = 0; i < 12; i++)	{
					for(int j = 0; j < 21; j++)	{
						layoutConst = new GridBagConstraints(); // Redefine layoutConst each run
						layoutConst.gridx = i; // gridx and gridy assigned to appropriate iteration
						layoutConst.gridy = j;
						layoutConst.insets = new Insets(1,1,1,1); // insets allow a spacing of 1 pixel for each block
						
						JPanel gridBlock = new JPanel(); // New JPanel each loop.
						gridBlock.setPreferredSize(new Dimension(35, 35)); // Resize each gridBlock panel
						if(i == 0 || i == 11 || j == 20)	{
							gridBlock.setBackground(Color.BLACK);
						}
						else	{
						gridBlock.setBackground(Color.WHITE); // Color the gridBlock
						}
						gridBlock.setFocusable(true);
						gridBlock.requestFocusInWindow();
						gameBoard.add(gridBlock, layoutConst); // Add to gameBoard following layoutConst.											
					}
				}
				
				for (int i = 0; i < 12; i++) {
					for (int j = 0; j < 21; j++) {
						if (i == 0 || i == 11 || j == 20) {
							isFilled[i][j] = true;
						} else {
							isFilled[i][j] = false;
						}
					}
				}
				
				// Add to Frame Panel
				fPanel.add(gameBoard);
				frame.pack();
				
				//-------------SCORE UPDATE-----------
				scoreLabel.setText("Score: " + score);
				scoreLabel.setForeground(Color.WHITE);
				fPanel.add(scoreLabel);
												
	}
}