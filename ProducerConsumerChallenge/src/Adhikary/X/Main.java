package Adhikary.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String... args)
	{

		ShoeWarehouse.addInventoryItems(Shoe.SANDAL,3000L);
		ShoeWarehouse.addInventoryItems(Shoe.BOOTS,6000L);
		ShoeWarehouse.addInventoryItems(Shoe.LOAFER,3000L);
		ShoeWarehouse.addInventoryItems(Shoe.SNEAKER,2000L);

		Order sandalOrd1 = new Order(1L,Shoe.SANDAL,100);
		Order sandalOrd2 = new Order(2L,Shoe.SANDAL,500);
		Order sandalOrd3 = new Order(3L,Shoe.SANDAL,5000);

		Order loaferOrd1 = new Order(4L,Shoe.LOAFER,200);
		Order loaferOrd2 = new Order(5L,Shoe.LOAFER,40000);

		List<Order> ordersList = new ArrayList<>(Arrays.asList(sandalOrd1,sandalOrd2,sandalOrd3,loaferOrd1,loaferOrd2));

		Random r = new Random();



		Shoe[] enumArr = Shoe.values();
		int num = r.nextInt(1,3);
		int i = 1;
		int totalOrders = 5 + num ;

		while(i <= num)
		{
			int ordinalValue = r.nextInt(0,4);
			int quantity = r.nextInt(100,6000);
			ordersList.add(new Order(i+5L,enumArr[ordinalValue],quantity));
			i++;
		}


		ordersList.forEach(System.out::println);

		System.out.println(" \n\n Number of Orders in ordersList field = "  + ordersList.size());


		System.out.println("-".repeat(50));

		ShoeWarehouse bishalStore = new ShoeWarehouse();




		Thread orderAdder = new Thread(()->{



			for(Order order : ordersList)
			{
				bishalStore.receiveOrder(order);

				try {
					Thread.sleep(new Random().nextInt(1500,2000));
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}


			bishalStore.setStatus();
			System.out.println("Order adder Completed ");


		});


		Thread orderProcessor = new Thread(()->
		{

			while(!bishalStore.getStatus()) {
				bishalStore.fullfillOrder();
				try {
					Thread.sleep(new Random().nextInt(500,2000));
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			System.out.println(" All %d Orders finished :-) ".formatted(totalOrders) );
		});

		orderAdder.start();
		orderProcessor.start();






	}

}
