/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

/**
 *
 * @author patel
 */
import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Player dealer;

    public void startGame() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Player("Dealer");

        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        player.showHand(false);
        dealer.showHand(true);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to Hit or Stand? (h/s): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCard(deck.drawCard());
                player.showHand(false);
                if (player.isBust()) {
                    System.out.println("You busted! Dealer wins.");
                    return;
                }
            } else {
                break;
            }
        }

        dealer.showHand(false);
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.drawCard());
            dealer.showHand(false);
        }

        if (dealer.isBust()) {
            System.out.println("Dealer busted! You win!");
        } else {
            int playerScore = player.getScore();
            int dealerScore = dealer.getScore();

            if (playerScore > dealerScore) {
                System.out.println("You win!");
            } else if (playerScore < dealerScore) {
                System.out.println("Dealer wins!");
            } else {
                System.out.println("It's a tie!");
            }
        }
    }
}
