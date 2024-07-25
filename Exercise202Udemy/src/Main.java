import java.util.ArrayList;
import java.util.Arrays;
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
        List<Player> players=PokerGame.dealingCards(forGame,4,5,"Bishal Adhikary"," Subhankar Adhikary"," Dhrup Barman","Rudra Roy");

        Hand royalFlush = new Hand(10,Card.getFaceCard(Card.Suit.CLUB,"A"),Card.getFaceCard(Card.Suit.CLUB,"K"),Card.getFaceCard(Card.Suit.CLUB,"Q"),Card.getFaceCard(Card.Suit.CLUB,"J"),Card.getNumericCard(Card.Suit.CLUB,10));
        Hand royalFlush2 = new Hand(10,Card.getFaceCard(Card.Suit.DIAMOND,"A"),Card.getFaceCard(Card.Suit.DIAMOND,"K"),Card.getFaceCard(Card.Suit.DIAMOND,"Q"),Card.getFaceCard(Card.Suit.CLUB,"J"),Card.getNumericCard(Card.Suit.CLUB,10));
        Hand royalFlush3 = new Hand(10,Card.getFaceCard(Card.Suit.HEART,"A"),Card.getFaceCard(Card.Suit.HEART,"K"),Card.getFaceCard(Card.Suit.HEART,"Q"),Card.getFaceCard(Card.Suit.HEART,"J"),Card.getNumericCard(Card.Suit.HEART,10));
        Hand royalFlush4 =  new Hand(10,Card.getFaceCard(Card.Suit.SPADE,"A"),Card.getFaceCard(Card.Suit.SPADE,"K"),Card.getFaceCard(Card.Suit.SPADE,"Q"),Card.getFaceCard(Card.Suit.SPADE,"J"),Card.getNumericCard(Card.Suit.SPADE,10));


//        System.arraycopy()
//        CardCombination pokerHandCombination = new CardCombination(royalFlush,royalFlush2,royalFlush3,royalFlush4,straightFlushArray());

        System.out.println(Arrays.toString(straightFlushArray()));


    }


    public static Hand[] straightFlushArray() {
        int k=0;
        Hand[] arr=new Hand[20];
        for (Card.Suit s : Card.Suit.values()) {
            for (int i = 0; i <5;i++) {
                Hand tempHand= new Hand(9,new Card[5]);
                for (int j = 0; j < 5; j++)
                {
                   tempHand.getCards().add(new Card(s,(j+2+i)+"",j+i));
                }
                arr[k]= tempHand;
                k+=1;


            }
        }
        return arr;



    }

}
