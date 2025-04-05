package Adhikary.X;

import java.util.Map;
import java.util.TreeMap;

public class DicePlayer implements Player{

    private static long id =0;
    private final long instanceId;
    private final String name;
    private final Map<String,Integer> scoresMap=new TreeMap<>();
    private long totalScore=0;

    public DicePlayer(String name)
    {
        this.name = name;
        instanceId=id++;
    }

    @Override
    public Player defensiveConstructor(String name)
    {
        return new DicePlayer(name);
    }
    protected void addScore(int score)
    {
        totalScore+=score;
    }

    public long getInstanceId()
    {
        return instanceId;
    }
    @Override
    public String name()
    {
        return name;
    }


}
