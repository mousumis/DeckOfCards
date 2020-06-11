package com.ms.deckofcards.deck;

import com.ms.deckofcards.card.Card;
import com.ms.deckofcards.card.playingcard.FaceValue;
import com.ms.deckofcards.card.playingcard.PlayingCard;
import com.ms.deckofcards.card.playingcard.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayingCardDeckTest {

    int deckSize = 52;
    String standardDeckStr;
    static final String STANDARD_DECK_FILE_PATH = "src/test/resources/StandardPlayingCardDeck.txt";

    @Before
    public void setUp() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STANDARD_DECK_FILE_PATH), StandardCharsets.UTF_8);
            standardDeckStr = String.join("\n", lines);
        }
        catch (IOException e) {
            System.err.println("Could not parse text file: " + STANDARD_DECK_FILE_PATH);
            standardDeckStr = "";
        }
    }

    @Test
    public void testDeckCreation() {
        // Test Standard deck creation
        PlayingCardDeck deck = new PlayingCardDeck();

        assertNotNull(deck);
        assertEquals("Check that deck has 52 cards as expected", deck.getDeck().size(), deckSize);
        assertEquals("String representation should be correct", deck.toString(), standardDeckStr);
    }

    @Test
    public void testCardDealing() {
        // Build a standard deck as control group to check against
        List<Card> standardDeck = getStandardDeck();

        // Create new playing card deck
        PlayingCardDeck deck = new PlayingCardDeck();
        deck.shuffle();
        assertEquals("Check that deck has 52 cards as expected", deck.getDeck().size(), deckSize);
        int currentDeckSize = deckSize;

        // Deal cards one at a time and check against standard deck to ensure a unique card is dealt each time
        for (int i = 0; i < deckSize; i++) {
            Card dealtCard = deck.dealOneCard();
            currentDeckSize--;

            assertEquals("Check that deck has expected number of cards", deck.getDeck().size(), currentDeckSize);
            assertTrue("Card being dealt should not have been dealt before", standardDeck.contains(dealtCard));

            //Remove dealt card from standard deck
            standardDeck.remove(dealtCard);
        }

        assertTrue("Deck should be empty", deck.getDeck().isEmpty());
        assertTrue("Standard deck should be empty", standardDeck.isEmpty());
    }

    @Test
    public void testShuffle() {
        PlayingCardDeck deck = new PlayingCardDeck();
        assertEquals("Check that deck has 52 cards as expected", deck.getDeck().size(), deckSize);

        List<PlayingCard> initialDeck = deck.getDeck();
        deck.shuffle();
        List<PlayingCard> shuffledDeck = deck.getDeck();

        // Contents of deck should be the same but order should be different
        assertEquals("Contents of deck should be the same", initialDeck, shuffledDeck);
        assertArrayEquals("Shuffled deck should be different from initial deck", initialDeck.toArray(), shuffledDeck.toArray());

        // Draw cards from deck and verify only remaining cards are shuffled
        deck.dealOneCard();
        deck.dealOneCard();

        assertEquals("Deck should have 50 cards since 2 were removed", deck.getDeck().size(), 50);
        deck.shuffle();
        assertEquals("Deck should have 50 cards after shuffling", deck.getDeck().size(), 50);
    }

    @Test
    public void testMultipleShuffles() {
        PlayingCardDeck deck = new PlayingCardDeck();
        assertEquals("Check that deck has 52 cards as expected", deck.getDeck().size(), deckSize);

        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();

        int currentDeckSize = 52;
        List<Card> standardDeck = getStandardDeck();

        // Deal cards one at a time and check against standard deck to ensure a unique card is dealt each time
        for (int i = 0; i < deckSize; i++) {
            Card dealtCard = deck.dealOneCard();
            currentDeckSize--;

            assertEquals("Check that deck has expected number of cards", deck.getDeck().size(), currentDeckSize);
            assertTrue("Card being dealt should not have been dealt before", standardDeck.contains(dealtCard));

            //Remove dealt card from standard deck
            standardDeck.remove(dealtCard);

            deck.shuffle();
        }

        assertEquals("Deck should have no cards", deck.getDeck().size(), 0);
        assertEquals("Standard deck should have no cards", standardDeck.size(), 0);
    }

    @Test
    public void testEmptyDeck() {
        PlayingCardDeck deck = new PlayingCardDeck();

        // Empty all cards from deck
        for (int i = 0; i < deckSize; i++) {
            deck.dealOneCard();
        }

        // Attempting to draw from an empty deck should return null
        assertNull("Trying to deal from empty deck will not return a card", deck.dealOneCard());

        deck.shuffle();
        assertTrue("Shuffling an empty deck should have no effect", deck.getDeck().isEmpty());

    }

    private List<Card> getStandardDeck() {
        List<Card> standardDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : FaceValue.values()) {
                standardDeck.add(new PlayingCard(suit, faceValue));
            }
        }
        return standardDeck;
    }

}