import java.util.Random;
import java.awt.List;
import java.util.LinkedList;
import java.util.ListIterator;    
import java.util.Collections;

public class Deck {

	public LinkedList<Card> cards = new LinkedList<Card>();

	
    public static String[] SUITS = {"c", "d", "h", "s"};
    public static String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    
	public void create(){		
		for (int a = 0; a <= 3; a++){
			for (int b = 0; b <= 12; b++){
				cards.add(new Card(RANKS[b], SUITS[a]));
			}
		}
		Collections.shuffle(cards);
	}
	
	public void dealPlayer(Player player){
		player.card1 = cards.get(0);
		cards.remove(0);

		player.card2 = cards.get(0);
		cards.remove(0);
	}
	
	// DEAL HOLE CARDS
	public void dealAll(LinkedList<Player> players, int numberPlayers){
	for(int i=0;i<numberPlayers;i++){
		this.dealPlayer(players.get(i));
		}
	}
	
	public void dealFlop(Dealer dealer){
		dealer.flop = cards.get(0);
		cards.remove(0);
	}
	
	public void dealTurn(Dealer dealer){
		dealer.turn = cards.get(0);
		cards.remove(0);
	}
	
	public void dealRiver(Dealer dealer){
		dealer.river = cards.get(0);
		cards.remove(0);
	}
	

}