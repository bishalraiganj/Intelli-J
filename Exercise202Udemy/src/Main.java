import java.util.Collections;
import java.util.List;

public class Main {


    public static void  main(String... args)
    {
        List<Card> standardDeck = Card.getStandardDeck();
        System.out.println(standardDeck);
        Card.printDeck(standardDeck," its a standard Deck of cards",4);

        Collections.shuffle(standardDeck);
        Card.printDeck(standardDeck," shuffled my standard deck of cards",4);

        standardDeck = Card.getStandardDeck();
        standardDeck.subList(26,52).clear();
        System.out.println("\n\n\nCutting My Standard Deck in Half\n"+standardDeck);
        Card.printDeck(standardDeck,"\n\n\n cut in half Standard Deck of cards",2);

        standardDeck = Card.getStandardDeck();

        List<Card> forGame=PokerGame.cardRandomization(standardDeck);
        Card.printDeck(forGame," Randomized Deck of cards",4);
        List<Player> playersHands=PokerGame.dealingCards(forGame,4,5,"Bishal Adhikary"," Subhankar Adhikary"," Dhrup Barman","Rudra Roy");





    }

}
