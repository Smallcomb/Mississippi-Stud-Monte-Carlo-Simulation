import java.util.LinkedList;


public class Outs {
	
	public void calcEV(LinkedList<Player> players, int numberPlayers, Dealer dealer, Hand hand, Deck deck){
		
		for(int n=0;n<numberPlayers;n++){
		double numberHands = 0;
		
		Card flop = dealer.flop;
		Card turn = dealer.turn;
		Card river = dealer.river;
		
		// TOTAL SUM OF WINS AND LOSSES
		int sumFlop = 0; 
		int sumTurn = 0;
		int sumRiver = 0;
		int sumResults = 0;
		
		double loss = 0, push = 0, pair = 0, twopair = 0, trips = 0, straight = 0, flush = 0, fullhouse = 0, quads = 0, straightflush = 0, royal = 0;

		// ALL RUNOUT COMBINATIONS
		// HOLE CARDS
		int result = hand.check(players.get(n).card1, players.get(n).card2, flop, turn, river);
		int hypFlop = players.get(n).ante;
		if (result > 0){
			hypFlop = 3*players.get(n).ante;
		}
		
		// FLOP
		for(int i=0; i<deck.cards.size(); i++){
		//for(int i=0; i<1; i++){
			if(dealer.flop.getRank() == "X"){
				flop = deck.cards.get(i);
			}
			//System.out.println("hypFLOP: " + flop.getBoth());
		result = hand.check(players.get(n).card1, players.get(n).card2, flop, turn, river);
		int hypTurn = players.get(n).ante;
		if (result > 0){
			hypTurn = 3*players.get(n).ante;			
		}	
			//TURN
			for(int j=0; j<deck.cards.size(); j++){
			//for(int j=0; j<2; j++){
				if (deck.cards.get(j) != flop){
					if(dealer.turn.getRank() == "Y"){
						turn = deck.cards.get(j);
					}
					//System.out.println("hypTURN: " + turn.getBoth());
				result = hand.check(players.get(n).card1, players.get(n).card2, flop, turn, river);
				int hypRiver = players.get(n).ante;
				if (result > 0){
					hypRiver = 3*players.get(n).ante;
				}
				// RIVER
				for(int k=0; k<deck.cards.size(); k++){
				//for(int k=0; k<4; k++){
					if (deck.cards.get(k) != turn && deck.cards.get(k) != flop){
						if(dealer.river.getRank() == "Z"){
							river = deck.cards.get(k);
						}
					//System.out.println("hypRIVER: " + river.getBoth());
					result = hand.check(players.get(n).card1, players.get(n).card2, flop, turn, river);
					
					numberHands++;
					//System.out.println("#HAND: " + numberHands);
					//System.out.println("RESULT: " + result);
					
					int hypTotal = players.get(n).ante + hypFlop + hypTurn + hypRiver;
					
					sumFlop =  + sumFlop +(result*(hypFlop+players.get(n).ante));
					sumTurn = sumTurn +(result*(hypTurn+hypFlop+players.get(n).ante));
					sumRiver = sumRiver +(result*(hypFlop+hypRiver+hypTurn+players.get(n).ante));
					
					
					switch(result){
					case -1: loss++;
					break;
					case 0: push++;
					break;
					case 1: pair++;
					break;
					case 2: twopair++;
					break;
					case 3: trips++;
					break;
					case 4: straight++;
					break;
					case 6: flush++;
					break;
					case 10: fullhouse++;
					break;
					case 40: quads++;
					break;
					case 100: straightflush++;
					break;
					case 500: royal++;
					break;
					default: break;					
							}
					
						}					
					}
				}
			}
		}
	//System.out.println();
	//System.out.println();
	//System.out.println("LOSS: " + loss);
	//System.out.println("PUSH: " + push);
	//System.out.println("PAIR: " + pair);
	//System.out.println("TWOPAIR: " + twopair);
	//System.out.println("TRIPS: " + trips);
	//System.out.println("STRAIGHT: " + straight);
	//System.out.println("FLUSH: " + flush);
	//System.out.println("QUADS: " + quads);
	//System.out.println("FULLHOUSE: " + fullhouse);
	//System.out.println("STRAIGHTFLUSH: " + straightflush);
	//System.out.println("ROYAL: " + royal);
		
	//System.out.println();
	//System.out.println("SUM RESULTS: " + sumResults);
	//System.out.println("AVG FLOP RETURN: " + sumFlop/numberHands);
	//System.out.println("AVG TURN RETURN: " + sumTurn/numberHands);
	//System.out.println("AVG RIVER RETURN: " + sumRiver/numberHands);
	
	double lossProb = loss / numberHands;
	double pushProb = push / numberHands;
	double pairProb = pair / numberHands;
	double twopairProb = twopair / numberHands;
	double tripsProb = trips / numberHands;
	double straightProb = straight / numberHands;
	double flushProb = flush / numberHands;
	double fullhouseProb = fullhouse / numberHands;
	double quadsProb = quads / numberHands;
	double straightflushProb = straightflush / numberHands;
	double royalProb = royal / numberHands;
	
	double EV = lossProb*-1 +
			pushProb*0 +
			pairProb*1 +
			twopairProb*2 +
			tripsProb*3 +
			straightProb*4 +
			flushProb*6 +
			fullhouseProb*10 +
			quadsProb*40 +
			straightflushProb*100 +
			royalProb*500;
	
	players.get(n).EV = EV;
	
	//System.out.println("EV: " + EV);
	
	//System.out.println("LOSSPROB: " + lossProb);
	//System.out.println("PUSHPROB: " + pushProb);
	//System.out.println("PAIRPROB: " + pairProb);
	//System.out.println("TWOPAIRPROB: " + twopairProb);
	//System.out.println("TRIPSPROB: " + tripsProb);
	//System.out.println("STRAIGHTPROB: " + straightProb);
	//System.out.println("FLUSHPROB: " + flushProb);
	//System.out.println("FULLHOUSEPROB: " + fullhouseProb);
	//System.out.println("QUADSPROB: " + quadsProb);
	//System.out.println("STRAIGHTFLUSHPROB: " + straightflushProb);
	//System.out.println("ROYALPROB: " + royalProb);
	
	double avgOutcome =
	lossProb*-1*players.get(n).totalBet +
	pushProb*0*players.get(n).totalBet +
	pairProb*1*players.get(n).totalBet +
	twopairProb*2*players.get(n).totalBet +
	tripsProb*3*players.get(n).totalBet +
	straightProb*4*players.get(n).totalBet +
	flushProb*6*players.get(n).totalBet +
	fullhouseProb*10*players.get(n).totalBet +
	quadsProb*40*players.get(n).totalBet +
	straightflushProb*100*players.get(n).totalBet +
	royalProb*500*players.get(n).totalBet;
	
	//System.out.println("AVG OUTCOME: " + avgOutcome);
	
	
	//int lossPay = -1*players.get(n).totalBet*loss;
	//int pushPay = 0*players.get(n).totalBet*push;
	//int pairPay = 1*players.get(n).totalBet*pair;
	//int twopairPay = 2*players.get(n).totalBet*twopair;
	//int tripsPay = 3*players.get(n).totalBet*trips;
	//int straightPay = 4*players.get(n).totalBet*straight;
	//int flushPay = 6*players.get(n).totalBet*flush;
	//int fullhousePay = 10*players.get(n).totalBet*fullhouse;
	//int quadsPay = 40*players.get(n).totalBet*quads;
	//int straightflushPay = 100*players.get(n).totalBet*straightflush;
	//int royalPay = 500*players.get(n).totalBet*royal;
	
	//int totalPay = lossPay + pushPay + pairPay + twopairPay + tripsPay + straightPay + flushPay + fullhousePay + quadsPay + straightflushPay + royalPay;

	//System.out.println("LOSS: $" + lossPay);
	//System.out.println("PUSH: $" + pushPay);
	//System.out.println("PAIR: $" + pairPay);
	//System.out.println("TWOPAIR: $" + twopairPay);
	//System.out.println("TRIPS: $" + tripsPay);
	//System.out.println("STRAIGHT: $" + straightPay);
	//System.out.println("FLUSH: $" + flushPay);
	//System.out.println("FULLHOUSE: $" + fullhousePay);
	//System.out.println("QUADS: $" + quadsPay);
	//System.out.println("STRAIGHTFLUSH: $" + straightflushPay);
	//System.out.println("ROYAL: $" + royalPay);
	//System.out.println("TOTAL: $" + totalPay);
	//System.out.println("AVG HAND: $" + totalPay/numberHands);
	//System.out.println();
		}
	}
}
