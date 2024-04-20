public class samsung extends Products{

   public samsung(String type, String description, double price)
   {
       super(type,description,price);

   }


    public void showDetails()
    {


        System.out.printf("""
    
       Samsung Phone Model :%s
       Price :%7f
       Specs :  %s
    
    
    """,type,price,description);


    }


}
