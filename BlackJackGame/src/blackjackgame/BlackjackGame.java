package blackjackgame;

import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Player dealer;

    public BlackjackGame() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Player("Dealer");
    }

    public void play() {
        System.out.println("=== Welcome to Blackjack ===");

        // Deal 2 cards each
        for (int i = 0; i < 2; i++) {
            player.addCardToHand(deck.dealCard());
            dealer.addCardToHand(deck.dealCard());
        }

        System.out.println("\nYour hand:");
        player.getHand().displayHand();

        System.out.println("\nDealer's visible card:");
        System.out.println(dealer.getHand().getCards().get(0));

        // Player's turn
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to hit or stand? (h/s): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("h")) {
                player.addCardToHand(deck.dealCard());
                System.out.println("\nYour hand:");
                player.getHand().displayHand();
                if (player.getHand().isBust()) {
                    System.out.println("You busted! Dealer wins.");
                    return;
                }
            } else {
                break;
            }
        }

        // Dealer's turn
        System.out.println("\nDealer's hand:");
        dealer.getHand().displayHand();
        while (dealer.getHand().getTotalValue() < 17) {
            System.out.println("Dealer hits.");
            dealer.addCardToHand(deck.dealCard());
            dealer.getHand().displayHand();
            if (dealer.getHand().isBust()) {
                System.out.println("Dealer busted! You win!");
                return;
            }
        }

        // Compare hands
        int playerTotal = player.getHand().getTotalValue();
        int dealerTotal = dealer.getHand().getTotalValue();

        System.out.println("\nFinal Results:");
        System.out.println("Your total: " + playerTotal);
        System.out.println("Dealer total: " + dealerTotal);

        if (playerTotal > dealerTotal) {
            System.out.println("You win!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
