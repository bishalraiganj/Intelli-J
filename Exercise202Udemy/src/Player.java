import java.util.List;

public record Player(int numOfCardInHand, String name, List<Card> hand) {


@Override
public String toString()

{
    return "%s".formatted(name)+"\n"+hand;




}

}
