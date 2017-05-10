import java.text.DecimalFormat;
import java.util.LinkedList;

public class Display {
	
	public Display(){}
	
	// DISPLAY DEALER CARDS
	public void dealerCards(Dealer dealer, int numberPlayers){
		System.out.println();
		System.out.print("DEALER: ");
		for(int i=0;i<numberPlayers;i++){
			System.out.print(dealer.flop.getBoth() + dealer.turn.getBoth() + dealer.river.getBoth());
			System.out.print(" | ");
		}
	}
	
	// DISPLAY PLAYER CARDS
	public void playerCards(LinkedList<Player> players, int numberPlayers){
		System.out.println();
		System.out.print("PLAYER: ");
		for(int i=0;i<numberPlayers;i++){
				System.out.print(players.get(i).card1.getBoth() + players.get(i).card2.getBoth() + "  " + " | ");				
		}
	}
	
	// DISPLAY PLAYER POINTS
	public void points(LinkedList<Player> players, int numberPlayers, Dealer dealer){
		System.out.println();
		System.out.print("POINTS: ");
		for(int i=0;i<numberPlayers;i++){
			System.out.print(players.get(i).getPoints(dealer) + "     " + " | ");
		}
	}
	
	// DISPLAY PLAYER EV
	public void EV(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand){
		System.out.println();
		System.out.print("EV    : ");
		
		for(int i=0;i<numberPlayers;i++){
			System.out.print(new DecimalFormat("#.###").format(players.get(i).EV));
			if (players.get(i).EV >= 0){
			System.out.print(" ");
			}
			System.out.print(" | ");
		}
	}
	
	// DISPLAY PLAYER HAND RANK
	public void playerHandRank(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand){
		System.out.println();
		System.out.print("HANDVL: ");
		
		for(int i=0;i<numberPlayers;i++){
			System.out.print(hand.check(players.get(i).card1, players.get(i).card2, dealer.getFlop(), dealer.getTurn(), dealer.getRiver()) + "    ");
			if (hand.check(players.get(i).card1, players.get(i).card2, dealer.getFlop(), dealer.getTurn(), dealer.getRiver()) >= 0){
			System.out.print(" ");
			}
			System.out.print(" | ");
		}
	}
	
	// DISPLAY PLAYER CHIPS
	public void chips(LinkedList<Player> players, int numberPlayers, Dealer dealer){
		System.out.println();
		System.out.print("CHIPS : ");
		for(int i=0;i<numberPlayers;i++){
			System.out.print(players.get(i).getChips());
			
			if(players.get(i).getChips() >= 0){
				System.out.print(" ");
			}
			//if(Math.abs(players.get(i).getChips()) < 100000){
			//	System.out.print(" ");
			//}
			if(Math.abs(players.get(i).getChips()) < 10000){
				System.out.print(" ");
			}
			if(Math.abs(players.get(i).getChips()) < 1000){
				System.out.print(" ");
			}
			if(Math.abs(players.get(i).getChips()) < 100){
				System.out.print(" ");
			}
			if(Math.abs(players.get(i).getChips()) < 10){
				System.out.print(" ");
			}
			System.out.print(" | ");
		}
	}
	
	// DISPLAY PLAYER ANTE BET
	public void ante(LinkedList<Player> players, int numberPlayers, Dealer dealer){
		System.out.println();
		System.out.print("ANTE  : ");
		for(int i=0;i<numberPlayers;i++){
			System.out.print(players.get(i).getAnte() + "    " + " | ");
		}
	}
	
	// DISPLAY PLAYER FLOP BET
	public void flop(LinkedList<Player> players, int numberPlayers, Dealer dealer){
		System.out.println();
		System.out.print("FLOP  : ");
		for(int i=0;i<numberPlayers;i++){
			System.out.print(players.get(i).getFlop() + "    ");
			if(players.get(i).getFlop() == 0){
				System.out.print(" ");
			}
			System.out.print(" | ");
		}
	}
	
	// DISPLAY PLAYER TURN BET
	public void turn(LinkedList<Player> players, int numberPlayers, Dealer dealer){
		System.out.println();
		System.out.print("TURN  : ");
		for(int i=0;i<numberPlayers;i++){
			System.out.print(players.get(i).getTurn() + "    ");
			if(players.get(i).getTurn() == 0){
				System.out.print(" ");
			}
			System.out.print(" | ");
		}
	}
	
	// DISPLAY PLAYER RIVER BET
	public void river(LinkedList<Player> players, int numberPlayers, Dealer dealer){
		
		System.out.println();
		System.out.print("RIVER : ");
		
		for(int i=0;i<numberPlayers;i++){
			System.out.print(players.get(i).getRiver() + "    ");
			if(players.get(i).getRiver() == 0){
				System.out.print(" ");
			}
			System.out.print(" | ");
		}
	}
	
	// DISPLAY PLAYER TOTAL BET
	public void playerTotalBet(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand){
		System.out.println();
		System.out.print("TOTBET: ");
		
		for(int i=0;i<numberPlayers;i++){
			System.out.print(
					players.get(i).getAnte()+
					players.get(i).getFlop()+
					players.get(i).getTurn()+
					players.get(i).getRiver());
			if (players.get(i).getAnte()+players.get(i).getFlop()+players.get(i).getTurn()+players.get(i).getRiver() < 100){
				System.out.print(" ");
			}
			System.out.print("    | ");
		}
	}
		
}
