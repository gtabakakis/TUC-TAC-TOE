package model;

import control.GameController;



public class GameModel {
	PlayersCatalogue  playerCatalogue;
	String [] gamePlayers;		
	String[][] gameBoard;
	GameController gc;
 
	/* Changes for Lab 08 */
	Boolean mover;
	int moves;
	
	public GameModel(GameController gc) {
		this.gc=gc;
		gamePlayers = new String[2];
		gameBoard= null;
		playerCatalogue= new PlayersCatalogue();
		/* Changes for Lab 08 */
		mover=false;
		moves=0;
		
		
	}
	
	public void selectPlayer(String player, int pos) {
		if (pos<0 && pos>1)return;
		gamePlayers[pos]=player;		
	}
	
	
	public boolean ready() {
		return (gamePlayers[0] != null && gamePlayers[1] !=null);
	}
	
	
	public void startGame() {
		gameBoard= new String[3][3];
		

	}
	
	
	public boolean inPlay() {
		return gameBoard !=null && moves <9;
	}
	
	public boolean NoPlay() {
		return !inPlay();
	}
	
	/* Changes for Lab 08 */
	public int getMover() {
		return mover.compareTo(false);
	}
	
	
	
	
	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public void setMover(Boolean mover) {
		this.mover = mover;
	}

	public String[] getGamePlayers() {
		return gamePlayers;
	}
	

	public String[][] getGameBoard() {
		return gameBoard;
	}
	
	/* Changes for Lab 08 */
	public void checkDimValidity(int row, int col) {
		if (row <0 || col < 0 || row > 2 || col >2) {
			throw new IndexOutOfBoundsException(row + ","+col +" is not a valid board cell");
		}
	}
	
	/* Changes for Lab 08 */
	public void checkMoveValidity(int row, int col) {
		checkDimValidity(row, col);
		if (gameBoard[row][col]!=null) {
			throw new IllegalArgumentException("Non playable cell");
		}
	}
	
	/* Changes for Lab 08 */
	public String getBoardMark(int row, int col) {
		checkDimValidity(row, col);
		return gameBoard[row][col];
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public PlayersCatalogue getPlayerCatalogue() {
		return playerCatalogue;
	}

	public void setPlayerCatalogue(PlayersCatalogue playerCatalogue) {
		this.playerCatalogue = playerCatalogue;
	}
	
	/* Changes for Lab 08 */
	public void makeMoveX(int row, int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col]=getMoverMarkO();
		mover=!mover;
		moves++;
	}
	
	
	public String checkWin() {
		
		if(gameBoard[0][0]!=null && gameBoard[0][1]!=null && gameBoard[0][2]!=null && gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][1].equals(gameBoard[0][2]))
			return gameBoard[0][0];
		if(gameBoard[1][0]!=null && gameBoard[1][1]!=null && gameBoard[1][2]!=null && gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[1][2]))
			return gameBoard[1][0];
		if(gameBoard[2][0]!=null && gameBoard[2][1]!=null && gameBoard[2][2]!=null && gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][1].equals(gameBoard[2][2]))
			return gameBoard[2][0];
		
		
		if(gameBoard[0][0]!=null && gameBoard[1][0]!=null && gameBoard[2][0]!=null && gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[1][0].equals(gameBoard[2][0]))
			return gameBoard[0][0];
		if(gameBoard[0][1]!=null && gameBoard[1][1]!=null && gameBoard[2][1]!=null && gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][1]))
			return gameBoard[0][1];
		if(gameBoard[0][2]!=null && gameBoard[1][2]!=null && gameBoard[2][2]!=null && gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[1][2].equals(gameBoard[3][2]))
			return gameBoard[1][1];
		
		if(gameBoard[0][0]!=null && gameBoard[1][1]!=null && gameBoard[2][2]!=null && gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2]))
			return gameBoard[0][0];
		if(gameBoard[0][2]!=null && gameBoard[1][1]!=null && gameBoard[2][0]!=null && gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0]))
			return gameBoard[1][1];
		
		return null;
	}
	
	/* Changes for Lab 08 */
	public String getMoverMark() {
		return mover? "O": "X";
	}
	
	public String getMoverMarkO() {
		return mover? "O": "X";
	}
	/* Changes for Lab 08 */
	public void makeMoveO(int row, int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col]=getMoverMarkX();
		mover=!mover;
		moves++;
	}
	
	/* Changes for Lab 08 */
	public String getMoverMarkX() {
		return mover? "X": "O";

	}
	
	/* Changes for Lab 08 */
	public String getPlayerStats(String player) {
		StringBuilder sb = new StringBuilder("");
		sb.append(player).append("\n\n\n");
		sb.append("Total:").append("\t").append(4).append("\n");
		sb.append("Won:").append("\t").append("75%").append("\n");
		sb.append("Lost:").append("\t").append("25%").append("\n");
		return sb.toString();			
	}
		
}
