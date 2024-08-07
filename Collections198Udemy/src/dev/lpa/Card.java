package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {

    public enum Suit {

        CLUB,DIAMOND,HEART,SPADE;
        public char getImage()
        {
            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
        }

    }

    @Override
    public String toString() {

        int index = face.equals("10")?2:1;
        String faceString = face.substring(0,index);
        return "%s%c(%d)".formatted(faceString,suit.getImage(),rank);

    }
    public static Card getNumericCard(Suit suit,int cardNumber)
    {
        if(cardNumber>1&&cardNumber<11)
        {

            return new Card(suit,String.valueOf(cardNumber),cardNumber-2);

        }

        System.out.println("Invalid Numeric Card Selected");
        return null;
    }

    public static Card getFaceCard(Suit suit,char abbrev)
    {
        int charIndex = "JQKA".indexOf(abbrev);

        if(charIndex>-1)
        {

            return new Card(suit,""+abbrev,charIndex+9);


        }

        System.out.println("Invalid Face Card Selected ");
        return null;




    }

    public static List<Card> getStandardDeck()
    {
        List<Card> standardDeck = new ArrayList<> (52);

        for(Suit suit :Suit.values())
        {

            for(int i=2;i<=10;i++)
            {
                standardDeck.add(getNumericCard(suit,i));


            }
            for(char c:new char[] {'J','Q','K','A'})
            {

                standardDeck.add(getFaceCard(suit,c));



            }
        }

        return standardDeck;


    }

    public static void printDeck(List<Card> deck)
    {
        printDeck(deck,"Current Deck",4);


    }


    public static void printDeck(List<Card> deck,String description,int rows)


    {
        System.out.println("-".repeat(29));

        if(description!=null)
        {
            System.out.println(description);

        }

        for(int i=0;i<rows;i++)
        {

            int cardsInRow = deck.size() /rows;
            int startIndex = i*cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex,endIndex).forEach(System.out::print);
            System.out.println();


        }






    }





}
