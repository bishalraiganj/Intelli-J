package Adhikary.X;

import java.util.concurrent.*;


class ColorThreadFactory implements ThreadFactory
{

	private String threadName;
	private int colorValue = 1;

	public ColorThreadFactory(ThreadColor color)
	{
		this.threadName = color.name();
	}

	public ColorThreadFactory()
	{

	}


	@Override
	public Thread newThread(Runnable r)
	{
		Thread thread = new Thread(r);
		String name = threadName;
		if(name == null)
		{
			name = ThreadColor.values()[colorValue].name();
		}
		if(++colorValue > (ThreadColor.values().length - 1))
		{
			colorValue = 1;
		}
		thread.setName(name);
		return thread;
	}
}
public class Main {

	public static void main(String... args)
	{

		ExecutorService multiExecutor = Executors.newCachedThreadPool();


			 var redValue =  multiExecutor.submit(()-> Main.sum( 1,10,1,"red" ) );


			var blueValue =  multiExecutor.submit(()-> Main.sum(10,100,10,"blue") );
			var greenValue = multiExecutor.submit(()-> Main.sum(2,20,2,"green"));
//			multiExecutor.execute(()->{
//				Main.sum(1,10,1,"yellow");
//			});
//			multiExecutor.execute(()->{
//				Main.sum(10,100,10,"cyan");
//			});
//			multiExecutor.execute(()->{
//				Main.sum(2,20,2,"purple");
//			});
//
//			try
//			{
//				TimeUnit.SECONDS.sleep(1);
//			}catch(InterruptedException e)
//			{
//				throw new RuntimeException(e);
//			}
//
//			System.out.println("    Next Tasks Will get executed     ");
//			for(String color : new String[] {"red","blue","green","yellow","purple","cyan"
//			,"black"})
//			{
//				multiExecutor.execute(()->{
//					Main.sum(1,10,1,color);
//				});
//			}
		try
		{
			System.out.println(redValue.get(500,TimeUnit.SECONDS));
			System.out.println(blueValue.get(500,TimeUnit.SECONDS));
			System.out.println(greenValue.get(500,TimeUnit.SECONDS));
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}

		finally {
			multiExecutor.shutdown();
	}







	}


	public static void  fixedmain(String... args)
	{
		int count = 6;
		ExecutorService multiExecutor = Executors.newFixedThreadPool(
				3,new ColorThreadFactory()
		);

		for(int i = 0 ; i < count ; i++)
		{
			multiExecutor.execute(()->
			{
				Main.countDown();
			});
		}


		multiExecutor.shutdown();





	}


	public static void singlemain(String... args)
	{

		ExecutorService blueExecutor = Executors.newSingleThreadExecutor(
				new ColorThreadFactory(ThreadColor.ANSI_BLUE));

		blueExecutor.execute(()->{

			Main.countDown();
		});
		blueExecutor.shutdown();


		boolean isDone = false;
		try {
			isDone = blueExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		if(isDone)
		{
			System.out.println("Blue finished, starting Yellow");

		}

		ExecutorService yellowExecutor = Executors.newSingleThreadExecutor(

				new ColorThreadFactory(ThreadColor.ANSI_YELLOW));
		yellowExecutor.execute(()->
		{
			Main.countDown();
		});
		yellowExecutor.shutdown();
		try {
			isDone = yellowExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}

		if(isDone)
		{
			System.out.println("Yellow finished, starting Red");
		}



		ExecutorService redExecutor = Executors.newSingleThreadExecutor(
				new ColorThreadFactory(ThreadColor.ANSI_RED)
		);
		redExecutor.execute(()->{
			Main.countDown();
		});
		redExecutor.shutdown();

		try
		{
			isDone = redExecutor.awaitTermination(500,TimeUnit.MILLISECONDS);

		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}

		if(isDone)
		{
			System.out.println("Red finished, and with it , All processes have finished ! :-) ");
		}




	}
	public static void nomain(String... args) {


		Thread blue = new Thread(()-> {

			Main.countDown();
		},ThreadColor.ANSI_BLUE.name());

		Thread yellow = new Thread(()->
		{
			Main.countDown();
		},ThreadColor.ANSI_YELLOW.name());



		Thread red = new Thread(()-> {
			Main.countDown();

		},"ANSI_RED");

		blue.start();
		try
		{
			blue.join();
		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}

		yellow.start();
		try
		{
			yellow.join();

		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		red.start();
		try
		{
			red.join();
		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}







	}




	private static void countDown() {
		String threadName = Thread.currentThread().getName();

		ThreadColor threadColor = ThreadColor.ANSI_RESET;

		try {
			threadColor = ThreadColor.valueOf(threadName.toUpperCase());
		} catch (IllegalArgumentException ignore) {
			//User may pass a bad color name, Will just ignore this.
		}
		String color = threadColor.color();
		for( int i = 20 ; i > 0 ; i--)
		{
			System.out.println(color + "" +
					threadName.replace("ANSI_","") + " " + i);


		}

	}

	private static int sum(int start, int end , int delta,  String colorString)
	{
		ThreadColor threadColor = ThreadColor.ANSI_RESET;

		try
		{
			threadColor = ThreadColor.valueOf("ANSI_" +
					colorString.toUpperCase());
		}catch(IllegalArgumentException e)
		{
			//User may pass a bad color name, Will just ignore this error .
		}

		String color = threadColor.color();
		int sum = 0;

		for(int i = start ; i <= end ; i += delta)
		{
			sum += i;
		}

		System.out.println(color + Thread.currentThread().getName() +
				", " + colorString + " " + sum);


		return sum;
	}


}



