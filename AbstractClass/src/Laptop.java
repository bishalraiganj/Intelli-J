public class Laptop extends ProductForSale{

    public Laptop(double price,String description,int productCount)
    {
        super(price,description,productCount);


    }
    public void showDetails()
    {
        System.out.printf("""
                
                Product Type :%s
                Product Price :%f INR
                Product Title :%s
                Quantity :%d
                
                """,super.getType(),super.getPrice(),super.getDescription(),super.getProductCount());


    }

}
