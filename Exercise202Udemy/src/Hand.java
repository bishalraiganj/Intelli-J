import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Hand {


    private List<Card> cards;
    private int rank;

    public Hand(int rank, Card... cardArr) {
        cards = new ArrayList<>(Arrays.asList(cardArr));
        this.rank = rank;


    }

    public int getRank() {
        return rank;

    }

    public List<Card> getCards() {

        return cards;

    }

    public void setCards(List<Card> cards)
    {
        this.cards= cards;
    }

    @Override
    public String toString()
    {

        return  "Hands"+cards+"\n";





    }


}
