package Adhikary.X;

import java.util.List;

public class Main {

    public static void main(String... args)
    {
        String sentence  = "Hello, World";
        boolean matches = sentence.matches("Hello, World");
        System.out.println(matches);

        String regex =  "[A-Z][ a-z]*[.]";
        String sentence2 = "The bike is red.";
        String sentence3 = "Hello World.";
        String sentence4 = "How are you?";
        boolean  matches2 = sentence2.matches(regex);
        System.out.println(matches2);
        System.out.println(sentence3.matches(regex));
        System.out.println(sentence4.matches(regex));

        System.out.println("-".repeat(50));

        String regex2 = "[A-Z].*[.]";
        String regex3 = "[A-Z].*\\.";
        String regex4 = "[A-Z][a-z\\s]+[.]";

        for(String s : List.of("The bike is red." ,"I am a new student.",
                "hello world.",
                "How are you?"))
        {
            boolean matched  = s.matches(regex);
            System.out.println(matched + ": " + s);
        }
        System.out.println("-".repeat(50));

        String regex5 = "[A-Z].*[.?!]";
        String regex6 = "^[A-Z][\\p{all}]+[.!?]$";

        for(String s : List.of("The bike is red, and has flat tires.","I love bein a new L.P.A student!",
                "Hello, friends and family: Welcome!",
                "How are you, Nary?")) {
            boolean matched = s.matches(regex5);
            System.out.println(matched + ": " + s);


        }



    }

}
