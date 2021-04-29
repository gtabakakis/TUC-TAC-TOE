package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.GameModel;
import view.MainAreaPanel;
import view.MainWindow;

public class GameController extends WindowAdapter {
	MainWindow view;
	GameModel model;
	
	private int pos;          
	
	public GameController() {		
		
	}
	
	@Override
	public void windowClosing(WindowEvent event) {
		quit();
	}
	
	
	public void start() {
		this.view= new MainWindow(this);
		this.model = new GameModel(this);
		this.view.addWindowListener(this);
		this.view.setVisible(true);
	}
	
	public void quit() {		
		System.out.println("bye bye...");		
		System.exit(0);
	}
	
	
	
	public void selectPlayer(String p, int pos) {
		this.model.selectPlayer(p, pos);	
		System.out.println("Player " + pos + " set to " + p);
		this.view.getLeftPanel().getStartGameBtn().setEnabled(model.ready());
		this.view.getRightPanel().getStartGameBtn().setEnabled(model.ready());		
	}
	
	public void startGame(int pos) {
		
		this.pos = pos;
	    this.model.setGameBoard(new String[3][3]);
		this.view.getLeftPanel().getStartGameBtn().setEnabled(false);
		this.view.getRightPanel().getStartGameBtn().setEnabled(false);
		
		this.view.getTopPanel().getAddPlayer().setEnabled(false);           //
		
		this.view.getMainPanel().showCard(MainAreaPanel.BOARD);
		this.view.getMainPanel().showCard("PLAYER_MOVE");
		this.view.getLeftPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
		this.view.getRightPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());

		this.model.setMoves(0);
	}
	
	
	
	public GameModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}

	public int getPos() {
		return pos;
	}
			
	
}
