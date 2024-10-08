package dev.lpa;

import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        Theatre bishalsScreen = new Theatre("bishalsScreen",6,30);
//        bishalsScreen.seatSet.add(new Theatre.Seat("B0019"));
        bishalsScreen.seatSet.forEach(System.out::println);
        System.out.println("-".repeat(50));
        bishalsScreen.printSeatMap();
        System.out.println("\n"+"-".repeat(50));
        BookingAgent bishal = new BookingAgent(bishalsScreen,'E',24);
        bishalsScreen.printSeatMap();
        bishalsScreen.seatSet.ceiling(new Theatre.Seat("B008")).setStatus(true);

        System.out.println("\n\n\n Before booking Multiple rows\n\n ");
        bishalsScreen.printSeatMap();

        System.out.println("\nafterMass booking\n"+"-".repeat(50));
        BookingAgent massBooking = new BookingAgent(bishalsScreen,"ABCDE",15);
        bishalsScreen.printSeatMap();
        System.out.println("\n"+"-".repeat(50));


    }

}
