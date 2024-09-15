package dev.lpa.dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] main)
    {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(50));

        Map<String,Contact> contacts = new HashMap<>();
        for(Contact contact : fullList)
        {
            contacts.put(contact.getName(),contact);
        }

        contacts.forEach((k,v)->System.out.println("Key=" + k + ", Value= " + v ));

        System.out.println("-".repeat(50));
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown",defaultContact));


        System.out.println("-".repeat(50));
        contacts.clear();
        for(Contact contact : fullList)
        {
            Contact duplicate = contacts.put(contact.getName(),contact);
            if(duplicate != null)
            {
//                System.out.println("Duplicate = " + duplicate);
//                System.out.println("Current = " + contact);
                contacts.put(contact.getName(),contact.mergeContactData(duplicate));
            }

        }

        contacts.forEach((k,v)->System.out.println("Key=" + k + ", Value= " + v ));

        System.out.println("-".repeat(50));
        contacts.clear();

        fullList.forEach(System.out::println);
        System.out.println("-".repeat(50));
        for(Contact contact : fullList)
        {
            contacts.putIfAbsent(contact.getName(),contact);
        }

        contacts.forEach((k,v)-> System.out.println("Key = " + k + ", Value  = "+v));

        System.out.println("-".repeat(50));
        contacts.clear();

        for(Contact contact : fullList)
        {
           Contact duplicate= contacts.putIfAbsent(contact.getName(),contact);
            if(duplicate !=null)
            {
                contacts.put(contact.getName(),contact.mergeContactData(duplicate));
            }
        }
        System.out.println("-".repeat(50));
        contacts.forEach((k,v)->System.out.println("Key = "+ k+ ", Value = "+ v));

        System.out.println("-".repeat(50));
        contacts.clear();

        fullList.forEach((contact)->contacts.merge(contact.getName(),contact,(previous,current)->
        {

            System.out.println("Prev : "+previous+ ": Current "+ current);
            Contact merged =contact.mergeContactData(previous);
            System.out.println("Merged : "+ merged);
            return merged;

        }
        ));

        System.out.println("-".repeat(50));
        contacts.clear();
        // The following is a reduced / succint version of the above code snippet

        fullList.forEach((contact)->contacts.merge(contact.getName(),contact,(previous,current)
        ->contact.mergeContactData(previous)));
        contacts.forEach((k,v)->System.out.println("Key : " + k+ ", Value :"+ v));

        //The following code snippet is another alternative of the above
        //with method reference in place of a lamba expression which is abstraction
        // of the implementation of the BiFucntion functional interface overriding its sam
        // with the following behaviour

        System.out.println("-".repeat(50));
        contacts.clear();

        fullList.forEach((contact)->contacts.merge(contact.getName(),contact,Contact::mergeContactData));
        contacts.forEach((k,v)->System.out.println("Key : "+ k + ", Value :"+ v));

        fullList.forEach((c)->System.out.println("-".repeat(40)+"\n"+"\nContact --->"+c+"\n"));




    }
}
