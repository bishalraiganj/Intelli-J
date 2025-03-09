import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    static int counter = 0 ;

    public static void main(String[] args) {
        int seed = 1;

        var streamB =
                Stream.iterate(seed,(i)->i<=15,(i)->i+1)
                .map((i)->"B"+i);

        seed +=15;

        Stream<String> streamI =
                Stream.iterate(seed,(i)->i+1)
                .limit(15)
                .map((i)->"I"+i);



        seed +=15;
        int nSeed = seed;

        String[] oLabels = new String[15];
        Arrays.setAll(oLabels,(i)->"N"+(nSeed + i));
        Stream<String> streamN = Arrays.stream(oLabels);

        seed += 15;
        Stream<String> streamG = Stream.of("G46","G47","G48","G49","G50","G51","G52","G53","G54","G55","G56","G57","G58","G59","G60");

        streamG.forEach(System.out::println);

//        seed+=15;
//        counter=seed;
//        Stream<String> streamO = Stream.generate(()->"O"+counter++) // This is not safe because it creates side effect meaning , it directly modifies a static variable which maybe used else where
//                                       .limit(15);
//        streamO.forEach(System.out::println);

        seed+=15;
        int rSeed = seed;

        Stream<String> streamO  = Stream.generate(Main::getCounter) // This approach is better because,  it doesn't alter a shared mutable state in this case the counter
                // and since streams are supposed to be functional this better also this makes it thread safe and using a separate counter logic instead directly using the counter variable makes this code cleaner
                .limit(15)
                .map((e)->"O"+(rSeed+e));

        streamO.forEach(System.out::println);


    }

    public static int  getCounter()
    {
        return counter++;
    }
}
