package dev.lpa.dev.lpa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {

   private String name;
   private Set<String> emails = new HashSet<>();
   private Set<String> phones = new HashSet<>();

   public Contact(String name)
   {
       this(name,null);

   }

   public Contact(String name,String email)
   {

       this(name,email,0);

   }

   public Contact(String name,long phone)
   {

    this(name,null,phone);

   }

   public Contact(String name,String email,long phone)
   {
       this.name = name;
       if(email!=null)
       this.emails.add(email);
       if(phone>0)
       {
           String p=String.valueOf(phone);
           this.phones.add("(%s) %s-%s".formatted(p.substring(0,3),p.substring(3,6),p.substring(6)));

       }
   }

    public String getName()
    {
        return name;

    }

    @Override
    public String toString()
    {
        return "%s: %s %s".formatted(name,emails,phones);
    }

    public Contact mergeContactData(Contact contact)
    {

        Contact newContact = new Contact(name);
        newContact.emails.addAll(this.emails);
        newContact.phones.addAll(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);
         return newContact;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return 33*getName().hashCode();
    }

    public void addEmail(String companyName)
    {
        String[] names = this.name.split(" ");

        String e= "%c%s@%s.com".formatted(names[0].charAt(0),names[names.length-1],companyName.replaceAll(" ","").toLowerCase());

        if(!emails.add(e))
        {
            System.out.println(name +" Already has email "+e);
        }
        else
            System.out.println(name+" now has email "+e);
    }

    public void replaceEmailIfExists(String oldEmail,String newEmail)
    {
        if(emails.contains(oldEmail))
        {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }



    }









}
