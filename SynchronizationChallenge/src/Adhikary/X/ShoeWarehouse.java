package Adhikary.X;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShoeWarehouse {


	private List<Order> shippingItems;

	public final static String[] PRODUCT_LIST = {"Running Shoes", "Sandals", "Boots", "Slippers", "High Tops"};

	public ShoeWarehouse() {

		this.shippingItems = new LinkedList<Order>(); /* This is more efficient in this case than ArrayList because ,
		we will do fifo operations so even though linkedLists need to traverse for retrieval  making the time complexity o(n)
		,here we will always retrieve the first element making the time complexity o(1) , and since adding removing is also constant time because
		of LinkedLists only need to update their links which is almost instant compared to arrayLists's shifting , LinkedList in this special case is
		a better choice */

	}

	public synchronized void receiveOrder(Order item) {

		while (this.shippingItems.size() > 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		shippingItems.add(item);
		System.out.println("Incoming: " + item);
		notifyAll();


	}

	public synchronized Order fulfillOrder()
	{

		while(shippingItems.isEmpty())
		{
			try
			{
				wait();
			}catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}




		}

		Order item = shippingItems.remove(0);
		System.out.println(Thread.currentThread().getName() + "Fulfilled: " + item);
		notifyAll();
		return item;


	}





}
