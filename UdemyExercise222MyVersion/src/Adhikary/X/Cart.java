package Adhikary.X;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private int id;
    Map<Product,Integer> products = new HashMap<>();
    LocalDate date ;
    String Type;

    public void addItem(Product p , int qty)
    {
        products.put(p,qty);
    }

    public void removeItem(Product p)
    {
        products.remove(p);
    }

    public void printSalesSlip()
    {


        products.forEach((k,v)->System.out.println(  k.getName() + "( " + k.getSku() + " )" + " x"+ v + " = %f".formatted(v*(k.)




    }
}
