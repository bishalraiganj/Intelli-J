package Adhikary.X;

import java.util.*;

public class ShoeWarehouse {

  public static Map<Shoe, Long> products = new TreeMap<>();

  private List<Order> orderQueue = new LinkedList<>();

  private static int MAX_CAPACITY = 200;

  public synchronized void receiveOrder(Order order)
  {


  while(orderQueue.size() >= MAX_CAPACITY)
  {


    try {
      wait();
    }catch(InterruptedException e)
    {
      e.printStackTrace();
    }

  }
  if( orderQueue.size() < MAX_CAPACITY
          && products.get(order.shoeType()) >= order.quantity() )

  {
    orderQueue.add(order);
    long shoeCount = products.get(order.shoeType());
    products.put(order.shoeType(), shoeCount - order.quantity());
    System.out.println("Added to orderQueue : " + order);
  }
  else
  {
    if(products.get(order.shoeType()) < order.quantity())
    {
      System.out.println("Not enough products in stock : Available -> " + products.get(order.shoeType()) + " Requested -> " + order.quantity());
    }
    else if(orderQueue.size() > MAX_CAPACITY)
    {
      System.out.println("Cannot add more Orders , Warehouse capacity reached");
    }
  }
  notifyAll();


  }

  public void fullfillOrder(Order order)
  {
    while(orderQueue.isEmpty())
    {
      try
      {
        wait();
      }catch(InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    orderQueue.removeFirst();
    System.out.println(" Order fullfilled : " + order);
    notifyAll();



  }

  public static void addInventoryItems(Shoe shoe, Long quantity)
  {
    products.merge(shoe, 0L,(k,v)-> v + quantity);
  }

}
