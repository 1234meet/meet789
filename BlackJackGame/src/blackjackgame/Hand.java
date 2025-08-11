package blackjackgame;

import java.util.*;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotalValue() {
        int total = 0;
        int aceCount = 0;
        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public void displayHand() {
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println("Total: " + getTotalValue());
    }

    public boolean isBust() {
        return getTotalValue() > 21;
    }

    public List<Card> getCards() {
        return cards;
    }
}
