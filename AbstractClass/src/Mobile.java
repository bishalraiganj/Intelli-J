public class Mobile extends ProductForSale {

    public Mobile(String type,double price,String description,int productCount)
    {

        super(price,description,productCount);
    }
    public void showDetails()
    {
        System.out.printf("""
                
                Product Type :%s
                Product Price :%f INR
                Product Title :%s
                Quantity :%i
                
                """,super.getType(),super.getPrice(),super.getDescription(),super.getProductCount());


    }



}
