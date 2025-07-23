package blackjackgame;

import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Player dealer;
    private int roundCounter; // NEW: Track rounds
    private Scanner sc = new Scanner(System.in); // ✅ Scanner moved to class-level

    public void startGame() {
        player = new Player("Player");
        dealer = new Player("Dealer");
        roundCounter = 0;

        // Play 4 rounds
        for (int i = 1; i <= 4; i++) {
            System.out.println("\n=== Round " + i + " ===");
            playRound();
            displayScores();
        }

        // Final result after 4 rounds
        determineWinner();
    }

    // Play one round of Blackjack
    private void playRound() {
        deck = new Deck();
        deck.shuffle();

        // Clear hands for new round
        player.clearHand();
        dealer.clearHand();

        // Initial deal
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        // Show hands
        player.showHand(false);
        dealer.showHand(true);

        // Player's turn
        while (true) {
            System.out.print("Do you want to Hit or Stand? (h/s): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCard(deck.drawCard());
                player.showHand(false);
                if (player.isBust()) {
                    System.out.println("You busted! Dealer wins this round.");
                    dealer.addScore(1); // Dealer gains point
                    return;
                }
            } else {
                break;
            }
        }

        // Dealer's turn
        dealer.showHand(false);
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.drawCard());
            dealer.showHand(false);
        }

        // Determine round winner
        if (dealer.isBust()) {
            System.out.println("Dealer busted! You win this round!");
            player.addScore(1);
        } else {
            int playerScore = player.getScore();
            int dealerScore = dealer.getScore();

            if (playerScore > dealerScore) {
                System.out.println("You win this round!");
                player.addScore(1);
            } else if (playerScore < dealerScore) {
                System.out.println("Dealer wins this round!");
                dealer.addScore(1);
            } else {
                System.out.println("It's a tie!");
            }
        }
    }

    // Show cumulative scores after each round
    private void displayScores() {
        System.out.println("Cumulative Scores -> Player: " + player.getTotalScore() + " | Dealer: " + dealer.getTotalScore());
    }

    // Final winner after all rounds
    private void determineWinner() {
        System.out.println("\n=== FINAL RESULT ===");
        if (player.getTotalScore() > dealer.getTotalScore()) {
            System.out.println("Player is the overall winner!");
        } else if (dealer.getTotalScore() > player.getTotalScore()) {
            System.out.println("Dealer is the overall winner!");
        } else {
            System.out.println("It's an overall tie!");
        }
    }
}
