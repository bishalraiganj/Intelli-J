import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < start + 15; i++) {
                bingoPool.add("" + c + i);
            }
            start += 15;
        }

        bingoPool.forEach(System.out::println);

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(50));

//        List<String> firstOnes = bingoPool.subList(0,15);
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
//      firstOnes.sort(null);// It still sorts by the natural order which is the override version of compareTo method when implementing the Comparable interface ,
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll((s) -> {
            if (s.indexOf('G') == 0 || s.indexOf('O') == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("\n" + "-".repeat(50));

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(50));

//        firstOnes.forEach(System.out::println);
//        bingoPool.forEach(System.out::println);

        var tempStream = bingoPool.stream()
                .limit(15)
                .filter((s) -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map((s) -> s.charAt(0) + "-" + s.substring(1))
                .sorted();

        tempStream.forEach((s) -> System.out.print(s + " "));
//                .forEach((s)->System.out.print(s + " "));

        System.out.println("\n" + "-".repeat(50));

//        for(int i = 0; i< 15 ; i++)
//        {
//            System.out.println(bingoPool.get(i));
//        }


        String[] strings = {"One", "Two", "Three"};
        var firstStream = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());
//                .forEach(System.out::println)

//        System.out.println("-".repeat(50));

        var secondStream = Stream.of("Six", "Five", "Four")
                .map(String::toUpperCase);
//                .forEach(System.out::println);

        Stream.concat(secondStream, firstStream)
                .map((s) -> s.charAt(0) + "-" + s)
                .forEach(System.out::println);

        System.out.println("-".repeat(50));

        Map<Character, int[]> myMap = new LinkedHashMap<>();
        int bingoIndex = 1;
        for (char c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, (i) -> i + labelNo);
            myMap.put(c, numbers);
            bingoIndex += 15;
        }

        myMap.forEach((k, v) -> System.out.println(k + "->" + Arrays.toString(v)));

        System.out.println("-".repeat(50));

        myMap.entrySet()
                .stream()
                .map((e) -> e.getKey() + " has range: " + e.getValue()[0] + " - " +
                        e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);


        Random random = new Random();
        Stream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach((s) -> System.out.print(s + " "));

        System.out.println();
        IntStream.iterate(1, (n) -> n + 1)
                .filter(Main::isPrime)
                .limit(20)
                .forEach((s) -> System.out.print(s + " "));

        System.out.println("\n"+"-".repeat(50));

        IntStream.iterate(1,(n)->n+1)
                .limit(100)
                .filter(Main::isPrime)
                .forEach((s)->System.out.print(s + " "));

        System.out.println("\n" + "-".repeat(50));

        IntStream.iterate(1,(n)-> n<=100, (n)->n+1)
                .filter(Main::isPrime)
                .forEach((s)->System.out.print(s + " "));

        System.out.println("\n" +  "-".repeat(50));

        IntStream.range(1,100)
                .filter(Main::isPrime)
                .forEach((s)->System.out.print(s + " "));

        System.out.println("\n" + "-".repeat(50));

        IntStream.rangeClosed(1,100)
                .filter(Main::isPrime)
                .forEach((s)->System.out.print(s + " "));


    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }

        }
        return true;
    }
}

