package Adhikary.X;

import java.util.stream.IntStream;

public class Main {
    public static void main(String... args)
    {
        var  result = IntStream.iterate(0,(i)->i<=1000,(i)->i+3)
                .summaryStatistics();

        System.out.println("Results = "+result);

        var leapYearData = IntStream.iterate(2000,(i)->i<=2025,(i)->i+1)
                .filter((i)->i%4==0)
                .peek(System.out::println)
                .summaryStatistics();




    }
}
