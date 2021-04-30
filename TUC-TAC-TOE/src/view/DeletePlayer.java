package view;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.GameController;

	
	@SuppressWarnings("serial")

	public class DeletePlayer extends JFrame {
		
		private JButton delBtn;
		private JTextField text;
		
		
		private GameController gc;
		
		public  DeletePlayer( GameController gc ) {
			
			this.gc = gc;
			this.setSize(325, 100);
			this.setTitle("Delete Player");
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			
			panel.add(new Label("Enter Player's Name:"));
			text = new JTextField(15);
			panel.add(text);
			
			delBtn = new JButton("Delete");
			delBtn.addActionListener((e)->{ this.delFunc(); });
			delBtn.addActionListener((e)->{ this.dispose(); });
			
			panel.add(delBtn);
			
			this.add(panel);
			
			this.setVisible(true);
			
			this.setLocationRelativeTo(null);
			
			
			
		}
		
		public void delFunc() {
			
			gc.getModel().getPlayerCatalogue().delPlayer(text.getText());
		
		}
		
		
	}

