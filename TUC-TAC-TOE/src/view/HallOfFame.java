package view;


import java.awt.Graphics;



import control.GameController;

@SuppressWarnings({"serial", "unused"})


public class HallOfFame extends GamePanel{
private GameController gc;
	
	public HallOfFame(GameController gc) {
		super(gc);
		this.gc=gc;
	}
	
	@Override
	public void paintComponent(Graphics g)   {  
	      super.paintComponent(g);
	      int x = this.getWidth()/2 - 50;
			int y = this.getHeight()/2;		
			g.drawString("Hall Of Fame", x, y);
	      
	}

}
