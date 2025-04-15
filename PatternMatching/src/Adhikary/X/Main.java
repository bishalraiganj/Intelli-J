package Adhikary.X;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String... args)
    {

        String sentence = "I like B.M.W motorcycles.";
        boolean matched = Pattern.matches("[A-Z].*[.]",sentence);
        System.out.println(matched + ": " + sentence);

        Pattern firstPattern = Pattern.compile("[A-Z].*?[.]");
        Matcher matcher = firstPattern.matcher(sentence);
        System.out.println(matcher.matches() + ": " + sentence);
        System.out.println("sentence.length = " + sentence.length());
        System.out.println("Matched Ending Index = " + matcher.end());

        System.out.println(matcher.lookingAt() + ": " + sentence);
        System.out.println("Matched Ending index = " + matcher.end());
        System.out.println("Matched on : " + sentence.substring(0,matcher.end()));
        System.out.println("-".repeat(50));

        matcher.reset();
        System.out.println(matcher.find() + ": " + sentence);
        System.out.println("Matched Ending Index  = " + matcher.end());
        System.out.println("Matched on : " + sentence.substring(matcher.start(),matcher.end()));

        System.out.println("-".repeat(50));

        System.out.println("Matched on : " + matcher.group());

        System.out.println("-".repeat(50));

        String htmlSnippet = """
                <H1>My Heading</H1>
                <h2>Sub-heading</h2>
                <p>This is a paragraph about something.</p>
                <p>This is another paragraph about something else.</p>
                <h3>Summary</h3>
                """;

        Pattern htmlPattern = Pattern.compile("<[hH]\\d>.*</[hH]\\d>");
        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while(htmlMatcher.find())
        {
            System.out.println("group: " + htmlMatcher.group());
        }






    }
}
