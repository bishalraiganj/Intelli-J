public class Apple extends Products{

   public Apple(String type, String description, double price)
   {
       super(type,description,price);

   }


    public void showDetails()
    {


        System.out.printf("""
    
       Apple Phone Model :%s
       Price :%7f
       Specs :  %s
    
    
    """,type,price,description);



    }


}
