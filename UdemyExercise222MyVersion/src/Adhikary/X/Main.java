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
        Product pumaBoot = new Product("P_S_01","Puma Star FG Boots","Puma","Shoe");
        Product samsungTablet = new Product("S_s10_SM8881","Samsung S10 Ultra","Samsung","Tablet");
        InventoryItem pumaShoes = new InventoryItem(pumaBoot,33,2,10,5,10999.0);
        InventoryItem samsungTabletS10 = new InventoryItem(samsungTablet,35,4,10,5,104999.0);
        InventoryItem nikeShoes = new InventoryItem(nikeBoots,34,0,10,5,10999.0);
        InventoryItem shoes = new InventoryItem(adidasBoot,23,0,10,5,3999.0);
        InventoryItem footballs = new InventoryItem(niviaFootball,45,10,10,5,899.0);
        Map<Product,InventoryItem> itemsInInventory = new HashMap<>();
        itemsInInventory.put(pumaBoot,pumaShoes);
        itemsInInventory.put(samsungTablet,samsungTabletS10);
        itemsInInventory.put(adidasBoot,shoes);
        itemsInInventory.put(niviaFootball,footballs);
        itemsInInventory.put(nikeBoots,nikeShoes);

        Map<InventoryItem,Integer> footballCartMap = new HashMap<>();
        footballCartMap.put(footballs,1);
        Cart footballCart= new Cart(1,footballCartMap, LocalDate.now(),"Virtual");
        Set<Cart> niviaDominatorCart = new TreeSet<>();
        niviaDominatorCart.add(footballCart);

        Map<Product,InventoryItem> aisleInventoryMap = new HashMap<>();

        Store bishalSportsStore = new Store(itemsInInventory,aisleInventoryMap,niviaDominatorCart);

        bishalSportsStore.listProductsByCategory();
//        bishalSportsStore.addToCartsSet(footballCart);
        bishalSportsStore.manageStoreCarts(new Cart(2,new HashMap<InventoryItem,Integer> (),LocalDate.now(),"Virtual"));






    }

}
