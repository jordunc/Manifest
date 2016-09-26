
public class Card {
	private int suit;
	private int value;
	
	//Default constructor
	public Card() {
	}
	//Overridden constructor allows forced card
	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	//Getters and setters for suit and value
	
	public String getSuit() {
		switch (suit) {
			case 1: return "S";
			case 2: return "D";
			case 3: return "C";
			case 4: return "H";
		}
		return "";
	}
	
	public int getSuitValue() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getValueString() {
		switch (value) {
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		case 14: return "A";
		}
	return "";
	}
	
	public void setSuit(char suit) {
		switch (suit) {
			case 'S': this.suit = 1;
			case 'D': this.suit = 2;
			case 'C': this.suit = 3;
			case 'H': this.suit = 4;
		}
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//Comparators for suit and value
	
	public int compareSuit(Card card) {
		int compare = card.getSuitValue();
		if(compare == this.getSuitValue())
			return 0;
		else return 1;
	}
	
	public int compareValue(Card card) {
		int compare = card.getValue();
		if(compare == this.getValue())
			return 0;
		else if(compare > this.getValue())
			return 1;
		else
			return -1;
	}
}
