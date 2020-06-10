package com.ms.deckofcards.exceptions;

public class EmptyDeckException extends RuntimeException {
    public EmptyDeckException(String errorMessage) {
        super(errorMessage);
    }
}