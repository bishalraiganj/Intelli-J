package Adhikary.X;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {

	public static void main(String... args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(
				FormatStyle.MEDIUM,
				FormatStyle.LONG
		);

		Callable<ZonedDateTime> waitThenDoIt = () ->
		{
			ZonedDateTime zdt = null;
			try {
				TimeUnit.SECONDS.sleep(2);
				zdt = ZonedDateTime.now();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return zdt;
		};


		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		List<Callable<ZonedDateTime>> list = Collections.nCopies(4, waitThenDoIt);

		try {
			System.out.println("---> " + ZonedDateTime.now().format(dtf));
			List<Future<ZonedDateTime>> futureList = threadPool.invokeAll(list);
			for (Future<ZonedDateTime> result : futureList) {
				try {
					System.out.println(result.get(1, TimeUnit.SECONDS).format(dtf));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			threadPool.shutdown();
		}

		System.out.println("---> " + ZonedDateTime.now().format(dtf));
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);


		ScheduledFuture<?> scheduledTask = 	executor.scheduleWithFixedDelay(() ->
			{
				System.out.println(Thread.currentThread().getName()+" :task2: " +ZonedDateTime.now().format(dtf));


			}, 2,2 , TimeUnit.SECONDS);

		long time = System.currentTimeMillis();

		while(!scheduledTask.isDone())
		{
			try
			{
				Thread.sleep(2000);
				if((System.currentTimeMillis()- time  )/ 1000  > 10)
				{
					scheduledTask.cancel(true);
				}
			}catch(InterruptedException e)
			{
				throw new RuntimeException(e);
			}

		}

		executor.shutdown();

	}
}
