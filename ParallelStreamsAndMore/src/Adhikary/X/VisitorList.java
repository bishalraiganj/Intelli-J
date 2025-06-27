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
				.distinct()
				.collect(()->new CopyOnWriteArrayList<Person>()
				,(CopyOnWriteArrayList<Person> a,Person e)-> a.add(e),(c,d)->c.addAll(d));

	}
	public static void main(String... args)
	{

		Runnable producer = ()-> {
			Person visitor = new Person();
			System.out.println("Adding " + visitor);
			boolean  queued = false;
			try {
				queued =  newVisitors.offer(visitor,5,TimeUnit.SECONDS);
			}catch(InterruptedException e)
			{
				System.out.println("Interrupted Exception ! ");
			}
			if( queued)
			{
				System.out.println( newVisitors);
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
			Person visitor  = newVisitors.poll();
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
		producerExecutor.scheduleWithFixedDelay(producer,0,1, TimeUnit.SECONDS);

		while(true)
		{
			try
			{
				if(!producerExecutor.awaitTermination(20,TimeUnit.SECONDS))
				{
					break;
				}
			}catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}

		}

		producerExecutor.shutdown();

	}

}
