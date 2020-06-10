package com.ms.deckofcards.card.playingcard;

import com.ms.deckofcards.card.Card;

import java.util.Objects;

/**
 * Defines a playing card with suit and face value
 */
public class PlayingCard implements Card {
    private Suit suit;
    private FaceValue faceValue;

    /**
     * Constructor creates an instance of playing card with given suit and value
     *
     * @param suit Suit of card
     * @param faceValue Face value of card
     */
    public PlayingCard(Suit suit, FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    /**
     * Get suit of the card
     *
     * @return Suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Get face value of the card
     *
     * @return Face value
     */
    public FaceValue getFaceValue() {
        return faceValue;
    }

    /**
     * Get a spring representation of the card
     *
     * @return String representing suit and value of the card
     */
    @Override
    public String toString() {
        return faceValue.getValue() + " of " + suit;
    }

    /**
     * Compare this instance of PlayingCard to another for equality
     *
     * @param o Another instance of PlayingCard
     *
     * @return True if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard that = (PlayingCard) o;
        return suit == that.suit && faceValue == that.faceValue;
    }

    /**
     * Get unique identifier for the instance of PlayingCard
     *
     * @return Unique hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(suit, faceValue);
    }
}
