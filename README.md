# DeckOfCards

deckOfCards is a Java implementation of a deck of cards and provides functionality to:
* Shuffle the deck which randomly permutes cards in the deck
* Deal one card randomly drawn from the deck. After the deck is empty, no more cards will be returned.

The following assumptions have been made about expected behavior:
* Duplicate cards are allowed in a deck
* Attempting to draw from an empty deck returns no card. The sample implementation displays a message indicating that the deck is empty when drawing from an empty deck.

The project uses a Template design pattern to define a generic deck of cards. A concrete implementation has been provided for a standard deck of playing cards. Support for other types can be added by defining a new type of `Card` and extending the `Deck` abstract template class.

## Prerequisites

This project requires a Java Runtime Environment to run.
Maven is needed is needed for local builds using the provided `pom.xml` configuration

## Build

A `pom.xml` configuration has been provided to build this project in maven:
```
mvn clean package
```
Artifacts will be generated in a folder named `target`. A pre-built jar is available in the `artifacts` folder

## Unit Tests
Unit tests are written using JUnit 4 and can be run using maven:
```
mvn test
```

## Usage

The main class provides a basic implementation that:
* Builds a new deck of playing cards
* Shuffles the deck
* Deals out all cards in the deck

The following command will run the project using the generated jar. Output will be written to console.

```java -cp DeckOfCards-1.0.jar com.ms.deckofcards.DeckOfCards```
