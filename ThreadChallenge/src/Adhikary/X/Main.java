package Adhikary.X;

public class Main
{

	static class OddThread extends Thread
	{


		@Override
		public void run()
		{
			for(int i = 1 ; i <= 10 ; i+=2)
			{
				System.out.println("OddThread: " + i);
				try
				{
					Thread.sleep(1000);


				}catch(InterruptedException e)
				{
					System.out.println("OddThread interrupted !");
					break;
				}

			}
		}
	}

	static class EvenRunnable implements Runnable {

		@Override
		public void run()
		{
			for(int i = 2 ; i <= 10 ; i+=2 )
			{
				System.out.println("EvenRunnable: " + i);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e)
				{
					System.out.println("EvenRunnable interrupted !");
				}
			}


		}


	}
	public static void main(String... args)
	{

		OddThread oddThread =  new OddThread();
//		Thread evenThread = new Thread(new EvenRunnable());

		Runnable runnable = ()-> {
			for(int i = 2 ; i <= 10 ; i += 2)
			{
				System.out.println( " EvenRunnable: " + i);
				try
				{
					Thread.sleep(1000);
				}catch(InterruptedException e)
				{
					System.out.println("EvenRunnable interrupted !");
					break;
				}
			}

		};

		Thread evenThread = new Thread(runnable);
		oddThread.start();
		evenThread.start();

		try
		{

			Thread.sleep(2000);

		}catch(InterruptedException e)
		{
			System.out.println("Main thread interrupted");
		}

		oddThread.interrupt();







	}


}
