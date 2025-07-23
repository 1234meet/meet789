/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import blackjackgame.Card;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int score = 0;
        int aceCount = 0;

        for (Card card : cards) {
            score += card.getValue();
            if (card.getRank().equals("Ace")) aceCount++;
        }

        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
        return score;
    }

    public void displayHand(boolean hideFirstCard) {
        for (int i = 0; i < cards.size(); i++) {
            if (i == 0 && hideFirstCard) {
                System.out.println("[Hidden Card]");
            } else {
                System.out.println(cards.get(i));
            }
        }
    }

    public void clear() {
        cards.clear();
    }
}