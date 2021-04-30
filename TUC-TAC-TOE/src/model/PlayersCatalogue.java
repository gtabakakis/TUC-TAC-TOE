package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import control.GameController;




public class PlayersCatalogue {
	private String[] players;
	
	GameController gc;
	
	public PlayersCatalogue(GameController gc) {
		this.gc = gc;
		players = new String[20];
		players[0]="Vasilis";
		players[1]="Nektarios";
		players[2]="Yannis";
		players[3]="Eleni";		
	}
	
	
	
	
	public void loadPlayers(){
		
		ObjectInputStream is = null;
		FileInputStream fis = null;		
		int pos = 0;
		
		try {
			fis = new FileInputStream("Players.txt");			
			is = new ObjectInputStream(fis);			
			while (fis.available()>0) {				
				String s = (String)is.readObject();				
				this.players[pos++] = s;

			}
			
			System.out.println("Loaded " + numOfPlayers() + " players!");
			System.out.println("............................................");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found for read objects...");
		}finally {
			try {is.close(); fis.close();}catch (Exception e) {
			}
		}
		
		
	}
	
	public void storePlayers() {
		ObjectOutputStream os = null;
		FileOutputStream fos = null;
		           //
		try {
			fos = new FileOutputStream("Players.txt");			
			os = new ObjectOutputStream(fos);
			
			for (String s: players) {
				os.writeObject(s);
			}
			System.out.println("All players stored successfully....");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {			
			e.printStackTrace();
		}finally {
			try {os.close(); fos.close();}catch (Exception e) {
			}
		}
	}
	
	
	
	
	
	public void addPlayer( String player ) {
		for (int i = 0;i<20;i++) {
			if( players[i] ==null ) {			
				this.players[i] = player;
				System.out.println("Player: "+player+" succesfully added!");
				return;
			}
			
		}
		System.out.println("No more Players can be stored!");
		JOptionPane.showMessageDialog(gc.getView(), 						
				"No more Players can be stored!",
				"Ooops...",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
	
	public void delPlayer( String player) {
		
		for (int i = 0;i<numOfPlayers();i++) {
			if( players[i].equals(player) ) {		
				this.players[i] = null;
				while( i < numOfPlayers() ) {
					this.players[i] = this.players[i+1];
					i++;
				}
				System.out.println("Player: "+player+" succesfully deleted!");
				return;
			}
			
		}
		System.out.println("No Player found with name: "+player+"!");
		JOptionPane.showMessageDialog(gc.getView(), 						
				"No Player Found",
				"Ooops...",
				JOptionPane.ERROR_MESSAGE);
		
	}
	
	
	
	
	
	
	public String getPlayer(int i) {
		if (i<0 || i>19) {
			return null;
		}
		return players[i];
	}
	
	
	public String[] getPlayers() {
		String playerCat[] = new String[numOfPlayers()];
		for( int i = 0; i<20; i++) {
			
			if(players[i] != null) {
				playerCat[i] = players[i];
			}
			
		}
		return playerCat;
		
	}
	
	
	public int numOfPlayers() {
		
		int num = 0;
		for(int j=0;j<20;j++) {
			if( players[j] != null ) {
				num++;
			}	
		}
		return num;
	}
	

	
}
