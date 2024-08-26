package dev.lpa.dev.lpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String... args)
    {


        printData("phone data",ContactData.getData("phone"));

        List<Contact>  phoneContacts1 = ContactData.getData("phone");
        List<Contact>  emailContacts1 = ContactData.getData("email");

        Set<Contact> phoneContacts = new HashSet<>(phoneContacts1);
        Set<Contact> emailContacts = new HashSet<>(emailContacts1);

        printData("Phone Contacts",phoneContacts);
        printData("Email Contacts",emailContacts);



    }

    public static void printData(String header, Collection<Contact> contacts)
    {
        System.out.println("-".repeat(34));
        System.out.println(header);
        System.out.println("-".repeat(34));
        contacts.forEach(System.out::println);



    }

}
