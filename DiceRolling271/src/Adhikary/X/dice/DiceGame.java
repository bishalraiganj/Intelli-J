package Adhikary.X.dice;

import Adhikary.X.game.Game;
import Adhikary.X.game.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiceGame extends Game<DicePlayer> {


    public DiceGame(String name)
    {
        super(name);
    }
    @Override
    public DicePlayer createNewPlayer(String name)
    {
        return new DicePlayer(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex)
    {
        Map<Character,GameAction> map = new LinkedHashMap<> (Map.of('R',new GameAction('R',"Roll Dice",( e)->this.rollDice(e))));
        map.putAll(getStandardActions());
        return map;
    }

    private boolean rollDice(int playerIndex)
    {
       return  getPlayer(playerIndex).rollDiceAndSelect();

    }









}
