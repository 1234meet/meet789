/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

/**
 *
 * @author patel
 */
import java.util.*;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        int aceCount = 0;

        for (Card card : cards) {
            score += card.getValue();
            if (card.getRank().equals("A")) aceCount++;
        }

        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }

        return score;
    }

    public void showHand(String owner, boolean hideFirst) {
        System.out.println(owner + "'s Hand:");
        for (int i = 0; i < cards.size(); i++) {
            if (i == 0 && hideFirst) {
                System.out.println("[Hidden Card]");
            } else {
                System.out.println(cards.get(i));
            }
        }
        if (!hideFirst) {
            System.out.println("Total: " + getScore());
        }
        System.out.println();
    }

    public boolean isBust() {
        return getScore() > 21;
    }
}
