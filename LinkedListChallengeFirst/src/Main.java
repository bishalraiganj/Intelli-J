public class Main {
    public static void main(String[] args)
    {
        MobilePhone phone1=new MobilePhone("6297609615");
        phone1.addNewContact(new Contact("her","123"));

        phone1.addNewContact(new Contact("her2","1223"));
        phone1.updateContact(new Contact("ht","123"),new Contact("   updated contact","1111"));
        phone1.addNewContact(new Contact("Bishal","62975"));
 System.out.println(phone1.myContacts);
 phone1.removeContact(new Contact("Bishal","62975"));
 System.out.println(phone1.myContacts);

 System.out.println(phone1.findContact(new Contact("her2","123")));
 phone1.findContact("her2");
 phone1.printContacts();
    }

}
