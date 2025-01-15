package Adhikary.X;

import java.util.*;

public abstract class Game <T extends Player>    {
    private final String gameName ;

    private final List<T> players ;

    private final Map<Character,GameAction>  standardActions ;

    public Game(String gameName,List<T> players,Map<Character,GameAction> standardActions)
    {
        this.gameName = gameName;
        this.players = new ArrayList<T> (players);
        this.standardActions=new LinkedHashMap<Character,GameAction> (standardActions);
    }
    public  abstract T createNewPlayer(String name);

    public abstract Map<Character,GameAction> getGameActions(int playerIndex);

    public int addPlayer(String name)
    {
        players.add()
    }

    public boolean executeGameAction(Character key)
    {
         return    standardActions.get(key).action().test(players.indexOf()
    }




}
