package com.ms.deckofcards.card.playingcard;

/**
 * Possible face values for a playing card
 */
public enum FaceValue {
    ACE ("ACE"),
    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    TEN ("10"),
    JACK ("JACK"),
    QUEEN ("QUEEN"),
    KING ("KING");

    private final String value;

    private FaceValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
