package dev.lpa;

import java.util.HashSet;
import java.util.Set;

public class Contact {

    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();


    public Contact(String name)
    {
        this.name = name;

    }
    public Contact(String name,String email)
    {
        this.name =name;
        this.emails.add(email);

    }
    public Contact(String name,long phone)
    {
        this.name = name;
        this.phones.add(Long.toString(phone));
    }
    public Contact(String name,String email,long phone)
    {
        this.name = name;
        this.emails.add(email);
        this.phones.add(Long.toString(phone));
    }


    public String getName()
    {
        return name;

    }

    public String toString()
    {
        return "";
    }

    public Contact mergeContactData(Contact contact)
    {



    }












}
