public class Customer {


    private String name;
    private double creditLimit;
    private String email;

    public String getName()
    {
        return name;
    }

    public double getCreditLimit() {

        return creditLimit;
    }

    public String getEmail() {

    return email;
    }
   public Customer(String name,double creditLimit,String email)
   {
       this.name=name;
       this.creditLimit=creditLimit;
       this.email=email;

   }
   public Customer() //second constructor off the class Customer
   {
       this("Bishal",200,"bishaladhikary@gmail.com");

   }
   public Customer(String name, String email)
   {

       this(name,900,email);
   }
}