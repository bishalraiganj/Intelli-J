package Adhikary.X;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String... args)
    {


        String r = "0121102000340";
        System.out.println(removeKdigits(r,2));
    }

    public static int removeKdigits(String num,int k)
    {
        char[] chars = num.toCharArray();
        List<Character> charsList = new ArrayList<>();

        for(char c : chars)
        {
            charsList.add(c);
        }

        charsList.removeIf((c)->Character.getNumericValue(c)==k);
        System.out.println(charsList);
        String result="";
        for(Character c : charsList)
        {
            result += ""+c; // We have to use += compound assignment in order to add / concat with the previous string the new string;
        }
        return Integer.valueOf(result);


        

    }
}
