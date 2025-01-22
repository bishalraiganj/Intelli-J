package Adhikary.X.Pirate;

import Adhikary.X.game.Game;
import Adhikary.X.game.GameAction;

import java.util.List;
import java.util.Map;

public class PirateGame extends Game<Pirate> {

    private static final List<List<String>> levelMap;



    public PirateGame(String gameName)
    {
        super(gameName);
    }

    @Override
    public Pirate createNewPlayer(String name)
    {
        return new Pirate(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex)
    {
        return null;
    }


}
