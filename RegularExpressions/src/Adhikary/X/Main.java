package Adhikary.X;

public class Main {
    public static void main(String... args)
    {
        String helloWorld = "%s %s".formatted("Hello","World");
        String helloWorld2 = String.format("%s %s","Hello","World");

        System.out.println("Using String's formatted method: " + helloWorld);
        System.out.println("Using String.format() : " + helloWorld2);

        String helloWorld3 = Main.format("%s %s","Hello","World");
        System.out.println("Using Main.format: " + helloWorld3);


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
