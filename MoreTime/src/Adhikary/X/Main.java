package Adhikary.X;

import java.time.ZoneId;

public class Main {

    static int counter = 0;
    public static void main(String... args)
    {

        System.out.println(ZoneId.systemDefault());

        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
        ZoneId.getAvailableZoneIds().stream()
                .filter((s)->s.startsWith("India"))
                .sorted()
                .map((s)->ZoneId.of(s))
                .peek((s)->++counter)
                .forEach((z)->System.out.println(z.getId() + ": " + z.getRules()));

        System.out.println("Indian Zone's Count = " + counter);




    }


}
