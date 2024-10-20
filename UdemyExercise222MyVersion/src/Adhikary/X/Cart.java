package Adhikary.X;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private int id;
    private Map<InventoryItem,Integer> products = new HashMap<>();
    private LocalDate date ;
    private String type;

    public Cart(int id,Map<InventoryItem,Integer> products,LocalDate date, String type)
    {
        this.id = id;
        this.products = products;
        this.date = date;
        this.type = type;
    }

    public int getId()
    {
        return id;
    }

    private Map<InventoryItem,Integer> getProducts()
    {
        return products;
    }

    private LocalDate getDate()
    {
        return date;
    }

    private String type()
    {
        return type;
    }
    public void addItem(InventoryItem p, int qty)
    {

        if(products.containsKey(p)&&p.get)
        {
            System.out.println("A")
            products.put(p,qty);

        }


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
