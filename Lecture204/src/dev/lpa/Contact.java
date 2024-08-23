package dev.lpa;


import java.lang.reflect.Array;
import java.util.Arrays;
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
        if(email!=null)
        this.emails.add(email);

    }
    public Contact(String name,long phone)
    {

        this.name = name;
        if(phone>0)
        this.phones.add( Long.toString(phone));

    }
    public Contact(String name,String email,long phone)
    {
        this.name = name;
        this.emails.add(email);

        this.phones.add(formatPhone(phone));
    }

    private String formatPhone(long phone)
    {
        int p=(int) phone;
        int size = Long.toString(phone).length();
        int[] digitArray = new int[size];
        for(int i=size-1;i>=0;i--)
        {
            digitArray[i]= (int) (p%10);
            p=p/10;

        }

        return "(%d%d%d) %d%d%d-%d%d%d%d".formatted(digitArray[0],digitArray[1],digitArray[2],digitArray[3],digitArray[4],digitArray[5],digitArray[6],digitArray[7],digitArray[8],digitArray[9]);


    }


    public String getName()
    {
        return name;

    }

    public String toString()
    {
        return " Name : %s \n Emails -%s \n Phones- %s".formatted(name,emails,phones);
    }

//    public Contact mergeContactData(Contact contact)
//    {
//
//
//
//    }












}
