import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;



public class Hand {
	
	public boolean contains(final int[] array, final int key) {     
	    return ArrayUtils.contains(array, key);
	}
	
	public int check (Card a, Card b, Card c, Card d, Card e){
	
		String[] handRanks = {a.getRank(), b.getRank(), c.getRank(), d.getRank(), e.getRank()};
		
		int[] handValues = new int[]{getValue(a.getRank()), getValue(b.getRank()), getValue(c.getRank()), getValue(d.getRank()), getValue(e.getRank())};
		Arrays.sort(handValues);
		
		// Tally card ranks instances (2, 3, 4...)
		int[] cardMatch = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		for(int i=0; i<handRanks.length; i++){
			switch(handRanks[i]){
			case "A": cardMatch[12]++;
			break;
			case "K": cardMatch[11]++;
			break;
			case "Q": cardMatch[10]++;
			break;
			case "J": cardMatch[9]++;
			break;
			case "T": cardMatch[8]++;
			break;
			case "9": cardMatch[7]++;
			break;
			case "8": cardMatch[6]++;
			break;
			case "7": cardMatch[5]++;
			break;
			case "6": cardMatch[4]++;
			break;
			case "5": cardMatch[3]++;
			break;
			case "4": cardMatch[2]++;
			break;
			case "3": cardMatch[1]++;
			break;
			case "2": cardMatch[0]++;
			break;
			
			default: break;
			}
		}
		
		
		// CHECK cardMatch
		//System.out.println("Card Matches " );
		//for(int i=0; i<cardMatch.length; i++){
		//	System.out.print(cardMatch[i]);
		//}
		//System.out.println();
		
		// QUADS
		if (contains(cardMatch, 4) == true){
			return 40;
		}
		
		// FULL HOUSE
		if (contains(cardMatch, 3) == true && contains(cardMatch, 2) == true){
			return 10;
		}
		
		// TRIPS
		if (contains(cardMatch, 3) == true && contains(cardMatch, 1) == true){
			return 3;
		}
		
		// TWO PAIR
		int paircount = 0;
		for(int n=0; n<cardMatch.length;n++){
			//System.out.print("CHECKING TWOPAIR");
			if (cardMatch[n] == 2){
				paircount++;
				if (paircount == 2){
				return 2;
				}
			}
		}
		
		// PAIR DIFFRENTIATION
		if (contains(cardMatch, 2)){
			
			// PAIR
			if(cardMatch[12] == 2 || cardMatch[11] == 2 || cardMatch[10] == 2 || cardMatch[9] == 2){
			return 1;
			}	
			
			// PUSH
			if(cardMatch[8] == 2 || cardMatch[7] == 2 || cardMatch[6] == 2 || cardMatch[5] == 2 || cardMatch[4] == 2){
			return 0;
			}		
		}
		
		// CHECK FLUSH
		boolean flush = false;
		if(
			a.getSuit() == b.getSuit() &&
			a.getSuit() == c.getSuit() &&	
			a.getSuit() == d.getSuit() &&
			a.getSuit() == e.getSuit()){
			flush = true;
		}
		
		// CHECK STRAIGHT
		boolean straight = true;
		for(int s=0; s<handValues.length-1;s++){
			if (handValues[s] + 1 != handValues[s + 1]) {
				straight = false;
			}
				
			// ACE STRAIGHT
			if (handValues[0] == 2 &&
				handValues[1] == 3 &&
				handValues[2] == 4 &&
				handValues[3] == 5 &&
				handValues[4] == 14) {
				straight = true;
				}				
		}
			
		// STRAIGHT	ONLY
		if (straight == true && flush == false){
			return 4;
		}
			
		// FLUSH ONLY	
		if (straight == false && flush == true){
			return 6;
		}
			
			// STRAIGHTFLUSH
			if(straight == true && flush == true){
			
				// ROYAL FLUSH
				if(handValues[4] == 14){
				return 500;
				}
				
			return 100;			
			}
				
		// ELSE LOSS
		return -1;
	}
	
	public int getValue (String x){
		
		int value = 0;
		
		switch(x){
		case "A": value = 14;
		break;
		case "K": value = 13;
		break;
		case "Q": value = 12;
		break;
		case "J": value = 11;
		break;
		case "T": value = 10;
		break;
		case "9": value = 9;
		break;
		case "8": value = 8;
		break;
		case "7": value = 7;
		break;
		case "6": value = 6;
		break;
		case "5": value = 5;
		break;
		case "4": value = 4;
		break;
		case "3": value = 3;
		break;
		case "2": value = 2;
		break;
		
		case "X": value = 16;
		break;
		case "Y": value = 17;
		break;
		case "Z": value = 18;
		break;
		
		default: value = 9999999; 
			break;
	}
		return value;
	}
	
	// CHECK GAPS
	public int getGap(String[] hand){
		int gapHand[] = new int[]{0, 0, 0};
		for (int i=0;i<hand.length-1;i++){
			gapHand[i] = getValue(hand[i]);
		}
		Arrays.sort(gapHand);
		int gap = 0;
		for (int i=0;i<gapHand.length-1;i++){
			gap = gap + gapHand[i+1] - gapHand[i];
		}
		return gap;
	}
	
	// CHECK FLUSH POTENTIAL
	public boolean getFlush(String[] flushHand){
		boolean flush = true;
		for (int i=0;i<flushHand.length-1;i++){
			if (flushHand[i] != flushHand[i+1]){
				flush = false;
				return flush;
			}
		}
		return flush;
	}
}
