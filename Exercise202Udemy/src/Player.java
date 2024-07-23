import java.util.List;

public record Player(int numOfCardInHand, String name, List<Card> hand,int rank) {

public Player(int numOfCardInHand,String name,List<Card> hand)
{  this(numOfCardInHand,name,hand,0);


}
@Override
public String toString()

{
    return "%s\n Rank = %d".formatted(name,rank)+"\n"+hand;




}

}
