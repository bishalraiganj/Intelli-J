package Adhikary.X;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String... args)
    {
        Product adidasBoot= new Product("A_FG_01","Adidas FG Predator","Adidas","Shpoes");
        Product niviaFootball = new Product("N_D_01","Nivia Dominator Football","Nivia","Football");
        InventoryItem shoes = new InventoryItem(adidasBoot,23,0,10,5,3999.0);
        InventoryItem footballs = new InventoryItem(niviaFootball,45,10,10,5,899.0);
        Map<Product,InventoryItem> itemsInInventory = new HashMap<>();
        itemsInInventory.put(adidasBoot,shoes);
        itemsInInventory.put(niviaFootball,footballs);




    }

}
