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

				for(int i = 3 ; primeCount < 500 ; i += 2) // This condition completely eliminates possibilities of multiples of 2 and some multiples of 3 but not all multiples of 3
				{
					if(i % 2 != 0 && i % 3 != 0) // Completely eliminating possibilites of numbers being multiples of 2 and 3
					{
						boolean forLoopBreakFlag = false;
						for(int j = 5 ; j <= Math.abs(Math.sqrt(i)) ; j += 6) // Since we are only left with numbers of the form 6k+5 and 6k+1 , these are not divisible by both 2 and 3
							// so we will only check their divisibility by numbers of the form 6k + 1 and 6k + 5
						{
							if(i % j == 0 || i % (j+2) == 0)
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

		Thread threadFour = new Thread(new Thread() {


			@Override
			public void run()
			{
				int primeCount = 0;

				for(int i =5 ; primeCount < 5 ; i +=6)
				{
					boolean forLoopBreakFlag = false;
					int oneForm = i + 2;

					for(int j = 5 ; j <= Math.sqrt(i) ; j += 6)
					{
						if( i % j == 0 || i % (j+2) == 0)
						{
							forLoopBreakFlag = true;
							break;
						}
					}
					if(!forLoopBreakFlag)
					{
						System.out.print(" " + i + " ");
						primeCount++;
					}
					boolean forLoopBreakFlag2 = false;

					for(int k = 5 ; k <= Math.sqrt(oneForm) ; k  += 6)
					{
						if(oneForm % k == 0 || oneForm % (k+2) == 0)
						{
							forLoopBreakFlag2 = true;
							break;
						}
					}
					if(!forLoopBreakFlag2)
					{
						System.out.print(" " +  oneForm + " ");
						primeCount++;
					}

				}


			}
		});

//		myThread.start();
//		threadTwo.start();
//		threadThree.start();

		threadFour.start();







	}



}
