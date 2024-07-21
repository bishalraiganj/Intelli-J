package dev.lpa;

import javax.swing.*;
import java.util.*;

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

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);

        Collections.sort(standardDeck,sortingAlgorithm);
        Card.printDeck(standardDeck," Standard Deck sorted by rank, suit",13);

        Collections.reverse(standardDeck);
        Card.printDeck(standardDeck,"Sorted by rank, suit reversed",13);

        List<Card> kings = new ArrayList<>(standardDeck.subList(4,8));
        Card.printDeck(kings," Kings in deck",1);

        List<Card> tens = new ArrayList<>(standardDeck.subList(16,20));
        Card.printDeck(tens," Tens in deck",1);

        Collections.shuffle(standardDeck);
        int subListIndex = Collections.indexOfSubList(standardDeck,tens);
        System.out.println(" sublist index for tens = "+subListIndex);
        System.out.println("Contains ="+standardDeck.containsAll(tens));

        boolean disjoint =  Collections.disjoint(standardDeck,tens);
        System.out.println(" disjoint ="+disjoint);

        boolean disjoint2 = Collections.disjoint(kings,tens);
        System.out.println(" disjoint2 ="+disjoint2);


        Collections.sort(standardDeck,sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART,10);
        int foundIndex = Collections.binarySearch(standardDeck,tenOfHearts,sortingAlgorithm);
        System.out.println("foundIndex ="+foundIndex);
        System.out.println("finding index using List.indexOf() ="+standardDeck.indexOf(tenOfHearts));
        System.out.println(standardDeck.get(foundIndex));


        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB,10);
        Collections.replaceAll(standardDeck,tenOfClubs,tenOfHearts);
        Card.printDeck(standardDeck.subList(32,36),"ten of clubs being replaces with ten of hearts",1);

        Collections.replaceAll(standardDeck,tenOfHearts,tenOfClubs);
        Card.printDeck(standardDeck.subList(32,36)," ten of hearts being replaces with ten of clubs",1);

        if(Collections.replaceAll(standardDeck,tenOfHearts,tenOfClubs))
        {
            System.out.println(" Tens of hearts replaced with tens of clubs");
        }
        else
        {
            System.out.println(" No tens of hearts found in the list");
        }

        System.out.println(" Ten of clubs cards ="+Collections.frequency(standardDeck,tenOfClubs));

        System.out.println("Best Card ="+Collections.max(standardDeck,Comparator.comparing((Card s)->s.rank()).thenComparing((s)->s.suit())));/* Here in the lambda expression which is in the comparing() i have explicitly declared the type of formal parameter/ the type of the argument that is being
        passed to the sam ,   sometimes lambdas type inference is bad specially in cases of using convenience methods and lambda chaining, because of bad type inference,  but
        if the sam has only one method and its pre-defined on a class we can infer this using method reference, since method reference has better type inference and more concise , we can use method reference ,

        here in this case the method Comparator.comparing() uses an implementation of the function functional interface whose sam has the method rank() invoked on the Card record instance passed as first argument to the sam
        meaning we can replace that corresponding lambda with the following method reference Card::rank   , and the instance on which the method rank() is invoked is an unbounded retriever;
        so the above method reference is an unbounded retriever instance method reference;   */

        System.out.println(" Worst Card in the standard deck ="+Collections.min(standardDeck,Comparator.comparing(Card::rank).thenComparing(Card::suit)));

        Collections.shuffle(standardDeck);
        Collections.sort(standardDeck,(s1,s2)->s1.suit().compareTo(s2.suit()));
        Card.printDeck(standardDeck," Sorted only by suit",4);
        var sortBySuit =  Comparator.comparing(Card::suit).thenComparing(Card::rank);
        standardDeck.sort(sortBySuit);
        Card.printDeck(standardDeck," Sorted by suit, rank",4);


        standardDeck = Card.getStandardDeck();
        List<Card> copied = new ArrayList<>(standardDeck.subList(0,13));
        Collections.rotate(copied,2);
        System.out.println("UnRotated ="+standardDeck.subList(0,13));
        System.out.println("Rotated +2  = "+copied);


        copied = new ArrayList<>(standardDeck.subList(0,13));
        Collections.rotate(copied,-2);
        System.out.println("UnRotated ="+standardDeck.subList(0,13));
        System.out.println("Rotated  -2 = "+copied);

        copied = new ArrayList<>(standardDeck.subList(0,13));
        for(int i=0;i<copied.size()/2;i++)
        {
            Collections.swap(copied,i,copied.size()-1-i);

        }
        System.out.println("Manual reverse :"+copied);

        copied = new ArrayList<>(standardDeck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using Reverse :"+copied);




































        





        







    }







}
