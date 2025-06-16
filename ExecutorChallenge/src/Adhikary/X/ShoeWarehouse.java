package Adhikary.X;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoeWarehouse {


	private List<Order> shippingItems;

	private final ExecutorService fulfillmentService;

	public final static String[] PRODUCT_LIST = {"Running Shoes", "Sandals", "Boots", "Slippers", "High Tops"};

	public ShoeWarehouse() {

		this.shippingItems = new LinkedList<Order>(); /* This is more efficient in this case than ArrayList because ,
		we will do fifo operations so even though linkedLists need to traverse for retrieval  making the time complexity o(n)
		,here we will always retrieve the first element making the time complexity o(1) , and since adding removing is also constant time because
		of LinkedLists only need to update their links which is almost instant compared to arrayLists's shifting , LinkedList in this special case is
		a better choice */

		this.fulfillmentService = Executors.newFixedThreadPool(3);

	}

	public void shutDown()
	{
		fulfillmentService.shutdown();
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
		System.out.println(Thread.currentThread().getName()+" Incoming: " + item);
		fulfillmentService.submit(()->{
			this.fulfillOrder();
		});
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
		System.out.println(Thread.currentThread().getName() + " Fulfilled: " + item);
		notifyAll();
		return item;


	}





}
