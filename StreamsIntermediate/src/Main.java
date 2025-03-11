import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String... args)
    {

        IntStream.iterate((int) 'A',(e)->e<=(int) 'z',(e)->e+1)
                .filter(Character::isAlphabetic)
//                .distinct()
                .map(Character::toUpperCase)
                .distinct()
//                .dropWhile((e)->Character.toUpperCase(e)<='E')
//                .takeWhile((e)->e< 'a')
//                .skip(5)
//              .filter((e)->Character.toUpperCase(e)> 'E')
                .forEach((e)->System.out.printf("%c ",e));


        System.out.println("\n"+"-".repeat(50));

        Random random = new Random();
        Stream.generate(()->random.nextInt((int) 'A',(int) 'Z'+1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach((e)->System.out.printf("%c ",e));







    }
}
