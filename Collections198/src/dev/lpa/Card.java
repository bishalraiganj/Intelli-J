package dev.lpa;

import com.sun.jdi.Value;

public class Card {
//    enum Cards {
//        One(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Joker("J"), Queen("Q"), King("K"), Ace("A");
//        private int cardNumber;
//        private String cardFace;
//
//        Cards(int i)
//        {
//            this.cardNumber = i;
//
//        }
//
//        Cards(String s)
//        {
//
//        this.cardFace =s;
//
//        }
//
//
//
//    }



    enum Suit{

        Club(9827,"Club"),Diamond(9830,"Diamond"),Heart(9829,"Heart"),Spade(9824,"Spade");
        private  int intValue;
        private  String cardAbbreviation;

        Suit(int intValue, String cardAbbreviation) {


        this.intValue=intValue;
        this.cardAbbreviation = cardAbbreviation;
        }

        public int getIntValue()
        {

            return intValue;
        }
    }

    Suit s1;
    String faceValue;
    int rank;
    public Card(Suit s1,int number)
    {
        this.s1=s1;
        this.rank=number;
    }
    public static void main(String... args)
    {
















    }
    @Override
    public  String toString()
    {
        return "Face Value : "+faceValue+(char) s1.getIntValue();

    }
    
    public static Card getNumericCard(Suit s1,int rank)
    {
        if 
        return new Card( s1,rank);

    }
    public static Card getFaceCard(Suit s1,String faceValue)
    {

        return new Card(Suit.valueOf(faceValue),);

    }


}
