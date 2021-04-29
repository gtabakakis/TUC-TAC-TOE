package view;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


import control.GameController;

@SuppressWarnings("serial")

public class AddPlayer extends JFrame {
	
	private JButton enterBtn;
	private JTextField text;
	
	
	private GameController gc;
	
	public  AddPlayer( GameController gc ) {
		
		this.gc = gc;
		this.setSize(325, 100);
		this.setTitle("Add Player");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		panel.add(new Label("Enter Player's Name:"));
		text = new JTextField(15);
		panel.add(text);
		
		enterBtn = new JButton("Enter");
		enterBtn.addActionListener((e)->{ this.addFunc(); });
		enterBtn.addActionListener((e)->{ this.dispose(); });
		
		panel.add(enterBtn);
		
		this.add(panel);
		
		this.setVisible(true);
		
		this.setLocationRelativeTo(null);
		
		
		
	}
	
	public void addFunc() {
		
		gc.getModel().getPlayerCatalogue().addPlayer(text.getText());
	
	}
	
	
	

	
}
