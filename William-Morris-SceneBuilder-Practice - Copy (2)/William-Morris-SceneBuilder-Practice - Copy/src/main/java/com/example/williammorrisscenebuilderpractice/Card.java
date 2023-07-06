package com.example.williammorrisscenebuilderpractice;

import java.util.ArrayList;
import java.util.Collections;

public class Card {

    enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES };    // uses enums to keep track of suit and rank
    enum Rank { ACE(11), TWO(2), THREE(3), FOUR(4), FIVE(5),
        SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
        final int value;
        private Rank(int value){
            this.value = value;
        }



    };

    public int getValue(){
        return value;
    }

    public final int value;
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;
    }

    public Suit getSuit() {
        return suit;
    }
                            // getters for rank and suit
    public Rank getRank() {
        return rank;
    }

    public boolean hasAce(ArrayList<Card> hand) {
        for (Card card : hand) {
            if (card.getRank() == Card.Rank.ACE) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Card> createDeck() {     // this static method creates a deck of cards
        ArrayList<Card> deck = new ArrayList<Card>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }
}
