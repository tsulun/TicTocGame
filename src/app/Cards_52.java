package app;

import java.util.ArrayList;
import java.util.Collections;

public class Cards_52 {
	String[] suits= {"Spades","Hearts","Clubs","Diamonds"};
	String[]numbers= {"Ace","2","3","4","5","6","7","8","9","10"};
	ArrayList<Card> deck=new ArrayList<>();
public void createDeck() {	
	for(String suit:suits) {
		for(String number:numbers)
			deck.add(new Card(suit,number));
	}
}

public void shuffle() {
	Collections.shuffle(deck);
}
public Card hit() {
	createDeck();
	shuffle();
	return deck.get(0);
}


}