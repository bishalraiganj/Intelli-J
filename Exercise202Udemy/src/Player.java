import java.util.List;

public class Player {
private int numOfCardInHand;
private String name;
private List<Card> hand;
private int handRank;
private int pointRank;
public Player(int numOfCardInHand,String name,List<Card> hand)
{  this.numOfCardInHand=numOfCardInHand;
    this.name=name;
    this.hand=hand;
    this.handRank=0;
    this.pointRank=0;


}

public int getNumOfCardInHand()
{
    return numOfCardInHand;

}
public String getName()
{

    return name;

}

public List<Card> getHand()
{

   return hand;

}

public int getHandRank()
{

    return handRank;

}

public int getPointRank()
{

    return pointRank;

}

public void setHandRank(int rank)
{

    this.handRank=rank;


}
public void setPointRank(int rank)
{
this.pointRank=rank;

}



@Override
public String toString()

{
    return "%s\n Hand Rank = %d , Points Rank =%d".formatted(name,handRank,pointRank)+"\n"+hand;




}




}
