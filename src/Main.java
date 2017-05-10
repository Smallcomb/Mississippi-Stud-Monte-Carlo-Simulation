import java.lang.Object;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		int totalRounds = 1000;
		
		// MAKE PLAYERS
		final int numberPlayers = 6;
		int buyin = 0;
		int betsize = 1;
		final LinkedList<Player> players = new LinkedList<Player>();

		for(int i=1;i<=numberPlayers;i++){
			players.add(new Player(i, buyin, betsize));
		}
		
		// LOOP STARTS HERE
		for(int i=0; i<totalRounds;i++){
		
		// SETUP
		Deck deck = new Deck();
		deck.create();
		
		Bet bet = new Bet();
		Display display = new Display();
		Outs outs = new Outs();
		Hand hand = new Hand();
	
		// DEALER
		Dealer dealer = new Dealer();
		//display.dealerCards(dealer, numberPlayers);
		
		// STARTING CHIP TOTAL
		//display.chips(players, numberPlayers, dealer);
		
		// PLAYER ANTE BET
		//display.ante(players, numberPlayers, dealer);
		
		// DEAL HOLE CARDS
		deck.dealAll(players, numberPlayers);		
		//display.playerCards(players, numberPlayers);
		
		outs.calcEV(players, numberPlayers, dealer, hand, deck);
		//display.EV(players, numberPlayers, dealer, hand);
		
		// PREFLOP BET
		bet.preflop(players, numberPlayers, dealer, hand, deck);
		//display.flop(players, numberPlayers, dealer);
	
		// DEAL FLOP
		deck.dealFlop(dealer);
		//display.dealerCards(dealer, numberPlayers);
		//display.playerCards(players, numberPlayers);

		// PRETURN BET
		outs.calcEV(players, numberPlayers, dealer, hand, deck);
		//display.EV(players, numberPlayers, dealer, hand);
		bet.preturn(players, numberPlayers, dealer, hand, deck);
		//display.turn(players, numberPlayers, dealer);
		
		// DEAL TURN
		deck.dealTurn(dealer);
		//display.dealerCards(dealer, numberPlayers);
		//display.playerCards(players, numberPlayers);
		
		// PRERIVER BET
		outs.calcEV(players, numberPlayers, dealer, hand, deck);
		//display.EV(players, numberPlayers, dealer, hand);
		bet.preriver(players, numberPlayers, dealer, hand, deck);
		//display.river(players, numberPlayers, dealer);
		
		// DEAL RIVER
		deck.dealRiver(dealer);
		//display.dealerCards(dealer, numberPlayers);
		//display.playerCards(players, numberPlayers);
		
		// PAYOUT
		//display.playerHandRank(players, numberPlayers, dealer, hand);
		//display.playerTotalBet(players, numberPlayers, dealer, hand);		
		bet.payout(players, numberPlayers, dealer, hand, deck);
		display.chips(players, numberPlayers, dealer);
		}
	}
}



