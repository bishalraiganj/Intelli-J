package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-----------------------------");

        Map<String, Contact> contacts = new HashMap<>();

        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-----------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
                ));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-".repeat(50));
        for( String contactName : new String[] { "Daisy Duck","Daffy Duck","Scrooge McDuck"})
        {
            contacts.computeIfAbsent(contactName,(k)->new Contact(contactName));
        }
        contacts.forEach((k,v)->System.out.println("Key ="+ k + ", Value =" + v));

        System.out.println("-".repeat(50));
        for(String contactName:new String[] { "Daisy Duck","Daffy Duck","Scrooge McDuck"})
        {
            contacts.computeIfPresent(contactName,(k,v)->{ v.addEmail
                            ("Fun Place");  return v;});
        }
        contacts.forEach((k,v)->System.out.println("Key =" + k + ", Value "+ v));

        System.out.println("-".repeat(50));
        contacts.replaceAll((k,v)->{
            String newEmail = k.replaceAll(" ","");
            v.replaceEmailIfExists("DDuck@funplace.com",newEmail+"@funplace.com");
            return v;
        });

        contacts.forEach((k,v)-> System.out.println("Key = "+k + ",Value "+v));

        System.out.println("-".repeat(50));
        Contact daisy = new Contact("Daisy Jane Duck","daisyj@duck.com");

        Contact replacedContact = contacts.replace("Daisy Duck",daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k,v)->System.out.println("Key =" + k + ",Value" + v));

        System.out.println("-".repeat(50));
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("UpdatedDaisy =" + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck",daisy,
                updatedDaisy);
        if(success)
        {
            System.out.println("Successfully replaced element");
        }
        else
        {
            System.out.println("Did not match on both key: %s and value : %s %n".formatted("Daisy Duck",replacedContact));
        }
        contacts.forEach((k,v)->System.out.println("Key ="+k + ",Value="+v));

        System.out.println("-".repeat(50));
        success = contacts.remove("Daisy Duck",daisy);
        if(success)
        {
            System.out.println("Successfully removed element"+daisy);
        }
        else
            System.out.println("Did not match on both key :%s and value: %s %n".formatted("Daisy Duck",daisy));
            contacts.forEach((k,v)->System.out.println("key =" + k + ", value ="+ v));



    }

}
