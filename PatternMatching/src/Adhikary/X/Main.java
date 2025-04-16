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

        Pattern htmlPattern = Pattern.compile("<[hH](?<level>\\d)>(.*)</[hH]\\d>");
        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while(htmlMatcher.find())
        {
//            System.out.println("group: " + htmlMatcher.group());
//            System.out.println("group: " + htmlMatcher.group(0));
            System.out.println( htmlMatcher.group("level") +" " +  htmlMatcher.group(2));
            System.out.println("index = " + htmlMatcher.start("level")); // referring to the captured group for the current match of the input string of this matcherInstance
        }

        System.out.println("-".repeat(50));
        htmlMatcher.reset();
        htmlMatcher.results().forEach((e)->System.out.println(e.group(1) + " " + e.group(2)));
        System.out.println("-".repeat(50));

        String tabbedText = """
                group1	group2	group3
                1	2	3
                a	b	d
                """;
        tabbedText.lines()
//                .forEach(System.out::println);
                .flatMap((e)->Pattern.compile("\\t").splitAsStream(e))
                .forEach((e)->System.out.println(e));

        htmlMatcher.reset();
        String updatedSnippet = htmlMatcher.replaceFirst((mr)->"<em>"+mr.group(2)+"</em>");
        System.out.println("-".repeat(50));
        System.out.println(updatedSnippet);
        System.out.println(htmlMatcher.start()+ " " + htmlMatcher.end());
        System.out.println(htmlMatcher.group(2));

        System.out.println("-".repeat(50));

//        System.out.print("here".repeat(50));
        htmlMatcher.usePattern(Pattern.compile("<([hH]\\d)>(.*)</\\1>"));
        htmlMatcher.reset();
        System.out.println("Using back reference replaced All <h> with <em>: \n" + htmlMatcher.replaceAll((mr)->"<em>$2</em>") );


        System.out.println("-".repeat(50));
        htmlMatcher.reset();
        System.out.println("-".repeat(50));
        System.out.println("Using Back Reference: \n" + htmlMatcher.replaceFirst((mr)->"<em>$2</em>"));







    }
}
