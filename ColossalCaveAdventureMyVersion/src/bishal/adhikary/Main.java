package bishal.adhikary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        Map<String,Location> locations = new HashMap<>();

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



         while(s.hasNext()) // it will look for tokens created with the default whitespace delimitter a space
        {

                String line = s.nextLine();
                String[] tokens = line.split(",");

                Arrays.asList(tokens).replaceAll(String::trim);
                System.out.println(Arrays.toString(tokens));
//                System.out.println(tokens[1]);

            }

/*
        System.out.println(Arrays.asList(t).forEacjArrays.asList(t).indexOf(m));
*/

        }







    }




