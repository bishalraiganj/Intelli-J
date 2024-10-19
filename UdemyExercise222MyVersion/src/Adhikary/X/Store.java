package Adhikary.X;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

class IdComparator implements Comparator<Cart> {

    public int compare(Cart i1, Cart i2)
    {
        return Integer.compare(i1.getId(),i2.getId());
    }


}

public class Store {
    private IdComparator idComparator = new IdComparator();
    private HashMap<Product,InventoryItem> inventory = new HashMap<>();
    private Set<Cart> carts = new TreeSet<>(idComparator);




}
