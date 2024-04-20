public class Lenovo extends Products{

   public  Lenovo(String type,String description,double price)
   {
       super(type,description,price);

   }


    public void showDetails()
    {

        System.out.printf("""
    
       Lenovo Phone Model :%s
       Price :%7f
       Specs :   %s
    
    
    """,type,price,description);


    }


}
