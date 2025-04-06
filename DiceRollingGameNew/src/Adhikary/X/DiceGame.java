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
                                                                                               Enter the Dice Face Value's separated by SPACE to roll them AGAIN !
                                                                                               Enter s to See the Scoring Combinations !
                    """);


            String input = scanner.nextLine();

           boolean complexLogic = input.replace(" ","").chars().filter((e)->e<48||e>57).mapToObj((e)->Integer.valueOf(e)).
                    collect(()->new ArrayList<>(),(ArrayList<Integer> e1,Integer e2)->e1.add(e2),(e3,e4)->e3.addAll(e4))
                    .size()<1 ;
            boolean easyLogicIsDigit = input.replace(" ","").chars().mapToObj((e)->Character.valueOf((char) e)).allMatch((e)->Character.isDigit(e));
            boolean easyLogicIsNotDigitNew =  input.replace(" ","").chars().anyMatch((e)->(e<49||e>54)); // more effiecient than the easyLogicIsDigit

            String[] str = input.split(" ");
            boolean logicStatusEntityLength = Arrays.stream(str).anyMatch((e)->e.toCharArray().length>1);


            if (input.equals("")) {
                System.out.println("Hope ! To See you again !Your Score :0");
                runStatus = false;
            }
            else if ((input.split(" ").length <6&& input.split(" ").length>0)&&!easyLogicIsNotDigitNew&&!logicStatusEntityLength) /* First logic checks whether there are less than 6 entities and more than one entities present i
            in the String or not , second condition checks where each characters are numeric digits  or not ,third condition checks each entity is of length 1 or not
            */
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
                System.out.println("Wrong input ! ONLY enter from the dice value's separated by SPACE or any valid option from the menu");
            }


        }
    }

    public static List<Integer> gameLogic(List<Integer> dices,String input) {
        Random random = new Random();
//        List<Integer> dices = random.ints(5, 1, 7)
//
//                .mapToObj((e) -> Integer.valueOf(e))
//                .peek((e)->System.out.println(e))
//                .collect(() -> new ArrayList<>(), (e1, e2) -> e1.add(e2), (e3, e4) -> e3.addAll(e4));


        Arrays.stream(input.split(" ")).map(Integer::valueOf).forEach((e)->
        {
            System.out.println("input entity:"+e+", dice.contains:"+dices.contains(e)+"indexOf:"+dices.indexOf(e));
            if(dices.contains(e))
            {
                dices.set(dices.indexOf(e),-1);
                System.out.println("did execute for :"+e);
            }
        });
        System.out.println(dices);

        List<Integer> newDices =  new ArrayList<>(dices);

        dices.stream().forEach((e)->{

            if(e==-1)
            {
                newDices.set(newDices.indexOf(e),random.nextInt(1,7));
            }
        });
//        newDices.stream().forEach((e)->dices.set(e,random.nextInt(1,7)));

        return newDices;

    }






}
