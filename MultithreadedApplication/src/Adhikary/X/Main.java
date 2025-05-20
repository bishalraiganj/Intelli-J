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
				int numCount = 0;
				for(int i = 0;numCount<=5 ; i++ )
				{
					if(i % 2 == 0)
					{
						System.out.print(i);
						try {
							TimeUnit.MILLISECONDS.sleep(1000);
						}catch(InterruptedException e)
						{
							e.printStackTrace();
						}

						numCount++;
					}
				}
			}
		}

		Thread evenThreadInstance = new EvenThread();
		evenThreadInstance.start();
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
