package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.GameController;

public class TopPanel extends GamePanel{	
	JButton quitBtn;
	JButton startGameBtn;
	JButton doneBtn;
	
	public TopPanel(GameController gc) {
		super(gc);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(MainWindow.WIDTH,MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		quitBtn = new JButton("Quit App");	
		quitBtn.setPreferredSize(new Dimension(100, 40));
		quitBtn.addActionListener((e)->{this.gc.quit();});		
		
		startGameBtn = new JButton("Start Game");
		startGameBtn.setPreferredSize(new Dimension(100, 40));
		startGameBtn.setEnabled(false);
		startGameBtn.addActionListener((e)->{this.gc.startGame();});
		
		doneBtn = new JButton("Done");		
		doneBtn.setPreferredSize(new Dimension(100, 40));		
		doneBtn.setEnabled(false);
		doneBtn.addActionListener((e)->{System.out.println("done pressed");});
		
		add(startGameBtn);
		add(doneBtn);
		add(quitBtn);					
	}

	public JButton getQuitBtn() {
		return quitBtn;
	}

	public JButton getStartBtn() {
		return startGameBtn;
	}
	

	public JButton getDoneBtn() {
		return doneBtn;
	}	
	
}
