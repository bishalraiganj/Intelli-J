package Adhikary.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


class RecursiveSumTask extends RecursiveTask<Long> {


	private final long[] numbers;

	private final int start;

	private final int end;

	private final int divison;

	public RecursiveSumTask(long[] numbers, int start , int end , int division)
	{
		this.numbers = numbers;
		this.start  = start;
		this.end = end;
		this.divison = division;

	}
	@Override
	protected Long compute()
	{
		if((end - start )  <= ( numbers.length / divison ) )
		{

			System.out.println(start + " : " + end);
			long sum = 0 ;
			for(int i = start ; i < end ; i++)
			{
				sum += numbers[i];
			}
			return sum;
		}
		else {
			int mid = ( start + end ) / 2 ;
			RecursiveSumTask left = new RecursiveSumTask(numbers,start,mid,divison);
			RecursiveSumTask right = new RecursiveSumTask(numbers,mid,end,divison);
			left.fork();
			right.fork();
			return left.join() + right.join();
		}
	}
}

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


		ForkJoinPool threadPool = ForkJoinPool.commonPool();
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

		System.out.println("CPU's : " + Runtime.getRuntime().availableProcessors());
		System.out.println("Parallelism = " + threadPool.getParallelism());
		System.out.println("Pool size = " + threadPool.getPoolSize());
		System.out.println("Steal count = " + threadPool.getStealCount());

		long tasksum = 0;

		for(Future<Long> future : futures)
		{
			tasksum += future.get();
		}

		System.out.println("Thread Pool Sum = " + tasksum);

		RecursiveTask<Long> task = new RecursiveSumTask(numbers,0,numbersLength,8);
		long forkJoinSum = threadPool.invoke(task);
		System.out.println("Recursive sum is: " + forkJoinSum);
		threadPool.shutdown();

		System.out.println(threadPool.getClass().getName());

	}


}
