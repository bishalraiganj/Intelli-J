package Adhikary.X;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String... args)
    {
        String helloWorld = "%s %s".formatted("Hello","World");
        String helloWorld2 = String.format("%s %s","Hello","World");

        System.out.println("Using String's formatted method: " + helloWorld);
        System.out.println("Using String.format() : " + helloWorld2);

        String helloWorld3 = Main.format("%s %s","Hello","World");
        System.out.println("Using Main.format: " + helloWorld3);

        String testString  = "Anyone can Learn abc's, 123's, and any regular expression";
        String replacement = "(-)";

        String[] patterns = {
                "[a-zA-Z]*$",
                "^[a-zA-Z]{3}",
                "[aA]ny\\b"
        };
        for(String pattern : patterns)
        {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern  + " => " + output);
        }

        String paragraph = """
                Double, double toil and trouble;
                Fire burn and caldron bubble.
                Fillet of a fenny snake,
                In the caldron boil and bake
                Eye of newt and toe of frog,
                Wool of bat and tongue of dog,
                Adder's fork and blind-worm's sting,
                Lizard's leg and howlet's wing,
                For a charm of powerful trouble,
                Like a hell-broth boil and bubble.
                """;

        String[] lines  = paragraph.split("\\R");
        System.out.println("This paragraph has " + lines.length + " lines");
        String[] words = paragraph.split("\\s");
        System.out.println("This paragraph has " + words.length + " words");

        System.out.println(paragraph.replaceAll("ble\\b","[GRUB]"));
        System.out.println(paragraph.replaceAll("[a-zA-Z]+ble","[GRUB]"));
        System.out.println(paragraph.replaceAll(".+ble","[GRUB]"));

        System.out.println("-".repeat(50));

        Scanner scanner = new Scanner(paragraph);
        System.out.println(scanner.delimiter());
        System.out.println("-".repeat(50));
        scanner.useDelimiter("\\R");

//        while(scanner.hasNext())
//        {
//            String element = scanner.next();
//            System.out.println(element);
//        }

//        scanner.tokens()
//                .map((s)->s.replaceAll("\\p{Punct}",""))
////                .map((e)->Arrays.stream(e.split("\\s+")).count())
//
//                .flatMap((e)->Arrays.stream(e.split("\\s+")))
//                .filter((e)->e.matches("[a-zA-Z]+ble"))
//                .forEach((e)->System.out.println(e));

        System.out.println("-".repeat(50));
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));


        scanner.close();




    }

    public static String format(String regexp, String... args)
    {

        int index = 0;
        while(regexp.matches(".*%s.*"))
        {
            regexp = regexp.replaceFirst("%s",args[index++]);
        }

        return regexp;
    }

    public static String replaceStrings(String s,String... args) // error may occur when we there are no %s left in the parameter String s
    {
        for(String string : args )
        {
            s = s.replaceFirst("%s",string);

        }

        return s;
    }


}
