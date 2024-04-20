import java.util.ArrayList;

public class Store {
  private static  ArrayList<ProductForSale> aList=new ArrayList<>();

    public static void main(String[] args)
    {

        aList.add(new Laptop(800,"Lenovo Legion 5",1));
 aList.get(0).showDetails();
 listProducts();
 }
  public static void addItemToOrder(ProductForSale product)
    {
        aList.add(product);


    }
    public static void  listProducts()
    {
        for(var item:aList)
        {

            System.out.printf("_".repeat(30));
            item.showDetails();

        }

    }

}
