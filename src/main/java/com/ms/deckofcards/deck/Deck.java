package com.ms.deckofcards.deck;

import com.ms.deckofcards.card.Card;

import java.util.List;
import java.util.Random;

/**
 * An abstract class that defines a deck of cards.
 * Classes extending this should provide an implementation of how to deal the deck of cards.
 *
 * @param <T> The type of card
 */
public abstract class Deck<T extends Card> {
    private List<T> deck;
    private Random random;

    /**
     * Constructor defines a new deck of given size
     *
     * @param deckSize Initial size of deck
     */
    public Deck(int deckSize) {
        random = new Random();
        deck = dealNewDeck(deckSize);
    }

    /**
     * Randomly shuffle cards in the deck
     */
    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int randomPosition = random.nextInt(deck.size());
            swap(i, randomPosition);
        }
    }

    /**
     * Deal one card from the deck and return the card
     *
     * @return Card removed from deck to be dealt out
     */
    public Card dealOneCard() {
        if (deck == null) {
            throw new NullPointerException("Deck is not initialized");
        }
        if (!deck.isEmpty()) {
            int randomIndex = random.nextInt(deck.size());
            Card cardRemoved = deck.get(randomIndex);
            deck.remove(randomIndex);
            return cardRemoved;
        }
        else {
            return null;
        }
    }

    /**
     * Getter for the deck of cards
     *
     * @return Deck of cards
     */
    public List<T> getDeck() {
        return deck;
    }

    /**
     * Get a string representation of the deck
     *
     * @return String with contents of deck
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Deck {\n");
        for (T card : deck) {
            sb.append(card.toString()).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }

    /**
     * Abstract method to define how to deal a deck. Classes extending Deck must provide an implementation
     *
     * @param deckSize initial size of dec
     *
     * @return A new deck of cards
     */
    abstract List<T> dealNewDeck(int deckSize);

    /**
     * Helper method to swap cards in two positions in the deck
     *
     * @param pos1 index 1
     * @param pos2 index 2
     */
    private void swap(int pos1, int pos2) {
        T card = deck.get(pos1);
        deck.set(pos1, deck.get(pos2));
        deck.set(pos2, card);
    }
}
