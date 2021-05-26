package app;

import java.util.*;
import java.util.Random;

public class Player {
	
	ArrayList<Card> deck= new ArrayList<>();
	int tokens;
	Cards_52 test=new Cards_52();
	Random r=new Random();
	
public Player(int tokens) {
		this.tokens = tokens;
	}
public void chipInc(int i) {
	tokens+=i;
}
public void chipDec(int i) {
	tokens-=i;
}

public void addCard(){
	deck.add(test.hit());
}
public void clearDeck(){
	
	deck.clear();;
}
public void printHand() {
	for(Card a:deck) {
		System.out.print("["+a.getSuit()+"-"+a.getNumber()+"] ");
	}
}

public String getCardNumber() {
	return deck.get(0).getNumber();
}
public String getCardSuit() {
	return deck.get(0).getSuit();
}
public int sumCards(){
	int sum=0;
	boolean flag=false;
	for(Card i :deck) {
		if(i.getNumber().equals("Ace")) {
			flag=true;
			sum+=11;
			}
		else
		sum+=Integer.parseInt(i.getNumber());
	}
	if(sum>21&&flag) {
		sum-=10;
	}
	return sum;
}

}
