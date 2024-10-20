package Adhikary.X;

import java.util.*;

class IdComparator implements Comparator<Cart> {

    public int compare(Cart i1, Cart i2)
    {
        return Integer.compare(i1.getId(),i2.getId());
    }


}

public class Store {
    private IdComparator idComparator = new IdComparator();
    private HashMap<Product,InventoryItem> inventory = new HashMap<>();



//    private Set<Cart> carts = new TreeSet<>(Comparator.comparing( ( o1)->o1.getId()));  Here , We have a lambda expression inside the comparing method which has the function functional interface as its parameter in its method signature

    private Set<Cart> carts = new TreeSet<>(Comparator.comparing(Cart::getId));

    private HashMap<Product,InventoryItem> aisleInventory  = new HashMap<>();

    public Store(HashMap<Product,InventoryItem> inventory,HashMap<Product,InventoryItem> aisleInventory,Set<Cart> carts)
    {
        this.inventory = inventory;
        this.aisleInventory = aisleInventory;
        this.carts = carts;
    }

    public void  manageStoreCarts(Cart c)
    {
        if(carts.contains(c))
        {
            System.out.println("Manage Cart : "+ c.getId()+"\n Press 1.Add Cart \n 2.Remove From Cart");
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            if(input == 1)
            {
                System.out.println("Enter the product name");
                String productName = s.next
            }

            carts.ceiling(c);
        }


    }


}
