package Adhikary.X;

import java.util.List;
import java.util.Map;

public abstract class Game <T extends Player>    {
    private final String gameName ;

    private final List<T> players ;

    private final Map<Character,GameAction>  standardActions ;

    public Game(String gameName,List<T> players,Map<Character,GameAction> standardActions)
    {
        this.gameName = gameName;
        this.players = players;
        this.standardActions=standardActions;
    }
    public  abstract T createNewPlayer(String name);

    public abstract Map<Character,GameAction> getGameActions(int playerIndex);

    public int addPlayer(String name)
    {
        players.add()
    }

    public boolean executeGameAction(Character key)
    {

    }




}
