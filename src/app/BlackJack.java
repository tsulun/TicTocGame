package app;

import java.util.Scanner;

public class BlackJack {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player p1 = new Player(100);
		Player p2 = new Player(100);
		boolean flag = true;
		System.out.println("Welcome to BlackJack");
		System.out.println("You have :"+p1.tokens+" chips");
		while (flag) {
			gameOver(p1);
			System.out.println("Please enter bet amount");
			int bet = sc.nextInt();
			sc.nextLine();
			deal(p1);
			deal(p2);
			comAi(p2);
			printHand(p1);
			printSum(p1);
			while (true) {
				System.out.println("Do you want to pick another one? y/n");
				String k = sc.nextLine();
				if (k.equalsIgnoreCase("y")) {
					hit(p1);
					printHand(p1);
					printSum(p1);
					if (p1.sumCards() > 21) {

						checkDeck(p1, p2,bet);
						System.out.println("pc's hand");
						printHand(p2);
						break;
					}
				} else if (k.equalsIgnoreCase("n")) {
					checkDeck(p1, p2,bet);
					System.out.println("pc's hand");
					printHand(p2);
					break;
				} else {
					System.out.println("invalid input");
				}
			}
			flag = anotherRound(p1, p2);
		}
		sc.close();
	}

	public static boolean anotherRound(Player p1, Player p2) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\ndo you wanna play another round?");
			String l = sc.nextLine();
			if (l.equalsIgnoreCase("y")) {
				flush(p1, p2);
				return true;
			}

			else if (l.equalsIgnoreCase("n")) {
				return false;
			} else {
				System.out.println("invalid input");
				continue;
			}

		}

	}

	public static void flush(Player p1, Player p2) {
		p1.clearDeck();
		p2.clearDeck();
	}

	public static Player deal(Player p) {
		p.addCard();
		p.addCard();
		return p;
	}

	public static void hit(Player p) {
		p.addCard();
	}

	public static void printSum(Player p) {
		System.err.println("your hand's value: " + p.sumCards());
	}

	public static void printHand(Player p) {
		p.printHand();
	}

	public static void checkDeck(Player p1, Player p2, int chip) {
		if (p1.sumCards() > 21 && p2.sumCards() < 21) {
			System.err.println("burst");
			System.err.println("pc won");
			p1.chipDec(chip);
			p2.chipInc(chip);
			printRemainChip(p1);
		} else if (p2.sumCards() > 21 && p1.sumCards() < 21) {
			System.err.println("burst");
			System.err.println("you won");
			p2.chipDec(chip);
			p1.chipInc(chip);
			printRemainChip(p1);
		} else if (p1.sumCards() == 21 && p2.sumCards() != 21) {
			System.err.println("blackjack");
			System.err.println("you won");
			p2.chipDec(chip);
			p1.chipInc(chip);
			printRemainChip(p1);
		} else if (p2.sumCards() == 21 && p1.sumCards() != 21) {
			System.err.println("blackjack");
			System.err.println("Pc won");
			p1.chipDec(chip);
			p2.chipInc(chip);
			printRemainChip(p1);
		} else if (p1.sumCards() > 21 && p2.sumCards() > 21) {
			System.err.println("tie");
			System.err.println("Both burst");
			printRemainChip(p1);
		} else if (p1.sumCards() == p2.sumCards()) {
			System.err.println("tie");
			printRemainChip(p1);
		} else if (p1.sumCards() > p2.sumCards()) {
			System.err.println("you won");
			p2.chipDec(chip);
			p1.chipInc(chip);
			printRemainChip(p1);
		} else if (p2.sumCards() > p1.sumCards()) {
			System.err.println("Pc won");
			p1.chipDec(chip);
			p2.chipInc(chip);
			printRemainChip(p1);
		}
	
	}

	public static void comAi(Player p) {
		while (p.sumCards() < 17)
			p.addCard();
	}

	public static void printRemainChip(Player p) {
		System.out.println("Remaining chip :"+p.tokens);

	}
	public static void gameOver(Player p) {
		if(p.tokens<=0) {
			System.out.println("SORRY, YOU HAVE NO CHIP \n\tGAME OVER");
			System.exit(1);
		}
	}
}
