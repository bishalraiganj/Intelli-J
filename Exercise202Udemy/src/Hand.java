import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Hand {


    List<Card> cards;
    int rank;
    public Hand(int rank, Card... cardArr)
    {
        cards =new ArrayList<>(Arrays.asList(cardArr));
        this.rank = rank;


    }
}
