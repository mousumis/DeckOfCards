#deckOfCards

deckOfCards is a Java implementation of a deck of cards and provides functionality to:
* Shuffle the deck which randomly permutes cards in the deck
* Deal one card randomly drawn from the deck

This implementation is for a standard deck of playing cards. Support for other types of cards can be added by extending the `Deck` abstract class.

## Prerequisites

This project requires a Java Runtime Environment to run.
Maven is needed is needed for local builds using the provided `pom.xml` configuration

## Build

A `pom.xml` configuration has been provided to build this project in maven:
```
mvn clean package
```
Artifacts will be generated in the `target` folder

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

```java -cp DeckOfCards-1.0-jar-with-dependencies.jar com.ms.deckofcards.DeckOfCards```