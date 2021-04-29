package model;

public class PlayersCatalogue {
	private String[] players;
	
	int j = 4;
	
	
	public PlayersCatalogue() {
		players = new String[20];
		players[0]="Vasilis";
		players[1]="Nektarios";
		players[2]="Yannis";
		players[3]="Eleni";		
	}
	
	
	
	
	public void addPlayer( String player ) {
		if( this.j < 20 ) {			
			this.players[j] = player;
			j++;
		}else {
			System.out.println("No more players can be stored!");
		}
		
	}
	
	public String getPlayer(int i) {
		if (i<0 || i>19) {
			return null;
		}
		return players[i];
	}
	
	
	public String[] getPlayers() {
		String playerCat[] = new String[j];
		for( int i = 0; i<j; i++) {
			
			playerCat[i] = players[i];
			
		}
		return playerCat;
		
	}
	

	
}
