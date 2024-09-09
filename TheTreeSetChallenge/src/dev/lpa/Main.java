package dev.lpa;

import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        Theatre bishalsScreen = new Theatre("bishalsScreen",5,25);
        bishalsScreen.seatSet.add(new Theatre.Seat("B0019"));
        bishalsScreen.seatSet.forEach(System.out::println);

    }

}
