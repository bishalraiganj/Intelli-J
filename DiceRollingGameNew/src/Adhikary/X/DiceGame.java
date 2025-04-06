package Adhikary.X;

import java.util.*;
import java.util.stream.Collectors;

public class DiceGame<T extends Player> {

    private final List<T> players=new ArrayList<>();
    private final T currentPlayer;


    public DiceGame(T currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }
    private  int diceIndexer=0;
    public void startPlay() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Map<Integer, Integer> dices = random.ints(5, 1, 7)
                .mapToObj((e) -> e)
                .collect(() -> new LinkedHashMap<>(), (LinkedHashMap<Integer, Integer> e1, Integer e2) -> e1.put(diceIndexer++, e2), (e3, e4) -> e3.putAll(e4));


        System.out.println("""
                
                                                                                  Welcome to The Dice Rolling ! Game V1.0 !
                """ + """
                                                                                             %s   UniqueID:%d
                """.formatted(currentPlayer.name(), currentPlayer.instanceId()));
        System.out.println("\n");
        System.out.print("""
                                                                                       Rolling the Dice.......
                
                                                                                       Your Dice Values :
                """);
        dices.forEach((k, v) -> System.out.print("""
                
                ( Dice.%d Face:%d )""".formatted(k, v)));
        boolean runStatus = true;
        while (runStatus) {

            System.out.println("""
                    
                                                                                                                 :MENU:
                                                                                               Press ! Enter to End the Game :
                                                                                               Enter the Dice no's separated by SPACE to roll them AGAIN !
                                                                                               Enter s to See the Scoring Combinations !
                    """);


            String input = scanner.nextLine();


            if (input.equals("")) {
                System.out.println("Hope ! To See you again !Your Score :0");
                runStatus = false;
            }
            else if ((input.toCharArray().length < 12))
            {


                String[] sArr = input.split(" ");
                for (String s : sArr) {
                    int index = dices.values().stream().collect(() -> new ArrayList<>(), (e1, e2) -> e1.add(e2), (e3, e4) -> e3.addAll(e4)).indexOf(Integer.valueOf(s));
                    System.out.println("Index :" + index);
//                int newValue = random.nextInt(1,7);
                    dices.put(index, -1);
//                System.out.println("Rolled Dice.%d New Value.%d".formatted(index,newValue));
//                dices.forEach((k,v)->System.out.println(k + " " +v));

//                System.out.println("New Dice Values :");
//                dices.forEach((k,v)->"( Dice.%d Face:%d".formatted(k,v));

                }
                for (Integer i : dices.keySet()) {
                    int newValue = random.nextInt(1, 7);
                    if (dices.get(i) == -1) {
                        System.out.println("Rolled Dice.%d New Dice Face:%d".formatted(i, newValue));
                        dices.put(i, newValue);
                    }
                }

                System.out.println("New Dice Values:");
                dices.forEach((k, v) -> System.out.println("( Dice.%d Face:%d)".formatted(k, v)));
            }
            else if(input.equalsIgnoreCase("s"))
            {


            }
            else
            {
                System.out.println("Wrong input only enter from the dice value's separated by SPACE or any valid option from the menu");
            }


        }
    }






}
