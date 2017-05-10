import java.util.LinkedList;

public class Bet {
	
	// (EV * TOTAL) + BOUND MONEY = OUTCOME > 0 = BET
	
	public void preflop(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand, Deck deck){
		for(int n=0;n<numberPlayers;n++){
			
			int bound = players.get(n).ante;
			
			//System.out.println("MATH 3x: " + (players.get(n).EV*3*players.get(n).ante) + bound);
			//System.out.println("MATH 2x: " + (players.get(n).EV*2*players.get(n).ante) + bound);
			//System.out.println("MATH 1x: " + (players.get(n).EV*1*players.get(n).ante) + bound);
			
			// 3X BET
			//if ((players.get(n).EV)*(bound + 3 * players.get(n).ante) + bound > 0){
			if (players.get(n).EV > 0){
				players.get(n).flop = 3*players.get(n).ante;
			}
			// 1X BET
			else if ((players.get(n).EV*1*players.get(n).ante) + bound > 0){
				players.get(n).flop = players.get(n).ante;
			}
			else
			// FOLD
			{
				players.get(n).flop = 0;
			}
		}
	}
		// (EV * TOTAL) + BOUND MONEY = OUTCOME > 0 = BET
		public void preturn(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand, Deck deck){
			for(int n=0;n<numberPlayers;n++){
				
				int bound = players.get(n).flop + players.get(n).ante;
				
				// PLAYER OUT
				if (players.get(n).flop == 0){
					players.get(n).turn = 0;
				}
				// 3X BET
				//if ((players.get(n).EV)*(bound + 3 * players.get(n).ante) + bound > 0){
				if (players.get(n).EV > 0){
					players.get(n).turn = 3*players.get(n).ante;
				}
				// 1X BET
				else if ((players.get(n).EV*1*players.get(n).ante) + bound > 0){
					players.get(n).turn = players.get(n).ante;
				}
				else
				// FOLD
				{
					players.get(n).turn = 0;
				}
			}
		}
		
		// (EV * TOTAL) + BOUND MONEY = OUTCOME > 0 = BET
		public void preriver(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand, Deck deck){
			for(int n=0;n<numberPlayers;n++){
				
				int bound = players.get(n).turn + players.get(n).flop + players.get(n).ante;
				
				// PLAYER OUT
				if (players.get(n).turn == 0){
					players.get(n).river = 0;
				}
				// 3X BET
				//if ((players.get(n).EV)*(bound + 3 * players.get(n).ante) + bound > 0){
				if (players.get(n).EV > 0){
					players.get(n).river = 3*players.get(n).ante;
				}
				// 1X BET
				else if ((players.get(n).EV*1*players.get(n).ante) + bound > 0){
					players.get(n).river = players.get(n).ante;
				}
				else
				// FOLD
				{
					players.get(n).river = 0;
				}
			}
		}
		
		// PAYOUT
		public void payout(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand, Deck deck){
			for(int n=0;n<numberPlayers;n++){
		
				int total = players.get(n).ante + players.get(n).flop + players.get(n).turn + players.get(n).river;
				int handPay = hand.check(players.get(n).card1, players.get(n).card2, dealer.getFlop(), dealer.getTurn(), dealer.getRiver());
				
			// IF RIVER = 0, AUTOLOSE	
			if (players.get(n).river == 0){
				players.get(n).chips = players.get(n).chips - total;
			}
			else{
				players.get(n).chips = players.get(n).chips + handPay*total;			
			}			
		}
	}
}
