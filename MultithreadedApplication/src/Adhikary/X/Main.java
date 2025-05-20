package Adhikary.X;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String... args)
	{
		class EvenThread extends Thread
		{
			@Override
			public void run()
			{
				System.out.println("Even Thread Started: ");
				int evenCount = 0;
				for(int i = 1;evenCount<5 ; i++ )
				{
					if(i % 2 == 0)
					{
						System.out.print(i + " ");
						try {
							TimeUnit.MILLISECONDS.sleep(1000);
						}catch(InterruptedException e)
						{
							e.printStackTrace();
						}

						evenCount++;
					}
				}
			}
		}

		Thread oddThread = new Thread(()->
		{

			System.out.println("oddThread Started: ");
			int oddCount = 0 ;
			for(int i = 1; oddCount<5 ; i++)
			{
				if(i % 2 != 0 )
				{
					System.out.print(i + " ");
					try
					{
						TimeUnit.MILLISECONDS.sleep(1000);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					oddCount++;
				}
			}

		});

		Thread evenThreadInstance = new EvenThread();
		evenThreadInstance.start();
		oddThread.start();
		while(evenThreadInstance.isAlive())
		{
			System.out.print(" . ");
			try {
				Thread.currentThread().sleep(500);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}




	}

}
