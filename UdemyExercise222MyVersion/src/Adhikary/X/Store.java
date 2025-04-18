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
    private Map<Product, InventoryItem> inventory ;
//    private Set<Cart> carts = new TreeSet<>(Comparator.comparing( ( o1)->o1.getId()));  Here , We have a lambda expression inside the comparing method which has the function functional interface as its parameter in its method signature

    private Set<Cart> carts ;

    private Map<Product, InventoryItem> aisleInventory ;

    public Store(Map<Product, InventoryItem> inventory, Map<Product, InventoryItem> aisleInventory, Set<Cart> carts) {
        this.inventory = inventory;
        this.aisleInventory = aisleInventory;
        this.carts = new TreeSet<>(Comparator.comparing(Cart::getId));
        this.carts.addAll(carts);
        carts.forEach((e)->{

           e.getProducts().forEach(InventoryItem::reserveItem);


        });
        System.out.println(carts+"\n\n");
    }

    public void addToCartsSet(Cart cart)
    {
        carts.add(cart);
    }

    public void manageStoreCarts(Cart c) {
        Scanner s = new Scanner(System.in);
        if (carts.contains(c)) {
            System.out.println("Cart Already Exists! \n Manage Cart : " + c.getId() + "\n Press 1.Add Cart \n       2.Remove From Cart");

            int input = s.nextInt();
            if (input == 1) {
                System.out.print("Enter the product name \n");
                s.nextLine();
                String productName = s.nextLine();
                int productAvailabilityCounter = 0;
                for (InventoryItem item : inventory.values()) {
                    if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                        System.out.println("Product is Available in the Store \n " +
                                "Current Stocks :" + (item.getQtyTotal() - item.getQtyReserved()));
                        System.out.println("Enter The Quantity to add \n");
                        int qty = s.nextInt();
                        s.nextLine();
                        if (item.getQtyTotal() - item.getQtyReserved() >= qty) {

                            System.out.println("In Stock, Adding to Your Cart");
                            c.addItem(item, qty);
                        }
                        productAvailabilityCounter++;

                    }
                    if(productAvailabilityCounter==1)
                    {
                        break;
                    }

                }

                if(productAvailabilityCounter==0)
                {
                    System.out.println("Product not Found ! NOT IN STORE\n");

                }



//                int productAvailabilityCounter =0;
//                inventory.forEach((k,v)->{if(v.getProduct().getName().equalsIgnoreCase(productName))
//                {
//
//                    System.out.println("Product is Available in the Store \n " +
//                                "Current Stocks :" + (v.getQtyTotal() - v.getQtyReserved()));
//                    System.out.println("Enter the Quantity to add");
//                        int qty = s.nextInt();
//                        s.nextLine();
//                        if(v.getQtyTotal() - v.getQtyReserved() >= qty) {
//
//                            System.out.println("In Stock, Adding to Your Cart");
//                            c.addItem(v, qty);
//
//
//
//                }
//
//
//                }
//
//                });
//
//
//                System.out.println(" Product not found");

            } else if (input == 2) {
                System.out.println("Enter the product name ");
                s.nextLine();
                String productName = s.nextLine();
                int productAvailabilityCounter = 0;
                for (InventoryItem item : inventory.values()) {
                    if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                        System.out.println("Product is in the Store\n Enter the quantity to remove from the cart");

                        int qty = s.nextInt();
                        s.nextLine();
                        if(c.getProducts().get(item)>=qty&&c.getProducts().get(item)!=0)
                        {
                            c.removeItem(item, qty);
                        }
                        else
                        {
                        System.out.println("Cart Doesnt contain enough Quantity to be removed");
                        }

                        productAvailabilityCounter++;
                    }
                    if(productAvailabilityCounter==1)
                    {
                        break;
                    }
                }
                if(productAvailabilityCounter==0)
                {
                    System.out.println("Product Not Found ! NOT IN STORE");
                }

            } else {
                System.out.println("Select from the correct options");
            }


        } else {
            System.out.println("Cart not found ! Want to add the cart and Manage Y/N ?");


            if (s.nextLine().equalsIgnoreCase("y")) {

                carts.add(c);
                System.out.println(" \n Manage Cart : " + c.getId() + "\n Press 1.Add Cart \n");

                int input = s.nextInt();
                s.nextLine();
                if (input == 1) {
                    System.out.println("Enter the product name");
                    String productName = s.nextLine();
                    int counterForProductAvailability=0;
                    for (InventoryItem item : inventory.values()) {

                        if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                            System.out.println("Product is Available in the Store \n " +
                                    "Current Stocks :" + (item.getQtyTotal() - item.getQtyReserved()));
                            System.out.println("Enter the Quantity to add \n");
                            int qty = s.nextInt();
                            s.nextLine();
                            if (item.getQtyTotal() - item.getQtyReserved() >= qty) {

                                System.out.println("In Stock, Adding to Your Cart");
                                c.addItem(item, qty);


                            }
                            counterForProductAvailability++;
                        }
                        if(counterForProductAvailability==1)  //we have the following code snippet because the advanced for loop used in its enclosing code uses inventory.values() which returns a collection that may have duplicate values because inventory is a hashMap where only keys are unique
                        // so in inventory there can be duplicate values  , we used this if condition to fix repeating the entire enclosing code inside the for loop by returning control once a match is found, the loop counter is altered and the control is returned from the for loop
                        {
//                        return;
                            break;
                        }
                    }

                    if(counterForProductAvailability==0)
                    {
                        System.out.println("Product not found ! Not in Store");
                    }


                } else if (input == 2) {
                    System.out.println("Enter the product name ");
                    String productName = s.nextLine();
                    for (InventoryItem item : inventory.values()) {
                        if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                            System.out.println("Product is in the Store\n Enter the quantity to remove from the cart");
                            int qty = s.nextInt();

                            c.removeItem(item, qty);
                        }
                    }
                }
            }

        }





    }


    public void listProductsByCategory()
    {


//        System.out.println("INVENTORY\n"+inventory);

        Map<Product,InventoryItem> sortedInventory = new TreeMap<>(inventory);
//        System.out.println("\n\n This is the Sorted Inventory\n\n"+sortedInventory+"\n\n");
        sortedInventory.forEach((k,v)->{System.out.print("Product\n"+k +"\nStock\n" + v+"\n\n\n");});



    }

    public void checkOutCart()
    {
        carts.forEach(System.out::println);

        System.out.println("Enter the Cart ID to check out");
        Scanner s= new Scanner(System.in);
        int input=s.nextInt();
        s.nextLine();

        carts.forEach((e)->{
            if(e.getId()==input)
            {
                System.out.println("Initiating CHECK OUT ......");
                e.getProducts().forEach(InventoryItem::sellItem);
            }
        });
    }

    public void abandonCarts()
    {
        System.out.println("Enter the Cart ID to abandon");
        Scanner s = new Scanner(System.in);
        int input= s.nextInt();
        s.nextLine();
        carts.forEach((e)-> {


            if (e.getId() == input) {
                carts.remove(e);
                System.out.println("Cart is abandonded");




            }


        });


    }

}
