package bishal.adhikary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Map.Entry<String,Location> currentLocation;
        Scanner s = new Scanner(
                """
                        road ,   at  the end of the road ,W: hill ,E:well house ,S:valley ,N:forest
                        hill ,on top of hill with a view in all directions ,N:forest ,E:road
                        well house,inside a well house for a small spring,W:road,N:lake,S:stream
                        valley,   in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
                        forest,at the edge of a thick dark forest,S:road,E:lake
                        lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house 
                        stream,near a stream with a rocky bed,W:valley, N:well house
                        """);


//        System.out.println(passPlacesData(s));


        System.out.print("""
                                                                                               The   Colossal Cave Adventure game ReCreated by Bishal Adhikary
                                                                                                 
                                                                                                  Go through the cave and complete tasks and explore the cave 
                                                                                                 
                                                                                               """);
        if(currentLocation==)
        System.out.println(" \n                                                        You are on the Road ")


    }

    public static Map<String,Location>  passPlacesData(Scanner s) {
        Map<String, Location> locations = new HashMap<>();
        while (s.hasNext()) // it will look for tokens created with the default whitespace delimitter a space
        {

            String line = s.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length <= 6 && tokens.length >= 2) {
                Arrays.asList(tokens).replaceAll(String::trim);
//                System.out.println(Arrays.toString(tokens));
//                System.out.println(tokens[1]);
                Map<Character, String> neighbouringLocations = new HashMap<>();
                for (int i = 2; i >= 2 && i < tokens.length; i++) {
                    String[] directionsAndPlaces = tokens[i].split(":");
                    Arrays.asList(directionsAndPlaces).replaceAll(String::trim);
                    neighbouringLocations.putIfAbsent(directionsAndPlaces[0].charAt(0), directionsAndPlaces[1]);


                }
                locations.putIfAbsent(tokens[0], new Location(tokens[1], neighbouringLocations));

            } else {
                System.out.println("Somethings wrong with the structure of the  places data ");
                return null;
            }

        }
        if (!locations.isEmpty())
        {
            return locations;
        }
/*
        System.out.println(Arrays.asList(t).forEach(Arrays.asList(t).indexOf(m));
*/
        System.out.println("Something  is wrong with the structure of the places data");
        return null;


    }



    public static Map<String,Location> passPlacesData(String    placesData)

    {
        Map<String, Location> locations = new HashMap<>();
        Scanner s = new Scanner(placesData);
        while (s.hasNext()) // it will look for tokens created with the default whitespace delimitter a space
        {

            String line = s.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length <= 6 && tokens.length >= 2) {
                Arrays.asList(tokens).replaceAll(String::trim);
//                System.out.println(Arrays.toString(tokens));
//                System.out.println(tokens[1]);
                Map<Character, String> neighbouringLocations = new HashMap<>();
                for (int i = 2; i >= 2 && i < tokens.length; i++) {
                    String[] directionsAndPlaces = tokens[i].split(":");
                    Arrays.asList(directionsAndPlaces).replaceAll(String::trim);
                    neighbouringLocations.putIfAbsent(directionsAndPlaces[0].charAt(0), directionsAndPlaces[1]);


                }
                locations.putIfAbsent(tokens[0], new Location(tokens[1], neighbouringLocations));

            } else {
                System.out.println("Somethings wrong with the structure of the  places data ");
                return null;
            }

        }
        if (!locations.isEmpty())
        {
            return locations;
        }
/*
        System.out.println(Arrays.asList(t).forEach(Arrays.asList(t).indexOf(m));
*/
        System.out.println("Something  is wrong with the structure of the places data");
        return null;

    }

    }





