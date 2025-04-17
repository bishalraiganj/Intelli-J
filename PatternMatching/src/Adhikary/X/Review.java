package Adhikary.X;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Review {

    public static void main(String... args)
    {
        String phoneList = """
                (800) 123-4567
                (800)123-4567
                (800) 123 4567
                800-123-4567
                800 123-4567
                800 123 4567
                8001234567
                """;


        Pattern phonePattern = Pattern.compile("\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}");
        phoneList.lines()
                .filter((e)-> phonePattern.matcher(e).matches())
                .forEach(System.out::println);

        System.out.println("-".repeat(50));




        Matcher phoneMatcher  = phonePattern.matcher(phoneList);
        while(phoneMatcher.find())
        {
            System.out.println(phoneMatcher.group());
        }
        System.out.println("-".repeat(50));



        phoneMatcher.reset();
        phoneMatcher.results()
                .forEach((mr)->System.out.println(mr.group()));
        System.out.println("-".repeat(50));


        phoneMatcher.reset();
        phoneMatcher.usePattern(Pattern.compile("\\(*[0-9]{3}\\)* [0-9]{3}-[0-9]{4}"));
        phoneMatcher.results()
                .forEach((mr)->System.out.println(mr.group()));
        System.out.println("-".repeat(50));

        phoneMatcher.reset();
        phoneMatcher.usePattern(Pattern.compile("\\(*[0-9]{3}\\)* *[0-9]{3}-[0-9]{4}"));
        phoneMatcher.results()
                .forEach((mr)->System.out.println(mr.group()));
        System.out.println("-".repeat(50));

        phoneMatcher.reset();
        phoneMatcher.usePattern(Pattern.compile("\\(*[0-9]{3}[)\\s]*[0-9]{3}-[0-9]{4}"));
        while(phoneMatcher.find())
        {
            System.out.println(phoneMatcher.group());
        }






    }


}
