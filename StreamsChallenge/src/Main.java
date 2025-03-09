import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {


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





    }
}
