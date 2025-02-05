package Adhikary.X;

import Adhikary.X.Pirate.PirateGame;
import Adhikary.X.game.Game;
import Adhikary.X.game.GameConsole;
import Adhikary.X.game.Player;

//class SpecialGameConsole<T extends Game<? extends Player>> extends GameConsole<Game<? extends Player>> {
//
//    public SpecialGameConsole(Game<? extends Player> game)
//    {
//        super(game);
//    }
//}

public class MainFinal {

    public static void main(String... args)
    {
        //My name is Bishal Adhikary and i love to play football , , , , ,

            GameConsole<PirateGame> game = new GameConsole<>(new PirateGame("Pirate Game"));



    }
}
