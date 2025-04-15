package Adhikary.X;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String... args)
    {

        String sentence = "I like motorcycles.";
        boolean matched = Pattern.matches("[A-Z].*[.]",sentence);
        System.out.println(matched + ": " + sentence);

        Pattern firstPattern = Pattern.compile("[A-Z].*[.]");
        Matcher matcher = firstPattern.matcher(sentence);
        System.out.println(matcher.matches() + ": " + sentence);
        System.out.println("sentence.length = " + sentence.length());
        System.out.println("Matched Ending Index = " + matcher.end());

        System.out.println(matcher.lookingAt() + ": " + sentence);
        System.out.println("Matched Ending index = " + matcher.end());



    }
}
