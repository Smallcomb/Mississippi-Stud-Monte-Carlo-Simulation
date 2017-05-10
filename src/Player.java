public class Player {
	
	public int id;
	
    public Card card1;
    public Card card2;
    public int points;
    
    public double EV = 0;
    
    public int chips;
    public int ante = 0;
    public int flop = 0;
    public int turn = 0;
    public int river = 0;
    public int totalBet = ante + flop + turn + river;

    public Player(int x, int y, int z){
    	this.id = x;
    	this.chips = y;
    	this.ante = z;
    }
    
    public int getTotalBet(){
    	return totalBet;
    }
    	
    public int getChips(){
    	return chips;
    }
    
    public int getAnte(){
    	return ante;
    }
    
    public int getFlop(){
    	return flop;
    }
    
    public int getTurn(){
    	return turn;
    }
    
    public int getRiver(){
    	return river;
    }
    
    public Card getCard1(){
    	return card1;
    }
    	
    public Card getCard2(){
    	return card2;
   	}
    
    //public double getEV(){
    	
    //}
    
    //COUNT POINTS
    public int getPoints(Dealer dealer){

    	points = 0;
    	
    	//PLAYER CARD ONE
		switch(card1.getRank()){
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
		
		// PLAYER CARD TWO
		switch(card2.getRank()){
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
		
		return points + dealer.getPoints();
    }
    
}

