package Adhikary.X;

public class Main {

	public static void main(String... args)
	{
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getClass().getName());

		System.out.println(currentThread);
		System.out.println(":".repeat(50));

		printThreadState(currentThread);

		System.out.println("-".repeat(50));

		currentThread.setName("MainGuy");
		currentThread.setPriority(Thread.MAX_PRIORITY);
		printThreadState(currentThread);





	}

	public static void printThreadState(Thread thread)
	{
		System.out.println("-".repeat(50));
		System.out.println("Thread ID: " + thread.getId() );
		System.out.println("Thread Name: " + thread.getName());
		System.out.println("Thread Priority: " + thread.getPriority());
		System.out.println("Thread State: " + thread.getState());
		System.out.println("Thread Group: " + thread.getThreadGroup());
		System.out.println("Thread is Alive: " + thread.isAlive());
		System.out.println("-".repeat(50));
		System.out.println();
	}

}
