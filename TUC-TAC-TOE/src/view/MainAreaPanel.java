package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import control.GameController;

@SuppressWarnings("serial")


public class MainAreaPanel extends GamePanel{
	public static final String HOF = "HALL_OF_FAME";
	public static final String BOARD = "GAME_BOARD";
		
	HallOfFame hallOfFame;
	GameBoard gameBoard;
	CardLayout cards;
	JPanel playerWon;
	JLabel labelWon;
	
	
	public MainAreaPanel(GameController gc) {
		super(gc);
		
		this.cards= new CardLayout();
		this.setLayout(this.cards);
		this.setPreferredSize(new Dimension(MainWindow.WIDTH - 2 * MainWindow.PLAYER_WIDTH, MainWindow.HEIGHT - MainWindow.TOP_HEIGHT));
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		
		hallOfFame = new HallOfFame(this.gc);
		
		gameBoard = new GameBoard(this.gc);
		
		playerWon = new JPanel();
		
		labelWon = new JLabel();
		
		
		this.add("PLAYER_WON", playerWon);
		playerWon.add(labelWon);

		this.add(HOF,hallOfFame);
		this.add(BOARD,gameBoard);
	}
	
	
	public void showCard(String s) {		
		cards.show(this, s);		
	}





	public GameBoard getGameBoard() {
		return gameBoard;
	}


	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}


	public JPanel getPlayerWon() {
		return playerWon;
	}


	public void setPlayerWon(JPanel playerWon) {
		this.playerWon = playerWon;
	}


	public JLabel getLabelWon() {
		return labelWon;
	}


	public void setLabelWon(JLabel labelWon) {
		this.labelWon = labelWon;
	}
	
	
	
}
