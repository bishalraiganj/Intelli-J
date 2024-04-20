import java.util.*;
public class MobilePhone {

    private String myNumber;
    ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact1)
    {
   for(int i=0;i<myContacts.size();i++)
   {
        if(Integer.parseInt(contact1.getPhoneNumber())==Integer.parseInt(myContacts.get(i).getPhoneNumber()))
       {
           return true;
       }
        }
   myContacts.add(contact1);
       return false;
    }

    public boolean updateContact(Contact pContact, Contact uContact) {
       for(int i=0;i<myContacts.size();i++)
       {
           if(pContact.getPhoneNumber()==myContacts.get(i).getPhoneNumber())
           {
               myContacts.set(i,uContact);
               return true;
           }
       }
       return false;
    }

    public boolean removeContact(Contact contact) {
     for(int i=0;i<myContacts.size();i++)
     {
         if(contact.getPhoneNumber()==myContacts.get(i).getPhoneNumber())
         {
             myContacts.remove(i);


         }


     }
        return false;
    }

    public int findContact(Contact contact) {
       for(Contact i:myContacts)
       {
           if(contact.getName()==i.getName())
           {
               return myContacts.indexOf(i);
           }

       }
        return -1;
    }

public void findContact(String contact)
{
for(Contact i:myContacts)
{   if(contact==i.getName())
{
   System.out.println("It found the Contact @"+myContacts.indexOf(i));
}
}
}
public Contact queryContact(String name)
{
for(Contact i:myContacts)
{
    if(name==i.getName())
    {
        return i;

    }




}
    return new Contact();

}
public void printContacts()
{

    System.out.printf("""
            Contact List:
            """);
    for(Contact i:myContacts)
    {
        System.out.println((myContacts.indexOf(i)+1)+". "+i.getName()+" -> "+i.getPhoneNumber());

    }
}

}



class Contact
{
 private  String name;

 private  String phoneNumber;
 public Contact()
 {

 }
 public Contact(String name, String phoneNumber)
 {
     this.name=name.trim();
     this.phoneNumber=phoneNumber.trim();
 }
 public String getName()
 {

     return name;

 }
public String getPhoneNumber()
{
    return phoneNumber;

}
public static Contact createContact(String name,String phoneNumber)
{
    return new Contact(name,phoneNumber);

}
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}