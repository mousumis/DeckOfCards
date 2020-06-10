package com.ms.deckofcards.card.playingcard;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayingCardTest {

    @Test
    public void testCardCreation()
    {
        PlayingCard playingCard = new PlayingCard(Suit.CLUBS, FaceValue.ACE);

        assertNotNull("Playing card should not be null", playingCard);
        assertEquals("Suit should be correctly set", playingCard.getSuit(), Suit.CLUBS);
        assertEquals("Face value should be correctly set", playingCard.getFaceValue(), FaceValue.ACE);
        assertEquals("String representation should be correctly created", playingCard.toString(), "ACE of CLUBS");
    }

    @Test
    public void testCardComparison()
    {
        PlayingCard playingCard1 = new PlayingCard(Suit.HEARTS, FaceValue.TWO);
        PlayingCard playingCard2 = new PlayingCard(Suit.CLUBS, FaceValue.THREE);
        PlayingCard playingCard3 = new PlayingCard(Suit.HEARTS, FaceValue.TWO);
        PlayingCard playingCard4 = null;

        assertEquals("Cards with same suit and face value should be equal", playingCard1, playingCard3);
        assertEquals("Cards with same suit and face value should have the same hashcode", playingCard1.hashCode(), playingCard3.hashCode());

        assertNotEquals("Cards with different suit and face value should not be equal", playingCard1, playingCard2);
        assertNotEquals("Cards with different suit and face value should have different hashcodes", playingCard1.hashCode(), playingCard2.hashCode());

        assertNotEquals("Card should not be equal to a null object", playingCard1, playingCard4);
    }
}