package bishal.adhikary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Map<Character,String> hashMapForTheRoad = new HashMap<>();
        hashMapForTheRoad.put('W',"hill");
        hashMapForTheRoad.putIfAbsent('E',"well house");
        hashMapForTheRoad.putIfAbsent('S',"valley");
        hashMapForTheRoad.putIfAbsent('N',"forest");
        Location currentLocation=new Location("at  the end of the road",hashMapForTheRoad);
        String currentLocationKey = "road";
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

        Map<String,Location> locationsHashMap = passPlacesData(s);
        System.out.print("""
                                                                                               
                                                                                               
                                                                                           
                                                                                               The   Colossal Cave Adventure game ReCreated by Bishal Adhikary
                                                                                                 
                                                                                                  Go through the cave and complete tasks and explore the cave 
                                                                                                 
                                                                                               """);
        if(currentLocationKey=="road") {


            System.out.println(" \n                                       :::::::: You are on the Road :::::::::  \n" +"                                       Choose from the following directions to go  \n                 " +
                    "             Enter W for West , E for East , N for North and S for South \n ");
        }

       Map<Character,String> cLocation = locationsHashMap.get("road").getNextPlace();

        while(!cLocation.isEmpty()) {
            System.out.println("                                     Current Location : %s \n                        ------------- %s --------------- ".formatted(currentLocationKey,locationsHashMap.get(currentLocationKey).getDescription()));
            for (Map.Entry<Character, String> entry : cLocation.entrySet()) {
                String d = entry.getValue();
                char c = entry.getKey();
                String direction = switch (c) {
                    case 'W' -> "West";
                    case 'E' -> "East";
                    case 'N' -> "North";
                    case 'S' -> "South";

                    default -> null;
                };


                System.out.println("%s goes to: %s ".formatted(direction, d));
            }

            System.out.println("                                        Enter the the direction to go to   ");

            Scanner directionInput = new Scanner(System.in);
            String inputString= directionInput.nextLine();
            char inputChar = inputString.toUpperCase().charAt(0);
            if(inputChar=='Q')
            {
                return;
            }
            currentLocationKey = cLocation.get(inputChar);
            cLocation=locationsHashMap.get(currentLocationKey).getNextPlace();

        }



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





