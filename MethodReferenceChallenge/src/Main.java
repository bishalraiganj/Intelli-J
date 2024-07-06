

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {




    public static void main(String[] args)
    {

        Person tim =new Person("Tim");

        String[] names = {"bishal","rudra","dhrup","joy","avi"};
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        UnaryOperator<String> randomMiddleInitial = (s)-> {char a=(char) (new Random().nextInt(26)+97);return s.concat(" "+String.valueOf(a));};
        UnaryOperator<String> reverseLastName = (s)->s.concat(new StringBuilder(s).reverse().toString());
        List<UnaryOperator<String>>  functionInterface = new ArrayList(List.of(toUpperCase,randomMiddleInitial,reverseLastName));
        List<UnaryOperator<String>> functionInterface2 = new ArrayList<>(List.of(
                String::toUpperCase,

                (s)->s+" "+getRandomChar('d','x')+".",
                (s)->s+=" "+reverse(s,0,s.indexOf(" ")),
                Main::reverse,
                String::new,
//               (s)->new String("Howdy "+s),
                String::valueOf,
                tim::last,
                (new Person("Suparna"))::last



        ));

        applyFunctions2(names,functionInterface2);

    }
    private static void applyFunctions(String[] names, List<UnaryOperator<String>> fList)
    {
        int i=0;
        for(String name : names)
        {
            names[i]=  name.transform(fList.get(1));
            ++i;
        }
        System.out.println(Arrays.toString(names));
    }


    private static void applyFunctions2(String[] names,List<UnaryOperator<String>> stringFunctions) {

        List<String> names2 = Arrays.asList(names);
        for (var function : stringFunctions)
        {

            names2.replaceAll(function);
            System.out.println(names2);


        }



        Person Tim =new Person("Tim");

    }

    public static char getRandomChar(char start,char end)
    {
        return (char) new Random().nextInt((int) start,(int) end+1);

    }
    public static String reverse(String s)
    {
        return reverse(s,0,s.length());

    }
    public static String reverse(String s,int start,int end)
    {

        return new StringBuilder(s.substring(start,end)).reverse().toString();
    }

    private record Person(String first)
    {

        public String last(String s)
        {
            return first +" "+s.substring(0,s.indexOf(" "));
        }
    }


}