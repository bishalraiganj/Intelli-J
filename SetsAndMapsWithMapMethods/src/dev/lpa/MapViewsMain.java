package dev.lpa;

import java.util.*;

public class MapViewsMain {

    public static void main(String[] args)
    {

        Map<String,Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach((c)->contacts.put(c.getName(),c));
        ContactData.getData("email").forEach((c)->contacts.put(c.getName(),c));

        Set<String> keysView  = contacts.keySet();
        System.out.println(keysView);

        System.out.println("-".repeat(40));
        keysView.forEach((System.out::println));

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if(contacts.containsKey("Linus Van Pelt"))
        {
            System.out.println("Linus and I go way back, so of course I have info");
        }

        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k,v)->System.out.println(v));


        System.out.println("\n\nPrinting copy of keys created by creating a" +
                "new TreeSet object\n\n");
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k,v)->System.out.println(v));

        keysView.retainAll(List.of("Linus Van Pelt","Charlie Brown","Robin Hood","Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k,v)->System.out.println(v));

        keysView.clear();
        System.out.println(contacts);

        ContactData.getData("phone").forEach((c)->contacts.put(c.getName(),c));
        ContactData.getData("email").forEach((c)->contacts.put((c).getName(),c));
        System.out.println(keysView);

        var values = contacts.values();
        values.forEach((System.out::println));


        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v)-> System.out.println(v));

        System.out.println("-".repeat(40));
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c->System.out.println(c.getNameLastFirst()+": "+c));

        System.out.println("-".repeat(40));
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(),first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        System.out.println("-".repeat(50));
        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if(set.size()<contacts.keySet().size())
        {
            System.out.println("Duplicate Values are in my map");
        }

        System.out.println("-".repeat(50));
        System.out.println(contacts.keySet().size());
        var nodeSet = contacts.entrySet();
        for(Map.Entry<String,Contact> entry : nodeSet )
        {
            System.out.println(nodeSet.getClass().getName());
            if(!(entry.getKey().equals(entry.getValue().getName())))
            {
                System.out.println(entry.getClass().getName());
                System.out.println("Key doesnt match name : "+ entry.getKey()
                + ": "+entry.getValue());
            }


        }
    }
}
