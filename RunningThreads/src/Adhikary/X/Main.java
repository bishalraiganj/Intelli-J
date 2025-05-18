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
				}catch(InterruptedException e)
				{
					System.out.println("\nWhoops!!" + tName + " interrupted");
					return;
				}
			}
			System.out.println("\n" + tName + "  thread execution completed");

		});

		System.out.println(thread.getName() + " thread starting");
		thread.start();

		System.out.println("Main thread would continue here");

		try
		{
			Thread.sleep(2000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		thread.interrupt();

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
