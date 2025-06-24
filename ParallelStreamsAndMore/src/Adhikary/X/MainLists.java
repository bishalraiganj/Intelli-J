package Adhikary.X;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;

public class MainLists {

	public static void main(String... args)
	{
		Map<String, Long>  threadMap = new ConcurrentSkipListMap<>();
   		Person[] persons  = Stream.generate(()->new Person())
				.parallel()
				.limit(10000)
				.peek((person)->
				{
					String threadName = Thread.currentThread().getName()
							.replace("ForkJoinPool.commonPool-worker-",
									"thread_");
					threadMap.merge(threadName,1L, (a,b)->Long.sum( a , b ));
				})
				.toArray((size)->{
					return new Person[size];
				});

		System.out.println("Total = " + persons.length);

		System.out.println(threadMap);

		long total = 0 ;

		for(long count : threadMap.values())
		{
			total += count;
		}

		System.out.println("ThreadCounts = " + total ); // ThreadCounts is not the number of threads it is the total number of person records processed by all threads


	}



}
