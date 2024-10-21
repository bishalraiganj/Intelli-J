package Adhikary.X;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Comparable<Cart> {

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

        if(products.containsKey(p)) {

            products.put(p, products.get(p) + qty);
            System.out.println("Added to the Cart \n " + this); // here "this" keyword refers to the current instance and printing the current instance means implicitly invoking the Overriden toString on the cart instance
            p.reserveItem(qty);
            if (p.getQtyTotal() - p.getQtyReserved() <= p.getQtyLow())
            {
                p.placeInventoryItem(p.getQtyReorder());
            }

        }

        else
            products.putIfAbsent(p,qty);
            System.out.println("Added to the Cart \n "+this);

            p.reserveItem(qty);
            if (p.getQtyTotal() - p.getQtyReserved() <= p.getQtyLow())
           {
             p.placeInventoryItem(p.getQtyReorder());
           }

    }

    public void removeItem(InventoryItem p,int qty)
    {
        if(products.containsKey(p))
        {
            products.put(p,products.get(p)-qty);
            System.out.println("Removed From the Cart "+p.getProduct().getName()+ " x"+qty+" \n"+this);
            p.releaseItem(qty);
            System.out.println("\n"+this);
        }
        else
            System.out.println("Product is not in the cart");

    }

//    public void printSalesSlip()
//    {
//
//        products.forEach((k,v)->System.out.println(  k.getName() + "( " + k.getSku() + " )" + " x"+ v + " = %f".formatted(v*(k.)
//
//    }

    @Override
    public boolean equals(Object o)
    {
        Cart c = (Cart) o;
       return this.id==c.getId();
    }

    @Override
    public String toString()
    {
        System.out.println("Cart ID:"+id+"\n Products in The Cart : \n");
        products.forEach((k,v)->System.out.println(k.getProduct().getName()+" Quantity x"+v));
        return "Date Created:" +date+"\n Type :"+type;

    }

    @Override
    public int compareTo(Cart c)
    {

        return this.date.compareTo(c.getDate());
    }


}
