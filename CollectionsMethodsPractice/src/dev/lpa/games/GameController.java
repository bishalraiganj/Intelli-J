package dev.lpa.games;

import dev.lpa.Card;
import dev.lpa.games.poker.PokerGame;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameController {

    public static void main(String... args)
    {



        PokerGame fiveCardDraw = new PokerGame(8 ,5);
        fiveCardDraw.startPlay();





        Card.printDeck(Card.getStandardDeck(),"Standard deck",4);



        List<Card> standardDeck3=Card.getStandardDeck();
        Collections.sort(standardDeck3, Comparator.comparing(Card::rank));
        Card.printDeck(standardDeck3,"Sorted only by rank",2);






        List<Card> standardDeck=Card.getStandardDeck();
       Collections.shuffle(standardDeck);
       Card.printDeck(standardDeck,"Shuffled deck",4);


        Collections.sort(standardDeck, Comparator.comparing(Card::suit));
        Card.printDeck(standardDeck,"Sorted only by Suit",2);



        List<Card> standardDeck1=Card.getStandardDeck();
        Card.printDeck(standardDeck1,"Standard Deck",4);
        List<Card> standardDeck2=Card.getStandardDeck();
        Collections.sort(standardDeck2, Comparator.comparing((Card c)->c.rank()).reversed());
        Card.printDeck(standardDeck2,"Sorted by rank reversed ",2);
        Collections.sort(standardDeck1, Card.sortRankReversedSuit());
        Card.printDeck(standardDeck1,"Sorted by rank reversed suit",2);










    }



}
