package dev.lpa;

import com.sun.jdi.Value;

import java.util.Arrays;

public class Card {
    enum Cards {
        One(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Joker("J"), Queen("Q"), King("K"), Ace("A");
        private int cardNumber;
        private String cardFace;

        Cards(int i)
        {
            this.cardNumber = i;

        }

        Cards(String s)
        {

        this.cardFace =s;

        }
        public int getCardNumber()
        {

            return cardNumber;
        }
        public String getCardFace()
        {

            return cardFace;

        }
        public static Cards getCard(int i)
        {
            if(i<14&&i>0)
            {
                for(Cards c :Cards.values())
                {
                    if(c.cardNumber==i)
                        return c;

                }

            }
            else
                System.out.println("Invalid card Number");
                return null;

        }

        public static Cards getFaceCard(String s)
        {

          for(Cards c: Cards.values())
          {
              if(c.cardFace.equalsIgnoreCase(s))
              {
                  return c;

              }

          }
          System.out.println(" Invalid Card Face");
          return null;

        }

    }


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
    Cards card;
    Suit s1;
    String faceValue;
    int rank;
//    public Card(Suit s1,int number)
//    {
//        this.s1=s1;
//        this.rank=number;
//    }
    public Card(Suit s1,Cards card)
    {
     this.s1=s1;
     this.card=card;

    }
    public static void main(String... args)
    {




    }
    @Override
    public  String toString()
    {
        return "Face Value : "+faceValue+(char) s1.getIntValue();

    }
    
    public static Card getNumericCard(Suit s1,int num)
    {
        if (num<10&&num>0) {
            return new Card(s1,Cards.getCard(num));
        }

        else
            System.out.println("Not a Numeric Card");
        return null;


    }
    public static Card getFaceCard(Suit s1,String s)

    {   for(String sa: Arrays.asList("J","Q","K","A"))
        {
            if(s.equalsIgnoreCase(sa))
            {

           return  new Card(s1,Cards.getFaceCard(s));
            }
        }
        System.out.println("Not a Face Card");
        return null;
    }








}
