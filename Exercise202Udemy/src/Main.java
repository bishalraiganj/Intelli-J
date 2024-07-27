import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String... args) {
        List<Card> standardDeck = Card.getStandardDeck();
        System.out.println(standardDeck);
        Card.printDeck(standardDeck, " its a standard Deck of cards", 4);

        Collections.shuffle(standardDeck);
        Card.printDeck(standardDeck, " shuffled my standard deck of cards", 4);

        standardDeck = Card.getStandardDeck();
        standardDeck.subList(26, 52).clear();
        System.out.println("\n\n\nCutting My Standard Deck in Half\n" + standardDeck);
        Card.printDeck(standardDeck, "\n\n\n cut in half Standard Deck of cards", 2);

        standardDeck = Card.getStandardDeck();

        List<Card> forGame = PokerGame.cardRandomization(standardDeck);
        Card.printDeck(forGame, " Randomized Deck of cards", 4);
        List<Player> players = PokerGame.dealingCards(forGame, 4, 5, "Bishal Adhikary", " Subhankar Adhikary", " Dhrup Barman", "Rudra Roy");

        Hand royalFlush = new Hand(10, Card.getFaceCard(Card.Suit.CLUB, "A"), Card.getFaceCard(Card.Suit.CLUB, "K"), Card.getFaceCard(Card.Suit.CLUB, "Q"), Card.getFaceCard(Card.Suit.CLUB, "J"), Card.getNumericCard(Card.Suit.CLUB, 10));
        Hand royalFlush2 = new Hand(10, Card.getFaceCard(Card.Suit.DIAMOND, "A"), Card.getFaceCard(Card.Suit.DIAMOND, "K"), Card.getFaceCard(Card.Suit.DIAMOND, "Q"), Card.getFaceCard(Card.Suit.CLUB, "J"), Card.getNumericCard(Card.Suit.CLUB, 10));
        Hand royalFlush3 = new Hand(10, Card.getFaceCard(Card.Suit.HEART, "A"), Card.getFaceCard(Card.Suit.HEART, "K"), Card.getFaceCard(Card.Suit.HEART, "Q"), Card.getFaceCard(Card.Suit.HEART, "J"), Card.getNumericCard(Card.Suit.HEART, 10));
        Hand royalFlush4 = new Hand(10, Card.getFaceCard(Card.Suit.SPADE, "A"), Card.getFaceCard(Card.Suit.SPADE, "K"), Card.getFaceCard(Card.Suit.SPADE, "Q"), Card.getFaceCard(Card.Suit.SPADE, "J"), Card.getNumericCard(Card.Suit.SPADE, 10));


//        System.arraycopy()
//        CardCombination pokerHandCombination = new CardCombination(royalFlush,royalFlush2,royalFlush3,royalFlush4,straightFlushArray());

        System.out.println(Arrays.toString(straightFlushArray()) + "\n" + straightFlushArray().length);
        System.out.println(Arrays.toString(fourOfAKind()));


//        System.out.println(new Card(Card.Suit.HEART,"Bishal Card",13));


    }


    public static Hand[] straightFlushArray() {
        int k = 0;
        Hand[] arr = new Hand[36];
        for (Card.Suit s : Card.Suit.values()) {
            for (int i = 0; i <= 8; i++) {
                Hand tempHand = new Hand(9, new Card[5]);
                for (int j = i; j <= i + 4; j++) {

                    if (i < 5) {
                        tempHand.getCards().add(Card.getNumericCard(s, j + 2));
                    } else {
                        if (j <= 8) {

                            tempHand.getCards().add(Card.getNumericCard(s, j + 2));


                        } else {
                            int count = (j + 2) - 10;


                            tempHand.getCards().add(Card.getFaceCard(s, "JQKA".charAt(count - 1) + ""));
                        }
                    }
                }

                tempHand.setCards(tempHand.getCards().subList(5, 10));
                arr[k] = tempHand;
                k += 1;


            }
        }
        return arr;


    }


    public static Hand[] fourOfAKind() {

        Hand[] arr = new Hand[12];
        for (int i = 0; i < 12; i++) {
            Hand tempHand = new Hand(8, new Card[4]);
            int k = 0;
            for (Card.Suit s : Card.Suit.values()) {

                if (i < 9) {

                    tempHand.getCards().set(k, Card.getNumericCard(s, i + 2));
                    k++;
                } else {
                    int counter = i - 8;
                    tempHand.getCards().set(k, Card.getFaceCard(s, "JQKA".charAt(counter - 1) + ""));
                    k++;
                }

            }
//            tempHand.setCards(tempHand.getCards().subList(4,8));
            arr[i] = tempHand;
        }
        return arr;


    }


    public static Hand[] fullHouse() {


        for (int l = 0; l < 13; l++)
        {
            for(int s=0;s<4;s++)
            {

               /

























            }
        }


















    }



}
