package Adhikary.X;

import Adhikary.X.dice.DiceGame;
import Adhikary.X.dice.ScoredItem;
import Adhikary.X.game.GameConsole;

import java.util.ArrayList;
import java.util.List;

public class MainGame {

    public static void main(String... args)
    {
//        List<Integer> currentDice = new ArrayList<>(List.of(2,2,4,4,4));
//        for(ScoredItem s: ScoredItem.values())
//        {
//            System.out.printf("Score for %s is %d %n",s,s.score(currentDice));
//        }

        GameConsole<DiceGame> console = new GameConsole<>(new DiceGame("Dice Rolling game"));
        console.playGame(console.addPlayer());


    }


}
