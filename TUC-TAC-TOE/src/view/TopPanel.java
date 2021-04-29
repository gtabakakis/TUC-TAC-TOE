package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;

import javax.swing.border.LineBorder;

import control.GameController;

public class TopPanel extends GamePanel{	
	JButton quitBtn;
	JButton doneBtn;
	JButton addPlayer;
	
	AddPlayer addPlr;
	
	public TopPanel(GameController gc) {
		super(gc);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(MainWindow.WIDTH,MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		
		
		quitBtn = new JButton("Quit App");	
		quitBtn.setPreferredSize(new Dimension(100, 40));
		quitBtn.addActionListener((e)->{this.gc.quit();});		
		
	
		doneBtn = new JButton("Done");		
		doneBtn.setPreferredSize(new Dimension(100, 40));		
		doneBtn.setEnabled(false);
		doneBtn.addActionListener((e)->{System.out.println("done pressed");
		gc.getView().getMainPanel().showCard(MainAreaPanel.HOF);
		doneBtn.setEnabled(false);
		this.gc.getView().getLeftPanel().startGameBtn.setEnabled(true);
		this.gc.getView().getRightPanel().startGameBtn.setEnabled(true);
		});
		

		addPlayer = new JButton("Add Player");	
		addPlayer.setPreferredSize(new Dimension(100, 40));
		addPlayer.addActionListener((e)->{ addPlr = new AddPlayer(gc); });	
		
		String addPlayerText = addPlayer.getText();
		
		add(quitBtn);
		add(doneBtn);
		add(quitBtn);		
		add(addPlayer);					

	}

	public JButton getQuitBtn() {
		return quitBtn;
	}



	public JButton getDoneBtn() {
		return doneBtn;
	}	
	
}
