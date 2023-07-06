package com.example.williammorrisscenebuilderpractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dealer{
    private ArrayList<Card> deck;

    public Dealer() {
        deck = Card.createDeck();   // dealer constructor calls the Card class's static createDeck method
    }

    public ArrayList<Card> deal(int cards) {           // this method creates a new array, a 5 card hand of shuffled cards
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < cards; i++) {
            hand.add(deck.remove(0));
        }
        return hand;
    }

    public Card deal1Card() {
        Card newCard = deck.remove(0);
        return newCard;
    }

    public void clearDeck(){
        deck.clear();
    }

    public ArrayList<Card> makeNewDeck(){
        deck = Card.createDeck();
        return deck;
    }
}