package Adhikary.X;

public class Main {

    public static void main(String... args)
    {

        Player bishalAdhikary = new DicePlayer("Bishal Adhikary");
        DiceGame<DicePlayer> firstGame = new DiceGame(bishalAdhikary);
        firstGame.startPlay();




    }


}
