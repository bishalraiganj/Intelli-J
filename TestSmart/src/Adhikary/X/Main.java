package Adhikary.X;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args)
    {
        Map<Long,Integer> map = new HashMap<> ();
        map.put(Long.valueOf(1),1);
        map.put(Long.valueOf(2),2);
        map.put(Long.valueOf(3),3);
        map.put(Long.valueOf(4),4);

        System.out.println(map.toString());


    }

}
