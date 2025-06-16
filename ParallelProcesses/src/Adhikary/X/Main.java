package Adhikary.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

	public static void main(String... args) throws Exception
	{
		int numbersLength = 100_000;
		long[] numbers =  new Random().longs(numbersLength,1,
				numbersLength)
				.toArray();

		long sum = Arrays.stream(numbers)
				.reduce(0L,(a,b)->a+b);
		System.out.println(sum);


		ForkJoinPool threadPool =(ForkJoinPool) Executors.newWorkStealingPool(4);
		List<Callable<Long>> tasks = new ArrayList<>();

		int taskNo = 10 ;

		int splitCount = numbersLength / taskNo;

		for( int i = 0 ; i < taskNo ; i++)
		{
			int start = i * splitCount ;
			int end = start + splitCount;
			tasks.add(()->{
				long tasksum = 0;
				for(int j = start ; j < end ; j++)
				{
					tasksum += numbers[j];
				}
				return tasksum;
			});
		}

		List<Future<Long>> futures = threadPool.invokeAll(tasks);

		System.out.println("Parallelism = " + threadPool.getParallelism());
		System.out.println("Pool size = " + threadPool.getPoolSize());
		System.out.println("Steal count = " + threadPool.getStealCount());

		long tasksum = 0;

		for(Future<Long> future : futures)
		{
			tasksum += future.get();
		}

		System.out.println("Thread Pool Sum = " + tasksum);
		threadPool.shutdown();

		System.out.println(threadPool.getClass().getName());

	}


}
