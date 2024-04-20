import java.util.ArrayList;

public class Store {

  private static   ArrayList<Products> pList=new ArrayList<>();
  private static  ArrayList<OrderItem> list=new ArrayList<>();

public static void main(String... args)
{
pList.add(new Lenovo("Zenfone 9S Pro","launched in 2008",5000));
pList.add(new Lenovo ("Zenfone 10","Launched in 2009",57000));
pList.add(new Apple("Iphone 16 pro max","Apple a18 pro chip",167000));
listProducts();

}

public static  void listProducts()
{
    for(var item:pList)
    {
        System.out.println("-".repeat(30));
        item.showDetails();


    }
}
}
