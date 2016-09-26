
public class HandTester {
	public static void main(String[] args) {
		
		//this creates 2 hands and then scores them
			//Feel free to test the inputs
			//It is assumed the input is valid (1,2,3,4) for suit or (2-14) for value
			//The hand does not check for duplicates, user is expected to provide valid input
		Card card1 = new Card(1, 2);
		Card card2 = new Card(2, 10);
		Card card3 = new Card(3, 11);
		Card card4 = new Card(4, 13);
		Card card5 = new Card(1, 14);
		
		Hand hand = new Hand(card1, card2, card3, card4, card5);
		
		check(hand);
		checkForPair(hand);
		checkFor2Pair(hand);
		checkFor3(hand);
		checkForStraight(hand);
		checkForFullHouse(hand);
		checkForFlush(hand);
		checkFor4(hand);
		checkForStraightFlush(hand);
		
		Card card6 = new Card(1, 10);
		Card card7 = new Card(2, 10);
		Card card8 = new Card(3, 11);
		Card card9 = new Card(4, 13);
		Card card10 = new Card(1, 14);
		
		Hand hand2 = new Hand(card6, card7, card8, card9, card10);
		
		check(hand2);
		checkForPair(hand2);
		checkFor2Pair(hand2);
		checkFor3(hand2);
		checkForStraight(hand2);
		checkForFullHouse(hand2);
		checkForFlush(hand2);
		checkFor4(hand2);
		checkForStraightFlush(hand2);
		
		System.out.println("Hand1: " + hand.toString() + "\nHand2: " + hand2.toString());
		
		//This compares the scores and tells you which hand won
		if(hand.getScore() > hand2.getScore())
			System.out.println("Hand 1 wins!");
		else if(hand2.getScore() > hand.getScore())
			System.out.println("Hand 2 wins!");
		else if(hand.getScore() == hand2.getScore())
			System.out.println("It's a tie!");
	}
	
	//Checks for a straight flush and sets score if found
	public static void checkForStraightFlush(Hand hand) {
		//Checks if all cards have same suit
		hand.sortBySuit();
		if(hand.compareSuit() == 0)
			//Checks if flush is straight or not
			if(hand.getHighCard() - hand.getLowCard() == 4)
				hand.setScore(120 + hand.getHighCard());
	}
	
	//Checks for 4 of a kind and sets score if found
	public static void checkFor4(Hand hand) {
		int streak = 0;
		int val = 0;
		for(int i = 0; i<hand.size(); i++) {
			val = hand.get(i).getValue();
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() == val)
					streak++;
				//Checks for 4 of a kind
				if(streak == 3) {
					i = hand.size()+1;
					j = hand.size() +1;
					hand.setScore(105 + val);
				}
				else if(j == hand.size() -1)
					streak = 0;
			}
		}
	}
	
	//Checks for a full house and sets score if found
	public static void checkForFullHouse(Hand hand) {
		int streak = 0;
		int val = 0;
		for(int i = 0; i<hand.size(); i++) {
			val = hand.get(i).getValue();
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() == val)
					streak++;
				//Checks for 3 of a kind
				if(streak == 2) {
					i = hand.size()+1;
					j = hand.size() +1;
				}
				else if(j == hand.size() -1)
					streak = 0;
			}
		}
		int streak2 = 0;
		int val2 = 0;
		for(int i = 0; i<hand.size(); i++) {
			val2 = hand.get(i).getValue();
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() == val2 && val != val2)
					streak2++;
				//Checks for a pair
				if(streak2 > 0 ) {
					i = hand.size()+1;
					j = hand.size() +1;
				}
				else if(j == hand.size() -1)
					streak2 = 0;
			}
		}
		if(streak == 2 && streak2 > 0)
			hand.setScore(90 + val);
	}
	
	//Checks for a flush and sets score if found
	public static void checkForFlush(Hand hand) {
		//Checks if all cards have same suit
		hand.sortBySuit();
		if(hand.compareSuit() == 0)
			hand.setScore(75 + hand.getHighCard());
	}
	
	//Checks for a straight and sets score if found
	public static void checkForStraight(Hand hand) {
		hand.sortByValue();
		boolean same = false;
		for(int i = 0; i<hand.size()-1; i++) {
			int j = i + 1;
			if(hand.get(i).getValue() == hand.get(j).getValue()) {
				same = true;
				i = hand.size();
			}
		}
		if(same == false && hand.getHighCard() - hand.getLowCard() == 4)
			hand.setScore(60 + hand.getHighCard());
	}
	
	//Checks for 3 of a kind and sets score if found
	public static void checkFor3(Hand hand) {
		int streak = 0;
		int val = 0;
		for(int i = 0; i<hand.size(); i++) {
			val = hand.get(i).getValue();
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() == val)
					streak++;
				//Checks for 3 of a kind
				if(streak == 2) {
					i = hand.size()+1;
					j = hand.size() +1;
				}
				else if(j == hand.size() -1)
					streak = 0;
			}
		}
		if(streak == 2)
			hand.setScore(45 + val);
	}
	
	//Checks for 2 pair and sets score if found
	public static void checkFor2Pair(Hand hand) {
		int streak = 0;
		int val = 0;
		for(int i = 0; i<hand.size(); i++) {
			val = hand.get(i).getValue();
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() == val)
					streak++;
				//Checks for a pair
				if(streak > 0) {
					i = hand.size()+1;
					j = hand.size() +1;
				}
				else if(j == hand.size() -1)
					streak = 0;
			}
		}
		int streak2 = 0;
		int val2 = 0;
		for(int i = 0; i<hand.size(); i++) {
			val2 = hand.get(i).getValue();
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() == val2 && val != val2)
					streak2++;
				//Checks for a pair
				if(streak2 > 0 ) {
					i = hand.size()+1;
					j = hand.size() +1;
				}
				else if(j == hand.size() -1)
					streak2 = 0;
			}
		}
		if(streak > 0 && streak2 > 0)
			if(val > val2)
				hand.setScore(30 + val);
			else
				hand.setScore(30 + val2);
	}
	
	//Checks for a pair and sets score if found
	public static void checkForPair(Hand hand) {
		int streak = 0;
		int val = 0;
		for(int i = 0; i<hand.size(); i++) {
			val = hand.get(i).getValue();
			for(int j = i+1; j<hand.size(); j++) {
				if(hand.get(j).getValue() == val)
					streak++;
				//Checks for a pair
				if(streak > 0) {
					i = hand.size()+1;
					j = hand.size() +1;
				}
				else if(j == hand.size() -1)
					streak = 0;
			}
		}
		if(streak > 0)
			hand.setScore(15 + val);
	}
	
	//Sets score to that of the highest card
	public static void check(Hand hand) {
		hand.setScore(hand.getHighCard());
	}
}