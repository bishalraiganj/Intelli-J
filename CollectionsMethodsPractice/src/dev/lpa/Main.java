package dev.lpa;

import dev.lpa.games.poker.PokerGame;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.sort(deck, Comparator.comparing(Card::rank).reversed().thenComparing(Card::suit));
        Card.printDeck(deck,"",4);

        PokerGame fiveCardDraw = new PokerGame(8 ,5);
        fiveCardDraw.startPlay();


    }
}
