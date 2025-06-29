package Adhikary.X;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class VisitorList {

	private static final ArrayBlockingQueue<Person> newVisitors = new ArrayBlockingQueue<>(5);

	private static final CopyOnWriteArrayList<Person> masterList;

	static
	{

		masterList = Stream.generate(()->{
			return new Person();
		})
				.limit(2500)
				.distinct()
				.collect(()->new CopyOnWriteArrayList<>()
				,(CopyOnWriteArrayList<Person> a,Person e)-> a.add(e),(c,d)->c.addAll(d));

	}
	public static void main(String... args)
	{

		Runnable producer = ()-> {
			Person visitor = new Person();
			System.out.println("Queueing " + visitor);
			boolean  queued = false;
			try {
				queued =  newVisitors.offer(visitor,5,TimeUnit.SECONDS);
			}catch(InterruptedException e)
			{
				System.out.println("Interrupted Exception ! ");
			}
			if( queued)
			{
//				System.out.println( newVisitors);
			}
			else {
				System.out.println("Queue is Full, cannot add " + visitor);
				System.out.println("Draining Queue and writing data to file");
				List<Person>  tempList = new ArrayList<>();
				newVisitors.drainTo(tempList);
				List<String> lines = new ArrayList<>();
				tempList.forEach((person)->lines.add(person.toString()));
				lines.add(visitor.toString());

				if(!Files.exists(Path.of("DrainedQueue.txt")))
				{
					try {
						Files.createFile(Path.of("DrainedQueue.txt"));

					}catch(IOException e)
					{
						throw new RuntimeException(e);
					}
				}
				try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(Path.of("DrainedQueue.txt").toFile(),true)))
				{

					for(String line : lines) {
						bos.write((line+"\n").getBytes(StandardCharsets.UTF_8));
					}



				}catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}

			}
		};



		Runnable consumer = ()->{

			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " Polling queue " + newVisitors.size());
			Person visitor = null;
			try {
				visitor = newVisitors.take();
			}catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}
			if(visitor != null )
			{
				System.out.println(threadName + " " + visitor);
				if(!masterList.contains(visitor))
				{
					masterList.add(visitor);
					System.out.println("--> New Visitor gets Coupon!: " + visitor);
				}
			}
			System.out.println(threadName + " done  " + newVisitors.size());

		};



		ScheduledExecutorService producerExecutor = Executors.newSingleThreadScheduledExecutor();
		producerExecutor.scheduleWithFixedDelay(producer,0,3, TimeUnit.SECONDS);



		ScheduledExecutorService consumerPool = Executors.newScheduledThreadPool(3);
		for(int i = 0 ; i < 3 ; i++)
		{
			consumerPool.scheduleAtFixedRate(consumer,6,1,TimeUnit.SECONDS);
		}




		while(true)
		{
			try
			{
				if(!producerExecutor.awaitTermination(10,TimeUnit.SECONDS))
				{
					break;
				}
			}catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}

		}

		producerExecutor.shutdown();


		while(true)
		{
			try {
				if (!consumerPool.awaitTermination(3, TimeUnit.SECONDS))
				{
					break;
				}
			} catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}


		}

		consumerPool.shutdown();





	}








}
