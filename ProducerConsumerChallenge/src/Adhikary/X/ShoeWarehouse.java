package Adhikary.X;

import java.util.*;

public class ShoeWarehouse {

  public static Map<Shoe, Long> products = new TreeMap<>(); //Inventory in the warehouse


  private List<Order> orderQueue = new LinkedList<>(); /*In this case LinkedList is faster because we are accessing
  the first element so for retrieval traversal is almost o(1) fast and since we do not have to shift because of modification/mutation (only updating links)
  updating links is o(1) fast as well so overall in this case LinkedList is faster than ArrayList
  */

  private final static int MAX_CAPACITY = 10;


  private static boolean status = false;

  public boolean getStatus()
  {
    return status;
  }

  public synchronized void setStatus() /* it is a flag to inform the order fullfiller thread
  that all orders are added and now you can finish
  */
  {
    status = true;
    notifyAll();
  }


  public synchronized void receiveOrder(Order order)
  {


    if(orderQueue.size() >= MAX_CAPACITY)
    {
      System.out.println("Cannot add more Orders , Warehouse capacity reached");
    }


  while(orderQueue.size() >= MAX_CAPACITY )
  {





    try {

      wait();

    }catch(InterruptedException e)
    {
      e.printStackTrace();
    }

  }
  if(products.get(order.shoeType()) >= order.quantity() )

  {
    orderQueue.add(order);
    long available = products.get(order.shoeType());
    products.compute(order.shoeType(),(key,val)->{

      return (val==null) ? 0L : available - order.quantity();
    });
    System.out.println("Added to orderQueue : " + order);
  }
  else
  {
    if(products.get(order.shoeType()) < order.quantity())
    {
      System.out.println("Not enough products in stock : Available -> " + products.get(order.shoeType()) + " Requested -> " + order.quantity());
    }

  }


  notifyAll();


  }





  public  synchronized void fullfillOrder()
  {
    while(orderQueue.isEmpty() && !status)
    {
      try
      {
        wait();
      }catch(InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    if(!orderQueue.isEmpty()) {
      System.out.println(" Order fullfilled : " + orderQueue.getFirst());
      orderQueue.removeFirst();
      notifyAll();

    }
  }

  public static void addInventoryItems(Shoe shoe, Long quantity)
  {
    if(!products.containsKey(shoe))
    {
      products.put(shoe, quantity);
    }
    else {
      products.merge(shoe, quantity, (k, v) -> v + quantity);
    }
  }

}
