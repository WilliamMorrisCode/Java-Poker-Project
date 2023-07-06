package com.example.williammorrisscenebuilderpractice;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public void receiveHand(ArrayList<Card> hand) {   // allows the player to receive the shuffled hand from the dealer class
        this.hand = hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    /*public int getScore() {
        int playerScore = 0;

        boolean hasAce = false;
        for (Card card : hand) {
            int value = card.getRank().getValue();
            if (value == 1) {
                hasAce = true;
            }
            playerScore += value;
        }
        if (hasAce && playerScore <= 11) {
            playerScore += 10;
        }
        return playerScore;
    }

     public void swapCards(int[] indices, Card[] newCards) {
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (index >= 0 && index < hand.size()) {
                hand.set(index, newCards[i]);
            }
        }
    }*/
}
