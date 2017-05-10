import java.util.LinkedList;

public class Points {

	//3 Cards

	//Raise 3x with any made hand (mid pair or higher).
	//Raise 3x with royal flush draw.
	//Raise 3x with straight flush draw, with no gaps, 567 or higher.
	//Raise 3x with straight flush draw, with one gap, and at least one high card.
	//Raise 3x with straight flush draw, with two gaps, and at least two high cards.
	//Raise 1x with any other three suited cards.
	//Raise 1x with a low pair.
	//Raise 1x with at least three points.
	//Raise 1x with a straight draw, with no gaps, 456 or higher.
	//Raise 1x with a straight draw, with one gap, and two mid cards.
	//Fold all others.



	
	// PLAYER BET DECISION - POINT
	public void bet(LinkedList<Player> players, int numberPlayers, int betsize, Dealer dealer, Hand hand, int pointsNeeded){
		for(int i=0;i<numberPlayers;i++){
			
			int playerBet = betsize;
			
			// NO CARDS
			if (pointsNeeded == 0){
				playerBet = betsize;
				players.get(i).ante = playerBet;
			}
			
			// 2 Cards
			if (pointsNeeded == 2){	
					
				// Raise 3x with ANY pair.
				if (
					players.get(i).card1.getRank() == players.get(i).card2.getRank() || 
					players.get(i).card1.getRank() == dealer.flop.getRank() || 
					players.get(i).card2.getRank() == dealer.flop.getRank() ||
					players.get(i).card1.getRank() == dealer.turn.getRank() || 
					players.get(i).card2.getRank() == dealer.turn.getRank() ||
					dealer.flop.getRank() == dealer.turn.getRank()){
					playerBet = 3*betsize;
					
				// Raise 1x with at least two points.
				}else if (players.get(i).getPoints(dealer) >= pointsNeeded){
					playerBet = betsize;
					
				// Raise 1x with 6/5 suited.
				}else if (
					((players.get(i).card1.getRank() == "6" && players.get(i).card2.getRank() == "5") || 
					(players.get(i).card1.getRank() == "5" && players.get(i).card2.getRank() == "6")) &&
					players.get(i).card1.getSuit() == players.get(i).card2.getSuit()){
					playerBet = betsize;
					
				// Fold all others.
				}else{
					playerBet = 0;
				}
				
			players.get(i).flop = playerBet;	
			}
			
			//3 Cards
			if (pointsNeeded == 3){
			
				//Raise 3x with any made hand (mid pair or higher).
				if (hand.check (players.get(i).getCard1(), players.get(i).getCard2(), dealer.getFlop(), dealer.getTurn(), dealer.getRiver()) <= 1){
					playerBet = 3*betsize;
				}
						
						
				//Raise 3x with royal flush draw.
				
				//Raise 3x with straight flush draw, with no gaps, 567 or higher.
				
				//Raise 3x with straight flush draw, with one gap, and at least one high card.
				
				//Raise 3x with straight flush draw, with two gaps, and at least two high cards.
				
				//Raise 1x with any other three suited cards.
				
				//Raise 1x with a low pair.
				
				//Raise 1x with at least three points.
				
				// FIND GAPS
				String gapHand[] = {players.get(i).card1.getRank(), players.get(i).card2.getRank(), dealer.getFlop().getRank()};
				int gap = hand.getGap(gapHand);
				
				// FIND FLUSH
				String flushHand[] = {players.get(i).card1.getSuit(), players.get(i).card2.getSuit(), dealer.getFlop().getSuit()};
				boolean flush = hand.getFlush(flushHand);
				
				//Raise 1x with a straight draw, with no gaps, 456 or higher.
				
				//Raise 1x with a straight draw, with one gap, and two mid cards.
				
				//Fold all others.
			
				players.get(i).turn = playerBet;
			}
			
			if (pointsNeeded == 4){
				//4 Cards

				//Raise 3x with any made hand (mid pair or higher).
				//Raise 3x with any four to a flush.
				//Raise 3x with four to an outside straight, 8 high or better.
				//Raise 1x with any other straight draw.
				//Raise 1x with a low pair.
				//Raise 1x with at least four points.
				//Raise 1x with three mid cards and at least one previous 3x raise.
				//Fold all others.
				
				players.get(i).river = playerBet;
			}
			
			players.get(i).chips = players.get(i).chips - playerBet;
		}
	}
	
}
