import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class PokerGame {


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

    public static List<Player> dealingCards(List<Card> cardList, int playerCount, int numOfCardInHand, String... names) {


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

        return players;
    }


    public static Player evaluateHands(List<Card> cardDeck,List<Player> players,CardCombination cardCombination)
    {


     int pRank=0;
     int rank;
     int playerCount = players.size();
     int numOfCardInHand = players.get(0).getHand().size();
     for(Player p:players)
     {




        for(Hand c:cardCombination.cList())
        {
            p.setHandRank( testCombination((s)->{if(p.getHand().containsAll(s.getCards())) return s.getRank();return 0;},c));



        }
        if (p.getHandRank()==0)
        {

            for(Card c:p.getHand())
            {
                pRank+=c.rank();


            }

            p.setPointRank(pRank);



        }



     }


     Player winner =Collections.max(players, Comparator.comparing((s)->{if(s.getHandRank()>0) return s.getHandRank();return s.getPointRank();}));

    return winner;
    }

    public static int testCombination(Function<Hand,Integer> p, Hand cardCombination)
    {

        return p.apply(cardCombination);




    }




}
