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
        System.out.println("-".repeat(50));




        phoneMatcher.reset();
        phoneMatcher.usePattern(Pattern.compile("\\(*[0-9]{3}[)\\s-]*[0-9]{3}[\\s-]*[0-9]{4}"));
        phoneMatcher.results()
                .forEach((mr)->System.out.println(mr.group()));
        System.out.println("-".repeat(50));



        phoneMatcher.reset();
        phoneMatcher.usePattern(Pattern.compile("\\(*[0-9]{3}[-\\s)]*\\d{3}[\\s-]*\\p{Digit}{4}"));
        phoneMatcher.results()
                .forEach((mr)->System.out.println(mr.group()));
        System.out.println("-".repeat(50));


        String htmlSnippets = """
                 <H1>My Heading</H1>
                 <h2>Sub-heading</h2>
                 <p>This is a paragraph about something.</p>
                 <p style="abc">This is another paragraph about something else.</p>
                 <h3 id="third">Summary</h3>
                 <br/>
                 <p>Testing</p>
                 """;




        Pattern htmlPattern = Pattern.compile("<(\\w+)[^>]*>([^\\v</>]*)(</\\1>)*");
        Matcher m = htmlPattern.matcher(htmlSnippets);
        m.results()
                .forEach((mr)->System.out.println("Full tag:" + mr.group(0)
                        + "\n\tType: " +mr.group(1)
                        + "\n\tText: " +mr.group(2)));

        System.out.println("-".repeat(50));


        m.reset();
        m.usePattern(Pattern.compile("<([a-z_0-9]+)[^>]*>([^\r\n</>]*)(</\\1>)*",Pattern.CASE_INSENSITIVE)); // here , I have replaced \\w with the character class [a-zA-Z_0-9] and \\v in second group with \r and \n
        m.results()
                .forEach((mr)->System.out.println("Full tag:" + mr.group(0)
                        + "\n\tType: " + mr.group(1)
                        + "\n\tText: " + mr.group(2)
                ));

        System.out.println("-".repeat(50) + "\n now");
        m.reset();
        m.usePattern(Pattern.compile("<([\\w]+)[^>]*>([^\\v</>]*)(</\\1>)",Pattern.CASE_INSENSITIVE));
        m.results()
                .filter((mr)->mr.group(1).toLowerCase().startsWith("h"))
                .forEach((mr)->System.out.println("Full tag: " + mr.group(0)
                        + "\n\tType: " + mr.group(1)
                        + "\n\tText: " + mr.group(2)
                ));








    }


}
