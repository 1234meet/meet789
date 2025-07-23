/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackgame;

/**
 *
 * @author patel
 */
public class Card {
    private String suit;
    private String rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue() {
        if ("JQK".contains(rank)) return 10;
        else if ("A".equals(rank)) return 11;
        else return Integer.parseInt(rank);
    }

    public String getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}

