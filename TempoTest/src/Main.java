import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        String goodString = "sihh234(8";
        String name = "Bish al";
        char[] goodStringArr  = goodString.toCharArray();
        char[] nameArr =  name.toCharArray();

        Set<Character> goodStringSet = new LinkedHashSet<>();
        for(char c:goodStringArr)
        {
            goodStringSet.add(c);
        }
        Set<Character> nameSet = new LinkedHashSet<>();
        for(char c:nameArr)
        {
            nameSet.add(c);
        }
        Set<Character> retainedSet = new LinkedHashSet<>(goodStringSet);
        retainedSet.retainAll(goodStringSet);

        Set<Character> finalNameSet = new LinkedHashSet<>(nameSet);
        finalNameSet.removeAll(retainedSet);

        finalNameSet.forEach(System.out::print);


    }

}
