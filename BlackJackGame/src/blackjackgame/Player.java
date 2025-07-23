/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

/**
 *
 * @author patel
 */
public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.getScore();
    }

    public void showHand(boolean hideFirst) {
        hand.showHand(name, hideFirst);
    }

    public boolean isBust() {
        return hand.isBust();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
}
