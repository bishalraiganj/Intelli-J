import java.util.stream.IntStream;

public class Main {

    public static void main(String... args)
    {

        IntStream.iterate((int) 'A',(e)->e<=(int) 'z',(e)->e+1)
                .forEach((e)->System.out.printf("%c ",e));







    }
}
