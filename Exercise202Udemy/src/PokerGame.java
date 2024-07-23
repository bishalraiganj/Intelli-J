import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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


//    public static Player evaluateHands(List<Card> cardDeck,List<Player> playerHands,List<CardCombination> cardCombination)
//    {
//
//     int playerCount = playerHands.size();
//     int numOfCardInHand = playerHands.get(0).hand().size();
//     for(Player p:playerHands)
//     {
//
//
//
//
//
//
//     }
//
//
//    }

    public static boolean testCombination(Predicate<CardCombination> p,CardCombination cardCombination)
    {

        return p.test(cardCombination);




    }




}
