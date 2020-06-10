package com.ms.deckofcards;

import com.ms.deckofcards.deck.PlayingCardDeck;

/**
 * A basic implementation of dealing and shuffling a deck of playing cards
 */
public class DeckOfCards {

    public static void main (String[] args)
    {
        System.out.println("########################################");
        System.out.println("Dealing deck of playing cards");
        System.out.println("########################################");

        PlayingCardDeck deck = new PlayingCardDeck();
        System.out.println("Created new deck of playing cards");
        System.out.println("State of deck: \n" + deck.toString());

        System.out.println("########################################");
        System.out.println("Shuffling deck");
        System.out.println("########################################");

        deck.shuffle();
        System.out.println("State of deck after shuffling: \n" + deck.toString());

        System.out.println("########################################");
        System.out.println("Deal cards from deck one at a time\n");
        System.out.println("########################################");

        for (int i = 0; i < 52; i++) {
            System.out.println("Dealing one card: " + deck.dealOneCard().toString());
        }

        System.out.println("Deck is now empty. Size of deck: " + deck.getDeck().size());

        // Trying to deal from empty deck will result in an empty deck exception message displayed
        deck.dealOneCard();
    }
}
