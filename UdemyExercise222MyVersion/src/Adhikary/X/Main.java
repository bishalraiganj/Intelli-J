package Adhikary.X;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String... args)
    {
        Product adidasBoot= new Product("A_FG_01","Adidas FG Predator","Adidas","Shoe");
        Product nikeBoots = new Product("N_T_01","Nike Tiempo Legend","Nike","Shoe");
        Product niviaFootball = new Product("N_D_01","Nivia Dominator Football","Nivia","Football");
        InventoryItem nikeShoes = new InventoryItem(nikeBoots,34,0,10,5,10999.0);
        InventoryItem shoes = new InventoryItem(adidasBoot,23,0,10,5,3999.0);
        InventoryItem footballs = new InventoryItem(niviaFootball,45,10,10,5,899.0);
        Map<Product,InventoryItem> itemsInInventory = new HashMap<>();
        itemsInInventory.put(adidasBoot,shoes);
        itemsInInventory.put(niviaFootball,footballs);
        itemsInInventory.put(nikeBoots,nikeShoes);

        Map<InventoryItem,Integer> footballCartMap = new HashMap<>();
        footballCartMap.put(footballs,1);
        Cart footballCart= new Cart(1,footballCartMap, LocalDate.now(),"Virtual");
        Set<Cart> niviaDominatorCart = new TreeSet<>();

        Map<Product,InventoryItem> aisleInventoryMap = new HashMap<>();

        Store bishalSportsStore = new Store(itemsInInventory,aisleInventoryMap,niviaDominatorCart);

        bishalSportsStore.listProductsByCategory();





    }

}
