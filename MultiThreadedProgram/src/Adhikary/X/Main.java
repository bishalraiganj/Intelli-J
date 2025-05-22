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



		/*
		threadThree (Thread instance) prints primeNumbers it's prime logic is optimized by only checking odd numbers that are not multiples of 2 and 3
		and so the numbers are also checked for divisibility only against odd numbers that are also not 2 and 3's multiples
		because we already know i's in the for loop are not so we dont have to check i's divisibility also by 2 and 3's multiples
		but only by odd numbers that are not 2 and 3's multiples "
		 */
		Thread threadThree = new Thread(new Thread() {

			@Override
			public void run()
			{
				int primeCount = 0;

				for(int i = 3 ; primeCount < 500 ; i += 2)
				{
					if(i % 2 != 0 && i % 3 != 0) // This condition is unnecessary since we are already checking only odd numbers that are not multiples of either 2 and 3
					{
						boolean forLoopBreakFlag = false;
						for(int j = 3 ; j <= Math.abs(Math.sqrt(i)) ; j += 2) // Here , we are only checking divisibility only by odd numbers that are not multiples of 2 and 3 for further optimization
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
