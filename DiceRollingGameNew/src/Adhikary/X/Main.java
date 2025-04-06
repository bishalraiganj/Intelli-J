package Adhikary.X;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args)
    {

        Player bishalAdhikary = new DicePlayer("Bishal Adhikary");
        DiceGame<DicePlayer> firstGame = new DiceGame(bishalAdhikary);
        firstGame.startPlay();

//          System.out.println(DiceGame.gameLogic(new ArrayList <>(List.of(1,3,4,1,2)),"3 5 6 4").toString());



    }


}
