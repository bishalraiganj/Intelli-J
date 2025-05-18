package Adhikary.X;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String... args)
	{
		System.out.println("Main thread running");
		try {
			System.out.println("Main thread paused for one second");
			Thread.sleep(1000);
		} catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		Thread thread = new Thread(()-> {

			String tName = Thread.currentThread().getName();
			System.out.println(tName + " should take 10 dots to run." );
			for(int i = 0 ; i < 10 ; i++)
			{
				System.out.print(". ");
				try{
					Thread.sleep(500);
					System.out.println("A.State = " + Thread.currentThread().getState());
				}catch(InterruptedException e)
				{
					System.out.println("\nWhoops!!" + tName + " interrupted");
					System.out.println("A1.State =  " + Thread.currentThread().getState());
					return;
				}
			}
			System.out.println("\n" + tName + "  thread execution completed");

		});

		System.out.println(thread.getName() + " thread starting");
		thread.start();

		long now = System.currentTimeMillis();

		while(thread.isAlive())
		{
			System.out.println("\nwaiting for my custom thread to complete");
			try
			{
				Thread.sleep(1000);
				System.out.println("B.State = " + thread.getState());

				if(System.currentTimeMillis() - now > 2000)
				{
					thread.interrupt();
				}
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}


		System.out.println("C.State = " + thread.getState());



//		System.out.println("Main thread would continue here");

//		try
//		{
//			Thread.sleep(2000);
//		}catch(InterruptedException e)
//		{
//			e.printStackTrace();
//		}
//		thread.interrupt();

//		while(thread.isAlive())
//		{
//			System.out.print(" M ");
//			try {
//				TimeUnit.MILLISECONDS.sleep(300);
//			}catch(InterruptedException e)
//			{
//				System.out.println("Main thread interrupted");
//			}
//		}
//		if(!thread.isAlive())
//		{
//			System.out.println(thread.getName() + " thread stopped" + " so stopping Main thread also :-)" );
//		}


	}

}
