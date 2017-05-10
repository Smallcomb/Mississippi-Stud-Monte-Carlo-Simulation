
public class Card {
	
	public String rank;
	public String suit;

	
	public Card(String rank, String suit){
		this.rank = rank;
		this.suit = suit;
	}
    
	public String getBoth(){
		String both = rank + suit;
		return both;
	}
	
	public String getRank(){
		return rank;
	}
	
	public String getSuit(){
		return suit;
	}
}
