package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String... args)
    {



        Card aceOfHeart = Card.getFaceCard(Card.Suit.HEART, 'A');
        Card[] cardArray = new Card[13];
        Arrays.fill(cardArray,aceOfHeart);
        Card.printDeck(Arrays.asList(cardArray)," Aces of Hearts",1);

        List<Card> cards = new ArrayList<> (52);
        Collections.fill(cards,aceOfHeart);
        System.out.println(cards);
        System.out.println("cards.size() ="+cards.size());

        List<Card> acesOfHearts = Collections.nCopies(16,aceOfHeart);
        Card.printDeck(acesOfHearts," Aces of Hearts",4);


        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB,'K');
        List<Card> kingsOfClubs = Collections.nCopies(16,kingOfClubs);
        Card.printDeck(kingsOfClubs,"Kings Of Clubs",4);

        List<Card> cards1 = new ArrayList<>(19);
        Collections.addAll(cards1,Card.getFaceCard(Card.Suit.HEART,'Q'),new Card(Card.Suit.HEART,"Suparna",13),Card.getNumericCard(Card.Suit.DIAMOND,9));



        Card.printDeck(cards1, " Card Collection  created by add all with var args", 1);

        Collections.addAll(cards,cardArray);
        Collections.addAll(cards,cardArray);
        Card.printDeck(cards," card collection with aces added",1);

          Collections.copy(cards,kingsOfClubs);
          Card.printDeck(cards,"Card collection with Kings Copied",2);

          cards = List.copyOf(kingsOfClubs);  // List.copyOf() returns a true list copy which is unmodifiable meaning doesnt support modification operations
          Card.printDeck(cards,"List copy of lings",1);


          cards = new ArrayList<> (List.copyOf(kingsOfClubs));
          cards.add(Card.getFaceCard(Card.Suit.HEART,'Q'));
          Card.printDeck(cards," cards list created calling List.of()  and by passing it to a modifiable list constructor such as an ArrayList constructor ",1);


        List<Card> standardDeck= Card.getStandardDeck();
        Card.printDeck(standardDeck);
        Collections.shuffle(standardDeck);
        Card.printDeck(standardDeck," Shuffled Deck",4);

        Collections.reverse(standardDeck);
        Card.printDeck(standardDeck," Reversed StandardDeck",4);




        







    }







}
