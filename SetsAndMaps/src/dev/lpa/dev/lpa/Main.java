package dev.lpa.dev.lpa;

import java.util.Collection;

public class Main {

    public static void main(String... args)
    {


        printData("phone data",ContactData.getData("phone"));




    }

    public static void printData(String header, Collection<Contact> contacts)
    {
        System.out.println("-".repeat(34));
        System.out.println(header);
        System.out.println("-".repeat(34));
        contacts.forEach(System.out::println);



    }

}
