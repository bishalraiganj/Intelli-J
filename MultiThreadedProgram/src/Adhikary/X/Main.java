package Adhikary.X;

import java.util.concurrent.TimeUnit;

public class Main {


	 static class  MyThread extends Thread{
		@Override
		public void run()
		{
			int evenCount = 0;
			for(int i = 1 ; evenCount<5 ; i++ ) {
				if (i % 2 == 0) {
					System.out.print(" "+ i + " ");
					evenCount++;
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}

			}


		}


	}
	public static void main(String... args)
	{

		Thread myThread = new MyThread();
		Thread threadTwo = new Thread(()->{

			int oddCount = 0;
			for(int i = 1 ; oddCount < 5 ; i++)
			{
				if( i % 2 != 0)
				{
					System.out.print(" " + i + " ");
					oddCount++;
					try {
						TimeUnit.MILLISECONDS.sleep(400);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}

				}
			}

		});

		Thread threadThree = new Thread(new Thread() {

			@Override
			public void run()
			{
				int primeCount = 0;

				for(int i = 3 ; primeCount < 500 ; i += 2)
				{
					if(i % 2 != 0 && i % 3 != 0)
					{
						boolean forLoopBreakFlag = false;
						for(int j = 3 ; j <= Math.abs(Math.sqrt(i)) ; j += 2)
						{
							if(i % j == 0)
							{
								forLoopBreakFlag = true;
								break;

							}

						}
						if(!forLoopBreakFlag)
						{
							System.out.print(" " + i + " ");
							primeCount++;
								try {
									Thread.sleep(1000);
								}catch(InterruptedException e)
								{
									e.printStackTrace();
								}
						}

					}
				}

			}
		});

//		myThread.start();
//		threadTwo.start();
		threadThree.start();








	}



}
