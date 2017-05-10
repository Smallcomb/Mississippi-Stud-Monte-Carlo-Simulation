
public class Dealer {
	public Card flop = new Card("X", "x");
	public Card turn = new Card("Y", "y");
	public Card river = new Card("Z", "z");
	
	public int chips = 10000;
	
	public int points = 0;
	
	public Dealer(){}
	
	public Card getFlop(){
		return flop;
	}
	
	public Card getTurn(){
		return turn;
	}
	
	public Card getRiver(){
		return river;
	}
	
    //COUNT POINTS
    public int getPoints(){

    	points = 0;
    	
    	//DEALER CARD ONE
		switch(flop.getRank()){
			case "A": points = points+2;
			break;
			case "K": points = points+2;
			break;
			case "Q": points = points+2;
			break;
			case "J": points = points+2;
			break;
			
			case "T": points++;
			break;
			case "9": points++;
			break;
			case "8": points++;
			break;
			case "7": points++;
			break;
			case "6": points++;
			break;
			
			default: break;
		}
		
		// DEALER CARD TWO
		switch(turn.getRank()){
			case "A": points = points+2;
			break;
			case "K": points = points+2;
			break;
			case "Q": points = points+2;
			break;
			case "J": points = points+2;
			break;
		
			case "T": points++;
			break;
			case "9": points++;
			break;
			case "8": points++;
			break;
			case "7": points++;
			break;
			case "6": points++;
			break;
		
		default: break;
		}
		
		// DEALER CARD THREE
				switch(river.getRank()){
					case "A": points = points+2;
					break;
					case "K": points = points+2;
					break;
					case "Q": points = points+2;
					break;
					case "J": points = points+2;
					break;
				
					case "T": points++;
					break;
					case "9": points++;
					break;
					case "8": points++;
					break;
					case "7": points++;
					break;
					case "6": points++;
					break;
				
				default: break;
				}
		
		return points;
    }
}
