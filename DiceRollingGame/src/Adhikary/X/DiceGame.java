package Adhikary.X;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class DiceGame {

    private final List<Player> playersHistory=new ArrayList<>();

    private final Random random = new Random();


    private final Player currentPlayer;

    private final Scanner scanner=new Scanner(System.in);


    public DiceGame()
    {

        this.currentPlayer = new DicePlayer("").defensiveConstructor(startGame());
    }

    public void addPlayer(Player player)
    {
        playersHistory.add(player.defensiveConstructor(player.name()));
    }

    public String startGame()
    {
        System.out.println("""
                
                
              
                Welcome to the Dice Rolling Game ! v1.0 \n
                     Enter You Player Name : \n
                
                """);

        return scanner.nextLine().trim();


    }

    public void startPlay()
    {

        Stream<Integer> diceFaces = random.ints(5,1,7)
                .boxed();

        if(currentPlayer.name().length()>0)
        {
            System.out.printf("""   
                     Welcome %s     
                     rolling  dice!
                     dice values : 
                     
                     """,currentPlayer.name());

            diceFaces.forEach((e)->System.out.print(e+","));

            boolean status =false;

            System.out.println("""
                                    :MENU:
                         Press Enter to End the Game !
                         Enter the Dice Values, to roll them again !
                         Press 1 , to Show the Scoring Combinations !
            """);

            while(!status)
            {



            }

        }


    }




}
