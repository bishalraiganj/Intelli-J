package Adhikary.X;

import java.util.*;

class IdComparator implements Comparator<Cart> {

    public int compare(Cart i1, Cart i2)
    {
        return Integer.compare(i1.getId(),i2.getId());
    }


}

public class Store {
//    private IdComparator idComparator = new IdComparator();
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
        Scanner s = new Scanner(System.in);
        if(carts.contains(c))
        {
            System.out.println("Cart Already Exists! \n Manage Cart : "+ c.getId()+"\n Press 1.Add Cart \n 2.Remove From Cart");

            int input = s.nextInt();
            if(input == 1)
            {
                System.out.println("Enter the product name");
                String productName = s.nextLine();
                for(InventoryItem item: inventory.values() )
                {
                    if(item.getProduct().getName().equalsIgnoreCase(productName))
                    {
                        System.out.println("Product is Available in the Store \n " +
                                "Current Stocks :"+(item.getQtyTotal()-item.getQtyReserved()));
                        int qty =s.nextInt();
                        if(item.getQtyTotal()-item.getQtyReserved()>=qty)
                        {

                            System.out.println("In Stock, Adding to Your Cart");
                            c.addItem(item,qty);


                        }
                    }
                }
                System.out.println(" Product not found");

            }
            else if(input ==2)
            {
                System.out.println("Enter the product name ");
            }
            else
            {
                System.out.println("Select from the correct options");
            }


        }
        else
            System.out.println("Cart not found ! Want to add the cart and Manage Y/N ?");
            carts.add()


    }


}