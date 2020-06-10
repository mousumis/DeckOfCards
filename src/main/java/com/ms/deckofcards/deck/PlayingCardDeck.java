package com.ms.deckofcards.deck;

import com.ms.deckofcards.card.playingcard.FaceValue;
import com.ms.deckofcards.card.playingcard.Suit;
import com.ms.deckofcards.card.playingcard.PlayingCard;

import java.util.ArrayList;
import java.util.List;

/**
 * An extension of the abstract Deck class for Playing Cards.
 */
public class PlayingCardDeck extends Deck<PlayingCard> {
    private static final int DEFAULT_DECK_SIZE = 52;

    /**
     * Constructor builds a deck with given initial size
     *
     * @param deckSize initial size of deck
     */
    public PlayingCardDeck(int deckSize) {
        super(deckSize);
    }

    /**
     * Builds a standard deck of playing cards
     */
    public PlayingCardDeck() {
        this(DEFAULT_DECK_SIZE);
    }

    /**
     * Deal a new deck of cards
     * @param deckSize initial size of deck
     *
     * @return Deck of playing cards
     */
    List<PlayingCard> dealNewDeck(int deckSize) {
        List<PlayingCard> deck = new ArrayList<>(deckSize);
        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : FaceValue.values()) {
                deck.add(new PlayingCard(suit, faceValue));
            }
        }
        return deck;
    }

}
