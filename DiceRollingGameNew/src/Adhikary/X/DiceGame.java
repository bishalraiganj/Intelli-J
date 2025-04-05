package Adhikary.X;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DiceGame<T extends DicePlayer> {

    public void startPlay(T player)
    {
        Scanner scanner = new Scanner(System.in);
        Random  random = new Random();
        Map<Integer,Integer> dices =  random.ints(5,1,7)
                        .collect(Collectors.groupingBy())



        System.out.println("""
                
                              Welcome to The Dice Rolling ! Game V1.0 !
                               
                """);
        System.out.println("\n".repeat(8));
        System.out.println("""
                
                            Rolling the Dice.......
                            
                            
                
                
                
                
                """)





    }







}
