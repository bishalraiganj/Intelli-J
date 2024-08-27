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

        int index =emailContacts1.indexOf(new Contact("Robin Hood"));
        Contact robinHood=emailContacts1.get(index);
        robinHood.addEmail("Sherwood Forests");
        robinHood.addEmail("Sherwood Forests");
        robinHood.replaceEmailIfExists("RHood@sherwoodforests.com","RHood@sherwoodforests.org");

        System.out.println(robinHood);

        Set<Contact> unionAB =  new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData(" (A \u222a B) Union of emails (A) with phones (B)",unionAB);

        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A \u2229 B) Intersect emails (A) with phones (B) ",intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B \u2229 A) Intersect phones (B) with emails (A)",intersectBA);

        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)",AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printData("(B - A) phones (B) - emails (A)",BMinusA);

        Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData(" Symmetric difference: phones and emails",symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric difference: phones and emails",symmetricDiff2);






    }

    public static void printData(String header, Collection<Contact> contacts)
    {


        System.out.println("-".repeat(34));
        System.out.println(header);
        System.out.println("-".repeat(34));
        contacts.forEach(System.out::println);



    }

}
