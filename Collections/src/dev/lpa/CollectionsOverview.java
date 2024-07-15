package dev.lpa;

import java.util.*;

public class CollectionsOverview {

    public static void main(String... main)
    {

        Collection<String> list = new TreeSet<>();

        String[] names = {"Anna","Bob","Carol","David","Edna"};
        list.addAll(Arrays.asList(names));

        System.out.println(list);

        list.add("Fred");

        list.addAll(Arrays.asList("George","Gary","Greece"));

        System.out.println(list);

        System.out.println("Is Gary in the list ?"+list.contains("Gary"));

        list.removeIf((s)->s.charAt(0) == 'G');

        System.out.println(list);

        System.out.println("Gary is in the list ?"+ list.contains("Gary"));




    }

}
