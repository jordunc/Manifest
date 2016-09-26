import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	private int score;
	
	//Default constructor
	public Hand() {
	}
	//Overriden constructor allows a forced hand
	public Hand(Card a, Card b, Card c, Card d, Card e) {
		hand.add(a);
		hand.add(b);
		hand.add(c);
		hand.add(d);
		hand.add(e);
	}
	
	//Returns a string that will show the hand when printed
	public String toString() {
		String s = "";
		for(int i = 0; i<hand.size(); i++)
			s = s + hand.get(i).getSuit() + hand.get(i).getValueString() + " ";
		return s;
	}
	
	//Allows hand.size() in tester class, basically overridden Arraylist.size()
	public int size() {
		return hand.size();
	}
	
	//Getters and setters, can get a card from the Arraylist, the score of the hand,
		//or set the score of the hand
	public Card get(int a) {
		return hand.get(a);
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//These methods help compare the cards in the hand
	
	//Sorts the hand by suit, then checks the suit of the first and last card, returns 0
		//if they're the same suit, 1 if not
	public int compareSuit() {
		sortBySuit();
		if(hand.get(0).getSuitValue() == hand.get(hand.size()-1).getSuitValue())
			return 0;
		else
			return 1;
	}
	
	//Returns the first card with the highest value if 2 have the same
	public int getHighCard() {
		int val = 0;
		for(int i = 0; i<hand.size(); i++) {
			if(hand.get(i).getValue() > val)
				val = hand.get(i).getValue();
		}
		return val;
	}
	
	//Returns the first card with the lowest value if 2 have the same
	public int getLowCard() {
		int val = 15;
		for(int i = 0; i<hand.size(); i++) {
			if(hand.get(i).getValue() < val)
				val = hand.get(i).getValue();
		}
		return val;
	}
	
	//Sorts the hand by suit, lowest value to highest so S, D, C, H
	public void sortBySuit() {
		Card card = new Card();
		for(int i = 0; i<hand.size(); i++) {
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getSuitValue() < hand.get(i).getSuitValue()) {
					card = hand.get(i);
					hand.remove(i);
					hand.add(hand.size(),card);
				}
			}
				
		}
	}
	
	//Sorts the hand by card value ignoring suit, low to high
	public void sortByValue() {
		Card card = new Card();
		for(int i = 0; i<hand.size(); i++) {
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() < hand.get(i).getValue()) {
					card = hand.get(i);
					hand.remove(i);
					hand.add(hand.size(), card);
				}
			}
		}
		
	}
}

