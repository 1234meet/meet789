/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

public class Player {
    private final String name;
    private final Hand hand;
    private int totalScore; // NEW: Track points across rounds

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.totalScore = 0;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.calculateScore();
    }

    public boolean isBust() {
        return getScore() > 21;
    }

    public void showHand(boolean hideFirstCard) {
        System.out.println(name + "'s Hand:");
        hand.displayHand(hideFirstCard);
        if (!hideFirstCard) {
            System.out.println("Score: " + getScore());
        }
    }

    // NEW: Clear hand between rounds
    public void clearHand() {
        hand.clear();
    }

    // NEW: Add and get cumulative score
    public void addScore(int points) {
        totalScore += points;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
