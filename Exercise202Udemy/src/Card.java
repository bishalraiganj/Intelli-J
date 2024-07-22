import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
    enum Suit {
        CLUB(9827), DIAMOND(9830), HEART(9829), SPADE(9824);
        int suitValue;

        Suit(int i) {
            suitValue = i;
        }

        public String getImage() {
            return "" +(char) suitValue;

        }

    }


    @Override
    public String toString() {
        return "%s%s%d".formatted(face, suit.getImage(), rank);
    }

    public static Card getNumericCard(Suit suit, int face) {
        if (face >= 1 && face <= 9) {
            return new Card(suit, "" + face, face - 1);

        } else
            System.out.println("Not a valid face value for a numeric card of the Standard Deck of cards , must be between 1 and 9");
        return null;
    }

    public static Card getFaceCard(Suit suit, String abbrev) {
        int i = "JQKA".indexOf(abbrev);
        if (i <= 3 && i >= 0) {
            return new Card(suit, "" + abbrev, 9 + i);


        } else
            System.out.println("Not a valid face abbreviation for a face card , enter one of these J, Q , K , A case sensitive");
        return null;

    }

    public static List<Card> getStandardDeck() {
        List<Card> standardDeck = new ArrayList<>(52);
        Suit[] suitArr = Suit.values();
        for (int i = 0; i < 4; i++) {
            for (int i2 = 1; i2 < 10; i2++) {
                standardDeck.add(Card.getNumericCard(suitArr[i ], i2));


            }
            for (int f = 0; f < 4; f++) {
                standardDeck.add(Card.getFaceCard(suitArr[i], "" + "JQKA".charAt(f)));


            }


        }

        return standardDeck;

    }

    public static void printDeck(List<Card> list, String description, int row)
    {
     System.out.println(description);
     int numOfEle =list.size()/row;
     for(int i= 1,j=0;i<=row&&j<=list.size()-1;i++)
     {
         for(int j1=0;j1<numOfEle;j1++)
         {
             System.out.print(list.get(j)+" ");
                j++;
         }
         System.out.println("");

     }
    }

    public static void printDeck(List<Card> list,String description)
    {
    printDeck(list,description,1);
    }


    public static List<Card> cardRandomization(List<Card> cardList)
    {
        Collections.shuffle(cardList);
        Collections.reverse(cardList);
        Collections.shuffle(cardList);
        if(cardList.size()>6) {
            Collections.rotate(cardList, cardList.size() / 2 - 2);
        }

        return cardList;

    }

    public static void handGame(List<Card> cardList,int playerCount,int numOfCardInHand,String... names) {


        List<Player> players = new ArrayList<>(playerCount);
        for (int i = 0; i < playerCount; i++) {
            int k = i;
            List<Card> cards = new ArrayList<>(numOfCardInHand);
            for (int j = 0; j < numOfCardInHand; j++) {
                cards.add(cardList.get(k));
//                k=k+(playerCount-1)+1;
                k += playerCount;

            }
            players.add(new Player(numOfCardInHand, names[i], cards));
        }
        for (Player p : players) {
            System.out.println("\n"+p);
        }




    }




    

}
